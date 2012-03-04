package com.catchme.steps.text;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.catchme.flow.presenter.BasePresenter;
import com.catchme.steps.text.type.TextStepActivity;
import com.catchme.steps.text.type.TextStepView;

public class FirstPointReached extends BasePresenter<TextStepView> {

  private static FirstPointReached instance = new FirstPointReached();

  private FirstPointReached() {
  }

  public static FirstPointReached getInstance() {
    return instance;
  }

  @Override
  public void go(Context context) {
    // TODO this method could be extracted in a BaseTestStepPresenter
    Intent goToWelcome = intentFactory.createIntent(context,
        TextStepActivity.class);
    context.startActivity(goToWelcome);
  }

  @Override
  public void bind(final TextStepView view) {
    // TODO this method could be extracted in a BaseTestStepPresenter
    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        next(view.getContext());
      }
    });

    // TODO set text
  }

  @Override
  public String getName() {
    return "First Point Reached";
  }

}
