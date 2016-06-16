/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javabeans;

import br.com.dml.Login;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Luiz Carlos
 */
@ManagedBean
public class LoginBeans {
    private BeansCEF beanscef = new BeansCEF();
    private List<BeansCEF> beans = new ArrayList<>();
    
    public void adicionarUsuario() throws SQLException{
        Login login = new Login();
        try {      
            login.cadastroLogin(beanscef);
            beans.add(beanscef);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
        beanscef = new BeansCEF();
    }

    public BeansCEF getBeanscef() {
        return beanscef;
    }

    public void setBeanscef(BeansCEF beanscef) {
        this.beanscef = beanscef;
    }

    public List<BeansCEF> getBeans() {
        return beans;
    }

    public void setBeans(List<BeansCEF> beans) {
        this.beans = beans;
    }
    
    
}
