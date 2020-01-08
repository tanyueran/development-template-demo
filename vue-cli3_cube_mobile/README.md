# vue-cli3_cube_mobile
> 推荐使用yarn


## 开发约定
```text
组件：
  1、自定义组件命名：以m开头，如：m_header.vue

css:
  1、css class类以下划线“_”命名区分，组件内的，用"-"区分,如：.header_wrapper   .header_wrapper-title
  2、所有组件内部的css选择器依赖【不允许】使用标签选择器开始，如：div{}// very bad
  3、组件内的class选择器名时，必须使用词组，如：.header{}// very bad
  4、全局的css可以使用一个单词 如：.left{float:left;}
  
js:
  1、不允许使用==,避免类型转换
```

## 项目依赖
```
  vue
  vuex
  vue-router
  cube-ui
  axios
```
