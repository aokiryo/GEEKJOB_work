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

/**
 *
 * @author ryo
 */
public class MySQL13_loginCheck extends HttpServlet {

    static Connection db_con = null;
    static PreparedStatement db_st = null;
    static ResultSet db_data = null;
    static ArrayList<String> checker = new ArrayList<String>();
    static MySQL13_beans data = new MySQL13_beans();

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
        HttpSession s = request.getSession(false);
        if (s == null) {
            response.sendRedirect("MySQL13_login.jsp");
        } else {
        try (PrintWriter out = response.getWriter()) {
            //ログイン情報保持セッション

            //名前エンコード用
            request.setCharacterEncoding("UTF-8");

            //ユーザー情報取得
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            //配列としてセッションに格納
            checker.add(userName);
            checker.add(password);

            //セッションに登録
            s.setAttribute("login", checker);

            //保持期間は1時間
            s.setMaxInactiveInterval(3600);

            //ログイン成否（DBアクセス）
            //パス
            final String loginSuccess = "WEB-INF/jsp/MySQL13_productOperation.jsp";
            final String loginFaile = "MySQL13_login.jsp";

            //ドライバ選択
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //コネクタ生成・接続
            db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "ryo", "bluerose");

            //検索対象はフォームから取得
            String searchUser = "SELECT * FROM userinfo WHERE name ='" + userName + "' AND password ='" + password + "'";

            //検索結果取得
            db_st = db_con.prepareStatement(searchUser);

            db_data = db_st.executeQuery();

            

            if (!userName.equals("") && !password.equals("")) {
                if (db_data.next() != false) {
                    //ログイン成功時処理
                    data.setLog(true);
                    request.setAttribute("DATA", data);
                    RequestDispatcher rd = request.getRequestDispatcher(loginSuccess);
                    rd.forward(request, response);
                } else {
                    //ログイン失敗時処理
//                    data.setLog(false);
//                    request.setAttribute("DATA", data);
//                    RequestDispatcher rd = request.getRequestDispatcher(loginFaile);
//                    rd.forward(request, response);
                    response.sendRedirect("MySQL13_login.jsp");
                }
            } else {
//                data.setLog(false);
//                request.setAttribute("DATA", data);
//                RequestDispatcher rd = request.getRequestDispatcher(loginFaile);
//                rd.forward(request, response);
                response.sendRedirect("MySQL13_login.jsp");

            }

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
