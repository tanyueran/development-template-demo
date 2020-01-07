<template>
  <div class="nav-wrapper">
    <el-menu
      :router="true">
      <el-submenu index="">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>导航一</span>
        </template>
        <el-menu-item-group>
          <template slot="title">分组一</template>
          <el-menu-item index="/home/page1">页面1</el-menu-item>
          <el-menu-item index="/home/page2">页面2</el-menu-item>
          <el-menu-item index="/home/page3">页面3</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-menu-item index="/home/page1">
        <i class="el-icon-menu"></i>
        <span slot="title">页面一</span>
      </el-menu-item>
      <el-menu-item index="/home/page2">
        <i class="el-icon-document"></i>
        <span slot="title">页面二</span>
      </el-menu-item>
      <el-menu-item index="/home/page3">
        <i class="el-icon-setting"></i>
        <span slot="title">页面三</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
  /*
  * 导航组件
  * */
  export default {
    name: 'm_nav',
    data() {
      return {
        navList: [
          {},
        ]
      }
    },
    watch: {
      $rotuer() {

      }
    },
    methods: {
      /*
      * 跳转页面
      * */
      goto(name) {
        if (name !== this.$route.name) {
          this.$router.push({name}).then(() => {
          }).catch((err) => {
            console.log("--------路由跳转错误");
            console.log(err);
          });
        }
      }
    }
  }
</script>

<style scoped lang="scss">

</style>
