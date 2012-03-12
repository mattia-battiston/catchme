package com.catchme.base;

import static org.mockito.Matchers.anyInt;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.catchme.flow.AppController;

public class BaseUnitTest {

  @Mock
  protected Context context;

  @Mock
  protected AppController appController;

  @Before
  public void baseBefore() {
    MockitoAnnotations.initMocks(this);

    mockContext();
  }

  private void mockContext() {
    Resources resources = mock(Resources.class);
    Drawable drawable = mock(Drawable.class);
    when(context.getResources()).thenReturn(resources);
    when(resources.getDrawable(anyInt())).thenReturn(drawable);
  }

}
