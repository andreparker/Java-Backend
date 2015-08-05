package com.andreparker_pf.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by andre on 5/11/15.
 */

@Path("/rest")
public class RestApiController {

    @GET
    @Produces("Application/json")
    @Path("test")
    public String RestTest()
    {
        return "Hello world!";
    }
}
