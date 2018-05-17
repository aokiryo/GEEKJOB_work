package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        PrintWriter out = response.getWriter();

        //セッションスタート
        HttpSession session = request.getSession();

        try {
            request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

            //アクセスルートチェック
            String accesschk = request.getParameter("acc");
            if (accesschk == null || (Integer) session.getAttribute("acc") != Integer.parseInt(accesschk)) {
                throw new Exception();
            }

            UserDataBeans udb = new UserDataBeans();

            udb.setName(request.getParameter("name"));
            udb.setYear(request.getParameter("year"));
            udb.setMonth(request.getParameter("month"));
            udb.setDay(request.getParameter("day"));
            udb.setType(request.getParameter("type"));
            udb.setTell(request.getParameter("tell"));
            udb.setComment(request.getParameter("comment"));

            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO userdata = new UserDataDTO();
            udb.UD2DTOMapping(userdata);

            //更新するレコードのuserIDを指定
            UserDataDTO ud = (UserDataDTO) session.getAttribute("resultdetail");
            userdata.setUserID(ud.getUserID());

            //DBへデータの挿入
            UserDataDAO.getInstance().update(userdata);

            //結果画面での表示用に入力パラメータ―をリクエストパラメータとして保持
            request.setAttribute("udb", udb);

            //詳細画面に戻った時のためセッションにも保存
            session.setAttribute("resultdetail", UserDataDAO.getInstance().searchByID(userdata));
            
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("error", "データベースとの接続エラーです");
            System.out.print(ex.getStackTrace());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } catch (Exception ex) {
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", "不正なアクセスです");
            System.out.print(ex.getStackTrace());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        } finally {
            out.close();
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
