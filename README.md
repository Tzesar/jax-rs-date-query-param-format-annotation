Date Format Annotation Test
===============================

This is a simple implementation of an annotation that allows JAX-RS to support a format input in order to parse Date and DateTime objects as QueryParams.

Modifications to the original implementation have been made to support empty params.

How to use:
----------
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

Original Implementation
------------------------

Date Param Annotation original implementation by [Paulo Zenida](https://zenidas.wordpress.com/recipes/configurable-date-format-in-jax-rs-as-queryparam/)
