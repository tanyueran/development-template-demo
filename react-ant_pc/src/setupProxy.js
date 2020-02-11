/**
 * @author tanxin
 * @date $
 * @Description: 代理
 */
const proxy = require('http-proxy-middleware');
module.exports = function (app) {
  app.use(
    '/red',
    proxy({
      target: 'http://localhost:3000',
      changeOrigin: true,
    })
  );
};
