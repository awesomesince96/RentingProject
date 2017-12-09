
package com.springwithjersey.common.util;

public final class ExceptionUtils {

  public static void handleException(RuntimeException exception, Runnable action) {
    try {
      action.run();
    } catch (RuntimeException exceptionWhenHandling) {
      exception.addSuppressed(exceptionWhenHandling);
    }
  }

  private ExceptionUtils() {}
}
