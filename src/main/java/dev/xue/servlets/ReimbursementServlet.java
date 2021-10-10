package dev.xue.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.xue.models.Reimbursement;
import dev.xue.services.ReimbursementService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReimbursementServlet extends HttpServlet {
//    ObjectMapper om = new ObjectMapper();
//    ReimbursementService reimbursementService = new ReimbursementService();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.getWriter().write(om.writeValueAsString(reimbursementService.getAllReimbursements()));
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        Reimbursement r = om.readValue(request.getReader(), Reimbursement.class);
//        r.setReimbursementID((reimbursementService.createReimbursement(r).getReimbursementID()));
//
//        response.getWriter().write(om.writeValueAsString(r));
//    }
    
}
