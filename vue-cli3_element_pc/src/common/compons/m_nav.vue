<template>
  <ul>
    <li @click="goto('page1')">
      页面1
    </li>
    <li @click="goto('page2')">
      页面2
    </li>
    <li @click="goto('page3')">
      页面3
    </li>
  </ul>
</template>

<script>
  /*
  * 导航组件
  * */
  export default {
    name: 'm_nav',
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
  ul {
    border-right: 1px solid #efefef;
  }

  li {
    height: 50px;
    line-height: 50px;
    padding-left: 1em;
    border-bottom: 1px solid #efefef;
    cursor: pointer;
  }
</style>
