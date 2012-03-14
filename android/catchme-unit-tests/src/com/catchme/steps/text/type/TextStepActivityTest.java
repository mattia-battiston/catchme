package com.catchme.steps.text.type;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.catchme.base.BaseUnitTest;
import com.catchme.base.CustomTestRunner;
import com.catchme.steps.text.SimpleTextPresenter;

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
  SimpleTextPresenter presenter;

  @Mock
  Bundle savedInstanceState;

  @Mock
  TextView textTitle;
  @Mock
  TextView textContent;

  @Before
  public void before() {
    TextStepActivity.setPresenter(presenter);
    textStepActivity.setTextContent(textContent);
    textStepActivity.setTextTitle(textTitle);
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

  @Test
  public void setText_setsTheTextWhoseNameIsPassedInAsContent() {
    textStepActivity.setText("example");

    verify(textContent).setText(anyInt());
  }

  @Test
  public void setTitle_setsTheTextWhoseNameIsPassedInAsContent() {
    textStepActivity.setTitle("example");

    verify(textTitle).setText(anyInt());
  }

}
