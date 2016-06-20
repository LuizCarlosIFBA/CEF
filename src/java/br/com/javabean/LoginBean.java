/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javabean;

import br.com.dml.Login;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luiz Carlos
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    private BeanCEF beanscef = new BeanCEF();
    private List<BeanCEF> beans = new ArrayList<BeanCEF>();
    
    public void adicionarUsuario() throws ClassNotFoundException{ 
        try {
            beans.add(beanscef);
            new Login().cadastroLogin(beanscef);
            beanscef = new BeanCEF();  
        } catch (SQLException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void listarUsuario(){
        Login login;
        try {
            login = new Login();
            login.consultarUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public BeanCEF getBeanscef() {
        return beanscef;
    }

    public void setBeanscef(BeanCEF beanscef) {
        this.beanscef = beanscef;
    }

    public List<BeanCEF> getBeans() {
        return beans;
    }

    public void setBeans(List<BeanCEF> beans) {
        this.beans = beans;
    }
    
    
}
