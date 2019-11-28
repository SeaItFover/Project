package com.codepig.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SessionServlet")
public class HttpSession extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        javax.servlet.http.HttpSession session =  req.getSession();
        System.out.println(session);
        session.setAttribute("spy","hahhaah");

    }
}
