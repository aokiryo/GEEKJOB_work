<%-- 
    Document   : QueryString2
    Created on : 2018/04/11, 16:20:29
    Author     : ryo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QuaryString2</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String get = request.getParameter("num");
            int num = Integer.parseInt(get);

            if (num >= 2) {
                out.print(num + " = ");
                for (int i = 2; num >= i; i++) {
                    if (num % i == 0) {
                        while (num % i == 0) {
                            num = num / i;
                            out.print(i);
                            if (num >i) {
                                out.print(" * ");
                            }
                        }
                    }
                }
            } else if(num <= 1){
                out.print("不正な値です");
            }else{
                out.print("素数です");
            }
        %>
    </body>
</html>
