<%-- 
    Document   : MySQL13_productOperation
    Created on : 2018/04/25, 11:56:59
    Author     : ryo
--%>

<%@page import="org.camp.servlet.MySQL13_beans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            MySQL13_beans data = (MySQL13_beans) request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>productOperation</title>
    </head>
    <body>
        <%
//            //ログインしているか確認
//            if (data.getLog() == false) {
//                response.sendRedirect("MySQL13_login.jsp");
//            }
        %>
        <h1>商品管理ページ</h1><br>
        <form action="MySQL13_productRegistration" method="post">
            登録する商品の情報を入力してください<br>
            商品ID:<input type="text" name="pID"><br>
            商品名:<input type="text" name="pName"><br>
            商品カテゴリ:<input type="text" name="pCategory"><br>
            商品価格:<input type="text" name="pPrice"><br>
            <input type="submit" name="btnsubmit" value="登録">
        </form>
        <form action="MySQL13_productRequest" method="post">
            <input type="submit" value="商品一覧表示">
        </form>
        <form action="MySQL13_logout" method="post">
            <input type="submit" value="ログアウト">
        </form>
    </body>
</html>
