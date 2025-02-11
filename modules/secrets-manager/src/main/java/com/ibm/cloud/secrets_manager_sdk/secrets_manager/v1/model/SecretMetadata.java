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

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * SecretMetadata.
 * <p>
 * Classes which extend this class:
 * - ArbitrarySecretMetadata
 * - UsernamePasswordSecretMetadata
 * - IAMCredentialsSecretMetadata
 * - CertificateSecretMetadata
 * - PublicCertificateSecretMetadata
 * - PrivateCertificateSecretMetadata
 * - KvSecretMetadata
 */
public class SecretMetadata extends GenericModel {

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

    protected String id;
    protected List<String> labels;
    protected String name;
    protected String description;
    @SerializedName("secret_group_id")
    protected String secretGroupId;
    protected Long state;
    @SerializedName("state_description")
    protected String stateDescription;
    @SerializedName("secret_type")
    protected String secretType;
    protected String crn;
    @SerializedName("creation_date")
    protected Date creationDate;
    @SerializedName("created_by")
    protected String createdBy;
    @SerializedName("last_update_date")
    protected Date lastUpdateDate;
    @SerializedName("versions_total")
    protected Long versionsTotal;
    @SerializedName("locks_total")
    protected Long locksTotal;
    @SerializedName("custom_metadata")
    protected Map<String, Object> customMetadata;
    @SerializedName("expiration_date")
    protected Date expirationDate;
    protected String ttl;
    @SerializedName("reuse_api_key")
    protected Boolean reuseApiKey;
    @SerializedName("service_id_is_static")
    protected Boolean serviceIdIsStatic;
    @SerializedName("service_id")
    protected String serviceId;
    @SerializedName("access_groups")
    protected List<String> accessGroups;
    @SerializedName("serial_number")
    protected String serialNumber;
    protected String algorithm;
    @SerializedName("key_algorithm")
    protected String keyAlgorithm;
    protected String issuer;
    protected CertificateValidity validity;
    @SerializedName("common_name")
    protected String commonName;
    @SerializedName("intermediate_included")
    protected Boolean intermediateIncluded;
    @SerializedName("private_key_included")
    protected Boolean privateKeyIncluded;
    @SerializedName("alt_names")
    protected List<String> altNames;
    @SerializedName("bundle_certs")
    protected Boolean bundleCerts;
    protected Rotation rotation;
    @SerializedName("issuance_info")
    protected IssuanceInfo issuanceInfo;
    @SerializedName("certificate_template")
    protected String certificateTemplate;
    @SerializedName("certificate_authority")
    protected String certificateAuthority;
    @SerializedName("revocation_time")
    protected Long revocationTime;
    @SerializedName("revocation_time_rfc3339")
    protected Date revocationTimeRfc3339;

    protected SecretMetadata() {
    }

    /**
     * Gets the id.
     * <p>
     * The unique ID of the secret.
     *
     * @return the id
     */
    public String id() {
        return id;
    }

    /**
     * Gets the labels.
     * <p>
     * Labels that you can use to filter for secrets in your instance.
     * <p>
     * Up to 30 labels can be created. Labels can be in the range 2 - 30 characters, including spaces. Special characters
     * that are not permitted include the angled bracket, comma, colon, ampersand, and vertical pipe character (|).
     * <p>
     * To protect your privacy, do not use personal data, such as your name or location, as a label for your secret.
     *
     * @return the labels
     */
    public List<String> labels() {
        return labels;
    }

    /**
     * Gets the name.
     * <p>
     * A human-readable alias to assign to your secret.
     * <p>
     * To protect your privacy, do not use personal data, such as your name or location, as an alias for your secret.
     *
     * @return the name
     */
    public String name() {
        return name;
    }

    /**
     * Gets the description.
     * <p>
     * An extended description of your secret.
     * <p>
     * To protect your privacy, do not use personal data, such as your name or location, as a description for your secret.
     *
     * @return the description
     */
    public String description() {
        return description;
    }

    /**
     * Gets the secretGroupId.
     * <p>
     * The v4 UUID that uniquely identifies the secret group to assign to this secret.
     * <p>
     * If you omit this parameter, your secret is assigned to the `default` secret group.
     *
     * @return the secretGroupId
     */
    public String secretGroupId() {
        return secretGroupId;
    }

    /**
     * Gets the state.
     * <p>
     * The secret state based on NIST SP 800-57. States are integers and correspond to the Pre-activation = 0, Active = 1,
     * Suspended = 2, Deactivated = 3, and Destroyed = 5 values.
     *
     * @return the state
     */
    public Long state() {
        return state;
    }

    /**
     * Gets the stateDescription.
     * <p>
     * A text representation of the secret state.
     *
     * @return the stateDescription
     */
    public String stateDescription() {
        return stateDescription;
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
     * Gets the crn.
     * <p>
     * The Cloud Resource Name (CRN) that uniquely identifies the resource.
     *
     * @return the crn
     */
    public String crn() {
        return crn;
    }

    /**
     * Gets the creationDate.
     * <p>
     * The date the secret was created. The date format follows RFC 3339.
     *
     * @return the creationDate
     */
    public Date creationDate() {
        return creationDate;
    }

    /**
     * Gets the createdBy.
     * <p>
     * The unique identifier for the entity that created the secret.
     *
     * @return the createdBy
     */
    public String createdBy() {
        return createdBy;
    }

    /**
     * Gets the lastUpdateDate.
     * <p>
     * Updates when any part of the secret metadata is modified. The date format follows RFC 3339.
     *
     * @return the lastUpdateDate
     */
    public Date lastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * Gets the versionsTotal.
     * <p>
     * The number of versions that are associated with a secret.
     *
     * @return the versionsTotal
     */
    public Long versionsTotal() {
        return versionsTotal;
    }

    /**
     * Gets the locksTotal.
     * <p>
     * The number of locks that are associated with a secret.
     *
     * @return the locksTotal
     */
    public Long locksTotal() {
        return locksTotal;
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
     * Gets the expirationDate.
     * <p>
     * The date the secret material expires. The date format follows RFC 3339.
     * <p>
     * You can set an expiration date on supported secret types at their creation. If you create a secret without
     * specifying an expiration date, the secret does not expire. The `expiration_date` field is supported for the
     * following secret types:
     * <p>
     * - `arbitrary`
     * - `username_password`.
     *
     * @return the expirationDate
     */
    public Date expirationDate() {
        return expirationDate;
    }

    /**
     * Gets the ttl.
     * <p>
     * The time-to-live (TTL) or lease duration that is assigned to the secret. For `iam_credentials` secrets, the TTL
     * defines for how long each generated API key remains valid.
     *
     * @return the ttl
     */
    public String ttl() {
        return ttl;
    }

    /**
     * Gets the reuseApiKey.
     * <p>
     * Determines whether to use the same service ID and API key for future read operations on an
     * `iam_credentials` secret.
     * <p>
     * If set to `true`, the service reuses the current credentials. If set to `false`, a new service ID and API key are
     * generated each time that the secret is read or accessed.
     *
     * @return the reuseApiKey
     */
    public Boolean reuseApiKey() {
        return reuseApiKey;
    }

    /**
     * Gets the serviceIdIsStatic.
     * <p>
     * Indicates whether an `iam_credentials` secret was created with a static service ID.
     * <p>
     * If the value is `true`, the service ID for the secret was provided by the user at secret creation. If the value is
     * `false`, the service ID was generated by Secrets Manager.
     *
     * @return the serviceIdIsStatic
     */
    public Boolean serviceIdIsStatic() {
        return serviceIdIsStatic;
    }

    /**
     * Gets the serviceId.
     * <p>
     * The service ID under which the API key is created. The service ID is included in the metadata only if the secret
     * was created with a static service ID.
     *
     * @return the serviceId
     */
    public String serviceId() {
        return serviceId;
    }

    /**
     * Gets the accessGroups.
     * <p>
     * The access groups that define the capabilities of the service ID and API key that are generated for an
     * `iam_credentials` secret. The access groups are included in the metadata only if the secret was created with a
     * service ID that was generated by Secrets Manager.
     *
     * @return the accessGroups
     */
    public List<String> accessGroups() {
        return accessGroups;
    }

    /**
     * Gets the serialNumber.
     * <p>
     * The unique serial number that was assigned to the certificate by the issuing certificate authority.
     *
     * @return the serialNumber
     */
    public String serialNumber() {
        return serialNumber;
    }

    /**
     * Gets the algorithm.
     * <p>
     * The identifier for the cryptographic algorithm that was used by the issuing certificate authority to sign the
     * certificate.
     *
     * @return the algorithm
     */
    public String algorithm() {
        return algorithm;
    }

    /**
     * Gets the keyAlgorithm.
     * <p>
     * The identifier for the cryptographic algorithm that was used to generate the public and private keys that are
     * associated with the certificate.
     *
     * @return the keyAlgorithm
     */
    public String keyAlgorithm() {
        return keyAlgorithm;
    }

    /**
     * Gets the issuer.
     * <p>
     * The distinguished name that identifies the entity that signed and issued the certificate.
     *
     * @return the issuer
     */
    public String issuer() {
        return issuer;
    }

    /**
     * Gets the validity.
     *
     * @return the validity
     */
    public CertificateValidity validity() {
        return validity;
    }

    /**
     * Gets the commonName.
     * <p>
     * The fully qualified domain name or host domain name that is defined for the certificate.
     *
     * @return the commonName
     */
    public String commonName() {
        return commonName;
    }

    /**
     * Gets the intermediateIncluded.
     * <p>
     * Indicates whether the certificate was imported with an associated intermediate certificate.
     *
     * @return the intermediateIncluded
     */
    public Boolean intermediateIncluded() {
        return intermediateIncluded;
    }

    /**
     * Gets the privateKeyIncluded.
     * <p>
     * Indicates whether the certificate was imported with an associated private key.
     *
     * @return the privateKeyIncluded
     */
    public Boolean privateKeyIncluded() {
        return privateKeyIncluded;
    }

    /**
     * Gets the altNames.
     * <p>
     * The alternative names that are defined for the certificate.
     *
     * @return the altNames
     */
    public List<String> altNames() {
        return altNames;
    }

    /**
     * Gets the bundleCerts.
     * <p>
     * Determines whether your issued certificate is bundled with intermediate certificates.
     * <p>
     * Set to `false` for the certificate file to contain only the issued certificate.
     *
     * @return the bundleCerts
     */
    public Boolean bundleCerts() {
        return bundleCerts;
    }

    /**
     * Gets the rotation.
     *
     * @return the rotation
     */
    public Rotation rotation() {
        return rotation;
    }

    /**
     * Gets the issuanceInfo.
     * <p>
     * Issuance information that is associated with your certificate.
     *
     * @return the issuanceInfo
     */
    public IssuanceInfo issuanceInfo() {
        return issuanceInfo;
    }

    /**
     * Gets the certificateTemplate.
     * <p>
     * The name of the certificate template.
     *
     * @return the certificateTemplate
     */
    public String certificateTemplate() {
        return certificateTemplate;
    }

    /**
     * Gets the certificateAuthority.
     * <p>
     * The intermediate certificate authority that signed this certificate.
     *
     * @return the certificateAuthority
     */
    public String certificateAuthority() {
        return certificateAuthority;
    }

    /**
     * Gets the revocationTime.
     * <p>
     * The timestamp of the certificate revocation.
     *
     * @return the revocationTime
     */
    public Long revocationTime() {
        return revocationTime;
    }

    /**
     * Gets the revocationTimeRfc3339.
     * <p>
     * The date and time that the certificate was revoked. The date format follows RFC 3339.
     *
     * @return the revocationTimeRfc3339
     */
    public Date revocationTimeRfc3339() {
        return revocationTimeRfc3339;
    }
}

