package com.catchme.flow;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import android.app.Activity;

import com.catchme.base.BaseUnitTest;
import com.catchme.flow.presenter.Presenter;
import com.catchme.flow.step.StepRetriever;

public class AppControllerTest extends BaseUnitTest {

  AppController appController = new AppController();

  @Mock
  Activity context;

  @Mock
  StepRetriever stepRetriever;

  @SuppressWarnings("rawtypes")
  @Mock
  Presenter firstStep;

  @SuppressWarnings("rawtypes")
  @Mock
  Presenter previousStep;

  @SuppressWarnings("rawtypes")
  @Mock
  Presenter nextStep;

  @Before
  public void before() {
    appController.setStepRetriever(stepRetriever);

    mockFirstStep();
    mockNextStep();
    mockPreviousStep();
  }

  @Test
  public void start_startsFirstStep() {
    appController.start(context);

    verify(firstStep).go(context);
  }

  @Test
  public void start_passTheAppControllerToTheStep() {
    appController.start(context);

    verify(firstStep).setAppController(appController);
  }

  @Test
  public void next_goesToStepAfterCurrentOne() {
    appController.start(context);
    Presenter<?> secondStep = mockStepAfter(firstStep);
    Presenter<?> thirdStep = mockStepAfter(secondStep);
    Presenter<?> fourthStep = mockStepAfter(thirdStep);

    appController.next(context);
    verify(secondStep).go(context);

    appController.next(context);
    verify(thirdStep).go(context);

    appController.next(context);
    verify(fourthStep).go(context);
  }

  @Test
  public void next_goesToNextStep() {
    appController.next(context);

    verify(nextStep).go(context);
  }

  @Test
  public void next_passTheAppControllerToTheStep() {
    appController.next(context);

    verify(nextStep).setAppController(appController);
  }

  @Test
  public void back_goesToStepBeforeCurrentOne() {
    appController.setStep(previousStep);
    Presenter<?> thirdStep = setStepBefore(previousStep);
    Presenter<?> secondStep = setStepBefore(thirdStep);
    Presenter<?> firstStep = setStepBefore(secondStep);

    appController.back(context);
    verify(thirdStep).go(context);

    appController.back(context);
    verify(secondStep).go(context);

    appController.back(context);
    verify(firstStep).go(context);
  }

  @Test
  public void back_goesToPreviousStep() {
    appController.back(context);

    verify(previousStep).go(context);
  }

  @Test
  public void back_passTheAppControllerToTheStep() {
    appController.back(context);

    verify(previousStep).setAppController(appController);
  }

  @SuppressWarnings("unchecked")
  private void mockFirstStep() {
    when(stepRetriever.getFirstStep()).thenReturn(firstStep);
  }

  @SuppressWarnings("unchecked")
  private void mockNextStep() {
    when(stepRetriever.getStepAfter(any(Presenter.class))).thenReturn(nextStep);
  }

  @SuppressWarnings("unchecked")
  private void mockPreviousStep() {
    when(stepRetriever.getStepBefore(any(Presenter.class))).thenReturn(
        previousStep);
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private Presenter<?> mockStepAfter(Presenter<?> previousStep) {
    Presenter nextStep = mock(Presenter.class);
    when(stepRetriever.getStepAfter(previousStep)).thenReturn(nextStep);
    return nextStep;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private Presenter setStepBefore(Presenter currentStep) {
    Presenter previousStep = mock(Presenter.class);
    when(stepRetriever.getStepBefore(currentStep)).thenReturn(previousStep);
    return previousStep;
  }

}
