package com.kicinger.examples.metrics;

import com.kicinger.examples.services.TestServices;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FunctionCounterMetricsService {

    private MeterRegistry meterRegistry;
    private TestServices testServices;

    @Autowired
    public FunctionCounterMetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    private void initFunctionCounter() {
//        FunctionCounter.builder("custom.function.counter", testServices, )
    }

    @PostConstruct
    private void initCounter() {
        Counter.builder("custom.counter")
                .baseUnit("happiness")
                .description("Measure of happiness")
                .register(meterRegistry);
    }

}
