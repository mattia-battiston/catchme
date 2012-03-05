package com.catchme.flow.presenter;

import java.util.HashMap;
import java.util.Map;

import com.catchme.steps.map.FirstPointPresenter;
import com.catchme.steps.text.FirstPointReached;
import com.catchme.steps.text.WelcomePresenter;

public class PresenterRetriever {

  private static Map<Class<? extends Presenter<?>>, Presenter<?>> presenters = new HashMap<Class<? extends Presenter<?>>, Presenter<?>>();

  static {
    presenters.put(WelcomePresenter.class, new WelcomePresenter());
    presenters.put(FirstPointPresenter.class, new FirstPointPresenter());
    presenters.put(FirstPointReached.class, new FirstPointReached());
  }

  @SuppressWarnings("unchecked")
  public <T extends Presenter<?>> T getPresenter(Class<T> clazz) {
    return (T) presenters.get(clazz);
  }

  public static Map<Class<? extends Presenter<?>>, Presenter<?>> getPresenters() {
    return presenters;
  }

}
