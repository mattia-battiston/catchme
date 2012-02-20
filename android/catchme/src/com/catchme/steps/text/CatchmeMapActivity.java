package com.catchme.steps.text;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.catchme.R;
import com.catchme.steps.map.BaloonLayout;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class CatchmeMapActivity extends MapActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.catchme_map);

    MapView mapView = (MapView) findViewById(R.id.mapview);
    MapController mapController = mapView.getController();

    LayoutInflater layoutInflater = (LayoutInflater) this
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    BaloonLayout noteBaloon = (BaloonLayout) layoutInflater.inflate(
        R.layout.baloon, null);
    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
        200, 100);
    layoutParams.addRule(RelativeLayout.CENTER_VERTICAL);
    layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    noteBaloon.setLayoutParams(layoutParams);

    mapView.removeView(noteBaloon);
    noteBaloon.setVisibility(View.VISIBLE);
    ((TextView) noteBaloon.findViewById(R.id.note_text))
        .setText("Example text for baloon");
    GeoPoint point = new GeoPoint(19240000, -99120000);
    mapController.animateTo(point);
    mapView.addView(noteBaloon, new MapView.LayoutParams(200, 200, point,
        MapView.LayoutParams.BOTTOM_CENTER));
    mapView.setEnabled(false);

    Button closeButton = (Button) findViewById(R.id.mapBaloon_close);
    closeButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        System.out.println("Button clicked");
      }
    });

  }

  @Override
  protected boolean isRouteDisplayed() {
    return false;
  }

}
