package com.idevlab.LabMgr.Config.Cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//用于跨域
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("https://next.stoplight.io")
            .allowedOrigins("http://localhost:8000")//允许本地8000端口跨域请求
            .allowedMethods("POST", "GET","OPTIONS")//允许POST GET OPTIONS 跨域
            .allowedHeaders("content-type")//允许content-type 跨域
            .exposedHeaders("content-type")//允许content-type 跨域
            .allowCredentials(true).maxAge(3600);//允许跨域cookie
    }
}
