package com.catchme;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catchme.steps.map.WelcomePresenter;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class WelcomePresenterTest {

  WelcomePresenter presenter;

  @Mock
  WelcomePresenter.PresenterView view;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);

    presenter = new WelcomePresenter(view);
  }

  @Test
  public void goToNextPageWhenClickingContinueButton() {
    presenter.go();

    View.OnClickListener continueClickListener = getContinueClickListener();
    continueClickListener.onClick(null);

    Intent startedIntent = getIntentStarte();
  }

  private Intent getIntentStarte() {
    // TODO Auto-generated method stub
    return null;
  }

  private OnClickListener getContinueClickListener() {
    // TODO Auto-generated method stub
    return null;
  }

}
