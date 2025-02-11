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
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PublicCertificateSecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.Rotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.utils.TestUtilities;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit test class for the PublicCertificateSecretResource model.
 */
public class PublicCertificateSecretResourceTest {
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    @Test
    public void testPublicCertificateSecretResource() throws Throwable {
        Rotation rotationModel = new Rotation.Builder()
                .autoRotate(false)
                .rotateKeys(false)
                .interval(Long.valueOf("26"))
                .unit("day")
                .build();
        assertEquals(rotationModel.autoRotate(), Boolean.valueOf(false));
        assertEquals(rotationModel.rotateKeys(), Boolean.valueOf(false));
        assertEquals(rotationModel.interval(), Long.valueOf("26"));
        assertEquals(rotationModel.unit(), "day");

        PublicCertificateSecretResource publicCertificateSecretResourceModel = new PublicCertificateSecretResource.Builder()
                .name("testString")
                .description("testString")
                .secretGroupId("testString")
                .labels(java.util.Arrays.asList("testString"))
                .customMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .versionCustomMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
                .bundleCerts(true)
                .ca("testString")
                .dns("testString")
                .keyAlgorithm("RSA2048")
                .altNames("testString")
                .commonName("example.com")
                .rotation(rotationModel)
                .build();
        assertEquals(publicCertificateSecretResourceModel.name(), "testString");
        assertEquals(publicCertificateSecretResourceModel.description(), "testString");
        assertEquals(publicCertificateSecretResourceModel.secretGroupId(), "testString");
        assertEquals(publicCertificateSecretResourceModel.labels(), java.util.Arrays.asList("testString"));
        assertEquals(publicCertificateSecretResourceModel.customMetadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
        assertEquals(publicCertificateSecretResourceModel.versionCustomMetadata(), java.util.Collections.singletonMap("anyKey", "anyValue"));
        assertEquals(publicCertificateSecretResourceModel.bundleCerts(), Boolean.valueOf(true));
        assertEquals(publicCertificateSecretResourceModel.ca(), "testString");
        assertEquals(publicCertificateSecretResourceModel.dns(), "testString");
        assertEquals(publicCertificateSecretResourceModel.keyAlgorithm(), "RSA2048");
        assertEquals(publicCertificateSecretResourceModel.altNames(), "testString");
        assertEquals(publicCertificateSecretResourceModel.commonName(), "example.com");
        assertEquals(publicCertificateSecretResourceModel.rotation(), rotationModel);

        String json = TestUtilities.serialize(publicCertificateSecretResourceModel);

        PublicCertificateSecretResource publicCertificateSecretResourceModelNew = TestUtilities.deserialize(json, PublicCertificateSecretResource.class);
        assertTrue(publicCertificateSecretResourceModelNew instanceof PublicCertificateSecretResource);
        assertEquals(publicCertificateSecretResourceModelNew.name(), "testString");
        assertEquals(publicCertificateSecretResourceModelNew.description(), "testString");
        assertEquals(publicCertificateSecretResourceModelNew.secretGroupId(), "testString");
        assertEquals(publicCertificateSecretResourceModelNew.customMetadata().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
        assertEquals(publicCertificateSecretResourceModelNew.versionCustomMetadata().toString(), java.util.Collections.singletonMap("anyKey", "anyValue").toString());
        assertEquals(publicCertificateSecretResourceModelNew.bundleCerts(), Boolean.valueOf(true));
        assertEquals(publicCertificateSecretResourceModelNew.ca(), "testString");
        assertEquals(publicCertificateSecretResourceModelNew.dns(), "testString");
        assertEquals(publicCertificateSecretResourceModelNew.keyAlgorithm(), "RSA2048");
        assertEquals(publicCertificateSecretResourceModelNew.altNames(), "testString");
        assertEquals(publicCertificateSecretResourceModelNew.commonName(), "example.com");
        assertEquals(publicCertificateSecretResourceModelNew.rotation().toString(), rotationModel.toString());
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPublicCertificateSecretResourceError() throws Throwable {
        new PublicCertificateSecretResource.Builder().build();
    }

}