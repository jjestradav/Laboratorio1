/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.usuarios;

import entity.Profesor;
import entity.Usuario;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import service.Service;
import service.ServiceProfesor;
import service.ServiceUsuario;

/**
 *
 * @author jonathan
 */
@Path("/usuarios")
public class UsuarioRestControllers {

    private final ServiceUsuario usuariosRepo = ServiceUsuario.getInstance();
    
       private final ServiceProfesor profeRepo = ServiceProfesor.getInstance();

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("/login")
    public Response login(Usuario us) {
        try {

            Optional<Usuario> opt = this.usuariosRepo.getUsuario(us);
            if (opt.isPresent()) {
                Profesor profe= new Profesor();
                profe.setCedula(opt.get().getCedula());
                Optional<Profesor> optprofe=this.profeRepo.getProfesor(profe);
                if(optprofe.isPresent()){
                return Response
                        .status(200)
                     //.header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers",
                                "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods",
                               "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .entity(optprofe.get())
                      .build();
                }
                else
                   throw new Exception(); 
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
           return Response
                        .status(500)
                        .header("Access-Control-Allow-Origin", "*")
                        .header("Access-Control-Allow-Credentials", "true")
                        .header("Access-Control-Allow-Headers",
                                "origin, content-type, accept, authorization")
                        .header("Access-Control-Allow-Methods",
                               "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                        .entity(e.getMessage())
                      .build();
        }
    }

    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public String getString() {
        System.out.println("HOLA");
        return "HOLA";
    }

}
