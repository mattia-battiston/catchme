package com.catchme.steps.text.type;

import android.content.Context;
import android.widget.Button;

public interface TextStepView {
  Button getContinueButton();

  Context getContext();

  void setText(String textName);

  void setTitle(String titleName);

}