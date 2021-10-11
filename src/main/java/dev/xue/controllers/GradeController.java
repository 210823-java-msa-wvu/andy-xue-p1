package dev.xue.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.xue.models.Employee;
import dev.xue.models.Grade;
import dev.xue.models.Request;
import dev.xue.services.EmployeeServices;
import dev.xue.services.GradeService;
import dev.xue.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GradeController implements FrontController{



    private ObjectMapper om = new ObjectMapper();
    private GradeService gradeService = new GradeService();
    private EmployeeServices employeeServices = new EmployeeServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = (String) request.getAttribute("path");
        System.out.println("Path attribute: " + path);

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        Employee e = employeeServices.getEmployee(username);
        PrintWriter out = response.getWriter();

        out.println("<h1> Welcome Back" + e.getFirstName() + "</h1>");

        if (path == null || path.equals("")) {


            switch (request.getMethod()) {

                case "GET": {
                    // maybe this is a l=place where you want to check a user's permission/role
                    break;
                }
                case "POST": {
                    // maybe this is a l=place where you want to check a user's permission/role
                    Grade g = om.readValue(request.getReader(), Grade.class);

//                    a.setId((requestService.createRequest(a)).getId());
                    g = gradeService.createGrade(g);
                    //response.setStatus(201); // Resource created
                    response.getWriter().write(om.writeValueAsString(g));
                    break;
                }

            }


        } else {

            int authorId = Integer.parseInt(path);

            switch (request.getMethod()) {

                case "GET": {
                    Grade r = gradeService.searchGradeById(authorId);
                    if (r != null) {
                        response.getWriter().write(om.writeValueAsString(r));
                    } else {
                        response.sendError(404, "Grade not found");
                    }
                    break;
                }

                case "PUT": {
                    Grade r = om.readValue(request.getReader(), Grade.class);
                    gradeService.updateGrade(r);
                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    // 204 - server doesn't have any content to send back, but the request was successful
                    break;
                }

                case "DELETE": {
                    gradeService.deleteGrade(authorId);
                    response.setStatus(204);
                    break;
                }

                default: {
                    response.sendError(405);
                    break;
                }
            }

        }








    }
}
