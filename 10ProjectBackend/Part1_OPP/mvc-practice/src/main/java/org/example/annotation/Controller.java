package org.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE}) // TYPE (클래스, 인터페이스, 이넘 등)에만 적용 가능
@Retention(RetentionPolicy.RUNTIME) // 유지 기간을 RUNTIME으로 설정
public @interface Controller {
}
