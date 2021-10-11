package dev.xue.controllers;

import dev.xue.models.Employee;
import dev.xue.services.EmployeeServices;
import dev.xue.services.UserServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController implements FrontController {

    private Logger log = LogManager.getLogger(LoginController.class);
    private UserServices userServices = new UserServices();
    private EmployeeServices employeeServices = new EmployeeServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Username: " + username + " Password: " + password);

        Employee e;

        if (userServices.login(username, password)) {
            // response.sendRedirect("static/reimbursements.html");
            e = employeeServices.getEmployee(username);

            HttpSession session = request.getSession();
            String currentUser = (String) session.getAttribute("username");
            session.setAttribute("username", e.getUsername());

            if (e.isDptHead() && e.isSupervisor())
            {
                response.sendRedirect("static/headAndSupervisor.html");
            }
            else if (e.isBenCo()){
                response.sendRedirect("static/bencoForm.html");
            }
            else if (e.isDptHead()){
                response.sendRedirect("static/dptHeadForm.html");
            }
            else if (e.isSupervisor()){
                response.sendRedirect("static/supervisorForm.html");
            }

            else {
               response.sendRedirect("static/home.html");
            }

        } else {
            response.sendRedirect("static/loginFailed.html");
        }


    }
}
