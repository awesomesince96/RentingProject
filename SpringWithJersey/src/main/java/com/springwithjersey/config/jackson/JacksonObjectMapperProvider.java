package com.springwithjersey.config.jackson;

import javax.ws.rs.ext.ContextResolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {
  private @Autowired ObjectMapper objectMapper;

  public ObjectMapper getContext(Class<?> type) {
    return objectMapper;
  }
}
