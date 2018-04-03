/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ryo
 */
public class Tarot extends HttpServlet {

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
            final String result = "/WEB-INF/jsp/TarotResult.jsp";

            //アルカナ一覧
            String arcana[] = {"愚者", "魔術師", "女教皇", "女帝", "皇帝", "教皇",
                 "恋人", "戦車", "力", "隠者", "運命の輪", "正義", "吊るされた男",
                 "死神", "節制", "悪魔", "塔", "星", "月", "太陽", "審判", "世界"};
            
            //位置
            String position[] = {"正位置", "逆位置"};
            
            //抽選
            Random rand1 = new Random();
            Integer index1 = rand1.nextInt(arcana.length);
            
            Random rand2 = new Random();
            Integer index2 = rand2.nextInt(position.length);
            
            //アルカナと位置の情報
            TarotBeans data = new TarotBeans();
            data.setArcana(arcana[index1]);
            data.setPosition(position[index2]);
            request.setAttribute("DATA", data);
                        
            RequestDispatcher rd = request.getRequestDispatcher(result);
            rd.forward(request, response);

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
