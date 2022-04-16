<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Receita"%>
<%@page import="java.util.ArrayList"%>


<%
    ArrayList<Receita> list = (ArrayList<Receita>) 
    request.getAttribute("list");
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Dados</h1>
        <table>
            <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Data</th>
                    <th>Autor</th>
                    <th>Ingredientes</th>
                    <th>Modo Preparo</th>
                </tr>
            </thead>
            <tbody>
             <%for (int i = 0; i < list.size(); i++) {%>
                <tr>
                    <td><%=list.get(i).getTitulo()%></td>
                    <td><%=list.get(i).getData()%></td>
                    <td><%=list.get(i).getAutor()%></td>
                    <td><%=list.get(i).getModopreparo()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
