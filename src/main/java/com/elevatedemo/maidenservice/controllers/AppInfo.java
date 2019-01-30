package com.elevatedemo.maidenservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class AppInfo {

    public String getName() {
        return name;
    }

    @Value("${spring.application.name}")
    private String name;
}
