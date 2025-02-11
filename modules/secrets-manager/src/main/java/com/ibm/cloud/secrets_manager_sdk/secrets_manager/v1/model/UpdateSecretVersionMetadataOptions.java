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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateSecretVersionMetadata options.
 */
public class UpdateSecretVersionMetadataOptions extends GenericModel {

    /**
     * The secret type.
     */
    public interface SecretType {
        /**
         * arbitrary.
         */
        String ARBITRARY = "arbitrary";
        /**
         * iam_credentials.
         */
        String IAM_CREDENTIALS = "iam_credentials";
        /**
         * imported_cert.
         */
        String IMPORTED_CERT = "imported_cert";
        /**
         * public_cert.
         */
        String PUBLIC_CERT = "public_cert";
        /**
         * private_cert.
         */
        String PRIVATE_CERT = "private_cert";
        /**
         * username_password.
         */
        String USERNAME_PASSWORD = "username_password";
        /**
         * kv.
         */
        String KV = "kv";
    }

    protected String secretType;
    protected String id;
    protected String versionId;
    protected CollectionMetadata metadata;
    protected List<UpdateSecretVersionMetadata> resources;

    /**
     * Builder.
     */
    public static class Builder {
        private String secretType;
        private String id;
        private String versionId;
        private CollectionMetadata metadata;
        private List<UpdateSecretVersionMetadata> resources;

        /**
         * Instantiates a new Builder from an existing UpdateSecretVersionMetadataOptions instance.
         *
         * @param updateSecretVersionMetadataOptions the instance to initialize the Builder with
         */
        private Builder(UpdateSecretVersionMetadataOptions updateSecretVersionMetadataOptions) {
            this.secretType = updateSecretVersionMetadataOptions.secretType;
            this.id = updateSecretVersionMetadataOptions.id;
            this.versionId = updateSecretVersionMetadataOptions.versionId;
            this.metadata = updateSecretVersionMetadataOptions.metadata;
            this.resources = updateSecretVersionMetadataOptions.resources;
        }

        /**
         * Instantiates a new builder.
         */
        public Builder() {
        }

        /**
         * Instantiates a new builder with required properties.
         *
         * @param secretType the secretType
         * @param id         the id
         * @param versionId  the versionId
         * @param metadata   the metadata
         * @param resources  the resources
         */
        public Builder(String secretType, String id, String versionId, CollectionMetadata metadata, List<UpdateSecretVersionMetadata> resources) {
            this.secretType = secretType;
            this.id = id;
            this.versionId = versionId;
            this.metadata = metadata;
            this.resources = resources;
        }

        /**
         * Builds a UpdateSecretVersionMetadataOptions.
         *
         * @return the new UpdateSecretVersionMetadataOptions instance
         */
        public UpdateSecretVersionMetadataOptions build() {
            return new UpdateSecretVersionMetadataOptions(this);
        }

        /**
         * Adds an resources to resources.
         *
         * @param resources the new resources
         * @return the UpdateSecretVersionMetadataOptions builder
         */
        public Builder addResources(UpdateSecretVersionMetadata resources) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
                    "resources cannot be null");
            if (this.resources == null) {
                this.resources = new ArrayList<UpdateSecretVersionMetadata>();
            }
            this.resources.add(resources);
            return this;
        }

        /**
         * Set the secretType.
         *
         * @param secretType the secretType
         * @return the UpdateSecretVersionMetadataOptions builder
         */
        public Builder secretType(String secretType) {
            this.secretType = secretType;
            return this;
        }

        /**
         * Set the id.
         *
         * @param id the id
         * @return the UpdateSecretVersionMetadataOptions builder
         */
        public Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Set the versionId.
         *
         * @param versionId the versionId
         * @return the UpdateSecretVersionMetadataOptions builder
         */
        public Builder versionId(String versionId) {
            this.versionId = versionId;
            return this;
        }

        /**
         * Set the metadata.
         *
         * @param metadata the metadata
         * @return the UpdateSecretVersionMetadataOptions builder
         */
        public Builder metadata(CollectionMetadata metadata) {
            this.metadata = metadata;
            return this;
        }

        /**
         * Set the resources.
         * Existing resources will be replaced.
         *
         * @param resources the resources
         * @return the UpdateSecretVersionMetadataOptions builder
         */
        public Builder resources(List<UpdateSecretVersionMetadata> resources) {
            this.resources = resources;
            return this;
        }
    }

    protected UpdateSecretVersionMetadataOptions() {
    }

    protected UpdateSecretVersionMetadataOptions(Builder builder) {
        com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.secretType,
                "secretType cannot be empty");
        com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
                "id cannot be empty");
        com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionId,
                "versionId cannot be empty");
        com.ibm.cloud.sdk.core.util.Validator.notNull(builder.metadata,
                "metadata cannot be null");
        com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resources,
                "resources cannot be null");
        secretType = builder.secretType;
        id = builder.id;
        versionId = builder.versionId;
        metadata = builder.metadata;
        resources = builder.resources;
    }

    /**
     * New builder.
     *
     * @return a UpdateSecretVersionMetadataOptions builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }

    /**
     * Gets the secretType.
     * <p>
     * The secret type.
     *
     * @return the secretType
     */
    public String secretType() {
        return secretType;
    }

    /**
     * Gets the id.
     * <p>
     * The v4 UUID that uniquely identifies the secret.
     *
     * @return the id
     */
    public String id() {
        return id;
    }

    /**
     * Gets the versionId.
     * <p>
     * The v4 UUID that uniquely identifies the secret version. You can also use `previous` to retrieve the previous
     * version.
     * <p>
     * **Note:** To find the version ID of a secret, use the [Get secret metadata](#get-secret-metadata) method and check
     * the response details.
     *
     * @return the versionId
     */
    public String versionId() {
        return versionId;
    }

    /**
     * Gets the metadata.
     * <p>
     * The metadata that describes the resource array.
     *
     * @return the metadata
     */
    public CollectionMetadata metadata() {
        return metadata;
    }

    /**
     * Gets the resources.
     * <p>
     * A collection of resources.
     *
     * @return the resources
     */
    public List<UpdateSecretVersionMetadata> resources() {
        return resources;
    }
}

