package controller;

import dao.ReceitaDao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Receita;

public class ReceitaServlet extends HttpServlet {

    Receita receita = new Receita();

    public ReceitaServlet() {
        super();
    }

    // listar infos
    protected void listarInfos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        ReceitaDao dao = new ReceitaDao();
        ArrayList<Receita> list = dao.listar();
        request.setAttribute("listarInfos", list);
        RequestDispatcher rd = request.getRequestDispatcher("selectInfos.jsp");
        rd.forward(request, response);
        response.sendRedirect("selectInfos.jsp");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String autor, data, titulo, ingredientes, modopreparo;
        //InputStream imagem = null;
        autor = request.getParameter("autor");
        data = request.getParameter("data");
        titulo = request.getParameter("titulo");
        ingredientes = request.getParameter("ingredientes");
        modopreparo = request.getParameter("modopreparo");
        //imagem = request(imagem);
        Receita receita = new Receita(autor, data, titulo, ingredientes, modopreparo);
        ReceitaDao dao = new ReceitaDao();
        dao.inserir(receita);
        try ( PrintWriter out = response.getWriter()) {

            out.println("Cadastro realizado com sucesso");
            out.println("<a href='ReceitaServlet'> Voltar </a>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            listarInfos(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ReceitaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceitaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(ReceitaServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReceitaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private InputStream request(InputStream imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
