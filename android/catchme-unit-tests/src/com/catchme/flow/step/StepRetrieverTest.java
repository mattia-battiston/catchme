package com.catchme.flow.step;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Arrays;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;
import com.catchme.steps.exit.ExitStep;

public class StepRetrieverTest extends BaseUnitTest {

  StepRetriever stepRetriever = new StepRetriever();

  @Test
  public void getFirstStep_returnsFirstStep() {
    BaseStep expectedFirstStep = mockFirstStep();

    BaseStep actualFirstStep = stepRetriever.getFirstStep();

    assertThat(actualFirstStep, is(expectedFirstStep));
  }

  @Test
  public void getStepAfter_returnsStepAfterCurrentOne() {
    BaseStep first = step("First");
    BaseStep second = step("Second");
    BaseStep third = step("Third");
    BaseStep fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    BaseStep stepAfter = stepRetriever.getStepAfter(second);

    assertThat(stepAfter, is(third));
  }

  @Test
  public void getStepAfter_returnsLastStepAfterPenultimate() {
    BaseStep first = step("First");
    BaseStep second = step("Second");
    BaseStep third = step("Third");
    BaseStep fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    BaseStep stepAfter = stepRetriever.getStepAfter(third);

    assertThat(stepAfter, is(fourth));
  }

  @Test(expected = RuntimeException.class)
  public void getStepAfter_exceptionIfThereAreNoMoreSteps() {
    BaseStep first = step("First");
    BaseStep second = step("Second");
    BaseStep third = step("Third");
    BaseStep fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    stepRetriever.getStepAfter(fourth);
  }

  @Test
  public void getStepBefore_returnsStepBeforeCurrentOne() {
    BaseStep first = step("First");
    BaseStep second = step("Second");
    BaseStep third = step("Third");
    BaseStep fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    BaseStep stepBefore = stepRetriever.getStepBefore(fourth);

    assertThat(stepBefore, is(third));
  }

  @Test
  public void getStepBefore_returnsFirstStepBeforeSecond() {
    BaseStep first = step("First");
    BaseStep second = step("Second");
    BaseStep third = step("Third");
    BaseStep fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    BaseStep stepBefore = stepRetriever.getStepBefore(second);

    assertThat(stepBefore, is(first));
  }

  @Test
  public void getStepBefore_returnsExitStepBeforeFirst() {
    BaseStep first = step("First");
    BaseStep second = step("Second");
    BaseStep third = step("Third");
    BaseStep fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    BaseStep stepBefore = stepRetriever.getStepBefore(first);

    assertThat(stepBefore, is(instanceOf(ExitStep.class)));
  }

  private void mockSteps(BaseStep... steps) {
    StepRetriever.setSteps(Arrays.asList(steps));
  }

  private BaseStep step(String stepName) {
    BaseStep step = mock(BaseStep.class);
    when(step.getName()).thenReturn(stepName);
    return step;
  }

  private BaseStep mockFirstStep() {
    BaseStep firstStep = mock(BaseStep.class);
    stepRetriever.getSteps().set(0, firstStep);
    return firstStep;
  }

}
