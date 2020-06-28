<template>
	<el-header class="header_box" height="84px">
		<div class="header_box-info">
			<div class="toggle-box">
				<a
					class="toggle-btn"
					@click="toggleHandler" :class="[isOpen?'el-icon-s-fold':'el-icon-s-unfold']"></a>
				<!--面包屑导航-->

			</div>
			<div class="info-box">
				<el-avatar title="hello" :src="userImg"/>
				&nbsp;
				<el-dropdown>
          <span class="el-dropdown-link">
            {{userInfo.userName}}<i class="el-icon-caret-bottom"></i>
          </span>
					<el-dropdown-menu slot="dropdown">
						<el-dropdown-item>个人信息</el-dropdown-item>
						<el-dropdown-item>退出</el-dropdown-item>
					</el-dropdown-menu>
				</el-dropdown>
			</div>
		</div>
		<div class="header_box-btn">
			but
		</div>
	</el-header>
</template>

<script>
  import userImg from '../assets/images/user.png';

  export default {
    name: 'm_header',
    computed: {
      userInfo() {
        return this.$store.state.userInfo;
      },
      isOpen() {
        return this.$store.state.navState;
      }
    },
    data() {
      return {
        userImg,
      }
    },
    methods: {
      toggleHandler() {
        this.$store.commit("set_nav_state", !this.$store.state.navState);
      }
    }
  }
</script>

<style scoped lang="scss">
	.header_box {
		display: flex;
		flex-direction: column;
		border-bottom: 1px solid #d8dce5;
		box-shadow: 0 1px 3px 0 rgba(0, 0, 0, 0.12), 0 0 3px 0 rgba(0, 0, 0, 0.04);
	}

	.header_box-info {
		height: 50px;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;

		.toggle-btn {
			font-size: 24px;
		}

		.info-box {
			display: flex;
			align-items: center;
		}
	}


	.header_box-btn {
		flex: 1;
	}
</style>
