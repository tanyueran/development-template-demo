<template>
  <div class="box">
    <m-header class="header"></m-header>
    <section class="container clear">
      <keep-alive :include="include">
        <router-view/>
      </keep-alive>
    </section>
    <m-nav class="nav-box"></m-nav>
  </div>
</template>

<script>
  import mHeader from '../common/compons/m_header.vue'
  import mNav from '../common/compons/m_nav.vue'

  export default {
    name: 'home',
    components: {
      mHeader,
      mNav,
    },
    computed: {
      include() {
        return this.$store.state.cacheList;
      }
    },
    data() {
      return {}
    }
  }
</script>

<style scoped lang="scss">
  .box {
    position: relative;
    height: 100%;
    overflow: hidden;
    padding-top: $header-height;
    padding-bottom: $footer-height;

    .header, .nav-box {
      position: absolute;
      left: 0;
      right: 0;
      z-index: 100;
    }

    .header {
      top: 0;
    }

    .nav-box {
      bottom: 0;
    }

    > section {
      height: 100%;
      position: relative;
      overflow-x: hidden;
      overflow-y: auto;
      padding: 1em 0;
    }
  }
</style>
