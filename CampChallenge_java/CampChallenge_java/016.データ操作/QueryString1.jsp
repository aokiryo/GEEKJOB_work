<%-- 
    Document   : QueryString1
    Created on : 2018/04/11, 14:20:08
    Author     : ryo
--%>

<%@page import="java.lang.Math"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
            String product = request.getParameter("type");
            int p = Integer.parseInt(product);

            //処理内容1
            out.print("購入した商品は");
            switch (p) {
                case 1:
                    out.print("雑貨<br>");
                    break;

                case 2:
                    out.print("生鮮食品<br>");
                    break;

                case 3:
                    out.print("その他<br>");
                    break;
            }

            //処理内容2
            //小数点以下は四捨五入
            int price = 0;
            String total = request.getParameter("total");
            double t = Integer.parseInt(total);
            String count = request.getParameter("count");
            int c = Integer.parseInt(count);
            price = (int) Math.round(t / c);

            out.print("購入商品の単価は" + price + "円<br>");

            //処理内容3
            //ポイントの計算で小数点以下が出た場合は切り捨て
            int point = 0;
            if (t < 3000) {
                out.print("ポイントの付与はありません");
            } else if (3000 <= t && t < 5000) {
                point = (int) Math.floor(t * 0.04);
                out.print(point + "ポイント付与されました");
            } else if (5000 <= t) {
                point = (int) Math.floor(t * 0.05);
                out.print(point + "ポイント付与されました");
            }
        %>
    </body>
</html>
