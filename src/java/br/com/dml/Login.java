/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dml;

import br.com.conexao.Conexao;
import br.com.javabens.BeansCEF;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Luiz Carlos
 */
public class Login {
    private Connection connection;
    public static Vector<BeansCEF> usuarios = new Vector();
    public Login() throws SQLException {
        this.connection = new Conexao().conectarBanco();
    }
    
    
    public void cadastroLogin(BeansCEF beans) throws ClassNotFoundException{  
         try {
                String sql = "insert into contaCadastro(login,senha)values(?,?)";
                // prepared statement para inserção
                PreparedStatement stmt = connection.prepareStatement(sql);
                // seta os valores

                stmt.setString(1,beans.getLogin());

                stmt.setString(2,beans.getSenha());

                // executa

                stmt.execute();

                stmt.close();

            } catch (SQLException e) {

                    throw new RuntimeException(e);
            }
    }
    
      
    public void alterarLogin(BeansCEF beans){
       try {
           PreparedStatement pst;
           pst = connection.prepareStatement("update contaCadastro set login=?, senha=? where login=? and senha=?");
           pst.setString(1, beans.getLogin());
           pst.setString(2, beans.getSenha());
           
           pst.execute();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }
    
    
    public void remove(BeansCEF beans){
        try {
                PreparedStatement stmt = connection.prepareStatement("delete from contatos where login=? and senha=?");
                stmt.setString(1, beans.getLogin());
                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
        
            }
    }   

}
