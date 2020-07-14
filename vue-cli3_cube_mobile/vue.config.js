/**
 * @author tanxin
 * @date $
 * @Description vue项目的配置
 */
// 是否为mock模式的
let obj = process.argv[3] ? {
  // 开启mock server数据,process.argv的第四个参数mock 表明是否为mock版本的
  before: require('./mock/index.js')
} : {
  proxy: {
    '^/api': { //替换代理地址名称
      target: 'http://localhost:3002/auth_system_ssm/',
      changeOrigin: true, //可否跨域
      pathRewrite: {
        '^/api': '', //重写接口
      },
    },
  },
};

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
    port: '3000',
    ...obj,
  },
};
