package com.catchme.steps.text.type;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.catchme.R;
import com.catchme.flow.presenter.Presenter;

public class TextStepActivity extends Activity implements TextStepView {

  private static Presenter<TextStepView> presenter;

  private Button continueButton;

  private TextView textContent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.text);

    continueButton = (Button) findViewById(R.id.text_continue);
    textContent = (TextView) findViewById(R.id.text_content);

    presenter.bind(this);
  }

  @Override
  public void onBackPressed() {
    presenter.back(this);
  }

  @Override
  public Button getContinueButton() {
    return continueButton;
  }

  @Override
  public Context getContext() {
    return this;
  }

  @Override
  public void setText(String textName) {
    int textResourceId = getResources().getIdentifier(textName, "string",
        getPackageName());
    textContent.setText(textResourceId);
  }

  public static void setPresenter(Presenter<TextStepView> presenter) {
    TextStepActivity.presenter = presenter;
  }

  public void setTextContent(TextView textContent) {
    this.textContent = textContent;
  }

}
