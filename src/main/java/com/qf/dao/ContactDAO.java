package com.qf.dao;

import com.qf.domain.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> queryAll() ;
    List<Contact> queryAll(int pageOffset,int pageSize);

    int queryCount();

    int delete(String contactId);

    Contact updateById(String id);

    int updateByContact(Contact contact);

    int addByContact(Contact contact);
}
