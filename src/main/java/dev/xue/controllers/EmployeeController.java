package dev.xue.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.xue.models.Employee;
import dev.xue.models.Request;
import dev.xue.services.EmployeeServices;
import dev.xue.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class EmployeeController implements FrontController {
    
    private ObjectMapper om = new ObjectMapper();
    private EmployeeServices employeeServices = new EmployeeServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = (String) request.getAttribute("path");
        System.out.println("Path attribute: " + path);



        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        Employee thisEmployee = employeeServices.getEmployee(username);


        if (path == null || path.equals("")) {

            switch (request.getMethod()) {

                case "GET": {
                    // maybe this is a l=place where you want to check a user's permission/role
                    System.out.println("Getting all requests...");

                    Employee e = employeeServices.getEmployee(username);

                    float tuition = e.getTuitionLeft();
                    response.getWriter().write(om.writeValueAsString(tuition));

                    break;
                }

                case "POST": {
                    //System.out.println("Creating new author...");
//                    Employee e = om.readValue(request.getReader(), Employee.class);
//
////                    a.setId((requestService.createRequest(a)).getId());
//                    e = employeeServices.(e);
//                    //response.setStatus(201); // Resource created
//                    response.getWriter().write(om.writeValueAsString(r));
                    break;
                }

                case "PUT": {
                    Employee e = om.readValue(request.getReader(), Employee.class);
                    System.out.println(e);

                    Employee e1 = employeeServices.getEmployeeByID(e.getId());

                    float curTuition = e1.getTuitionLeft() - e.getTuitionLeft();

                    employeeServices.updateTuition(curTuition, e.getId());

                    //response.setStatus(201); // Resource created
                    response.getWriter().write(om.writeValueAsString(e));
                    break;
                }

            }


        } else {

            switch (request.getMethod()) {

                case "GET": {
//                    Request r = requestService.searchRequestById(authorId);
//                    if (r != null) {
//                        response.getWriter().write(om.writeValueAsString(r));
//                    } else {
//                        response.sendError(404, "Request not found");
//                    }
                    break;
                }

                case "PUT": {
//                    Request r = om.readValue(request.getReader(), Request.class);
//                    requestService.updateRequest(r);
//                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
//                    // 204 - server doesn't have any content to send back, but the request was successful
                    break;
                }

                case "DELETE": {
//                    requestService.deleteRequest(authorId);
//                    response.setStatus(204);
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

