/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.ibm_cloud_secrets_manager_api.v1.model;

import com.ibm.cloud.ibm_cloud_secrets_manager_api.v1.model.CollectionMetadata;
import com.ibm.cloud.ibm_cloud_secrets_manager_api.v1.model.SecretMetadata;
import com.ibm.cloud.ibm_cloud_secrets_manager_api.v1.model.UpdateSecretMetadataOptions;
import com.ibm.cloud.ibm_cloud_secrets_manager_api.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateSecretMetadataOptions model.
 */
public class UpdateSecretMetadataOptionsTest {
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    @Test
    public void testUpdateSecretMetadataOptions() throws Throwable {
        CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
                .collectionType("application/vnd.ibm.secrets-manager.secret+json")
                .collectionTotal(Long.valueOf("1"))
                .build();
        assertEquals(collectionMetadataModel.collectionType(), "application/vnd.ibm.secrets-manager.secret+json");
        assertEquals(collectionMetadataModel.collectionTotal(), Long.valueOf("1"));

        SecretMetadata secretMetadataModel = new SecretMetadata.Builder()
                .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("dev", "us-south")))
                .name("example-secret")
                .description("Extended description for this secret.")
                .expirationDate(DateUtils.parseAsDateTime("2030-04-01T09:30:00.000Z"))
                .ttl("24h")
                .build();
        assertEquals(secretMetadataModel.labels(), new java.util.ArrayList<String>(java.util.Arrays.asList("dev", "us-south")));
        assertEquals(secretMetadataModel.name(), "example-secret");
        assertEquals(secretMetadataModel.description(), "Extended description for this secret.");
        assertEquals(secretMetadataModel.expirationDate(), DateUtils.parseAsDateTime("2030-04-01T09:30:00.000Z"));
        assertEquals(secretMetadataModel.ttl(), "24h");

        UpdateSecretMetadataOptions updateSecretMetadataOptionsModel = new UpdateSecretMetadataOptions.Builder()
                .secretType("arbitrary")
                .id("testString")
                .metadata(collectionMetadataModel)
                .resources(new java.util.ArrayList<SecretMetadata>(java.util.Arrays.asList(secretMetadataModel)))
                .build();
        assertEquals(updateSecretMetadataOptionsModel.secretType(), "arbitrary");
        assertEquals(updateSecretMetadataOptionsModel.id(), "testString");
        assertEquals(updateSecretMetadataOptionsModel.metadata(), collectionMetadataModel);
        assertEquals(updateSecretMetadataOptionsModel.resources(), new java.util.ArrayList<SecretMetadata>(java.util.Arrays.asList(secretMetadataModel)));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testUpdateSecretMetadataOptionsError() throws Throwable {
        new UpdateSecretMetadataOptions.Builder().build();
    }

}