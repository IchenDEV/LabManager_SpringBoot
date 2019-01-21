package com.idevlab.LabMgr.Config.Cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/login/**")
            .allowedOrigins("http://localhost:8000")
            .allowedMethods("POST", "GET","OPTIONS")
            .allowedHeaders("content-type")
            .exposedHeaders("content-type")
            .allowCredentials(true).maxAge(3600);
    }
}
