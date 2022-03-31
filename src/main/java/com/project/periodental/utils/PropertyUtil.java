package com.project.periodental.utils;

import com.project.periodental.adapter.db.DBFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author djimenez on 14/3/2022
 * dental-shift
 */
public class PropertyUtil {

    public static final String USER = "user";
    public static final String PASSWORD = "password";
    public static final String CONNECTION = "connection";

    public static Properties load() {
        try {
            Properties p = new Properties();
            InputStream stream =
                    DBFactory.class.getClassLoader().getResourceAsStream("META-INF/dbadapter.properties");
            p.load(stream);
            return p;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
