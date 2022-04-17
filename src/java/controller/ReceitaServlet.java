package controller;

import dao.ReceitaDao;
import dao.Conexao;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.System.out;
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

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReceitaServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            /*Para fiz de testes não inclui a variavel imagem e Data;
               É necessario inserir a varial de imagem  e data posteriormente;
            */
            String autor, data, titulo, ingredientes, modopreparo;
            //InputStream imagem = null;
            autor = request.getParameter("autor");
            data = request.getParameter("data");
            titulo = request.getParameter("titulo");
            ingredientes = request.getParameter("ingredientes");
            modopreparo = request.getParameter("modopreparo");
            //imagem = request(imagem);
            Receita receita = new Receita(autor,data,titulo, ingredientes,modopreparo);
            ReceitaDao dao = new ReceitaDao();
            dao.inserir(receita);
            out.print("Gravado com sucesso!");
            out.print("<a href='gerador.html'>VOLTAR</a>");
            out.println("</body>");
            out.println("</html>");
        }  
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReceitaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ReceitaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

    private InputStream request(InputStream imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}

    
