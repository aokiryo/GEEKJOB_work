<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();

    //1件の検索結果はセッションに保存
    UserDataDTO udd = (UserDataDTO) request.getAttribute("resultData");
    
    if(udd != null){
    session.setAttribute("resultdetail", udd);
    }else{
    udd = (UserDataDTO)session.getAttribute("resultdetail");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMSユーザー情報詳細画面</title>
    </head>
    <body>
        <h1>詳細情報</h1>
        名前:<%= udd.getName()%><br>
        生年月日:<%= udd.getBirthday()%><br>
        種別:<%= udd.getType()%><br>
        電話番号:<%= udd.getTell()%><br>
        自己紹介:<%= udd.getComment()%><br>
        登録日時:<%= udd.getNewDate()%><br>

        <form action="Update" method="POST">
            <input type="hidden" name="acc"  value="<%= session.getAttribute("acc")%>">
            <input type="submit" name="update" value="更新"style="width:100px">
        </form>
        <form action="Delete" method="POST">
            <input type="hidden" name="acc"  value="<%= session.getAttribute("acc")%>">
            <input type="submit" name="delete" value="削除"style="width:100px">
        </form>
        <form action="./searchresult.jsp" method="POST">
            <input type="submit" name="return" value="検索結果へ戻る">
        </form>
    </body>
    <%=jh.home()%>
</html>
