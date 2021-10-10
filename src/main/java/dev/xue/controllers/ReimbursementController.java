package dev.xue.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.xue.models.Employee;
import dev.xue.models.Reimbursement;
import dev.xue.models.Request;
import dev.xue.services.EmployeeServices;
import dev.xue.services.ReimbursementService;
import dev.xue.services.RequestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReimbursementController implements FrontController {

    private ObjectMapper om = new ObjectMapper();
    private ReimbursementService reimbursementService = new ReimbursementService();
    private RequestService requestService = new RequestService();
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
                    System.out.println("Getting all Reimbursements...");

                    List<Reimbursement> reimbursements = reimbursementService.getAllReimbursements();
                    response.getWriter().write(om.writeValueAsString(reimbursements));
                    break;
                }

                case "POST": {
                    //System.out.println("Creating new author...");
                    Reimbursement r = om.readValue(request.getReader(), Reimbursement.class);
//                    a.setId((reimbursementService.createReimbursement(a)).getId());
                    r = reimbursementService.createReimbursement(r);
                    String rName = r.getReimbursementName();

                    Reimbursement r1 = reimbursementService.getReimbursementByName(rName);

                    //System.out.println("id " +r1.getEmployeeID());


                    Request myRequest = new Request(r1.getEmployeeID(), r1.getReimbursementID(), "pending", false, false, false, false, "_");

                    myRequest = requestService.createRequest(myRequest);

                    //response.setStatus(201); // Resource created
                    response.getWriter().write(om.writeValueAsString(r));


                    break;
                }

            }


        } else {

            int authorId = Integer.parseInt(path);

            switch (request.getMethod()) {

                case "GET": {
                    Reimbursement r = reimbursementService.searchReimbursementById(authorId);
                    if (r != null) {
                        response.getWriter().write(om.writeValueAsString(r));
                    } else {
                        response.sendError(404, "Reimbursement not found");
                    }
                    break;
                }

                case "PUT": {
                    Reimbursement r = om.readValue(request.getReader(), Reimbursement.class);
                    reimbursementService.updateReimbursement(r);
                    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
                    // 204 - server doesn't have any content to send back, but the request was successful
                    break;
                }

                case "DELETE": {
                    reimbursementService.deleteReimbursement(authorId);
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
