package com.andreparker_pf.Repositories.impl;

import com.andreparker_pf.Repositories.IMessageContactRepository;
import com.andreparker_pf.entities.MessageContact;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by andre on 5/28/15.
 */
public class MessageContactHibernateRepository implements IMessageContactRepository{


    private SessionFactory factory;

    public MessageContactHibernateRepository()
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        factory = configuration.buildSessionFactory(registry);
    }

    public MessageContactHibernateRepository(SessionFactory factory)
    {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<MessageContact> getAll() {
        List<MessageContact> contacts = null;
        Transaction transaction = null;
        Session session = factory.openSession();

        try
        {
            transaction = session.beginTransaction();
            contacts = new ArrayList<>();
            List ls = session.createQuery("FROM MessageContact").list();

            for(Iterator itr = ls.iterator(); itr.hasNext();)
            {
                MessageContact contact = (MessageContact)itr.next();
                contacts.add(contact);
            }

            transaction.commit();
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
        return contacts;
    }

    @Override
    public int add(MessageContact contact) {
        Session session = factory.openSession();
        Transaction transaction = null;
        int id = -1;
        try
        {
            transaction = session.beginTransaction();
            id = (int)session.save(contact);
            transaction.commit();
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
        }
        finally {
            session.close();
        }
        return id;
    }

    @Override
    public void remove(int id)
    {
        Session session = factory.openSession();
        Transaction transaction = null;

        try
        {
            transaction = session.beginTransaction();
            MessageContact contact = (MessageContact)session.get(MessageContact.class, id);
            session.delete(contact);

            transaction.commit();
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }

            ex.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public void remove(MessageContact contact) {
        remove(contact.getId());
    }

    @Override
    public void deleteAll() {
        Session session = factory.openSession();
        Transaction transaction = null;

        try
        {
            transaction = session.beginTransaction();
            SQLQuery query = session.createSQLQuery("DELETE * FROM");
            query.executeUpdate();
            transaction.commit();
        }
        catch(HibernateException ex)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
