package vn.edu.iuh.fit.labsweek02www.frontend.models;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.labsweek02www.backend.entities.Employee;
import vn.edu.iuh.fit.labsweek02www.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.labsweek02www.backend.services.EmployeeServices;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeModel {
    private EmployeeServices services = new EmployeeServices();
        public void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
            String name = req.getParameter("name");
            String s_dob = req.getParameter("dob");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String address = req.getParameter("address");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dob = LocalDate.parse(s_dob,formatter);

            Employee employee = new Employee(name,dob,phone,email,address, EmployeeStatus.ACTIVE);
            services.insertEmp(employee);
            resp.sendRedirect("Employee.jsp");
        }
}
