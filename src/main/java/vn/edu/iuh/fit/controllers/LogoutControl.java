package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.edu.iuh.fit.models.Log;
import vn.edu.iuh.fit.services.LogServices;


import javax.swing.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/LogoutControl")
public class LogoutControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(session.getAttribute("timeIn").toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Log log = new Log(
                session.getAttribute("accountId").toString(),
                new Timestamp(parsedDate.getTime()),
                new Timestamp(date.getTime()),
                ""
        );
        LogServices.insertLog(log);
        resp.sendRedirect("/LapTrinh_Java_WWW_Week01/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("action");
        System.out.println(str);
    }
}