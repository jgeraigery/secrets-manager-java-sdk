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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Properties that describe a secret.
 */
public class UsernamePasswordSecretResource extends SecretResource {

    /**
     * The secret type.
     */
    public interface SecretType {
        /**
         * arbitrary.
         */
        String ARBITRARY = "arbitrary";
        /**
         * username_password.
         */
        String USERNAME_PASSWORD = "username_password";
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
         * kv.
         */
        String KV = "kv";
    }


    /**
     * Builder.
     */
    public static class Builder {
        private String name;
        private String description;
        private String secretGroupId;
        private List<String> labels;
        private Map<String, Object> customMetadata;
        private Map<String, Object> versionCustomMetadata;
        private String username;
        private String password;
        private Date expirationDate;

        /**
         * Instantiates a new Builder from an existing UsernamePasswordSecretResource instance.
         *
         * @param usernamePasswordSecretResource the instance to initialize the Builder with
         */
        public Builder(SecretResource usernamePasswordSecretResource) {
            this.name = usernamePasswordSecretResource.name;
            this.description = usernamePasswordSecretResource.description;
            this.secretGroupId = usernamePasswordSecretResource.secretGroupId;
            this.labels = usernamePasswordSecretResource.labels;
            this.customMetadata = usernamePasswordSecretResource.customMetadata;
            this.versionCustomMetadata = usernamePasswordSecretResource.versionCustomMetadata;
            this.username = usernamePasswordSecretResource.username;
            this.password = usernamePasswordSecretResource.password;
            this.expirationDate = usernamePasswordSecretResource.expirationDate;
        }

        /**
         * Instantiates a new builder.
         */
        public Builder() {
        }

        /**
         * Instantiates a new builder with required properties.
         *
         * @param name the name
         */
        public Builder(String name) {
            this.name = name;
        }

        /**
         * Builds a UsernamePasswordSecretResource.
         *
         * @return the new UsernamePasswordSecretResource instance
         */
        public UsernamePasswordSecretResource build() {
            return new UsernamePasswordSecretResource(this);
        }

        /**
         * Adds an labels to labels.
         *
         * @param labels the new labels
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder addLabels(String labels) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(labels,
                    "labels cannot be null");
            if (this.labels == null) {
                this.labels = new ArrayList<String>();
            }
            this.labels.add(labels);
            return this;
        }

        /**
         * Set the name.
         *
         * @param name the name
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set the description.
         *
         * @param description the description
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Set the secretGroupId.
         *
         * @param secretGroupId the secretGroupId
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder secretGroupId(String secretGroupId) {
            this.secretGroupId = secretGroupId;
            return this;
        }

        /**
         * Set the labels.
         * Existing labels will be replaced.
         *
         * @param labels the labels
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder labels(List<String> labels) {
            this.labels = labels;
            return this;
        }

        /**
         * Set the customMetadata.
         *
         * @param customMetadata the customMetadata
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder customMetadata(Map<String, Object> customMetadata) {
            this.customMetadata = customMetadata;
            return this;
        }

        /**
         * Set the versionCustomMetadata.
         *
         * @param versionCustomMetadata the versionCustomMetadata
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder versionCustomMetadata(Map<String, Object> versionCustomMetadata) {
            this.versionCustomMetadata = versionCustomMetadata;
            return this;
        }

        /**
         * Set the username.
         *
         * @param username the username
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        /**
         * Set the password.
         *
         * @param password the password
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * Set the expirationDate.
         *
         * @param expirationDate the expirationDate
         * @return the UsernamePasswordSecretResource builder
         */
        public Builder expirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }
    }

    protected UsernamePasswordSecretResource() {
    }

    protected UsernamePasswordSecretResource(Builder builder) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
                "name cannot be null");
        name = builder.name;
        description = builder.description;
        secretGroupId = builder.secretGroupId;
        labels = builder.labels;
        customMetadata = builder.customMetadata;
        versionCustomMetadata = builder.versionCustomMetadata;
        username = builder.username;
        password = builder.password;
        expirationDate = builder.expirationDate;
    }

    /**
     * New builder.
     *
     * @return a UsernamePasswordSecretResource builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }
}

