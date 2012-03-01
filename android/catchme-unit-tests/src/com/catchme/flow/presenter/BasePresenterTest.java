package com.catchme.flow.presenter;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import android.content.Context;

import com.catchme.base.BaseUnitTest;
import com.catchme.flow.AppController;

public class BasePresenterTest extends BaseUnitTest {

  BasePresenter<Void> presenter = new BasePresenter<Void>() {
    @Override
    public void go(Context context) {
    }

    @Override
    public String getName() {
      return null;
    }

    @Override
    public void bind(Void view) {
    }
  };

  @Mock
  AppController appController;

  @Mock
  Context context;

  @Before
  public void before() {
    presenter.setAppController(appController);
  }

  @Test
  public void next_goesToNextStep() {
    presenter.next(context);

    verify(appController).next(context);
  }

  @Test
  public void back_goesToPreviousStep() {
    presenter.back(context);

    verify(appController).back(context);
  }

}
