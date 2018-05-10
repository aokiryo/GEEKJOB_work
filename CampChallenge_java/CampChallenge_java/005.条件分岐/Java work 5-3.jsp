<%-- 
    Document   : Java work 1-7
    Created on : 2018/03/27, 14:48:09
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
            char word = 'あ';
            
            switch(word){
                case 'あ':
                    out.print("日本語");
                    break;
                
                case 'A':
                    out.print("英語");
                    break;
                
                default:
            }
        %>
    </body>
</html>
