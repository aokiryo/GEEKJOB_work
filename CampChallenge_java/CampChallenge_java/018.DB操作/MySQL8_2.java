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

/**
 *
 * @author ryo
 */
public class MySQL8_2 extends HttpServlet {

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

            //パス
            final String result = "WEB-INF/jsp/MySQL8_4.jsp";

            //検索対象
            String search = request.getParameter("searchN");

            //ドライバ選択
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            //コネクタ生成・接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ryo", "bluerose");

            //検索対象はHTMLのフォームから取得
            String searchText = "SELECT * FROM profiles WHERE name LIKE '%" + search + "%'";

            //部分一致検索
            db_st = db_con.prepareStatement(searchText);
            
            //検索結果取得
            db_data = db_st.executeQuery();
            
            //beansのインスタンス生成
            MySQL8_3 data = new MySQL8_3();

            while (db_data.next()) {
                data.setProfilesID(db_data.getInt("profilesID"));
                data.setName(db_data.getString("name"));
                data.setTel(db_data.getString("tel"));
                data.setAge(db_data.getInt("age"));
                data.setBirthday(db_data.getString("birthday"));
            }

            request.setAttribute("DATA", data);

            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //ファイルクローズ
                db_st.close();
                db_con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MySQL8_2.class.getName()).log(Level.SEVERE, null, ex);
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
