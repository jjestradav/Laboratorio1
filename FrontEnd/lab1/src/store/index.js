import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    profesor:{},
    cursos:{},
    grupos:[]
  },
  mutations: {
    setProfesor(state,profe){
      state.profesor=profe;
    },
    setCursos(state,curs){
      state.cursos=curs;
    },
    setGrupos(state,grups){
      state.grupos=grups
    }
  },
  actions: {
  },
  modules: {
  }
})
