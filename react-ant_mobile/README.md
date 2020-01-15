# react移动端项目

## 项目说明
### 依赖
1. react
2. redux
3. react-redux
4. react-router
5. ant-mobile
6. create-react-app
7. async-validator  校验器
8. scss

### 使用react、vue对比
react技术栈的难度肯定是远高于vue的，确实不像vue易上手  
react强制使用【this.setState({})】更新等类似的强约束，对于构建大型项目的性能有很好的约束

## create-react-app说明
> [详情](https://create-react-app.dev/docs/getting-started)

### 开发代理
如果需要配置代理，在src/setupProxy.js中配置，依赖于http-proxy-middleware  
添加打包环境的全局参数在".env"中添加   
pwa文件一般用不着，留着无妨。
