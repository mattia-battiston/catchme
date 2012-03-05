package com.catchme.steps.text;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;

public class WelcomePresenterTest extends BaseUnitTest {

  WelcomePresenter presenter = new WelcomePresenter();

  @Test
  public void hasName() {
    assertNotNull(presenter.getName());
  }

  @Test
  public void showsWelcomeText() {
    assertThat(presenter.getTextName(), is("text_welcome"));
  }

  @Test
  public void showsWelcomeTitle() {
    assertThat(presenter.getTitleName(), is("text_welcome_title"));
  }
}
