package com.example.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
import org.springframework.nativex.hint.TypeHint;

@TypeHint(
        types = PathRoutePredicateFactory.class,
        typeNames =
                "org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory$Config")
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
