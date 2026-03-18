package ru.ssau.labs.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ru.ssau.labs.spring.service"})
public class AppConfig {
}
