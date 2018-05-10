<%-- 
    Document   : Java work 8-3
    Created on : 2018/03/29, 11:00:48
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
//0から100までの合計
            int result = 0;
            
            for (int i = 0; i <= 100; i++) {
                result = result + i;
            }
            
            out.print(result);
            
        %>
    </body>
</html>
