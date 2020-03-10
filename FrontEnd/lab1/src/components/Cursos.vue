<template>
    <b-container class="container">
    <Header/>
    <b-row>
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
    </b-row>
    <div class="d-flex justify-content-center h-100">
      <b-card title="Seleccione un Curso">
        <div class="d-flex justify-content-center form_container">
          <!--                        action="/Kronos/LoginServlet"-->
            <table  class="table table-striped table-bordered border-info">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Grupos</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="curso in this.cursos"  :key="curso.codigo">
                        <td>{{ curso.nombre }}</td>
                        <td><b-button class="btn btn-success btn-sm" @click="verGrupos(curso.codigo)">Ver</b-button></td>

                    </tr>
                </tbody>
            </table>
        </div>
      </b-card>
    </div>
  </b-container>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import Header from './Header.vue';
export default {
    name:'Cursos',
    data(){
        return{

        }
    },
    components:{
      Header
    },
    methods:{
        ...mapMutations(["setProfesor",'setCursos','setGrupos']),
        verGrupos(codigo){
            let url='http://localhost:9090/Laboratorio1/api/grupos/gruposPorProfesor/'+
            this.profesor.cedula+'/'+codigo;
            fetch(url,{
              mode:'cors'
            }).then(response=>response.json())
              .then(gruposAlumnos=>{
                let map=new Map();
                for(let obj of gruposAlumnos){
                  let estudiante={
                        alumno:obj.alumno,
                        nota:obj.nota
                      }
                  let mapObj=map.get(obj.grupo)
                    if(mapObj === undefined){
                      let grupo={
                        grupo:obj.grupo,
                        estudiantes:[]
                      }
                      
                      grupo.estudiantes.push(estudiante);
                      map.set(obj.grupo,grupo)
                    
                    }
                    else{
                      mapObj.estudiantes.push(estudiante);
                      map.set(obj.grupo,mapObj);

                    }
                }
                let array=Array.from(map.values());
                this.setGrupos(array);
                console.log(array);
                }).then(()=>{this.$router.replace('/grupos');})
        }
    },
      computed: {
      //...Vuex.
      ...mapState(["profesor",'cursos','grupos'])
    },
  mounted:function(){
      console.log(this.cursos);
  }

}
</script>