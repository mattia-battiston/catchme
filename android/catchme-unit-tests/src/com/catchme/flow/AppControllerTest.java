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
import com.catchme.flow.step.BaseStep;
import com.catchme.flow.step.StepRetriever;

public class AppControllerTest extends BaseUnitTest {

  AppController appController = new AppController();

  @Mock
  Activity context;

  @Mock
  StepRetriever stepRetriever;

  @Mock
  BaseStep firstStep;

  @Mock
  BaseStep previousStep;

  @Mock
  BaseStep nextStep;

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
    BaseStep secondStep = mockStepAfter(firstStep);
    BaseStep thirdStep = mockStepAfter(secondStep);
    BaseStep fourthStep = mockStepAfter(thirdStep);

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
    BaseStep thirdStep = setStepBefore(previousStep);
    BaseStep secondStep = setStepBefore(thirdStep);
    BaseStep firstStep = setStepBefore(secondStep);

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

  private void mockFirstStep() {
    when(stepRetriever.getFirstStep()).thenReturn(firstStep);
  }

  private void mockNextStep() {
    when(stepRetriever.getStepAfter(any(BaseStep.class))).thenReturn(nextStep);
  }

  private void mockPreviousStep() {
    when(stepRetriever.getStepBefore(any(BaseStep.class))).thenReturn(previousStep);
  }

  private BaseStep mockStepAfter(BaseStep previousStep) {
    BaseStep nextStep = mock(BaseStep.class);
    when(stepRetriever.getStepAfter(previousStep)).thenReturn(nextStep);
    return nextStep;
  }

  private BaseStep setStepBefore(BaseStep currentStep) {
    BaseStep previousStep = mock(BaseStep.class);
    when(stepRetriever.getStepBefore(currentStep)).thenReturn(previousStep);
    return previousStep;
  }

}
