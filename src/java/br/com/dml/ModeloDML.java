/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dml;

import br.com.conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import br.com.javabens.BeansCEF;

/**
 *
 * @author Luiz Carlos
 */
public class ModeloDML {
    private Connection connection;
    public static Vector<BeansCEF> usuarios = new Vector();
    public ModeloDML () throws SQLException {
        this.connection = new Conexao().conectarBanco();
    }
     
    public void inserirProduto(BeansCEF beans) throws ClassNotFoundException{
       try {
           PreparedStatement pst;
           pst = connection.prepareStatement("insert into cadastroProduto(nomeProduto,entrada,saida,estoque) values (?,?,?,?)");
           pst.setString(1, beans.getNomeProduto());
           pst.setInt(2, beans.getEntrada());
           pst.setInt(3, beans.getSaida());
           pst.setInt(4, beans.getEstoque());
           
           pst.execute();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }
   
    public void atualizarPessoa(BeansCEF beans){
       try {
           PreparedStatement pst;
           pst = connection.prepareStatement("update cadastroProduto set nomeProduto=?, entrada=?, saida=?, estoque=? where id_produto = ?");
           pst.setString(1, beans.getNomeProduto());
           pst.setInt(2, beans.getEntrada());
           pst.setInt(3, beans.getSaida());
           pst.setInt(4, beans.getEstoque());
           pst.setInt(5, beans.getId_produto());
           pst.execute();
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
    }

    public  BeansCEF carregarUmaPessoa(BeansCEF beans){
       try {
           PreparedStatement pst = connection.prepareStatement("select * from cadastroPessoa where id_produto = ?");
           pst.setInt(1, beans.getId_produto());
           ResultSet rs = pst.executeQuery();
           rs.next();
           beans.setNomeProduto(rs.getString("nomeProduto"));
           beans.setEntrada(rs.getInt("entrada"));
           beans.setSaida(rs.getInt("saida"));
            beans.setSaida(rs.getInt("estoque"));
           beans.setId_produto(rs.getInt("id_produto"));
           return beans;
       } catch (SQLException e) {
           System.out.println(e.getMessage());
           return null;
       }
   }

   public List<BeansCEF> carregarTodasPessoas(){
  
      List<BeansCEF> beanscef = new ArrayList<BeansCEF>();
      //fechar método close
      try {
         Statement st = connection.createStatement(); 
         ResultSet rs = st.executeQuery("select * from cadastroPessoa"); 
         while (rs.next()){
	    BeansCEF beans= new BeansCEF();
	    beans.setId_produto(rs.getInt("id_produto"));
            beans.setNomeProduto(rs.getString("nomeProduto"));
	    beans.setEntrada(rs.getInt("entrada"));
	    beans.setSaida(rs.getInt("saida"));;
	    beans.setEstoque(rs.getInt("estoque"));;
            usuarios.add(beans);
	 }
         rs.close();
      } catch(SQLException e) {
	 System.out.println(e.getMessage());
      }
     return usuarios;
   }
   
  public void excluir(BeansCEF beans) {
     try{   
            String sql ="delete from cadastroPessoa where id_produto=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1,  beans.getId_produto());
            stmt.execute();
            stmt.close();
        } catch(SQLException e) {
            throw new RuntimeException(e);
     }
    
}
}
