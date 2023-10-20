package vn.edu.iuh.fit.labsweek02www.frontend.models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.labsweek02www.backend.entities.Customer;
import vn.edu.iuh.fit.labsweek02www.backend.services.CustomerService;

import java.io.IOException;

public class CustomerModel {
    private CustomerService service = new CustomerService();
    public void insertCustomer(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        Customer cust = new Customer(name,email,phone,address);
        service.insertCust(cust);
        resp.sendRedirect("Customers.jsp");
    }
}
