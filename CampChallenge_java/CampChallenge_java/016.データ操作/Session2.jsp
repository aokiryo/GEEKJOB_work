<%-- 
    Document   : Session2
    Created on : 2018/04/13, 11:23:57
    Author     : ryo
--%>

<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formcatch</title>
    </head>
    <body>
        <%
            String defaultName = "";
            String defaultSexM = "";
            String defaultSexF = "";
            String defaultHobby = "";
            Cookie[] cs = request.getCookies();
            if (cs != null) {
                for (int i = 0; i < cs.length; i++) {
                    String cookieName = cs[i].getName();
                    if (cookieName.equals("Name")) {
                        String cookieN = cs[i].getValue();
                        String decodedName = URLDecoder.decode(cookieN, "UTF-8");
                        defaultName = decodedName;
                    } else if (cookieName.equals("Sex")) {
                        if (cs[i].getValue().equals("Male")) {
                            defaultSexM = "checked";
                        } else {
                            defaultSexF = "checked";
                        }
                    } else if (cookieName.equals("Hobby")) {
                        String cookieH = cs[i].getValue();
                        String decodedHobby = URLDecoder.decode(cookieH, "UTF-8");
                        defaultHobby = decodedHobby;
                    }
                }
            }
        %>
        <form action="./Session2.jsp" method="post">
            名前 : <input type="text" name="txtName" value="<%= defaultName%>"><br>
            性別 : <input type="radio" name="radSex" value="Male" <%= defaultSexM%>>男
            <input type="radio" name="radSex" value="Female" <%= defaultSexF%>>女<br>
            趣味 : <input type="text" name="txtHobby" value="<%= defaultHobby%>"><br>
            <input type="submit" name="btnSubmit" value="送信">
        </form>
        <%
            request.setCharacterEncoding("UTF-8");
            if (request.getParameter("txtName") != null) {
                String encodedName = URLEncoder.encode(request.getParameter("txtName"), "UTF-8");
                Cookie cName = new Cookie("Name", encodedName);
                cName.setMaxAge(3600);
                response.addCookie(cName);
            }
            if (request.getParameter("radSex") != null) {
                Cookie cSex = new Cookie("Sex", request.getParameter("radSex"));
                cSex.setMaxAge(3600);
                response.addCookie(cSex);
            }
            if (request.getParameter("txtHobby") != null) {
                String encodedHobby = URLEncoder.encode(request.getParameter("txtHobby"), "UTF-8");
                Cookie cHobby = new Cookie("Hobby", encodedHobby);
                cHobby.setMaxAge(3600);
                response.addCookie(cHobby);
            }

        %>
    </body>
</html>
