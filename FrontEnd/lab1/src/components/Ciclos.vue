<template>
  <b-container class="container">
    <b-row>
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
    </b-row>
    <div class="d-flex justify-content-center h-100">
      <b-card title="Seleccione un Ciclo">
        <div class="d-flex justify-content-center form_container">
          <!--                        action="/Kronos/LoginServlet"-->
          <b-form  @submit="verCursos">
            <div class="input-group mb-3">
              <div class="input-group-append"></div>
              <b-form-select v-model="selected" >
                  <option value='-1'>Escoga una opción</option>
                <option
                  v-for="ciclo in options"
                  :key="ciclo.codigo"
                  v-bind:value="ciclo.codigo"
                >Ciclo {{ ciclo.numeroCiclo }} {{ciclo.anho}}</option>
              </b-form-select>
            </div>

            <div class="d-flex justify-content-center mt-3 login_container">
              <b-button type="submit" name="button" class="btn login_btn">Ver</b-button>
            </div>
          </b-form>
        </div>
      </b-card>
    </div>
  </b-container>
</template>


<script>
import { mapState, mapMutations } from "vuex";
export default {
  name: "Ciclos",
  data() {
    return {
       selected:'-1', 
      options: []
    };
  },
  methods: {
    ...mapMutations(["setProfesor",'setCursos']),
    verCursos(event){
         event.preventDefault();
            let url='http://localhost:9090/Laboratorio1/api/cursos/getCursos/'+this.profesor.cedula+'/'+this.selected;
            console.log(url);
            console.log(url);
             fetch(url,{
                 mode:'cors'
             })
             .then(response=>response.json())
             .then(cursos=>this.setCursos(cursos))
             .then(()=>{
               
                this.$router.replace('/cursos');
      })
             //console.log(this.cursos);


    }
  },
  computed: {
    //...Vuex.
    ...mapState(["profesor",'cursos'])
  },
  created() {
    let url = "http://localhost:9090/Laboratorio1/api/ciclos/getAll";
    fetch(url, {
      mode: "cors"
    })
      .then(response => response.json())
      .then(ciclos => {
        this.options = ciclos;
        
      })
  }
};
</script>