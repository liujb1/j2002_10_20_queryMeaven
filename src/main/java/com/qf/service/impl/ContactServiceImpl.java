package com.qf.service.impl;

import com.qf.dao.ContactDAO;
import com.qf.dao.impl.ContactDAOImpl;
import com.qf.domain.Contact;
import com.qf.service.ContactService;

import java.util.List;

public class ContactServiceImpl implements ContactService {
    ContactDAO contactDAO=new ContactDAOImpl();
    @Override
    public List<Contact> queryAll() {
      return  contactDAO.queryAll();

    }

    @Override
    public List<Contact> queryAll(int currentPage, int pageSize) {
        int pageOffset=(currentPage-1)*pageSize;
       List<Contact> contactList= contactDAO.queryAll( pageOffset,  pageSize);
       return contactList;
    }

    @Override
    public int queryPageCount(int pageSize) {
        int recordCound=queryCount();
       return (int) Math.ceil(recordCound/(double)pageSize);
    }



    @Override
    public int queryCount() {
       int recordCound=contactDAO.queryCount();
       return recordCound;
}

    @Override
    public Boolean delete(String contactId) {
        int result=contactDAO.delete(contactId);
        return result==1;
    }

    @Override
    public Contact updateById(String id) {
        return contactDAO.updateById(id);
    }

    @Override
    public boolean updateByContact(Contact contact) {
       int result= contactDAO.updateByContact(contact);
        return result==1;
    }

    @Override
    public boolean addByContact(Contact contact) {
       int result= contactDAO.addByContact(contact);
        return result==1;
    }
}