<template>
  <b-container >
    <Header />
    <h2>
      <b-badge>Perfil</b-badge>
    </h2>
    <br />
    <br />
    <h4>
      <b-badge>Nombre del Profesor</b-badge>
      {{profesor.nombre}}
    </h4>
    <br />
    <h4>
      <b-badge>Cedula del Profesor</b-badge>
      {{profesor.cedula}}
    </h4>
    <br />
    <h4>
      <b-badge>Telefono del Profesor</b-badge>
      {{profesor.telefono}}
    </h4>
    <br />
    <h4>
      <b-badge>Email del Profesor</b-badge>
      {{profesor.email}}
    </h4>
  </b-container>
</template>


<script>
import Header from "./Header.vue";
import { mapState, mapMutations } from "vuex";
export default {
  name: "Profile",
  data() {
    return {};
  },
  methods: {
    ...mapMutations(["setProfesor"])
  },
  components: {
    Header
  },
  computed: {
    //...Vuex.
    ...mapState(["profesor"])
  }
};
</script>