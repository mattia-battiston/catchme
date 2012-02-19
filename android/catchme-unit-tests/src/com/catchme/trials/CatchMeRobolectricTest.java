package com.catchme.trials;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@Ignore
@RunWith(CustomTestRunner.class)
public class CatchMeRobolectricTest {

  @Test
  public void routeIsNotDisplayed() {
    CatchmeActivity activity = new CatchmeActivity();

    assertThat(activity.isRouteDisplayed(), is(false));
  }

  @Test
  public void onCreate() {
    CatchmeActivity activity = new CatchmeActivity();

    activity.onCreate(null);
  }

}
