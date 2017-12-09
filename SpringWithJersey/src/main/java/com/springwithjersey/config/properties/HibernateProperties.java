package com.springwithjersey.config.properties;

import lombok.Data;

@Data
public class HibernateProperties {
  private String dialect;
  private Boolean showSql;
  private String persistenceUnitName;
}
