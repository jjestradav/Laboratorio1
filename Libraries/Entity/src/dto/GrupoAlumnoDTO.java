/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author jonathan
 */
public class GrupoAlumnoDTO {
    
    private int grupo;
    private AlumnoDTO alumno;
    private int nota;

    public GrupoAlumnoDTO() {
    }

    public GrupoAlumnoDTO(int grupo, AlumnoDTO alumno, int nota) {
        this.grupo = grupo;
        this.alumno = alumno;
        this.nota = nota;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
    
}
