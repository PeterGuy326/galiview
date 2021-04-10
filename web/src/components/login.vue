<template>
    <div id="login-modal" class="modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-login" role="document">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="login-div" v-show="MODAL_STATUS === STATUS_LOGIN">
                        <h3>登&nbsp;&nbsp;录</h3>
                        <div class="form-group">
                            <input v-model="member.mobile" class="form-control" placeholder="手机号">
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="password" placeholder="密码" v-model="member.passwordOriginal">
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <input id="image-code-input" class="form-control" type="text" placeholder="验证码"
                                       v-model="member.imageCode">
                                <div class="input-group-addon" id="image-code-addon">
                                    <img id="image-code" alt="验证码" v-on:click="loadImageCode()"/>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-block submit-button">
                                登&nbsp;&nbsp;录
                            </button>
                        </div>
                        <div class="form-group">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" class=" rememberMe" v-model="rememberMe"> 记住密码
                                </label>
                                <div class="pull-right">
                                    <a href="javascript:;" v-on:click="toForgetDiv()">忘记密码</a>&nbsp;
                                    <a href="javascript:;" v-on:click="toRegisterDiv()">我要注册</a>
                                </div>
                            </div>
                        </div>
                        <div class="form-group to-register-div">
                        </div>
                    </div>
                    <div class="register-div" v-show="MODAL_STATUS === STATUS_REGISTER">
                        <h3>注&nbsp;&nbsp;册</h3>
                        <div class="form-group">
                            <input id="register-mobile" v-model="memberRegister.mobile"
                                   class="form-control" placeholder="手机号">
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <input id="register-mobile-code" class="form-control"
                                       placeholder="手机验证码" v-model="memberRegister.code">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" id="register-send-code-btn"
                                            v-on:click="sendSmsForRegister()">发送验证码
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input id="register-name" v-model="memberRegister.name"
                                   class="form-control" placeholder="昵称">
                        </div>
                        <div class="form-group">
                            <input id="register-password" v-model="memberRegister.passwordOriginal"
                                   class="form-control" placeholder="密码" type="password">
                        </div>
                        <div class="form-group">
                            <input id="register-confirm-password" v-model="memberRegister.confirm"
                                   class="form-control" placeholder="确认密码"
                                   name="memberRegisterConfirm" type="password">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-block submit-button" v-on:click="register()">
                                注&nbsp;&nbsp;册
                            </button>
                        </div>
                        <div class="form-group to-login-div">
                            <a href="javascript:;" v-on:click="toLoginDiv()">我要登录</a>
                        </div>
                    </div>
                    <div class="forget-div" v-show="MODAL_STATUS === STATUS_FORGET">
                        <h3>忘记密码</h3>
                        <div class="form-group">
                            <input id="forget-mobile" v-model="memberForget.mobile"
                                   class="form-control" placeholder="手机号">
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <input id="forget-mobile-code" class="form-control"
                                       placeholder="手机验证码" v-model="memberForget.code">
                                <div class="input-group-append">
                                    <button class="btn btn-outline-secondary" id="forget-send-code-btn">
                                        发送验证码
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input id="forget-password" v-model="memberForget.passwordOriginal"
                                   class="form-control" placeholder="密码" type="password">
                        </div>
                        <div class="form-group">
                            <input id="forget-confirm-password" v-model="memberForget.confirm"
                                   class="form-control" placeholder="确认密码" type="password">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary btn-block submit-button">
                                重&nbsp;&nbsp;置
                            </button>
                        </div>
                        <div class="form-group to-login-div">
                            <a href="javascript:;" v-on:click="toLoginDiv()">我要登录</a>
                        </div>
                    </div>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</template>

<script>

  export default {
    name: 'the-login',
    data: function () {
      return {
        // 模态框内容切换：登录、注册、忘记密码
        STATUS_LOGIN: "STATUS_LOGIN",
        STATUS_REGISTER: "STATUS_REGISTER",
        STATUS_FORGET: "STATUS_FORGET",
        MODAL_STATUS: "",

        member: {},
        memberForget: {},
        memberRegister: {},

        rememberMe: true, // 记住密码
        imageCodeToken: ""
      }
    },
    mounted() {
      let _this = this;
      _this.toLoginDiv();
    },
    methods: {

      /**
       * 打开登录注册窗口
       */
      openLoginModal() {
        let _this = this;
        $("#login-modal").modal("show");
      },

      //---------------登录框、注册框、忘记密码框切换-----------------
      toLoginDiv() {
        let _this = this;
        _this.MODAL_STATUS = _this.STATUS_LOGIN
      },
      toRegisterDiv() {
        let _this = this;
        _this.MODAL_STATUS = _this.STATUS_REGISTER
      },
      toForgetDiv() {
        let _this = this;
        _this.MODAL_STATUS = _this.STATUS_FORGET
      },

      register() {
        let _this = this;
        _this.memberRegister.password = hex_md5(_this.memberRegister.passwordOriginal + KEY);

        // 调服务端注册接口
        _this.$ajax.post(process.env.VUE_APP_SERVER + '/business/web/member/register', _this.memberRegister).then((response) => {
          let resp = response.data;
          if (resp.success) {
            Toast.success("注册成功");
          } else {
            Toast.warning(resp.message);
          }
        })
      },

    }
  }
</script>

<style scoped>
    /* 登录框 */
    .login-div .input-group-addon {
        padding: 0;
        border: 0;
    }

    #login-modal h3 {
        text-align: center;
        margin-bottom: 20px;
    }

    #login-modal .modal-login {
        max-width: 400px;
    }

    #login-modal input:not(.rememberMe) {
        height: 45px;
        font-size: 16px;
    }

    #login-modal .submit-button {
        height: 50px;
        font-size: 20px;
    }

    #login-modal .to-login-div {
        text-align: center;
    }
</style>
