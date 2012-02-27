package com.catchme.flow.step;

import android.content.Context;

public interface Step {

  void go(Context context);

  void next(Context context);

  void back(Context context);

  public abstract String getName();

}
