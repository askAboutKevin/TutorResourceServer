package com.tutor.resource.auth;

import io.dropwizard.auth.Authorizer;

import javax.annotation.Nullable;
import javax.ws.rs.container.ContainerRequestContext;

public class CustomAuthorizer implements Authorizer<TutorResourceUser> {

    @Override
    public boolean authorize(TutorResourceUser principal, String role) {
        return principal.getRoles() != null && principal.getRoles().contains(role);
    }
}
