package com.andreparker_pf.entities;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by andre on 5/11/15.
 */

import javax.persistence.*;

@Entity
@Table(name = "MessageContact")
@XmlRootElement
public class MessageContact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "message")
    private String message;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    public MessageContact()
    {}

    public MessageContact(int msg_id)
    {
        id = msg_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || obj.getClass() != getClass()) return false;
        MessageContact o = (MessageContact)obj;
        if(o.id != id) return false;

        return super.equals(obj);
    }
}
