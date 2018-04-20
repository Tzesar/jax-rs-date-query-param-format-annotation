package org.tzesar.rest;

import org.tzesar.rest.annotations.DateFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("")
public class MessageRestService {

	@GET
    @Path("/parse-date")
	public Response testModified(
	        @QueryParam("date") @DateFormat() Date date
    ) {

		String result = "Date formatted : " + date;

		return Response.status(200).entity(result).build();

	}

}