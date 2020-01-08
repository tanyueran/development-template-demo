<template>
  <div id="app">
    <a-spin
      size="large"
      :delay="100"
      wrapperClassName="a-spin"
      :spinning="isLoading">
      <router-view/>
    </a-spin>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component({
  computed: {
    isLoading() {
      return this.$store.state.isLoading;
    },
  },
})
export default class App extends Vue {
}
</script>

<style scoped lang="scss">
  #app {
    height: 100%;
  }

  .a-spin{
    height: 100%;
  }
</style>
