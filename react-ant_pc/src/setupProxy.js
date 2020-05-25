/**
 * @author tanxin
 * @date $
 * @Description: 代理
 */
const {createProxyMiddleware} = require('http-proxy-middleware');
module.exports = function (app) {
  app.use(
    '/red',
    createProxyMiddleware({
      target: 'http://localhost:3001',
      changeOrigin: true,
    })
  );
};
