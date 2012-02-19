package com.catchme.base;

import java.io.File;

import org.junit.runners.model.InitializationError;

import com.xtremelabs.robolectric.RobolectricTestRunner;

public class CustomTestRunner extends RobolectricTestRunner {

  public CustomTestRunner(Class<?> testClass) throws InitializationError {
    // defaults to "AndroidManifest.xml", "res" in the current directory
    super(testClass, new File("../catchme"));
  }

}