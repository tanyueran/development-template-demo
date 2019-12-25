<template>
  <div class="wrapper">
    <div class="login-box">
      <h1 class="text-center">登录</h1>
      <el-form ref="form"
               :rules="form"
               :model="userInfo"
               label-width="80px">
        <el-form-item label="账号" prop="username">
          <el-input v-model="userInfo.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="userInfo.password"></el-input>
        </el-form-item>
      </el-form>
      <footer class="text-center">
        <el-button @click="loginHandler">登录</el-button>
      </footer>
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
        // 验证
        form: {
          username: [
            {required: true, message: '请输入账号', trigger: 'blur'},
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ],
        }
      }
    },
    methods: {
      /*
      * 登录事件监听
      * */
      loginHandler() {
        this.$refs.form.validate((result) => {
          if (result) {
            this.login(this.userInfo);
          }
        });
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

    h1 {
      margin: 1em 0;
    }

    > .login-box {
      position: absolute;
      width: 460px;
      top: 50%;
      left: 70%;
      border: 1px solid #efefef;
      padding: 50px 100px;
      transform: translate(-50%, -50%);

      p {
        margin-bottom: 10px;
      }
    }
  }
</style>
