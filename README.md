# Spring-Jersey-JWT
With this sample application, I want to show you,

  - How to create and verify a JSON web token (JWT)
  - How to use JWT with Jersey and SpringBoot 
  inorder to invoke some secured endpoints using a simple annotation.
# So what is JWT ?
JWT is just a token format or it defines a token format which is compact and self-contained and can be used  for securely transmitting information between parties as a JSON object. This token can be verified and trusted because it is digitally signed.<br>
More about JWT can be found here <a href="https://jwt.io/introduction/">JWT Introduction</a><br>

# But what is the purpose of a security token ?
Security tokens are protected data structures<br>
They contain information about issuer and subject<br>
They are signed ( tamper proof & authenticity)<br>
Tipically contain an expiration time<br>

# Before JWT ?
- We have  <a href="https://en.wikipedia.org/wiki/Security_Assertion_Markup_Language"> SAML - Security Assertion markup language token </a> (Used mostly in SOAP)  and <br>
- Simple Web Token <a href="https://msdn.microsoft.com/en-us/library/azure/hh781551.aspx">SWT</a>

# How it works
Now that we have a little knowledge on JWT, let's dive into the application.<br>
Here are the two GET methods of the *ProductRestResource* endpoint.
```java
@Path("/products")
@Produces({ MediaType.APPLICATION_JSON})
public class ProductRestResource {

	@GET
	public Response findAllPublicProducts() {
		return Response.status(Status.OK).entity("{\"message\":\"Public products list\"}").build();
	}

	@GET
	@Path("/secure")
	@JWTTokenNeeded //this annotation verifies the token passed by the client in the header.
	public Response findAllPrivateProducts() {
		return Response.status(Status.OK).entity("{\"message\":\"Secured products list\"}").build();
	}
}
```
 
# Sequence Diagram 
![PlantUML model](http://www.plantuml.com/plantuml/png/bL5BJm8n4BxtLqpgOIyIq7ZQH18rQg8c4C1uuLBQWHrTshMFRD3utorR5f1e8eScVNpFgP3UMBWf2RM74ukAPJ0f48mkLw1eFaUBMYBCqDU86iGQppAX5LJ2Uf9KYSWa1pwob1KrwGNRV-93QrIGVeHklKom4gSwwrRfscKSX8DXc9KaZo9s7SfWCV77pVud_-5bycGMfE-ez6Yd6h9kkJudHlF4WANkdNvAaCFzxGH6-1wYAtHWBoTBY4u_CN8ux_LWy1X1m9Ved5WWpsFg1WKj3KfodczTKiw_NTfIB05tPXUzCtZM8lZ2MFg8_zGgDZro60x6EyMQV07NHgqkFtbmQBLOncpyjVP2BKdpKru9vsfZrVxj5skqjfwRVetOrSPOU38Qtd05f9ilBr0ej4Vt-v_guH1-dtX2gOEHVmC0)
 
# Conclusion
Hope this short explanation is helpful to you to understand the basic concepts.<br>
**Your comments and suggestions are most welcome!** <br><br>
Cheers! <br> [@SreenuDoosari](https://twitter.com/SreenuDoosari)
