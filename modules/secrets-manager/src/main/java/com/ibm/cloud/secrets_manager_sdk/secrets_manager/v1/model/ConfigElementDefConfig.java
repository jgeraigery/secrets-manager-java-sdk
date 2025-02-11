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
 * The configuration to define for the specified secret type.
 * <p>
 * Classes which extend this class:
 * - ConfigElementDefConfigLetsEncryptConfig
 * - ConfigElementDefConfigCloudInternetServicesConfig
 * - ConfigElementDefConfigClassicInfrastructureConfig
 * - RootCertificateAuthorityConfig
 * - IntermediateCertificateAuthorityConfig
 * - CertificateTemplateConfig
 */
public class ConfigElementDefConfig extends GenericModel {

    /**
     * The status of the certificate authority. The status of a root certificate authority is either `configured` or
     * `expired`. For intermediate certificate authorities, possible statuses include `signing_required`,
     * `signed_certificate_required`, `certificate_template_required`, `configured`, `expired` or `revoked`.
     */
    public interface Status {
        /**
         * signing_required.
         */
        String SIGNING_REQUIRED = "signing_required";
        /**
         * signed_certificate_required.
         */
        String SIGNED_CERTIFICATE_REQUIRED = "signed_certificate_required";
        /**
         * certificate_template_required.
         */
        String CERTIFICATE_TEMPLATE_REQUIRED = "certificate_template_required";
        /**
         * configured.
         */
        String CONFIGURED = "configured";
        /**
         * expired.
         */
        String EXPIRED = "expired";
        /**
         * revoked.
         */
        String REVOKED = "revoked";
    }

    /**
     * The format of the returned data.
     */
    public interface Format {
        /**
         * pem.
         */
        String PEM = "pem";
        /**
         * pem_bundle.
         */
        String PEM_BUNDLE = "pem_bundle";
    }

    /**
     * The format of the generated private key.
     */
    public interface PrivateKeyFormat {
        /**
         * der.
         */
        String DER = "der";
        /**
         * pkcs8.
         */
        String PKCS8 = "pkcs8";
    }

    /**
     * The type of private key to generate.
     */
    public interface KeyType {
        /**
         * rsa.
         */
        String RSA = "rsa";
        /**
         * ec.
         */
        String EC = "ec";
    }

    /**
     * The signing method to use with this certificate authority to generate private certificates.
     * <p>
     * You can choose between internal or externally signed options. For more information, see the
     * [docs](https://cloud.ibm.com/docs/secrets-manager?topic=secrets-manager-intermediate-certificate-authorities).
     */
    public interface SigningMethod {
        /**
         * internal.
         */
        String INTERNAL = "internal";
        /**
         * external.
         */
        String EXTERNAL = "external";
    }

    @SerializedName("private_key")
    protected String privateKey;
    @SerializedName("cis_crn")
    protected String cisCrn;
    @SerializedName("cis_apikey")
    protected String cisApikey;
    @SerializedName("classic_infrastructure_username")
    protected String classicInfrastructureUsername;
    @SerializedName("classic_infrastructure_password")
    protected String classicInfrastructurePassword;
    @SerializedName("max_ttl")
    protected Object maxTtl;
    @SerializedName("crl_expiry")
    protected Object crlExpiry;
    @SerializedName("crl_disable")
    protected Boolean crlDisable;
    @SerializedName("crl_distribution_points_encoded")
    protected Boolean crlDistributionPointsEncoded;
    @SerializedName("issuing_certificates_urls_encoded")
    protected Boolean issuingCertificatesUrlsEncoded;
    @SerializedName("common_name")
    protected String commonName;
    protected String status;
    @SerializedName("expiration_date")
    protected Date expirationDate;
    @SerializedName("alt_names")
    protected String altNames;
    @SerializedName("ip_sans")
    protected String ipSans;
    @SerializedName("uri_sans")
    protected String uriSans;
    @SerializedName("other_sans")
    protected List<String> otherSans;
    protected Object ttl;
    protected String format;
    @SerializedName("private_key_format")
    protected String privateKeyFormat;
    @SerializedName("key_type")
    protected String keyType;
    @SerializedName("key_bits")
    protected Long keyBits;
    @SerializedName("max_path_length")
    protected Long maxPathLength;
    @SerializedName("exclude_cn_from_sans")
    protected Boolean excludeCnFromSans;
    @SerializedName("permitted_dns_domains")
    protected List<String> permittedDnsDomains;
    protected List<String> ou;
    protected List<String> organization;
    protected List<String> country;
    protected List<String> locality;
    protected List<String> province;
    @SerializedName("street_address")
    protected List<String> streetAddress;
    @SerializedName("postal_code")
    protected List<String> postalCode;
    @SerializedName("serial_number")
    protected String serialNumber;
    protected Map<String, Object> data;
    @SerializedName("signing_method")
    protected String signingMethod;
    protected String issuer;
    @SerializedName("certificate_authority")
    protected String certificateAuthority;
    @SerializedName("allowed_secret_groups")
    protected String allowedSecretGroups;
    @SerializedName("allow_localhost")
    protected Boolean allowLocalhost;
    @SerializedName("allowed_domains")
    protected List<String> allowedDomains;
    @SerializedName("allowed_domains_template")
    protected Boolean allowedDomainsTemplate;
    @SerializedName("allow_bare_domains")
    protected Boolean allowBareDomains;
    @SerializedName("allow_subdomains")
    protected Boolean allowSubdomains;
    @SerializedName("allow_glob_domains")
    protected Boolean allowGlobDomains;
    @SerializedName("allow_any_name")
    protected Boolean allowAnyName;
    @SerializedName("enforce_hostnames")
    protected Boolean enforceHostnames;
    @SerializedName("allow_ip_sans")
    protected Boolean allowIpSans;
    @SerializedName("allowed_uri_sans")
    protected List<String> allowedUriSans;
    @SerializedName("allowed_other_sans")
    protected List<String> allowedOtherSans;
    @SerializedName("server_flag")
    protected Boolean serverFlag;
    @SerializedName("client_flag")
    protected Boolean clientFlag;
    @SerializedName("code_signing_flag")
    protected Boolean codeSigningFlag;
    @SerializedName("email_protection_flag")
    protected Boolean emailProtectionFlag;
    @SerializedName("key_usage")
    protected List<String> keyUsage;
    @SerializedName("ext_key_usage")
    protected List<String> extKeyUsage;
    @SerializedName("ext_key_usage_oids")
    protected List<String> extKeyUsageOids;
    @SerializedName("use_csr_common_name")
    protected Boolean useCsrCommonName;
    @SerializedName("use_csr_sans")
    protected Boolean useCsrSans;
    @SerializedName("require_cn")
    protected Boolean requireCn;
    @SerializedName("policy_identifiers")
    protected List<String> policyIdentifiers;
    @SerializedName("basic_constraints_valid_for_non_ca")
    protected Boolean basicConstraintsValidForNonCa;
    @SerializedName("not_before_duration")
    protected Object notBeforeDuration;

    protected ConfigElementDefConfig() {
    }

    /**
     * Gets the privateKey.
     * <p>
     * The private key that is associated with your Automatic Certificate Management Environment (ACME) account.
     * <p>
     * If you have a working ACME client or account for Let's Encrypt, you can use the existing private key to enable
     * communications with Secrets Manager. If you don't have an account yet, you can create one. For more information,
     * see the
     * [docs](https://cloud.ibm.com/docs/secrets-manager?topic=secrets-manager-prepare-order-certificates#create-acme-account).
     *
     * @return the privateKey
     */
    public String privateKey() {
        return privateKey;
    }

    /**
     * Gets the cisCrn.
     * <p>
     * The Cloud Resource Name (CRN) that is associated with the CIS instance.
     *
     * @return the cisCrn
     */
    public String cisCrn() {
        return cisCrn;
    }

    /**
     * Gets the cisApikey.
     * <p>
     * An IBM Cloud API key that can to list domains in your CIS instance.
     * <p>
     * To grant Secrets Manager the ability to view the CIS instance and all of its domains, the API key must be assigned
     * the Reader service role on Internet Services (`internet-svcs`).
     * <p>
     * If you need to manage specific domains, you can assign the Manager role. For production environments, it is
     * recommended that you assign the Reader access role, and then use the
     * [IAM Policy Management API](https://cloud.ibm.com/apidocs/iam-policy-management#create-policy) to control specific
     * domains. For more information, see the
     * [docs](https://cloud.ibm.com/docs/secrets-manager?topic=secrets-manager-prepare-order-certificates#authorize-specific-domains).
     *
     * @return the cisApikey
     */
    public String cisApikey() {
        return cisApikey;
    }

    /**
     * Gets the classicInfrastructureUsername.
     * <p>
     * The username that is associated with your classic infrastructure account.
     * <p>
     * In most cases, your classic infrastructure username is your `&lt;account_id&gt;_&lt;email_address&gt;`. For more
     * information, see the [docs](https://cloud.ibm.com/docs/account?topic=account-classic_keys).
     *
     * @return the classicInfrastructureUsername
     */
    public String classicInfrastructureUsername() {
        return classicInfrastructureUsername;
    }

    /**
     * Gets the classicInfrastructurePassword.
     * <p>
     * Your classic infrastructure API key.
     * <p>
     * For information about viewing and accessing your classic infrastructure API key, see the
     * [docs](https://cloud.ibm.com/docs/account?topic=account-classic_keys).
     *
     * @return the classicInfrastructurePassword
     */
    public String classicInfrastructurePassword() {
        return classicInfrastructurePassword;
    }

    /**
     * Gets the maxTtl.
     * <p>
     * The maximum time-to-live (TTL) for certificates that are created by this CA.
     * <p>
     * The value can be supplied as a string representation of a duration in hours, for example '8760h'. In the API
     * response, this value is returned in seconds (integer).
     * <p>
     * Minimum value is one hour (`1h`). Maximum value is 100 years (`876000h`).
     *
     * @return the maxTtl
     */
    public Object maxTtl() {
        return maxTtl;
    }

    /**
     * Gets the crlExpiry.
     * <p>
     * The time until the certificate revocation list (CRL) expires.
     * <p>
     * The value can be supplied as a string representation of a duration in hours, such as `48h`. The default is 72
     * hours. In the API response, this value is returned in seconds (integer).
     * <p>
     * **Note:** The CRL is rotated automatically before it expires.
     *
     * @return the crlExpiry
     */
    public Object crlExpiry() {
        return crlExpiry;
    }

    /**
     * Gets the crlDisable.
     * <p>
     * Disables or enables certificate revocation list (CRL) building.
     * <p>
     * If CRL building is disabled, a signed but zero-length CRL is returned when downloading the CRL. If CRL building is
     * enabled,  it will rebuild the CRL.
     *
     * @return the crlDisable
     */
    public Boolean crlDisable() {
        return crlDisable;
    }

    /**
     * Gets the crlDistributionPointsEncoded.
     * <p>
     * Determines whether to encode the certificate revocation list (CRL) distribution points in the certificates that are
     * issued by this certificate authority.
     *
     * @return the crlDistributionPointsEncoded
     */
    public Boolean crlDistributionPointsEncoded() {
        return crlDistributionPointsEncoded;
    }

    /**
     * Gets the issuingCertificatesUrlsEncoded.
     * <p>
     * Determines whether to encode the URL of the issuing certificate in the certificates that are issued by this
     * certificate authority.
     *
     * @return the issuingCertificatesUrlsEncoded
     */
    public Boolean issuingCertificatesUrlsEncoded() {
        return issuingCertificatesUrlsEncoded;
    }

    /**
     * Gets the commonName.
     * <p>
     * The fully qualified domain name or host domain name for the certificate.
     *
     * @return the commonName
     */
    public String commonName() {
        return commonName;
    }

    /**
     * Gets the status.
     * <p>
     * The status of the certificate authority. The status of a root certificate authority is either `configured` or
     * `expired`. For intermediate certificate authorities, possible statuses include `signing_required`,
     * `signed_certificate_required`, `certificate_template_required`, `configured`, `expired` or `revoked`.
     *
     * @return the status
     */
    public String status() {
        return status;
    }

    /**
     * Gets the expirationDate.
     * <p>
     * The date that the certificate expires. The date format follows RFC 3339.
     *
     * @return the expirationDate
     */
    public Date expirationDate() {
        return expirationDate;
    }

    /**
     * Gets the altNames.
     * <p>
     * The Subject Alternative Names to define for the CA certificate, in a comma-delimited list.
     * <p>
     * The alternative names can be host names or email addresses.
     *
     * @return the altNames
     */
    public String altNames() {
        return altNames;
    }

    /**
     * Gets the ipSans.
     * <p>
     * The IP Subject Alternative Names to define for the CA certificate, in a comma-delimited list.
     *
     * @return the ipSans
     */
    public String ipSans() {
        return ipSans;
    }

    /**
     * Gets the uriSans.
     * <p>
     * The URI Subject Alternative Names to define for the CA certificate, in a comma-delimited list.
     *
     * @return the uriSans
     */
    public String uriSans() {
        return uriSans;
    }

    /**
     * Gets the otherSans.
     * <p>
     * The custom Object Identifier (OID) or UTF8-string Subject Alternative Names to define for the CA certificate.
     * <p>
     * The alternative names must match the values that are specified in the `allowed_other_sans` field in the associated
     * certificate template. The format is the same as OpenSSL: `&lt;oid&gt;:&lt;type&gt;:&lt;value&gt;` where the current
     * valid type is `UTF8`.
     *
     * @return the otherSans
     */
    public List<String> otherSans() {
        return otherSans;
    }

    /**
     * Gets the ttl.
     * <p>
     * The time-to-live (TTL) to assign to this CA certificate.
     * <p>
     * The value can be supplied as a string representation of a duration, such as `12h`. The value can be supplied in
     * seconds (suffix `s`), minutes (suffix `m`), hours (suffix `h`) or days (suffix `d`). The value can't exceed the
     * `max_ttl` that is defined in the associated certificate template. In the API response, this value is returned in
     * seconds (integer).
     *
     * @return the ttl
     */
    public Object ttl() {
        return ttl;
    }

    /**
     * Gets the format.
     * <p>
     * The format of the returned data.
     *
     * @return the format
     */
    public String format() {
        return format;
    }

    /**
     * Gets the privateKeyFormat.
     * <p>
     * The format of the generated private key.
     *
     * @return the privateKeyFormat
     */
    public String privateKeyFormat() {
        return privateKeyFormat;
    }

    /**
     * Gets the keyType.
     * <p>
     * The type of private key to generate.
     *
     * @return the keyType
     */
    public String keyType() {
        return keyType;
    }

    /**
     * Gets the keyBits.
     * <p>
     * The number of bits to use when generating the private key.
     * <p>
     * Allowable values for RSA keys are: `2048` and `4096`. Allowable values for EC keys are: `224`, `256`, `384`, and
     * `521`. The default for RSA keys is `2048`. The default for EC keys is `256`.
     *
     * @return the keyBits
     */
    public Long keyBits() {
        return keyBits;
    }

    /**
     * Gets the maxPathLength.
     * <p>
     * The maximum path length to encode in the generated certificate. `-1` means no limit.
     * <p>
     * If the signing certificate has a maximum path length set, the path length is set to one less than that of the
     * signing certificate. A limit of `0` means a literal path length of zero.
     *
     * @return the maxPathLength
     */
    public Long maxPathLength() {
        return maxPathLength;
    }

    /**
     * Gets the excludeCnFromSans.
     * <p>
     * Controls whether the common name is excluded from Subject Alternative Names (SANs).
     * <p>
     * If set to `true`, the common name is is not included in DNS or Email SANs if they apply. This field can be useful
     * if the common name is not a hostname or an email address, but is instead a human-readable identifier.
     *
     * @return the excludeCnFromSans
     */
    public Boolean excludeCnFromSans() {
        return excludeCnFromSans;
    }

    /**
     * Gets the permittedDnsDomains.
     * <p>
     * The allowed DNS domains or subdomains for the certificates to be signed and issued by this CA certificate.
     *
     * @return the permittedDnsDomains
     */
    public List<String> permittedDnsDomains() {
        return permittedDnsDomains;
    }

    /**
     * Gets the ou.
     * <p>
     * The Organizational Unit (OU) values to define in the subject field of the resulting certificate.
     *
     * @return the ou
     */
    public List<String> ou() {
        return ou;
    }

    /**
     * Gets the organization.
     * <p>
     * The Organization (O) values to define in the subject field of the resulting certificate.
     *
     * @return the organization
     */
    public List<String> organization() {
        return organization;
    }

    /**
     * Gets the country.
     * <p>
     * The Country (C) values to define in the subject field of the resulting certificate.
     *
     * @return the country
     */
    public List<String> country() {
        return country;
    }

    /**
     * Gets the locality.
     * <p>
     * The Locality (L) values to define in the subject field of the resulting certificate.
     *
     * @return the locality
     */
    public List<String> locality() {
        return locality;
    }

    /**
     * Gets the province.
     * <p>
     * The Province (ST) values to define in the subject field of the resulting certificate.
     *
     * @return the province
     */
    public List<String> province() {
        return province;
    }

    /**
     * Gets the streetAddress.
     * <p>
     * The Street Address values in the subject field of the resulting certificate.
     *
     * @return the streetAddress
     */
    public List<String> streetAddress() {
        return streetAddress;
    }

    /**
     * Gets the postalCode.
     * <p>
     * The Postal Code values in the subject field of the resulting certificate.
     *
     * @return the postalCode
     */
    public List<String> postalCode() {
        return postalCode;
    }

    /**
     * Gets the serialNumber.
     * <p>
     * The serial number to assign to the generated certificate. To assign a random serial number, you can omit this
     * field.
     *
     * @return the serialNumber
     */
    public String serialNumber() {
        return serialNumber;
    }

    /**
     * Gets the data.
     * <p>
     * The data that is associated with the root certificate authority. The data object contains the following fields:
     * <p>
     * - `certificate`: The root certificate content.
     * - `issuing_ca`: The certificate of the certificate authority that signed and issued this certificate.
     * - `serial_number`: The unique serial number of the root certificate.
     *
     * @return the data
     */
    public Map<String, Object> data() {
        return data;
    }

    /**
     * Gets the signingMethod.
     * <p>
     * The signing method to use with this certificate authority to generate private certificates.
     * <p>
     * You can choose between internal or externally signed options. For more information, see the
     * [docs](https://cloud.ibm.com/docs/secrets-manager?topic=secrets-manager-intermediate-certificate-authorities).
     *
     * @return the signingMethod
     */
    public String signingMethod() {
        return signingMethod;
    }

    /**
     * Gets the issuer.
     * <p>
     * The certificate authority that signed and issued the certificate.
     * <p>
     * If the certificate is signed internally, the `issuer` field is required and must match the name of a certificate
     * authority that is configured in the Secrets Manager service instance.
     *
     * @return the issuer
     */
    public String issuer() {
        return issuer;
    }

    /**
     * Gets the certificateAuthority.
     * <p>
     * The name of the intermediate certificate authority.
     *
     * @return the certificateAuthority
     */
    public String certificateAuthority() {
        return certificateAuthority;
    }

    /**
     * Gets the allowedSecretGroups.
     * <p>
     * Scopes the creation of private certificates to only the secret groups that you specify.
     * <p>
     * This field can be supplied as a comma-delimited list of secret group IDs.
     *
     * @return the allowedSecretGroups
     */
    public String allowedSecretGroups() {
        return allowedSecretGroups;
    }

    /**
     * Gets the allowLocalhost.
     * <p>
     * Determines whether to allow `localhost` to be included as one of the requested common names.
     *
     * @return the allowLocalhost
     */
    public Boolean allowLocalhost() {
        return allowLocalhost;
    }

    /**
     * Gets the allowedDomains.
     * <p>
     * The domains to define for the certificate template. This property is used along with the `allow_bare_domains` and
     * `allow_subdomains` options.
     *
     * @return the allowedDomains
     */
    public List<String> allowedDomains() {
        return allowedDomains;
    }

    /**
     * Gets the allowedDomainsTemplate.
     * <p>
     * Determines whether to allow the domains that are supplied in the `allowed_domains` field to contain access control
     * list (ACL) templates.
     *
     * @return the allowedDomainsTemplate
     */
    public Boolean allowedDomainsTemplate() {
        return allowedDomainsTemplate;
    }

    /**
     * Gets the allowBareDomains.
     * <p>
     * Determines whether to allow clients to request private certificates that match the value of the actual domains on
     * the final certificate.
     * <p>
     * For example, if you specify `example.com` in the `allowed_domains` field, you grant clients the ability to request
     * a certificate that contains the name `example.com` as one of the DNS values on the final certificate.
     * <p>
     * **Important:** In some scenarios, allowing bare domains can be considered a security risk.
     *
     * @return the allowBareDomains
     */
    public Boolean allowBareDomains() {
        return allowBareDomains;
    }

    /**
     * Gets the allowSubdomains.
     * <p>
     * Determines whether to allow clients to request private certificates with common names (CN) that are subdomains of
     * the CNs that are allowed by the other certificate template options. This includes wildcard subdomains.
     * <p>
     * For example, if `allowed_domains` has a value of `example.com` and `allow_subdomains`is set to `true`, then the
     * following subdomains are allowed: `foo.example.com`, `bar.example.com`, `*.example.com`.
     * <p>
     * **Note:** This field is redundant if you use the `allow_any_name` option.
     *
     * @return the allowSubdomains
     */
    public Boolean allowSubdomains() {
        return allowSubdomains;
    }

    /**
     * Gets the allowGlobDomains.
     * <p>
     * Determines whether to allow glob patterns, for example, `ftp*.example.com`, in the names that are specified in the
     * `allowed_domains` field.
     * <p>
     * If set to `true`, clients are allowed to request private certificates with names that match the glob patterns.
     *
     * @return the allowGlobDomains
     */
    public Boolean allowGlobDomains() {
        return allowGlobDomains;
    }

    /**
     * Gets the allowAnyName.
     * <p>
     * Determines whether to allow clients to request a private certificate that matches any common name.
     *
     * @return the allowAnyName
     */
    public Boolean allowAnyName() {
        return allowAnyName;
    }

    /**
     * Gets the enforceHostnames.
     * <p>
     * Determines whether to enforce only valid host names for common names, DNS Subject Alternative Names, and the host
     * section of email addresses.
     *
     * @return the enforceHostnames
     */
    public Boolean enforceHostnames() {
        return enforceHostnames;
    }

    /**
     * Gets the allowIpSans.
     * <p>
     * Determines whether to allow clients to request a private certificate with IP Subject Alternative Names.
     *
     * @return the allowIpSans
     */
    public Boolean allowIpSans() {
        return allowIpSans;
    }

    /**
     * Gets the allowedUriSans.
     * <p>
     * The URI Subject Alternative Names to allow for private certificates.
     * <p>
     * Values can contain glob patterns, for example `spiffe://hostname/_*`.
     *
     * @return the allowedUriSans
     */
    public List<String> allowedUriSans() {
        return allowedUriSans;
    }

    /**
     * Gets the allowedOtherSans.
     * <p>
     * The custom Object Identifier (OID) or UTF8-string Subject Alternative Names (SANs) to allow for private
     * certificates.
     * <p>
     * The format for each element in the list is the same as OpenSSL: `&lt;oid&gt;:&lt;type&gt;:&lt;value&gt;` where the
     * current valid type is `UTF8`. To allow any value for an OID, use `*` as its value. Alternatively, specify a single
     * `*` to allow any `other_sans` input.
     *
     * @return the allowedOtherSans
     */
    public List<String> allowedOtherSans() {
        return allowedOtherSans;
    }

    /**
     * Gets the serverFlag.
     * <p>
     * Determines whether private certificates are flagged for server use.
     *
     * @return the serverFlag
     */
    public Boolean serverFlag() {
        return serverFlag;
    }

    /**
     * Gets the clientFlag.
     * <p>
     * Determines whether private certificates are flagged for client use.
     *
     * @return the clientFlag
     */
    public Boolean clientFlag() {
        return clientFlag;
    }

    /**
     * Gets the codeSigningFlag.
     * <p>
     * Determines whether private certificates are flagged for code signing use.
     *
     * @return the codeSigningFlag
     */
    public Boolean codeSigningFlag() {
        return codeSigningFlag;
    }

    /**
     * Gets the emailProtectionFlag.
     * <p>
     * Determines whether private certificates are flagged for email protection use.
     *
     * @return the emailProtectionFlag
     */
    public Boolean emailProtectionFlag() {
        return emailProtectionFlag;
    }

    /**
     * Gets the keyUsage.
     * <p>
     * The allowed key usage constraint to define for private certificates.
     * <p>
     * You can find valid values in the [Go x509 package documentation](https://pkg.go.dev/crypto/x509#KeyUsage).  Omit
     * the `KeyUsage` part of the value. Values are not case-sensitive. To specify no key usage constraints, set this
     * field to an empty list.
     *
     * @return the keyUsage
     */
    public List<String> keyUsage() {
        return keyUsage;
    }

    /**
     * Gets the extKeyUsage.
     * <p>
     * The allowed extended key usage constraint on private certificates.
     * <p>
     * You can find valid values in the [Go x509 package documentation](https://golang.org/pkg/crypto/x509/#ExtKeyUsage).
     * Omit the `ExtKeyUsage` part of the value. Values are not case-sensitive. To specify no key usage constraints, set
     * this field to an empty list.
     *
     * @return the extKeyUsage
     */
    public List<String> extKeyUsage() {
        return extKeyUsage;
    }

    /**
     * Gets the extKeyUsageOids.
     * <p>
     * A list of extended key usage Object Identifiers (OIDs).
     *
     * @return the extKeyUsageOids
     */
    public List<String> extKeyUsageOids() {
        return extKeyUsageOids;
    }

    /**
     * Gets the useCsrCommonName.
     * <p>
     * When used with the `sign_csr` action, this field determines whether to use the common name (CN) from a certificate
     * signing request (CSR) instead of the CN that's included in the JSON data of the certificate.
     * <p>
     * Does not include any requested Subject Alternative Names (SANs) in the CSR. To use the alternative names, include
     * the `use_csr_sans` property.
     *
     * @return the useCsrCommonName
     */
    public Boolean useCsrCommonName() {
        return useCsrCommonName;
    }

    /**
     * Gets the useCsrSans.
     * <p>
     * When used with the `sign_csr` action, this field determines whether to use the Subject Alternative Names
     * (SANs) from a certificate signing request (CSR) instead of the SANs that are included in the JSON data of the
     * certificate.
     * <p>
     * Does not include the common name in the CSR. To use the common name, include the `use_csr_common_name` property.
     *
     * @return the useCsrSans
     */
    public Boolean useCsrSans() {
        return useCsrSans;
    }

    /**
     * Gets the requireCn.
     * <p>
     * Determines whether to require a common name to create a private certificate.
     * <p>
     * By default, a common name is required to generate a certificate. To make the `common_name` field optional, set the
     * `require_cn` option to `false`.
     *
     * @return the requireCn
     */
    public Boolean requireCn() {
        return requireCn;
    }

    /**
     * Gets the policyIdentifiers.
     * <p>
     * A list of policy Object Identifiers (OIDs).
     *
     * @return the policyIdentifiers
     */
    public List<String> policyIdentifiers() {
        return policyIdentifiers;
    }

    /**
     * Gets the basicConstraintsValidForNonCa.
     * <p>
     * Determines whether to mark the Basic Constraints extension of an issued private certificate as valid for non-CA
     * certificates.
     *
     * @return the basicConstraintsValidForNonCa
     */
    public Boolean basicConstraintsValidForNonCa() {
        return basicConstraintsValidForNonCa;
    }

    /**
     * Gets the notBeforeDuration.
     * <p>
     * The duration in seconds by which to backdate the `not_before` property of an issued private certificate.
     * <p>
     * The value can be supplied as a string representation of a duration, such as `30s`. In the API response, this value
     * is returned in seconds (integer).
     *
     * @return the notBeforeDuration
     */
    public Object notBeforeDuration() {
        return notBeforeDuration;
    }
}

