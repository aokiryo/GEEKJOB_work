<%-- 
    Document   : MySQL13_productView
    Created on : 2018/05/01, 16:36:42
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
            MySQL13_beans data = (MySQL13_beans) request.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            if (data.getProducts() != null) {
                out.print("商品一覧" + "<br>");
                for (int i = 0; i < data.getProducts().size(); i++) {
                    for (int n = 0; n < data.getProducts().get(i).size(); n++) {
                        out.print(data.getProducts().get(i).get(n));
                        if(n < data.getProducts().get(i).size() - 1){
                        out.print( "&nbsp" + ":" + "&nbsp");
                        }
                    }
                    out.print("<br>");
                }
            } else {
                out.print("データが存在しません");
            }
        %>
        <form action="MySQL13_logout" method="post">
            <input type="submit" value="ログアウト">
        </form>
    </body>
</html>
