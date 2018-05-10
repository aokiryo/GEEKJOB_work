<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <%
            String defaultName = "";
            String defaultYear = "0";
            String defaultMonth = "0";
            String defaultDay = "0";
            String defaultTypeE = "";
            String defaultTypeS = "";
            String defaultTypeO = "";
            String defaultTell = "";
            String defaultComment = "";
        %>
        <form action="insertconfirm" method="POST">
            <%if (hs.getAttribute("name") != null) {
                    defaultName = (String) hs.getAttribute("name");
                }%>
            名前:
            <input type="text" name="name" value="<%= defaultName%>">
            <br><br>

            <%if (hs.getAttribute("year") != null) {
                    if (!hs.getAttribute("year").equals("")) {
                        defaultYear = (String) hs.getAttribute("year");
                    }
                }%>
            <%if (hs.getAttribute("month") != null) {
                    if (!hs.getAttribute("month").equals("")) {
                        defaultMonth = (String) hs.getAttribute("month");
                    }
                }%>
            <%if (hs.getAttribute("day") != null) {
                    if (!hs.getAttribute("day").equals("")) {
                        defaultDay = (String) hs.getAttribute("day");
                    }
                }%>
            生年月日:
            <select name="year">
                <option value="">----</option>
                <% for (int i = 1950; i <= 2010; i++) {%>
                <option value="<%=i%>"<%if (i == Integer.parseInt(defaultYear)) {%>
                        selected<%}%>> <%=i%></option>
                <%}%>
            </select>年
            <select name="month">
                <option value="">--</option>
                <% for (int i = 1; i <= 12; i++) {%>
                <option value="<%=i%>"<%if (i == Integer.parseInt(defaultMonth)) {%>
                        selected<%}%>> <%=i%></option>
                <%}%>
            </select>月
            <select name="day">
                <option value="">--</option>
                <% for (int i = 1; i <= 31; i++) {%>
                <option value="<%=i%>"<%if (i == Integer.parseInt(defaultDay)) {%>
                        selected<%}%>> <%=i%></option>
                <%}%>
            </select>日
            <br><br>

            <%if (hs.getAttribute("type") != null) {
                    if (hs.getAttribute("type").equals("1")) {
                        defaultTypeE = "checked";
                    } else if (hs.getAttribute("type").equals("2")) {
                        defaultTypeS = "checked";
                    } else if (hs.getAttribute("type").equals("3")) {
                        defaultTypeO = "checked";
                    }
                }%>
            種別:
            <br>
            <input type="radio" name="type" value="1" <%= defaultTypeE%>>エンジニア<br>
            <input type="radio" name="type" value="2" <%= defaultTypeS%>>営業<br>
            <input type="radio" name="type" value="3" <%= defaultTypeO%>>その他<br>
            <br>

            <%if (hs.getAttribute("tell") != null) {
                    defaultTell = (String) hs.getAttribute("tell");
                }%>
            電話番号:
            <input type="text" name="tell" value="<%= defaultTell%>">
            <br><br>

            <%if (hs.getAttribute("comment") != null) {
                    defaultComment = (String) hs.getAttribute("comment");
                }%>
            自己紹介文
            <br>
            <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%= defaultComment%></textarea><br><br>

            <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
            <input type="submit" name="btnSubmit" value="確認画面へ">
        </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
