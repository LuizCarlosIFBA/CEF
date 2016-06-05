/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.conexao;

import java.sql.*;

/**
 *
 * @author Luiz Carlos
 */
public class Conexao {
    private static Connection con;  
   
    public static Connection conectarBanco() throws SQLException{ 
	
            try {     
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Estoque","root","1234");
                System.out.println("Conectado");
            } catch (ClassNotFoundException ex) {
                System.out.println("Erro "+ex);
            }
            
     
        return con;  
    }
}
