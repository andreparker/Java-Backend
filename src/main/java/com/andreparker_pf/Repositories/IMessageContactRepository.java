package com.andreparker_pf.Repositories;

import com.andreparker_pf.entities.MessageContact;

import java.util.List;

/**
 * Created by andre on 5/11/15.
 */
public interface IMessageContactRepository {

    List<MessageContact> GetAll();
    int Add(MessageContact contact);
    void Remove(int id);
    void Remove(MessageContact contact);
    void DeleteAll();
}
