<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Receita"%>
<%@page import="java.util.ArrayList"%>
<%
    ArrayList<Receita> list = (ArrayList<Receita>) request.getAttribute("listarInfos");
%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="./assets/styles/style.css" type="text/css"/>
        <title>Gerador de Receitas</title>
    </head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand">Gerador de Receitas</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="index.html">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ReceitaServlet">Lista de Receita</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="gerador.html">Criar Receitas</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <body>
        <div class="container color-black">
            <div class="card w-100 my-5">
                <div class="card card-center" style="width: 18rem;">
                    <% for (int i = 0; i < list.size(); i++) {%>
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title"><h4><%=list.get(i).getTitulo()%></h4>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><h6>Ingredientes:</h6><%=list.get(i).getIngredientes()%></li>
                        <li class="list-group-item"><h6>Modo de Preparo:</h6><%=list.get(i).getModopreparo()%></li>
                        <li class="list-group-item"><h6>Modo de Preparo:</h6><%=list.get(i).getId()%></li>
                        <li class="list-group-item"><h6>Autor:</h6><%=list.get(i).getAutor()%></li>
                        <li class="list-group-item"><h6>Data de Criação:</h6><%=list.get(i).getData()%></li>
                    </ul>
                    <div class="card-body">
                        <a href="javascript:confirmaAlteracao(<%=list.get(i).getId()%>)" class="card-link">ALTERAR</a>
                        <a href="javascript:confirmaExclusao(<%=list.get(i).getId()%>)" class="card-link">EXCLUIR</a>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
        <a href="index.html">VOLTAR</a></p>
    <script src="assets/js/confirmacao.js" type="text/javascript"></script>
</body>
</html>