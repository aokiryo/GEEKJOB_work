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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ryo
 */
public class MySQL13_productRegistration extends HttpServlet {

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

            //登録する商品情報
            int pID = Integer.valueOf(request.getParameter("pID"));
            String pName = request.getParameter("pName");
            String pCategory = request.getParameter("pCategory");
            int pPrice = Integer.valueOf(request.getParameter("pPrice"));

            //ドライバ選択
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //コネクタ生成・接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ryo", "bluerose");

            //登録情報はフォームから取得
            String productInfo = "INSERT INTO productinfo VALUES(" + pID + ",'" + pName + "','" + pCategory + "'," + pPrice + ")";

            //登録SQL文発行
            db_st = db_con.prepareStatement(productInfo);

            //実行
            db_st.executeUpdate();

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/MySQL13_productOperation.jsp");
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
