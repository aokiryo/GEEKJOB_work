<%@page import="jums.JumsHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error</title>
    </head>
    <body>
        エラーが発生しました。以下の項目を確認してください。<br><br>
        <% if(request.getAttribute("error") != null){%>
        <%= request.getAttribute("error")%>
        <%}else{%>
        不正なアクセスです
        <%}%><br><br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
