package com.richstonedt.rs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@MapperScan(basePackages = "com.richstonedt.cs.mapper")
@ComponentScan(basePackages = {"com.richstonedt.cs.mapper","com.richstonedt.cs.service","com.richstonedt.cs.service.serviceImpl","com.richstonedt.rs"})
public class Spring {

    public static void main(String[] args) {

        SpringApplication.run(Spring.class, args);
    }
}