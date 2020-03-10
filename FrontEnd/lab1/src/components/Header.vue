<template>
   <div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand disabled>Gestión de Notas</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <!--<b-nav-item @click='verCursos'>Cursos</b-nav-item>-->
        <b-nav-item @click='verCiclos'>Ciclos</b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav class="ml-auto">

        <b-nav-item-dropdown right>
          
          <template v-slot:button-content>
            <em>User</em>
          </template>
          <b-dropdown-item @click='verProfile'>Profile</b-dropdown-item>
          <b-dropdown-item href="/login">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</div>
</template>

<script>
import {mapState, mapMutations} from "vuex";
export default {
    name:'Menu', 
    data(){
     return{
             
     }   
    },
     methods:{
        ...mapMutations(["setProfesor",'setCursos','setGrupos']),
        verCiclos(event){
            event.preventDefault()
            this.setProfesor(this.profesor)
            console.log(this.profesor)
            this.$router.replace("/ciclos")
        },
        verProfile(event){
            event.preventDefault()
            this.setProfesor(this.profesor)
            this.$router.replace('/profile')
        }
        },
        computed: {
    //...Vuex.
    ...mapState(["profesor",'cursos','grupos'])
  }

}
</script>