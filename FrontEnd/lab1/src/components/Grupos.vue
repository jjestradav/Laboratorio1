<template>
  <b-container fluid="lg">
    <Header />
    <h2>Grupos que el profesor {{profesor.nombre}} imparte clases</h2>
    <div class="d-flex justify-content-center h-100">
      <b-card title="Seleccione un Grupo">
        <div class="d-flex justify-content-center form_container">
          <!--                        action="/Kronos/LoginServlet"-->
          <table class="table table-striped table-bordered border-info">
            <thead>
              <tr>
                <th>Codigo</th>
                <th>Numero de Grupo</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="grupo in this.grupos" :key="grupo.codigo">
                <td>{{ grupo.codigo }}</td>
                <td>{{grupo.numeroGrupo}}</td>
                <td>
                  <b-button class="btn btn-success btn-sm" @click="verAlumnos(grupo.codigo)">Ver</b-button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
        <th></th>
      </b-card>
    </div>
  </b-container>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import Header from "./Header.vue";
export default {
  name: "Grupos",
  data() {
    return {};
  },
  components: {
    Header
  },
  methods: {
    ...mapMutations(["setProfesor", "setCursos", "setGrupos", "setAlumnos"]),
    verAlumnos(codigo) {
      let url =
        "http://localhost:9090/Laboratorio1/api/grupos/alumnosPorGrupo/" +
        codigo;
      fetch(url, {
        mode: "cors"
      })
        .then(response => response.json())
        .then(alumnos => {
          this.setAlumnos(alumnos);
          console.log(alumnos);
        })
        .then(() => {
          this.$router.replace("/alumnos");
        });
    }
  },
  computed: {
    //...Vuex.
    ...mapState(["profesor", "cursos", "grupos", "alumnos"])
  }
};
</script>