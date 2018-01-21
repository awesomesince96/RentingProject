package com.springwithjersey.config.data;

import static com.springwithjersey.config.ApplicationConfiguration.BASE_PACKAGE;

import java.util.Properties;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springwithjersey.common.util.AuditingDateTimeProvider;
import com.springwithjersey.common.util.DateTimeService;
import com.springwithjersey.config.properties.HibernateProperties;
import com.springwithjersey.config.properties.MysqlProperties;

@Configuration
@ComponentScan(basePackages = BASE_PACKAGE)
@EnableJpaRepositories(basePackages = BASE_PACKAGE)
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
@EnableTransactionManagement
public class MysqlClientConfiguration {
  private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

  private static final String PROPERTY_NAME_HIBERNATE_HBM2LL = "hibernate.hbm2ddl.auto";

  private static final String PROPERTY_NAME_HIBERNATE_BATCH_SIZE = "hibernate.jdbc.batch_size";
  public static final String BASE_PACKAGE = "com.springwithjersey";

  private @Autowired MysqlProperties mysqlProperties;
  private @Autowired HibernateProperties hibernateProperties;

  @Bean
  DateTimeProvider dateTimeProvider(DateTimeService dateTimeService) {
    return new AuditingDateTimeProvider(dateTimeService);
  }

  @Bean
  public DriverManagerDataSource mySqlDataSource() {
    DriverManagerDataSource mySqlDataSource = new DriverManagerDataSource();
    mySqlDataSource.setDriverClassName(mysqlProperties.getDriverClassName());
    mySqlDataSource.setUrl(mysqlProperties.getUrl());
    mySqlDataSource.setUsername(mysqlProperties.getUsername());
    mySqlDataSource.setPassword(mysqlProperties.getPassword());

    return mySqlDataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(mySqlDataSource());
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
    entityManagerFactoryBean.setPackagesToScan(BASE_PACKAGE);
    // entityManagerFactoryBean.setPersistenceUnitName(hibernateProperties.getPersistenceUnitName());
    entityManagerFactoryBean.setJpaProperties(jpaProperties());

    return entityManagerFactoryBean;
  }

  private Properties jpaProperties() {
    Properties jpaProperties = new Properties();
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, hibernateProperties.getDialect());
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, hibernateProperties.getShowSql());
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_BATCH_SIZE, 80);

    jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2LL, hibernateProperties.getHbm2ddl());
    System.out.println("oadnjlvsvsnvdlsnvsl-----" + hibernateProperties.getHbm2ddl());

    jpaProperties.put("hibernate.order_inserts", "true");
    jpaProperties.put("hibernate.order_updates", "true");
    // jpaProperties.put("hbm2ddl.auto", "create");
    return jpaProperties;
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

    return transactionManager;
  }

  @Bean
  public JdbcTemplate mysqlJdbcTemplate() {
    return new JdbcTemplate(mySqlDataSource());
  }

  @Bean
  public NamedParameterJdbcTemplate mysqlNamedParameterJdbcTemplate() {
    return new NamedParameterJdbcTemplate(mySqlDataSource());
  }
}
