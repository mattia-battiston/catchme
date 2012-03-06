package com.catchme.flow.step;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Arrays;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;
import com.catchme.flow.presenter.Presenter;
import com.catchme.steps.exit.ExitStep;

public class StepRetrieverTest extends BaseUnitTest {

  StepRetriever stepRetriever = new StepRetriever();

  @Test
  public void getFirstStep_returnsFirstStep() {
    Presenter<?> expectedFirstStep = mockFirstStep();

    Presenter<?> actualFirstStep = stepRetriever.getFirstStep();

    assertEquals(actualFirstStep, expectedFirstStep);
  }

  @Test
  public void getStepAfter_returnsStepAfterCurrentOne() {
    Presenter<?> first = step("First");
    Presenter<?> second = step("Second");
    Presenter<?> third = step("Third");
    Presenter<?> fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    Presenter<?> stepAfter = stepRetriever.getStepAfter(second);

    assertEquals(stepAfter, third);
  }

  @Test
  public void getStepAfter_returnsLastStepAfterPenultimate() {
    Presenter<?> first = step("First");
    Presenter<?> second = step("Second");
    Presenter<?> third = step("Third");
    Presenter<?> fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    Presenter<?> stepAfter = stepRetriever.getStepAfter(third);

    assertEquals(stepAfter, fourth);
  }

  @Test(expected = RuntimeException.class)
  public void getStepAfter_exceptionIfThereAreNoMoreSteps() {
    Presenter<?> first = step("First");
    Presenter<?> second = step("Second");
    Presenter<?> third = step("Third");
    Presenter<?> fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    stepRetriever.getStepAfter(fourth);
  }

  @Test
  public void getStepBefore_returnsStepBeforeCurrentOne() {
    Presenter<?> first = step("First");
    Presenter<?> second = step("Second");
    Presenter<?> third = step("Third");
    Presenter<?> fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    Presenter<?> stepBefore = stepRetriever.getStepBefore(fourth);

    assertEquals(stepBefore, third);
  }

  @Test
  public void getStepBefore_returnsFirstStepBeforeSecond() {
    Presenter<?> first = step("First");
    Presenter<?> second = step("Second");
    Presenter<?> third = step("Third");
    Presenter<?> fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    Presenter<?> stepBefore = stepRetriever.getStepBefore(second);

    assertEquals(stepBefore, first);
  }

  @Test
  public void getStepBefore_returnsExitStepBeforeFirst() {
    Presenter<?> first = step("First");
    Presenter<?> second = step("Second");
    Presenter<?> third = step("Third");
    Presenter<?> fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    Presenter<?> stepBefore = stepRetriever.getStepBefore(first);

    assertThat(stepBefore, is(instanceOf(ExitStep.class)));
  }

  private void mockSteps(Presenter<?>... steps) {
    StepRetriever.setSteps(Arrays.asList(steps));
  }

  private Presenter<?> step(String stepName) {
    Presenter<?> step = mock(Presenter.class);
    when(step.getStepName()).thenReturn(stepName);
    return step;
  }

  private Presenter<?> mockFirstStep() {
    Presenter<?> firstStep = mock(Presenter.class);
    stepRetriever.getSteps().set(0, firstStep);
    return firstStep;
  }

}
