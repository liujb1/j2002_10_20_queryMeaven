package com.qf.service;

import com.qf.domain.Contact;

import java.util.List;

public interface ContactService {
   List<Contact> queryAll();

    List<Contact> queryAll(int currentPage, int pageSize);

    int queryPageCount(int pageSize);
     int queryCount();

    Boolean delete(String contactId);

    Contact updateById(String id);
    boolean updateByContact(Contact contact);

 boolean addByContact(Contact contact);
}
