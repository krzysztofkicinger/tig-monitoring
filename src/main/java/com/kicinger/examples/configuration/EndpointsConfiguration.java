package com.kicinger.examples.configuration;

import com.kicinger.examples.endpoints.HealthWebEndpointExtension;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.logging.LoggersEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.annotation.Bean;

public class EndpointsConfiguration {

    @Bean
    @ConditionalOnClass(LoggingSystem.class)
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint // Makes sure that the endpoint is not created (or exposed) according to the configuratoin
    public LoggersEndpoint loggersEndpoint(LoggingSystem loggingSystem) {
        return new LoggersEndpoint(loggingSystem);
    }

    @Bean
    @ConditionalOnClass(HealthEndpoint.class)
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public HealthWebEndpointExtension healthWebEndpointExtension(HealthEndpoint healthEndpoint) {
        return new HealthWebEndpointExtension(healthEndpoint);
    }

}
