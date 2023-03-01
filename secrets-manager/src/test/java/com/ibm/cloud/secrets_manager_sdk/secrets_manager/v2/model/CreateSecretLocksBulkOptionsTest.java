/*
 * (C) Copyright IBM Corp. 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.secrets_manager_sdk.secrets_manager.v2.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v2.model.CreateSecretLocksBulkOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v2.model.SecretLockPrototype;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v2.utils.TestUtilities;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateSecretLocksBulkOptions model.
 */
public class CreateSecretLocksBulkOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateSecretLocksBulkOptions() throws Throwable {
    SecretLockPrototype secretLockPrototypeModel = new SecretLockPrototype.Builder()
      .name("lock-example")
      .description("testString")
      .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();
    assertEquals(secretLockPrototypeModel.name(), "lock-example");
    assertEquals(secretLockPrototypeModel.description(), "testString");
    assertEquals(secretLockPrototypeModel.attributes(), java.util.Collections.singletonMap("anyKey", "anyValue"));

    CreateSecretLocksBulkOptions createSecretLocksBulkOptionsModel = new CreateSecretLocksBulkOptions.Builder()
      .id("0b5571f7-21e6-42b7-91c5-3f5ac9793a46")
      .locks(java.util.Arrays.asList(secretLockPrototypeModel))
      .mode("exclusive")
      .build();
    assertEquals(createSecretLocksBulkOptionsModel.id(), "0b5571f7-21e6-42b7-91c5-3f5ac9793a46");
    assertEquals(createSecretLocksBulkOptionsModel.locks(), java.util.Arrays.asList(secretLockPrototypeModel));
    assertEquals(createSecretLocksBulkOptionsModel.mode(), "exclusive");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSecretLocksBulkOptionsError() throws Throwable {
    new CreateSecretLocksBulkOptions.Builder().build();
  }

}