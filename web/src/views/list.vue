<template>
  <main role="main">
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <pagination ref="pagination" v-bind:list="listCourse"></pagination>
          </div>
        </div>
        <br>
        <div class="row">
          <div v-for="o in courses" class="col-md-4">
            <the-course v-bind:course="o"></the-course>
          </div>
          <h3 v-show="courses.length === 0">暂未视频发布</h3>
        </div>
      </div>
    </div>

  </main>
</template>

<script>
import TheCourse from "../components/the-course";
import Pagination from "../components/pagination";

export default {
  components: {Pagination, TheCourse},
  name: 'list',
  data: function () {
    return {
      courses: [],
    }
  },
  mounted() {
    let _this = this;
    _this.$refs.pagination.size = 1;
    _this.listCourse(1);
  },
  methods: {
    /**
     * 查询课程列表
     */
    listCourse(page) {
      let _this = this;
      _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/web/course/list', {
        page: page,
        size: _this.$refs.pagination.size,
      }).then((response) => {
        let resp = response.data;
        if (resp.success) {
          _this.courses = resp.content.list;
          _this.$refs.pagination.render(page, resp.content.total);
        }
      }).catch((response) => {
        console.log("error：", response);
      })
    },

  }
}
</script>
<style>

</style>