import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
  ,
  {
    path:'/grupos',
    name:'GruposView',
    component: () => import(/* webpackChunkName: "grupo" */ '../views/GruposView.vue')
  }
,
  {
    path:'/login',
    name:'Login',
    component: () => import(/* webpackChunkName: "login" */ '../views/LoginView.vue')
  }
  ,
  {
    path:'/ciclos',
    name:'Ciclos',
    component: () => import(/* webpackChunkName: "ciclos" */ '../views/CiclosView.vue')
  },
  {
    path:'/cursos',
    name:'Cursos',
    component: () => import(/* webpackChunkName: "cursos" */ '../views/CursosView.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
