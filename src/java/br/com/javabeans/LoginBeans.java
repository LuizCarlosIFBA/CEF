/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.javabeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Luiz Carlos
 */
@ManagedBean
public class LoginBeans {
    private BeansCEF beanscef = new BeansCEF();
    private List<BeansCEF> beans = new ArrayList<>();
    
    public void adicionarUsuario(){
        beans.add(beanscef);
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
