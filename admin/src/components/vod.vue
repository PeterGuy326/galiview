<template>
  <big-file v-bind:input-id="inputId"
            v-bind:text="text"
            v-bind:suffixs="suffixs"
            v-bind:use="use"
            v-bind:after-upload="afterUpload"
            v-bind:shard-size="shardSize"
            v-bind:url="'oss-append'"></big-file>
</template>

<script>
import BigFile from "./big-file";

export default {
  components: {BigFile},
  name: 'vod',
  props: {
    text: {
      default: "上传VOD"
    },
    inputId: {
      default: "vod-upload"
    },
    suffixs: {
      default: []
    },
    use: {
      default: ""
    },
    shardSize: {
      default: 50 * 1024
    },
    afterUpload: {
      type: Function,
      default: null
    },
  },
  methods: {}
}
</script>
