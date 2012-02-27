package com.catchme.flow.step;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import android.content.Context;

import com.catchme.base.BaseUnitTest;
import com.catchme.flow.AppController;

public class BaseStepTest extends BaseUnitTest {

  BaseStep step = new BaseStepForTest();

  @Mock
  AppController appController;

  @Mock
  Context context;

  @Before
  public void before() {
    step.setAppController(appController);
  }

  @Test
  public void next_goesToNextStep() {
    step.next(context);

    verify(appController).next(context);
  }

  @Test
  public void back_goesToPreviousStep() {
    step.back(context);

    verify(appController).back(context);
  }

  private class BaseStepForTest extends BaseStep {
    @Override
    public void go(Context context) {
    }

    @Override
    public String getName() {
      return null;
    }
  }
}
