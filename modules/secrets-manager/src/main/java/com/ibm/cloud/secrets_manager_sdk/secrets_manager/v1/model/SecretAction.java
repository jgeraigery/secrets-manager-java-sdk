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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * SecretAction.
 * <p>
 * Classes which extend this class:
 * - RotateArbitrarySecretBody
 * - RotatePublicCertBody
 * - RotateUsernamePasswordSecretBody
 * - RotateCertificateBody
 * - RotatePrivateCertBody
 * - RotatePrivateCertBodyWithCsr
 * - RotatePrivateCertBodyWithVersionCustomMetadata
 * - RestoreIAMCredentialsSecretBody
 * - DeleteCredentialsForIAMCredentialsSecret
 * - RotateKvSecretBody
 */
public class SecretAction extends GenericModel {

    protected Object payload;
    @SerializedName("custom_metadata")
    protected Map<String, Object> customMetadata;
    @SerializedName("version_custom_metadata")
    protected Map<String, Object> versionCustomMetadata;
    @SerializedName("rotate_keys")
    protected Boolean rotateKeys;
    protected String password;
    protected String certificate;
    @SerializedName("private_key")
    protected String privateKey;
    protected String intermediate;
    protected String csr;
    @SerializedName("version_id")
    protected String versionId;
    @SerializedName("api_key_id")
    protected String apiKeyId;
    @SerializedName("service_id")
    protected String serviceId;

    protected SecretAction() {
    }

    /**
     * Gets the payload.
     * <p>
     * The new secret data to assign to an `arbitrary` secret.
     *
     * @return the payload
     */
    public Object payload() {
        return payload;
    }

    /**
     * Gets the customMetadata.
     * <p>
     * The secret metadata that a user can customize.
     *
     * @return the customMetadata
     */
    public Map<String, Object> customMetadata() {
        return customMetadata;
    }

    /**
     * Gets the versionCustomMetadata.
     * <p>
     * The secret version metadata that a user can customize.
     *
     * @return the versionCustomMetadata
     */
    public Map<String, Object> versionCustomMetadata() {
        return versionCustomMetadata;
    }

    /**
     * Gets the rotateKeys.
     * <p>
     * Determine whether keys must be rotated.
     *
     * @return the rotateKeys
     */
    public Boolean rotateKeys() {
        return rotateKeys;
    }

    /**
     * Gets the password.
     * <p>
     * The new password to assign to a `username_password` secret.
     *
     * @return the password
     */
    public String password() {
        return password;
    }

    /**
     * Gets the certificate.
     * <p>
     * The new data to associate with the certificate.
     *
     * @return the certificate
     */
    public String certificate() {
        return certificate;
    }

    /**
     * Gets the privateKey.
     * <p>
     * The new private key to associate with the certificate.
     *
     * @return the privateKey
     */
    public String privateKey() {
        return privateKey;
    }

    /**
     * Gets the intermediate.
     * <p>
     * The new intermediate certificate to associate with the certificate.
     *
     * @return the intermediate
     */
    public String intermediate() {
        return intermediate;
    }

    /**
     * Gets the csr.
     * <p>
     * The certificate signing request. If you provide a CSR, it is used for auto rotation and manual rotation requests
     * that do not include a CSR. If you don't include the CSR, the certificate is generated with the last CSR that you
     * provided to create the private certificate, or on a previous request to rotate the certificate. If no CSR was
     * provided in the past, the certificate is generated with a CSR that is created internally.
     *
     * @return the csr
     */
    public String csr() {
        return csr;
    }

    /**
     * Gets the versionId.
     * <p>
     * The ID of the target version or the alias `previous`.
     *
     * @return the versionId
     */
    public String versionId() {
        return versionId;
    }

    /**
     * Gets the apiKeyId.
     * <p>
     * The ID of the API key that you want to delete. If the secret was created with a static service ID, only the API key
     * is deleted. Otherwise, the service ID is deleted together with its API key.
     *
     * @return the apiKeyId
     */
    public String apiKeyId() {
        return apiKeyId;
    }

    /**
     * Gets the serviceId.
     * <p>
     * The service ID that you want to delete. This property can be used instead of the `api_key_id` field, but only for
     * secrets that were created with a service ID that was generated by Secrets Manager.
     * <p>
     * **Deprecated.** Use the `api_key_id` field instead.
     *
     * @return the serviceId
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public String serviceId() {
        return serviceId;
    }
}

