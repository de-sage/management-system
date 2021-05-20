package com.claritae.maintainance.config;

import com.claritae.maintainance.audit.AuditorAwareImple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.claritae.maintainance" })
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@ComponentScan({ "com.claritae.maintainance" })
public class PersistenceConfig {

    @Bean("auditorProvider")
    public AuditorAwareImple auditorProvider() {
        return new AuditorAwareImple();
    }
}
