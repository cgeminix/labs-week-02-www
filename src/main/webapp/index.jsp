<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vn.edu.iuh.fit.labsweek02www.backend.repositories.CustomerRepository"%>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
    <%
        CustomerRepository customerRepository = new CustomerRepository();
    %>
    <a href="Customers.jsp">List Customer</a>
    <br>
    <a href="Employee.jsp">List Employee</a>
</body>
</html>