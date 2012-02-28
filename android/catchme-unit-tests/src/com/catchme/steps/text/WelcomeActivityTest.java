package com.catchme.steps.text;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.os.Bundle;
import android.view.View;

import com.catchme.base.BaseUnitTest;
import com.catchme.base.CustomTestRunner;

@RunWith(CustomTestRunner.class)
public class WelcomeActivityTest extends BaseUnitTest {

  WelcomeActivity welcomeActivity = new WelcomeActivity() {
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
    welcomeActivity.setPresenter(presenter);
  }

  @Test
  public void onCreateBindsPresenter() {
    welcomeActivity.onCreate(savedInstanceState);

    verify(presenter).bind(welcomeActivity);
  }

  @Test
  public void onBack_delegatesToPresenter() {
    welcomeActivity.onBackPressed();

    verify(presenter).back(welcomeActivity);
  }

}
