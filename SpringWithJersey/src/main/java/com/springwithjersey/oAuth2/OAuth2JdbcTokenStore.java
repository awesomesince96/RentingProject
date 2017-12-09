package com.springwithjersey.oAuth2;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.common.util.SerializationUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.Assert;

public class OAuth2JdbcTokenStore implements TokenStore {
  private static final Log LOG = LogFactory.getLog(OAuth2JdbcTokenStore.class);

  /** The Constant DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT. */
  private static final String DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT =
      "insert into oauth2accesstoken (TokenId, Token, AuthenticationId, UserName, ClientId, Authentication, RefreshToken) values (?, ?, ?, ?, ?, ?, ?)";

  /** The Constant DEFAULT_ACCESS_TOKEN_SELECT_STATEMENT. */
  private static final String DEFAULT_ACCESS_TOKEN_SELECT_STATEMENT =
      "select TokenId, Token from oauth2accesstoken where TokenId = ?";

  /** The Constant DEFAULT_ACCESS_TOKEN_AUTHENTICATION_SELECT_STATEMENT. */
  private static final String DEFAULT_ACCESS_TOKEN_AUTHENTICATION_SELECT_STATEMENT =
      "select TokenId, Authentication from oauth2accesstoken where TokenId = ?";

  /** The Constant DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT. */
  private static final String DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT =
      "select TokenId, Token from oauth2accesstoken where AuthenticationId = ?";

  /** The Constant DEFAULT_ACCESS_TOKENS_FROM_USERNAME_AND_CLIENT_SELECT_STATEMENT. */
  private static final String DEFAULT_ACCESS_TOKENS_FROM_USERNAME_AND_CLIENT_SELECT_STATEMENT =
      "select TokenId, Token from oauth2accesstoken where UserName = ? and ClientId = ?";

  /** The Constant DEFAULT_ACCESS_TOKENS_FROM_CLIENTID_SELECT_STATEMENT. */
  private static final String DEFAULT_ACCESS_TOKENS_FROM_CLIENTID_SELECT_STATEMENT =
      "select TokenId, Token from oauth2accesstoken where ClientId = ?";

  /** The Constant DEFAULT_ACCESS_TOKEN_DELETE_STATEMENT. */
  private static final String DEFAULT_ACCESS_TOKEN_DELETE_STATEMENT =
      "delete from oauth2accesstoken where TokenId = ?";

  /** The Constant DEFAULT_ACCESS_TOKEN_DELETE_FROM_REFRESH_TOKEN_STATEMENT. */
  private static final String DEFAULT_ACCESS_TOKEN_DELETE_FROM_REFRESH_TOKEN_STATEMENT =
      "delete from oauth2accesstoken where RefreshToken = ?";

  /** The Constant DEFAULT_REFRESH_TOKEN_INSERT_STATEMENT. */
  private static final String DEFAULT_REFRESH_TOKEN_INSERT_STATEMENT =
      "insert into oauth2refreshtoken (TokenId, Token, Authentication) values (?, ?, ?)";

  /** The Constant DEFAULT_REFRESH_TOKEN_SELECT_STATEMENT. */
  private static final String DEFAULT_REFRESH_TOKEN_SELECT_STATEMENT =
      "select TokenId, Token from oauth2refreshtoken where TokenId = ?";

  /** The Constant DEFAULT_REFRESH_TOKEN_AUTHENTICATION_SELECT_STATEMENT. */
  private static final String DEFAULT_REFRESH_TOKEN_AUTHENTICATION_SELECT_STATEMENT =
      "select TokenId, Authentication from oauth2refreshtoken where TokenId = ?";

  /** The Constant DEFAULT_REFRESH_TOKEN_DELETE_STATEMENT. */
  private static final String DEFAULT_REFRESH_TOKEN_DELETE_STATEMENT =
      "delete from oauth2refreshtoken where TokenId = ?";

  /** The insert access token sql. */
  private String insertAccessTokenSql = DEFAULT_ACCESS_TOKEN_INSERT_STATEMENT;

  /** The select access token sql. */
  private String selectAccessTokenSql = DEFAULT_ACCESS_TOKEN_SELECT_STATEMENT;

  /** The select access token authentication sql. */
  private String selectAccessTokenAuthenticationSql = DEFAULT_ACCESS_TOKEN_AUTHENTICATION_SELECT_STATEMENT;

  /** The select access token from authentication sql. */
  private String selectAccessTokenFromAuthenticationSql = DEFAULT_ACCESS_TOKEN_FROM_AUTHENTICATION_SELECT_STATEMENT;

  /** The select access tokens from user name and client id sql. */
  private String selectAccessTokensFromUserNameAndClientIdSql =
      DEFAULT_ACCESS_TOKENS_FROM_USERNAME_AND_CLIENT_SELECT_STATEMENT;

  /** The select access tokens from client id sql. */
  private String selectAccessTokensFromClientIdSql = DEFAULT_ACCESS_TOKENS_FROM_CLIENTID_SELECT_STATEMENT;

  /** The delete access token sql. */
  private String deleteAccessTokenSql = DEFAULT_ACCESS_TOKEN_DELETE_STATEMENT;

  /** The insert refresh token sql. */
  private String insertRefreshTokenSql = DEFAULT_REFRESH_TOKEN_INSERT_STATEMENT;

  /** The select refresh token sql. */
  private String selectRefreshTokenSql = DEFAULT_REFRESH_TOKEN_SELECT_STATEMENT;

  /** The select refresh token authentication sql. */
  private String selectRefreshTokenAuthenticationSql = DEFAULT_REFRESH_TOKEN_AUTHENTICATION_SELECT_STATEMENT;

  /** The delete refresh token sql. */
  private String deleteRefreshTokenSql = DEFAULT_REFRESH_TOKEN_DELETE_STATEMENT;

  /** The delete access token from refresh token sql. */
  private String deleteAccessTokenFromRefreshTokenSql = DEFAULT_ACCESS_TOKEN_DELETE_FROM_REFRESH_TOKEN_STATEMENT;

  /** The authentication key generator. */
  private AuthenticationKeyGenerator authenticationKeyGenerator = new DefaultAuthenticationKeyGenerator();

  /** The jdbc template. */
  private final JdbcTemplate jdbcTemplate;

  /**
   * Instantiates a new mob gate jdbc token store.
   *
   * @param dataSource the data source
   */
  public OAuth2JdbcTokenStore(DataSource dataSource) {
    Assert.notNull(dataSource, "DataSource required");
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  /**
   * Sets the authentication key generator.
   *
   * @param authenticationKeyGenerator the new authentication key generator
   */
  public void setAuthenticationKeyGenerator(AuthenticationKeyGenerator authenticationKeyGenerator) {
    this.authenticationKeyGenerator = authenticationKeyGenerator;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.oauth2.provider.token.TokenStore#getAccessToken(org.springframework.security.oauth2.
   * provider.OAuth2Authentication)
   */
  public OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
    OAuth2AccessToken accessToken = null;

    String key = authenticationKeyGenerator.extractKey(authentication);
    try {
      accessToken =
          jdbcTemplate.queryForObject(selectAccessTokenFromAuthenticationSql, new RowMapper<OAuth2AccessToken>() {
            public OAuth2AccessToken mapRow(ResultSet rs, int rowNum) throws SQLException {
              return deserializeAccessToken(rs.getBytes(2));
            }
          }, key);
    } catch (EmptyResultDataAccessException e) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("Failed to find access token for authentication " + authentication);
      }
    } catch (IllegalArgumentException e) {
      LOG.error("Could not extract access token for authentication " + authentication, e);
    } catch (IncorrectResultSizeDataAccessException e) {
      LOG.error("Could not extract access token for authentication " + authentication, e);
    }

    if (accessToken != null
        && !key.equals(authenticationKeyGenerator.extractKey(readAuthentication(accessToken.getValue())))) {
      removeAccessToken(accessToken.getValue());
      // Keep the store consistent (maybe the same user is represented by this authentication but the details have
      // changed)
      storeAccessToken(accessToken, authentication);
    }
    return accessToken;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.oauth2.provider.token.TokenStore#storeAccessToken(org.springframework.security.oauth2.
   * common.OAuth2AccessToken, org.springframework.security.oauth2.provider.OAuth2Authentication)
   */
  public void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
    String refreshToken = null;
    if (token.getRefreshToken() != null) {
      refreshToken = token.getRefreshToken().getValue();
    }

    if (readAccessToken(token.getValue()) != null) {
      removeAccessToken(token.getValue());
    }

    jdbcTemplate.update(insertAccessTokenSql,
        new Object[] {extractTokenKey(token.getValue()), new SqlLobValue(serializeAccessToken(token)),
            authenticationKeyGenerator.extractKey(authentication),
            authentication.isClientOnly() ? null : authentication.getName(),
            authentication.getOAuth2Request().getClientId(), new SqlLobValue(serializeAuthentication(authentication)),
            extractTokenKey(refreshToken)},
        new int[] {Types.VARCHAR, Types.BLOB, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BLOB, Types.VARCHAR});
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.oauth2.provider.token.TokenStore#readAccessToken(java.lang.String)
   */
  public OAuth2AccessToken readAccessToken(String tokenValue) {
    OAuth2AccessToken accessToken = null;

    try {
      accessToken = jdbcTemplate.queryForObject(selectAccessTokenSql, new RowMapper<OAuth2AccessToken>() {
        public OAuth2AccessToken mapRow(ResultSet rs, int rowNum) throws SQLException {
          return deserializeAccessToken(rs.getBytes(2));
        }
      }, extractTokenKey(tokenValue));
    } catch (EmptyResultDataAccessException e) {
      if (LOG.isInfoEnabled()) {
        LOG.info("Failed to find access token for token " + tokenValue);
      }
    } catch (IllegalArgumentException e) {
      LOG.warn("Failed to deserialize access token for " + tokenValue, e);
      removeAccessToken(tokenValue);
    }

    return accessToken;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.oauth2.provider.token.TokenStore#removeAccessToken(org.springframework.security.oauth2
   * .common.OAuth2AccessToken)
   */
  public void removeAccessToken(OAuth2AccessToken token) {
    removeAccessToken(token.getValue());
  }

  /**
   * Removes the access token.
   *
   * @param tokenValue the token value
   */
  public void removeAccessToken(String tokenValue) {
    jdbcTemplate.update(deleteAccessTokenSql, extractTokenKey(tokenValue));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.oauth2.provider.token.TokenStore#readAuthentication(org.springframework.security.
   * oauth2.common.OAuth2AccessToken)
   */
  public OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
    return readAuthentication(token.getValue());
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.oauth2.provider.token.TokenStore#readAuthentication(java.lang.String)
   */
  public OAuth2Authentication readAuthentication(String token) {
    OAuth2Authentication authentication = null;

    try {
      authentication =
          jdbcTemplate.queryForObject(selectAccessTokenAuthenticationSql, new RowMapper<OAuth2Authentication>() {
            public OAuth2Authentication mapRow(ResultSet rs, int rowNum) throws SQLException {
              return deserializeAuthentication(rs.getBytes(2));
            }
          }, extractTokenKey(token));
    } catch (EmptyResultDataAccessException e) {
      if (LOG.isInfoEnabled()) {
        LOG.info("Failed to find access token for token " + token);
      }
    } catch (IllegalArgumentException e) {
      LOG.warn("Failed to deserialize authentication for " + token, e);
      removeAccessToken(token);
    }

    return authentication;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.oauth2.provider.token.TokenStore#storeRefreshToken(org.springframework.security.oauth2
   * .common.OAuth2RefreshToken, org.springframework.security.oauth2.provider.OAuth2Authentication)
   */
  public void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
    jdbcTemplate.update(insertRefreshTokenSql,
        new Object[] {extractTokenKey(refreshToken.getValue()), new SqlLobValue(serializeRefreshToken(refreshToken)),
            new SqlLobValue(serializeAuthentication(authentication))},
        new int[] {Types.VARCHAR, Types.BLOB, Types.BLOB});
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.oauth2.provider.token.TokenStore#readRefreshToken(java.lang.String)
   */
  public OAuth2RefreshToken readRefreshToken(String token) {
    OAuth2RefreshToken refreshToken = null;

    try {
      refreshToken = jdbcTemplate.queryForObject(selectRefreshTokenSql, new RowMapper<OAuth2RefreshToken>() {
        public OAuth2RefreshToken mapRow(ResultSet rs, int rowNum) throws SQLException {
          return deserializeRefreshToken(rs.getBytes(2));
        }
      }, extractTokenKey(token));
    } catch (EmptyResultDataAccessException e) {
      if (LOG.isInfoEnabled()) {
        LOG.info("Failed to find refresh token for token " + token);
      }
    } catch (IllegalArgumentException e) {
      LOG.warn("Failed to deserialize refresh token for token " + token, e);
      removeRefreshToken(token);
    }

    return refreshToken;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.oauth2.provider.token.TokenStore#removeRefreshToken(org.springframework.security.
   * oauth2.common.OAuth2RefreshToken)
   */
  public void removeRefreshToken(OAuth2RefreshToken token) {
    removeRefreshToken(token.getValue());
  }

  /**
   * Removes the refresh token.
   *
   * @param token the token
   */
  public void removeRefreshToken(String token) {
    jdbcTemplate.update(deleteRefreshTokenSql, extractTokenKey(token));
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.oauth2.provider.token.TokenStore#readAuthenticationForRefreshToken(org.springframework
   * .security.oauth2.common.OAuth2RefreshToken)
   */
  public OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
    return readAuthenticationForRefreshToken(token.getValue());
  }

  /**
   * Read authentication for refresh token.
   *
   * @param value the value
   * @return the o auth2 authentication
   */
  public OAuth2Authentication readAuthenticationForRefreshToken(String value) {
    OAuth2Authentication authentication = null;

    try {
      authentication =
          jdbcTemplate.queryForObject(selectRefreshTokenAuthenticationSql, new RowMapper<OAuth2Authentication>() {
            public OAuth2Authentication mapRow(ResultSet rs, int rowNum) throws SQLException {
              return deserializeAuthentication(rs.getBytes(2));
            }
          }, extractTokenKey(value));
    } catch (EmptyResultDataAccessException e) {
      if (LOG.isInfoEnabled()) {
        LOG.info("Failed to find access token for token " + value);
      }
    } catch (IllegalArgumentException e) {
      LOG.warn("Failed to deserialize access token for " + value, e);
      removeRefreshToken(value);
    }

    return authentication;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.oauth2.provider.token.TokenStore#removeAccessTokenUsingRefreshToken(org.
   * springframework.security.oauth2.common.OAuth2RefreshToken)
   */
  public void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
    removeAccessTokenUsingRefreshToken(refreshToken.getValue());
  }

  /**
   * Removes the access token using refresh token.
   *
   * @param refreshToken the refresh token
   */
  public void removeAccessTokenUsingRefreshToken(String refreshToken) {
    jdbcTemplate.update(deleteAccessTokenFromRefreshTokenSql, new Object[] {extractTokenKey(refreshToken)},
        new int[] {Types.VARCHAR});
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.security.oauth2.provider.token.TokenStore#findTokensByClientId(java.lang.String)
   */
  public Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
    List<OAuth2AccessToken> accessTokens = new ArrayList<OAuth2AccessToken>();

    try {
      accessTokens = jdbcTemplate.query(selectAccessTokensFromClientIdSql, new SafeAccessTokenRowMapper(), clientId);
    } catch (EmptyResultDataAccessException e) {
      if (LOG.isInfoEnabled()) {
        LOG.info("Failed to find access token for clientId " + clientId);
      }
    }
    accessTokens = removeNulls(accessTokens);

    return accessTokens;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.springframework.security.oauth2.provider.token.TokenStore#findTokensByClientIdAndUserName(java.lang.String,
   * java.lang.String)
   */
  public Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
    List<OAuth2AccessToken> accessTokens = new ArrayList<OAuth2AccessToken>();

    try {
      accessTokens = jdbcTemplate.query(selectAccessTokensFromUserNameAndClientIdSql, new SafeAccessTokenRowMapper(),
          userName, clientId);
    } catch (EmptyResultDataAccessException e) {
      if (LOG.isInfoEnabled()) {
        LOG.info("Failed to find access token for userName " + userName);
      }
    }
    accessTokens = removeNulls(accessTokens);

    return accessTokens;
  }

  /**
   * Removes the nulls.
   *
   * @param accessTokens the access tokens
   * @return the list
   */
  private List<OAuth2AccessToken> removeNulls(List<OAuth2AccessToken> accessTokens) {
    List<OAuth2AccessToken> tokens = new ArrayList<OAuth2AccessToken>();
    for (OAuth2AccessToken token : accessTokens) {
      if (token != null) {
        tokens.add(token);
      }
    }
    return tokens;
  }

  /**
   * Extract token key.
   *
   * @param value the value
   * @return the string
   */
  protected String extractTokenKey(String value) {
    if (value == null) {
      return null;
    }
    MessageDigest digest;
    try {
      digest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException("MD5 algorithm not available.  Fatal (should be in the JDK).");
    }

    try {
      byte[] bytes = digest.digest(value.getBytes("UTF-8"));
      return String.format("%032x", new BigInteger(1, bytes));
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("UTF-8 encoding not available.  Fatal (should be in the JDK).");
    }
  }

  /**
   * The Class SafeAccessTokenRowMapper.
   */
  private final class SafeAccessTokenRowMapper implements RowMapper<OAuth2AccessToken> {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    public OAuth2AccessToken mapRow(ResultSet rs, int rowNum) throws SQLException {
      try {
        return deserializeAccessToken(rs.getBytes(2));
      } catch (IllegalArgumentException e) {
        String token = rs.getString(1);
        jdbcTemplate.update(deleteAccessTokenSql, token);
        return null;
      }
    }
  }

  /**
   * Serialize access token.
   *
   * @param token the token
   * @return the byte[]
   */
  protected byte[] serializeAccessToken(OAuth2AccessToken token) {
    return SerializationUtils.serialize(token);
  }

  /**
   * Serialize refresh token.
   *
   * @param token the token
   * @return the byte[]
   */
  protected byte[] serializeRefreshToken(OAuth2RefreshToken token) {
    return SerializationUtils.serialize(token);
  }

  /**
   * Serialize authentication.
   *
   * @param authentication the authentication
   * @return the byte[]
   */
  protected byte[] serializeAuthentication(OAuth2Authentication authentication) {
    return SerializationUtils.serialize(authentication);
  }

  /**
   * Deserialize access token.
   *
   * @param token the token
   * @return the o auth2 access token
   */
  protected OAuth2AccessToken deserializeAccessToken(byte[] token) {
    return SerializationUtils.deserialize(token);
  }

  /**
   * Deserialize refresh token.
   *
   * @param token the token
   * @return the o auth2 refresh token
   */
  protected OAuth2RefreshToken deserializeRefreshToken(byte[] token) {
    return SerializationUtils.deserialize(token);
  }

  /**
   * Deserialize authentication.
   *
   * @param authentication the authentication
   * @return the o auth2 authentication
   */
  protected OAuth2Authentication deserializeAuthentication(byte[] authentication) {
    return SerializationUtils.deserialize(authentication);
  }

  /**
   * Sets the insert access token sql.
   *
   * @param insertAccessTokenSql the new insert access token sql
   */
  public void setInsertAccessTokenSql(String insertAccessTokenSql) {
    this.insertAccessTokenSql = insertAccessTokenSql;
  }

  /**
   * Sets the select access token sql.
   *
   * @param selectAccessTokenSql the new select access token sql
   */
  public void setSelectAccessTokenSql(String selectAccessTokenSql) {
    this.selectAccessTokenSql = selectAccessTokenSql;
  }

  /**
   * Sets the delete access token sql.
   *
   * @param deleteAccessTokenSql the new delete access token sql
   */
  public void setDeleteAccessTokenSql(String deleteAccessTokenSql) {
    this.deleteAccessTokenSql = deleteAccessTokenSql;
  }

  /**
   * Sets the insert refresh token sql.
   *
   * @param insertRefreshTokenSql the new insert refresh token sql
   */
  public void setInsertRefreshTokenSql(String insertRefreshTokenSql) {
    this.insertRefreshTokenSql = insertRefreshTokenSql;
  }

  /**
   * Sets the select refresh token sql.
   *
   * @param selectRefreshTokenSql the new select refresh token sql
   */
  public void setSelectRefreshTokenSql(String selectRefreshTokenSql) {
    this.selectRefreshTokenSql = selectRefreshTokenSql;
  }

  /**
   * Sets the delete refresh token sql.
   *
   * @param deleteRefreshTokenSql the new delete refresh token sql
   */
  public void setDeleteRefreshTokenSql(String deleteRefreshTokenSql) {
    this.deleteRefreshTokenSql = deleteRefreshTokenSql;
  }

  /**
   * Sets the select access token authentication sql.
   *
   * @param selectAccessTokenAuthenticationSql the new select access token authentication sql
   */
  public void setSelectAccessTokenAuthenticationSql(String selectAccessTokenAuthenticationSql) {
    this.selectAccessTokenAuthenticationSql = selectAccessTokenAuthenticationSql;
  }

  /**
   * Sets the select refresh token authentication sql.
   *
   * @param selectRefreshTokenAuthenticationSql the new select refresh token authentication sql
   */
  public void setSelectRefreshTokenAuthenticationSql(String selectRefreshTokenAuthenticationSql) {
    this.selectRefreshTokenAuthenticationSql = selectRefreshTokenAuthenticationSql;
  }

  /**
   * Sets the select access token from authentication sql.
   *
   * @param selectAccessTokenFromAuthenticationSql the new select access token from authentication sql
   */
  public void setSelectAccessTokenFromAuthenticationSql(String selectAccessTokenFromAuthenticationSql) {
    this.selectAccessTokenFromAuthenticationSql = selectAccessTokenFromAuthenticationSql;
  }

  /**
   * Sets the delete access token from refresh token sql.
   *
   * @param deleteAccessTokenFromRefreshTokenSql the new delete access token from refresh token sql
   */
  public void setDeleteAccessTokenFromRefreshTokenSql(String deleteAccessTokenFromRefreshTokenSql) {
    this.deleteAccessTokenFromRefreshTokenSql = deleteAccessTokenFromRefreshTokenSql;
  }

  /**
   * Sets the select access tokens from user name and client id sql.
   *
   * @param selectAccessTokensFromUserNameAndClientIdSql the new select access tokens from user name and client id sql
   */
  public void setSelectAccessTokensFromUserNameAndClientIdSql(String selectAccessTokensFromUserNameAndClientIdSql) {
    this.selectAccessTokensFromUserNameAndClientIdSql = selectAccessTokensFromUserNameAndClientIdSql;
  }

  /**
   * Sets the select access tokens from client id sql.
   *
   * @param selectAccessTokensFromClientIdSql the new select access tokens from client id sql
   */
  public void setSelectAccessTokensFromClientIdSql(String selectAccessTokensFromClientIdSql) {
    this.selectAccessTokensFromClientIdSql = selectAccessTokensFromClientIdSql;
  }
}

