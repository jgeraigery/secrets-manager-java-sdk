/*
 * (C) Copyright IBM Corp. 2022.
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

package com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotateArbitrarySecretBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UpdateSecretOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.utils.TestUtilities;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateSecretOptions model.
 */
public class UpdateSecretOptionsTest {
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    @Test
    public void testUpdateSecretOptions() throws Throwable {
        RotateArbitrarySecretBody secretActionModel = new RotateArbitrarySecretBody.Builder()
                .payload("testString")
                .customMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .versionCustomMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .build();
        assertEquals(secretActionModel.payload(), "testString");
        assertEquals(secretActionModel.customMetadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
        assertEquals(secretActionModel.versionCustomMetadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));

        UpdateSecretOptions updateSecretOptionsModel = new UpdateSecretOptions.Builder()
                .secretType("arbitrary")
                .id("testString")
                .action("rotate")
                .secretAction(secretActionModel)
                .build();
        assertEquals(updateSecretOptionsModel.secretType(), "arbitrary");
        assertEquals(updateSecretOptionsModel.id(), "testString");
        assertEquals(updateSecretOptionsModel.action(), "rotate");
        assertEquals(updateSecretOptionsModel.secretAction(), secretActionModel);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testUpdateSecretOptionsError() throws Throwable {
        new UpdateSecretOptions.Builder().build();
    }

}