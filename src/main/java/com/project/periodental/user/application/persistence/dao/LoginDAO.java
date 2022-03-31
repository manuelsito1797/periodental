package com.project.periodental.user.application.persistence.dao;

import com.project.periodental.adapter.db.IDBAdapter;
import com.project.periodental.user.domain.user.CommonUserFactory;
import com.project.periodental.user.domain.user.User;
import io.activej.inject.annotation.Inject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public class LoginDAO {

    private final IDBAdapter adapter;

    @Inject
    public LoginDAO(IDBAdapter adapter) {
        this.adapter = adapter;
    }

    public boolean exitsByName(String username) {
        try {
            var sql = "select * from t_usuario where f_usuario = '".concat(username.trim() + "' limit 1");
            var result = executeQuery(sql);

            if(!result.next()) {
                return false;
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String findEncriptedPasswordByUsername(String username) {
        try {
            var sql = "select * from t_usuario where f_usuario = '".concat(username.trim() + "' limit 1");
            var result = executeQuery(sql);

            if(!result.next()) {
                return null;
            }

            return result.getString(7);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User singUp(String username, String password) {
        try {
            var sql = "select * from t_usuario where f_usuario = '"
                    .concat(username.trim() + "' and f_password = '".concat(password.trim() + "' limit 1"));
            var result = executeQuery(sql);

            if(!result.next()) {
                return null;
            }

            int id = result.getInt(1);
            String name = result.getString(2);
            String lastName = result.getString(3);
            String phone = result.getString(4);
            String email = result.getString(5);
            String user = result.getString(6);
            String pw = result.getString(7);
            Timestamp creationDate = result.getTimestamp(8);
            int createdBy = result.getInt(9);
            boolean status = result.getBoolean(10);

            return new CommonUserFactory().create(id, name, lastName, phone, email,
                    user, pw, createdBy, creationDate, status);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ResultSet executeQuery(String sql) {
        var connection = adapter.getConnection();
        try {
            var statement = connection.prepareStatement(sql);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
