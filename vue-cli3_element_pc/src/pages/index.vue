<template>
  <div class="app-box">
    <m-header class="app-header"></m-header>
    <section class="app-section clear">
      <m-nav class="app-nav-box"></m-nav>
      <div class="app-container">
        <keep-alive :include="include">
          <router-view/>
        </keep-alive>
      </div>
    </section>
    <m-footer class="app-footer"></m-footer>
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
  .app-box {
    height: 100%;
    position: relative;
    overflow: hidden;

    .app-header, .app-header {
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

    > .app-section {
      height: 100%;
      overflow: hidden;
      padding-top: $header-height;
      padding-bottom: $footer-height;

      > .app-nav-box {
        float: left;
        width: 18%;
        height: 100%;
        overflow-y: auto;
      }

      > .app-container {
        height: 100%;
        overflow-y: auto;
        margin-left: 18%;
        padding: 10px;
      }
    }
  }
</style>
