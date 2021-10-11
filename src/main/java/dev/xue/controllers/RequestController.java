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
import java.io.PrintWriter;
import java.util.List;



public class RequestController implements FrontController {


    private ObjectMapper om = new ObjectMapper();
    private RequestService requestService = new RequestService();
    private EmployeeServices employeeServices = new EmployeeServices();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = (String) request.getAttribute("path");
        System.out.println("Path attribute: " + path);
        System.out.println("Getting all requests...");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        Employee e = employeeServices.getEmployee(username);

        if (path == null || path.equals("")) {

            switch (request.getMethod()) {

                case "GET": {
                    // maybe this is a l=place where you want to check a user's permission/role
//                    System.out.println("Getting all requests...");
//                    HttpSession session = request.getSession();
//                    String username = (String) session.getAttribute("username");
//
//                    Employee e = employeeServices.getEmployee(username);

                    List<Request> requests;

                    if (e.isBenCo()){
                        requests = requestService.getBencoRequests();
                    }
//                    else if (e.isSupervisor()&& e.isDptHead()){
//                        requests = requestService.getBothRequests(e.getId());
//                    }
                    else if (e.isDptHead()){
                        requests = requestService.getDptRequests(e.getId());
                    }
                    else if (e.isSupervisor()){
                        requests = requestService.getSupervisorRequests(e.getId());
                    }
                    else {
                        requests = requestService.getRequestsForEmloyee(e.getId());

                    }
                    response.getWriter().write(om.writeValueAsString(requests));

                    break;
                }

                case "POST": {
                    //System.out.println("Creating new author...");
                    Request r = om.readValue(request.getReader(), Request.class);

//                    a.setId((requestService.createRequest(a)).getId());
                    r = requestService.createRequest(r);
                    //response.setStatus(201); // Resource created
                    response.getWriter().write(om.writeValueAsString(r));
                    break;
                }
                case "PUT": {

                    Request r = om.readValue(request.getReader(), Request.class);//stores request id to be updated,

                    if (e.isSupervisor() && e.isDptHead())
                    {
                        requestService.updateBoth(r.isSupervisorApproval(), r.isDptApproval(), r.getRequestID(), r.getStatus(), r.getDeniedReason());
                    }
                    else if (e.isBenCo()){
                        requestService.updateBenco(r.isBenCoApproval(), r.getRequestID(), r.getStatus());
                    }
                    else if (e.isDptHead()) {
                        requestService.updateDptHead(r.isDptApproval(),r.getRequestID(), r.getStatus());
                    }
                    else if (e.isSupervisor()){
                        requestService.updateSupervisor(r.isSupervisorApproval(), r.getRequestID(), r.getStatus(), r.getDeniedReason());
                    }

                    System.out.println(r);
                    response.getWriter().write(om.writeValueAsString(r));
                    break;
                }

            }


        } else {

            int authorId = Integer.parseInt(path);

            switch (request.getMethod()) {

                case "GET": {
                    Request r = requestService.searchRequestById(authorId);
                    if (r != null) {
                        response.getWriter().write(om.writeValueAsString(r));
                    } else {
                        response.sendError(404, "Request not found");
                    }
                    break;
                }

                case "PUT": {
                    Request r = om.readValue(request.getReader(), Request.class);
                    requestService.updateRequest(r);
                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    // 204 - server doesn't have any content to send back, but the request was successful
                    break;
                }

                case "DELETE": {
                    requestService.deleteRequest(authorId);
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
