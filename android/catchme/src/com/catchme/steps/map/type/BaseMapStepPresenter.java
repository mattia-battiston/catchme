package com.catchme.steps.map.type;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.catchme.flow.presenter.BasePresenter;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public abstract class BaseMapStepPresenter extends BasePresenter<MapStepView> {

  @Override
  public void go(Context context) {
    MapStepActivity.setMapPresenter(this);
    Intent goToMap = intentFactory.createIntent(context, MapStepActivity.class);
    context.startActivity(goToMap);
  }

  @Override
  public void bind(final MapStepView view) {
    MapView map = view.getMap();
    MapController mapController = view.getMapController();

    map.setBuiltInZoomControls(true);
    mapController.setZoom(18);

    GeoPoint target = getTarget();
    String titleName = getTitleName();
    String textName = getTextName();
    view.setTarget(target, titleName, textName);
    mapController.animateTo(target);

    view.getContinueButton().setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        next(view.getContext());
      }
    });

    view.setTitle(titleName);
  }

  protected abstract String getTitleName();

  protected abstract String getTextName();

  protected abstract GeoPoint getTarget();

}
