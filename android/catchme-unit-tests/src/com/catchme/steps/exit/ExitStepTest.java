package com.catchme.steps.exit;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import android.app.Activity;
import android.content.Intent;

import com.catchme.android.IntentFactory;
import com.catchme.base.BaseUnitTest;

public class ExitStepTest extends BaseUnitTest {

  ExitStep exitStep = new ExitStep();

  @Mock
  IntentFactory intentFactory;

  @Mock
  Activity activity;

  @Mock
  Intent intent;

  @Before
  public void before() {
    exitStep.setIntentFactory(intentFactory);
    when(intentFactory.createIntent(anyString(), anyString())).thenReturn(
        intent);
  }

  @Test
  public void goesBackToHome() {
    exitStep.go(activity);

    verify(intentFactory)
        .createIntent(Intent.ACTION_MAIN, Intent.CATEGORY_HOME);
    verify(activity).startActivity(intent);
  }

  @Test
  public void terminateCurrentActivity() {
    exitStep.go(activity);

    verify(activity).finish();
  }

  @Test
  public void hasAName() {
    assertNotNull(exitStep.getStepName());
  }

}
