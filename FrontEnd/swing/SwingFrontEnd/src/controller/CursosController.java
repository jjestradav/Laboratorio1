/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Session;
import dto.GrupoAlumnoDTO;
import entity.Curso;
import entity.Profesor;
import java.util.List;
import javax.swing.JOptionPane;
import service.ServiceGrupo;
import view.CursosView;
import viewmodel.CursosViewModel;

/**
 *
 * @author jonathan
 */
public class CursosController {
    
    private final ServiceGrupo gruposRepo= ServiceGrupo.getInstance();
    private final Session session = Session.getInstance();
    private CursosViewModel model;
    private CursosView view;

    public CursosController(CursosViewModel model, CursosView view) {

    }

    public void hide() {
        view.setVisible(false);
    }

    public void show() {
        view.setVisible(true);
    }

    public void setComboBox() {

        try {

            List<Curso> result = (List<Curso>)this.session.getAttribute("cursos");
            
            if(result==null)
                throw new Exception();
            
            this.model.setCursos(result);

        }

        catch(Exception e) {
            e.printStackTrace();
                JOptionPane.showMessageDialog(this.view, 
  "Ha Ocurrido un error al cargar los datos", "Error!", JOptionPane.ERROR_MESSAGE);
           }
   
}
    
    
    public void goToGrupos(Curso cur){
        
        try{
        Profesor profe=(Profesor)this.session.getAttribute("user");
        if(profe==null)
            throw new Exception();
        
        List<GrupoAlumnoDTO> dto=this.gruposRepo.buscarGrupoPorProfesor(profe, cur);
        session.setAttibute("grupos", dto);
        
        
        }
        
        catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this.view, 
  "Ha Ocurrido un error al cargar los datos", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
