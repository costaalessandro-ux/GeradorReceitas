
package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
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
        SQL = "insert into registro (autor,titulo,ingredientes,modopreparo) values (?,?,?,?)";
    
        preparar = conexao.prepareStatement(SQL);
        preparar.setString(1,receita.getAutor());
        preparar.setString(2,receita.getTitulo());
        preparar.setString(3,receita.getIngredientes());
        preparar.setString(4,receita.getModopreparo());
        //preparar.setDate(5,(Date)receita.getData());
        //preparar.setFile(6,receita.getImagem());
        preparar.execute();
        preparar.close();
    }
    
    
}