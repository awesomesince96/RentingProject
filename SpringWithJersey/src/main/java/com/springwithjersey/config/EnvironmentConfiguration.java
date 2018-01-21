package com.springwithjersey.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.springwithjersey.config.properties.HibernateProperties;
import com.springwithjersey.config.properties.MysqlProperties;
import com.springwithjersey.config.properties.OAuth2Properties;

@Configuration
@PropertySource("classpath:environment.properties")
public class EnvironmentConfiguration implements InitializingBean {

  @Value("${#systemProperties['dev.testing']:false}")
  public boolean isDevTesting;

  public static boolean IS_DEV_TESTING;

  @Value("${env}")
  private String env;

  @Value("#{systemProperties['run.schedulers']}")
  private Boolean runSchedulers;

  public static Boolean RUN_SCHEDULERS;
  public static String ENV;
  public static String HOST_URL;

  @Value("${mysql.driverClassName}")
  private String mysqlDriverClassName;
  @Value("${mysql.url}")
  private String mysqlUrl;
  @Value("${mysql.username}")
  private String mysqlUserName;
  @Value("${mysql.password}")
  private String mysqlPassword;
  @Value("${mysql.maxPoolSize}")
  private Integer mysqlMaxPoolSize;
  @Value("${mysql.minPoolSize}")
  private Integer mysqlMinPoolSize;


  @Value("${hibernate.dialect}")
  private String hibernateDialect;
  @Value("${hibernate.show_sql}")
  private Boolean hibernateShowSql;
  // @Value("${hibernate.persistenceUnitName}")
  // private String hibernatePersistenceUnitName;

  @Value("${hibernate.hbm2ddl.auto}")
  private String hibernateHbm2ddlAuto;



  @Value("${oAuthSecurity.supportRefreshToken}")
  private Boolean oAuthSecuritySupportRefreshToken;
  @Value("${oAuthSecurity.accessTokenValiditySeconds}")
  private Integer oAuthSecurityAccessTokenValiditySeconds;

  @Bean
  public MysqlProperties mysqlProperties() {
    MysqlProperties mysqlProperties = new MysqlProperties();
    mysqlProperties.setDriverClassName(mysqlDriverClassName);
    mysqlProperties.setUrl(mysqlUrl);
    mysqlProperties.setUsername(mysqlUserName);
    mysqlProperties.setPassword(mysqlPassword);
    mysqlProperties.setMaxPoolSize(mysqlMaxPoolSize);
    mysqlProperties.setMinPoolSize(mysqlMinPoolSize);

    return mysqlProperties;
  }

  @Bean
  public HibernateProperties hibernateProperties() {
    HibernateProperties hibernateProperties = new HibernateProperties();
    hibernateProperties.setDialect(hibernateDialect);
    hibernateProperties.setShowSql(hibernateShowSql);
    // hibernateProperties.setPersistenceUnitName(hibernatePersistenceUnitName);
    // hibernateProperties.setHbm2ddl(hibernateHbm2ddlAuto);
    hibernateProperties.setHbm2ddl(hibernateHbm2ddlAuto);

    return hibernateProperties;
  }

  public OAuth2Properties oAuth2Properties() {
    OAuth2Properties oAuth2Properties = new OAuth2Properties();
    oAuth2Properties.setSupportRefreshToken(oAuthSecuritySupportRefreshToken);
    oAuth2Properties.setAccessTokenValiditySeconds(oAuthSecurityAccessTokenValiditySeconds);
    return oAuth2Properties;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    // TODO Auto-generated method stub

  }

}
