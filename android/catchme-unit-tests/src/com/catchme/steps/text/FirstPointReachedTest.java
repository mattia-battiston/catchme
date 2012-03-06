package com.catchme.steps.text;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;

public class FirstPointReachedTest extends BaseUnitTest {

  FirstPointReached presenter = new FirstPointReached();

  @Test
  public void hasName() {
    assertNotNull(presenter.getStepName());
  }

  @Test
  public void showsFirstPointReachedText() {
    assertThat(presenter.getTextName(), is("text_firstPointReached"));
  }

  @Test
  public void showsFirstPointReachedTitle() {
    assertThat(presenter.getTitleName(), is("text_firstPointReached_title"));
  }
}
