package com.delta.soft_manage_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.delta.soft_manage_system.dao")
public class SoftManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftManageSystemApplication.class, args);
    }

}
