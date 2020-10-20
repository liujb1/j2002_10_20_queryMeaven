package com.qf.web;

import com.qf.domain.Contact;
import com.qf.service.ContactService;
import com.qf.service.impl.ContactServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/update_servlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactService contactService=new ContactServiceImpl();
        Map<String, String[]> parameterMap = request.getParameterMap();
        Contact contact=new Contact();
        try {
            BeanUtils.populate(contact,parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        contactService.updateByContact(contact);

        response.sendRedirect("query_contact");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
