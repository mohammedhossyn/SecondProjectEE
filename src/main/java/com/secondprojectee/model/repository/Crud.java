package com.secondprojectee.model.repository;

import com.secondprojectee.model.tools.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class Crud <M> implements AutoCloseable{
    protected  Connection connection;
    protected PreparedStatement preparedStatement;

    public Crud() throws SQLException {
        connection = Jdbc.getJdbc().getConnection();
    }

    public abstract M add(M m) throws SQLException;
    public abstract M edit(M m) throws SQLException;
    public abstract Long remove(Long id) throws SQLException;
    public abstract List<M> findAll() throws SQLException;
    public abstract M findById(Long id) throws SQLException;

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
