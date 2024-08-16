package com.example.apigateway.services;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class RouterValidator {

    public static final List<String> openEndpoints = List.of(
            "/v1/auth"
    );

    public Predicate<ServerHttpRequest> isSecured = serverHttpRequest ->
            openEndpoints.stream().noneMatch(uri -> serverHttpRequest.getURI().getPath().contains(uri));
}
