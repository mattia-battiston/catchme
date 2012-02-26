package com.catchme.flow;

public class PresenterRetriever {

  // TODO implement this class for real

  public <T> T getPresenter(Class<T> clazz) {
    try {
      return clazz.newInstance();
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e.getMessage(), e);
    } catch (InstantiationException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

}
