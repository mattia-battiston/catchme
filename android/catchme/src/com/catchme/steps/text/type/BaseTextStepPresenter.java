package com.catchme.steps.text.type;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.catchme.flow.presenter.BasePresenter;

public abstract class BaseTextStepPresenter extends BasePresenter<TextStepView> {

  @Override
  public void go(Context currentContext) {
    Intent goToWelcome = intentFactory.createIntent(currentContext,
        TextStepActivity.class);
    currentContext.startActivity(goToWelcome);
  }

  @Override
  public void bind(final TextStepView view) {
    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        next(view.getContext());
      }
    });

    view.setText(getTextName());
  }

  public abstract String getTextName();

}
