package com.catchme.android;

import android.content.Intent;

public class IntentFactory {

  public Intent createIntent(String action, String category) {
    Intent intent = createIntent();
    intent.setAction(action);
    intent.addCategory(category);
    return intent;
  }

  protected Intent createIntent() {
    return new Intent();
  }

}
