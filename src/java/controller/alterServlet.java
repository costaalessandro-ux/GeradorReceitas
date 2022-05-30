package controller;

import dao.ReceitaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Receita;

public class alterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
            
            String autor = request.getParameter("autor");
            Receita receita = new Receita();
            ReceitaDao dao = new ReceitaDao();
            receita.setAutor(autor);       
            dao.alterSelect(receita);
            
            /*
            System.out.println(receita.getAutor());
            System.out.println(receita.getData());
            System.out.println(receita.getTitulo());
            System.out.println(receita.getIngredientes());
            System.out.println(receita.getModopreparo());
            */
            
            
           
            request.setAttribute("autor", receita.getAutor());
            request.setAttribute("data", receita.getData());
            request.setAttribute("titulo", receita.getTitulo());
            request.setAttribute("ingredientes", receita.getIngredientes());
            request.setAttribute("modopreparo", receita.getModopreparo());
            RequestDispatcher rd = request.getRequestDispatcher("formAlter.jsp");
            rd.forward(request, response);
           


        }
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(alterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(alterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(alterServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(alterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }


