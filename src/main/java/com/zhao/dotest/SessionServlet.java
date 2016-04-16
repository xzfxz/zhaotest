package com.zhao.dotest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String attributeName = req.getParameter("uname");
        String attributeValue = req.getParameter("uage");
        req.getSession().setAttribute(attributeName, attributeValue);
           resp.getWriter().print("hello world");
    }

    private static final long serialVersionUID = 2878267318695777395L;
}