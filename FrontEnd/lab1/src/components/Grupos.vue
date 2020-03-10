<template>
  <b-container fluid="lg">
    <Header />
    <h2>Grupos que el profesor {{profesor.nombre}} imparte clases</h2>
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
    ...mapMutations(["setProfesor", "setCursos", "setGrupos"])
  },
  computed: {
    //...Vuex.
    ...mapState(["profesor", "cursos", "grupos"])
  }
};
</script>