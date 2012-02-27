package com.catchme.steps.text;

import static org.junit.Assert.assertNotNull;
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
import com.catchme.steps.text.WelcomePresenter.PresenterView;

public class WelcomePresenterTest extends BaseUnitTest {

  WelcomePresenter presenter = WelcomePresenter.getInstance();

  @Mock
  IntentFactory intentFactory;

  @Mock
  PresenterView view;

  @Mock
  Button continueButton;

  @Mock
  View gui;

  @Before
  public void before() {
    presenter.setIntentFactory(intentFactory);
    presenter.setAppController(appController);

    mockView();
  }

  @Test
  public void go_startsWelcomeActivity() {
    Intent intent = mockIntentToStartActivity(WelcomeActivity.class);

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
  public void hasName() {
    assertNotNull(presenter.getName());
  }

  private Intent mockIntentToStartActivity(Class<WelcomeActivity> activityClass) {
    Intent intent = mock(Intent.class);
    when(intentFactory.createIntent(any(Context.class), any(Class.class)))
        .thenReturn(intent);
    return intent;
  }

  private void mockView() {
    when(view.getContinueButton()).thenReturn(continueButton);
    when(view.getContext()).thenReturn(context);
  }

  private OnClickListener getClickListenerFor(Button button) {
    ArgumentCaptor<View.OnClickListener> clickListenerCaptor = ArgumentCaptor
        .forClass(View.OnClickListener.class);
    verify(button).setOnClickListener(clickListenerCaptor.capture());
    return clickListenerCaptor.getValue();
  }

}
