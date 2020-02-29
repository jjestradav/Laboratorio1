/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author jonathan
 */
import entity.Curso;
import exception.GlobalException;
import exception.NoDataException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;


public class ServiceCurso  {
    
     private Service service= Service.getInstance();
     
    private static final String INSERTAR_CURSO = "{call INSERTAR_CURSO(?,?,?,?,?,?)}";
    private static final String MODIFICAR_CURSO = "{call MODIFICAR_CURSO(?,?,?,?,?,?)}";
    private static final String BUSCAR_CURSO = "{?=call BUSCAR_CURSO(?)}";
    private static final String LISTAR_CURSO = "{?=call LISTAR_CURSO()}";
    private static final String ELIMINAR_CURSO = "{call ELIMINAR_CURSO(?)}";

      private static ServiceCurso instance=null;

    private ServiceCurso() {

    }
    
    public static ServiceCurso getInstance(){
     
        if(instance==null)
            instance=new ServiceCurso();
        
        return instance;
    }

    /*Insertar alumnos*/
    public void insertar_curso(Curso elAlumno) throws GlobalException, NoDataException {
        try {
            this.service.conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        CallableStatement pstmt = null;

        try {
            pstmt =  this.service.getConnection().prepareCall(INSERTAR_CURSO);
//            pstmt.setString(1, elAlumno.getCodigo_curso());
//            pstmt.setString(2, elAlumno.getCodigo_carrera());
//            pstmt.setString(3, elAlumno.getNo_ciclo());
//            pstmt.setString(4, elAlumno.getNombre());
//            pstmt.setString(5, elAlumno.getCreditos());
//            pstmt.setString(6, elAlumno.getHoras_semanales());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                throw new NoDataException("No se realizo la insercion");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new GlobalException("Llave duplicada");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                this.service.desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    /*Modificar alumnos*/
    public void modificar_curso(Curso elAlumno) throws GlobalException, NoDataException {
        try {
            this.service.conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = this.service.getConnection().prepareStatement(MODIFICAR_CURSO);
//            pstmt.setString(1, elAlumno.getCodigo_curso());
//            pstmt.setString(2, elAlumno.getCodigo_carrera());
//            pstmt.setString(3, elAlumno.getNo_ciclo());
//            pstmt.setString(4, elAlumno.getNombre());
//            pstmt.setString(5, elAlumno.getCreditos());
//            pstmt.setString(6, elAlumno.getHoras_semanales());
            int resultado = pstmt.executeUpdate();

            if (resultado == 0) {
                throw new NoDataException("No se realizo la actualización");
            } else {
                System.out.println("\nModificación Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                this.service.desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }

    /*Buscar alumnos*/
    public Curso buscar_curso(String id) throws GlobalException, NoDataException {

        try {
            this.service.conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Curso elCurso = null;
        CallableStatement pstmt = null;
        try {
            pstmt = this.service.getConnection().prepareCall(BUSCAR_CURSO);
        //    pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, id);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
//            while (rs.next()) {
//                elCurso = new Curso(rs.getString("CODIGO_CURSO"),
//                        rs.getString("CODIGO_CARRERA"),
//                        rs.getString("NO_CICLO"),
//                        rs.getString("NOMBRE"),
//                        rs.getString("CREDITOS"),
//                        rs.getString("HORAS_SEMANALES"));
//                coleccion.add(elCurso);
//            }
        } catch (SQLException e) {
            e.printStackTrace();

            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                this.service.desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (coleccion == null || coleccion.size() == 0) {
            throw new NoDataException("No hay datos");
        }
        return elCurso;
    }

    /*Listar alumnos*/
    public Collection listar_curso() throws GlobalException, NoDataException {
        try {
            this.service.conectar();
        } catch (ClassNotFoundException ex) {
            throw new GlobalException("No se ha localizado el Driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }

        ResultSet rs = null;
        ArrayList coleccion = new ArrayList();
        Curso elCurso = null;
        CallableStatement pstmt = null;
        try {
            pstmt = this.service.getConnection().prepareCall(LISTAR_CURSO);
       //     pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
//            while (rs.next()) {
//                elCurso = new Curso(rs.getString("CODIGO_CURSO"),
//                        rs.getString("CODIGO_CARRERA"),
//                        rs.getString("NO_CICLO"),
//                        rs.getString("NOMBRE"),
//                        rs.getString("CREDITOS"),
//                        rs.getString("HORAS_SEMANALES"));
//                coleccion.add(elCurso);
//            }
        } catch (SQLException e) {
            e.printStackTrace();

            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                this.service.desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
        if (coleccion == null || coleccion.size() == 0) {
            throw new NoDataException("No hay datos");
        }
        return coleccion;
    }

    /*Eliminar alumnos*/
    public void eliminar_curso(String id) throws GlobalException, NoDataException {
        try {
              this.service.conectar();
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        PreparedStatement pstmt = null;
        try {
            pstmt = this.service.getConnection().prepareStatement(ELIMINAR_CURSO);
            pstmt.setString(1, id);

            int resultado = pstmt.executeUpdate();

            if (resultado == 0) {
                throw new NoDataException("No se realizo el borrado");
            } else {
                System.out.println("\nEliminación Satisfactoria!");
            }
        } catch (SQLException e) {
            throw new GlobalException("Sentencia no valida");
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
               this.service.desconectar();
            } catch (SQLException e) {
                throw new GlobalException("Estatutos invalidos o nulos");
            }
        }
    }
}
