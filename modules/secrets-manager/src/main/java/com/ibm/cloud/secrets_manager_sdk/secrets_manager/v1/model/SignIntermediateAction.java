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

/**
 * A request to sign an intermediate certificate authority.
 */
public class SignIntermediateAction extends ConfigAction {

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
     * Builder.
     */
    public static class Builder {
        private String commonName;
        private String altNames;
        private String ipSans;
        private String uriSans;
        private List<String> otherSans;
        private Object ttl;
        private String format;
        private Long maxPathLength;
        private Boolean excludeCnFromSans;
        private List<String> permittedDnsDomains;
        private Boolean useCsrValues;
        private List<String> ou;
        private List<String> organization;
        private List<String> country;
        private List<String> locality;
        private List<String> province;
        private List<String> streetAddress;
        private List<String> postalCode;
        private String serialNumber;
        private String intermediateCertificateAuthority;

        /**
         * Instantiates a new Builder from an existing SignIntermediateAction instance.
         *
         * @param signIntermediateAction the instance to initialize the Builder with
         */
        public Builder(ConfigAction signIntermediateAction) {
            this.commonName = signIntermediateAction.commonName;
            this.altNames = signIntermediateAction.altNames;
            this.ipSans = signIntermediateAction.ipSans;
            this.uriSans = signIntermediateAction.uriSans;
            this.otherSans = signIntermediateAction.otherSans;
            this.ttl = signIntermediateAction.ttl;
            this.format = signIntermediateAction.format;
            this.maxPathLength = signIntermediateAction.maxPathLength;
            this.excludeCnFromSans = signIntermediateAction.excludeCnFromSans;
            this.permittedDnsDomains = signIntermediateAction.permittedDnsDomains;
            this.useCsrValues = signIntermediateAction.useCsrValues;
            this.ou = signIntermediateAction.ou;
            this.organization = signIntermediateAction.organization;
            this.country = signIntermediateAction.country;
            this.locality = signIntermediateAction.locality;
            this.province = signIntermediateAction.province;
            this.streetAddress = signIntermediateAction.streetAddress;
            this.postalCode = signIntermediateAction.postalCode;
            this.serialNumber = signIntermediateAction.serialNumber;
            this.intermediateCertificateAuthority = signIntermediateAction.intermediateCertificateAuthority;
        }

        /**
         * Instantiates a new builder.
         */
        public Builder() {
        }

        /**
         * Instantiates a new builder with required properties.
         *
         * @param intermediateCertificateAuthority the intermediateCertificateAuthority
         */
        public Builder(String intermediateCertificateAuthority) {
            this.intermediateCertificateAuthority = intermediateCertificateAuthority;
        }

        /**
         * Builds a SignIntermediateAction.
         *
         * @return the new SignIntermediateAction instance
         */
        public SignIntermediateAction build() {
            return new SignIntermediateAction(this);
        }

        /**
         * Adds an otherSans to otherSans.
         *
         * @param otherSans the new otherSans
         * @return the SignIntermediateAction builder
         */
        public Builder addOtherSans(String otherSans) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(otherSans,
                    "otherSans cannot be null");
            if (this.otherSans == null) {
                this.otherSans = new ArrayList<String>();
            }
            this.otherSans.add(otherSans);
            return this;
        }

        /**
         * Adds an permittedDnsDomains to permittedDnsDomains.
         *
         * @param permittedDnsDomains the new permittedDnsDomains
         * @return the SignIntermediateAction builder
         */
        public Builder addPermittedDnsDomains(String permittedDnsDomains) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(permittedDnsDomains,
                    "permittedDnsDomains cannot be null");
            if (this.permittedDnsDomains == null) {
                this.permittedDnsDomains = new ArrayList<String>();
            }
            this.permittedDnsDomains.add(permittedDnsDomains);
            return this;
        }

        /**
         * Adds an ou to ou.
         *
         * @param ou the new ou
         * @return the SignIntermediateAction builder
         */
        public Builder addOu(String ou) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(ou,
                    "ou cannot be null");
            if (this.ou == null) {
                this.ou = new ArrayList<String>();
            }
            this.ou.add(ou);
            return this;
        }

        /**
         * Adds an organization to organization.
         *
         * @param organization the new organization
         * @return the SignIntermediateAction builder
         */
        public Builder addOrganization(String organization) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(organization,
                    "organization cannot be null");
            if (this.organization == null) {
                this.organization = new ArrayList<String>();
            }
            this.organization.add(organization);
            return this;
        }

        /**
         * Adds an country to country.
         *
         * @param country the new country
         * @return the SignIntermediateAction builder
         */
        public Builder addCountry(String country) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(country,
                    "country cannot be null");
            if (this.country == null) {
                this.country = new ArrayList<String>();
            }
            this.country.add(country);
            return this;
        }

        /**
         * Adds an locality to locality.
         *
         * @param locality the new locality
         * @return the SignIntermediateAction builder
         */
        public Builder addLocality(String locality) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(locality,
                    "locality cannot be null");
            if (this.locality == null) {
                this.locality = new ArrayList<String>();
            }
            this.locality.add(locality);
            return this;
        }

        /**
         * Adds an province to province.
         *
         * @param province the new province
         * @return the SignIntermediateAction builder
         */
        public Builder addProvince(String province) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(province,
                    "province cannot be null");
            if (this.province == null) {
                this.province = new ArrayList<String>();
            }
            this.province.add(province);
            return this;
        }

        /**
         * Adds an streetAddress to streetAddress.
         *
         * @param streetAddress the new streetAddress
         * @return the SignIntermediateAction builder
         */
        public Builder addStreetAddress(String streetAddress) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(streetAddress,
                    "streetAddress cannot be null");
            if (this.streetAddress == null) {
                this.streetAddress = new ArrayList<String>();
            }
            this.streetAddress.add(streetAddress);
            return this;
        }

        /**
         * Adds an postalCode to postalCode.
         *
         * @param postalCode the new postalCode
         * @return the SignIntermediateAction builder
         */
        public Builder addPostalCode(String postalCode) {
            com.ibm.cloud.sdk.core.util.Validator.notNull(postalCode,
                    "postalCode cannot be null");
            if (this.postalCode == null) {
                this.postalCode = new ArrayList<String>();
            }
            this.postalCode.add(postalCode);
            return this;
        }

        /**
         * Set the commonName.
         *
         * @param commonName the commonName
         * @return the SignIntermediateAction builder
         */
        public Builder commonName(String commonName) {
            this.commonName = commonName;
            return this;
        }

        /**
         * Set the altNames.
         *
         * @param altNames the altNames
         * @return the SignIntermediateAction builder
         */
        public Builder altNames(String altNames) {
            this.altNames = altNames;
            return this;
        }

        /**
         * Set the ipSans.
         *
         * @param ipSans the ipSans
         * @return the SignIntermediateAction builder
         */
        public Builder ipSans(String ipSans) {
            this.ipSans = ipSans;
            return this;
        }

        /**
         * Set the uriSans.
         *
         * @param uriSans the uriSans
         * @return the SignIntermediateAction builder
         */
        public Builder uriSans(String uriSans) {
            this.uriSans = uriSans;
            return this;
        }

        /**
         * Set the otherSans.
         * Existing otherSans will be replaced.
         *
         * @param otherSans the otherSans
         * @return the SignIntermediateAction builder
         */
        public Builder otherSans(List<String> otherSans) {
            this.otherSans = otherSans;
            return this;
        }

        /**
         * Set the ttl.
         *
         * @param ttl the ttl
         * @return the SignIntermediateAction builder
         */
        public Builder ttl(Object ttl) {
            this.ttl = ttl;
            return this;
        }

        /**
         * Set the format.
         *
         * @param format the format
         * @return the SignIntermediateAction builder
         */
        public Builder format(String format) {
            this.format = format;
            return this;
        }

        /**
         * Set the maxPathLength.
         *
         * @param maxPathLength the maxPathLength
         * @return the SignIntermediateAction builder
         */
        public Builder maxPathLength(long maxPathLength) {
            this.maxPathLength = maxPathLength;
            return this;
        }

        /**
         * Set the excludeCnFromSans.
         *
         * @param excludeCnFromSans the excludeCnFromSans
         * @return the SignIntermediateAction builder
         */
        public Builder excludeCnFromSans(Boolean excludeCnFromSans) {
            this.excludeCnFromSans = excludeCnFromSans;
            return this;
        }

        /**
         * Set the permittedDnsDomains.
         * Existing permittedDnsDomains will be replaced.
         *
         * @param permittedDnsDomains the permittedDnsDomains
         * @return the SignIntermediateAction builder
         */
        public Builder permittedDnsDomains(List<String> permittedDnsDomains) {
            this.permittedDnsDomains = permittedDnsDomains;
            return this;
        }

        /**
         * Set the useCsrValues.
         *
         * @param useCsrValues the useCsrValues
         * @return the SignIntermediateAction builder
         */
        public Builder useCsrValues(Boolean useCsrValues) {
            this.useCsrValues = useCsrValues;
            return this;
        }

        /**
         * Set the ou.
         * Existing ou will be replaced.
         *
         * @param ou the ou
         * @return the SignIntermediateAction builder
         */
        public Builder ou(List<String> ou) {
            this.ou = ou;
            return this;
        }

        /**
         * Set the organization.
         * Existing organization will be replaced.
         *
         * @param organization the organization
         * @return the SignIntermediateAction builder
         */
        public Builder organization(List<String> organization) {
            this.organization = organization;
            return this;
        }

        /**
         * Set the country.
         * Existing country will be replaced.
         *
         * @param country the country
         * @return the SignIntermediateAction builder
         */
        public Builder country(List<String> country) {
            this.country = country;
            return this;
        }

        /**
         * Set the locality.
         * Existing locality will be replaced.
         *
         * @param locality the locality
         * @return the SignIntermediateAction builder
         */
        public Builder locality(List<String> locality) {
            this.locality = locality;
            return this;
        }

        /**
         * Set the province.
         * Existing province will be replaced.
         *
         * @param province the province
         * @return the SignIntermediateAction builder
         */
        public Builder province(List<String> province) {
            this.province = province;
            return this;
        }

        /**
         * Set the streetAddress.
         * Existing streetAddress will be replaced.
         *
         * @param streetAddress the streetAddress
         * @return the SignIntermediateAction builder
         */
        public Builder streetAddress(List<String> streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        /**
         * Set the postalCode.
         * Existing postalCode will be replaced.
         *
         * @param postalCode the postalCode
         * @return the SignIntermediateAction builder
         */
        public Builder postalCode(List<String> postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        /**
         * Set the serialNumber.
         *
         * @param serialNumber the serialNumber
         * @return the SignIntermediateAction builder
         */
        public Builder serialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
            return this;
        }

        /**
         * Set the intermediateCertificateAuthority.
         *
         * @param intermediateCertificateAuthority the intermediateCertificateAuthority
         * @return the SignIntermediateAction builder
         */
        public Builder intermediateCertificateAuthority(String intermediateCertificateAuthority) {
            this.intermediateCertificateAuthority = intermediateCertificateAuthority;
            return this;
        }
    }

    protected SignIntermediateAction() {
    }

    protected SignIntermediateAction(Builder builder) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(builder.intermediateCertificateAuthority,
                "intermediateCertificateAuthority cannot be null");
        commonName = builder.commonName;
        altNames = builder.altNames;
        ipSans = builder.ipSans;
        uriSans = builder.uriSans;
        otherSans = builder.otherSans;
        ttl = builder.ttl;
        format = builder.format;
        maxPathLength = builder.maxPathLength;
        excludeCnFromSans = builder.excludeCnFromSans;
        permittedDnsDomains = builder.permittedDnsDomains;
        useCsrValues = builder.useCsrValues;
        ou = builder.ou;
        organization = builder.organization;
        country = builder.country;
        locality = builder.locality;
        province = builder.province;
        streetAddress = builder.streetAddress;
        postalCode = builder.postalCode;
        serialNumber = builder.serialNumber;
        intermediateCertificateAuthority = builder.intermediateCertificateAuthority;
    }

    /**
     * New builder.
     *
     * @return a SignIntermediateAction builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }
}

