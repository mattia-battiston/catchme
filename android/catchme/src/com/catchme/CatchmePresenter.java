package com.catchme;

public class CatchmePresenter {

  private final CatchmeView view;

  public CatchmePresenter(CatchmeView view) {
    this.view = view;
  }

  public void bind() {
    view.getMapController().setZoom(10);
  }

}
