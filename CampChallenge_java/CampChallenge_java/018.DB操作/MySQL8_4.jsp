<%-- 
    Document   : MySQL8_4
    Created on : 2018/04/20, 11:50:55
    Author     : ryo
--%>

<%@page import="org.camp.servlet.MySQL8_3"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <%
            MySQL8_3 data = (MySQL8_3) request.getAttribute("DATA");
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>result</title>
    </head>
    <body>
        <%    
            request.setCharacterEncoding("UTF-8");
            
            if (data.getProfilesID() != 0) {
                out.print(data.getProfilesID() + "<br>");
                out.print(data.getName() + "<br>");
                out.print(data.getTel() + "<br>");
                out.print(data.getAge() + "<br>");
                out.print(data.getBirthday() + "<br>");
            } else {
                out.print("データが存在しません");
            }
        %>
    </body>
</html>
