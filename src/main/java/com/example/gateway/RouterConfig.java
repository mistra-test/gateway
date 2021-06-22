package com.example.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouterConfig {
    @Value("${core.route.authentication-service}")
    String authenticationService;

    @Value("${core.route.catalog-service}")
    String catalogService;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(this::routeOnAuthentication)
                .route(this::routeOnCatalog)
                .build();
    }

    private Buildable<Route> routeOnCatalog(PredicateSpec route) {
        return route.path("/catalog/**").uri(catalogService);
    }

    private Buildable<Route> routeOnAuthentication(PredicateSpec route) {
        return route.path("/authentication/**").uri(authenticationService);
    }
}
