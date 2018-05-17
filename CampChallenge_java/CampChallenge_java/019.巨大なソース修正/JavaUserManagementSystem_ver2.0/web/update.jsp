<%@page import="jums.UserDataDTO"%>
<%@page import="jums.JumsHelper" %>
<%@page import="java.text.SimpleDateFormat"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    UserDataDTO ud = (UserDataDTO) session.getAttribute("resultdetail");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS変更画面</title>
    </head>
    <body>
        <form action="UpdateResult" method="POST">
            名前:
            <input type="text" name="name" value="<%= ud.getName()%>">
            <br><br>

            生年月日:　
            <select name="year">
                <option value="">----</option>
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>" <%if (i == Integer.parseInt(new SimpleDateFormat("yyyy").format(ud.getBirthday()))) {%>
                        selected<%}%>> <%=i%></option>
                <% } %>
            </select>年
            <select name="month">
                <option value="">--</option>
                <% for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>" <%if (i == Integer.parseInt(new SimpleDateFormat("MM").format(ud.getBirthday()))) {%>
                        selected<%}%>> <%=i%></option>
                <% } %>
            </select>月
            <select name="day">
                <option value="">--</option>
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"<%if (i == Integer.parseInt(new SimpleDateFormat("dd").format(ud.getBirthday()))) {%>
                        selected<%}%>> <%=i%></option>
                <% } %>
            </select>日
            <br><br>


            種別:
            <br>
            <% for (int i = 1; i <= 3; i++) {%>
            <input type="radio" name="type" value="<%=i%>" <%if (i == ud.getType()) {%> 
                   checked <%}%>> <%=jh.exTypenum(i)%><br>
            <%}%>
            <br>

            電話番号:
            <input type="text" name="tell" value="<%= ud.getTell()%>">
            <br><br>

            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= ud.getComment()%></textarea><br><br>

            <input type="hidden" name="acc"  value="<%= session.getAttribute("acc")%>">
            <input type="submit" name="btnSubmit" value="更新">
        </form>
        <form action="./resultdetail.jsp" method="POST">
            <input type="submit" name="back" value="詳細画面へ戻る">
        </form><br>
        <%=jh.home()%>
    </body>
</html>
