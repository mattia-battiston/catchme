package com.catchme.trials;

public class CatchmePresenter {

  private CatchmeView view;

  public void go(CatchmeView view) {
    this.view = view;

    view.getMapController().setZoom(10);
  }

}
