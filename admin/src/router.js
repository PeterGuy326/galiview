import Vue from 'vue'
import Router from 'vue-router'
import Login from './views/login.vue'

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
        path: '*',
        redirect: "/login",
    }, {
        path: '/login',
        component: Login
    }]
})
