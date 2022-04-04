
package dao;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Receita;



public class ReceitaDao {
    
    private Connection conexao;
    private PreparedStatement preparar;
    private ResultSet resultado;
    private String SQL;
    
    public ReceitaDao() throws ClassNotFoundException, SQLException {
        conexao = new Conexao().getConexao();
    }
    
    
    
    public void inserir(Receita receita) throws SQLException{
        SQL = "insert into registro (autor,titulo,ingredientes,modopreparo,data,imagem) values (?,?,?,?,?,?)";
        
        
        
        preparar = conexao.prepareStatement(SQL);
        preparar.setString(1,receita.getAutor());
        preparar.setString(2,receita.getTitulo());
        preparar.setString(3,receita.getIngredientes());
        preparar.setString(4,receita.getModopreparo());
        preparar.setString(5,receita.getData());
       // preparar.setBlob(6,receita.getImagem());
        if (receita.getImagem() != null) {
                preparar.setBlob(3, receita.getImagem());
        }
        preparar.execute();
        preparar.close();
    }

    
    
}
