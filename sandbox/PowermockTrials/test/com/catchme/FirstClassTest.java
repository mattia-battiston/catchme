package com.catchme;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FirstClassTest {

  @Test
  public void test() {
    String sayHello = new FirstClass().sayHello("Mattia");

    assertThat(sayHello, is("Hello from superclass, Mattia and hello Mattia"));
  }

}
