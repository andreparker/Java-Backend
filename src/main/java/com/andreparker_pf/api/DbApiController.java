package com.andreparker_pf.api;

import com.andreparker_pf.entities.MessageContact;

import javax.ws.rs.*;

/**
 * Created by andre on 5/29/15.
 */

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("/repo")
public class DbApiController {

    @Context
    UriInfo uriInfo;

    @Context
    Request request;

    @POST
    @Path("/db-add-contact")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces("Application/JSON")
    public String addContact(MessageContact contact)
    {

        return "Contact: " + contact.getName() + " Message: " + contact.getMessage();
    }

    @GET
    @Path("/db-all-contacts")
    @Produces("Application/JSON")
    public String getContacts()
    {
        return "Contacts";
    }
}
