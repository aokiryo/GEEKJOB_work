/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import static org.camp.servlet.MySQL13_loginCheck.data;

/**
 *
 * @author ryo
 */
public class MySQL13_productRequest extends HttpServlet {

    static Connection db_con = null;
    static PreparedStatement db_st = null;
    static ResultSet db_data = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession s = request.getSession();
            Object status = s.getAttribute("login");
            if (status == null) {
                response.sendRedirect("MySQL13_login.jsp");
            }

            //名前エンコード用
            request.setCharacterEncoding("UTF-8");

            //ドライバ選択
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //コネクタ生成・接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ryo", "bluerose");

            //登録情報はフォームから取得
            String getProductInfo = "SELECT * FROM productinfo";

            //検索結果取得
            db_st = db_con.prepareStatement(getProductInfo);

            db_data = db_st.executeQuery();

            db_data.next();

            for (int i = 1; i < db_data.getRow() + 1; i++) {

                ArrayList<String> pInfo = new ArrayList<String>();

                pInfo.add(String.valueOf(db_data.getInt("ID")));
                pInfo.add(db_data.getString("name"));
                pInfo.add(db_data.getString("category"));
                pInfo.add(String.valueOf(db_data.getInt("price")));

                data.setProducts(pInfo);

                if (i < db_data.getRow() + 1) {
                    db_data.next();
                }
            }

            request.setAttribute("DATA", data);

            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/MySQL13_productView.jsp");
            rd.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("コネクタが見つかりません");
        } catch (InstantiationException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("コネクタを生成できませんでした");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("不正な接続です");
        } catch (SQLException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("データベースとの交信に失敗しました");
        } finally {
            try {
                //ファイルクローズ
                db_st.close();
                db_con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("ファイルをクローズできませんでした");
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
