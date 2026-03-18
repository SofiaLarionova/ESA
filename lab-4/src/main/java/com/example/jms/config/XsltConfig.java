package com.example.jms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.xslt.XsltView;
import org.springframework.web.servlet.view.xslt.XsltViewResolver;

@Configuration
public class XsltConfig {

    @Bean
    public XsltViewResolver xsltViewResolver() {
        XsltViewResolver resolver = new XsltViewResolver();
        resolver.setOrder(1);
        resolver.setPrefix("classpath:/templates/");
        resolver.setSuffix(".xsl");
        resolver.setViewClass(XsltView.class);
        return resolver;
    }
}