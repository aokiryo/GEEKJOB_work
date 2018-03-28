<%-- 
    Document   : Java work 1-3
    Created on : 2018/03/27, 11:10:51
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
            int num1 = 10;
            final int num2 = 5;
            
            //加算　15
            int add = num1 + num2;
            out.print(num1 + "+" + num2 + "=" + add + "<br>");
           
            //減算　5
            int sub = num1 - num2;
            out.print(num1 + "-" + num2 + "=" + sub + "<br>");

            //乗算　50
            int mul = num1 * num2;
            out.print(num1 + "*" + num2 + "=" + mul + "<br>");

            //除算　2
            int div = num1 / num2;
            out.print(num1 + "/" + num2 + "=" + div + "<br>");
            
        %>
    </body>
</html>
