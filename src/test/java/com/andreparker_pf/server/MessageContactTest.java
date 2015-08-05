package com.andreparker_pf.server;

import com.andreparker_pf.entities.MessageContact;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by andre on 5/11/15.
 */
public class MessageContactTest {

    @Test
    public void idHasGetterSetter()
    {
        int number = 10;
        MessageContact contact = new MessageContact(number);
        assertThat(contact.getId(), is(equalTo(number)));
    }

    @Test
    public void messageHasGetterSetter()
    {
        String msg = "Test string";
        MessageContact contact = new MessageContact();
        contact.setMessage(msg);
        assertThat(contact.getMessage(), is(equalTo(msg)));
    }

    @Test
    public void emailHasGetterSetter()
    {
        String email = "somebody@gmail.com";
        MessageContact contact = new MessageContact();
        contact.setEmail(email);
        assertThat(contact.getEmail(), is(equalTo(email)));
    }

    @Test
    public void nameHasGetterSetter()
    {
        String name = "boby";
        MessageContact contact = new MessageContact();
        contact.setName(name);
        assertThat(contact.getName(), is(equalTo(name)));
    }

    @Test
    public void objectCompareSuccess()
    {
        MessageContact contact1 = new MessageContact(1);
        MessageContact contact2 = contact1;
        assertThat(contact1, is(equalTo(contact2)));
    }

    @Test
    public void objectCompareFail()
    {
        MessageContact contact1 = new MessageContact(1);
        MessageContact contact2 = new MessageContact(2);
        assertThat(contact1, is(not(equalTo(contact2))));
    }
}
