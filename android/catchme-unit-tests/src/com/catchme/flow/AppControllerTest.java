package com.catchme.flow;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import android.content.Context;

import com.catchme.base.BaseUnitTest;
import com.catchme.flow.step.Step;
import com.catchme.flow.step.StepRetriever;

public class AppControllerTest extends BaseUnitTest {

  AppController appController = new AppController();

  @Mock
  Context context;

  @Mock
  StepRetriever stepRetriever;

  @Mock
  Step firstStep;

  @Before
  public void before() {
    appController.setStepRetriever(stepRetriever);

    mockFirstStep();
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
    Step secondStep = mockStepAfter(firstStep);
    Step thirdStep = mockStepAfter(secondStep);
    mockStepAfter(thirdStep);

    appController.next(context);
    verify(stepRetriever).getStepAfter(firstStep);

    appController.next(context);
    verify(stepRetriever).getStepAfter(secondStep);

    appController.next(context);
    verify(stepRetriever).getStepAfter(thirdStep);
  }

  @Test
  public void next_goesToNextStep() {
    appController.start(context);
    Step secondStep = mockStepAfter(firstStep);

    appController.next(context);

    verify(secondStep).go(context);
  }

  private void mockFirstStep() {
    when(stepRetriever.getFirstStep()).thenReturn(firstStep);
  }

  private Step mockStepAfter(Step previousStep) {
    Step nextStep = mock(Step.class);
    when(stepRetriever.getStepAfter(previousStep)).thenReturn(nextStep);
    return nextStep;
  }

}
