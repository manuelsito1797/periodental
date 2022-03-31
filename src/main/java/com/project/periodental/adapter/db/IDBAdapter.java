package com.project.periodental.adapter.db;

import java.sql.Connection;

/**
 * @author djimenez on 29/3/2022
 * periodental
 */
public interface IDBAdapter {

    Connection getConnection();
}
