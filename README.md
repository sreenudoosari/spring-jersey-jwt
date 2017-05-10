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
![PlantUML model](http://www.plantuml.com/plantuml/png/bP5BImCn58Nt-HMNk9YDfLLS3LXGKK65bdR4JJTfSjkvEat6F1Yg-DzD9trP5EmYaCVvSiv9XFJ6mar5g3sSM5GiWw94CBfQWgBP32rgYJ15to1g42izouHMK0lhIL8j8aaEVAIK5GtfETi_uaDhL91-X6urJB0I9phhrcdRPHo4Ws6OLYIF0hiEPR2O-74x_ya_l1HFPaxwZYgFTg8XwrQhTIBQ8mOiTU_qKu8SxcyB6E5xYAxGWRsSB2aw_KJaSDxhmU0nYe0lq3anHvx7rAqADXXKv3pVkgISVxjiIh4at9bTzCxWMOlWIsFf8_xJviQsHmx3mRY0QwEMbvyyEBHQB68S_jfueHQa-IclXNEDiMf_zukr-DPcNQaXNyBLsajuCXhUS0casrykKIYqHrVwtws7lNz_vAHI1w_y3G00)
 

