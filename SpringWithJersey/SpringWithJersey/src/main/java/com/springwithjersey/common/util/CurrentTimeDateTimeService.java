package com.springwithjersey.common.util;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class CurrentTimeDateTimeService implements DateTimeService {
  @Override
  public ZonedDateTime getCurrentDateAndTime() {
    return ZonedDateTime.now();
  }
}
