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
 * Metadata properties that describe a public certificate secret.
 */
public class PublicCertificateSecretMetadata extends SecretMetadata {

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
     * The identifier for the cryptographic algorithm to be used to generate the public key that is associated with the
     * certificate.
     */
    public interface KeyAlgorithm {
        /**
         * RSA2048.
         */
        String RSA2048 = "RSA2048";
        /**
         * RSA4096.
         */
        String RSA4096 = "RSA4096";
        /**
         * EC256.
         */
        String EC256 = "EC256";
        /**
         * EC384.
         */
        String EC384 = "EC384";
    }


    /**
     * Builder.
     */
    public static class Builder {
        private List<String> labels;
        private String name;
        private String description;
        private Map<String, Object> customMetadata;
        private Boolean bundleCerts;
        private String keyAlgorithm;
        private List<String> altNames;
        private String commonName;
        private Rotation rotation;

        /**
         * Instantiates a new Builder from an existing PublicCertificateSecretMetadata instance.
         *
         * @param publicCertificateSecretMetadata the instance to initialize the Builder with
         */
        public Builder(SecretMetadata publicCertificateSecretMetadata) {
            this.labels = publicCertificateSecretMetadata.labels;
            this.name = publicCertificateSecretMetadata.name;
            this.description = publicCertificateSecretMetadata.description;
            this.customMetadata = publicCertificateSecretMetadata.customMetadata;
            this.bundleCerts = publicCertificateSecretMetadata.bundleCerts;
            this.keyAlgorithm = publicCertificateSecretMetadata.keyAlgorithm;
            this.altNames = publicCertificateSecretMetadata.altNames;
            this.commonName = publicCertificateSecretMetadata.commonName;
            this.rotation = publicCertificateSecretMetadata.rotation;
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
         * Builds a PublicCertificateSecretMetadata.
         *
         * @return the new PublicCertificateSecretMetadata instance
         */
        public PublicCertificateSecretMetadata build() {
            return new PublicCertificateSecretMetadata(this);
        }

        /**
         * Adds an labels to labels.
         *
         * @param labels the new labels
         * @return the PublicCertificateSecretMetadata builder
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
         * Adds an altNames to altNames.
         *
         * @param altNames the new altNames
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder addAltNames(String altNames) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(altNames,
                    "altNames cannot be null");
            if (this.altNames == null) {
                this.altNames = new ArrayList<String>();
            }
            this.altNames.add(altNames);
            return this;
        }

        /**
         * Set the labels.
         * Existing labels will be replaced.
         *
         * @param labels the labels
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder labels(List<String> labels) {
            this.labels = labels;
            return this;
        }

        /**
         * Set the name.
         *
         * @param name the name
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set the description.
         *
         * @param description the description
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder description(String description) {
            this.description = description;
            return this;
        }

        /**
         * Set the customMetadata.
         *
         * @param customMetadata the customMetadata
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder customMetadata(Map<String, Object> customMetadata) {
            this.customMetadata = customMetadata;
            return this;
        }

        /**
         * Set the bundleCerts.
         *
         * @param bundleCerts the bundleCerts
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder bundleCerts(Boolean bundleCerts) {
            this.bundleCerts = bundleCerts;
            return this;
        }

        /**
         * Set the keyAlgorithm.
         *
         * @param keyAlgorithm the keyAlgorithm
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder keyAlgorithm(String keyAlgorithm) {
            this.keyAlgorithm = keyAlgorithm;
            return this;
        }

        /**
         * Set the altNames.
         * Existing altNames will be replaced.
         *
         * @param altNames the altNames
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder altNames(List<String> altNames) {
            this.altNames = altNames;
            return this;
        }

        /**
         * Set the commonName.
         *
         * @param commonName the commonName
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder commonName(String commonName) {
            this.commonName = commonName;
            return this;
        }

        /**
         * Set the rotation.
         *
         * @param rotation the rotation
         * @return the PublicCertificateSecretMetadata builder
         */
        public Builder rotation(Rotation rotation) {
            this.rotation = rotation;
            return this;
        }
    }

    protected PublicCertificateSecretMetadata() {
    }

    protected PublicCertificateSecretMetadata(Builder builder) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
                "name cannot be null");
        labels = builder.labels;
        name = builder.name;
        description = builder.description;
        customMetadata = builder.customMetadata;
        bundleCerts = builder.bundleCerts;
        keyAlgorithm = builder.keyAlgorithm;
        altNames = builder.altNames;
        commonName = builder.commonName;
        rotation = builder.rotation;
    }

    /**
     * New builder.
     *
     * @return a PublicCertificateSecretMetadata builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }
}

