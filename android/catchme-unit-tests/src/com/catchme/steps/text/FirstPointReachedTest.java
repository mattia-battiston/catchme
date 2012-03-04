package com.catchme.steps.text;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;

public class FirstPointReachedTest extends BaseUnitTest {

  FirstPointReached presenter = FirstPointReached.getInstance();

  @Test
  public void hasName() {
    assertNotNull(presenter.getName());
  }

}
