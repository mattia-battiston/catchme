package com.catchme.steps.map.type;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import android.os.Bundle;
import android.widget.TextView;

import com.catchme.base.BaseUnitTest;
import com.catchme.base.CustomTestRunner;
import com.catchme.steps.map.FirstPointPresenter;
import com.catchme.steps.map.point.MapPointFactory;
import com.catchme.steps.map.point.MapPointOverlay;
import com.catchme.steps.map.point.baloon.BaloonLayout;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MapView.LayoutParams;
import com.google.android.maps.Overlay;

@RunWith(CustomTestRunner.class)
public class MapStepActivityTest extends BaseUnitTest {

  MapStepActivity mapStepActivity = new MapStepActivity();

  @Mock
  Bundle savedInstanceState;

  @Mock
  FirstPointPresenter presenter;

  @Mock
  GeoPoint point;

  @Mock
  MapPointFactory mapPointFactory;

  @Mock
  MapView mapView;

  @Mock
  MapController mapController;

  List<Overlay> overlays = new ArrayList<Overlay>();

  @Mock
  TextView textTitle;

  @Before
  public void before() {
    MapStepActivity.setMapPresenter(presenter);

    mapStepActivity.setMapPointFactory(mapPointFactory);
    mapStepActivity.setMapView(mapView);
    mapStepActivity.setMapController(mapController);
    when(mapView.getOverlays()).thenReturn(overlays);
    mockPointCreation();
    mapStepActivity.setTextTitle(textTitle);
  }

  @Test
  public void onCreateBindsPresenter() {
    mapStepActivity.onCreate(savedInstanceState);

    verify(presenter).bind(mapStepActivity);
  }

  @Test
  public void setTargetAddsPointOnTheMap() {
    MapPointOverlay mapPoint = mockPointCreation();

    mapStepActivity.setTarget(point, "text");

    assertThat(overlays.size(), is(1));
    assertThat((MapPointOverlay) overlays.get(0), is(mapPoint));
  }

  @Test
  public void setTargetCentersTheMapOnTheTarget() {
    mapStepActivity.setTarget(point, "text");

    verify(mapController).animateTo(point);
  }

  @Test
  public void setTitle_setsTheTextWhoseNameIsPassedInAsContent() {
    mapStepActivity.setTitle("example");

    verify(textTitle).setText(anyInt());
  }

  private MapPointOverlay mockPointCreation() {
    MapPointOverlay mapPoint = mock(MapPointOverlay.class);
    BaloonLayout baloonLayout = mock(BaloonLayout.class);
    LayoutParams layoutParams = mock(LayoutParams.class);
    when(mapPoint.getView()).thenReturn(baloonLayout);
    when(mapPoint.getViewParams()).thenReturn(layoutParams);
    when(mapPointFactory.createMapPoint(any(GeoPoint.class), anyString()))
        .thenReturn(mapPoint);
    return mapPoint;
  }
}
