<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Receita"%>
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
                    <form action="updateInfos" enctype="multipart/form-data" >
                        <label for="autor">Autor</label><p>
                        <input type="text" id="autor" name="autor" value="<%out.print(request.getAttribute("autor"));%>"><p>
                            <label for="data">Data</label><p>
                        <input type="date" id="data" name="data" value="<%out.print(request.getAttribute("data"));%>" ><p>
                            <label for="titulo">Titulo</label><p>
                        <input type="text" id="titulo" name="titulo" value="<%out.print(request.getAttribute("titulo"));%>"><p>
                            <label for="ingredientes">Ingredientes</label><p>
                            <textarea id="ingredientes" name="ingredientes" rows="8" cols="35" ><%out.print(request.getAttribute("ingredientes"));%></textarea><p>
                            <label for="modopreparo">Modo de Preparo</label><p>
                            <textarea id="modopreparo" name="modopreparo"  rows="8" cols="35"><%out.print(request.getAttribute("modopreparo"));%> </textarea><p>
                           
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
