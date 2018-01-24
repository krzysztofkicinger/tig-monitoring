package com.kicinger.examples.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.http.ResponseEntity;

@EndpointWebExtension(endpoint = HealthEndpoint.class)
public class HealthWebEndpointExtension {

    private final HealthEndpoint delegate;

    public HealthWebEndpointExtension(HealthEndpoint delegate) {
        this.delegate = delegate;
    }

    @ReadOperation
    public ResponseEntity<Health> getHealth() {
        return ResponseEntity.ok(delegate.health());
    }

}
