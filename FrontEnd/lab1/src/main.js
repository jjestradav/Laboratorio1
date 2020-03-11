import Vue from 'vue'
import router from './router'
import store from './store'
import { BootstrapVue} from 'bootstrap-vue'
import bootbox from 'bootbox';
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import App from './App.vue'

// Install BootstrapVue
Vue.use(BootstrapVue)
Vue.use(bootbox)
// Optionally install the BootstrapVue icon components plugin

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
