package org.tzesar.rest;

import org.tzesar.rest.annotations.DateFormat;
import org.tzesar.rest.annotations.DateTimeFormat;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/")
public class MessageRestService {

    @GET
    @Path("/test1")
    public Response test1(
            @QueryParam("date") @DateFormat final Date date
    ) {
        String result = "Date formatted : " + date;

        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/test2")
    public Response test2(
            @QueryParam("date") @DateFormat("yyyy/MM/dd") final Date date
    ) {
        String result = "Date formatted : " + date;

        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/test3")
    public Response test3(
            @QueryParam("date") @DateTimeFormat final Date date
    ) {
        String result = "Date formatted : " + date;

        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/test4")
    public Response test4(
            @QueryParam("date") @DateTimeFormat("yyyy/MM/dd HH:mm") final Date date
    ) {
        String result = "Date formatted : " + date;

        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/test5")
    @Produces(MediaType.APPLICATION_JSON)
    public Response test5(@BeanParam final DateBean dateBean) {
        return Response.status(200).entity(dateBean).build();
    }

    public static class DateBean {
        @QueryParam("dateQuery")
        @DateTimeFormat("dd-MM-yyyy HH:mm")
        private Date dateQuery;

        public Date getDateQuery() {
            return dateQuery;
        }

        public void setDateQuery(Date dateQuery) {
            this.dateQuery = dateQuery;
        }
    }

}