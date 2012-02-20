package com.catchme;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catchme.base.CustomTestRunner;
import com.catchme.steps.text.WelcomePresenter;

@RunWith(CustomTestRunner.class)
public class CatchmeActivityTest {

  CatchmeActivity catchmeActivity = new CatchmeActivity();

  @Mock
  WelcomePresenter welcomePage;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);

    catchmeActivity.setWelcomePresenter(welcomePage);
  }

  @Test
  public void startsWelcomePage() {
    catchmeActivity.onCreate(null);

    verify(welcomePage).go();
  }

}
