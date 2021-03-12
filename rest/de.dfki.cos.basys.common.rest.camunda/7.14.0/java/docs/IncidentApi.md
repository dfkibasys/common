# IncidentApi

All URIs are relative to *http://localhost:8080/engine-rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getIncident**](IncidentApi.md#getIncident) | **GET** /incident/{id} | Get Incident
[**getIncidents**](IncidentApi.md#getIncidents) | **GET** /incident | Get List
[**getIncidentsCount**](IncidentApi.md#getIncidentsCount) | **GET** /incident/count | Get List Count
[**resolveIncident**](IncidentApi.md#resolveIncident) | **DELETE** /incident/{id} | Resolve Incident


<a name="getIncident"></a>
# **getIncident**
> IncidentDto getIncident(id)

Get Incident

Retrieves an incident by ID.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.IncidentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    IncidentApi apiInstance = new IncidentApi(defaultClient);
    String id = "id_example"; // String | The id of the incident to be retrieved.
    try {
      IncidentDto result = apiInstance.getIncident(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IncidentApi#getIncident");
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
 **id** | **String**| The id of the incident to be retrieved. |

### Return type

[**IncidentDto**](IncidentDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Request successful. |  -  |
**404** | Returned if an incident with given id does not exist. |  -  |

<a name="getIncidents"></a>
# **getIncidents**
> List&lt;IncidentDto&gt; getIncidents(incidentId, incidentType, incidentMessage, incidentMessageLike, processDefinitionId, processDefinitionKeyIn, processInstanceId, executionId, incidentTimestampBefore, incidentTimestampAfter, activityId, failedActivityId, causeIncidentId, rootCauseIncidentId, _configuration, tenantIdIn, jobDefinitionIdIn, sortBy, sortOrder)

Get List

Queries for incidents that fulfill given parameters. The size of the result set can be retrieved by using the [Get Incident Count](https://docs.camunda.org/manual/7.14/reference/rest/incident/get-query-count/) method.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.IncidentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    IncidentApi apiInstance = new IncidentApi(defaultClient);
    String incidentId = "incidentId_example"; // String | Restricts to incidents that have the given id.
    String incidentType = "incidentType_example"; // String | Restricts to incidents that belong to the given incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types.
    String incidentMessage = "incidentMessage_example"; // String | Restricts to incidents that have the given incident message.
    String incidentMessageLike = "incidentMessageLike_example"; // String | Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character '%' to express like-strategy: starts with (`string%`), ends with (`%string`) or contains (`%string%`).
    String processDefinitionId = "processDefinitionId_example"; // String | Restricts to incidents that belong to a process definition with the given id.
    String processDefinitionKeyIn = "processDefinitionKeyIn_example"; // String | Restricts to incidents that belong to a process definition with the given keys. Must be a comma-separated list.
    String processInstanceId = "processInstanceId_example"; // String | Restricts to incidents that belong to a process instance with the given id.
    String executionId = "executionId_example"; // String | Restricts to incidents that belong to an execution with the given id.
    OffsetDateTime incidentTimestampBefore = OffsetDateTime.now(); // OffsetDateTime | Restricts to incidents that have an incidentTimestamp date before the given date. By default, the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`.
    OffsetDateTime incidentTimestampAfter = OffsetDateTime.now(); // OffsetDateTime | Restricts to incidents that have an incidentTimestamp date after the given date. By default*, the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`.
    String activityId = "activityId_example"; // String | Restricts to incidents that belong to an activity with the given id.
    String failedActivityId = "failedActivityId_example"; // String | Restricts to incidents that were created due to the failure of an activity with the given id.
    String causeIncidentId = "causeIncidentId_example"; // String | Restricts to incidents that have the given incident id as cause incident.
    String rootCauseIncidentId = "rootCauseIncidentId_example"; // String | Restricts to incidents that have the given incident id as root cause incident.
    String _configuration = "_configuration_example"; // String | Restricts to incidents that have the given parameter set as configuration.
    String tenantIdIn = "tenantIdIn_example"; // String | Restricts to incidents that have one of the given comma-separated tenant ids.
    String jobDefinitionIdIn = "jobDefinitionIdIn_example"; // String | Restricts to incidents that have one of the given comma-separated job definition ids.
    String sortBy = "sortBy_example"; // String | Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter.
    String sortOrder = "sortOrder_example"; // String | Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter.
    try {
      List<IncidentDto> result = apiInstance.getIncidents(incidentId, incidentType, incidentMessage, incidentMessageLike, processDefinitionId, processDefinitionKeyIn, processInstanceId, executionId, incidentTimestampBefore, incidentTimestampAfter, activityId, failedActivityId, causeIncidentId, rootCauseIncidentId, _configuration, tenantIdIn, jobDefinitionIdIn, sortBy, sortOrder);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IncidentApi#getIncidents");
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
 **incidentId** | **String**| Restricts to incidents that have the given id. | [optional]
 **incidentType** | **String**| Restricts to incidents that belong to the given incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. | [optional]
 **incidentMessage** | **String**| Restricts to incidents that have the given incident message. | [optional]
 **incidentMessageLike** | **String**| Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character &#39;%&#39; to express like-strategy: starts with (&#x60;string%&#x60;), ends with (&#x60;%string&#x60;) or contains (&#x60;%string%&#x60;). | [optional]
 **processDefinitionId** | **String**| Restricts to incidents that belong to a process definition with the given id. | [optional]
 **processDefinitionKeyIn** | **String**| Restricts to incidents that belong to a process definition with the given keys. Must be a comma-separated list. | [optional]
 **processInstanceId** | **String**| Restricts to incidents that belong to a process instance with the given id. | [optional]
 **executionId** | **String**| Restricts to incidents that belong to an execution with the given id. | [optional]
 **incidentTimestampBefore** | **OffsetDateTime**| Restricts to incidents that have an incidentTimestamp date before the given date. By default, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. | [optional]
 **incidentTimestampAfter** | **OffsetDateTime**| Restricts to incidents that have an incidentTimestamp date after the given date. By default*, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. | [optional]
 **activityId** | **String**| Restricts to incidents that belong to an activity with the given id. | [optional]
 **failedActivityId** | **String**| Restricts to incidents that were created due to the failure of an activity with the given id. | [optional]
 **causeIncidentId** | **String**| Restricts to incidents that have the given incident id as cause incident. | [optional]
 **rootCauseIncidentId** | **String**| Restricts to incidents that have the given incident id as root cause incident. | [optional]
 **_configuration** | **String**| Restricts to incidents that have the given parameter set as configuration. | [optional]
 **tenantIdIn** | **String**| Restricts to incidents that have one of the given comma-separated tenant ids. | [optional]
 **jobDefinitionIdIn** | **String**| Restricts to incidents that have one of the given comma-separated job definition ids. | [optional]
 **sortBy** | **String**| Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. | [optional] [enum: incidentId, incidentMessage, incidentTimestamp, incidentType, executionId, activityId, processInstanceId, processDefinitionId, causeIncidentId, rootCauseIncidentId, configuration, tenantId]
 **sortOrder** | **String**| Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. | [optional] [enum: asc, desc]

### Return type

[**List&lt;IncidentDto&gt;**](IncidentDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Request successful. |  -  |
**400** | Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. |  -  |

<a name="getIncidentsCount"></a>
# **getIncidentsCount**
> List&lt;CountResultDto&gt; getIncidentsCount(incidentId, incidentType, incidentMessage, incidentMessageLike, processDefinitionId, processDefinitionKeyIn, processInstanceId, executionId, incidentTimestampBefore, incidentTimestampAfter, activityId, failedActivityId, causeIncidentId, rootCauseIncidentId, _configuration, tenantIdIn, jobDefinitionIdIn)

Get List Count

Queries for the number of incidents that fulfill given parameters. Takes the same parameters as the [Get Incidents](https://docs.camunda.org/manual/7.14/reference/rest/incident/get-query/) method.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.IncidentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    IncidentApi apiInstance = new IncidentApi(defaultClient);
    String incidentId = "incidentId_example"; // String | Restricts to incidents that have the given id.
    String incidentType = "incidentType_example"; // String | Restricts to incidents that belong to the given incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types.
    String incidentMessage = "incidentMessage_example"; // String | Restricts to incidents that have the given incident message.
    String incidentMessageLike = "incidentMessageLike_example"; // String | Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character '%' to express like-strategy: starts with (`string%`), ends with (`%string`) or contains (`%string%`).
    String processDefinitionId = "processDefinitionId_example"; // String | Restricts to incidents that belong to a process definition with the given id.
    String processDefinitionKeyIn = "processDefinitionKeyIn_example"; // String | Restricts to incidents that belong to a process definition with the given keys. Must be a comma-separated list.
    String processInstanceId = "processInstanceId_example"; // String | Restricts to incidents that belong to a process instance with the given id.
    String executionId = "executionId_example"; // String | Restricts to incidents that belong to an execution with the given id.
    OffsetDateTime incidentTimestampBefore = OffsetDateTime.now(); // OffsetDateTime | Restricts to incidents that have an incidentTimestamp date before the given date. By default, the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`.
    OffsetDateTime incidentTimestampAfter = OffsetDateTime.now(); // OffsetDateTime | Restricts to incidents that have an incidentTimestamp date after the given date. By default*, the date must have the format `yyyy-MM-dd'T'HH:mm:ss.SSSZ`, e.g., `2013-01-23T14:42:45.000+0200`.
    String activityId = "activityId_example"; // String | Restricts to incidents that belong to an activity with the given id.
    String failedActivityId = "failedActivityId_example"; // String | Restricts to incidents that were created due to the failure of an activity with the given id.
    String causeIncidentId = "causeIncidentId_example"; // String | Restricts to incidents that have the given incident id as cause incident.
    String rootCauseIncidentId = "rootCauseIncidentId_example"; // String | Restricts to incidents that have the given incident id as root cause incident.
    String _configuration = "_configuration_example"; // String | Restricts to incidents that have the given parameter set as configuration.
    String tenantIdIn = "tenantIdIn_example"; // String | Restricts to incidents that have one of the given comma-separated tenant ids.
    String jobDefinitionIdIn = "jobDefinitionIdIn_example"; // String | Restricts to incidents that have one of the given comma-separated job definition ids.
    try {
      List<CountResultDto> result = apiInstance.getIncidentsCount(incidentId, incidentType, incidentMessage, incidentMessageLike, processDefinitionId, processDefinitionKeyIn, processInstanceId, executionId, incidentTimestampBefore, incidentTimestampAfter, activityId, failedActivityId, causeIncidentId, rootCauseIncidentId, _configuration, tenantIdIn, jobDefinitionIdIn);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling IncidentApi#getIncidentsCount");
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
 **incidentId** | **String**| Restricts to incidents that have the given id. | [optional]
 **incidentType** | **String**| Restricts to incidents that belong to the given incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. | [optional]
 **incidentMessage** | **String**| Restricts to incidents that have the given incident message. | [optional]
 **incidentMessageLike** | **String**| Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character &#39;%&#39; to express like-strategy: starts with (&#x60;string%&#x60;), ends with (&#x60;%string&#x60;) or contains (&#x60;%string%&#x60;). | [optional]
 **processDefinitionId** | **String**| Restricts to incidents that belong to a process definition with the given id. | [optional]
 **processDefinitionKeyIn** | **String**| Restricts to incidents that belong to a process definition with the given keys. Must be a comma-separated list. | [optional]
 **processInstanceId** | **String**| Restricts to incidents that belong to a process instance with the given id. | [optional]
 **executionId** | **String**| Restricts to incidents that belong to an execution with the given id. | [optional]
 **incidentTimestampBefore** | **OffsetDateTime**| Restricts to incidents that have an incidentTimestamp date before the given date. By default, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. | [optional]
 **incidentTimestampAfter** | **OffsetDateTime**| Restricts to incidents that have an incidentTimestamp date after the given date. By default*, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. | [optional]
 **activityId** | **String**| Restricts to incidents that belong to an activity with the given id. | [optional]
 **failedActivityId** | **String**| Restricts to incidents that were created due to the failure of an activity with the given id. | [optional]
 **causeIncidentId** | **String**| Restricts to incidents that have the given incident id as cause incident. | [optional]
 **rootCauseIncidentId** | **String**| Restricts to incidents that have the given incident id as root cause incident. | [optional]
 **_configuration** | **String**| Restricts to incidents that have the given parameter set as configuration. | [optional]
 **tenantIdIn** | **String**| Restricts to incidents that have one of the given comma-separated tenant ids. | [optional]
 **jobDefinitionIdIn** | **String**| Restricts to incidents that have one of the given comma-separated job definition ids. | [optional]

### Return type

[**List&lt;CountResultDto&gt;**](CountResultDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Request successful. |  -  |
**400** | Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. |  -  |

<a name="resolveIncident"></a>
# **resolveIncident**
> resolveIncident(id)

Resolve Incident

Resolves an incident with given id.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.IncidentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    IncidentApi apiInstance = new IncidentApi(defaultClient);
    String id = "id_example"; // String | The id of the incident to be resolved.
    try {
      apiInstance.resolveIncident(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling IncidentApi#resolveIncident");
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
 **id** | **String**| The id of the incident to be resolved. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**204** | Request successful. |  -  |
**404** | Returned if an incident with given id does not exist. |  -  |
**400** | Returned if an incident is not related to any execution or an incident is of type &#x60;failedJob&#x60; or &#x60;failedExternalTask&#x60;. To resolve such an incident, please refer to the [Incident Types](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) section. |  -  |

