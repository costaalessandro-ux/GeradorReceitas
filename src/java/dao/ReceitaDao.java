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

    public void inserir(Receita receita) throws SQLException {
        SQL = "insert into registro (autor,data,titulo,ingredientes,modopreparo) values (?,?,?,?,?)";

        preparar = conexao.prepareStatement(SQL);
        //preparar.setInt(1,Integer.parseInt(receita.getAutor()));
        preparar.setString(1, receita.getAutor());
        preparar.setString(2, receita.getData());
        preparar.setString(3, receita.getTitulo());
        preparar.setString(4, receita.getIngredientes());
        preparar.setString(5, receita.getModopreparo());
        preparar.execute();
        preparar.close();
    }

    public ArrayList<Receita> listar() {
        ArrayList<Receita> list = new ArrayList<>();
        SQL = "SELECT * FROM registro order by id;";

        try {
            preparar = conexao.prepareStatement(SQL);

            resultado = preparar.executeQuery();

            while (resultado.next()) {
                Integer id = resultado.getInt(1);
                String autor = resultado.getString(2);
                String data = resultado.getString(3);
                String titulo = resultado.getString(4);
                String ingredientes = resultado.getString(5);
                String modopreparo = resultado.getString(6);
                list.add(new Receita(id, autor, data, titulo, ingredientes, modopreparo));
            }
            conexao.close();
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void alterSelect(Receita receita) {
        SQL = "select * from registro where id = ?";
        try {
            preparar = conexao.prepareStatement(SQL);
            preparar.setInt(1, receita.getId());
            resultado = preparar.executeQuery();
            while (resultado.next()) {
                receita.setAutor(resultado.getString(2));
                receita.setData(resultado.getString(3));
                receita.setTitulo(resultado.getString(4));
                receita.setIngredientes(resultado.getString(5));
                receita.setModopreparo(resultado.getString(6));
            }
            conexao.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void alter(Receita receita) throws SQLException {
        SQL = "update registro set autor=?,data=?,titulo=?,ingredientes=?,modopreparo=? where id=?";
        try {
            preparar = conexao.prepareStatement(SQL);
            preparar.setString(1, receita.getAutor());
            preparar.setString(2, receita.getData());
            preparar.setString(3, receita.getTitulo());
            preparar.setString(4, receita.getIngredientes());
            preparar.setString(5, receita.getModopreparo());
            preparar.setInt(6, receita.getId());
            preparar.executeUpdate();
            conexao.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(Receita receita) throws SQLException {
        SQL = "delete from registro where id=?";
        preparar = conexao.prepareStatement(SQL);
        preparar.setInt(1, receita.getId());
        preparar.execute();
        preparar.close();
    }

}
