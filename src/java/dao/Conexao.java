
package dao;

//será utilizado com postgres!
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {

// utilizando mysql;
private Connection conexao;
private final String DRIVER="jdbc:mysql://localhost:3306/receita?zeroDateTimeBehavior=convertToNull"; // driver para comunicar com java
private final String SERVER="localhost"; // nome do servidor ou ip
private final String USER="root"; // usuário do mysql
private final String PORTA="3306"; // porta do mysql
private final String SENHA=""; //senha usada na instalação do banco de dados
private final String CLASSDRIVER="com.mysql.jdbc.Driver";

public Connection getConexao() throws ClassNotFoundException, SQLException{
Class.forName(CLASSDRIVER);
conexao = DriverManager.getConnection(DRIVER,USER,SENHA);
return conexao;
}


}
