package vn.edu.iuh.fit.gk_03;

import java.io.*;

import jakarta.persistence.EntityTransaction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.iuh.fit.connectionDB.ConnectionDB;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.responsitory.CandidateResponsitory;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        if (request.getParameter("viewCandidateDetail")!=null){
            candidateDetail(request,response);
        } else if (request.getParameter("findRole")!=null) {
            String role = request.getParameter("role");
            CandidateResponsitory responsitory = new CandidateResponsitory();
            if (role.equals("ALL")){
                request.setAttribute("byRole", responsitory.getAll());
            }else {
                request.setAttribute("byRole", responsitory.getAllByRole(Role.valueOf(role)));
            }
            request.setAttribute("role",role);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/cau5.jsp");
            dispatcher.forward(request,response);
        }

    }
    public void candidateDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        CandidateResponsitory responsitory = new CandidateResponsitory();
        request.setAttribute("candidate", responsitory.findOne(id));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CandidateDetail.jsp");
        dispatcher.forward(request,response);
    }

}