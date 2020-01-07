<template>
  <header class="header_wrapper">
    <div class="header_wrapper-container clear">
      <a class="header_wrapper-logo left">
        welcome：个人管理系统
      </a>
      <div class="header_wrapper-user right">
        <el-avatar title="hello" :src="userImg"></el-avatar>
        <el-dropdown>
          <span class="el-dropdown-link">
            {{userInfo.name}}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </header>
</template>

<script>
  import userImg from '../../assets/images/user.png';

  export default {
    name: 'm_header',
    computed: {
      userInfo() {
        return this.$store.getters.get_userInfo;
      }
    },
    data() {
      return {
        userImg,
      }
    }
  }
</script>

<style scoped lang="scss">
  .header_wrapper {
    height: $header-height;
    line-height: $header-height;
    border: 1px solid #efefef;
    background-color: #fff;
    box-shadow: 0 0 6px #efefef;

    .header_wrapper-container {
      width: $container-width;
      margin: 0 auto;
    }

    .header_wrapper-user {
      height: $header-height;
      display: flex;
      align-items: center;

      [title="hello"] {
        margin-right: 10px;
      }
    }


  }
</style>
