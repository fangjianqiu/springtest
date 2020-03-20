package com.richstonedt.rs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * <b><code>SdlApp</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/12/19 20:59.
 *
 * @author Li Shangzhe
 * @since czps2s4ada-sdl-be 0.1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.richstonedt.cs.mapper")
@ComponentScan(basePackages = {"com.richstonedt.cs.mapper","com.richstonedt.cs.service","com.richstonedt.cs.service.serviceImpl","com.richstonedt.rs.Controller"})
public class Spring {

    public static void main(String[] args) {
        SpringApplication.run(Spring.class, args);
    }
}