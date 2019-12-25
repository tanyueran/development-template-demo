<template>
  <div class="wrapper">
    <div class="login-box">
      <h1 class="text-center">登录</h1>
      <cube-form
        :model="userInfo"
        :schema="schema"
        :immediate-validate="false"
        :options="options"
        @validate="validateHandler"
        @submit="submitHandler">
      </cube-form>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'login',
    data() {
      return {
        // 用户信息
        userInfo: {
          username: 'admin',
          password: 'password',
        },
        schema: {
          fields: [
            {
              type: 'input',
              modelKey: 'username',
              label: '账号',
              props: {
                placeholder: '请输入'
              },
              rules: {
                required: true
              },
              trigger: 'blur'
            },
            {
              type: 'input',
              modelKey: 'password',
              label: '密码',
              props: {
                placeholder: '请输入'
              },
              rules: {
                required: true
              },
              // validating when blur
              trigger: 'blur'
            },
            {
              type: 'submit',
              label: '登录'
            },
          ],
        },

        options: {
          scrollToInvalidField: true,
          layout: 'classic'
        },
      }
    },
    methods: {
      /*
      * 提交表单
      * */
      submitHandler(e) {
        this.login(this.userInfo);
        e.preventDefault();
      },
      validateHandler(result) {
      },

      /*
      * 登录
      * */
      login(obj) {
        this.$axios({
          url: this.$api.login.login,
          method: 'post',
          data: obj,
        }).then((data) => {
          if (data.code === 100) {
            this.$store.commit('set_isLogin', true);
            this.$store.commit('set_userInfo', data.data);
            this.$router.replace({name: 'home'});
          } else {
            this.$message({
              type: 'error',
              message: data.msg,
            });
          }
        }).catch((err) => {
          console.log(err);
        });
      }
    }
  }
</script>

<style scoped lang="scss">
  .wrapper {
    height: 100%;
    overflow-y: hidden;
    position: relative;

    > .login-box {
      position: absolute;
      padding: 1em 0;
      top: 50%;
      left: 50%;
      width: 80%;
      border: 1px solid #efefef;
      transform: translate(-50%, -50%);

    }
  }
</style>
