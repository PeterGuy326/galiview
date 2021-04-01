<template>
  <main role="main">
    <div class="album py-5 bg-light">
      <div class="container">
        <div class="row">
          <div v-for="o in courses" class="col-md-4">
            <the-course v-bind:course="o"></the-course>
          </div>
          <h3 v-show="courses.length === 0">视频还未上架</h3>
        </div>
      </div>
    </div>

  </main>
</template>

<script>
import TheCourse from "../components/the-course";

export default {
  components: {TheCourse},
  name: 'list',
  data: function () {
    return {
      courses: [],
    }
  },
  mounted() {
    let _this = this;
    _this.listCourse();
  },
  methods: {
    /**
     * 查询课程列表
     */
    listCourse() {
      let _this = this;
    },

  }
}
</script>
<style>

</style>