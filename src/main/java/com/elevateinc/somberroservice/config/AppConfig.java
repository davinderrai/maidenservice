package com.elevateinc.somberroservice.config;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Getter
    @Value(value = "${spring.application.name}")
    private String name;
}
