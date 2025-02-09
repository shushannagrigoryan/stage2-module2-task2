package com.example.servlet;

import com.example.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            response.sendRedirect("/login.jsp");
        }
        else{
            response.sendRedirect("/user/hello.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
        HttpSession session = request.getSession();
        Users.getInstance().getUsers();
        if(Users.getInstance().getUsers().contains(request.getParameter("login")) && !request.getParameter("password").isEmpty()){
            session.setAttribute("user", request.getParameter("login"));
            response.sendRedirect("/user/hello.jsp");
        }
        else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
