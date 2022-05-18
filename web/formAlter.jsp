<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Receita"%>
<%@page import="java.util.ArrayList"%>
<%
    
    Receita receita = new Receita(); 
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
       <div class="container">
            <div class="text-center">
                <div class="mb-3">
                    <form action="insertServlet" enctype="multipart/form-data" >
                        <label for="autor">Autor</label><p>
                        <input type="text" id="autor" name="autor" value="<%=receita.getAutor()%>"><p>
                            <label for="data">Data</label><p>
                        <input type="date" id="data" name="data"><p>
                            <label for="titulo">Titulo</label><p>
                        <input type="text" id="titulo" name="titulo"><p>
                            <label for="ingredientes">Ingredientes</label><p>
                            <textarea id="ingredientes" name="ingredientes" rows="8" cols="35"></textarea><p>
                            <label for="modopreparo">Modo de Preparo</label><p>
                            <textarea id="modopreparo" name="modopreparo" rows="8" cols="35"></textarea><p>
                            <label for="imagem">Imagem</label><p>
                        <input type="file" id="imagem" name="imagem"><p> 
                            <input type="submit" id="adicionar" name="adicionar" value="Adicionar">
                            <input type="reset" id="cancelar" name="cancelar" value="Cancelar">
                    </form>
                    <p><a href="ReceitaServlet"/> Lista de Receitas </a></p>
                        <p> <a href="index.html"/> Voltar </a></p>
                </div>
            </div>
        </div>
    </body>
</html>
