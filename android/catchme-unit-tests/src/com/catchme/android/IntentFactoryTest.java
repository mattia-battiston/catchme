package com.catchme.android;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mock;

import android.content.Intent;

import com.catchme.base.BaseUnitTest;

public class IntentFactoryTest extends BaseUnitTest {

  IntentFactory intentFactory = new IntentFactory() {
    protected android.content.Intent createIntent() {
      return intent;
    };
  };

  @Mock
  Intent intent;

  @Test
  public void createIntent_createsIntentWithAction() {
    intentFactory.createIntent("test_action", "test_category");

    verify(intent).setAction("test_action");
  }

  @Test
  public void createIntent_createsIntentWithCategory() {
    intentFactory.createIntent("test_action", "test_category");

    verify(intent).addCategory("test_category");
  }

  @Test
  public void createIntent_returnsTheIntent() {
    Intent createdIntent = intentFactory.createIntent("test_action",
        "test_category");

    assertNotNull(createdIntent);
  }

}
