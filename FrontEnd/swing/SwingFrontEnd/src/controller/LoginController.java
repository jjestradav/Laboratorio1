/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Session;
import entity.Profesor;
import entity.Usuario;
import java.util.List;
import java.util.Optional;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import service.ServiceProfesor;
import service.ServiceUsuario;
import view.CiclosView;
import view.LoginView;
import viewmodel.LoginViewModel;

/**
 *
 * @author jonathan
 */
public class LoginController {
    
    private ServiceUsuario usuarioRepo=ServiceUsuario.getInstance();
    private ServiceProfesor profesRepo=ServiceProfesor.getInstance();
    private Session session= Session.getInstance();
    private LoginViewModel model;
    private LoginView view;
    
        public LoginController(LoginView view, LoginViewModel model) {        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
        
    public ServiceUsuario getUsuarioRepo() {
        return usuarioRepo;
    }

    public void setUsuarioRepo(ServiceUsuario usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public LoginViewModel getModel() {
        return model;
    }

    public void setModel(LoginViewModel model) {
        this.model = model;
    }
    
            
        public void login(Usuario typed) throws Exception{
        try{
            model.setCurrent(typed);
            Optional<Usuario> opt=this.usuarioRepo.getUsuario(typed);
            if(opt.isPresent()){
                Profesor profe= new Profesor();
                profe.setCedula(typed.getCedula());
                Optional<Profesor> optProfe= this.profesRepo.getProfesor(profe);
                if(!optProfe.isPresent())
                    throw new Exception();
                session.setAttibute("user", optProfe.get());
                CiclosController nextView=(CiclosController)session.getAttribute("cicloController");
                if(nextView!=null){
                    this.hide();
                    nextView.show();
                }
                    
            }
            else
                throw new Exception();
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this.view, 
  "Usuario o Clave incorrectos", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
    }   
           public void hide(){
        view.setVisible(false);
    }   
       
           public void show(){
        view.setVisible(true);
    }
}
