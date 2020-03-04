/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.ciclos;

import entity.Ciclo;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.Service;
import service.ServiceCiclo;
import service.ServiceCurso;

/**
 *
 * @author jonathan
 */
@Path("/ciclos")
public class CiclosRestController {
    
    private final ServiceCiclo ciclosRepo= ServiceCiclo.getInstance();
    
    @GET
    @Path("/getAll")
    public Response getAllCiclos(){
        try{
            List<Ciclo> result= ciclosRepo.getCiclos();
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
