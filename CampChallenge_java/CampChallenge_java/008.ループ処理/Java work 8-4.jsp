<%-- 
    Document   : Java work 8-4
    Created on : 2018/03/29, 11:47:21
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
            int num = 1000;

            //numを2で繰り返し割り、100未満になったら処理を終える
            while (num > 100) {
                num = num / 2;
            }
            
            out.print(num);
            
        %>
    </body>
</html>
