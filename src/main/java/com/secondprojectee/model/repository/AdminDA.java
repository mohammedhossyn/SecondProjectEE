package com.secondprojectee.model.repository;

import com.secondprojectee.model.entity.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDA extends Crud <Admin>{
    public AdminDA() throws SQLException {
    }

    @Override
    public Admin add(Admin admin) throws SQLException {
        admin.setStatus(true);
        preparedStatement = connection.prepareStatement("INSERT INTO ADMIN (ID,FIRSTNAME,LASTNAME,STATUS) VALUES(admin_seq.nextval,?,?,?)");
        preparedStatement.setString(1,admin.getFirstName());
        preparedStatement.setString(2,admin.getLastName());
        preparedStatement.setBoolean(3, admin.isStatus());
        preparedStatement.execute();
        return admin;
    }

    @Override
    public Admin edit(Admin admin) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE ADMIN (?,?,?) WHERE ID = ?");
        preparedStatement.setString(1,admin.getFirstName());
        preparedStatement.setString(2,admin.getLastName());
        preparedStatement.setBoolean(3, admin.isStatus());
        preparedStatement.setLong(4,admin.getId());
        preparedStatement.execute();
        return admin;

    }

    @Override
    public Long remove(Long id) throws SQLException {
        preparedStatement = connection.prepareStatement("UPDATE ADMIN SET SATUS = 0 WHERE ID = ?");
        preparedStatement.setLong(1,id);
        preparedStatement.execute();
        return null;
    }

    @Override
    public List<Admin> findAll() throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT * FROM ADMIN ORDER BY LASTNAME");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Admin> adminList = new ArrayList<>();
        while (resultSet.next()) {
            Admin admin = new Admin(
                    resultSet.getLong("id"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getBoolean("status")
            );
            adminList.add(admin);
        }
        return adminList;
    }

    @Override
    public Admin findById(Long id) throws SQLException {
        preparedStatement = connection.prepareStatement("SELECT FROM ADMIN WHERE ID = ?");
        ResultSet resultSet = preparedStatement.executeQuery();
        Admin admin = new Admin(
                resultSet.getLong("id"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                resultSet.getBoolean("status")
        );
        return admin;
    }

}
