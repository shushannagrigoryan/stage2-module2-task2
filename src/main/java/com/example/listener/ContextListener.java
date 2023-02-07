package com.example.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;

public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent e){
        e.getServletContext().setAttribute("servletTimeInit", LocalDateTime.now());

    }
}
