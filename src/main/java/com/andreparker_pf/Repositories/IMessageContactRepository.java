package com.andreparker_pf.Repositories;

import com.andreparker_pf.entities.MessageContact;

import java.util.List;

/**
 * Created by andre on 5/11/15.
 */
public interface IMessageContactRepository {

    List<MessageContact> getAll();
    int add(MessageContact contact);
    void remove(int id);
    void remove(MessageContact contact);
    void deleteAll();
}
