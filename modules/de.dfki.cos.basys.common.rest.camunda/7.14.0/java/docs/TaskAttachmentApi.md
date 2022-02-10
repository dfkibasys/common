# TaskAttachmentApi

All URIs are relative to *http://localhost:8080/engine-rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addAttachment**](TaskAttachmentApi.md#addAttachment) | **POST** /task/{id}/attachment/create | 
[**deleteAttachment**](TaskAttachmentApi.md#deleteAttachment) | **DELETE** /task/{id}/attachment/{attachmentId} | 
[**getAttachment**](TaskAttachmentApi.md#getAttachment) | **GET** /task/{id}/attachment/{attachmentId} | 
[**getAttachmentData**](TaskAttachmentApi.md#getAttachmentData) | **GET** /task/{id}/attachment/{attachmentId}/data | 
[**getAttachments**](TaskAttachmentApi.md#getAttachments) | **GET** /task/{id}/attachment | 


<a name="addAttachment"></a>
# **addAttachment**
> AttachmentDto addAttachment(id, attachmentName, attachmentDescription, attachmentType, url, content)



Creates an attachment for a task.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.TaskAttachmentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    TaskAttachmentApi apiInstance = new TaskAttachmentApi(defaultClient);
    String id = "id_example"; // String | The id of the task to add the attachment to.
    String attachmentName = "attachmentName_example"; // String | The name of the attachment.
    String attachmentDescription = "attachmentDescription_example"; // String | The description of the attachment.
    String attachmentType = "attachmentType_example"; // String | The type of the attachment.
    String url = "url_example"; // String | The url to the remote content of the attachment.
    File content = new File("/path/to/file"); // File | The content of the attachment.
    try {
      AttachmentDto result = apiInstance.addAttachment(id, attachmentName, attachmentDescription, attachmentType, url, content);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskAttachmentApi#addAttachment");
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
 **id** | **String**| The id of the task to add the attachment to. |
 **attachmentName** | **String**| The name of the attachment. | [optional]
 **attachmentDescription** | **String**| The description of the attachment. | [optional]
 **attachmentType** | **String**| The type of the attachment. | [optional]
 **url** | **String**| The url to the remote content of the attachment. | [optional]
 **content** | **File**| The content of the attachment. | [optional]

### Return type

[**AttachmentDto**](AttachmentDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Request successful. |  -  |
**400** | The task does not exists or task id is null. No content or url to remote content exists. See the [Introduction](/reference/rest/overview/#error-handling) for the error response format. |  -  |
**403** | The history of the engine is disabled. See the [Introduction](/reference/rest/overview/#error-handling) for the error response format. |  -  |

<a name="deleteAttachment"></a>
# **deleteAttachment**
> deleteAttachment(id, attachmentId)



Removes an attachment from a task by id.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.TaskAttachmentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    TaskAttachmentApi apiInstance = new TaskAttachmentApi(defaultClient);
    String id = "id_example"; // String | The id of the task.
    String attachmentId = "attachmentId_example"; // String | The id of the attachment to be removed.
    try {
      apiInstance.deleteAttachment(id, attachmentId);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskAttachmentApi#deleteAttachment");
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
 **id** | **String**| The id of the task. |
 **attachmentId** | **String**| The id of the attachment to be removed. |

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
**403** | The history of the engine is disabled. See the [Introduction](/reference/rest/overview/#error-handling) for the error response format. |  -  |
**404** | A Task Attachment for the given task id and attachment id does not exist. See the [Introduction](/reference/rest/overview/#error-handling) for the error response format. |  -  |

<a name="getAttachment"></a>
# **getAttachment**
> AttachmentDto getAttachment(id, attachmentId)



Retrieves a task attachment by task id and attachment id.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.TaskAttachmentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    TaskAttachmentApi apiInstance = new TaskAttachmentApi(defaultClient);
    String id = "id_example"; // String | The id of the task.
    String attachmentId = "attachmentId_example"; // String | The id of the attachment to be retrieved.
    try {
      AttachmentDto result = apiInstance.getAttachment(id, attachmentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskAttachmentApi#getAttachment");
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
 **id** | **String**| The id of the task. |
 **attachmentId** | **String**| The id of the attachment to be retrieved. |

### Return type

[**AttachmentDto**](AttachmentDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Request successful. |  -  |
**404** | The attachment for the given task and attachment id does not exist or the history of the engine is disabled.  See the [Introduction](/reference/rest/overview/#error-handling) for the error response format. |  -  |

<a name="getAttachmentData"></a>
# **getAttachmentData**
> File getAttachmentData(id, attachmentId)



Retrieves the binary content of a task attachment by task id and attachment id.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.TaskAttachmentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    TaskAttachmentApi apiInstance = new TaskAttachmentApi(defaultClient);
    String id = "id_example"; // String | The id of the task.
    String attachmentId = "attachmentId_example"; // String | The id of the attachment to be retrieved.
    try {
      File result = apiInstance.getAttachmentData(id, attachmentId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskAttachmentApi#getAttachmentData");
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
 **id** | **String**| The id of the task. |
 **attachmentId** | **String**| The id of the attachment to be retrieved. |

### Return type

[**File**](File.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/octet-stream, text/plain, application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Request successful. |  -  |
**404** | The attachment content for the given task id and attachment id does not exist, or the history of the engine is disabled.  See the [Introduction](/reference/rest/overview/#error-handling) for the error response format. |  -  |

<a name="getAttachments"></a>
# **getAttachments**
> List&lt;AttachmentDto&gt; getAttachments(id)



Gets the attachments for a task.

### Example
```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.models.*;
import de.dfki.cos.basys.common.rest.camunda.api.TaskAttachmentApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/engine-rest");

    TaskAttachmentApi apiInstance = new TaskAttachmentApi(defaultClient);
    String id = "id_example"; // String | The id of the task to retrieve the attachments for.
    try {
      List<AttachmentDto> result = apiInstance.getAttachments(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TaskAttachmentApi#getAttachments");
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
 **id** | **String**| The id of the task to retrieve the attachments for. |

### Return type

[**List&lt;AttachmentDto&gt;**](AttachmentDto.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | Request successful. |  -  |
**404** | No task exists for the given task id. See the [Introduction](/reference/rest/overview/#error-handling) for the error response format. |  -  |

