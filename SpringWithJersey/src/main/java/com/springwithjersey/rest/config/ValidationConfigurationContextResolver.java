package com.springwithjersey.rest.config;

import static com.springwithjersey.rest.constants.RestConstants.CLASS_PREFIX;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.server.validation.ValidationConfig;
import org.hibernate.validator.internal.engine.DefaultParameterNameProvider;

public class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {

  public ValidationConfig getContext(final Class<?> type) {
    final ValidationConfig config = new ValidationConfig();
    config.parameterNameProvider(new RestFieldAnnotationParameterNameProvider());
    return config;
  }


  static class RestFieldAnnotationParameterNameProvider extends DefaultParameterNameProvider {
    public List<String> getParameterNames(Method method) {
      Annotation[][] annotationsByParam = method.getParameterAnnotations();
      List<String> names = new ArrayList<>(annotationsByParam.length);
      for (Annotation[] annotations : annotationsByParam) {
        String name = getQueryOrPathParamName(annotations);
        if (name == null) {
          Class<?> aClass = method.getParameterTypes()[names.size()];
          name = aClass.getSimpleName().replaceAll(CLASS_PREFIX, "");
        }
        names.add(name);
      }

      return names;
    }

    private static String getQueryOrPathParamName(Annotation[] annotations) {
      for (Annotation annotation : annotations) {
        if (annotation.annotationType().equals(QueryParam.class)) {
          return QueryParam.class.cast(annotation).value();
        } else if (annotation.annotationType().equals(PathParam.class)) {
          return PathParam.class.cast(annotation).value();
        }
      }

      return null;
    }
  }
}
