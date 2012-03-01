package com.catchme.flow.presenter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.catchme.base.BaseUnitTest;

public class PresenterRetrieverTest extends BaseUnitTest {

  PresenterRetriever presenterRetriever = new PresenterRetriever();

  Map<Class<? extends Presenter<?>>, Presenter<?>> presenters;

  @Before
  public void before() {
    presenters = PresenterRetriever.getPresenters();
  }

  @SuppressWarnings("rawtypes")
  @Test
  public void getPresenterReturnsTheExpectedPresenter() {
    Presenter expectedPresenter = addFakePresenter();

    Presenter actualPresenter = presenterRetriever
        .getPresenter(expectedPresenter.getClass());

    assertThat(expectedPresenter, is(actualPresenter));
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  private Presenter<?> addFakePresenter() {
    Presenter presenter = mock(Presenter.class);
    presenters.put((Class<? extends Presenter<?>>) presenter.getClass(),
        presenter);
    return presenter;
  }
}
