# TelemetryApi

All URIs are relative to *http://localhost:8080/engine-rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**configureTelemetry**](TelemetryApi.md#configureTelemetry) | **POST** /telemetry/configuration | Configure Telemetry
[**getTelemetryConfiguration**](TelemetryApi.md#getTelemetryConfiguration) | **GET** /telemetry/configuration | Fetch Telemetry Configuration


<a name="configureTelemetry"></a>
# **configureTelemetry**
> configureTelemetry(telemetryConfigurationDto)

Configure Telemetry

Configures whether Camunda receives data collection of the process engine setup and usage.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.TelemetryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    TelemetryApi apiInstance = new TelemetryApi(defaultClient);
    TelemetryConfigurationDto telemetryConfigurationDto = {"enableTelemetry":true}; // TelemetryConfigurationDto | 
    try {
      apiInstance.configureTelemetry(telemetryConfigurationDto);
    } catch (ApiException e) {
      System.err.println("Exception when calling TelemetryApi#configureTelemetry");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **telemetryConfigurationDto** | [**TelemetryConfigurationDto**](TelemetryConfigurationDto.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Request successful. |  -  |
**401** | If the user who perform the operation is not a &lt;b&gt;camunda-admin&lt;/b&gt; user. |  -  |

<a name="getTelemetryConfiguration"></a>
# **getTelemetryConfiguration**
> TelemetryConfigurationDto getTelemetryConfiguration()

Fetch Telemetry Configuration

Fetches Telemetry Configuration.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.TelemetryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    TelemetryApi apiInstance = new TelemetryApi(defaultClient);
    try {
      TelemetryConfigurationDto result = apiInstance.getTelemetryConfiguration();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TelemetryApi#getTelemetryConfiguration");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**TelemetryConfigurationDto**](TelemetryConfigurationDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Request successful. |  -  |
**401** | If the user who perform the operation is not a &lt;b&gt;camunda-admin&lt;/b&gt; user. |  -  |

