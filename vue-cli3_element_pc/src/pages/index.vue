<template>
  <div class="box">
    <m-header class="header"></m-header>
    <section class="container clear">
      <m-nav class="nav-box"></m-nav>
      <div>
        <keep-alive :include="include">
          <router-view/>
        </keep-alive>
      </div>
    </section>
    <m-footer class="footer"></m-footer>
  </div>
</template>

<script>
  import mHeader from '../common/compons/m_header.vue'
  import mFooter from '../common/compons/m_footer.vue'
  import mNav from '../common/compons/m_nav.vue'

  export default {
    name: 'home',
    components: {
      mHeader,
      mFooter,
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
    height: 100%;
    position: relative;
    overflow: hidden;

    .header, .footer {
      position: absolute;
      left: 0;
      right: 0;
      z-index: 100;
    }

    .header {
      top: 0;
    }

    .footer {
      bottom: 0;
    }

    > section {
      height: 100%;
      overflow: hidden;
      padding-top: $header-height;
      padding-bottom: $footer-height;

      > .nav-box {
        float: left;
        width: 18%;
        height: 100%;
      }

      > div {
        height: 100%;
        overflow-y: auto;
        margin-left: 18%;
        padding: 10px;
      }
    }
  }
</style>
