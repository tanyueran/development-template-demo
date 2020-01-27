package com.github.tanyueran.controller;

import com.github.tanyueran.pojo.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 返回的消息处理
 */
@ControllerAdvice
public class AdviceController implements ResponseBodyAdvice {

	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}

	// 处理成功
	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
		if (body instanceof Result) {
			return body;
		}
		return Result.setSuccess(body);
	}

	// 错误监听
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result handlerMyException(Exception e) {
		e.printStackTrace();
		// 获取校验的结果信息，并返回
		if (e instanceof MethodArgumentNotValidException) {
			return Result.setError(((MethodArgumentNotValidException) e).getBindingResult().getFieldError().getDefaultMessage());
		}
		return Result.setError(e.getMessage());
	}
}
