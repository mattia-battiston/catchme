package com.catchme.trials;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catchme.R;
import com.catchme.WelcomePresenter;

public class WelcomePresenterTest {

  WelcomePresenter presenter;

  @Mock
  WelcomePresenter.View view;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);

    presenter = new WelcomePresenter(view);
  }

  @Test
  public void go_setsWhichLayoutToUse() {
    presenter.go();

    verify(view).setContentView(anyInt());
  }

  @Test
  public void welcomePresenterUsesWelcomeLayout() {
    presenter.go();

    verify(view).setContentView(R.layout.welcome);
  }

}
