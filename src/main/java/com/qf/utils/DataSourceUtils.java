package com.qf.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceUtils implements ServletContextListener {
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        return dataSource;
    }


    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        InputStream is = servletContext.getResourceAsStream("WEB-INF/db.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(p);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
