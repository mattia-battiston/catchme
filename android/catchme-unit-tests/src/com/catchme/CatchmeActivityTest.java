package com.catchme;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.catchme.base.BaseUnitTest;
import com.catchme.base.CustomTestRunner;
import com.catchme.flow.AppController;

@RunWith(CustomTestRunner.class)
public class CatchmeActivityTest extends BaseUnitTest {

  CatchmeActivity catchmeActivity = new CatchmeActivity();

  @Mock
  AppController appController;

  @Before
  public void before() {
    catchmeActivity.setAppController(appController);
  }

  @Test
  public void startsTheApplication() {
    catchmeActivity.onResume();

    verify(appController).start(catchmeActivity);
  }

}
