package com.codepig.cookie;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

@WebServlet("/CookieServlet")
public class HttpCookie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie
        Cookie cookie = new Cookie("spy","lht123");
        //2.响应给浏览器
        resp.addCookie(cookie);

    }
}
