package com.secondprojectee.model.service;

import com.secondprojectee.model.entity.Admin;
import com.secondprojectee.model.repository.AdminDA;

import java.sql.SQLException;
import java.util.List;

public class AdminService {
    public static Admin add(Admin admin) throws Exception {
        try (AdminDA adminDA = new AdminDA()) {
            return adminDA.add(admin);
        }
    }

    public static Admin edit(Admin admin) throws Exception {
        try (AdminDA adminDA = new AdminDA()) {
            return adminDA.edit(admin);
        }
    }

    public static Long remove(Long id) throws Exception {
        try (AdminDA adminDA = new AdminDA()) {
            return adminDA.remove(id);
        }
    }

    public static List<Admin> findAll() throws Exception {
        try (AdminDA adminDA = new AdminDA()) {
            return adminDA.findAll();
        }
    }

    public static Admin findById(Long id) throws Exception {
        try (AdminDA adminDA = new AdminDA()) {
            return adminDA.findById(id);
        }
    }


}
