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
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotatePublicCertBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.utils.TestUtilities;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit test class for the RotatePublicCertBody model.
 */
public class RotatePublicCertBodyTest {
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    @Test
    public void testRotatePublicCertBody() throws Throwable {
        RotatePublicCertBody rotatePublicCertBodyModel = new RotatePublicCertBody.Builder()
                .rotateKeys(true)
                .customMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .versionCustomMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .build();
        assertEquals(rotatePublicCertBodyModel.rotateKeys(), Boolean.valueOf(true));
        assertEquals(rotatePublicCertBodyModel.customMetadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
        assertEquals(rotatePublicCertBodyModel.versionCustomMetadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));

        String json = TestUtilities.serialize(rotatePublicCertBodyModel);

        RotatePublicCertBody rotatePublicCertBodyModelNew = TestUtilities.deserialize(json, RotatePublicCertBody.class);
        assertTrue(rotatePublicCertBodyModelNew instanceof RotatePublicCertBody);
        assertEquals(rotatePublicCertBodyModelNew.rotateKeys(), Boolean.valueOf(true));
        assertEquals(rotatePublicCertBodyModelNew.customMetadata().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
        assertEquals(rotatePublicCertBodyModelNew.versionCustomMetadata().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRotatePublicCertBodyError() throws Throwable {
        new RotatePublicCertBody.Builder().build();
    }

}