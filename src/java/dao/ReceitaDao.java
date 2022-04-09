
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    
    public static List<Receita> listar() throws SQLException{
        List<Receita> vetorReceita = new ArrayList<>();
        SQL = "SELECT * FROM registro;";
        
        preparar = conexao.prepareStatement(SQL);
        
        resultado = preparar.executeQuery();
        
        while(resultado.next()){
            Receita receita = new Receita();
            receita.setId(resultado.getInt("id")); 
            receita.setTitulo(resultado.getString("titulo"));
            receita.setAutor(resultado.getString("autor"));
            receita.setIngredientes(resultado.getString("ingredientes"));
            receita.setModopreparo(resultado.getString("modopreparo"));
            vetorReceita.add(receita);
        }
        return vetorReceita;
    }
    
    
    
    
}
