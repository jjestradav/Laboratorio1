/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.grupos;

import dto.GrupoAlumnoDTO;
import entity.Curso;
import entity.Grupo;
import entity.GrupoAlumno;
import entity.Profesor;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.ServiceGrupo;
import service.ServiceGrupoAlumno;

/**
 *
 * @author jonathan
 */
@Path("/grupos")
public class GruposRestController {
    
    private ServiceGrupo gruposRepo=ServiceGrupo.getInstance();
    private ServiceGrupoAlumno alumRepo=ServiceGrupoAlumno.getInstance();
    
    @GET
    @Path("/gruposPorProfesor/{cedula}/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response gruposPorProfesor(@PathParam("cedula") String cedula,@PathParam("codigo") int codigo){
        try{
            Profesor profe= new Profesor();
            profe.setCedula(cedula);
            Curso cur= new Curso();
            cur.setCodigo(codigo);
          List<Grupo> result= gruposRepo.buscarGrupoPorCurso(cur, profe);
          return Response
                        .status(200)
                  //   .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers",
                                "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods",
                               "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .entity(result)
                      .build();
        }
        
        catch(Exception e){
            e.printStackTrace();
              return Response  .status(500)
           //          .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers",
                                "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods",
                               "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                       .entity("Error")
                      .build();
        }
    }
            
     @GET
    @Path("/alumnosPorGrupo/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response alumnosPorGrupo(@PathParam("codigo") int codigo){
        try{
            Grupo cur= new Grupo();
            cur.setCodigo(codigo);
          List<GrupoAlumnoDTO> result= alumRepo.buscarGrupoPorProfesor(cur);
          return Response
                        .status(200)
                  //   .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers",
                                "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods",
                               "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .entity(result)
                      .build();
        }
        
        catch(Exception e){
            e.printStackTrace();
              return Response  .status(500)
           //          .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers",
                                "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods",
                               "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                       .entity("Error")
                      .build();
        }
    }       
            
    
}
