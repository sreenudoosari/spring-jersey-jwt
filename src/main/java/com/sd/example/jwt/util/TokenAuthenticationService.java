package com.sd.example.jwt.util;

import static java.util.Collections.emptyList;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

class TokenAuthenticationService {
	static final long EXPIRATIONTIME = 180000; // 3 minutes
	static final String SECRET = "ASecretKeyForClient";
	static final String TOKEN_PREFIX = "Bearer";

	static void addAuthentication(HttpServletResponse res, String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		res.addHeader(HttpHeaders.AUTHORIZATION, TOKEN_PREFIX + " " + JWT);
	}

	static Authentication getAuthentication(javax.ws.rs.container.ContainerRequestContext request) {
		String token = request.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody().getSubject();
			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		return null;
	}
}