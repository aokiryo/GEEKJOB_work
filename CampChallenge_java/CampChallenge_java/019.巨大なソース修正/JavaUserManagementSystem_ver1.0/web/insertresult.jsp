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
        <title>JUMS登録結果画面</title>
    </head>
    <body>
        <% if (data.getError().size() == 0) {%>
        <h1>登録結果</h1><br>
        名前:<%= data.getName()%><br>
        生年月日:<%= data.getYear()+"年"+data.getMonth()+"月"+data.getDay()+"日"%><br>
        種別:<%= data.getType()%><br>
        電話番号:<%= data.getTell()%><br>
        自己紹介:<%= data.getComment()%><br>
        以上の内容で登録しました。<br>
    <% }else{ %>
        <h1>下部リンクから登録情報を入力してください</h1>
    <% } %>
        <form action="insert" method="POST">
            <input type="submit" name="no" value="登録画面に戻る">
        </form>
    <%
            hs.invalidate();
    %>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
