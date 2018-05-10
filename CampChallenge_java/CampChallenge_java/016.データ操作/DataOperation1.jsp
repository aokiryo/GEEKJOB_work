<%-- 
    Document   : DataOperation1
    Created on : 2018/04/10, 15:48:05
    Author     : ryo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            out.print(request.getParameter("txtName")+"<br>");
            out.print(request.getParameter("radSex")+"<br>");
            out.print(request.getParameter("txtHobby")+"<br>");
        %>
    </body>
</html>
