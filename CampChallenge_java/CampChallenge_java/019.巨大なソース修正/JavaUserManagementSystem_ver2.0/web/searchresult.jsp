<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();

    //他のページから戻ってきた時に参照する
    Object back = session.getAttribute("resultData");
    
    //検索結果
    ArrayList<UserDataDTO> udd = (ArrayList<UserDataDTO>) request.getAttribute("resultData");
    
    if (udd != null) {
        session.setAttribute("resultData", udd);
    } else if (udd == null && back != null) {
        udd = (ArrayList<UserDataDTO>) session.getAttribute("resultData");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>
            <%for (int i = 0; i < udd.size(); i++) {%>
            <tr>
                <td><a href="ResultDetail?id=<%= udd.get(i).getUserID()%>"><%= udd.get(i).getName()%></a></td>
                <td><%= udd.get(i).getBirthday()%></td>
                <td><%= udd.get(i).getType()%></td>
                <td><%= udd.get(i).getNewDate()%></td>
            </tr>
            <%}%>
        </table>
    </body>
    <%=jh.home()%>
</html>
