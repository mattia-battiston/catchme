package com.catchme.steps.text.type;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.os.Bundle;
import android.view.View;

import com.catchme.base.BaseUnitTest;
import com.catchme.base.CustomTestRunner;
import com.catchme.steps.text.WelcomePresenter;
import com.catchme.steps.text.type.TextStepActivity;

@RunWith(CustomTestRunner.class)
public class TextStepActivityTest extends BaseUnitTest {

  TextStepActivity textStepActivity = new TextStepActivity() {
    @Override
    public void setContentView(int layoutResID) {
    }

    @Override
    public View findViewById(int id) {
      return null;
    }
  };

  @Mock
  WelcomePresenter presenter;

  @Mock
  Bundle savedInstanceState;

  @Before
  public void before() {
    textStepActivity.setPresenter(presenter);
  }

  @Test
  public void onCreateBindsPresenter() {
    textStepActivity.onCreate(savedInstanceState);

    verify(presenter).bind(textStepActivity);
  }

  @Test
  public void onBack_delegatesToPresenter() {
    textStepActivity.onBackPressed();

    verify(presenter).back(textStepActivity);
  }

}
