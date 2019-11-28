package com.codepig.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

@WebServlet("/CookieServlet02")
public class HttpCookie02 extends HttpServlet {
    private static final long serialVersionUID = 1L;



    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie
        Cookie cookie = new Cookie("spy","lht123");

        //设置cookie持久化时间
        cookie.setMaxAge(30);

        //设置Cookie在指定的路径访问时携带着cookie
        cookie.setPath("/CookieServlet02");

        //2.响应给浏览器
        resp.addCookie(cookie);

        //获取携带的cookie
        Cookie[] cookies = req.getCookies();
        if (cookie != null){
            for (Cookie coo:cookies){
                String name = coo.getName();
                if (name.equals("spy")){
                    resp.getWriter().write("<br>");
                    resp.getWriter().write("value = "+coo.getValue());
                    resp.getWriter().write("</br>");
                }
            }
        }

    }
}
