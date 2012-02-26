package com.catchme.base;

import org.junit.Before;
import org.mockito.MockitoAnnotations;

public class BaseUnitTest {

  @Before
  public void baseBefore() {
    MockitoAnnotations.initMocks(this);
  }

}
