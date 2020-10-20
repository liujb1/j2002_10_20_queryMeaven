package com.qf.dao.impl;

import com.qf.dao.ContactDAO;
import com.qf.domain.Contact;
import com.qf.utils.DataSourceUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ContactDAOImpl implements ContactDAO {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(DataSourceUtils.getDataSource());
    @Override
    public List<Contact> queryAll() {
        List<Contact> execute = null;
        String sql="select * from contact_info where del=0";
        try {
         execute=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Contact.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        return execute;
    }

    @Override
    public List<Contact> queryAll(int pageOffset, int pageSize) {
        String sql="select * from contact_info where del=0 limit ?,?";
        List<Contact> query=null;
        try {
          query=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Contact.class),pageOffset,pageSize);
        }catch (Exception e){
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int queryCount() {
        int result = 0;
        try {
            String sql = "SELECT COUNT(*) FROM contact_info where del=0";
       result= jdbcTemplate.queryForObject(sql,Integer.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public int delete(String contactId) {
        int update=0;
        try {
            String sql = "update contact_info set del=1 where id=?";
            update=jdbcTemplate.update(sql,contactId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return update;
    }

    @Override
    public Contact updateById(String id) {
        String sql="select * from contact_info where id=? and del=0";
        List<Contact> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contact.class), id);
        if(query.size()==1){
            return query.get(0);
        }else
           return null;
    }

    @Override
    public int updateByContact(Contact contact) {
        String sql="update contact_info set name=? ,gender=?, birthday=? ,birthplace=? ,mobile=? ,email=? where id=?";
        int update = jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail(),
                contact.getId());
        return update;

    }

    @Override
    public int addByContact(Contact contact) {
        String sql="insert into contact_info (name,gender,birthday,birthplace,mobile,email) values(?,?,?,?,?,?)";
    int update = jdbcTemplate.update(sql,
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail());
        return  update;
    }

}
