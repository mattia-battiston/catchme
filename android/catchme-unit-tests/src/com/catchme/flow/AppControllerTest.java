package com.catchme.flow;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import android.content.Context;

import com.catchme.base.BaseUnitTest;
import com.catchme.steps.text.WelcomePresenter;

public class AppControllerTest extends BaseUnitTest {

  AppController appController = new AppController();

  @Mock
  Context context;

  @Before
  public void before() {
    appController.setPresenterRetriever(presenterRetriever);
  }

  @Test
  public void start_startsFirstStep() {
    WelcomePresenter welcomePresenter = presenterRetriever
        .getPresenter(WelcomePresenter.class);

    appController.start(context);

    verify(welcomePresenter).go(context);
  }

  @Test
  public void start_passTheAppControllerToTheStep() {
    WelcomePresenter welcomePresenter = presenterRetriever
        .getPresenter(WelcomePresenter.class);

    appController.start(context);

    verify(welcomePresenter).setAppController(appController);
  }

}
