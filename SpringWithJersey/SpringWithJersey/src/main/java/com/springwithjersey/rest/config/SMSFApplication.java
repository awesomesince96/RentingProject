package com.springwithjersey.rest.config;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.springwithjersey.endpoint.UserEndPoint;

public class SMSFApplication extends ResourceConfig {
  private final Logger logger = LoggerFactory.getLogger(SMSFApplication.class);

  public SMSFApplication() {
    logger.info("Application start");
    setProperties();
    registerFeatures();
    registerResources();
  }

  public void setProperties() {
    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
  }

  public void registerResources() {
    register(UserEndPoint.class);
  }

  public void registerFeatures() {
    register(JacksonJsonProvider.class);
    register(ValidationConfigurationContextResolver.class);
    register(RolesAllowedDynamicFeature.class);
    register(MultiPartFeature.class);
  }
}
