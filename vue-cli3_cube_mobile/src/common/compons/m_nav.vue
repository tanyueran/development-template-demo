<template>
  <ul>
    <li @click="goto('home')"
        :class="[$route.name=='home'?'active':'']">
      <span class="cubeic-home"></span>
      首页
    </li>
    <li @click="goto('page1')"
        :class="[$route.name=='page1'?'active':'']">
      <span class="cubeic-message"></span>
      消息
    </li>
    <li @click="goto('page2')"
        :class="[$route.name=='page2'?'active':'']">
      <span class="cubeic-credit-card"></span>
      应用
    </li>
    <li @click="goto('page3')"
        :class="[$route.name=='page3'?'active':'']">
      <span class="cubeic-person"></span>
      我的
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
    border-top: 1px solid #efefef;
    display: flex;
    height: $footer-height;

    > li {
      cursor: pointer;
      text-align: center;
      position: relative;
      flex-grow: 1;
      flex-basis: 0;
      flex-shrink: 0;
      overflow: hidden;
      background-color: rgb(244, 244, 244);
      display: flex;
      flex-direction: column;
      justify-content: center;
      font-size: px2rem(16);
      color: #909090;

      > span {
        margin-bottom: px2rem(4);
      }

      &.active {
        color: $blue-color;
      }

      &:after {
        content: "";
        display: block;
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        pointer-events: none;
        //设置径向渐变
        background-image: radial-gradient(circle, #666 10%, transparent 10.01%);
        background-repeat: no-repeat;
        background-position: 50%;
        transform: scale(10, 10);
        opacity: 0;
        transition: transform .3s, opacity .5s;
      }

      &:active:after {
        transform: scale(0, 0);
        opacity: .3;
        //设置初始状态
        transition: 0s;
      }
    }
  }

</style>
