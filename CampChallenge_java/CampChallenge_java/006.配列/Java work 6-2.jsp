<%-- 
    Document   : Java work 6-2
    Created on : 2018/03/28, 11:47:34
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

            //ArrayList型の配列を作成
            ArrayList<String> detas = new ArrayList<String>();

            //要素を追加
            detas.add("10");
            detas.add("100");
            detas.add("soeda");
            detas.add("hayashi");
            detas.add("-20");
            detas.add("118");
            detas.add("END");

            //"soeda"を"33"に変更
            detas.set(2, "33");

            //要素をすべて表示
            out.print(detas.get(0));
            out.print("<br>");
            out.print(detas.get(1));
            out.print("<br>");
            out.print(detas.get(2));
            out.print("<br>");
            out.print(detas.get(3));
            out.print("<br>");
            out.print(detas.get(4));
            out.print("<br>");
            out.print(detas.get(5));
            out.print("<br>");
            out.print(detas.get(6));

        %>
    </body>
</html>
