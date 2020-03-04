/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Alumno;
import entity.Grupo;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonathan
 */
public class ServiceGrupoAlumno {
    
     private Service service= Service.getInstance();
    
     private static final String INSERTAR_CURSO = "{call INSERTAR_CURSO(?,?,?,?,?,?)}";
    private static final String MODIFICAR_CURSO = "{call MODIFICAR_CURSO(?,?,?,?,?,?)}";
    private static final String BUSCAR_CURSO = "{?=call BUSCAR_CURSO(?)}";
    private static final String LISTAR_CURSO = "{?=call LISTAR_CURSO()}";
    private static final String ELIMINAR_CURSO = "{call ELIMINAR_CURSO(?)}";
    
        private static ServiceGrupoAlumno instance=null;

    private ServiceGrupoAlumno() {

    }
    
    public static ServiceGrupoAlumno getInstance(){
     
        if(instance==null)
            instance=new ServiceGrupoAlumno();
        
        return instance;
    }
    
    public List<Alumno> buscarAlumnosPorGrupo(Grupo grupo) throws Exception{
        
        try{
            this.service.conectar();
            
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        
          CallableStatement statement=null;
             ResultSet rs=null;
        try{
           
                     
                     this.service.getConnection().prepareCall(ELIMINAR_CURSO);
                     statement.registerOutParameter(1, Types.OTHER);
                     statement.setInt(1, grupo.getNumeroGrupo());
                     rs=statement.executeQuery();
                     List<Alumno> result= new ArrayList<>();
                     while(rs.next()){
                         //
                     }
                     return result;
             
             
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally{
            try{
            if(rs != null)
                rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
                throw e;
            }
            try{
            if(statement != null){
                statement.close();
            }
            }
            catch(Exception e){
                e.printStackTrace();
                  throw e;
            }
            try{
            this.service.desconectar();
            }
            catch(Exception e){
                e.printStackTrace();
                  throw e;
            }
        }
     
    }
    
}
