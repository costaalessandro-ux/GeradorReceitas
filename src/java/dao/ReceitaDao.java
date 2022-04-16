
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Receita;



public class ReceitaDao {
    
    private static Connection conexao;
    private static PreparedStatement preparar;
    private static ResultSet resultado;
    private static String SQL;
    
    public ReceitaDao() throws ClassNotFoundException, SQLException {
        conexao = new Conexao().getConexao();
    }
    
    public void inserir(Receita receita) throws SQLException{
        SQL = "insert into registro (autor,titulo,ingredientes,modopreparo,data) values (?,?,?,?,?)";
        
        preparar = conexao.prepareStatement(SQL);
        preparar.setString(1,receita.getAutor());
        preparar.setString(2,receita.getTitulo());
        preparar.setString(3,receita.getIngredientes());
        preparar.setString(4,receita.getModopreparo());
        preparar.setString(5,receita.getData());
       // preparar.setBlob(6,receita.getImagem());
       /*if (receita.getImagem() != null) {
                preparar.setBlob(3, receita.getImagem());
        }*/
        preparar.execute();
        preparar.close();
    }
    
    
    public ArrayList<Receita> listar(){
        ArrayList<Receita> list = new ArrayList<>();
        SQL = "SELECT * FROM registro orde by autor;";
        
        try{
        preparar = conexao.prepareStatement(SQL);
        
        resultado = preparar.executeQuery();
        
        while(resultado.next()){
            //Integer id = resultado.getInt(1); 
            String autor = resultado.getString(2); 
            String data = resultado.getString(3);
            String titulo = resultado.getString(4); 
            String ingredientes = resultado.getString(5); 
            String modopreparo = resultado.getString(6); 
            list.add(new Receita(autor,data,titulo,ingredientes,modopreparo));
        }
        conexao.close();
        return list;
    }catch(SQLException e){
       System.out.println(e);
       return null;         
    }
    
    
    }
}
