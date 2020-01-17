package com.github.tanyueran.exception;

/**
 * 没有多余的数量了
 */
public class NoAmountException extends RuntimeException {
  public NoAmountException() {
    super("don't have amount");
  }

  public NoAmountException(String message) {
    super(message);
  }
}
