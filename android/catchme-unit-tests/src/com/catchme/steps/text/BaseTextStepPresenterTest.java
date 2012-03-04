package com.catchme.steps.text;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.catchme.android.IntentFactory;
import com.catchme.base.BaseUnitTest;
import com.catchme.steps.text.type.BaseTextStepPresenter;
import com.catchme.steps.text.type.TextStepActivity;
import com.catchme.steps.text.type.TextStepView;

public class BaseTextStepPresenterTest extends BaseUnitTest {

  BaseTextStepPresenter presenter = new BaseTextStepPresenterForTest();

  @Mock
  IntentFactory intentFactory;

  @Mock
  TextStepView view;

  @Mock
  Button continueButton;

  @Mock
  View gui;

  String textName = "textName";

  @Before
  public void before() {
    presenter.setIntentFactory(intentFactory);
    presenter.setAppController(appController);
    mockView();
  }

  @Test
  public void go_startsTextStepActivity() {
    Intent intent = mockIntentToStartActivity(TextStepActivity.class);

    presenter.go(context);

    verify(context).startActivity(intent);
  }

  @Test
  public void onContinueGoToNextStep() {
    presenter.bind(view);

    View.OnClickListener clickListener = getClickListenerFor(continueButton);
    clickListener.onClick(gui);

    verify(appController).next(context);
  }

  @Test
  public void setsTheTextToShow() {
    presenter.bind(view);

    verify(view).setText(textName);
  }

  private Intent mockIntentToStartActivity(Class<TextStepActivity> activityClass) {
    Intent intent = mock(Intent.class);
    when(intentFactory.createIntent(any(Context.class), any(Class.class)))
        .thenReturn(intent);
    return intent;
  }

  private OnClickListener getClickListenerFor(Button button) {
    ArgumentCaptor<View.OnClickListener> clickListenerCaptor = ArgumentCaptor
        .forClass(View.OnClickListener.class);
    verify(button).setOnClickListener(clickListenerCaptor.capture());
    return clickListenerCaptor.getValue();
  }

  private void mockView() {
    when(view.getContinueButton()).thenReturn(continueButton);
    when(view.getContext()).thenReturn(context);
  }

  private class BaseTextStepPresenterForTest extends BaseTextStepPresenter {
    @Override
    public String getName() {
      return "BaseTextStepPresenterForTest";
    }

    @Override
    public String getTextName() {
      return textName;
    }
  }

}
