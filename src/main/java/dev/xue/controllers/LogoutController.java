package dev.xue.controllers;

import dev.xue.services.UserServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutController implements FrontController {

    private Logger log = LogManager.getLogger(LogoutController.class);
    private UserServices userServices = new UserServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        System.out.println("Username: " + username + " Password: " + password);

        request.getSession().invalidate();
        response.sendRedirect("static/index2.html");
    }
}
