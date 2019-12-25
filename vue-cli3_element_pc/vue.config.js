/**
 * @author tanxin
 * @date $
 * @Description vue项目的配置
 */
module.exports = {
  lintOnSave: false,
  publicPath: './',

  productionSourceMap: true,

  css: {
    loaderOptions: {
      sass: {
        prependData: `@import "~@/style/variable.scss";`,
      }
    }
  },

  // 开发的代理
  devServer: {
    disableHostCheck: true,
    proxy: {
      '/wl_mobile_api': { //替换代理地址名称
        target: 'http://10.19.0.55:8001/',
        changeOrigin: true, //可否跨域
        pathRewrite: {
          '^/wl_mobile_api': '/services', //重写接口
        },
      },
    },
  },
};
