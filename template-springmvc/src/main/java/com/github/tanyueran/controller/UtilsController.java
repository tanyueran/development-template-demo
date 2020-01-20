package com.github.tanyueran.controller;

import com.github.tanyueran.utils.IdBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/common")
public class UtilsController {
  @Autowired
  @Qualifier("idBuilder")
  private IdBuilder idBuilder;

  // 获取id
  @GetMapping("/id/{num}")
  public List<String> getId(@PathVariable(value = "num", required = false) Integer num) {
    if (num == null) {
      num = 1;
    }
    List<String> list = new ArrayList<>(num);
    for (int i = 0; i < num; i++) {
      list.add(Long.toString(idBuilder.nextId()));
    }
    return list;
  }
}
