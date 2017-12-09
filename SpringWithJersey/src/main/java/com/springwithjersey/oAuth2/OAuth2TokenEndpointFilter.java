package com.springwithjersey.oAuth2;

import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;

public class OAuth2TokenEndpointFilter extends ClientCredentialsTokenEndpointFilter {

  public OAuth2TokenEndpointFilter() {
    super("/api/login");
  }
}
