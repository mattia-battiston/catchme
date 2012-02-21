package com.catchme.steps.map;

import android.content.Context;
import android.content.Intent;

import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CatchmeMapPresenter {

  private static CatchmeMapPresenter instance = new CatchmeMapPresenter();

  public interface PresenterView {
    MapView getMap();

    MapController getMapController();
  }

  private CatchmeMapPresenter() {
  }

  public static CatchmeMapPresenter getInstance() {
    return instance;
  }

  public void go(Context context) {
    Intent goToMap = new Intent(context, CatchmeMapActivity.class);
    context.startActivity(goToMap);
  }

  public void bind(final PresenterView view) {
    view.getMap().setBuiltInZoomControls(true);
    view.getMapController().setZoom(15);
  }
}
