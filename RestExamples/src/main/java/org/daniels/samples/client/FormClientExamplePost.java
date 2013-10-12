package org.daniels.samples.client;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class FormClientExamplePost {

	private static final Logger logger = Logger.getLogger(FormClientExamplePost.class);
	
	public static void main(String[] args) {
		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/rest/user/add");
		

			Form formInput = new Form();    
			formInput.add("name", "Pawel");    
			formInput.add("age", 2);    

			// this also works!
			//ClientResponse response = webResource.post(ClientResponse.class, formInput);
			
			ClientResponse response = webResource
					.post(ClientResponse.class, formInput);


			
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);

		
			logger.info("Output from Server .... \n");
			logger.info(output);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}