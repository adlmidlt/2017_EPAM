package org.shop.configuration;

import org.shop.DisplayNameBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfig.class, InitializerConfig.class, ServiceConfig.class})
public class FactoryConfig {

    @Bean
    public BeanPostProcessor displayNameBeanPostProcessor() {
        return new DisplayNameBeanPostProcessor();
    }
}
