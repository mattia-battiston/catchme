package com.catchme.base;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catchme.flow.presenter.PresenterRetriever;
import com.catchme.steps.text.WelcomePresenter;

public class BaseUnitTest {

  @Mock
  protected PresenterRetriever presenterRetriever;

  @Before
  public void baseBefore() {
    MockitoAnnotations.initMocks(this);

    mockPresenters();
  }

  private void mockPresenters() {
    WelcomePresenter welcomePresenter = mock(WelcomePresenter.class);
    when(presenterRetriever.getPresenter(WelcomePresenter.class)).thenReturn(
        welcomePresenter);
  }

}
