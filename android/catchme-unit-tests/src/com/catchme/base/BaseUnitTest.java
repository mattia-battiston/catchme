package com.catchme.base;

import static org.mockito.Matchers.anyInt;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.catchme.flow.AppController;
import com.catchme.flow.presenter.PresenterRetriever;
import com.catchme.steps.text.WelcomePresenter;

public class BaseUnitTest {

  @Mock
  protected Context context;

  @Mock
  protected AppController appController;

  @Mock
  protected PresenterRetriever presenterRetriever;

  @Before
  public void baseBefore() {
    MockitoAnnotations.initMocks(this);

    mockPresenters();
    mockContext();
  }

  private void mockPresenters() {
    WelcomePresenter welcomePresenter = mock(WelcomePresenter.class);
    when(presenterRetriever.getPresenter(WelcomePresenter.class)).thenReturn(
        welcomePresenter);
  }

  private void mockContext() {
    Resources resources = mock(Resources.class);
    Drawable drawable = mock(Drawable.class);
    when(context.getResources()).thenReturn(resources);
    when(resources.getDrawable(anyInt())).thenReturn(drawable);
  }

}
