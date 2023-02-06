package com.secondprojectee.controller;

import com.secondprojectee.model.entity.Admin;
import com.secondprojectee.model.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.getSession().setAttribute("adminList", AdminService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("admin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");

        try {
            AdminService.add(new Admin(firstName, lastName));
        } catch (Exception e) {
            e.getMessage();
        }
        resp.sendRedirect("/admin");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        Boolean status = Boolean.valueOf(req.getParameter("status"));
        try {
            AdminService.edit(new Admin(id,firstName,lastName,status));
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            AdminService.remove(Long.valueOf(req.getParameter("id")));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
