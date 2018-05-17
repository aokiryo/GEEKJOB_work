<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO udd = (UserDataDTO) session.getAttribute("resultdetail");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>削除確認</h1>
        以下の内容を削除します。よろしいですか？<br>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br><br>

        <a href="DeleteResult?acc=<%= session.getAttribute("acc")%>">はい</a><br>
        <a href="./resultdetail.jsp">いいえ</a><br>
        
        <%=jh.home()%>
    </body>
</html>
