package com.sd.example.jwt.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(final HttpServletRequest request, final HttpServletResponse response,
			final AuthenticationException authException) throws IOException, ServletException {

		response.setHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
		response.setContentType(MediaType.APPLICATION_JSON);
		response.setStatus(Status.UNAUTHORIZED.getStatusCode());
		response.getOutputStream().println("{\"message\":\"AUTHENTICATION FAILED\"}");
		response.getOutputStream().flush();

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("A_REALM");
		super.afterPropertiesSet();
	}
}