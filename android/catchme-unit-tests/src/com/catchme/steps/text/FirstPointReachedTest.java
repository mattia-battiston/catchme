package com.catchme.steps.text;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;

public class FirstPointReachedTest extends BaseUnitTest {

  FirstPointReached presenter = FirstPointReached.getInstance();

  @Test
  public void hasName() {
    assertNotNull(presenter.getName());
  }

  @Test
  public void showsFirstPointReachedText() {
    assertThat(presenter.getTextName(), is("text_firstPointReached"));
  }

}
