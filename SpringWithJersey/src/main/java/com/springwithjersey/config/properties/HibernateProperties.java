package com.springwithjersey.config.properties;

import lombok.Data;

@Data
public class HibernateProperties {
  private String dialect;
  private Boolean showSql;
  // private String persistenceUnitName;
  private String hbm2ddl;

  public String getDialect() {
    return dialect;
  }

  public void setDialect(String dialect) {
    this.dialect = dialect;
  }

  public Boolean getShowSql() {
    return showSql;
  }

  public void setShowSql(Boolean showSql) {
    this.showSql = showSql;
  }

  // public String getPersistenceUnitName() {
  // return persistenceUnitName;
  // }
  //
  // public void setPersistenceUnitName(String persistenceUnitName) {
  // this.persistenceUnitName = persistenceUnitName;
  // }

  public String getHbm2ddl() {
    return hbm2ddl;
  }

  public void setHbm2ddl(String hbm2ddl) {
    this.hbm2ddl = hbm2ddl;
  }



}
