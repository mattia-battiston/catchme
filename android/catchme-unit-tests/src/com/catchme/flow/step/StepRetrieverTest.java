package com.catchme.flow.step;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

import java.util.Arrays;

import org.junit.Test;

import com.catchme.base.BaseUnitTest;

public class StepRetrieverTest extends BaseUnitTest {

  StepRetriever stepRetriever = new StepRetriever();

  @Test
  public void getFirstStep_returnsFirstStep() {
    Step expectedFirstStep = mockFirstStep();

    Step actualFirstStep = stepRetriever.getFirstStep();

    assertThat(actualFirstStep, is(expectedFirstStep));
  }

  @Test
  public void getStepAfter_returnsStepAfterCurrentOne() {
    Step first = step("First");
    Step second = step("Second");
    Step third = step("Third");
    Step fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    Step stepAfter = stepRetriever.getStepAfter(second);

    assertThat(stepAfter, is(third));
  }

  @Test
  public void getStepAfter_returnsLastStepAfterPenultimate() {
    Step first = step("First");
    Step second = step("Second");
    Step third = step("Third");
    Step fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    Step stepAfter = stepRetriever.getStepAfter(third);

    assertThat(stepAfter, is(fourth));
  }

  @Test(expected = RuntimeException.class)
  public void getStepAfter_exceptionIfThereAreNoMoreSteps() {
    Step first = step("First");
    Step second = step("Second");
    Step third = step("Third");
    Step fourth = step("Fourth");
    mockSteps(first, second, third, fourth);

    stepRetriever.getStepAfter(fourth);
  }

  private void mockSteps(Step... steps) {
    StepRetriever.setSteps(Arrays.asList(steps));
  }

  private Step step(String stepName) {
    Step step = mock(Step.class);
    when(step.getName()).thenReturn(stepName);
    return step;
  }

  private Step mockFirstStep() {
    Step firstStep = mock(Step.class);
    stepRetriever.getSteps().set(0, firstStep);
    return firstStep;
  }

}
