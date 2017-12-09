package com.springwithjersey.oAuth2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.util.Assert;

import com.springwithjersey.rest.constants.StatusConstants;

import lombok.Getter;


public class OAuth2UserDetailsService implements UserDetailsService {

  @Getter
  private PasswordEncoder passwordEncoder;

  private JdbcTemplate jdbcTemplate;

  public static final String DEF_USERS_BY_USERNAME_QUERY =
      "select email, password, concat(first_name, ' ', last_name) as name, status, isDeleted from user where email = ?";
  public static final String DEF_ROLE_BY_USERNAME_QUERY =
      "select r.name from role r, user u where u.role_id = r.id and u.email = ?";

  /** The role prefix. */
  private String rolePrefix = "";

  /**
   * Instantiates a new mob gate user details service.
   *
   * @param dataSource the data source
   * @param passwordEncoder the password encoder
   */
  public OAuth2UserDetailsService(DataSource dataSource, PasswordEncoder passwordEncoder) {
    Assert.notNull(dataSource, "DataSource required");
    jdbcTemplate = new JdbcTemplate(dataSource);
    this.passwordEncoder = passwordEncoder;
  }


  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    List<UserDetails> users = loadUsersByUsername(email);

    if (users.size() == 0) {
      throw new UsernameNotFoundException("User with username " + email + " not found");
    }

    UserDetails user = users.get(0); // contains no GrantedAuthority[]
    // check if user is disabled

    if (!user.isEnabled()) {
      throw new OAuth2Exception("You are not allowed to login because you are unauthorized.");
    }
    Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
    dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));

    List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>();
    dbAuths.addAll(dbAuthsSet);
    return createUserDetails(email, user, dbAuths);
  }

  /**
   * Creates the user details.
   *
   * @param email the username
   * @param userFromUserQuery the user from user query
   * @param combinedAuthorities the combined authorities
   * @return the user details
   */
  protected UserDetails createUserDetails(String email, UserDetails userFromUserQuery,
      List<GrantedAuthority> combinedAuthorities) {
    String returnUsername = userFromUserQuery.getUsername();
    String name = ((LoginUserDetail) userFromUserQuery).getName();
    return new LoginUserDetail(returnUsername, userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(), true,
        true, true, combinedAuthorities, name);
  }

  /**
   * Load users by username.
   *
   * @param email the username
   * @return the list
   */
  protected List<UserDetails> loadUsersByUsername(String email) {
    return getJdbcTemplate().query(DEF_USERS_BY_USERNAME_QUERY, new String[] {email}, new RowMapper<UserDetails>() {
      @Override
      public UserDetails mapRow(ResultSet rs, int i) throws SQLException {
        String email = rs.getString("email");
        String password = rs.getString("password");
        String name = rs.getString("name");
        String status = rs.getString("status");
        Boolean isDeleted = rs.getBoolean("isDeleted");
        return new LoginUserDetail(email, password, !isDeleted && StatusConstants.ACTIVE.equalsIgnoreCase(status), true,
            true, true, AuthorityUtils.NO_AUTHORITIES, name);
      }
    });
  }

  /**
   * Load user authorities.
   *
   * @param email the username
   * @return the list
   */
  protected List<GrantedAuthority> loadUserAuthorities(String email) {
    return getJdbcTemplate().query(DEF_ROLE_BY_USERNAME_QUERY, new String[] {email}, new RowMapper<GrantedAuthority>() {
      public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {
        String roleName = rolePrefix + rs.getString("name");
        return new SimpleGrantedAuthority(roleName);
      }
    });
  }

  /**
   * Gets the jdbc template.
   *
   * @return the jdbc template
   */
  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }
}
