<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Receita"%>
<%@page import="java.util.ArrayList"%>


<%
    ArrayList<Receita> list = (ArrayList<Receita>) 
    request.getAttribute("listarInfos");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerador de Receitas</title>
    </head>
    <body>
        <h1>Select Infos</h1>
        <table>
            <thead>
                <tr>
                    <th>Autor</th>
                    <th>Data</th>
                    <th>Titulo</th>
                    <th>Ingredientes</th>
                    <th>Modo de Preparo</th>
                </tr>
            </thead>
            
            <tbody>
             <% for(int i = 0; i < list.size(); i++) {%>
                <tr>
                    <td><%=list.get(i).getAutor()%></td>
                    <td><%=list.get(i).getData()%></td>
                    <td><%=list.get(i).getTitulo()%></td>
                    <td><%=list.get(i).getIngredientes()%></td>
                    <td><%=list.get(i).getModopreparo()%></td>
                </tr>
                <%}%>
            </tbody>
            
        </table>
            <a href="index.html">VOLTAR</a>
    </body>
</html>
