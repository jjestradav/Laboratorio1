/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Grupo;
import entity.Profesor;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class ServiceGrupo {
    
    private Service service= Service.getInstance();
    private static final String LISTAR_PROFESOR_POR_GRUPO="{?=call buscarGrupoPorProfesor(?)}";
    
        private static ServiceGrupo instance=null;

    private ServiceGrupo() {

    }
    
    public static ServiceGrupo getInstance(){
     
        if(instance==null)
            instance=new ServiceGrupo();
        
        return instance;
    }
    
    public List<Grupo> buscarGrupoPorProfesor(Profesor profesor) throws Exception{
        
        try{
            this.service.conectar();
        }
        catch(Exception e){
            throw e;
        }
        try{
            CallableStatement statement=this.service.getConnection().prepareCall(LISTAR_PROFESOR_POR_GRUPO);
            statement.setString(1, profesor.getCedula());
            statement.registerOutParameter(1, Types.OTHER);
            ResultSet rs=statement.executeQuery();
            List<Grupo> result= new ArrayList<>();
            
            while(rs.next()){
                //rs.get()
                //result.add()
            }
            try{
                rs.close();
            }
            catch(Exception e){
                throw e;
            }
            
             try{
                statement.close();
            }
            catch(Exception e){
               throw e; 
            }
              try{
                this.service.desconectar();
            }
            catch(Exception e){
                throw e;
            }
            
            return result;
        }
        
        catch(Exception e){
            
            throw e;
        }
       
        
        
      
    }
    
}
