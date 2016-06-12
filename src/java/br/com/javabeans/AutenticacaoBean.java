/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javabeans;

import javax.faces.bean.ManagedBean;
/**
 *
 * @author Luiz Carlos
 */
public class AutenticacaoBean{
    private BeansCEF beans = new BeansCEF();
    
    public String doEfetuarLogin() {
    if("root".equals(beans.getLogin()) &&
       "123".equals(beans.getSenha())) {
      /* Se escrever o login e senha correto então vai para a tela principal do sistema. */
      return "TelaOpcoes";
    }

    //Caso erre o login ou senha fica na mesma tela.
    return null;
  }

  public BeansCEF getUsuario() {
    return beans;
  }

  public void setUsuario(BeansCEF beans) {
    this.beans = beans;
  }

}
