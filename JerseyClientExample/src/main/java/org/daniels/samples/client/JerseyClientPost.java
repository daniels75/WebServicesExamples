package org.daniels.samples.client;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPost {
	private static final Logger logger = Logger.getLogger(JerseyClientGet.class);
	public static void main(String[] args) {

		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:8080/rest/json/metallica/post");

			String input = "{\"singer\":\"Metallica\",\"title\":\"Fade To Black\"}";

			ClientResponse response = webResource.type("application/json")
					.post(ClientResponse.class, input);

			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			logger.info("Output from Server .... \n");
			String output = response.getEntity(String.class);
			logger.info(output);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

}
