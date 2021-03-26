import Vue from 'vue'
import App from './app.vue'
import router from './router'
import axios from 'axios'
import filter from "./filter/filter";

Vue.config.productionTip = false
Vue.prototype.$ajax = axios

// 解决每次ajax请求，对应的sessionId不一致的问题
axios.defaults.withCredentials = true

/**
 * axios拦截器
 */
axios.interceptors.request.use(function (config) {
  console.log("请求：", config);
  return config;
}, error => {});
axios.interceptors.response.use(function (response) {
  console.log("返回结果：", response);
  return response;
}, error => {});

// 全局过滤器
Object.keys(filter).forEach(key => {
  Vue.filter(key, filter[key])
});

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

console.log("环境：", process.env.NODE_ENV);