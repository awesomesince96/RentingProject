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

  public String getDriverClassName() {
    return driverClassName;
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getMaxPoolSize() {
    return maxPoolSize;
  }

  public void setMaxPoolSize(Integer maxPoolSize) {
    this.maxPoolSize = maxPoolSize;
  }

  public Integer getMinPoolSize() {
    return minPoolSize;
  }

  public void setMinPoolSize(Integer minPoolSize) {
    this.minPoolSize = minPoolSize;
  }


}
