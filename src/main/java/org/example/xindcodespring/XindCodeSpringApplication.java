package org.example.xindcodespring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.xindcodespring.mapper")
public class XindCodeSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(XindCodeSpringApplication.class, args);
    }

}
