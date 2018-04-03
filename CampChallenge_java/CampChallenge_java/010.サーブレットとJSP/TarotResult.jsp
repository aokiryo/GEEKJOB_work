<%-- 
    Document   : TarotResult
    Created on : 2018/03/30, 16:04:46
    Author     : ryo
--%>

<%@page import="org.camp.servlet.TarotBeans"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%
            TarotBeans data = (TarotBeans) request.getAttribute("DATA");
        %>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (data != null) {

                //正位置の方が悪い意味になるカード
                ArrayList<String> list = new ArrayList<String>();
                list.add("死神");
                list.add("悪魔");
                list.add("月");

                //結果
                String oracle;

                int arc;
                int pos;
                
                //"塔"のカードは位置によらず凶兆
                if (data.getArcana().equals("塔")) {
                    oracle = "凶兆";
                }

                if (list.contains(data.getArcana())) {
                    arc = 0;
                } else {
                    arc = 1;
                }

                if (data.getPosition().equals("正位置")) {
                    pos = 0;
                } else {
                    pos = 1;
                }

                if (arc == 0 && pos == 0) {
                    oracle = "凶兆";
                } else if (arc == 0 && pos == 1) {
                    oracle = "吉兆";
                } else if (arc == 1 && pos == 0) {
                    oracle = "吉兆";
                } else {
                    oracle = "凶兆";
                }

                out.print("<h1><center>啓示されたカードは『" + data.getArcana() + "』の『"
                        + data.getPosition() + "』</center><h1><br>");
                out.print("<h1><center>これは『" + oracle + "』を意味する</center><h1><br>");

            }


        %>
    </body>
</html>
