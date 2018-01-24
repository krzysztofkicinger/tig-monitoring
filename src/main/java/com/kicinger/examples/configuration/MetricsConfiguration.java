package com.kicinger.examples.configuration;

import io.micrometer.core.instrument.ImmutableTag;
import io.micrometer.core.instrument.binder.jvm.JvmThreadMetrics;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class MetricsConfiguration {

    // Use env to create common solution
//    private Environment environment;

    @Bean
    public MeterRegistryConfigurer meterRegistryConfigurer() {
        return registry ->
                registry.config().commonTags(
                        Arrays.asList(
                                new ImmutableTag("application", "tig-monitoring"),
                                new ImmutableTag("product-group", "examples")
                        )
                );
    }

    @Bean
    public JvmThreadMetrics jvmThreadMetrics() {
        return new JvmThreadMetrics();
    }

}
