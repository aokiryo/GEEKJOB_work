<%-- 
    Document   : MySQL13_login
    Created on : 2018/04/27, 17:08:07
    Author     : ryo
--%>

<%@page import="org.camp.servlet.MySQL13_beans"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            Object status = session.getAttribute("login");
            if (status != null) {
                out.println("<p>認証に失敗しました</p>");
                out.println("<p>再度ユーザー名とパスワードを入力して下さい</p>");
                session.setAttribute("login", null);
            }
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <form action="MySQL13_loginCheck" method="post">
            ユーザー名とパスワードを入力してください<br>
            ユーザー名:<input type="text" name="userName"><br>
            パスワード:<input type="text" name="password"><br>
            <input type="submit" name="btnsubmit" value="ログイン">
        </form>
    </body>
</html>
