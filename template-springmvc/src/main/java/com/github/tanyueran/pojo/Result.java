package com.github.tanyueran.pojo;

// 统一的结果集
public class Result {
  private Integer code;
  private String msg;
  private Object obj;

  public Result() {
  }

  public Result(Integer code, String msg, Object obj) {
    this.code = code;
    this.msg = msg;
    this.obj = obj;
  }

  // 失败的设置
  public static Result setError(String msg) {
    return new Result(-200, msg, false);
  }

  // 成功的设置
  public static Result setSuccess(Object obj) {
    return new Result(200, "ok", obj);
  }

  @Override
  public String toString() {
    return "Result{" +
      "code=" + code +
      ", msg='" + msg + '\'' +
      ", obj=" + obj +
      '}';
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getObj() {
    return obj;
  }

  public void setObj(Object obj) {
    this.obj = obj;
  }
}
