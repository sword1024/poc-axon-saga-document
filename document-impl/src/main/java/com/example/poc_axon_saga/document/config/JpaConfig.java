package com.example.poc_axon_saga.document.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.poc_axon_saga.document.repository")
@EntityScan(value = "com.example.poc_axon_saga.document.model")
public class JpaConfig {
}
