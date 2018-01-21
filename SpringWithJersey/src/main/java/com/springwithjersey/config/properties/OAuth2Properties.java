package com.springwithjersey.config.properties;

import lombok.Data;

@Data
public class OAuth2Properties {
  private Boolean supportRefreshToken;
  private Integer accessTokenValiditySeconds;

  public Boolean getSupportRefreshToken() {
    return supportRefreshToken;
  }

  public void setSupportRefreshToken(Boolean supportRefreshToken) {
    this.supportRefreshToken = supportRefreshToken;
  }

  public Integer getAccessTokenValiditySeconds() {
    return accessTokenValiditySeconds;
  }

  public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
    this.accessTokenValiditySeconds = accessTokenValiditySeconds;
  }


}
