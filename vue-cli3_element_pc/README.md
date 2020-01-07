# vue-cli3_element_pc
> 使用yarn打包

## 项目安装依赖-初始化
```
yarn install
```
---

### 项目开发
```
yarn run serve
```
---

### 项目打包
```
yarn run build
```
---

### 代码约定
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


### 依赖库
- vue
- vuex 
- vue-router
- axios
- element-ui
- scss

---
### 修改思考
```text
2020/1/7:
原本打算将ts加入项目中，但是在本来约束的东西，却将项目的复杂度翻了好几倍，所以一般项目并不适合使用ts，如果是组件、函数库等确实很适合。
```

