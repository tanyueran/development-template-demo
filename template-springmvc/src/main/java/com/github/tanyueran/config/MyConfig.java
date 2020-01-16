package com.github.tanyueran.config;

import com.github.tanyueran.utils.IdBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MyConfig {

  // id生成器
  @Bean
  public IdBuilder IdBuilder() {
    return new IdBuilder(1, 1, 1);
  }
}
