package com.andreparker_pf.providers;

import com.andreparker_pf.entities.MessageContact;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import java.io.IOException;
import java.io.InputStream;


        import java.lang.annotation.Annotation;
        import java.lang.reflect.Type;

/**
 * Created by andre on 6/3/15.
 */
public class MessageContactBodyReader implements MessageBodyReader<MessageContact>
{
    @Override
    public boolean isReadable(Class<?> type, Type genericType,
                              Annotation[] annotations, MediaType mediaType)
    {
        return type == MessageContact.class;
    }

    @Override
    public MessageContact readFrom(Class<MessageContact> type,
                                   Type genericType,
                                   Annotation[] annotations,
                                   MediaType mediaType,
                                   MultivaluedMap<String, String> httpHeaders,
                                   InputStream entityStream) throws IOException, WebApplicationException
    {

        try {
            ObjectMapper mapper = new ObjectMapper();
            MessageContact contact = mapper.readValue(entityStream, new TypeReference<MessageContact>() {
            });
            return contact;
        }
        catch(JsonGenerationException ex)
        {
            ex.printStackTrace();
        }
        catch (JsonMappingException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return null;
    }
}
