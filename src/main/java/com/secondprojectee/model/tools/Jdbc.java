package com.secondprojectee.model.tools;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Jdbc {
    private static Jdbc jdbc = new Jdbc();

    public Jdbc() {
    }
    private static BasicDataSource basicDataSource = new BasicDataSource();
    static {
        basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        basicDataSource.setUsername("mohammedhossyn");
        basicDataSource.setPassword("mh990713");
        basicDataSource.setMaxIdle(10);
        basicDataSource.setMaxTotal(5);
    }
    public static Jdbc getJdbc() {
        return jdbc;
    }
public Connection getConnection() throws SQLException {
return basicDataSource.getConnection();
}
}
