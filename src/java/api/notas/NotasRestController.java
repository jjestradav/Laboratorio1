/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.notas;

import dto.GrupoAlumnoDTO;
import entity.Grupo;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.ServiceGrupoAlumno;

/**
 *
 * @author jose
 */
@Path("/grupos")
public class NotasRestController {
    private ServiceGrupoAlumno alumRepo=ServiceGrupoAlumno.getInstance();
    
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("/notas")
    public Response actualizarNota(GrupoAlumnoDTO model){
        System.out.println(model.getNota());
    try{
    Boolean sucess=alumRepo.ActualizarNota(model);
    if(sucess){
        Grupo aux= new Grupo();
        aux.setCodigo(model.getGrupo());
        List<GrupoAlumnoDTO> response=alumRepo.buscarGrupoPorProfesor(aux);
       return Response.status(200).header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers",
                                "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods",
                               "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .entity(response)
                      .build(); 
    }else{
    throw new Exception();
    }
    }catch(Exception e) {
    throw new InternalServerErrorException();
    }
        
    }
    
}
