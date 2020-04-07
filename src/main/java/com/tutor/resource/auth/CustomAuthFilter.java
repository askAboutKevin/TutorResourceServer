package com.tutor.resource.auth;

import io.dropwizard.auth.AuthFilter;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import java.io.IOException;

@PreMatching
@Priority(Priorities.AUTHENTICATION)
public class CustomAuthFilter extends AuthFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        throw new WebApplicationException(Response.Status.UNAUTHORIZED);
    }
}
