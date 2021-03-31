<template>
  <main role="main">

    <section class="jumbotron text-center">
      <div class="container">
        <h1>嘎哩动漫视频</h1>
        <p class="lead text-muted m-3">
          希望热爱二次元文化和游戏制作的小朋友们能够在社区里得到自己同伴，有别人没有的资源可以分享出来让大家能够为自己的梦想而奋斗
        </p>
        <p>
          <a href="#" class="btn btn-primary my-2 p-3 font-weight-bold">点击进入社区</a>
        </p>
      </div>
    </section>

    <div class="album py-5 bg-light">
      <div class="container">
        <div class="title1">最新上线</div>
        <div class="row">
          <div v-for="o in news" class="col-md-4">
            <div class="card mb-4 shadow-sm course">
              <img class="img-fluid" v-bind:src="o.image">
              <div class="card-body">
                <h4 class="">{{ o.name }}</h4>
                <p class="card-text">{{ o.summary }}</p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">课程详情</button>
                  </div>
                  <div class="text-muted">
                    <span class="badge badge-info"><i class="fa fa-yen"
                                                      aria-hidden="true"></i>&nbsp;{{ o.price }}</span>&nbsp;
                    <span class="badge badge-info"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;123</span>&nbsp;
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

        <hr>

        <div class="title2">好课推荐</div>
        <div class="row">
          <div v-for="o in news" class="col-md-4">
            <div class="card mb-4 shadow-sm course">
              <img class="img-fluid" v-bind:src="o.image">
              <div class="card-body">
                <h4 class="">{{ o.name }}</h4>
                <p class="card-text">{{ o.summary }}</p>
                <div class="d-flex justify-content-between align-items-center">
                  <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">课程详情</button>
                  </div>
                  <div class="text-muted">
                    <span class="badge badge-info"><i class="fa fa-yen"
                                                      aria-hidden="true"></i>&nbsp;{{ o.price }}</span>&nbsp;
                    <span class="badge badge-info"><i class="fa fa-user" aria-hidden="true"></i>&nbsp;123</span>&nbsp;
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </main>
</template>

<script>

export default {
  name: 'index',
  data: function () {
    return {
      news: [],
    }
  },
  mounted() {
    let _this = this;
    _this.listNew();
  },
  methods: {
    /**
     * 查询新上好课
     */
    listNew() {
      let _this = this;
      _this.$ajax.get(process.env.VUE_APP_SERVER + '/business/web/course/list-new').then((response) => {
        console.log("查询新上好课结果：", response);
        let resp = response.data;
        if (resp.success) {
          _this.news = resp.content;
        }
      }).catch((response) => {
        console.log("error：", response);
      })
    },
  }
}
</script>

<style>
.title1 {
  margin-bottom: 2rem;
  color: #fafafa;
  letter-spacing: 0;
  text-shadow: 0px 1px 0px #999, 0px 2px 0px #888, 0px 3px 0px #777, 0px 4px 0px #666, 0px 5px 0px #555, 0px 6px 0px #444, 0px 7px 0px #333, 0px 8px 7px #001135;
  font-size: 2rem;
}

.title2 {
  margin-bottom: 2rem;
  color: transparent;
  -webkit-text-stroke: 1px black;
  letter-spacing: 0.04em;
  font-size: 2rem;
}

.course h4 {
  font-size: 1.25rem;
  margin: 15px 0;
}

.course .text-muted .badge {
  font-size: 1rem;
}
</style>
