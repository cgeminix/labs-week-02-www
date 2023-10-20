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
    <a href="">List Customer</a>
</body>
</html>