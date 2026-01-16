package org.example.xindcodespring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("org.example.xindcodespring.mapper")

public class XindCodeSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(XindCodeSpringApplication.class, args);
    }

}
