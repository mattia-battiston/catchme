package com.catchme;

import android.content.Context;
import android.content.Intent;

public class CatchmeMapPresenter {

  private static CatchmeMapPresenter instance = new CatchmeMapPresenter();

  private CatchmeMapPresenter() {
  }

  public static CatchmeMapPresenter getInstance() {
    return instance;
  }

  public void go(Context context) {
    Intent goToMap = new Intent(context, CatchmeMapActivity.class);
    context.startActivity(goToMap);
  }

}
