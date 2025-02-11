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
import java.util.Map;

/**
 * Properties that describe a secret.
 */
public class CertificateSecretResource extends SecretResource {

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
        private String certificate;
        private String privateKey;
        private String intermediate;
        private Object altNames;

        /**
         * Instantiates a new Builder from an existing CertificateSecretResource instance.
         *
         * @param certificateSecretResource the instance to initialize the Builder with
         */
        public Builder(SecretResource certificateSecretResource) {
            this.name = certificateSecretResource.name;
            this.description = certificateSecretResource.description;
            this.secretGroupId = certificateSecretResource.secretGroupId;
            this.labels = certificateSecretResource.labels;
            this.customMetadata = certificateSecretResource.customMetadata;
            this.versionCustomMetadata = certificateSecretResource.versionCustomMetadata;
            this.certificate = certificateSecretResource.certificate;
            this.privateKey = certificateSecretResource.privateKey;
            this.intermediate = certificateSecretResource.intermediate;
            this.altNames = certificateSecretResource.altNames;
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
         * Builds a CertificateSecretResource.
         *
         * @return the new CertificateSecretResource instance
         */
        public CertificateSecretResource build() {
            return new CertificateSecretResource(this);
        }

        /**
         * Adds an labels to labels.
         *
         * @param labels the new labels
         * @return the CertificateSecretResource builder
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
         * @return the CertificateSecretResource builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set the description.
         *
         * @param description the description
         * @return the CertificateSecretResource builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Set the secretGroupId.
         *
         * @param secretGroupId the secretGroupId
         * @return the CertificateSecretResource builder
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
         * @return the CertificateSecretResource builder
         */
        public Builder labels(List<String> labels) {
            this.labels = labels;
            return this;
        }

        /**
         * Set the customMetadata.
         *
         * @param customMetadata the customMetadata
         * @return the CertificateSecretResource builder
         */
        public Builder customMetadata(Map<String, Object> customMetadata) {
            this.customMetadata = customMetadata;
            return this;
        }

        /**
         * Set the versionCustomMetadata.
         *
         * @param versionCustomMetadata the versionCustomMetadata
         * @return the CertificateSecretResource builder
         */
        public Builder versionCustomMetadata(Map<String, Object> versionCustomMetadata) {
            this.versionCustomMetadata = versionCustomMetadata;
            return this;
        }

        /**
         * Set the certificate.
         *
         * @param certificate the certificate
         * @return the CertificateSecretResource builder
         */
        public Builder certificate(String certificate) {
            this.certificate = certificate;
            return this;
        }

        /**
         * Set the privateKey.
         *
         * @param privateKey the privateKey
         * @return the CertificateSecretResource builder
         */
        public Builder privateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }

        /**
         * Set the intermediate.
         *
         * @param intermediate the intermediate
         * @return the CertificateSecretResource builder
         */
        public Builder intermediate(String intermediate) {
            this.intermediate = intermediate;
            return this;
        }

        /**
         * Set the altNames.
         *
         * @param altNames the altNames
         * @return the CertificateSecretResource builder
         */
        public Builder altNames(Object altNames) {
            this.altNames = altNames;
            return this;
        }
    }

    protected CertificateSecretResource() {
    }

    protected CertificateSecretResource(Builder builder) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
                "name cannot be null");
        name = builder.name;
        description = builder.description;
        secretGroupId = builder.secretGroupId;
        labels = builder.labels;
        customMetadata = builder.customMetadata;
        versionCustomMetadata = builder.versionCustomMetadata;
        certificate = builder.certificate;
        privateKey = builder.privateKey;
        intermediate = builder.intermediate;
        altNames = builder.altNames;
    }

    /**
     * New builder.
     *
     * @return a CertificateSecretResource builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }
}

