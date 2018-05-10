<%-- 
    Document   : Java work 8-1
    Created on : 2018/03/29, 10:32:05
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
            //8の20乗
            long result = 1;
            
            for (int i = 0; i < 20; i++) {
                result = result * 8;
            }
            
            out.print(result);
            
        %>
    </body>
</html>
