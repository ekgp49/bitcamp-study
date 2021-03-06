package com.eomcs.util;

import java.lang.reflect.Method;

public class RequestHandler {
  Object bean;
  String path;
  Method method;

  public RequestHandler() {
    // TODO Auto-generated constructor stub
  }

  public RequestHandler(Method method, Object bean) {
    this.bean = bean;
    this.method = method;
    this.path = getPath(method);
  }

  private String getPath(Method method) {
    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
    return requestMapping.value();
  }

  public Object getBean() {
    return bean;
  }

  public void setBean(Object bean) {
    this.bean = bean;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Method getMethod() {
    return method;
  }

  public void setMethod(Method method) {
    this.method = method;
  }


}
