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
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.Rotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.utils.TestUtilities;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Unit test class for the Rotation model.
 */
public class RotationTest {
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    @Test
    public void testRotation() throws Throwable {
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

        String json = TestUtilities.serialize(rotationModel);

        Rotation rotationModelNew = TestUtilities.deserialize(json, Rotation.class);
        assertTrue(rotationModelNew instanceof Rotation);
        assertEquals(rotationModelNew.autoRotate(), Boolean.valueOf(false));
        assertEquals(rotationModelNew.rotateKeys(), Boolean.valueOf(false));
        assertEquals(rotationModelNew.interval(), Long.valueOf("26"));
        assertEquals(rotationModelNew.unit(), "day");
    }
}