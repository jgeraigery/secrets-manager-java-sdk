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

import java.util.Map;

/**
 * The request body of a `rotate` action.
 */
public class RotateArbitrarySecretBody extends SecretAction {


    /**
     * Builder.
     */
    public static class Builder {
        private Object payload;
        private Map<String, Object> customMetadata;
        private Map<String, Object> versionCustomMetadata;

        /**
         * Instantiates a new Builder from an existing RotateArbitrarySecretBody instance.
         *
         * @param rotateArbitrarySecretBody the instance to initialize the Builder with
         */
        public Builder(SecretAction rotateArbitrarySecretBody) {
            this.payload = rotateArbitrarySecretBody.payload;
            this.customMetadata = rotateArbitrarySecretBody.customMetadata;
            this.versionCustomMetadata = rotateArbitrarySecretBody.versionCustomMetadata;
        }

        /**
         * Instantiates a new builder.
         */
        public Builder() {
        }

        /**
         * Instantiates a new builder with required properties.
         *
         * @param payload the payload
         */
        public Builder(Object payload) {
            this.payload = payload;
        }

        /**
         * Builds a RotateArbitrarySecretBody.
         *
         * @return the new RotateArbitrarySecretBody instance
         */
        public RotateArbitrarySecretBody build() {
            return new RotateArbitrarySecretBody(this);
        }

        /**
         * Set the payload.
         *
         * @param payload the payload
         * @return the RotateArbitrarySecretBody builder
         */
        public Builder payload(Object payload) {
            this.payload = payload;
            return this;
        }

        /**
         * Set the customMetadata.
         *
         * @param customMetadata the customMetadata
         * @return the RotateArbitrarySecretBody builder
         */
        public Builder customMetadata(Map<String, Object> customMetadata) {
            this.customMetadata = customMetadata;
            return this;
        }

        /**
         * Set the versionCustomMetadata.
         *
         * @param versionCustomMetadata the versionCustomMetadata
         * @return the RotateArbitrarySecretBody builder
         */
        public Builder versionCustomMetadata(Map<String, Object> versionCustomMetadata) {
            this.versionCustomMetadata = versionCustomMetadata;
            return this;
        }
    }

    protected RotateArbitrarySecretBody() {
    }

    protected RotateArbitrarySecretBody(Builder builder) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(builder.payload,
                "payload cannot be null");
        payload = builder.payload;
        customMetadata = builder.customMetadata;
        versionCustomMetadata = builder.versionCustomMetadata;
    }

    /**
     * New builder.
     *
     * @return a RotateArbitrarySecretBody builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }
}

