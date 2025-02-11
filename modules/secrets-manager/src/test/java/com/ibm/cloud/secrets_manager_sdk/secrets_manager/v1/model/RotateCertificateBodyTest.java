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
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotateCertificateBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.utils.TestUtilities;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit test class for the RotateCertificateBody model.
 */
public class RotateCertificateBodyTest {
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    @Test
    public void testRotateCertificateBody() throws Throwable {
        RotateCertificateBody rotateCertificateBodyModel = new RotateCertificateBody.Builder()
                .certificate("testString")
                .privateKey("testString")
                .intermediate("testString")
                .customMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .versionCustomMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .build();
        assertEquals(rotateCertificateBodyModel.certificate(), "testString");
        assertEquals(rotateCertificateBodyModel.privateKey(), "testString");
        assertEquals(rotateCertificateBodyModel.intermediate(), "testString");
        assertEquals(rotateCertificateBodyModel.customMetadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
        assertEquals(rotateCertificateBodyModel.versionCustomMetadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));

        String json = TestUtilities.serialize(rotateCertificateBodyModel);

        RotateCertificateBody rotateCertificateBodyModelNew = TestUtilities.deserialize(json, RotateCertificateBody.class);
        assertTrue(rotateCertificateBodyModelNew instanceof RotateCertificateBody);
        assertEquals(rotateCertificateBodyModelNew.certificate(), "testString");
        assertEquals(rotateCertificateBodyModelNew.privateKey(), "testString");
        assertEquals(rotateCertificateBodyModelNew.intermediate(), "testString");
        assertEquals(rotateCertificateBodyModelNew.customMetadata().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
        assertEquals(rotateCertificateBodyModelNew.versionCustomMetadata().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testRotateCertificateBodyError() throws Throwable {
        new RotateCertificateBody.Builder().build();
    }

}