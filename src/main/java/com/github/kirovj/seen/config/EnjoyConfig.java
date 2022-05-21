package com.github.kirovj.seen.config;

import com.jfinal.template.ext.spring.JFinalViewResolver;
import com.jfinal.template.source.ClassPathSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

@Configuration
public class EnjoyConfig {

    @Bean
    public ViewResolver enjoyViewResolver() {
        var jvr = new JFinalViewResolver();
        jvr.setDevMode(false);
        jvr.setSourceFactory(new ClassPathSourceFactory());
        jvr.setPrefix("/templates/");
        jvr.setSuffix(".html");
        jvr.setContentType("text/html;charset=UTF-8");
        jvr.setOrder(0);

        var engine = JFinalViewResolver.engine;
        // 热加载配置能对后续配置产生影响，需要放在最前面
        engine.setDevMode(true);
        engine.setBaseTemplatePath(null);
        engine.setToClassPathSourceFactory();
        return jvr;
    }
}
