package com.catchme.steps.map;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.catchme.flow.presenter.BasePresenter;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class FirstPointPresenter extends BasePresenter<MapStepView> {

  private static FirstPointPresenter instance = new FirstPointPresenter();

  private MapStepView view;

  private MapView map;

  private MapController mapController;

  private FirstPointPresenter() {
  }

  public static FirstPointPresenter getInstance() {
    return instance;
  }

  public void go(Context context) {
    Intent goToMap = intentFactory.createIntent(context, MapStepActivity.class);
    context.startActivity(goToMap);
  }

  public void bind(final MapStepView view) {
    this.view = view;
    this.map = view.getMap();
    this.mapController = view.getMapController();

    map.setBuiltInZoomControls(true);
    mapController.setZoom(15);

    GeoPoint target = new GeoPoint(19240000, -99120000);
    view.setTarget(target, "Hello world");
    mapController.animateTo(target);

    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        next(view.getContext());
      }
    });
  }

  public MapStepView getView() {
    return view;
  }

  @Override
  public String getName() {
    return "firstPoint";
  }
}
