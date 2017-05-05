package com.sd.example.jwt.util;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.security.core.Authentication;

import com.sd.example.jwt.filter.JWTTokenNeeded;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTAuthenticationFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		Authentication authentication = TokenAuthenticationService.getAuthentication(requestContext);
		if (authentication == null) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}
}