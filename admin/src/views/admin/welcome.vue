<template>
  <div>
    <h1>你好，欢迎进入控台</h1>
  </div>
</template>

<script>
export default {
  name: "welcome",
  mounted: function () {
    this.$parent.activeSidebar("welcome-sidebar")
  },
  methods: {

  }
}
</script>

<style>

</style>