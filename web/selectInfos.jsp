<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Receita"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Receita> list = (ArrayList<Receita>) request.getAttribute("listarInfos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerador de Receitas</title>
    </head>
    <body>
        <h1>Lista de Receitas</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Autor</th>
                    <th>Data</th>
                    <th>Titulo</th>
                    <th>Ingredientes</th>
                    <th>Modo de Preparo</th>
                    <th colspan=\"2\">Ações</th>
                </tr>
            </thead>
            <tbody>
                <% for (int i = 0; i < list.size(); i++) {%>
                <tr>
                    <td><%=list.get(i).getId()%></td>
                    <td><%=list.get(i).getAutor()%></td>
                    <td><%=list.get(i).getData()%></td>
                    <td><%=list.get(i).getTitulo()%></td>
                    <td><%=list.get(i).getIngredientes()%></td>
                    <td><%=list.get(i).getModopreparo()%></td>
                    <td><a href="alterServlet?id=<%=list.get(i).getId()%>">ALTERAR</a></td>
                    <td><a href="javascript:confirmaExclusao(<%=list.get(i).getId()%>)" class="botao1">EXCLUIR</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <p>
            <a href="index.html">VOLTAR</a></p>
        <script src="assets/confirmacao.js" type="text/javascript"></script>
    </body>
</html>
