package com.sandbox;


import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationException;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.List;
import java.util.Optional;

@Singleton
public class AuthenticationProviderLocal implements AuthenticationProvider {
    UserRepository userRepository;

    public AuthenticationProviderLocal(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        return Flux.create(emitter -> {
            userRepository
                    .findByUsername((String) authenticationRequest.getIdentity())
                    .ifPresentOrElse((user) -> {
                        if (authenticationRequest.getIdentity().equals(user.getUsername()) &&
                                authenticationRequest.getSecret().equals(user.getPassword())) {
                            emitter.next(AuthenticationResponse.success((String) authenticationRequest.getIdentity(), List.of("admin")));
                            emitter.complete();
                        } else {
                            emitter.error(new AuthenticationException(new AuthenticationFailed()));
                        }
                    }, () -> {
                        emitter.error(new AuthenticationException(new AuthenticationFailed()));
                    });
        }, FluxSink.OverflowStrategy.ERROR);
    }
}
