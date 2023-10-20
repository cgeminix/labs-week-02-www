package vn.edu.iuh.fit.labsweek02www.frontend.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.labsweek02www.frontend.models.CustomerModel;

import java.io.IOException;

@WebServlet("/controls")
public class ServletController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object o = req.getParameter("action");
            if(o != null){
                String action = o.toString();
                if(action.equalsIgnoreCase("Insert_customer")){
                    CustomerModel customerModel = new CustomerModel();
                    customerModel.insertCustomer(req,resp);
                }
            }else {
                resp.sendRedirect("Customers.json");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
