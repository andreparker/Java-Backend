package com.andreparker_pf.api;

import com.andreparker_pf.entities.MessageContact;
import com.andreparker_pf.providers.MessageContactBodyReader;
import javafx.application.Application;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by andre on 6/2/15.
 */
public class DbApiControllerTest extends JerseyTest {
    @Override
    protected javax.ws.rs.core.Application configure() {
        return new ResourceConfig().packages("com.andreparker_pf.api");
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(MessageContactBodyReader.class);
        super.configureClient(config);
    }

    @Test
    public void addContactTest()
    {
        MessageContact contact = new MessageContact();
        contact.setName("Andre");
        contact.setMessage("Hello world");
        contact.setEmail("andrelnparker@gmail.com");

        Entity<String> entity = Entity.entity("{ \"id\":0, \"message\":\"a message\", \"email\":\"andrelnparker@gmail.com\", \"name\":\"andre\"}", MediaType.valueOf(MediaType.APPLICATION_JSON));
        //Entity<MessageContact> entity = Entity.entity(contact, MediaType.APPLICATION_JSON_TYPE);
        Response response = target("/repo").path("/db-add-contact").
                request(MediaType.TEXT_PLAIN_TYPE).accept(MediaType.APPLICATION_JSON_TYPE).post(entity, Response.class);

        String output = "";

        try
        {
            output = response.readEntity(String.class);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


        assertNotEquals(-1, output.indexOf("andre"));
    }

    @Test
    public void getContactsTest()
    {
        Response response = target("/repo").path("/db-all-contacts").request().accept(MediaType.APPLICATION_JSON_TYPE).get();


        String output = "empty";

        try
        {
            output = response.readEntity(String.class);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        assertEquals("Contacts",output);
    }
}
