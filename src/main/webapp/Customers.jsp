<%--
  Created by IntelliJ IDEA.
  User: To Nga
  Date: 10/20/2023
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vn.edu.iuh.fit.labsweek02www.backend.services.CustomerService" %>
<%@ page import="vn.edu.iuh.fit.labsweek02www.backend.entities.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<html>
<head>
    <title>Customers</title>
</head>
<body>
<%
    CustomerService service = new CustomerService();
    List<Customer> lsCust =  service.getAll();
%>
<div class="container">
    <h2>Customers</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th><a href="Insert_Customer.jsp">Insert customer</a></th>

        </tr>
        </thead>
        <tbody>
        <%
            for (Customer cus : lsCust){
                long id = cus.getId();
        %>
        <tr>
            <td><%=id%></td>
            <td><%=cus.getCustName()%></td>
            <td><%=cus.getEmail()%></td>
            <td><%=cus.getPhone()%></td>
            <td><%=cus.getAddress()%></td>
            <th><a href="">update</a></th>
            <th><a href="">delete</a></th>

        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
