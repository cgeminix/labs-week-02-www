<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 10/22/2023
  Time: 7:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vn.edu.iuh.fit.labsweek02www.backend.services.EmployeeServices" %>
<%@ page import="vn.edu.iuh.fit.labsweek02www.backend.entities.Employee" %>
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
    EmployeeServices services = new EmployeeServices();
    List<Employee> lsEmployee =  services.getAll();
%>
<div class="container">
    <h2>Customers</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Dob</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Status</th>
            <th><a href="Insert_Employee.jsp">Insert customer</a></th>

        </tr>
        </thead>
        <tbody>
        <%
            for (Employee employee : lsEmployee){
                long id = employee.getId();
        %>
        <tr>
            <td><%=id%></td>
            <td><%=employee.getFullname()%></td>
            <td><%=employee.getDob()%></td>
            <td><%=employee.getPhone()%></td>
            <td><%=employee.getEmail()%></td>
            <td><%=employee.getAddress()%></td>
            <td><%=employee.getStatus()%></td>
            <th><a href="">update</a></th>
            <th><a href="">delete</a></th>

        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
