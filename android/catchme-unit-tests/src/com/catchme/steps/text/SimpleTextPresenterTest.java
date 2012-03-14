package com.catchme.steps.text;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;

public class SimpleTextPresenterTest extends BaseUnitTest {

  SimpleTextPresenter presenter = new SimpleTextPresenter("stepName");

  @Test
  public void hasName() {
    assertNotNull(presenter.getStepName());
  }

  @Test
  public void showsWelcomeText() {
    assertThat(presenter.getTextName(), is("text_stepName"));
  }

  @Test
  public void showsWelcomeTitle() {
    assertThat(presenter.getTitleName(), is("text_stepName_title"));
  }
}
