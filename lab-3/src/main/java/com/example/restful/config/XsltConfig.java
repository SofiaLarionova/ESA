package com.example.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

@Configuration
public class XsltConfig {

    @Bean
    public XsltViewResolver xsltViewResolver() {
        XsltViewResolver resolver = new XsltViewResolver();
        resolver.setOrder(1); // Приоритет ViewResolver
        resolver.setPrefix("classpath:/templates/"); // Путь к вашим XSLT-шаблонам
        resolver.setSuffix(".xsl"); // Расширение XSLT-файлов
        resolver.setViewClass(XsltView.class);
        return resolver;
    }
}