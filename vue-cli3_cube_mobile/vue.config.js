/**
 * @author tanxin
 * @date $
 * @Description vue项目的配置
 */
module.exports = {
  lintOnSave: false,// 开发环境每次检测格式

  publicPath: './',

  productionSourceMap: true,

  css: {
    loaderOptions: {
      // cube的样式
      stylus: {
        'resolve url': true,
        import: [
          './src/style/cube',
        ],
      },
      sass: {
        prependData: `@import "~@/style/variable.scss";`,
      }
    }
  },

  pluginOptions: {
    'cube-ui': {
      postCompile: true,
      theme: true,
    },
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
