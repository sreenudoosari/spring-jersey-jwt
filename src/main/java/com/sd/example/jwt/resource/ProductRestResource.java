package com.sd.example.jwt.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import com.sd.example.jwt.filter.JWTTokenNeeded;

@Component
@Path("/products")
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
public class ProductRestResource {

	@GET
	public Response findAllPublicProducts() {
		return Response.status(Status.OK).entity("{\"message\":\"Public products list\"}").build();
	}

	@GET
	@Path("/secure")
	@JWTTokenNeeded //this annotation verifies the authentication of the user and his token if logged in.
	public Response findAllPrivateProducts() {
		return Response.status(Status.OK).entity("{\"message\":\"Secured products list\"}").build();
	}

}
