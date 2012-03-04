package com.catchme.steps.text;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;

public class WelcomePresenterTest extends BaseUnitTest {

  WelcomePresenter presenter = WelcomePresenter.getInstance();

  @Test
  public void hasName() {
    assertNotNull(presenter.getName());
  }

}
