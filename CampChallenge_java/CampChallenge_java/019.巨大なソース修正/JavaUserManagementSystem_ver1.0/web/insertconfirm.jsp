<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            UserDataBeans data = (UserDataBeans) hs.getAttribute("DATA");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録確認画面</title>
    </head>
    <body>
        <% if (data.getError().size() == 0) {%>
        <h1>登録確認</h1>
        名前:<%= data.getName()%><br><!--要素1-->
        生年月日:<%= data.getYear() + "年" + data.getMonth() + "月" + data.getDay() + "日"%><br><!--要素2-->
        種別:<%= data.getType()%><br><!--要素3-->
        電話番号:<%= data.getTell()%><br><!--要素4-->
        自己紹介:<%= data.getComment()%><br><!--要素5-->
        上記の内容で登録します。よろしいですか？
        <form action="insertresult" method="POST">
            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="yes" value="はい">
        </form>
        <% } else {
            for (int i = 0; i < data.getError().size(); i++) {
                out.print(data.getError().get(i));
                if (i < data.getError().size() - 1) {
                    out.print(", ");
                }
            }
        %>
        が未入力です
        <% }%>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
