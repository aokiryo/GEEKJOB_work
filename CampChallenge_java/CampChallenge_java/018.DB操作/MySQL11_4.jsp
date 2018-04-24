<%-- 
    Document   : MySQL11_4
    Created on : 2018/04/24, 13:49:16
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
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");

            if (data.getDatas() != null) {
                for (int i = 0; i < data.getDatas().size(); i++) {
                    out.print("データ" + (i+1) + "<br>");
                    for (int n = 0; n < data.getDatas().get(i).size(); n++) {
                        out.print(data.getDatas().get(i).get(n) + "&nbsp");
                    }
                    out.print("<br>");
                }
            } else {
                out.print("データが存在しません");
            }
        %>
    </body>
</html>
