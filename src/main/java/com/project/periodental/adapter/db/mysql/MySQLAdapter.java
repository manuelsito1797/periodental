package com.project.periodental.adapter.db.mysql;

import com.project.periodental.adapter.db.IDBAdapter;
import com.project.periodental.utils.PropertyUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class MySQLAdapter implements IDBAdapter {

    static {
        try {
            new com.mysql.cj.jdbc.Driver();
        } catch(Exception e){}
    }

    @Override
    public Connection getConnection() {
        try{
            String connectionString = getConnectionString();

            Properties p = PropertyUtil.load();
            assert p != null;
            String user = p.getProperty(PropertyUtil.USER);
            String password = p.getProperty(PropertyUtil.PASSWORD);

            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private String getConnectionString(){
        return Objects.requireNonNull(PropertyUtil.load()).getProperty(PropertyUtil.CONNECTION);
    }
}
