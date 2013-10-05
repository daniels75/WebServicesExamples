package org.daniels.samples.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/users")
public class URIMatchingExamples {

	@GET
	public Response getUser() {
		return Response.status(200).entity("getUser is called").build();
	}

	@GET
	@Path("/superuser")
	public Response getSuperUser() {
		return Response.status(200).entity("getSuperUser is called").build();
	}

	@GET
	@Path("{name}")
	public Response getUserByName(@PathParam("name") String name) {
		return Response.status(200)
				.entity("getUserByName is called, name : " + name).build();
	}

	@GET
	@Path("{id : \\d+}")
	public Response getUserById(@PathParam("id") String id) {
		return Response.status(200).entity("getUserById is called, id : " + id)
				.build();
	}

	@GET
	@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
	public Response getUserByUserName(@PathParam("username") String username) {
		return Response.status(200)
				.entity("getUserByUserName is called, username : " + username)
				.build();
	}

	@GET
	@Path("/books/{isbn : \\d+}")
	public Response getUserBookByISBN(@PathParam("isbn") String isbn) {
		return Response.status(200)
				.entity("getUserBookByISBN is called, isbn : " + isbn).build();
	}
	
	
	@GET
	@Path("{year}/{month}/{day}")
	public Response getUserHistory(
			@PathParam("year") int year,
			@PathParam("month") int month, 
			@PathParam("day") int day) {
 
	   String date = year + "/" + month + "/" + day;
 
	   return Response.status(200)
		.entity("getUserHistory is called, year/month/day : " + date)
		.build();
 
	}	

}