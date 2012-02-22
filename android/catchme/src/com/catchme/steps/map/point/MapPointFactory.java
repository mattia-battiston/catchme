package com.catchme.steps.map.point;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.catchme.R;
import com.catchme.steps.map.BaloonLayout;
import com.catchme.steps.map.CatchmeMapPresenter;
import com.google.android.maps.GeoPoint;

public class MapPointFactory {

  private final Activity activity;
  private final CatchmeMapPresenter presenter;

  public MapPointFactory(Activity activity, CatchmeMapPresenter mapPresenter) {
    this.activity = activity;
    this.presenter = mapPresenter;
  }

  public MapPointOverlay createMapPoint(GeoPoint point) {
    MapPointOverlay pin = new MapPointOverlay(activity);
    pin.setPoint(point);
    pin.setPresenter(presenter);

    LayoutInflater layoutInflater = (LayoutInflater) activity
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    BaloonLayout noteBaloon = (BaloonLayout) layoutInflater.inflate(
        R.layout.baloon, null);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
        200, 100);
    layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
    layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    noteBaloon.setLayoutParams(layoutParams);
    pin.setBaloonLayout(noteBaloon);

    return pin;
  }

}
