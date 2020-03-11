<template>
  <b-container>
 
      <Header />
  
    <div class="d-flex justify-content-center h-100">
      <b-card title="Seleccione un Grupo">
        <div class="d-flex justify-content-center form_container">
          <!--                        action="/Kronos/LoginServlet"-->
          <table class="table table-striped table-bordered border-info">
            <thead>
              <tr>
                <th>Cedula</th>
                <th>Nombre</th>
                <th>Nota</th>
                <th>Editar Nota</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="alum in this.alumnos" :key="alum.cedula">
                <td>{{alum.alumno.cedula}}</td>
                <td>{{alum.alumno.nombre}}</td>
                <td>{{alum.nota}}</td>
                <td>
                  <b-button
                    class="btn btn-success btn-sm"
                    v-b-modal.modal-1
                    cedula="'alum'"
                    @click="verInfo(alum)"
                  >Editar Nota</b-button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <th></th>
      </b-card>
      <div>
        <b-modal id="modal-1" title="Actualizar" >
          <p class="my-4">Estudiante</p>
          <p class="my-3">Cedula: {{selected.alumno.cedula}}</p>
          <p class="my-3">Nombre: {{selected.alumno.nombre}}</p>
          <b-form-input
            v-model="selected.nota"
            id="nota"
            name="nota"
            type="text"
            class="form-control input_pass"
            placeholder="Nota"
            required
          ></b-form-input>
          <template v-slot:modal-footer="{ ok, cancel, hide }">
            <b>Custom Footer</b>
            <!-- Emulate built in modal footer ok and cancel button actions -->
            <b-button size="sm" variant="success" data-dismiss="modal" @click="registrarNota()">Registrar</b-button>
            <!-- Button with custom close trigger value -->
            <b-button size="sm" variant="outline-secondary" @click="hide('forget')">Cancelar</b-button>
          </template>
        </b-modal>
      </div>
    </div>
  </b-container>
</template>
<script>
import { mapState, mapMutations } from "vuex";
import Header from "./Header.vue";

require ('jquery')
export default {
  name: "Alumnos",
  data() {
    return {
      selected: {
        alumno: {
          cedula: "",
          nombre: ""
        },
        grupo:"",
        nota:""
      },
      modalShow :true
    };
  },
  components: {
    Header
  },
  methods: {
    ...mapMutations(["setProfesor", "setCursos", "setGrupos", "setAlumnos"]),
    verInfo(alumno) {
      this.selected = alumno;
    },
    registrarNota(){
      let url="http://localhost:9090/Laboratorio1/api/grupos/notas/"
      this.selected.nota = parseFloat(this.selected.nota)
      fetch(url, {
        method:"POST",
        headers: {
          'Accept': 'application/json',
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.selected)
      })
        .then(response => response.json())
        .catch(error => {
          console.log(error);
        })
        .then(galumno=>{
          this.setAlumnos(galumno)
            console.log(galumno)
            }).then(()=>{this.$bvModal.hide('modal-1')})
    console.log(this.nota)
    return true;   
    }
  },
  computed: {
    //...Vuex.
    ...mapState(["profesor", "cursos", "grupos", "alumnos"])
  }
};
</script>