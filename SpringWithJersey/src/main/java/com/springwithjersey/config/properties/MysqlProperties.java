package com.springwithjersey.config.properties;

import lombok.Data;

@Data
public class MysqlProperties {
  private String driverClassName;
  private String url;
  private String username;
  private String password;
  private Integer maxPoolSize;
  private Integer minPoolSize;
}
