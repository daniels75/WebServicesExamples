1. Run from command line:
	mvn jetty:run
2. Examples:
	----------------------------------------
	JAX-RS @Path URI matching example
	JAX-RS URI matching examples.
	----------------------------------------
	1.	Normal URI Matching - See normal URI matching with @Path annotation.
			http://localhost:8080/rest/users
			http://localhost:8080/rest/users/superuser
	2.	URI Matching and Parameter
		The value within an open brace “{” and close brace “}”, is represents a parameter, and can be access with @PathParam
			http://localhost:8080/rest/users/Daniels
			http://localhost:8080/rest/users/Kate
	3.	URI Matching and Regular Expression
		@Path support complex URI matching with regular expression, via following expression :
		{" variable-name [ ":" regular-expression ] "}
			
			@Path("{id : \\d+}")
			http://localhost:8080/rest/users/123
			
			@Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]}")
			http://localhost:8080/rest/users/username/ABC - fails!
			http://localhost:8080/rest/users/username/AB - ok!
			
			@Path("/books/{isbn : \\d+}")
			http://localhost:8080/rest/users/books/1234
		
	4.	@PathParam – Multiple Parameters
		Example to inject multiple parameters into Java method.
		http://localhost:8080/rest/users/2011/10/05
		
-----------------------------------------
Query Example
-----------------------------------------
	1. @QueryParam example
	See a full example of using @QueryParam in JAX-RS. 
	http://localhost:8080/rest/querysamples/sample1?from=100&to=200&orderBy=age&orderBy=name
	
	2. Programmatic Query Parameter
	Alternatively, you can get the query parameters grammatically, via “@Context UriInfo“
	http://localhost:8080/rest/querysamples/sample2??from=100&to=200&orderBy=age&orderBy=name
	
	3. @DefaultValue example
	@DefaultValue is good for optional parameter.
	http://localhost:8080/rest/querysamples/sample3	
	
	
	
		
		
	