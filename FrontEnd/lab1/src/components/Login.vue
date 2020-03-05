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
      <div class="user_card">
        <div class="d-flex justify-content-center">
          <div class="brand_logo_container">
            <img th:src="@{/images/user.png}" class="brand_logo" alt="Logo" />
          </div>
        </div>
        <div class="d-flex justify-content-center form_container">
          <!--                        action="/Kronos/LoginServlet"-->
          <b-form @submit="onSubmit">
            <div class="input-group mb-3">
              <div class="input-group-append">
                <span class="input-group-text">
                  <i class="fas fa-user"></i>
                </span>
              </div>
              <b-form-input v-model="persona.cedula" placeholder="Usuario"></b-form-input>
            </div>
            <div class="input-group mb-2">
              <div class="input-group-append">
                <span class="input-group-text">
                  <i class="fas fa-key"></i>
                </span>
              </div>
              <b-form-input
                v-model="persona.password"
                type="password"
                id="password"
                name="password"
                class="form-control input_pass"
                placeholder="Contraseña"
                required
              ></b-form-input>
            </div>
            <div class="form-group">
              <div class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" id="customControlInline" />
                <label class="custom-control-label" for="customControlInline">Recordar</label>
              </div>
            </div>

            <div class="d-flex justify-content-center mt-3 login_container">
              <b-button type="submit" name="button" class="btn login_btn">Login</b-button>
            </div>
          </b-form>
        </div>
      </div>
    </div>
  </b-container>
</template>


<script>
import { mapState, mapMutations } from 'vuex';

export default {
  name: 'Login',
  data() {
    return {
      persona: {
        cedula: "",
        password: "",
        rol:""
      },
      profe:{}
    };
  },
  methods: {
    onSubmit(evt) {
      evt.preventDefault();
      let url = "http://localhost:9090/Laboratorio1/api/usuarios/login";
      fetch(url, {
        method: "POST",
        headers: {
          'Accept': 'application/json',
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.persona)
      })
        .then(response => response.json())
        .catch(error => {
          console.log(error);
        })
        .then(profe=>{
            console.log(profe)
        this.profe.cedula=profe.cedula;
        this.profe.nombre=profe.nombre;
        this.profe.telefono=profe.telefono;
        this.profe.email=profe.email;
        this.setProfesor(profe)
      
         
            
            }).then(()=>{
               this.$router.replace('/ciclos');
                
            })

    },
    ...mapMutations(['setProfesor'])
  },
  computed:{
    //...Vuex.
    ...mapState(['profesor'])
  }
};
</script>

<style scoped>
body,
html {
  margin: 0;
  padding: 0;
  height: 100%;
  background: #bbc9d4 !important;
}
.user_card {
  height: 400px;
  width: 350px;
  margin-top: auto;
  margin-bottom: auto;
  background: #1f3140;
  position: relative;
  display: flex;
  justify-content: center;
  flex-direction: column;
  padding: 10px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  -webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2),
    0 6px 20px 0 rgba(0, 0, 0, 0.19);
  -moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2),
    0 6px 20px 0 rgba(0, 0, 0, 0.19);
  border-radius: 5px;
  color: #bbc9d4;
}
.brand_logo_container {
  position: absolute;
  height: 170px;
  width: 170px;
  top: -75px;
  border-radius: 50%;
  background: white;
  padding: 10px;
  text-align: center;
}
.brand_logo {
  height: 150px;
  width: 150px;
  border-radius: 50%;
  border: 2px solid white;
}
.form_container {
  margin-top: 100px;
}
.login_btn {
  width: 100%;
  background: #667306 !important;
  color: white !important;
}
.login_btn:focus {
  box-shadow: none !important;
  outline: 0px !important;
}
.login_container {
  padding: 0 2rem;
}
.input-group-text {
  background: #667306 !important;
  color: white !important;
  border: 0 !important;
  border-radius: 0.25rem 0 0 0.25rem !important;
}
.input_user,
.input_pass:focus {
  box-shadow: none !important;
  outline: 0px !important;
}
.custom-checkbox .custom-control-input:checked ~ .custom-control-label::before {
  background-color: #667306 !important;
}
</style>

