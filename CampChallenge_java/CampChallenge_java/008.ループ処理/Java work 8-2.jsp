<%-- 
    Document   : Java work 8-2
    Created on : 2018/03/29, 10:49:50
    Author     : ryo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            //文字列型の変数
            ArrayList<String> words = new ArrayList<String>();

            //30回"A"を挿入
            for (int i = 0; i < 30; i++) {
                words.add("A");
            }
            
            //表示
            out.print(words);
            
        %>
    </body>
</html>
