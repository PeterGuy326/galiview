<template>
  <div>
    <button type="button" v-on:click="selectFile()" class="btn btn-white btn-default btn-round">
      <i class="ace-icon fa fa-upload"></i>
      {{text}}
    </button>
    <input class="hidden" type="file" ref="file" v-on:change="uploadFile()" v-bind:id="inputId+'-input'">
  </div>
</template>

<script>
export default {
  name: 'big-file',
  props: {
    text: {
      default: "上传大文件"
    },
    inputId: {
      default: "file-upload"
    },
    suffixs: {
      default: []
    },
    use: {
      default: ""
    },
    afterUpload: {
      type: Function,
      default: null
    },
  },
  data: function () {
    return {
    }
  },
  methods: {
    uploadFile () {
      let _this = this;
      let formData = new window.FormData();
      let file = _this.$refs.file.files[0];

      console.log(file);
      /*
        name: "test.mp4"
        lastModified: 1901173357457
        lastModifiedDate: Tue May 27 2099 14:49:17 GMT+0800 (中国标准时间) {}
        webkitRelativePath: ""
        size: 37415970
        type: "video/mp4"
      */

      // 生成文件标识，标识多次上传的是不是同一个文件
      let key = hex_md5(file);
      let key10 = parseInt(key, 16);
      let key62 = Tool._10to62(key10);
      console.log(key, key10, key62);
      /*
        d41d8cd98f00b204e9800998ecf8427e
        2.8194976848941264e+38
        6sfSqfOwzmik4A4icMYuUe
       */

      // 判断文件格式
      let suffixs = _this.suffixs;
      let fileName = file.name;
      let suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length).toLowerCase();
      let validateSuffix = false;
      for (let i = 0; i < suffixs.length; i++) {
        if (suffixs[i].toLowerCase() === suffix) {
          validateSuffix = true;
          break;
        }
      }
      if (!validateSuffix) {
        Toast.warning("文件格式不正确！只支持上传：" + suffixs.join(","));
        $("#" + _this.inputId + "-input").val("");
        return;
      }

      // 文件分片
      let shardSize = 20 * 1024 * 1024;    //以20MB为一个分片
      let shardIndex = 2;		//分片索引，1表示第1个分片
      let start = (shardIndex - 1) * shardSize;	//当前分片起始位置
      let end = Math.min(file.size, start + shardSize); //当前分片结束位置
      let fileShard = file.slice(start, end); //从文件中截取当前的分片数据
      let size = file.size;
      let shardTotal = Math.ceil(size / shardSize); //总片数

      // // key："shard"必须和后端controller参数名一致
      // formData.append('shard', fileShard);
      // formData.append('shardIndex', shardIndex);
      // formData.append('shardSize', shardSize);
      // formData.append('shardTotal', shardTotal);
      // formData.append('use', _this.use);
      // formData.append('name', file.name);
      // formData.append('suffix', suffix);
      // formData.append('size', size);
      // formData.append('key', key62);
      // Loading.show();
      // _this.$ajax.post(process.env.VUE_APP_SERVER + '/file/admin/upload', formData).then((response)=>{
      //   Loading.hide();
      //   let resp = response.data;
      //   console.log("上传文件成功：", resp);
      //   _this.afterUpload(resp);
      //   $("#" + _this.inputId + "-input").val("");
      // });

      // 将图片转为base64进行传输
      let fileReader = new FileReader();
      fileReader.onload = function(e) {
        let base64 = e.target.result;
        console.log("base64:", base64);

        let param = {
          'shard': base64,
          'shardIndex': shardIndex,
          'shardSize': shardSize,
          'shardTotal': shardTotal,
          'use': _this.use,
          'name': file.name,
          'suffix': suffix,
          'size': file.size,
          'key': key62
        };

        Loading.show();
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/file/admin/upload', param).then((response)=>{
          Loading.hide();
          let resp = response.data;
          console.log("上传文件成功：", resp);
          _this.afterUpload(resp);
          $("#" + _this.inputId + "-input").val("");
        });
      };
      fileReader.readAsDataURL(fileShard);
    },

    selectFile () {
      let _this = this;
      $("#" + _this.inputId + "-input").trigger("click");
    }
  }
}
</script>
