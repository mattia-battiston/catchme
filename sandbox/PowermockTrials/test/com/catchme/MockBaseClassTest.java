package com.catchme;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ FirstClass.class })
public class MockBaseClassTest {

  @Test
  public void mockBaseClassTest() {
    PowerMockito.mockStatic(BaseFirstClass.class);
    PowerMockito.when(BaseFirstClass.baseSayHelloStaticly(anyString()))
        .thenReturn("fail");

    assertThat(FirstClass.baseSayHelloStaticly("Mattia"), is("fail"));
  }

  @Test
  public void mockBaseClassTest2() {
    PowerMockito.mockStatic(BaseFirstClass.class);
    PowerMockito.when(BaseFirstClass.baseSayHelloStaticly(anyString()))
        .thenReturn("fail");

    assertThat(FirstClass.sayHelloStaticly("Mattia"), is("fail and then work"));
  }
}
