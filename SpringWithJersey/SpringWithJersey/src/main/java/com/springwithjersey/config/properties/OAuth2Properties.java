package com.springwithjersey.config.properties;

import lombok.Data;

@Data
public class OAuth2Properties {
  private Boolean supportRefreshToken;
  private Integer accessTokenValiditySeconds;
}
