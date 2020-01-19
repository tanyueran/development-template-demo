package com.github.tanyueran.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 红包金额随机
public class RedUtils {

  /***
   * 红包随机算法
   * @param remainSize ：剩余红包苏
   * @param remainMoney： 剩余金额
   * @return 随机金额数
   */
  public static double randomNum(Integer remainSize, Double remainMoney) {
    // remainSize 剩余的红包数量
    // money 剩余的钱
    if (remainSize == null || remainSize <= 0) {
      throw new RuntimeException("剩余红包数必须大于0");
    }

    if (remainMoney == null || remainMoney <= 0) {
      throw new RuntimeException("剩余的金额必要大于0");
    }

    if (remainSize == 1) {
      return (double) Math.round(remainMoney * 100) / 100;
    }
    Random r = new Random();
    // 随机是应在0.01 和 平均数的2倍之间
    double min = 0.01;
    double max = remainMoney / remainSize * 2;
    double _money = r.nextDouble() * max;
    _money = _money <= min ? 0.01 : _money;
    return (double) Math.round(_money * 100) / 100;
  }

  public static void main(String[] args) {
    int size = 4;
    double money = 4;
    int len = size;
    List<Double> list = new ArrayList<>(10);
    for (int i = 0; i < len; i++) {
      double j = RedUtils.randomNum(size, money);
      System.out.println("剩余红包数:" + size + "剩余金额数：" + money + "随机金额：" + j);
      size--;
      money -= j;
      list.add(j);
    }
    System.out.println(list);
    double total = list.stream().mapToDouble(item -> item).sum();
    System.out.println(total);
  }

}
