package org.example;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServerLauncher {
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationServerLauncher.class);

    public static void main(String[] args) throws Exception {
//        내장 톰켓
        String webappDirLocation = "10ProjectBackend/Part1_OPP/servlet/src/main/webapps/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9000);

        tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
        logger.info("configuring app with basedir: {}", new File("./" + webappDirLocation).getAbsolutePath());



        tomcat.start();
        tomcat.getServer().await();
    }
}
