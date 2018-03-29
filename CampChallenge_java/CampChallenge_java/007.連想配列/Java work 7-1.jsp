<%-- 
    Document   : Java work 7-1
    Created on : 2018/03/29, 10:15:38
    Author     : ryo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "java.util.HashMap" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HashMap<String,String> map1= new HashMap<String,String>();
            map1.put("1","AAA"); 

            HashMap<String,String> map2= new HashMap<String,String>();
            map1.put("hello","world"); 

            HashMap<String,String> map3= new HashMap<String,String>();
            map1.put("soeda","33"); 

            HashMap<String,String> map4= new HashMap<String,String>();
            map1.put("20","20"); 
        %>
    </body>
</html>
