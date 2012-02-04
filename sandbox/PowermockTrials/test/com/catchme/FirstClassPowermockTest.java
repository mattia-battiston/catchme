package com.catchme;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FirstClass.class })
public class FirstClassPowermockTest {

  @Test(expected = RuntimeException.class)
  public void errorWhenUsingConstructor() throws Exception {
    PowerMockito.whenNew(FirstClass.class).withNoArguments()
        .thenThrow(new RuntimeException());

    new FirstClass();
  }

}
