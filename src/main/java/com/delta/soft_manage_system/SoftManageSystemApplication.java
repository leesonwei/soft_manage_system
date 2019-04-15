package com.delta.soft_manage_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {"com.delta.soft_manage_system.*","com.delta.auth.*"})
@MapperScan(basePackages = {"com.delta.soft_manage_system.dao","com.delta.auth.dao"})
@EnableTransactionManagement
public class SoftManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftManageSystemApplication.class, args);
    }

}
