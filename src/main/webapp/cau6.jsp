<%@ page import="vn.edu.iuh.fit.responsitory.CandidateResponsitory" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Candidate" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Leon
  Date: 10/27/2023
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
            crossorigin="anonymous"></script>
</head>
<%
    CandidateResponsitory responsitory = new CandidateResponsitory();
    List<Candidate> ds = responsitory.getAllByGmail();
    ds = ds!=null?ds:new ArrayList<>();
%>
<body>
<div style="height: 500px; width: 900px">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ma</th>
            <th scope="col">ten</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <%for (Candidate cd:ds){%>
        <tr>
            <td><%=cd.getId()%></td>
            <td><%=cd.getFullName()%></td>
            <td>
                <form action="hello-servlet">
                    <input type="hidden" value=<%=cd.getId()%> name="id">  >
                    <BUTTON type="submit" name="viewCandidateDetail" >View</BUTTON>
                </form>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
