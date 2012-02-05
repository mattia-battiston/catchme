package com.catchme;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import com.google.android.maps.MapActivity;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ MapActivity.class })
public class CatchmeActivityTest {

  CatchmeActivity catchmeActivity;

  @Before
  public void before() throws Exception {
    catchmeActivity = Whitebox.newInstance(CatchmeActivity.class);
  }

  @Test
  public void firstTest() {
    assertFalse(catchmeActivity.isRouteDisplayed());
  }

  @Test
  public void secondTest() {
    assertFalse(catchmeActivity.isRouteDisplayed());
  }

}
