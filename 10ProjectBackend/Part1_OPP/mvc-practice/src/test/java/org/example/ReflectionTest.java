package org.example;

import org.example.Model.User;
import org.example.annotation.Controller;
import org.example.annotation.Service;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Controller 애노테이션이 설정돼 있는 모든 클래스를 찾아서 출력
 */
public class ReflectionTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectionTest.class);

    @Test
    void controllerScan() {
        Set<Class<?>> beans = getTypesAnnotatedWith(List.of(Controller.class, Service.class));

        logger.debug("beans: [{}]", beans);
    }

    @Test
    void showClass() {
        Class<User> clazz = User.class;
        logger.debug(clazz.getName());

//        객체의 필드 정보 출력
        logger.debug("User all declared fields: [{}]", Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toList()));
//        객체의 생성자 정보 출력
        logger.debug("User all declared constructors: [{}]", Arrays.stream(clazz.getDeclaredConstructors()).collect(Collectors.toList()));
//        객체의 메서드 정보 출력
        logger.debug("User all declared methods: [{}]", Arrays.stream(clazz.getDeclaredMethods()).collect(Collectors.toList()));
    }

//    힙 영역에 있는 클래스 정보를 로드하는 방법
    @Test
    void load() throws ClassNotFoundException {
//        1
        Class<User> clazz = User.class;

//        2
        User user = new User("serverwizard", "홍종완");
        Class<? extends User> clazz2 = user.getClass();

//        3
        Class<?> clazz3 = Class.forName("org.example.Model.User");

        logger.debug("clazz: [{}]", clazz);
        logger.debug("clazz2: [{}]", clazz2);
        logger.debug("clazz3: [{}]", clazz3);
    }

    private static Set<Class<?>> getTypesAnnotatedWith(List<Class<? extends Annotation>> annotations) {
        Reflections reflections = new Reflections("org.example");

        Set<Class<?>> beans = new HashSet<>();
        annotations.forEach(annotation -> beans.addAll(reflections.getTypesAnnotatedWith(annotation)));
//        beans.addAll(reflections.getTypesAnnotatedWith(Controller.class)); // @Controller 애노테이션이 설정돼 있는 클래스 찾기
//        beans.addAll(reflections.getTypesAnnotatedWith(Service.class));  // @Service 애노테이션이 설정돼 있는 클래스 찾기
        return beans;
    }
}
