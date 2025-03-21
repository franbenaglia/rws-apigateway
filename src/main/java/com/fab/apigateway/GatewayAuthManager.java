package com.fab.apigateway;

import java.util.Collections;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class GatewayAuthManager implements ReactiveAuthenticationManager {

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        if (authentication == null) {
            return null;
        }
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        if ((authentication.getName() == null || authentication.getName().isEmpty())
                || (authentication.getCredentials() == null)) {
            return null;
        }
        if (("test-user".equals(name) && "test-pwd".equals(password))) {
            return Mono.just(new UsernamePasswordAuthenticationToken(name, password, Collections.emptyList()));
        }
        return null;
    }
}