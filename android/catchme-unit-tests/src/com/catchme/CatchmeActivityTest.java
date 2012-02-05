package com.catchme;

import static org.junit.Assert.assertFalse;
import static org.powermock.api.support.membermodification.MemberMatcher.constructor;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.android.maps.MapActivity;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ CatchmeActivity.class })
public class CatchmeActivityTest {

  CatchmeActivity catchmeActivity;

  @Before
  public void before() throws Exception {
    suppress(constructor(MapActivity.class));

    catchmeActivity = new CatchmeActivity();
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
