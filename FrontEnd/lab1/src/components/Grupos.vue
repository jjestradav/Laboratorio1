<template>
    <b-container>
        <h2>Cursos Asignados a {{profesor.nombre}}</h2>
    </b-container>
</template>

<script>
import { mapState, mapMutations } from 'vuex';

export default {
  name: 'Grupos',
  data() {
      return {
      }
    },
    methods:{
     ...mapMutations(['setProfesor','setCursos'])
    },
     computed:{
    //...Vuex.
    ...mapState(['profesor','cursos'])
  }
  }
  


 
  </script>