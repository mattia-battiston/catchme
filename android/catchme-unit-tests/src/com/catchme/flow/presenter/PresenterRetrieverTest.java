package com.catchme.flow.presenter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.catchme.base.BaseUnitTest;
import com.catchme.flow.presenter.Presenter;
import com.catchme.flow.presenter.PresenterRetriever;

public class PresenterRetrieverTest extends BaseUnitTest {

  PresenterRetriever presenterRetriever = new PresenterRetriever();

  Map<Class<? extends Presenter>, Presenter> presenters;

  @Before
  public void before() {
    presenters = PresenterRetriever.getPresenters();
  }

  @Test
  public void getPresenterReturnsTheExpectedPresenter() {
    Presenter expectedPresenter = addFakePresenter();

    Presenter actualPresenter = presenterRetriever
        .getPresenter(expectedPresenter.getClass());

    assertThat(expectedPresenter, is(actualPresenter));
  }

  private Presenter addFakePresenter() {
    Presenter presenter = mock(Presenter.class);
    presenters.put(presenter.getClass(), presenter);
    return presenter;
  }
}
