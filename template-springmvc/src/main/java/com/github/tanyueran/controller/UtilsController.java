package com.github.tanyueran.controller;

import com.github.tanyueran.utils.IdBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class UtilsController {
  @Autowired
  private IdBuilder idBuilder;

  // 获取id
  @GetMapping("/id")
  public String getId() {
    return Long.toString(idBuilder.nextId());
  }
}
