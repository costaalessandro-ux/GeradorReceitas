

function confirmaExclusao(id){
    let opcao = confirm("Deseja excluir essa Receita ?");
    if(opcao===true){
       window.location.href= "deleteServlet?id=" + id;
    }  
}

