package com.example;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class Register implements Serializable {

    private static final long serialVersionUID = 1L;
    private User user;

    @PostConstruct
    public void init() {
        user = new User();
    }
    
    public void submit() {
        FacesMessage message = new FacesMessage("Registration succesful!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public User getUser() {
        return user;
    }
}