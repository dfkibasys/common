# EngineApi

All URIs are relative to *http://localhost:8080/engine-rest*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProcessEngineNames**](EngineApi.md#getProcessEngineNames) | **GET** /engine | 



## getProcessEngineNames

> List&lt;ProcessEngineDto&gt; getProcessEngineNames()



Retrieves the names of all process engines available on your platform.
**Note**: You cannot prepend `/engine/{name}` to this method.

### Example

```java
// Import classes:
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.model.*;
import de.dfki.cos.basys.common.rest.camunda.api.EngineApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080/engine-rest");

        EngineApi apiInstance = new EngineApi(defaultClient);
        try {
            List<ProcessEngineDto> result = apiInstance.getProcessEngineNames();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling EngineApi#getProcessEngineNames");
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

[**List&lt;ProcessEngineDto&gt;**](ProcessEngineDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Request successful. |  -  |

