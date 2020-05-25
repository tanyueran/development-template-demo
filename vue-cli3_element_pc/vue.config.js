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
    port: '3002',
    proxy: {
      '/api': { //替换代理地址名称
        target: 'http://localhost:3002/',
        changeOrigin: true, //可否跨域
        pathRewrite: {
          '^/api': '/services', //重写接口
        },
      },
    },
  },
};
