package dev.xue.servlets;

import dev.xue.controllers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
I want our Request Handler to do 2 things:
    1: Return to the FrontControllerServlet the appropriate Controller to accomplish what the request is asking for
    2: Save some information to the Session that we will be using later
 */
public class RequestHandler {
    private Logger log = LogManager.getLogger(RequestHandler.class);

    // A map to hold the different controllers that we will be creating
    private Map<String, FrontController> controllerMap;

    {
        controllerMap = new HashMap<String, FrontController>();

        //controllerMap.put("books", new BookController());
        //controllerMap.put("authors", new AuthorController());
        controllerMap.put("login", new LoginController());
        controllerMap.put("users", new UserController());
        controllerMap.put("reimbursements", new ReimbursementController());
        controllerMap.put("logout", new LogoutController());
        controllerMap.put("requests", new RequestController());
        controllerMap.put("employees", new EmployeeController());
        controllerMap.put("grades", new GradeController());


    }

    // a method to return the appropriate controller
    public FrontController handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // This is where the logic will go to parse the URI and send back the appropriate controller
        StringBuilder uriString = new StringBuilder(request.getRequestURI()); // uri = /LibraryServlet/books/1
        System.out.println(uriString);

        // Remove context path
        uriString.replace(0, request.getContextPath().length() + 1, ""); // now we have => books/1
        System.out.println(uriString);

        // check first if there is a '.' - aka are we trying to access a static resource
//        if (uriString.indexOf(".") != -1) {
//            request.setAttribute("static", uriString.toString());
//            return (req, resp) -> {
//               req.getRequestDispatcher("/static/books.html").forward(req, resp);
//            };
//        }

        if (uriString.indexOf("html") != -1) {
            request.setAttribute("static", uriString.toString());
            return controllerMap.get(uriString.toString());
        }

        if (uriString.indexOf("/") != -1) {
            request.setAttribute("path", uriString.substring(uriString.indexOf("/") + 1)); // this will set the attribute 'path' to '1'
            uriString.replace(uriString.indexOf("/"), uriString.length() +1, ""); // at this point uriString = 'books'


        }

        System.out.println(uriString);

        return controllerMap.get(uriString.toString());

    }

}

