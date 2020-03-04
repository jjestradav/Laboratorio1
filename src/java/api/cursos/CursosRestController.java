/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.cursos;

import entity.Ciclo;
import entity.Curso;
import entity.Profesor;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import service.ServiceCurso;

/**
 *
 * @author jonathan
 */
@Path("/cursos")
public class CursosRestController {
    
    private final ServiceCurso cursosRepo= ServiceCurso.getInstance();
    @GET
    @Path("/getCursos/{cedula}/{codigo}")
    public Response getAllCiclos(@PathParam("cedula") String cedula, @PathParam("codigo") int codigo  ){
        try{
            Profesor profe= new Profesor();
            profe.setCedula(cedula);
            Ciclo ciclo= new Ciclo();
            ciclo.setCodigo(codigo);
            List<Curso> result= cursosRepo.getCursosPorProfesor(profe, ciclo);
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
