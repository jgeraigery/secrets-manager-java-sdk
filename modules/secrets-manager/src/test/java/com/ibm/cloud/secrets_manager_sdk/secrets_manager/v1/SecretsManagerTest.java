/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.SecretsManager;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ActionOnConfigElementOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ArbitrarySecretMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ArbitrarySecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ArbitrarySecretVersion;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ArbitrarySecretVersionInfo;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ArbitrarySecretVersionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateSecretData;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateSecretMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateSecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateSecretVersion;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateSecretVersionInfo;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateSecretVersionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateTemplateConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateTemplatesConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateTemplatesConfigItem;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CertificateValidity;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ChallengeResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CollectionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigAction;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementActionData;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementActionResult;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementActionResultConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementDef;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementDefConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementDefConfigClassicInfrastructureConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementDefConfigCloudInternetServicesConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementDefConfigLetsEncryptConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ConfigElementMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CreateConfigElementOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CreateIAMCredentialsSecretEngineRootConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CreateNotificationsRegistrationOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CreateSecret;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CreateSecretGroupOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.CreateSecretOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.DeleteConfigElementOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.DeleteCredentialsForIAMCredentialsSecret;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.DeleteNotificationsRegistrationOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.DeleteSecretGroupOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.DeleteSecretOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.EngineConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfigElementOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfigElements;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfigElementsOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfigElementsResourcesItem;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfigElementsResourcesItemCertificateAuthoritiesConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfigElementsResourcesItemDnsProvidersConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfigOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetConfigResourcesItem;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetInstanceLocks;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetLocksOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetNotificationsRegistrationOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetNotificationsSettings;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetPolicyOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecret;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretGroupOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretLocks;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretMetadataOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretPolicies;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretPolicyRotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretVersion;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretVersionLocksOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretVersionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretVersionMetadataOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSecretVersionOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.GetSingleConfigElement;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IAMCredentialsSecretEngineRootConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IAMCredentialsSecretMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IAMCredentialsSecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IAMCredentialsSecretVersion;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IAMCredentialsSecretVersionInfo;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IAMCredentialsSecretVersionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.InstanceSecretsLocks;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IntermediateCertificateAuthoritiesConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IntermediateCertificateAuthoritiesConfigItem;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IntermediateCertificateAuthorityConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.IssuanceInfo;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.KvSecretMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.KvSecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ListAllSecretsOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ListInstanceSecretsLocksOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ListSecretGroupsOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ListSecretLocks;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ListSecretVersions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ListSecretVersionsOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ListSecrets;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.ListSecretsOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.LockSecretBodyLocksItem;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.LockSecretOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.LockSecretVersionOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.NotificationsSettings;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PrivateCertPolicyRotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PrivateCertSecretEngineRootConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PrivateCertificateSecretMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PrivateCertificateSecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PrivateCertificateSecretVersion;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PrivateCertificateSecretVersionInfo;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PrivateCertificateSecretVersionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PublicCertSecretEngineRootConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PublicCertificateSecretMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PublicCertificateSecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PutConfigOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.PutPolicyOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RestoreIAMCredentialsSecretBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RevokeAction;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RevokeActionResult;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RootCertificateAuthoritiesConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RootCertificateAuthoritiesConfigItem;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RootCertificateAuthorityConfig;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotateArbitrarySecretBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotateCertificateBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotateCrlActionResult;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotateKvSecretBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotatePrivateCertBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotatePrivateCertBodyWithCsr;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotatePrivateCertBodyWithVersionCustomMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotatePublicCertBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.RotateUsernamePasswordSecretBody;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.Rotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretAction;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretGroupDef;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretGroupMetadataUpdatable;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretGroupResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretLockData;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretLockVersion;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretMetadataRequest;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretPolicyRotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretPolicyRotationRotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretPolicyRotationRotationPolicyRotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretPolicyRotationRotationPublicCertPolicyRotation;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretVersion;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretVersionInfo;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretVersionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SecretsLocks;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SendTestNotificationOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SetSignedAction;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SetSignedActionResult;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SignActionResultData;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SignCsrAction;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SignCsrActionResult;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SignIntermediateAction;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SignIntermediateActionResult;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.SignIntermediateActionResultData;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UnlockSecretOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UnlockSecretVersionOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UpdateConfigElementOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UpdateSecretGroupMetadataOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UpdateSecretMetadataOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UpdateSecretOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UpdateSecretVersionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UpdateSecretVersionMetadataOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UpdateSecretVersionOptions;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UsernamePasswordSecretMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UsernamePasswordSecretResource;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UsernamePasswordSecretVersion;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UsernamePasswordSecretVersionInfo;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.model.UsernamePasswordSecretVersionMetadata;
import com.ibm.cloud.secrets_manager_sdk.secrets_manager.v1.utils.TestUtilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SecretsManager service.
 */
public class SecretsManagerTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected SecretsManager secretsManagerService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new SecretsManager(serviceName, null);
  }

  // Test the createSecretGroup operation with a valid options model parameter
  @Test
  public void testCreateSecretGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"name\": \"my-secret-group\", \"description\": \"Extended description for this group.\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"last_update_date\": \"2018-05-12T23:20:50.520Z\", \"type\": \"application/vnd.ibm.secrets-manager.secret.group+json\"}]}";
    String createSecretGroupPath = "/api/v1/secret_groups";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.secrets-manager.secret.group+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the SecretGroupResource model
    SecretGroupResource secretGroupResourceModel = new SecretGroupResource.Builder()
      .name("my-secret-group")
      .description("Extended description for this group.")
      .add("foo", "testString")
      .build();

    // Construct an instance of the CreateSecretGroupOptions model
    CreateSecretGroupOptions createSecretGroupOptionsModel = new CreateSecretGroupOptions.Builder()
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(secretGroupResourceModel))
      .build();

    // Invoke createSecretGroup() with a valid options model and verify the result
    Response<SecretGroupDef> response = secretsManagerService.createSecretGroup(createSecretGroupOptionsModel).execute();
    assertNotNull(response);
    SecretGroupDef responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createSecretGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createSecretGroup operation with and without retries enabled
  @Test
  public void testCreateSecretGroupWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testCreateSecretGroupWOptions();

    secretsManagerService.disableRetries();
    testCreateSecretGroupWOptions();
  }

  // Test the createSecretGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSecretGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.createSecretGroup(null).execute();
  }

  // Test the listSecretGroups operation with a valid options model parameter
  @Test
  public void testListSecretGroupsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"name\": \"my-secret-group\", \"description\": \"Extended description for this group.\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"last_update_date\": \"2018-05-12T23:20:50.520Z\", \"type\": \"application/vnd.ibm.secrets-manager.secret.group+json\"}]}";
    String listSecretGroupsPath = "/api/v1/secret_groups";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListSecretGroupsOptions model
    ListSecretGroupsOptions listSecretGroupsOptionsModel = new ListSecretGroupsOptions();

    // Invoke listSecretGroups() with a valid options model and verify the result
    Response<SecretGroupDef> response = secretsManagerService.listSecretGroups(listSecretGroupsOptionsModel).execute();
    assertNotNull(response);
    SecretGroupDef responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listSecretGroupsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listSecretGroups operation with and without retries enabled
  @Test
  public void testListSecretGroupsWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testListSecretGroupsWOptions();

    secretsManagerService.disableRetries();
    testListSecretGroupsWOptions();
  }

  // Test the getSecretGroup operation with a valid options model parameter
  @Test
  public void testGetSecretGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"name\": \"my-secret-group\", \"description\": \"Extended description for this group.\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"last_update_date\": \"2018-05-12T23:20:50.520Z\", \"type\": \"application/vnd.ibm.secrets-manager.secret.group+json\"}]}";
    String getSecretGroupPath = "/api/v1/secret_groups/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSecretGroupOptions model
    GetSecretGroupOptions getSecretGroupOptionsModel = new GetSecretGroupOptions.Builder()
      .id("testString")
      .build();

    // Invoke getSecretGroup() with a valid options model and verify the result
    Response<SecretGroupDef> response = secretsManagerService.getSecretGroup(getSecretGroupOptionsModel).execute();
    assertNotNull(response);
    SecretGroupDef responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSecretGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSecretGroup operation with and without retries enabled
  @Test
  public void testGetSecretGroupWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetSecretGroupWOptions();

    secretsManagerService.disableRetries();
    testGetSecretGroupWOptions();
  }

  // Test the getSecretGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSecretGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getSecretGroup(null).execute();
  }

  // Test the updateSecretGroupMetadata operation with a valid options model parameter
  @Test
  public void testUpdateSecretGroupMetadataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"name\": \"my-secret-group\", \"description\": \"Extended description for this group.\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"last_update_date\": \"2018-05-12T23:20:50.520Z\", \"type\": \"application/vnd.ibm.secrets-manager.secret.group+json\"}]}";
    String updateSecretGroupMetadataPath = "/api/v1/secret_groups/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.secrets-manager.secret.group+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the SecretGroupMetadataUpdatable model
    SecretGroupMetadataUpdatable secretGroupMetadataUpdatableModel = new SecretGroupMetadataUpdatable.Builder()
      .name("updated-secret-group-name")
      .description("Updated description for this group.")
      .build();

    // Construct an instance of the UpdateSecretGroupMetadataOptions model
    UpdateSecretGroupMetadataOptions updateSecretGroupMetadataOptionsModel = new UpdateSecretGroupMetadataOptions.Builder()
      .id("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(secretGroupMetadataUpdatableModel))
      .build();

    // Invoke updateSecretGroupMetadata() with a valid options model and verify the result
    Response<SecretGroupDef> response = secretsManagerService.updateSecretGroupMetadata(updateSecretGroupMetadataOptionsModel).execute();
    assertNotNull(response);
    SecretGroupDef responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSecretGroupMetadataPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateSecretGroupMetadata operation with and without retries enabled
  @Test
  public void testUpdateSecretGroupMetadataWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testUpdateSecretGroupMetadataWOptions();

    secretsManagerService.disableRetries();
    testUpdateSecretGroupMetadataWOptions();
  }

  // Test the updateSecretGroupMetadata operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSecretGroupMetadataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.updateSecretGroupMetadata(null).execute();
  }

  // Test the deleteSecretGroup operation with a valid options model parameter
  @Test
  public void testDeleteSecretGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteSecretGroupPath = "/api/v1/secret_groups/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteSecretGroupOptions model
    DeleteSecretGroupOptions deleteSecretGroupOptionsModel = new DeleteSecretGroupOptions.Builder()
      .id("testString")
      .build();

    // Invoke deleteSecretGroup() with a valid options model and verify the result
    Response<Void> response = secretsManagerService.deleteSecretGroup(deleteSecretGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteSecretGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteSecretGroup operation with and without retries enabled
  @Test
  public void testDeleteSecretGroupWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testDeleteSecretGroupWOptions();

    secretsManagerService.disableRetries();
    testDeleteSecretGroupWOptions();
  }

  // Test the deleteSecretGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteSecretGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.deleteSecretGroup(null).execute();
  }

  // Test the createSecret operation with a valid options model parameter
  @Test
  public void testCreateSecretWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"secret_group_id\": \"secretGroupId\", \"labels\": [\"labels\"], \"state\": 0, \"state_description\": \"Active\", \"secret_type\": \"arbitrary\", \"crn\": \"crn:v1:bluemix:public:secrets-manager:<region>:a/<account-id>:<service-instance>:secret:<secret-id>\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"createdBy\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"versions_total\": 1, \"versions\": [{\"anyKey\": \"anyValue\"}], \"locks_total\": 1, \"custom_metadata\": {\"anyKey\": \"anyValue\"}, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}, \"expiration_date\": \"2030-04-01T09:30:00.000Z\", \"payload\": \"payload\", \"secret_data\": {\"anyKey\": \"anyValue\"}}]}";
    String createSecretPath = "/api/v1/secrets/arbitrary";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.secrets-manager.secret+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the ArbitrarySecretResource model
    ArbitrarySecretResource secretResourceModel = new ArbitrarySecretResource.Builder()
      .name("example-arbitrary-secret")
      .description("Extended description for this secret.")
      .secretGroupId("bc656587-8fda-4d05-9ad8-b1de1ec7e712")
      .labels(java.util.Arrays.asList("dev", "us-south"))
      .customMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .versionCustomMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .expirationDate(DateUtils.parseAsDateTime("2030-01-01T00:00:00Z"))
      .payload("secret-data")
      .build();

    // Construct an instance of the CreateSecretOptions model
    CreateSecretOptions createSecretOptionsModel = new CreateSecretOptions.Builder()
      .secretType("arbitrary")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(secretResourceModel))
      .build();

    // Invoke createSecret() with a valid options model and verify the result
    Response<CreateSecret> response = secretsManagerService.createSecret(createSecretOptionsModel).execute();
    assertNotNull(response);
    CreateSecret responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createSecretPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createSecret operation with and without retries enabled
  @Test
  public void testCreateSecretWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testCreateSecretWOptions();

    secretsManagerService.disableRetries();
    testCreateSecretWOptions();
  }

  // Test the createSecret operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateSecretNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.createSecret(null).execute();
  }

  // Test the listSecrets operation with a valid options model parameter
  @Test
  public void testListSecretsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"secret_group_id\": \"secretGroupId\", \"labels\": [\"labels\"], \"state\": 0, \"state_description\": \"Active\", \"secret_type\": \"arbitrary\", \"crn\": \"crn:v1:bluemix:public:secrets-manager:<region>:a/<account-id>:<service-instance>:secret:<secret-id>\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"createdBy\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"versions_total\": 1, \"versions\": [{\"anyKey\": \"anyValue\"}], \"locks_total\": 1, \"custom_metadata\": {\"anyKey\": \"anyValue\"}, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}, \"expiration_date\": \"2030-04-01T09:30:00.000Z\", \"payload\": \"payload\", \"secret_data\": {\"anyKey\": \"anyValue\"}}]}";
    String listSecretsPath = "/api/v1/secrets/arbitrary";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListSecretsOptions model
    ListSecretsOptions listSecretsOptionsModel = new ListSecretsOptions.Builder()
      .secretType("arbitrary")
      .limit(Long.valueOf("1"))
      .offset(Long.valueOf("0"))
      .build();

    // Invoke listSecrets() with a valid options model and verify the result
    Response<ListSecrets> response = secretsManagerService.listSecrets(listSecretsOptionsModel).execute();
    assertNotNull(response);
    ListSecrets responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listSecretsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
  }

  // Test the listSecrets operation with and without retries enabled
  @Test
  public void testListSecretsWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testListSecretsWOptions();

    secretsManagerService.disableRetries();
    testListSecretsWOptions();
  }

  // Test the listSecrets operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListSecretsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.listSecrets(null).execute();
  }

  // Test the listAllSecrets operation with a valid options model parameter
  @Test
  public void testListAllSecretsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"secret_group_id\": \"secretGroupId\", \"labels\": [\"labels\"], \"state\": 0, \"state_description\": \"Active\", \"secret_type\": \"arbitrary\", \"crn\": \"crn:v1:bluemix:public:secrets-manager:<region>:a/<account-id>:<service-instance>:secret:<secret-id>\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"createdBy\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"versions_total\": 1, \"versions\": [{\"anyKey\": \"anyValue\"}], \"locks_total\": 1, \"custom_metadata\": {\"anyKey\": \"anyValue\"}, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}, \"expiration_date\": \"2030-04-01T09:30:00.000Z\", \"payload\": \"payload\", \"secret_data\": {\"anyKey\": \"anyValue\"}}]}";
    String listAllSecretsPath = "/api/v1/secrets";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAllSecretsOptions model
    ListAllSecretsOptions listAllSecretsOptionsModel = new ListAllSecretsOptions.Builder()
      .limit(Long.valueOf("1"))
      .offset(Long.valueOf("0"))
      .search("testString")
      .sortBy("id")
      .groups(java.util.Arrays.asList("testString"))
      .build();

    // Invoke listAllSecrets() with a valid options model and verify the result
    Response<ListSecrets> response = secretsManagerService.listAllSecrets(listAllSecretsOptionsModel).execute();
    assertNotNull(response);
    ListSecrets responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAllSecretsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(query.get("search"), "testString");
    assertEquals(query.get("sort_by"), "id");
    assertEquals(query.get("groups"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
  }

  // Test the listAllSecrets operation with and without retries enabled
  @Test
  public void testListAllSecretsWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testListAllSecretsWOptions();

    secretsManagerService.disableRetries();
    testListAllSecretsWOptions();
  }

  // Test the getSecret operation with a valid options model parameter
  @Test
  public void testGetSecretWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"secret_group_id\": \"secretGroupId\", \"labels\": [\"labels\"], \"state\": 0, \"state_description\": \"Active\", \"secret_type\": \"arbitrary\", \"crn\": \"crn:v1:bluemix:public:secrets-manager:<region>:a/<account-id>:<service-instance>:secret:<secret-id>\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"createdBy\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"versions_total\": 1, \"versions\": [{\"anyKey\": \"anyValue\"}], \"locks_total\": 1, \"custom_metadata\": {\"anyKey\": \"anyValue\"}, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}, \"expiration_date\": \"2030-04-01T09:30:00.000Z\", \"payload\": \"payload\", \"secret_data\": {\"anyKey\": \"anyValue\"}}]}";
    String getSecretPath = "/api/v1/secrets/arbitrary/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSecretOptions model
    GetSecretOptions getSecretOptionsModel = new GetSecretOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .build();

    // Invoke getSecret() with a valid options model and verify the result
    Response<GetSecret> response = secretsManagerService.getSecret(getSecretOptionsModel).execute();
    assertNotNull(response);
    GetSecret responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSecretPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSecret operation with and without retries enabled
  @Test
  public void testGetSecretWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetSecretWOptions();

    secretsManagerService.disableRetries();
    testGetSecretWOptions();
  }

  // Test the getSecret operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSecretNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getSecret(null).execute();
  }

  // Test the updateSecret operation with a valid options model parameter
  @Test
  public void testUpdateSecretWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"secret_group_id\": \"secretGroupId\", \"labels\": [\"labels\"], \"state\": 0, \"state_description\": \"Active\", \"secret_type\": \"arbitrary\", \"crn\": \"crn:v1:bluemix:public:secrets-manager:<region>:a/<account-id>:<service-instance>:secret:<secret-id>\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"createdBy\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"versions_total\": 1, \"versions\": [{\"anyKey\": \"anyValue\"}], \"locks_total\": 1, \"custom_metadata\": {\"anyKey\": \"anyValue\"}, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}, \"expiration_date\": \"2030-04-01T09:30:00.000Z\", \"payload\": \"payload\", \"secret_data\": {\"anyKey\": \"anyValue\"}}]}";
    String updateSecretPath = "/api/v1/secrets/arbitrary/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the RotateArbitrarySecretBody model
    RotateArbitrarySecretBody secretActionModel = new RotateArbitrarySecretBody.Builder()
      .payload("testString")
      .customMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .versionCustomMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Construct an instance of the UpdateSecretOptions model
    UpdateSecretOptions updateSecretOptionsModel = new UpdateSecretOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .action("rotate")
      .secretAction(secretActionModel)
      .build();

    // Invoke updateSecret() with a valid options model and verify the result
    Response<GetSecret> response = secretsManagerService.updateSecret(updateSecretOptionsModel).execute();
    assertNotNull(response);
    GetSecret responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSecretPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("action"), "rotate");
  }

  // Test the updateSecret operation with and without retries enabled
  @Test
  public void testUpdateSecretWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testUpdateSecretWOptions();

    secretsManagerService.disableRetries();
    testUpdateSecretWOptions();
  }

  // Test the updateSecret operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSecretNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.updateSecret(null).execute();
  }

  // Test the deleteSecret operation with a valid options model parameter
  @Test
  public void testDeleteSecretWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteSecretPath = "/api/v1/secrets/arbitrary/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteSecretOptions model
    DeleteSecretOptions deleteSecretOptionsModel = new DeleteSecretOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .build();

    // Invoke deleteSecret() with a valid options model and verify the result
    Response<Void> response = secretsManagerService.deleteSecret(deleteSecretOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteSecretPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteSecret operation with and without retries enabled
  @Test
  public void testDeleteSecretWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testDeleteSecretWOptions();

    secretsManagerService.disableRetries();
    testDeleteSecretWOptions();
  }

  // Test the deleteSecret operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteSecretNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.deleteSecret(null).execute();
  }

  // Test the listSecretVersions operation with a valid options model parameter
  @Test
  public void testListSecretVersionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creation_date\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"payload_available\": true, \"downloaded\": true, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}}]}";
    String listSecretVersionsPath = "/api/v1/secrets/arbitrary/testString/versions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListSecretVersionsOptions model
    ListSecretVersionsOptions listSecretVersionsOptionsModel = new ListSecretVersionsOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .build();

    // Invoke listSecretVersions() with a valid options model and verify the result
    Response<ListSecretVersions> response = secretsManagerService.listSecretVersions(listSecretVersionsOptionsModel).execute();
    assertNotNull(response);
    ListSecretVersions responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listSecretVersionsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listSecretVersions operation with and without retries enabled
  @Test
  public void testListSecretVersionsWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testListSecretVersionsWOptions();

    secretsManagerService.disableRetries();
    testListSecretVersionsWOptions();
  }

  // Test the listSecretVersions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListSecretVersionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.listSecretVersions(null).execute();
  }

  // Test the getSecretVersion operation with a valid options model parameter
  @Test
  public void testGetSecretVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"version_id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creation_date\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"locks_total\": 1, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}, \"secret_data\": {\"anyKey\": \"anyValue\"}}]}";
    String getSecretVersionPath = "/api/v1/secrets/arbitrary/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSecretVersionOptions model
    GetSecretVersionOptions getSecretVersionOptionsModel = new GetSecretVersionOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .versionId("testString")
      .build();

    // Invoke getSecretVersion() with a valid options model and verify the result
    Response<GetSecretVersion> response = secretsManagerService.getSecretVersion(getSecretVersionOptionsModel).execute();
    assertNotNull(response);
    GetSecretVersion responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSecretVersionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSecretVersion operation with and without retries enabled
  @Test
  public void testGetSecretVersionWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetSecretVersionWOptions();

    secretsManagerService.disableRetries();
    testGetSecretVersionWOptions();
  }

  // Test the getSecretVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSecretVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getSecretVersion(null).execute();
  }

  // Test the updateSecretVersion operation with a valid options model parameter
  @Test
  public void testUpdateSecretVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"secret_group_id\": \"secretGroupId\", \"labels\": [\"labels\"], \"state\": 0, \"state_description\": \"Active\", \"secret_type\": \"arbitrary\", \"crn\": \"crn:v1:bluemix:public:secrets-manager:<region>:a/<account-id>:<service-instance>:secret:<secret-id>\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"createdBy\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"versions_total\": 1, \"versions\": [{\"anyKey\": \"anyValue\"}], \"locks_total\": 1, \"custom_metadata\": {\"anyKey\": \"anyValue\"}, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}, \"expiration_date\": \"2030-04-01T09:30:00.000Z\", \"payload\": \"payload\", \"secret_data\": {\"anyKey\": \"anyValue\"}}]}";
    String updateSecretVersionPath = "/api/v1/secrets/private_cert/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateSecretVersionOptions model
    UpdateSecretVersionOptions updateSecretVersionOptionsModel = new UpdateSecretVersionOptions.Builder()
      .secretType("private_cert")
      .id("testString")
      .versionId("testString")
      .action("revoke")
      .build();

    // Invoke updateSecretVersion() with a valid options model and verify the result
    Response<GetSecret> response = secretsManagerService.updateSecretVersion(updateSecretVersionOptionsModel).execute();
    assertNotNull(response);
    GetSecret responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSecretVersionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("action"), "revoke");
  }

  // Test the updateSecretVersion operation with and without retries enabled
  @Test
  public void testUpdateSecretVersionWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testUpdateSecretVersionWOptions();

    secretsManagerService.disableRetries();
    testUpdateSecretVersionWOptions();
  }

  // Test the updateSecretVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSecretVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.updateSecretVersion(null).execute();
  }

  // Test the getSecretVersionMetadata operation with a valid options model parameter
  @Test
  public void testGetSecretVersionMetadataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"version_id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creation_date\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"payload_available\": true, \"downloaded\": true, \"locks_total\": 1, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}}]}";
    String getSecretVersionMetadataPath = "/api/v1/secrets/arbitrary/testString/versions/testString/metadata";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSecretVersionMetadataOptions model
    GetSecretVersionMetadataOptions getSecretVersionMetadataOptionsModel = new GetSecretVersionMetadataOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .versionId("testString")
      .build();

    // Invoke getSecretVersionMetadata() with a valid options model and verify the result
    Response<GetSecretVersionMetadata> response = secretsManagerService.getSecretVersionMetadata(getSecretVersionMetadataOptionsModel).execute();
    assertNotNull(response);
    GetSecretVersionMetadata responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSecretVersionMetadataPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSecretVersionMetadata operation with and without retries enabled
  @Test
  public void testGetSecretVersionMetadataWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetSecretVersionMetadataWOptions();

    secretsManagerService.disableRetries();
    testGetSecretVersionMetadataWOptions();
  }

  // Test the getSecretVersionMetadata operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSecretVersionMetadataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getSecretVersionMetadata(null).execute();
  }

  // Test the updateSecretVersionMetadata operation with a valid options model parameter
  @Test
  public void testUpdateSecretVersionMetadataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"id\", \"version_id\": \"4a0225e9-17a0-46c1-ace7-f25bcf4237d4\", \"creation_date\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"payload_available\": true, \"downloaded\": true, \"locks_total\": 1, \"version_custom_metadata\": {\"anyKey\": \"anyValue\"}}]}";
    String updateSecretVersionMetadataPath = "/api/v1/secrets/arbitrary/testString/versions/testString/metadata";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.secrets-manager.secret+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the UpdateSecretVersionMetadata model
    UpdateSecretVersionMetadata updateSecretVersionMetadataModel = new UpdateSecretVersionMetadata.Builder()
      .versionCustomMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Construct an instance of the UpdateSecretVersionMetadataOptions model
    UpdateSecretVersionMetadataOptions updateSecretVersionMetadataOptionsModel = new UpdateSecretVersionMetadataOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .versionId("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(updateSecretVersionMetadataModel))
      .build();

    // Invoke updateSecretVersionMetadata() with a valid options model and verify the result
    Response<GetSecretVersionMetadata> response = secretsManagerService.updateSecretVersionMetadata(updateSecretVersionMetadataOptionsModel).execute();
    assertNotNull(response);
    GetSecretVersionMetadata responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSecretVersionMetadataPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateSecretVersionMetadata operation with and without retries enabled
  @Test
  public void testUpdateSecretVersionMetadataWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testUpdateSecretVersionMetadataWOptions();

    secretsManagerService.disableRetries();
    testUpdateSecretVersionMetadataWOptions();
  }

  // Test the updateSecretVersionMetadata operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSecretVersionMetadataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.updateSecretVersionMetadata(null).execute();
  }

  // Test the getSecretMetadata operation with a valid options model parameter
  @Test
  public void testGetSecretMetadataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"labels\": [\"labels\"], \"name\": \"example-secret\", \"description\": \"Extended description for this secret.\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"state\": 0, \"state_description\": \"Active\", \"secret_type\": \"arbitrary\", \"crn\": \"crn:v1:bluemix:public:secrets-manager:<region>:a/<account-id>:<service-instance>:secret:<secret-id>\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"ServiceId-cb258cb9-8de3-4ac0-9aec-b2b2d27ac976\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"versions_total\": 1, \"locks_total\": 1, \"custom_metadata\": {\"anyKey\": \"anyValue\"}, \"expiration_date\": \"2030-04-01T09:30:00.000Z\"}]}";
    String getSecretMetadataPath = "/api/v1/secrets/arbitrary/testString/metadata";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSecretMetadataOptions model
    GetSecretMetadataOptions getSecretMetadataOptionsModel = new GetSecretMetadataOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .build();

    // Invoke getSecretMetadata() with a valid options model and verify the result
    Response<SecretMetadataRequest> response = secretsManagerService.getSecretMetadata(getSecretMetadataOptionsModel).execute();
    assertNotNull(response);
    SecretMetadataRequest responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSecretMetadataPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getSecretMetadata operation with and without retries enabled
  @Test
  public void testGetSecretMetadataWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetSecretMetadataWOptions();

    secretsManagerService.disableRetries();
    testGetSecretMetadataWOptions();
  }

  // Test the getSecretMetadata operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSecretMetadataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getSecretMetadata(null).execute();
  }

  // Test the updateSecretMetadata operation with a valid options model parameter
  @Test
  public void testUpdateSecretMetadataWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"labels\": [\"labels\"], \"name\": \"example-secret\", \"description\": \"Extended description for this secret.\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"state\": 0, \"state_description\": \"Active\", \"secret_type\": \"arbitrary\", \"crn\": \"crn:v1:bluemix:public:secrets-manager:<region>:a/<account-id>:<service-instance>:secret:<secret-id>\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"ServiceId-cb258cb9-8de3-4ac0-9aec-b2b2d27ac976\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"versions_total\": 1, \"locks_total\": 1, \"custom_metadata\": {\"anyKey\": \"anyValue\"}, \"expiration_date\": \"2030-04-01T09:30:00.000Z\"}]}";
    String updateSecretMetadataPath = "/api/v1/secrets/arbitrary/testString/metadata";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.secrets-manager.secret+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the ArbitrarySecretMetadata model
    ArbitrarySecretMetadata secretMetadataModel = new ArbitrarySecretMetadata.Builder()
      .labels(java.util.Arrays.asList("dev", "us-south"))
      .name("updated-secret-name")
      .description("Updated description for this secret.")
      .customMetadata(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .expirationDate(DateUtils.parseAsDateTime("2030-04-01T09:30:00Z"))
      .build();

    // Construct an instance of the UpdateSecretMetadataOptions model
    UpdateSecretMetadataOptions updateSecretMetadataOptionsModel = new UpdateSecretMetadataOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(secretMetadataModel))
      .build();

    // Invoke updateSecretMetadata() with a valid options model and verify the result
    Response<SecretMetadataRequest> response = secretsManagerService.updateSecretMetadata(updateSecretMetadataOptionsModel).execute();
    assertNotNull(response);
    SecretMetadataRequest responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateSecretMetadataPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateSecretMetadata operation with and without retries enabled
  @Test
  public void testUpdateSecretMetadataWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testUpdateSecretMetadataWOptions();

    secretsManagerService.disableRetries();
    testUpdateSecretMetadataWOptions();
  }

  // Test the updateSecretMetadata operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSecretMetadataNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.updateSecretMetadata(null).execute();
  }

  // Test the getLocks operation with a valid options model parameter
  @Test
  public void testGetLocksWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"name\": \"name\", \"description\": \"description\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"createdBy\", \"attributes\": {\"anyKey\": \"anyValue\"}, \"secret_version_id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"secret_id\": \"secretId\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"secret_version_alias\": \"current\"}]}";
    String getLocksPath = "/api/v1/locks/arbitrary/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLocksOptions model
    GetLocksOptions getLocksOptionsModel = new GetLocksOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .limit(Long.valueOf("1"))
      .offset(Long.valueOf("0"))
      .search("testString")
      .build();

    // Invoke getLocks() with a valid options model and verify the result
    Response<ListSecretLocks> response = secretsManagerService.getLocks(getLocksOptionsModel).execute();
    assertNotNull(response);
    ListSecretLocks responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLocksPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(query.get("search"), "testString");
  }

  // Test the getLocks operation with and without retries enabled
  @Test
  public void testGetLocksWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetLocksWOptions();

    secretsManagerService.disableRetries();
    testGetLocksWOptions();
  }

  // Test the getLocks operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLocksNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getLocks(null).execute();
  }

  // Test the lockSecret operation with a valid options model parameter
  @Test
  public void testLockSecretWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"secret_id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"versions\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"alias\": \"current\", \"locks\": [\"locks\"], \"payload_available\": true}]}]}";
    String lockSecretPath = "/api/v1/locks/arbitrary/testString/lock";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the LockSecretBodyLocksItem model
    LockSecretBodyLocksItem lockSecretBodyLocksItemModel = new LockSecretBodyLocksItem.Builder()
      .name("lock-1")
      .description("lock for consumer-1")
      .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Construct an instance of the LockSecretOptions model
    LockSecretOptions lockSecretOptionsModel = new LockSecretOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .locks(java.util.Arrays.asList(lockSecretBodyLocksItemModel))
      .mode("exclusive")
      .build();

    // Invoke lockSecret() with a valid options model and verify the result
    Response<GetSecretLocks> response = secretsManagerService.lockSecret(lockSecretOptionsModel).execute();
    assertNotNull(response);
    GetSecretLocks responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, lockSecretPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("mode"), "exclusive");
  }

  // Test the lockSecret operation with and without retries enabled
  @Test
  public void testLockSecretWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testLockSecretWOptions();

    secretsManagerService.disableRetries();
    testLockSecretWOptions();
  }

  // Test the lockSecret operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLockSecretNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.lockSecret(null).execute();
  }

  // Test the unlockSecret operation with a valid options model parameter
  @Test
  public void testUnlockSecretWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"secret_id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"versions\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"alias\": \"current\", \"locks\": [\"locks\"], \"payload_available\": true}]}]}";
    String unlockSecretPath = "/api/v1/locks/arbitrary/testString/unlock";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UnlockSecretOptions model
    UnlockSecretOptions unlockSecretOptionsModel = new UnlockSecretOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .locks(java.util.Arrays.asList("testString"))
      .build();

    // Invoke unlockSecret() with a valid options model and verify the result
    Response<GetSecretLocks> response = secretsManagerService.unlockSecret(unlockSecretOptionsModel).execute();
    assertNotNull(response);
    GetSecretLocks responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unlockSecretPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the unlockSecret operation with and without retries enabled
  @Test
  public void testUnlockSecretWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testUnlockSecretWOptions();

    secretsManagerService.disableRetries();
    testUnlockSecretWOptions();
  }

  // Test the unlockSecret operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnlockSecretNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.unlockSecret(null).execute();
  }

  // Test the getSecretVersionLocks operation with a valid options model parameter
  @Test
  public void testGetSecretVersionLocksWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"name\": \"name\", \"description\": \"description\", \"creation_date\": \"2018-04-12T23:20:50.520Z\", \"created_by\": \"createdBy\", \"attributes\": {\"anyKey\": \"anyValue\"}, \"secret_version_id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"secret_id\": \"secretId\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"last_update_date\": \"2018-04-12T23:20:50.520Z\", \"secret_version_alias\": \"current\"}]}";
    String getSecretVersionLocksPath = "/api/v1/locks/arbitrary/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetSecretVersionLocksOptions model
    GetSecretVersionLocksOptions getSecretVersionLocksOptionsModel = new GetSecretVersionLocksOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .versionId("testString")
      .limit(Long.valueOf("1"))
      .offset(Long.valueOf("0"))
      .search("testString")
      .build();

    // Invoke getSecretVersionLocks() with a valid options model and verify the result
    Response<ListSecretLocks> response = secretsManagerService.getSecretVersionLocks(getSecretVersionLocksOptionsModel).execute();
    assertNotNull(response);
    ListSecretLocks responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSecretVersionLocksPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(query.get("search"), "testString");
  }

  // Test the getSecretVersionLocks operation with and without retries enabled
  @Test
  public void testGetSecretVersionLocksWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetSecretVersionLocksWOptions();

    secretsManagerService.disableRetries();
    testGetSecretVersionLocksWOptions();
  }

  // Test the getSecretVersionLocks operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSecretVersionLocksNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getSecretVersionLocks(null).execute();
  }

  // Test the lockSecretVersion operation with a valid options model parameter
  @Test
  public void testLockSecretVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"secret_id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"versions\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"alias\": \"current\", \"locks\": [\"locks\"], \"payload_available\": true}]}]}";
    String lockSecretVersionPath = "/api/v1/locks/arbitrary/testString/versions/testString/lock";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the LockSecretBodyLocksItem model
    LockSecretBodyLocksItem lockSecretBodyLocksItemModel = new LockSecretBodyLocksItem.Builder()
      .name("lock-1")
      .description("lock for consumer-1")
      .attributes(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Construct an instance of the LockSecretVersionOptions model
    LockSecretVersionOptions lockSecretVersionOptionsModel = new LockSecretVersionOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .versionId("testString")
      .locks(java.util.Arrays.asList(lockSecretBodyLocksItemModel))
      .mode("exclusive")
      .build();

    // Invoke lockSecretVersion() with a valid options model and verify the result
    Response<GetSecretLocks> response = secretsManagerService.lockSecretVersion(lockSecretVersionOptionsModel).execute();
    assertNotNull(response);
    GetSecretLocks responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, lockSecretVersionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("mode"), "exclusive");
  }

  // Test the lockSecretVersion operation with and without retries enabled
  @Test
  public void testLockSecretVersionWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testLockSecretVersionWOptions();

    secretsManagerService.disableRetries();
    testLockSecretVersionWOptions();
  }

  // Test the lockSecretVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLockSecretVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.lockSecretVersion(null).execute();
  }

  // Test the unlockSecretVersion operation with a valid options model parameter
  @Test
  public void testUnlockSecretVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"secret_id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"versions\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"alias\": \"current\", \"locks\": [\"locks\"], \"payload_available\": true}]}]}";
    String unlockSecretVersionPath = "/api/v1/locks/arbitrary/testString/versions/testString/unlock";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UnlockSecretVersionOptions model
    UnlockSecretVersionOptions unlockSecretVersionOptionsModel = new UnlockSecretVersionOptions.Builder()
      .secretType("arbitrary")
      .id("testString")
      .versionId("testString")
      .locks(java.util.Arrays.asList("testString"))
      .build();

    // Invoke unlockSecretVersion() with a valid options model and verify the result
    Response<GetSecretLocks> response = secretsManagerService.unlockSecretVersion(unlockSecretVersionOptionsModel).execute();
    assertNotNull(response);
    GetSecretLocks responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unlockSecretVersionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the unlockSecretVersion operation with and without retries enabled
  @Test
  public void testUnlockSecretVersionWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testUnlockSecretVersionWOptions();

    secretsManagerService.disableRetries();
    testUnlockSecretVersionWOptions();
  }

  // Test the unlockSecretVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnlockSecretVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.unlockSecretVersion(null).execute();
  }

  // Test the listInstanceSecretsLocks operation with a valid options model parameter
  @Test
  public void testListInstanceSecretsLocksWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"secret_id\": \"b0283d74-0894-830b-f81d-1f115f67729f\", \"secret_group_id\": \"f5283d74-9024-230a-b72c-1f115f61290f\", \"secret_type\": \"arbitrary\", \"versions\": [{\"id\": \"bc656587-8fda-4d05-9ad8-b1de1ec7e712\", \"alias\": \"current\", \"locks\": [\"locks\"], \"payload_available\": true}]}]}";
    String listInstanceSecretsLocksPath = "/api/v1/locks";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListInstanceSecretsLocksOptions model
    ListInstanceSecretsLocksOptions listInstanceSecretsLocksOptionsModel = new ListInstanceSecretsLocksOptions.Builder()
      .limit(Long.valueOf("1"))
      .offset(Long.valueOf("0"))
      .search("testString")
      .groups(java.util.Arrays.asList("testString"))
      .build();

    // Invoke listInstanceSecretsLocks() with a valid options model and verify the result
    Response<GetInstanceLocks> response = secretsManagerService.listInstanceSecretsLocks(listInstanceSecretsLocksOptionsModel).execute();
    assertNotNull(response);
    GetInstanceLocks responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listInstanceSecretsLocksPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(query.get("search"), "testString");
    assertEquals(query.get("groups"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
  }

  // Test the listInstanceSecretsLocks operation with and without retries enabled
  @Test
  public void testListInstanceSecretsLocksWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testListInstanceSecretsLocksWOptions();

    secretsManagerService.disableRetries();
    testListInstanceSecretsLocksWOptions();
  }

  // Test the putPolicy operation with a valid options model parameter
  @Test
  public void testPutPolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"anyKey\": \"anyValue\"}]}";
    String putPolicyPath = "/api/v1/secrets/username_password/testString/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CollectionMetadata model
    CollectionMetadata collectionMetadataModel = new CollectionMetadata.Builder()
      .collectionType("application/vnd.ibm.secrets-manager.config+json")
      .collectionTotal(Long.valueOf("1"))
      .build();

    // Construct an instance of the SecretPolicyRotationRotationPolicyRotation model
    SecretPolicyRotationRotationPolicyRotation secretPolicyRotationRotationModel = new SecretPolicyRotationRotationPolicyRotation.Builder()
      .interval(Long.valueOf("1"))
      .unit("day")
      .build();

    // Construct an instance of the SecretPolicyRotation model
    SecretPolicyRotation secretPolicyRotationModel = new SecretPolicyRotation.Builder()
      .type("application/vnd.ibm.secrets-manager.secret.policy+json")
      .rotation(secretPolicyRotationRotationModel)
      .build();

    // Construct an instance of the PutPolicyOptions model
    PutPolicyOptions putPolicyOptionsModel = new PutPolicyOptions.Builder()
      .secretType("username_password")
      .id("testString")
      .metadata(collectionMetadataModel)
      .resources(java.util.Arrays.asList(secretPolicyRotationModel))
      .policy("rotation")
      .build();

    // Invoke putPolicy() with a valid options model and verify the result
    Response<GetSecretPolicies> response = secretsManagerService.putPolicy(putPolicyOptionsModel).execute();
    assertNotNull(response);
    GetSecretPolicies responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putPolicyPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("policy"), "rotation");
  }

  // Test the putPolicy operation with and without retries enabled
  @Test
  public void testPutPolicyWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testPutPolicyWOptions();

    secretsManagerService.disableRetries();
    testPutPolicyWOptions();
  }

  // Test the putPolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutPolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.putPolicy(null).execute();
  }

  // Test the getPolicy operation with a valid options model parameter
  @Test
  public void testGetPolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"anyKey\": \"anyValue\"}]}";
    String getPolicyPath = "/api/v1/secrets/username_password/testString/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetPolicyOptions model
    GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
      .secretType("username_password")
      .id("testString")
      .policy("rotation")
      .build();

    // Invoke getPolicy() with a valid options model and verify the result
    Response<GetSecretPolicies> response = secretsManagerService.getPolicy(getPolicyOptionsModel).execute();
    assertNotNull(response);
    GetSecretPolicies responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPolicyPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("policy"), "rotation");
  }

  // Test the getPolicy operation with and without retries enabled
  @Test
  public void testGetPolicyWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetPolicyWOptions();

    secretsManagerService.disableRetries();
    testGetPolicyWOptions();
  }

  // Test the getPolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getPolicy(null).execute();
  }

  // Test the putConfig operation with a valid options model parameter
  @Test
  public void testPutConfigWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String putConfigPath = "/api/v1/config/iam_credentials";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateIAMCredentialsSecretEngineRootConfig model
    CreateIAMCredentialsSecretEngineRootConfig engineConfigModel = new CreateIAMCredentialsSecretEngineRootConfig.Builder()
      .apiKey("API_KEY")
      .build();

    // Construct an instance of the PutConfigOptions model
    PutConfigOptions putConfigOptionsModel = new PutConfigOptions.Builder()
      .secretType("iam_credentials")
      .engineConfig(engineConfigModel)
      .build();

    // Invoke putConfig() with a valid options model and verify the result
    Response<Void> response = secretsManagerService.putConfig(putConfigOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putConfigPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the putConfig operation with and without retries enabled
  @Test
  public void testPutConfigWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testPutConfigWOptions();

    secretsManagerService.disableRetries();
    testPutConfigWOptions();
  }

  // Test the putConfig operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutConfigNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.putConfig(null).execute();
  }

  // Test the getConfig operation with a valid options model parameter
  @Test
  public void testGetConfigWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"certificate_authorities\": [{\"name\": \"name\", \"type\": \"letsencrypt\"}], \"dns_providers\": [{\"name\": \"name\", \"type\": \"letsencrypt\"}]}]}";
    String getConfigPath = "/api/v1/config/iam_credentials";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetConfigOptions model
    GetConfigOptions getConfigOptionsModel = new GetConfigOptions.Builder()
      .secretType("iam_credentials")
      .build();

    // Invoke getConfig() with a valid options model and verify the result
    Response<GetConfig> response = secretsManagerService.getConfig(getConfigOptionsModel).execute();
    assertNotNull(response);
    GetConfig responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getConfigPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getConfig operation with and without retries enabled
  @Test
  public void testGetConfigWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetConfigWOptions();

    secretsManagerService.disableRetries();
    testGetConfigWOptions();
  }

  // Test the getConfig operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetConfigNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getConfig(null).execute();
  }

  // Test the createConfigElement operation with a valid options model parameter
  @Test
  public void testCreateConfigElementWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"name\": \"name\", \"type\": \"letsencrypt\", \"config\": {\"private_key\": \"privateKey\"}}]}";
    String createConfigElementPath = "/api/v1/config/public_cert/certificate_authorities";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ConfigElementDefConfigCloudInternetServicesConfig model
    ConfigElementDefConfigCloudInternetServicesConfig configElementDefConfigModel = new ConfigElementDefConfigCloudInternetServicesConfig.Builder()
      .cisCrn("crn:v1:bluemix:public:internet-svcs:global:a/<account-id>:<service-instance>::")
      .cisApikey("cis_apikey_value")
      .build();

    // Construct an instance of the CreateConfigElementOptions model
    CreateConfigElementOptions createConfigElementOptionsModel = new CreateConfigElementOptions.Builder()
      .secretType("public_cert")
      .configElement("certificate_authorities")
      .name("cis-example-config")
      .type("cis")
      .config(configElementDefConfigModel)
      .build();

    // Invoke createConfigElement() with a valid options model and verify the result
    Response<GetSingleConfigElement> response = secretsManagerService.createConfigElement(createConfigElementOptionsModel).execute();
    assertNotNull(response);
    GetSingleConfigElement responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createConfigElementPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createConfigElement operation with and without retries enabled
  @Test
  public void testCreateConfigElementWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testCreateConfigElementWOptions();

    secretsManagerService.disableRetries();
    testCreateConfigElementWOptions();
  }

  // Test the createConfigElement operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateConfigElementNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.createConfigElement(null).execute();
  }

  // Test the getConfigElements operation with a valid options model parameter
  @Test
  public void testGetConfigElementsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"certificate_authorities\": [{\"name\": \"name\", \"type\": \"letsencrypt\"}]}]}";
    String getConfigElementsPath = "/api/v1/config/public_cert/certificate_authorities";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetConfigElementsOptions model
    GetConfigElementsOptions getConfigElementsOptionsModel = new GetConfigElementsOptions.Builder()
      .secretType("public_cert")
      .configElement("certificate_authorities")
      .build();

    // Invoke getConfigElements() with a valid options model and verify the result
    Response<GetConfigElements> response = secretsManagerService.getConfigElements(getConfigElementsOptionsModel).execute();
    assertNotNull(response);
    GetConfigElements responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getConfigElementsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getConfigElements operation with and without retries enabled
  @Test
  public void testGetConfigElementsWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetConfigElementsWOptions();

    secretsManagerService.disableRetries();
    testGetConfigElementsWOptions();
  }

  // Test the getConfigElements operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetConfigElementsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getConfigElements(null).execute();
  }

  // Test the getConfigElement operation with a valid options model parameter
  @Test
  public void testGetConfigElementWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"name\": \"name\", \"type\": \"letsencrypt\", \"config\": {\"private_key\": \"privateKey\"}}]}";
    String getConfigElementPath = "/api/v1/config/public_cert/certificate_authorities/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetConfigElementOptions model
    GetConfigElementOptions getConfigElementOptionsModel = new GetConfigElementOptions.Builder()
      .secretType("public_cert")
      .configElement("certificate_authorities")
      .configName("testString")
      .build();

    // Invoke getConfigElement() with a valid options model and verify the result
    Response<GetSingleConfigElement> response = secretsManagerService.getConfigElement(getConfigElementOptionsModel).execute();
    assertNotNull(response);
    GetSingleConfigElement responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getConfigElementPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getConfigElement operation with and without retries enabled
  @Test
  public void testGetConfigElementWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetConfigElementWOptions();

    secretsManagerService.disableRetries();
    testGetConfigElementWOptions();
  }

  // Test the getConfigElement operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetConfigElementNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.getConfigElement(null).execute();
  }

  // Test the updateConfigElement operation with a valid options model parameter
  @Test
  public void testUpdateConfigElementWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"name\": \"name\", \"type\": \"letsencrypt\", \"config\": {\"private_key\": \"privateKey\"}}]}";
    String updateConfigElementPath = "/api/v1/config/public_cert/certificate_authorities/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateConfigElementOptions model
    UpdateConfigElementOptions updateConfigElementOptionsModel = new UpdateConfigElementOptions.Builder()
      .secretType("public_cert")
      .configElement("certificate_authorities")
      .configName("testString")
      .type("cis")
      .config(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .build();

    // Invoke updateConfigElement() with a valid options model and verify the result
    Response<GetSingleConfigElement> response = secretsManagerService.updateConfigElement(updateConfigElementOptionsModel).execute();
    assertNotNull(response);
    GetSingleConfigElement responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateConfigElementPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateConfigElement operation with and without retries enabled
  @Test
  public void testUpdateConfigElementWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testUpdateConfigElementWOptions();

    secretsManagerService.disableRetries();
    testUpdateConfigElementWOptions();
  }

  // Test the updateConfigElement operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateConfigElementNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.updateConfigElement(null).execute();
  }

  // Test the actionOnConfigElement operation with a valid options model parameter
  @Test
  public void testActionOnConfigElementWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"name\": \"name\", \"type\": \"letsencrypt\", \"config\": {\"common_name\": \"example.com\", \"alt_names\": \"altNames\", \"ip_sans\": \"ipSans\", \"uri_sans\": \"uriSans\", \"other_sans\": [\"otherSans\"], \"ttl\": \"anyValue\", \"format\": \"pem\", \"max_path_length\": 13, \"exclude_cn_from_sans\": false, \"permitted_dns_domains\": [\"permittedDnsDomains\"], \"use_csr_values\": false, \"ou\": [\"ou\"], \"organization\": [\"organization\"], \"country\": [\"country\"], \"locality\": [\"locality\"], \"province\": [\"province\"], \"street_address\": [\"streetAddress\"], \"postal_code\": [\"postalCode\"], \"serial_number\": \"d9:be:fe:35:ba:09:42:b5\", \"data\": {\"certificate\": \"certificate\", \"serial_number\": \"d9:be:fe:35:ba:09:42:b5\", \"issuing_ca\": \"issuingCa\", \"ca_chain\": [\"caChain\"], \"expiration\": 10}, \"csr\": \"csr\"}}]}";
    String actionOnConfigElementPath = "/api/v1/config/private_cert/root_certificate_authorities/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the SignCsrAction model
    SignCsrAction configActionModel = new SignCsrAction.Builder()
      .commonName("example.com")
      .altNames("testString")
      .ipSans("testString")
      .uriSans("testString")
      .otherSans(java.util.Arrays.asList("testString"))
      .ttl("12h")
      .format("pem")
      .maxPathLength(Long.valueOf("26"))
      .excludeCnFromSans(false)
      .permittedDnsDomains(java.util.Arrays.asList("testString"))
      .useCsrValues(false)
      .ou(java.util.Arrays.asList("testString"))
      .organization(java.util.Arrays.asList("testString"))
      .country(java.util.Arrays.asList("testString"))
      .locality(java.util.Arrays.asList("testString"))
      .province(java.util.Arrays.asList("testString"))
      .streetAddress(java.util.Arrays.asList("testString"))
      .postalCode(java.util.Arrays.asList("testString"))
      .serialNumber("d9:be:fe:35:ba:09:42:b5")
      .csr("testString")
      .build();

    // Construct an instance of the ActionOnConfigElementOptions model
    ActionOnConfigElementOptions actionOnConfigElementOptionsModel = new ActionOnConfigElementOptions.Builder()
      .secretType("private_cert")
      .configElement("root_certificate_authorities")
      .configName("testString")
      .action("sign_intermediate")
      .config(configActionModel)
      .build();

    // Invoke actionOnConfigElement() with a valid options model and verify the result
    Response<ConfigElementActionResult> response = secretsManagerService.actionOnConfigElement(actionOnConfigElementOptionsModel).execute();
    assertNotNull(response);
    ConfigElementActionResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, actionOnConfigElementPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("action"), "sign_intermediate");
  }

  // Test the actionOnConfigElement operation with and without retries enabled
  @Test
  public void testActionOnConfigElementWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testActionOnConfigElementWOptions();

    secretsManagerService.disableRetries();
    testActionOnConfigElementWOptions();
  }

  // Test the actionOnConfigElement operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testActionOnConfigElementNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.actionOnConfigElement(null).execute();
  }

  // Test the deleteConfigElement operation with a valid options model parameter
  @Test
  public void testDeleteConfigElementWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteConfigElementPath = "/api/v1/config/public_cert/certificate_authorities/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteConfigElementOptions model
    DeleteConfigElementOptions deleteConfigElementOptionsModel = new DeleteConfigElementOptions.Builder()
      .secretType("public_cert")
      .configElement("certificate_authorities")
      .configName("testString")
      .build();

    // Invoke deleteConfigElement() with a valid options model and verify the result
    Response<Void> response = secretsManagerService.deleteConfigElement(deleteConfigElementOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteConfigElementPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteConfigElement operation with and without retries enabled
  @Test
  public void testDeleteConfigElementWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testDeleteConfigElementWOptions();

    secretsManagerService.disableRetries();
    testDeleteConfigElementWOptions();
  }

  // Test the deleteConfigElement operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteConfigElementNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.deleteConfigElement(null).execute();
  }

  // Test the createNotificationsRegistration operation with a valid options model parameter
  @Test
  public void testCreateNotificationsRegistrationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"event_notifications_instance_crn\": \"crn:v1:bluemix:public:event-notifications:us-south:a/<account-id>:<service-instance>::\"}]}";
    String createNotificationsRegistrationPath = "/api/v1/notifications/registration";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateNotificationsRegistrationOptions model
    CreateNotificationsRegistrationOptions createNotificationsRegistrationOptionsModel = new CreateNotificationsRegistrationOptions.Builder()
      .eventNotificationsInstanceCrn("crn:v1:bluemix:public:event-notifications:us-south:a/<account-id>:<service-instance>::")
      .eventNotificationsSourceName("My Secrets Manager")
      .eventNotificationsSourceDescription("Optional description of this source in an Event Notifications instance.")
      .build();

    // Invoke createNotificationsRegistration() with a valid options model and verify the result
    Response<GetNotificationsSettings> response = secretsManagerService.createNotificationsRegistration(createNotificationsRegistrationOptionsModel).execute();
    assertNotNull(response);
    GetNotificationsSettings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createNotificationsRegistrationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createNotificationsRegistration operation with and without retries enabled
  @Test
  public void testCreateNotificationsRegistrationWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testCreateNotificationsRegistrationWOptions();

    secretsManagerService.disableRetries();
    testCreateNotificationsRegistrationWOptions();
  }

  // Test the createNotificationsRegistration operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateNotificationsRegistrationNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    secretsManagerService.createNotificationsRegistration(null).execute();
  }

  // Test the getNotificationsRegistration operation with a valid options model parameter
  @Test
  public void testGetNotificationsRegistrationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"metadata\": {\"collection_type\": \"application/vnd.ibm.secrets-manager.config+json\", \"collection_total\": 1}, \"resources\": [{\"event_notifications_instance_crn\": \"crn:v1:bluemix:public:event-notifications:us-south:a/<account-id>:<service-instance>::\"}]}";
    String getNotificationsRegistrationPath = "/api/v1/notifications/registration";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetNotificationsRegistrationOptions model
    GetNotificationsRegistrationOptions getNotificationsRegistrationOptionsModel = new GetNotificationsRegistrationOptions();

    // Invoke getNotificationsRegistration() with a valid options model and verify the result
    Response<GetNotificationsSettings> response = secretsManagerService.getNotificationsRegistration(getNotificationsRegistrationOptionsModel).execute();
    assertNotNull(response);
    GetNotificationsSettings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getNotificationsRegistrationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getNotificationsRegistration operation with and without retries enabled
  @Test
  public void testGetNotificationsRegistrationWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testGetNotificationsRegistrationWOptions();

    secretsManagerService.disableRetries();
    testGetNotificationsRegistrationWOptions();
  }

  // Test the deleteNotificationsRegistration operation with a valid options model parameter
  @Test
  public void testDeleteNotificationsRegistrationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteNotificationsRegistrationPath = "/api/v1/notifications/registration";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteNotificationsRegistrationOptions model
    DeleteNotificationsRegistrationOptions deleteNotificationsRegistrationOptionsModel = new DeleteNotificationsRegistrationOptions();

    // Invoke deleteNotificationsRegistration() with a valid options model and verify the result
    Response<Void> response = secretsManagerService.deleteNotificationsRegistration(deleteNotificationsRegistrationOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteNotificationsRegistrationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteNotificationsRegistration operation with and without retries enabled
  @Test
  public void testDeleteNotificationsRegistrationWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testDeleteNotificationsRegistrationWOptions();

    secretsManagerService.disableRetries();
    testDeleteNotificationsRegistrationWOptions();
  }

  // Test the sendTestNotification operation with a valid options model parameter
  @Test
  public void testSendTestNotificationWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String sendTestNotificationPath = "/api/v1/notifications/test";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the SendTestNotificationOptions model
    SendTestNotificationOptions sendTestNotificationOptionsModel = new SendTestNotificationOptions();

    // Invoke sendTestNotification() with a valid options model and verify the result
    Response<Void> response = secretsManagerService.sendTestNotification(sendTestNotificationOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, sendTestNotificationPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the sendTestNotification operation with and without retries enabled
  @Test
  public void testSendTestNotificationWRetries() throws Throwable {
    secretsManagerService.enableRetries(4, 30);
    testSendTestNotificationWOptions();

    secretsManagerService.disableRetries();
    testSendTestNotificationWOptions();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    secretsManagerService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    secretsManagerService = SecretsManager.newInstance(serviceName);
    String url = server.url("/").toString();
    secretsManagerService.setServiceUrl(url);
  }
}