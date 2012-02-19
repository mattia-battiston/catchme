package com.catchme;

public class WelcomePresenter {

  private final View view;

  public interface View {
    void setContentView(int contentView);
  }

  public WelcomePresenter(View view) {
    this.view = view;
  }

  public void go() {
    view.setContentView(R.layout.welcome);
  }

}
