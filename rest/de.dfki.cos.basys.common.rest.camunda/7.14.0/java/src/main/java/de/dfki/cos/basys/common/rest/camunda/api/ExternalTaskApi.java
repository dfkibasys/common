package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.BatchDto;
import de.dfki.cos.basys.common.rest.camunda.dto.CompleteExternalTaskDto;
import de.dfki.cos.basys.common.rest.camunda.dto.CountResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExtendLockOnExternalTaskDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExternalTaskBpmnError;
import de.dfki.cos.basys.common.rest.camunda.dto.ExternalTaskDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExternalTaskFailureDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExternalTaskQueryDto;
import de.dfki.cos.basys.common.rest.camunda.dto.FetchExternalTasksDto;
import de.dfki.cos.basys.common.rest.camunda.dto.LockedExternalTaskDto;
import org.threeten.bp.OffsetDateTime;
import de.dfki.cos.basys.common.rest.camunda.dto.PriorityDto;
import de.dfki.cos.basys.common.rest.camunda.dto.RetriesDto;
import de.dfki.cos.basys.common.rest.camunda.dto.SetRetriesForExternalTasksDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class ExternalTaskApi {
  private ApiClient apiClient;

  public ExternalTaskApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ExternalTaskApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Get the API cilent
   *
   * @return API client
   */
  public ApiClient getApiClient() {
    return apiClient;
  }

  /**
   * Set the API cilent
   *
   * @param apiClient an instance of API client
   */
  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * 
   * Completes an external task by id and updates process variables.
   * @param id The id of the task to complete. (required)
   * @param completeExternalTaskDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if the task&#39;s most recent lock was not acquired by the provided worker. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Returned if the corresponding process instance could not be resumed successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void completeExternalTaskResource(String id, CompleteExternalTaskDto completeExternalTaskDto) throws ApiException {
    completeExternalTaskResourceWithHttpInfo(id, completeExternalTaskDto);
  }

  /**
   * 
   * Completes an external task by id and updates process variables.
   * @param id The id of the task to complete. (required)
   * @param completeExternalTaskDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if the task&#39;s most recent lock was not acquired by the provided worker. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Returned if the corresponding process instance could not be resumed successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> completeExternalTaskResourceWithHttpInfo(String id, CompleteExternalTaskDto completeExternalTaskDto) throws ApiException {
    Object localVarPostBody = completeExternalTaskDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling completeExternalTaskResource");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}/complete"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ExternalTaskApi.completeExternalTaskResource", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Extends the timeout of the lock by a given amount of time.
   * @param id The id of the external task. (required)
   * @param extendLockOnExternalTaskDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> In case the new lock duration is negative or the external task is not locked by the given worker or not  locked at all, an exception of type &#x60;InvalidRequestException&#x60; is returned. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void extendLock(String id, ExtendLockOnExternalTaskDto extendLockOnExternalTaskDto) throws ApiException {
    extendLockWithHttpInfo(id, extendLockOnExternalTaskDto);
  }

  /**
   * 
   * Extends the timeout of the lock by a given amount of time.
   * @param id The id of the external task. (required)
   * @param extendLockOnExternalTaskDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> In case the new lock duration is negative or the external task is not locked by the given worker or not  locked at all, an exception of type &#x60;InvalidRequestException&#x60; is returned. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> extendLockWithHttpInfo(String id, ExtendLockOnExternalTaskDto extendLockOnExternalTaskDto) throws ApiException {
    Object localVarPostBody = extendLockOnExternalTaskDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling extendLock");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}/extendLock"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ExternalTaskApi.extendLock", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Fetches and locks a specific number of external tasks for execution by a worker. Query can be restricted to specific task topics and for each task topic an individual lock time can be provided.
   * @param fetchExternalTasksDto  (optional)
   * @return List&lt;LockedExternalTaskDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<LockedExternalTaskDto> fetchAndLock(FetchExternalTasksDto fetchExternalTasksDto) throws ApiException {
    return fetchAndLockWithHttpInfo(fetchExternalTasksDto).getData();
  }

  /**
   * 
   * Fetches and locks a specific number of external tasks for execution by a worker. Query can be restricted to specific task topics and for each task topic an individual lock time can be provided.
   * @param fetchExternalTasksDto  (optional)
   * @return ApiResponse&lt;List&lt;LockedExternalTaskDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<LockedExternalTaskDto>> fetchAndLockWithHttpInfo(FetchExternalTasksDto fetchExternalTasksDto) throws ApiException {
    Object localVarPostBody = fetchExternalTasksDto;
    
    // create path and map variables
    String localVarPath = "/external-task/fetchAndLock";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<LockedExternalTaskDto>> localVarReturnType = new GenericType<List<LockedExternalTaskDto>>() {};

    return apiClient.invokeAPI("ExternalTaskApi.fetchAndLock", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves an external task by id, corresponding to the &#x60;ExternalTask&#x60; interface in the engine.
   * @param id The id of the external task to be retrieved. (required)
   * @return ExternalTaskDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> External task with the given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ExternalTaskDto getExternalTask(String id) throws ApiException {
    return getExternalTaskWithHttpInfo(id).getData();
  }

  /**
   * 
   * Retrieves an external task by id, corresponding to the &#x60;ExternalTask&#x60; interface in the engine.
   * @param id The id of the external task to be retrieved. (required)
   * @return ApiResponse&lt;ExternalTaskDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> External task with the given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ExternalTaskDto> getExternalTaskWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getExternalTask");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<ExternalTaskDto> localVarReturnType = new GenericType<ExternalTaskDto>() {};

    return apiClient.invokeAPI("ExternalTaskApi.getExternalTask", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves the error details in the context of a running external task by id.
   * @param id The id of the external task for which the error details should be retrieved. (required)
   * @return String
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> Request successful. In case the external task has no error details. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> An external task with the given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public String getExternalTaskErrorDetails(String id) throws ApiException {
    return getExternalTaskErrorDetailsWithHttpInfo(id).getData();
  }

  /**
   * 
   * Retrieves the error details in the context of a running external task by id.
   * @param id The id of the external task for which the error details should be retrieved. (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> Request successful. In case the external task has no error details. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> An external task with the given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<String> getExternalTaskErrorDetailsWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getExternalTaskErrorDetails");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}/errorDetails"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "text/plain", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<String> localVarReturnType = new GenericType<String>() {};

    return apiClient.invokeAPI("ExternalTaskApi.getExternalTaskErrorDetails", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for the external tasks that fulfill given parameters. Parameters may be static as well as dynamic runtime properties of executions. The size of the result set can be retrieved by using the [Get External Task Count](https://docs.camunda.org/manual/7.14/reference/rest/external-task/get-query-count/) method.
   * @param externalTaskId Filter by an external task&#39;s id. (optional)
   * @param externalTaskIdIn Filter by the comma-separated list of external task ids. (optional)
   * @param topicName Filter by an external task topic. (optional)
   * @param workerId Filter by the id of the worker that the task was most recently locked by. (optional)
   * @param locked Only include external tasks that are currently locked (i.e., they have a lock time and it has not expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param notLocked Only include external tasks that are currently not locked (i.e., they have no lock or it has expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param withRetriesLeft Only include external tasks that have a positive (&amp;gt; 0) number of retries (or &#x60;null&#x60;). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param noRetriesLeft Only include external tasks that have 0 retries. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param lockExpirationAfter Restrict to external tasks that have a lock that expires after a given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param lockExpirationBefore Restrict to external tasks that have a lock that expires before a given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param activityId Filter by the id of the activity that an external task is created for. (optional)
   * @param activityIdIn Filter by the comma-separated list of ids of the activities that an external task is created for. (optional)
   * @param executionId Filter by the id of the execution that an external task belongs to. (optional)
   * @param processInstanceId Filter by the id of the process instance that an external task belongs to. (optional)
   * @param processInstanceIdIn Filter by a comma-separated list of process instance ids that an external task may belong to. (optional)
   * @param processDefinitionId Filter by the id of the process definition that an external task belongs to. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. An external task must have one of the given tenant ids. (optional)
   * @param active Only include active tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param suspended Only include suspended tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param priorityHigherThanOrEquals Only include jobs with a priority higher than or equal to the given value. Value must be a valid &#x60;long&#x60; value. (optional)
   * @param priorityLowerThanOrEquals Only include jobs with a priority lower than or equal to the given value. Value must be a valid &#x60;long&#x60; value. (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return List&lt;ExternalTaskDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<ExternalTaskDto> getExternalTasks(String externalTaskId, String externalTaskIdIn, String topicName, String workerId, Boolean locked, Boolean notLocked, Boolean withRetriesLeft, Boolean noRetriesLeft, OffsetDateTime lockExpirationAfter, OffsetDateTime lockExpirationBefore, String activityId, String activityIdIn, String executionId, String processInstanceId, String processInstanceIdIn, String processDefinitionId, String tenantIdIn, Boolean active, Boolean suspended, Long priorityHigherThanOrEquals, Long priorityLowerThanOrEquals, String sortBy, String sortOrder, Integer firstResult, Integer maxResults) throws ApiException {
    return getExternalTasksWithHttpInfo(externalTaskId, externalTaskIdIn, topicName, workerId, locked, notLocked, withRetriesLeft, noRetriesLeft, lockExpirationAfter, lockExpirationBefore, activityId, activityIdIn, executionId, processInstanceId, processInstanceIdIn, processDefinitionId, tenantIdIn, active, suspended, priorityHigherThanOrEquals, priorityLowerThanOrEquals, sortBy, sortOrder, firstResult, maxResults).getData();
  }

  /**
   * 
   * Queries for the external tasks that fulfill given parameters. Parameters may be static as well as dynamic runtime properties of executions. The size of the result set can be retrieved by using the [Get External Task Count](https://docs.camunda.org/manual/7.14/reference/rest/external-task/get-query-count/) method.
   * @param externalTaskId Filter by an external task&#39;s id. (optional)
   * @param externalTaskIdIn Filter by the comma-separated list of external task ids. (optional)
   * @param topicName Filter by an external task topic. (optional)
   * @param workerId Filter by the id of the worker that the task was most recently locked by. (optional)
   * @param locked Only include external tasks that are currently locked (i.e., they have a lock time and it has not expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param notLocked Only include external tasks that are currently not locked (i.e., they have no lock or it has expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param withRetriesLeft Only include external tasks that have a positive (&amp;gt; 0) number of retries (or &#x60;null&#x60;). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param noRetriesLeft Only include external tasks that have 0 retries. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param lockExpirationAfter Restrict to external tasks that have a lock that expires after a given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param lockExpirationBefore Restrict to external tasks that have a lock that expires before a given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param activityId Filter by the id of the activity that an external task is created for. (optional)
   * @param activityIdIn Filter by the comma-separated list of ids of the activities that an external task is created for. (optional)
   * @param executionId Filter by the id of the execution that an external task belongs to. (optional)
   * @param processInstanceId Filter by the id of the process instance that an external task belongs to. (optional)
   * @param processInstanceIdIn Filter by a comma-separated list of process instance ids that an external task may belong to. (optional)
   * @param processDefinitionId Filter by the id of the process definition that an external task belongs to. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. An external task must have one of the given tenant ids. (optional)
   * @param active Only include active tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param suspended Only include suspended tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param priorityHigherThanOrEquals Only include jobs with a priority higher than or equal to the given value. Value must be a valid &#x60;long&#x60; value. (optional)
   * @param priorityLowerThanOrEquals Only include jobs with a priority lower than or equal to the given value. Value must be a valid &#x60;long&#x60; value. (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return ApiResponse&lt;List&lt;ExternalTaskDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ExternalTaskDto>> getExternalTasksWithHttpInfo(String externalTaskId, String externalTaskIdIn, String topicName, String workerId, Boolean locked, Boolean notLocked, Boolean withRetriesLeft, Boolean noRetriesLeft, OffsetDateTime lockExpirationAfter, OffsetDateTime lockExpirationBefore, String activityId, String activityIdIn, String executionId, String processInstanceId, String processInstanceIdIn, String processDefinitionId, String tenantIdIn, Boolean active, Boolean suspended, Long priorityHigherThanOrEquals, Long priorityLowerThanOrEquals, String sortBy, String sortOrder, Integer firstResult, Integer maxResults) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/external-task";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "externalTaskId", externalTaskId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "externalTaskIdIn", externalTaskIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "topicName", topicName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "workerId", workerId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "locked", locked));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "notLocked", notLocked));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withRetriesLeft", withRetriesLeft));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "noRetriesLeft", noRetriesLeft));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lockExpirationAfter", lockExpirationAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lockExpirationBefore", lockExpirationBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityId", activityId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityIdIn", activityIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executionId", executionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceId", processInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceIdIn", processInstanceIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "priorityHigherThanOrEquals", priorityHigherThanOrEquals));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "priorityLowerThanOrEquals", priorityLowerThanOrEquals));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortOrder", sortOrder));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstResult", firstResult));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxResults", maxResults));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<ExternalTaskDto>> localVarReturnType = new GenericType<List<ExternalTaskDto>>() {};

    return apiClient.invokeAPI("ExternalTaskApi.getExternalTasks", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for the number of external tasks that fulfill given parameters. Takes the same parameters as the [Get External Tasks](https://docs.camunda.org/manual/7.14/reference/rest/external-task/get-query/) method.
   * @param externalTaskId Filter by an external task&#39;s id. (optional)
   * @param externalTaskIdIn Filter by the comma-separated list of external task ids. (optional)
   * @param topicName Filter by an external task topic. (optional)
   * @param workerId Filter by the id of the worker that the task was most recently locked by. (optional)
   * @param locked Only include external tasks that are currently locked (i.e., they have a lock time and it has not expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param notLocked Only include external tasks that are currently not locked (i.e., they have no lock or it has expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param withRetriesLeft Only include external tasks that have a positive (&amp;gt; 0) number of retries (or &#x60;null&#x60;). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param noRetriesLeft Only include external tasks that have 0 retries. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param lockExpirationAfter Restrict to external tasks that have a lock that expires after a given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param lockExpirationBefore Restrict to external tasks that have a lock that expires before a given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param activityId Filter by the id of the activity that an external task is created for. (optional)
   * @param activityIdIn Filter by the comma-separated list of ids of the activities that an external task is created for. (optional)
   * @param executionId Filter by the id of the execution that an external task belongs to. (optional)
   * @param processInstanceId Filter by the id of the process instance that an external task belongs to. (optional)
   * @param processInstanceIdIn Filter by a comma-separated list of process instance ids that an external task may belong to. (optional)
   * @param processDefinitionId Filter by the id of the process definition that an external task belongs to. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. An external task must have one of the given tenant ids. (optional)
   * @param active Only include active tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param suspended Only include suspended tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param priorityHigherThanOrEquals Only include jobs with a priority higher than or equal to the given value. Value must be a valid &#x60;long&#x60; value. (optional)
   * @param priorityLowerThanOrEquals Only include jobs with a priority lower than or equal to the given value. Value must be a valid &#x60;long&#x60; value. (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto getExternalTasksCount(String externalTaskId, String externalTaskIdIn, String topicName, String workerId, Boolean locked, Boolean notLocked, Boolean withRetriesLeft, Boolean noRetriesLeft, OffsetDateTime lockExpirationAfter, OffsetDateTime lockExpirationBefore, String activityId, String activityIdIn, String executionId, String processInstanceId, String processInstanceIdIn, String processDefinitionId, String tenantIdIn, Boolean active, Boolean suspended, Long priorityHigherThanOrEquals, Long priorityLowerThanOrEquals) throws ApiException {
    return getExternalTasksCountWithHttpInfo(externalTaskId, externalTaskIdIn, topicName, workerId, locked, notLocked, withRetriesLeft, noRetriesLeft, lockExpirationAfter, lockExpirationBefore, activityId, activityIdIn, executionId, processInstanceId, processInstanceIdIn, processDefinitionId, tenantIdIn, active, suspended, priorityHigherThanOrEquals, priorityLowerThanOrEquals).getData();
  }

  /**
   * 
   * Queries for the number of external tasks that fulfill given parameters. Takes the same parameters as the [Get External Tasks](https://docs.camunda.org/manual/7.14/reference/rest/external-task/get-query/) method.
   * @param externalTaskId Filter by an external task&#39;s id. (optional)
   * @param externalTaskIdIn Filter by the comma-separated list of external task ids. (optional)
   * @param topicName Filter by an external task topic. (optional)
   * @param workerId Filter by the id of the worker that the task was most recently locked by. (optional)
   * @param locked Only include external tasks that are currently locked (i.e., they have a lock time and it has not expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param notLocked Only include external tasks that are currently not locked (i.e., they have no lock or it has expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param withRetriesLeft Only include external tasks that have a positive (&amp;gt; 0) number of retries (or &#x60;null&#x60;). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param noRetriesLeft Only include external tasks that have 0 retries. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param lockExpirationAfter Restrict to external tasks that have a lock that expires after a given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param lockExpirationBefore Restrict to external tasks that have a lock that expires before a given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param activityId Filter by the id of the activity that an external task is created for. (optional)
   * @param activityIdIn Filter by the comma-separated list of ids of the activities that an external task is created for. (optional)
   * @param executionId Filter by the id of the execution that an external task belongs to. (optional)
   * @param processInstanceId Filter by the id of the process instance that an external task belongs to. (optional)
   * @param processInstanceIdIn Filter by a comma-separated list of process instance ids that an external task may belong to. (optional)
   * @param processDefinitionId Filter by the id of the process definition that an external task belongs to. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. An external task must have one of the given tenant ids. (optional)
   * @param active Only include active tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param suspended Only include suspended tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param priorityHigherThanOrEquals Only include jobs with a priority higher than or equal to the given value. Value must be a valid &#x60;long&#x60; value. (optional)
   * @param priorityLowerThanOrEquals Only include jobs with a priority lower than or equal to the given value. Value must be a valid &#x60;long&#x60; value. (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> getExternalTasksCountWithHttpInfo(String externalTaskId, String externalTaskIdIn, String topicName, String workerId, Boolean locked, Boolean notLocked, Boolean withRetriesLeft, Boolean noRetriesLeft, OffsetDateTime lockExpirationAfter, OffsetDateTime lockExpirationBefore, String activityId, String activityIdIn, String executionId, String processInstanceId, String processInstanceIdIn, String processDefinitionId, String tenantIdIn, Boolean active, Boolean suspended, Long priorityHigherThanOrEquals, Long priorityLowerThanOrEquals) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/external-task/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "externalTaskId", externalTaskId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "externalTaskIdIn", externalTaskIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "topicName", topicName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "workerId", workerId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "locked", locked));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "notLocked", notLocked));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withRetriesLeft", withRetriesLeft));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "noRetriesLeft", noRetriesLeft));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lockExpirationAfter", lockExpirationAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lockExpirationBefore", lockExpirationBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityId", activityId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityIdIn", activityIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executionId", executionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceId", processInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceIdIn", processInstanceIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "priorityHigherThanOrEquals", priorityHigherThanOrEquals));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "priorityLowerThanOrEquals", priorityLowerThanOrEquals));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<CountResultDto> localVarReturnType = new GenericType<CountResultDto>() {};

    return apiClient.invokeAPI("ExternalTaskApi.getExternalTasksCount", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for distinct topic names of external tasks that fulfill given parameters. Query can be restricted to only tasks with retries left, tasks that are locked, or tasks that are unlocked. The parameters withLockedTasks and withUnlockedTasks are exclusive. Setting them both to true will return an empty list. Providing no parameters will return a list of all distinct topic names with external tasks.
   * @param withLockedTasks Only include external tasks that are currently locked (i.e., they have a lock time and it has not expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param withUnlockedTasks Only include external tasks that are currently not locked (i.e., they have no lock or it has expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param withRetriesLeft Only include external tasks that have a positive (&amp;gt; 0) number of retries (or &#x60;null&#x60;). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. </td><td>  -  </td></tr>
     </table>
   */
  public List<String> getTopicNames(Boolean withLockedTasks, Boolean withUnlockedTasks, Boolean withRetriesLeft) throws ApiException {
    return getTopicNamesWithHttpInfo(withLockedTasks, withUnlockedTasks, withRetriesLeft).getData();
  }

  /**
   * 
   * Queries for distinct topic names of external tasks that fulfill given parameters. Query can be restricted to only tasks with retries left, tasks that are locked, or tasks that are unlocked. The parameters withLockedTasks and withUnlockedTasks are exclusive. Setting them both to true will return an empty list. Providing no parameters will return a list of all distinct topic names with external tasks.
   * @param withLockedTasks Only include external tasks that are currently locked (i.e., they have a lock time and it has not expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param withUnlockedTasks Only include external tasks that are currently not locked (i.e., they have no lock or it has expired). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @param withRetriesLeft Only include external tasks that have a positive (&amp;gt; 0) number of retries (or &#x60;null&#x60;). Value may only be &#x60;true&#x60;, as &#x60;false&#x60; matches any external task. (optional)
   * @return ApiResponse&lt;List&lt;String&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<String>> getTopicNamesWithHttpInfo(Boolean withLockedTasks, Boolean withUnlockedTasks, Boolean withRetriesLeft) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/external-task/topic-names";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withLockedTasks", withLockedTasks));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withUnlockedTasks", withUnlockedTasks));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withRetriesLeft", withRetriesLeft));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<String>> localVarReturnType = new GenericType<List<String>>() {};

    return apiClient.invokeAPI("ExternalTaskApi.getTopicNames", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Reports a business error in the context of a running external task by id. The error code must be specified to identify the BPMN error handler.
   * @param id The id of the external task in which context a BPMN error is reported. (required)
   * @param externalTaskBpmnError  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if the task&#39;s most recent lock was not acquired by the provided worker.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Returned if the corresponding process instance could not be resumed successfully.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void handleExternalTaskBpmnError(String id, ExternalTaskBpmnError externalTaskBpmnError) throws ApiException {
    handleExternalTaskBpmnErrorWithHttpInfo(id, externalTaskBpmnError);
  }

  /**
   * 
   * Reports a business error in the context of a running external task by id. The error code must be specified to identify the BPMN error handler.
   * @param id The id of the external task in which context a BPMN error is reported. (required)
   * @param externalTaskBpmnError  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if the task&#39;s most recent lock was not acquired by the provided worker.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Returned if the corresponding process instance could not be resumed successfully.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> handleExternalTaskBpmnErrorWithHttpInfo(String id, ExternalTaskBpmnError externalTaskBpmnError) throws ApiException {
    Object localVarPostBody = externalTaskBpmnError;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling handleExternalTaskBpmnError");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}/bpmnError"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ExternalTaskApi.handleExternalTaskBpmnError", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Reports a failure to execute an external task by id. A number of retries and a timeout until the task can be retried can be specified. If retries are set to 0, an incident for this task is created.
   * @param id The id of the external task to report a failure for. (required)
   * @param externalTaskFailureDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if the task&#39;s most recent lock was not acquired by the provided worker. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Returned if the corresponding process instance could not be resumed successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void handleFailure(String id, ExternalTaskFailureDto externalTaskFailureDto) throws ApiException {
    handleFailureWithHttpInfo(id, externalTaskFailureDto);
  }

  /**
   * 
   * Reports a failure to execute an external task by id. A number of retries and a timeout until the task can be retried can be specified. If retries are set to 0, an incident for this task is created.
   * @param id The id of the external task to report a failure for. (required)
   * @param externalTaskFailureDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if the task&#39;s most recent lock was not acquired by the provided worker. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Returned if the corresponding process instance could not be resumed successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> handleFailureWithHttpInfo(String id, ExternalTaskFailureDto externalTaskFailureDto) throws ApiException {
    Object localVarPostBody = externalTaskFailureDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling handleFailure");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}/failure"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ExternalTaskApi.handleFailure", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Queries for external tasks that fulfill given parameters in the form of a JSON object.  This method is slightly more powerful than the [Get External Tasks](https://docs.camunda.org/manual/7.14/reference/rest/external-task/get-query/) method because it allows to specify a hierarchical result sorting.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param externalTaskQueryDto  (optional)
   * @return List&lt;ExternalTaskDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The Response is a JSON array of external task objects. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<ExternalTaskDto> queryExternalTasks(Integer firstResult, Integer maxResults, ExternalTaskQueryDto externalTaskQueryDto) throws ApiException {
    return queryExternalTasksWithHttpInfo(firstResult, maxResults, externalTaskQueryDto).getData();
  }

  /**
   * 
   * Queries for external tasks that fulfill given parameters in the form of a JSON object.  This method is slightly more powerful than the [Get External Tasks](https://docs.camunda.org/manual/7.14/reference/rest/external-task/get-query/) method because it allows to specify a hierarchical result sorting.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param externalTaskQueryDto  (optional)
   * @return ApiResponse&lt;List&lt;ExternalTaskDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The Response is a JSON array of external task objects. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ExternalTaskDto>> queryExternalTasksWithHttpInfo(Integer firstResult, Integer maxResults, ExternalTaskQueryDto externalTaskQueryDto) throws ApiException {
    Object localVarPostBody = externalTaskQueryDto;
    
    // create path and map variables
    String localVarPath = "/external-task";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstResult", firstResult));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxResults", maxResults));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<ExternalTaskDto>> localVarReturnType = new GenericType<List<ExternalTaskDto>>() {};

    return apiClient.invokeAPI("ExternalTaskApi.queryExternalTasks", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for the number of external tasks that fulfill given parameters. This method takes the same message body as the [Get External Tasks (POST)](https://docs.camunda.org/manual/7.14/reference/rest/external-task/post-query/) method.
   * @param externalTaskQueryDto  (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto queryExternalTasksCount(ExternalTaskQueryDto externalTaskQueryDto) throws ApiException {
    return queryExternalTasksCountWithHttpInfo(externalTaskQueryDto).getData();
  }

  /**
   * 
   * Queries for the number of external tasks that fulfill given parameters. This method takes the same message body as the [Get External Tasks (POST)](https://docs.camunda.org/manual/7.14/reference/rest/external-task/post-query/) method.
   * @param externalTaskQueryDto  (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> queryExternalTasksCountWithHttpInfo(ExternalTaskQueryDto externalTaskQueryDto) throws ApiException {
    Object localVarPostBody = externalTaskQueryDto;
    
    // create path and map variables
    String localVarPath = "/external-task/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<CountResultDto> localVarReturnType = new GenericType<CountResultDto>() {};

    return apiClient.invokeAPI("ExternalTaskApi.queryExternalTasksCount", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Sets the priority of an existing external task by id. The default value of a priority is 0.
   * @param id The id of the external task to set the priority for. (required)
   * @param priorityDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void setExternalTaskResourcePriority(String id, PriorityDto priorityDto) throws ApiException {
    setExternalTaskResourcePriorityWithHttpInfo(id, priorityDto);
  }

  /**
   * 
   * Sets the priority of an existing external task by id. The default value of a priority is 0.
   * @param id The id of the external task to set the priority for. (required)
   * @param priorityDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setExternalTaskResourcePriorityWithHttpInfo(String id, PriorityDto priorityDto) throws ApiException {
    Object localVarPostBody = priorityDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling setExternalTaskResourcePriority");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}/priority"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ExternalTaskApi.setExternalTaskResourcePriority", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Sets the number of retries left to execute an external task by id. If retries are set to 0, an  incident is created.
   * @param id The id of the external task to set the number of retries for. (required)
   * @param retriesDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> In case the number of retries is negative or null, an exception of type &#x60;InvalidRequestException&#x60; is returned. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void setExternalTaskResourceRetries(String id, RetriesDto retriesDto) throws ApiException {
    setExternalTaskResourceRetriesWithHttpInfo(id, retriesDto);
  }

  /**
   * 
   * Sets the number of retries left to execute an external task by id. If retries are set to 0, an  incident is created.
   * @param id The id of the external task to set the number of retries for. (required)
   * @param retriesDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> In case the number of retries is negative or null, an exception of type &#x60;InvalidRequestException&#x60; is returned. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setExternalTaskResourceRetriesWithHttpInfo(String id, RetriesDto retriesDto) throws ApiException {
    Object localVarPostBody = retriesDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling setExternalTaskResourceRetries");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}/retries"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ExternalTaskApi.setExternalTaskResourceRetries", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Sets the number of retries left to execute external tasks by id synchronously. If retries are set to 0,  an incident is created.
   * @param setRetriesForExternalTasksDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> In case the number of retries is negative or null, an exception of type &#x60;InvalidRequestException&#x60; is returned. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task,  e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void setExternalTaskRetries(SetRetriesForExternalTasksDto setRetriesForExternalTasksDto) throws ApiException {
    setExternalTaskRetriesWithHttpInfo(setRetriesForExternalTasksDto);
  }

  /**
   * 
   * Sets the number of retries left to execute external tasks by id synchronously. If retries are set to 0,  an incident is created.
   * @param setRetriesForExternalTasksDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> In case the number of retries is negative or null, an exception of type &#x60;InvalidRequestException&#x60; is returned. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task,  e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setExternalTaskRetriesWithHttpInfo(SetRetriesForExternalTasksDto setRetriesForExternalTasksDto) throws ApiException {
    Object localVarPostBody = setRetriesForExternalTasksDto;
    
    // create path and map variables
    String localVarPath = "/external-task/retries";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ExternalTaskApi.setExternalTaskRetries", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Sets the number of retries left to execute external tasks by id asynchronously. If retries are set to 0, an incident is created.
   * @param setRetriesForExternalTasksDto  (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> If neither externalTaskIds nor externalTaskQuery are present or externalTaskIds contains null value or  the number of retries is negative or null, an exception of type &#x60;InvalidRequestException&#x60; is returned. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task,  e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto setExternalTaskRetriesAsyncOperation(SetRetriesForExternalTasksDto setRetriesForExternalTasksDto) throws ApiException {
    return setExternalTaskRetriesAsyncOperationWithHttpInfo(setRetriesForExternalTasksDto).getData();
  }

  /**
   * 
   * Sets the number of retries left to execute external tasks by id asynchronously. If retries are set to 0, an incident is created.
   * @param setRetriesForExternalTasksDto  (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> If neither externalTaskIds nor externalTaskQuery are present or externalTaskIds contains null value or  the number of retries is negative or null, an exception of type &#x60;InvalidRequestException&#x60; is returned. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task,  e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> setExternalTaskRetriesAsyncOperationWithHttpInfo(SetRetriesForExternalTasksDto setRetriesForExternalTasksDto) throws ApiException {
    Object localVarPostBody = setRetriesForExternalTasksDto;
    
    // create path and map variables
    String localVarPath = "/external-task/retries-async";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<BatchDto> localVarReturnType = new GenericType<BatchDto>() {};

    return apiClient.invokeAPI("ExternalTaskApi.setExternalTaskRetriesAsyncOperation", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Unlocks an external task by id. Clears the task&#39;s lock expiration time and worker id.
   * @param id The id of the external task to unlock. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void unlock(String id) throws ApiException {
    unlockWithHttpInfo(id);
  }

  /**
   * 
   * Unlocks an external task by id. Clears the task&#39;s lock expiration time and worker id.
   * @param id The id of the external task to unlock. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist. This could indicate a wrong task id as well as a cancelled task, e.g., due to a caught BPMN boundary event. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> unlockWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling unlock");
    }
    
    // create path and map variables
    String localVarPath = "/external-task/{id}/unlock"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ExternalTaskApi.unlock", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
