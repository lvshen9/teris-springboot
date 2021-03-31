package com.lvshen.teris;

import com.lvshen.teris.control.GameControl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author lvshen
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TerisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TerisApplication.class, args);
        init();
        new GameControl();
    }

    public static void init() {
        System.setProperty("java.awt.headless", "false");
    }

}
