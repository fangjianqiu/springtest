package com.richstonedt.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b><code>MybatisPlusConfig</code></b>
 * <p/>
 * 分页器
 * <p/>
 * <b>Creation Time:</b> 2019/11/21 15:43.
 *
 * @author Li Shangzhe
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
