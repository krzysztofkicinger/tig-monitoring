package com.kicinger.examples.services;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MetricsService {

    private MeterRegistry meterRegistry;

    @Autowired
    public MetricsService(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public void addAdditionalCounter() {
        meterRegistry.counter("tig.additional.counter").increment();
    }

    public void addAdditionalGauge() {
        meterRegistry.gauge("tig.additional.gauge", new Random().nextInt());
    }


}
