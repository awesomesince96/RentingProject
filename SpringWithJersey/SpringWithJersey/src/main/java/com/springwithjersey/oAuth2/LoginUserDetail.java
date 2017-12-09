package com.springwithjersey.oAuth2;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class LoginUserDetail extends org.springframework.security.core.userdetails.User {

  private String name;

  public LoginUserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities,
      String name) {
    super(username, password, authorities);
    this.name = name;
  }

  public LoginUserDetail(String username, String password, boolean enabled, boolean accountNonExpired,
      boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
      String name) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
