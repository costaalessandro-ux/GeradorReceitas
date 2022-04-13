<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Receita" %>
<%
  ArrayList<Receita> list = (ArrayList<Receita>)request.getAttribute("list");
  for (int i = 1; i < list.size(); i++){
  
      out.println(list.get(i).getTitulo());
      out.println(list.get(i).getData());
      out.println(list.get(i).getAutor());
      out.println(list.get(i).getIngredientes());
      out.println(list.get(i).getModopreparo());
}
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   <% for (int i = 1; i < list.size(); i++){%>
  
      out.println(list.get(i).getTitulo());
      out.println(list.get(i).getData());
      out.println(list.get(i).getAutor());
      out.println(list.get(i).getIngredientes());
      out.println(list.get(i).getModopreparo());
    <%}%>
        <h1>Hello World!</h1>
    </body>
</html>
