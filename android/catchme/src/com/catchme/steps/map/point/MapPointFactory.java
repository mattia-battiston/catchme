package com.catchme.steps.map.point;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.catchme.R;
import com.catchme.steps.map.point.baloon.BaloonLayout;
import com.google.android.maps.GeoPoint;

public class MapPointFactory {

  private final Activity activity;

  public MapPointFactory(Activity activity) {
    this.activity = activity;
  }

  // TODO some of this code should be in the MapPointOverlay, the baloon is
  // part of the point for us
  public MapPointOverlay createMapPoint(GeoPoint point, String text) {
    MapPointOverlay pin = new MapPointOverlay(activity);
    pin.setPosition(point);

    BaloonLayout layout = getBaloonLayout();
    layout.setVisibility(View.VISIBLE);
    ((TextView) layout.findViewById(R.id.note_text)).setText(text);

    pin.setLayout(layout);
    return pin;
  }

  // TODO initialize this starting the application and make it available
  private BaloonLayout getBaloonLayout() {
    LayoutInflater layoutInflater = (LayoutInflater) activity
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    BaloonLayout noteBaloon = (BaloonLayout) layoutInflater.inflate(
        R.layout.baloon, null);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
        200, 100);
    layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
    layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    noteBaloon.setLayoutParams(layoutParams);
    return noteBaloon;
  }

}
