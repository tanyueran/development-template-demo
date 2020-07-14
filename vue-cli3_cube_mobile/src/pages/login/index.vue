<template>
	<div class="wrapper">
		<div class="login-box">
			<h1>登录</h1>
			<section>
				<p>
					<span class="icon icon-username cubeic-person"></span>
					<input v-model="userInfo.username" placeholder="账号" type="text">
				</p>
				<p>
					<span class="icon icon-pwd cubeic-lock"></span>
					<input v-model="userInfo.password" placeholder="密码" type="password">
				</p>
				<div class="btn-box">
					<button v-if="!loading" class="login-btn" @click="loginClickHandler">登录</button>
					<button v-else class="login-btn">正在登录...</button>
				</div>
				<div class="btn-box">
					<button class="register-btn" @click="$router.replace({name:'register'})">注册</button>
				</div>
			</section>
		</div>
	</div>
</template>

<script>
  import validator from 'async-validator';
  import {login} from "../../api/user";

  /*
  * 登录页面
  * */
  export default {
    name: 'loginPage',
    data() {
      return {
        loading: false,
        // 用户信息
        userInfo: {
          username: 'admin',
          password: 'password',
        },
        description: {
          username: {
            type: 'string',
            required: true,
          },
          password: {
            type: 'string',
            required: true,
          },
        },
        validator: null,
      }
    },
    created() {
      this.validate = new validator(this.description);
    },
    methods: {
      loginClickHandler() {
        this.validate.validate(this.userInfo, (error, filed) => {
          if (error === null) {
            this.login(this.userInfo)
          }
        });
      },

      /*
      * 登录
      * */
      login(obj) {
        this.loading = true;
        login(obj).then(data => {
          this.$store.commit("set_token", data);
          this.$store.commit("set_isLogin", true);
          this.$store.dispatch("getUserInfo");
          this.$router.replace({name: 'home'});
        }).catch(err => {
          console.log(err);
        }).finally(() => {
          this.loading = false;
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
		background: url("../../assets/images/login-bg.jpg") center center no-repeat;
		background-size: cover;

		> .login-box {
			position: absolute;
			padding: 2em 1em;
			top: 40%;
			left: 50%;
			width: 85%;
			transform: translate(-50%, -50%);
			background-color: rgba(33, 33, 33, .5);
			color: #fff;

			h1 {
				padding-left: px2rem(10);
				font-size: px2rem(20);
				font-weight: 400;
				margin-bottom: px2rem(20);
			}

			p {
				text-align: center;
				position: relative;
				margin-bottom: px2rem(18);
				font-size: px2rem(18);

				.icon {
					color: #efefef;
					position: absolute;
					top: 50%;
					left: px2rem(10);
					transform: translate(0, -50%);
				}

				input {
					width: 100%;
					height: px2rem(35);
					padding-left: 2em;
					background-color: rgba(33, 33, 33, .5);
					color: #fff;

					&::-webkit-input-placeholder {
						color: #909090;
					}
				}
			}
		}

		.btn-box {
			text-align: center;

			&:last-child {
				margin-top: px2rem(10);
			}
		}
	}

	button {
		height: px2rem(35);
		background-color: transparent;
		border: 1px solid #fff;
		color: #f0f0f0;
		width: 100%;

		&.login-btn {
			border-color: transparent;
			background-color: rgba(240, 167, 50, .8);

		}
	}
</style>
