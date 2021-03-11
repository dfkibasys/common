package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.AuthorizationExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.CompleteTaskDto;
import de.dfki.cos.basys.common.rest.camunda.dto.CountResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import java.io.File;
import de.dfki.cos.basys.common.rest.camunda.dto.FormDto;
import de.dfki.cos.basys.common.rest.camunda.dto.TaskBpmnErrorDto;
import de.dfki.cos.basys.common.rest.camunda.dto.TaskDto;
import de.dfki.cos.basys.common.rest.camunda.dto.TaskEscalationDto;
import de.dfki.cos.basys.common.rest.camunda.dto.TaskQueryDto;
import de.dfki.cos.basys.common.rest.camunda.dto.UserIdDto;
import de.dfki.cos.basys.common.rest.camunda.dto.VariableValueDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class TaskApi {
  private ApiClient apiClient;

  public TaskApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TaskApi(ApiClient apiClient) {
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
   * Claims a task for a specific user.  **Note:** The difference with the [Set Assignee](https://docs.camunda.org/manual/7.14/reference/rest/task/post-assignee/) method is that here a check is performed to see if the task already has a user assigned to it.
   * @param id The id of the task to claim. (required)
   * @param userIdDto Provide the id of the user that claims the task. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task with given id does not exist or claiming was not successful. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void claim(String id, UserIdDto userIdDto) throws ApiException {
    claimWithHttpInfo(id, userIdDto);
  }

  /**
   * 
   * Claims a task for a specific user.  **Note:** The difference with the [Set Assignee](https://docs.camunda.org/manual/7.14/reference/rest/task/post-assignee/) method is that here a check is performed to see if the task already has a user assigned to it.
   * @param id The id of the task to claim. (required)
   * @param userIdDto Provide the id of the user that claims the task. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task with given id does not exist or claiming was not successful. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> claimWithHttpInfo(String id, UserIdDto userIdDto) throws ApiException {
    Object localVarPostBody = userIdDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling claim");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/claim"
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

    return apiClient.invokeAPI("TaskApi.claim", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Completes a task and updates process variables.
   * @param id The id of the task to complete. (required)
   * @param completeTaskDto  (optional)
   * @return Map&lt;String, VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The response contains the process variables. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> Request successful. The response contains no variables. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> If the task does not exist or the corresponding process instance could not be resumed successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, VariableValueDto> complete(String id, CompleteTaskDto completeTaskDto) throws ApiException {
    return completeWithHttpInfo(id, completeTaskDto).getData();
  }

  /**
   * 
   * Completes a task and updates process variables.
   * @param id The id of the task to complete. (required)
   * @param completeTaskDto  (optional)
   * @return ApiResponse&lt;Map&lt;String, VariableValueDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The response contains the process variables. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> Request successful. The response contains no variables. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> If the task does not exist or the corresponding process instance could not be resumed successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, VariableValueDto>> completeWithHttpInfo(String id, CompleteTaskDto completeTaskDto) throws ApiException {
    Object localVarPostBody = completeTaskDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling complete");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/complete"
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

    GenericType<Map<String, VariableValueDto>> localVarReturnType = new GenericType<Map<String, VariableValueDto>>() {};

    return apiClient.invokeAPI("TaskApi.complete", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Creates a new task.
   * @param taskDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if a not valid &#x60;delegationState&#x60; is supplied. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void createTask(TaskDto taskDto) throws ApiException {
    createTaskWithHttpInfo(taskDto);
  }

  /**
   * 
   * Creates a new task.
   * @param taskDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if a not valid &#x60;delegationState&#x60; is supplied. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createTaskWithHttpInfo(TaskDto taskDto) throws ApiException {
    Object localVarPostBody = taskDto;
    
    // create path and map variables
    String localVarPath = "/task/create";

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

    return apiClient.invokeAPI("TaskApi.createTask", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Delegates a task to another user.
   * @param id The id of the task to delegate. (required)
   * @param userIdDto Provide the id of the user that the task should be delegated to. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> If the task does not exist or delegation was not successful. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void delegateTask(String id, UserIdDto userIdDto) throws ApiException {
    delegateTaskWithHttpInfo(id, userIdDto);
  }

  /**
   * 
   * Delegates a task to another user.
   * @param id The id of the task to delegate. (required)
   * @param userIdDto Provide the id of the user that the task should be delegated to. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> If the task does not exist or delegation was not successful. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> delegateTaskWithHttpInfo(String id, UserIdDto userIdDto) throws ApiException {
    Object localVarPostBody = userIdDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling delegateTask");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/delegate"
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

    return apiClient.invokeAPI("TaskApi.delegateTask", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Removes a task by id.
   * @param id The id of the task to be removed. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request. The Task with the given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The Task with the given id cannot be deleted because it is part of a running process or case instance. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteTask(String id) throws ApiException {
    deleteTaskWithHttpInfo(id);
  }

  /**
   * 
   * Removes a task by id.
   * @param id The id of the task to be removed. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request. The Task with the given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The Task with the given id cannot be deleted because it is part of a running process or case instance. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteTaskWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteTask");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}"
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

    return apiClient.invokeAPI("TaskApi.deleteTask", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Retrieves the deployed form that is referenced from a given task. For further information please refer to the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
   * @param id The id of the task to get the deployed form for. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The form key has wrong format. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The deployed form cannot be retrieved due to missing permissions on task resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> No deployed form for a given task exists. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getDeployedForm(String id) throws ApiException {
    return getDeployedFormWithHttpInfo(id).getData();
  }

  /**
   * 
   * Retrieves the deployed form that is referenced from a given task. For further information please refer to the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
   * @param id The id of the task to get the deployed form for. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The form key has wrong format. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The deployed form cannot be retrieved due to missing permissions on task resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> No deployed form for a given task exists. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getDeployedFormWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getDeployedForm");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/deployed-form"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/xhtml+xml", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<File> localVarReturnType = new GenericType<File>() {};

    return apiClient.invokeAPI("TaskApi.getDeployedForm", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves the form key for a task. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine. This key can be used to do task-specific form rendering in client applications. Additionally, the context path of the containing process application is returned.
   * @param id The id of the task to retrieve the form for. (required)
   * @return FormDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Task with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public FormDto getForm(String id) throws ApiException {
    return getFormWithHttpInfo(id).getData();
  }

  /**
   * 
   * Retrieves the form key for a task. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine. This key can be used to do task-specific form rendering in client applications. Additionally, the context path of the containing process application is returned.
   * @param id The id of the task to retrieve the form for. (required)
   * @return ApiResponse&lt;FormDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Task with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<FormDto> getFormWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getForm");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/form"
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

    GenericType<FormDto> localVarReturnType = new GenericType<FormDto>() {};

    return apiClient.invokeAPI("TaskApi.getForm", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves the form variables for a task. The form variables take form data specified on the task into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
   * @param id The id of the task to retrieve the variables for. (required)
   * @param variableNames A comma-separated list of variable names. Allows restricting the list of requested variables to the variable names in the list. It is best practice to restrict the list of variables to the variables actually required by the form in order to minimize fetching of data. If the query parameter is ommitted all variables are fetched. If the query parameter contains non-existent variable names, the variable names are ignored. (optional)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](http://jackson.codehaus.org/) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return Map&lt;String, VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. A JSON object containing a property for each variable returned. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td>  id is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, VariableValueDto> getFormVariables(String id, String variableNames, Boolean deserializeValues) throws ApiException {
    return getFormVariablesWithHttpInfo(id, variableNames, deserializeValues).getData();
  }

  /**
   * 
   * Retrieves the form variables for a task. The form variables take form data specified on the task into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
   * @param id The id of the task to retrieve the variables for. (required)
   * @param variableNames A comma-separated list of variable names. Allows restricting the list of requested variables to the variable names in the list. It is best practice to restrict the list of variables to the variables actually required by the form in order to minimize fetching of data. If the query parameter is ommitted all variables are fetched. If the query parameter contains non-existent variable names, the variable names are ignored. (optional)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](http://jackson.codehaus.org/) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return ApiResponse&lt;Map&lt;String, VariableValueDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. A JSON object containing a property for each variable returned. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td>  id is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, VariableValueDto>> getFormVariablesWithHttpInfo(String id, String variableNames, Boolean deserializeValues) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getFormVariables");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/form-variables"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableNames", variableNames));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deserializeValues", deserializeValues));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Map<String, VariableValueDto>> localVarReturnType = new GenericType<Map<String, VariableValueDto>>() {};

    return apiClient.invokeAPI("TaskApi.getFormVariables", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves the rendered form for a task. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param id The id of the task to get the rendered form for. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The task with the given id does not exist or has no form field metadata defined for this task. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getRenderedForm(String id) throws ApiException {
    return getRenderedFormWithHttpInfo(id).getData();
  }

  /**
   * 
   * Retrieves the rendered form for a task. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param id The id of the task to get the rendered form for. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The task with the given id does not exist or has no form field metadata defined for this task. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getRenderedFormWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getRenderedForm");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/rendered-form"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/xhtml+xml", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<File> localVarReturnType = new GenericType<File>() {};

    return apiClient.invokeAPI("TaskApi.getRenderedForm", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves a task by id.
   * @param id The id of the task to be retrieved. (required)
   * @return TaskDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Task with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public TaskDto getTask(String id) throws ApiException {
    return getTaskWithHttpInfo(id).getData();
  }

  /**
   * 
   * Retrieves a task by id.
   * @param id The id of the task to be retrieved. (required)
   * @return ApiResponse&lt;TaskDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Task with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TaskDto> getTaskWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getTask");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}"
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

    GenericType<TaskDto> localVarReturnType = new GenericType<TaskDto>() {};

    return apiClient.invokeAPI("TaskApi.getTask", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for tasks that fulfill a given filter. The size of the result set can be retrieved by using the Get Task Count method.  **Security Consideration:** There are several query parameters (such as assigneeExpression) for specifying an EL expression. These are disabled by default to prevent remote code execution. See the section on [security considerations](https://docs.camunda.org/manual/7.14/user-guide/process-engine/securing-custom-code/) for custom code in the user guide for details.
   * @param processInstanceId Restrict to tasks that belong to process instances with the given id. (optional)
   * @param processInstanceIdIn Restrict to tasks that belong to process instances with the given ids. (optional)
   * @param processInstanceBusinessKey Restrict to tasks that belong to process instances with the given business key. (optional)
   * @param processInstanceBusinessKeyExpression Restrict to tasks that belong to process instances with the given business key which  is described by an expression. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. (optional)
   * @param processInstanceBusinessKeyIn Restrict to tasks that belong to process instances with one of the give business keys.  The keys need to be in a comma-separated list. (optional)
   * @param processInstanceBusinessKeyLike Restrict to tasks that have a process instance business key that has the parameter  value as a substring. (optional)
   * @param processInstanceBusinessKeyLikeExpression Restrict to tasks that have a process instance business key that has the parameter  value as a substring and is described by an expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param processDefinitionId Restrict to tasks that belong to a process definition with the given id. (optional)
   * @param processDefinitionKey Restrict to tasks that belong to a process definition with the given key. (optional)
   * @param processDefinitionKeyIn Restrict to tasks that belong to a process definition with one of the given keys. The  keys need to be in a comma-separated list. (optional)
   * @param processDefinitionName Restrict to tasks that belong to a process definition with the given name. (optional)
   * @param processDefinitionNameLike Restrict to tasks that have a process definition name that has the parameter value as  a substring. (optional)
   * @param executionId Restrict to tasks that belong to an execution with the given id. (optional)
   * @param caseInstanceId Restrict to tasks that belong to case instances with the given id. (optional)
   * @param caseInstanceBusinessKey Restrict to tasks that belong to case instances with the given business key. (optional)
   * @param caseInstanceBusinessKeyLike Restrict to tasks that have a case instance business key that has the parameter value  as a substring. (optional)
   * @param caseDefinitionId Restrict to tasks that belong to a case definition with the given id. (optional)
   * @param caseDefinitionKey Restrict to tasks that belong to a case definition with the given key. (optional)
   * @param caseDefinitionName Restrict to tasks that belong to a case definition with the given name. (optional)
   * @param caseDefinitionNameLike Restrict to tasks that have a case definition name that has the parameter value as a  substring. (optional)
   * @param caseExecutionId Restrict to tasks that belong to a case execution with the given id. (optional)
   * @param activityInstanceIdIn Only include tasks which belong to one of the passed and comma-separated activity  instance ids. (optional)
   * @param tenantIdIn Only include tasks which belong to one of the passed and comma-separated  tenant ids. (optional)
   * @param withoutTenantId Only include tasks which belong to no tenant. Value may only be &#x60;true&#x60;,  as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param assignee Restrict to tasks that the given user is assigned to. (optional)
   * @param assigneeExpression Restrict to tasks that the user described by the given expression is assigned to.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param assigneeLike Restrict to tasks that have an assignee that has the parameter  value as a substring. (optional)
   * @param assigneeLikeExpression Restrict to tasks that have an assignee that has the parameter value described by the  given expression as a substring. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param assigneeIn Only include tasks which are assigned to one of the passed and  comma-separated user ids. (optional)
   * @param owner Restrict to tasks that the given user owns. (optional)
   * @param ownerExpression Restrict to tasks that the user described by the given expression owns. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param candidateGroup Only include tasks that are offered to the given group. (optional)
   * @param candidateGroupExpression Only include tasks that are offered to the group described by the given expression.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param candidateUser Only include tasks that are offered to the given user or to one of his groups. (optional)
   * @param candidateUserExpression Only include tasks that are offered to the user described by the given expression.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param includeAssignedTasks Also include tasks that are assigned to users in candidate queries. Default is to only  include tasks that are not assigned to any user if you query by candidate user or group(s). (optional, default to false)
   * @param involvedUser Only include tasks that the given user is involved in. A user is involved in a task if  an identity link exists between task and user (e.g., the user is the assignee). (optional)
   * @param involvedUserExpression Only include tasks that the user described by the given expression is involved in. A user is involved in a task if an identity link exists between task and user (e.g., the user is the assignee). See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. (optional)
   * @param assigned If set to &#x60;true&#x60;, restricts the query to all tasks that are assigned. (optional, default to false)
   * @param unassigned If set to &#x60;true&#x60;, restricts the query to all tasks that are unassigned. (optional, default to false)
   * @param taskDefinitionKey Restrict to tasks that have the given key. (optional)
   * @param taskDefinitionKeyIn Restrict to tasks that have one of the given keys. The keys need to be in a comma-separated list. (optional)
   * @param taskDefinitionKeyLike Restrict to tasks that have a key that has the parameter value as a substring. (optional)
   * @param name Restrict to tasks that have the given name. (optional)
   * @param nameNotEqual Restrict to tasks that do not have the given name. (optional)
   * @param nameLike Restrict to tasks that have a name with the given parameter value as substring. (optional)
   * @param nameNotLike Restrict to tasks that do not have a name with the given parameter value as substring. (optional)
   * @param description Restrict to tasks that have the given description. (optional)
   * @param descriptionLike Restrict to tasks that have a description that has the parameter value as a substring. (optional)
   * @param priority Restrict to tasks that have the given priority. (optional)
   * @param maxPriority Restrict to tasks that have a lower or equal priority. (optional)
   * @param minPriority Restrict to tasks that have a higher or equal priority. (optional)
   * @param dueDate Restrict to tasks that are due on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param dueDateExpression Restrict to tasks that are due on the date described by the given expression. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param dueAfter Restrict to tasks that are due after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.435+0200&#x60;. (optional)
   * @param dueAfterExpression Restrict to tasks that are due after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param dueBefore Restrict to tasks that are due before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.243+0200&#x60;. (optional)
   * @param dueBeforeExpression Restrict to tasks that are due before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpDate Restrict to tasks that have a followUp date on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.342+0200&#x60;. (optional)
   * @param followUpDateExpression Restrict to tasks that have a followUp date on the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpAfter Restrict to tasks that have a followUp date after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.542+0200&#x60;. (optional)
   * @param followUpAfterExpression Restrict to tasks that have a followUp date after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpBefore Restrict to tasks that have a followUp date before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.234+0200&#x60;. (optional)
   * @param followUpBeforeExpression Restrict to tasks that have a followUp date before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpBeforeOrNotExistent Restrict to tasks that have no followUp date or a followUp date before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.432+0200&#x60;. The typical use case is to query all &#x60;active&#x60; tasks for a user for a given date. (optional)
   * @param followUpBeforeOrNotExistentExpression Restrict to tasks that have no followUp date or a followUp date before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdOn Restrict to tasks that were created on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.324+0200&#x60;. (optional)
   * @param createdOnExpression Restrict to tasks that were created on the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdAfter Restrict to tasks that were created after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.342+0200&#x60;. (optional)
   * @param createdAfterExpression Restrict to tasks that were created after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdBefore Restrict to tasks that were created before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.332+0200&#x60;. (optional)
   * @param createdBeforeExpression Restrict to tasks that were created before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param delegationState Restrict to tasks that are in the given delegation state. Valid values are &#x60;PENDING&#x60; and &#x60;RESOLVED&#x60;. (optional)
   * @param candidateGroups Restrict to tasks that are offered to any of the given candidate groups. Takes a comma-separated list of group names, so for example &#x60;developers,support,sales&#x60;. (optional)
   * @param candidateGroupsExpression Restrict to tasks that are offered to any of the candidate groups described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to &#x60;java.util.List&#x60; of Strings. (optional)
   * @param withCandidateGroups Only include tasks which have a candidate group. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withoutCandidateGroups Only include tasks which have no candidate group. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withCandidateUsers Only include tasks which have a candidate user. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withoutCandidateUsers Only include tasks which have no candidate users. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param active Only include active tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param suspended Only include suspended tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param taskVariables Only include tasks that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param processVariables Only include tasks that belong to process instances that have variables with certain  values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param caseInstanceVariables Only include tasks that belong to case instances that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param variableNamesIgnoreCase Match all variable names in this query case-insensitively. If set &#x60;variableName&#x60; and &#x60;variablename&#x60; are treated as equal. (optional, default to false)
   * @param variableValuesIgnoreCase Match all variable values in this query case-insensitively. If set &#x60;variableValue&#x60; and &#x60;variablevalue&#x60; are treated as equal. (optional, default to false)
   * @param parentTaskId Restrict query to all tasks that are sub tasks of the given task. Takes a task id. (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return List&lt;TaskDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;, or if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<TaskDto> getTasks(String processInstanceId, String processInstanceIdIn, String processInstanceBusinessKey, String processInstanceBusinessKeyExpression, String processInstanceBusinessKeyIn, String processInstanceBusinessKeyLike, String processInstanceBusinessKeyLikeExpression, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionName, String processDefinitionNameLike, String executionId, String caseInstanceId, String caseInstanceBusinessKey, String caseInstanceBusinessKeyLike, String caseDefinitionId, String caseDefinitionKey, String caseDefinitionName, String caseDefinitionNameLike, String caseExecutionId, String activityInstanceIdIn, String tenantIdIn, Boolean withoutTenantId, String assignee, String assigneeExpression, String assigneeLike, String assigneeLikeExpression, String assigneeIn, String owner, String ownerExpression, String candidateGroup, String candidateGroupExpression, String candidateUser, String candidateUserExpression, Boolean includeAssignedTasks, String involvedUser, String involvedUserExpression, Boolean assigned, Boolean unassigned, String taskDefinitionKey, String taskDefinitionKeyIn, String taskDefinitionKeyLike, String name, String nameNotEqual, String nameLike, String nameNotLike, String description, String descriptionLike, Integer priority, Integer maxPriority, Integer minPriority, String dueDate, String dueDateExpression, String dueAfter, String dueAfterExpression, String dueBefore, String dueBeforeExpression, String followUpDate, String followUpDateExpression, String followUpAfter, String followUpAfterExpression, String followUpBefore, String followUpBeforeExpression, String followUpBeforeOrNotExistent, String followUpBeforeOrNotExistentExpression, String createdOn, String createdOnExpression, String createdAfter, String createdAfterExpression, String createdBefore, String createdBeforeExpression, String delegationState, String candidateGroups, String candidateGroupsExpression, Boolean withCandidateGroups, Boolean withoutCandidateGroups, Boolean withCandidateUsers, Boolean withoutCandidateUsers, Boolean active, Boolean suspended, String taskVariables, String processVariables, String caseInstanceVariables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase, String parentTaskId, String sortBy, String sortOrder, Integer firstResult, Integer maxResults) throws ApiException {
    return getTasksWithHttpInfo(processInstanceId, processInstanceIdIn, processInstanceBusinessKey, processInstanceBusinessKeyExpression, processInstanceBusinessKeyIn, processInstanceBusinessKeyLike, processInstanceBusinessKeyLikeExpression, processDefinitionId, processDefinitionKey, processDefinitionKeyIn, processDefinitionName, processDefinitionNameLike, executionId, caseInstanceId, caseInstanceBusinessKey, caseInstanceBusinessKeyLike, caseDefinitionId, caseDefinitionKey, caseDefinitionName, caseDefinitionNameLike, caseExecutionId, activityInstanceIdIn, tenantIdIn, withoutTenantId, assignee, assigneeExpression, assigneeLike, assigneeLikeExpression, assigneeIn, owner, ownerExpression, candidateGroup, candidateGroupExpression, candidateUser, candidateUserExpression, includeAssignedTasks, involvedUser, involvedUserExpression, assigned, unassigned, taskDefinitionKey, taskDefinitionKeyIn, taskDefinitionKeyLike, name, nameNotEqual, nameLike, nameNotLike, description, descriptionLike, priority, maxPriority, minPriority, dueDate, dueDateExpression, dueAfter, dueAfterExpression, dueBefore, dueBeforeExpression, followUpDate, followUpDateExpression, followUpAfter, followUpAfterExpression, followUpBefore, followUpBeforeExpression, followUpBeforeOrNotExistent, followUpBeforeOrNotExistentExpression, createdOn, createdOnExpression, createdAfter, createdAfterExpression, createdBefore, createdBeforeExpression, delegationState, candidateGroups, candidateGroupsExpression, withCandidateGroups, withoutCandidateGroups, withCandidateUsers, withoutCandidateUsers, active, suspended, taskVariables, processVariables, caseInstanceVariables, variableNamesIgnoreCase, variableValuesIgnoreCase, parentTaskId, sortBy, sortOrder, firstResult, maxResults).getData();
  }

  /**
   * 
   * Queries for tasks that fulfill a given filter. The size of the result set can be retrieved by using the Get Task Count method.  **Security Consideration:** There are several query parameters (such as assigneeExpression) for specifying an EL expression. These are disabled by default to prevent remote code execution. See the section on [security considerations](https://docs.camunda.org/manual/7.14/user-guide/process-engine/securing-custom-code/) for custom code in the user guide for details.
   * @param processInstanceId Restrict to tasks that belong to process instances with the given id. (optional)
   * @param processInstanceIdIn Restrict to tasks that belong to process instances with the given ids. (optional)
   * @param processInstanceBusinessKey Restrict to tasks that belong to process instances with the given business key. (optional)
   * @param processInstanceBusinessKeyExpression Restrict to tasks that belong to process instances with the given business key which  is described by an expression. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. (optional)
   * @param processInstanceBusinessKeyIn Restrict to tasks that belong to process instances with one of the give business keys.  The keys need to be in a comma-separated list. (optional)
   * @param processInstanceBusinessKeyLike Restrict to tasks that have a process instance business key that has the parameter  value as a substring. (optional)
   * @param processInstanceBusinessKeyLikeExpression Restrict to tasks that have a process instance business key that has the parameter  value as a substring and is described by an expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param processDefinitionId Restrict to tasks that belong to a process definition with the given id. (optional)
   * @param processDefinitionKey Restrict to tasks that belong to a process definition with the given key. (optional)
   * @param processDefinitionKeyIn Restrict to tasks that belong to a process definition with one of the given keys. The  keys need to be in a comma-separated list. (optional)
   * @param processDefinitionName Restrict to tasks that belong to a process definition with the given name. (optional)
   * @param processDefinitionNameLike Restrict to tasks that have a process definition name that has the parameter value as  a substring. (optional)
   * @param executionId Restrict to tasks that belong to an execution with the given id. (optional)
   * @param caseInstanceId Restrict to tasks that belong to case instances with the given id. (optional)
   * @param caseInstanceBusinessKey Restrict to tasks that belong to case instances with the given business key. (optional)
   * @param caseInstanceBusinessKeyLike Restrict to tasks that have a case instance business key that has the parameter value  as a substring. (optional)
   * @param caseDefinitionId Restrict to tasks that belong to a case definition with the given id. (optional)
   * @param caseDefinitionKey Restrict to tasks that belong to a case definition with the given key. (optional)
   * @param caseDefinitionName Restrict to tasks that belong to a case definition with the given name. (optional)
   * @param caseDefinitionNameLike Restrict to tasks that have a case definition name that has the parameter value as a  substring. (optional)
   * @param caseExecutionId Restrict to tasks that belong to a case execution with the given id. (optional)
   * @param activityInstanceIdIn Only include tasks which belong to one of the passed and comma-separated activity  instance ids. (optional)
   * @param tenantIdIn Only include tasks which belong to one of the passed and comma-separated  tenant ids. (optional)
   * @param withoutTenantId Only include tasks which belong to no tenant. Value may only be &#x60;true&#x60;,  as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param assignee Restrict to tasks that the given user is assigned to. (optional)
   * @param assigneeExpression Restrict to tasks that the user described by the given expression is assigned to.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param assigneeLike Restrict to tasks that have an assignee that has the parameter  value as a substring. (optional)
   * @param assigneeLikeExpression Restrict to tasks that have an assignee that has the parameter value described by the  given expression as a substring. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param assigneeIn Only include tasks which are assigned to one of the passed and  comma-separated user ids. (optional)
   * @param owner Restrict to tasks that the given user owns. (optional)
   * @param ownerExpression Restrict to tasks that the user described by the given expression owns. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param candidateGroup Only include tasks that are offered to the given group. (optional)
   * @param candidateGroupExpression Only include tasks that are offered to the group described by the given expression.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param candidateUser Only include tasks that are offered to the given user or to one of his groups. (optional)
   * @param candidateUserExpression Only include tasks that are offered to the user described by the given expression.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param includeAssignedTasks Also include tasks that are assigned to users in candidate queries. Default is to only  include tasks that are not assigned to any user if you query by candidate user or group(s). (optional, default to false)
   * @param involvedUser Only include tasks that the given user is involved in. A user is involved in a task if  an identity link exists between task and user (e.g., the user is the assignee). (optional)
   * @param involvedUserExpression Only include tasks that the user described by the given expression is involved in. A user is involved in a task if an identity link exists between task and user (e.g., the user is the assignee). See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. (optional)
   * @param assigned If set to &#x60;true&#x60;, restricts the query to all tasks that are assigned. (optional, default to false)
   * @param unassigned If set to &#x60;true&#x60;, restricts the query to all tasks that are unassigned. (optional, default to false)
   * @param taskDefinitionKey Restrict to tasks that have the given key. (optional)
   * @param taskDefinitionKeyIn Restrict to tasks that have one of the given keys. The keys need to be in a comma-separated list. (optional)
   * @param taskDefinitionKeyLike Restrict to tasks that have a key that has the parameter value as a substring. (optional)
   * @param name Restrict to tasks that have the given name. (optional)
   * @param nameNotEqual Restrict to tasks that do not have the given name. (optional)
   * @param nameLike Restrict to tasks that have a name with the given parameter value as substring. (optional)
   * @param nameNotLike Restrict to tasks that do not have a name with the given parameter value as substring. (optional)
   * @param description Restrict to tasks that have the given description. (optional)
   * @param descriptionLike Restrict to tasks that have a description that has the parameter value as a substring. (optional)
   * @param priority Restrict to tasks that have the given priority. (optional)
   * @param maxPriority Restrict to tasks that have a lower or equal priority. (optional)
   * @param minPriority Restrict to tasks that have a higher or equal priority. (optional)
   * @param dueDate Restrict to tasks that are due on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param dueDateExpression Restrict to tasks that are due on the date described by the given expression. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param dueAfter Restrict to tasks that are due after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.435+0200&#x60;. (optional)
   * @param dueAfterExpression Restrict to tasks that are due after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param dueBefore Restrict to tasks that are due before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.243+0200&#x60;. (optional)
   * @param dueBeforeExpression Restrict to tasks that are due before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpDate Restrict to tasks that have a followUp date on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.342+0200&#x60;. (optional)
   * @param followUpDateExpression Restrict to tasks that have a followUp date on the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpAfter Restrict to tasks that have a followUp date after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.542+0200&#x60;. (optional)
   * @param followUpAfterExpression Restrict to tasks that have a followUp date after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpBefore Restrict to tasks that have a followUp date before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.234+0200&#x60;. (optional)
   * @param followUpBeforeExpression Restrict to tasks that have a followUp date before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpBeforeOrNotExistent Restrict to tasks that have no followUp date or a followUp date before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.432+0200&#x60;. The typical use case is to query all &#x60;active&#x60; tasks for a user for a given date. (optional)
   * @param followUpBeforeOrNotExistentExpression Restrict to tasks that have no followUp date or a followUp date before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdOn Restrict to tasks that were created on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.324+0200&#x60;. (optional)
   * @param createdOnExpression Restrict to tasks that were created on the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdAfter Restrict to tasks that were created after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.342+0200&#x60;. (optional)
   * @param createdAfterExpression Restrict to tasks that were created after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdBefore Restrict to tasks that were created before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.332+0200&#x60;. (optional)
   * @param createdBeforeExpression Restrict to tasks that were created before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param delegationState Restrict to tasks that are in the given delegation state. Valid values are &#x60;PENDING&#x60; and &#x60;RESOLVED&#x60;. (optional)
   * @param candidateGroups Restrict to tasks that are offered to any of the given candidate groups. Takes a comma-separated list of group names, so for example &#x60;developers,support,sales&#x60;. (optional)
   * @param candidateGroupsExpression Restrict to tasks that are offered to any of the candidate groups described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to &#x60;java.util.List&#x60; of Strings. (optional)
   * @param withCandidateGroups Only include tasks which have a candidate group. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withoutCandidateGroups Only include tasks which have no candidate group. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withCandidateUsers Only include tasks which have a candidate user. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withoutCandidateUsers Only include tasks which have no candidate users. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param active Only include active tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param suspended Only include suspended tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param taskVariables Only include tasks that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param processVariables Only include tasks that belong to process instances that have variables with certain  values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param caseInstanceVariables Only include tasks that belong to case instances that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param variableNamesIgnoreCase Match all variable names in this query case-insensitively. If set &#x60;variableName&#x60; and &#x60;variablename&#x60; are treated as equal. (optional, default to false)
   * @param variableValuesIgnoreCase Match all variable values in this query case-insensitively. If set &#x60;variableValue&#x60; and &#x60;variablevalue&#x60; are treated as equal. (optional, default to false)
   * @param parentTaskId Restrict query to all tasks that are sub tasks of the given task. Takes a task id. (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return ApiResponse&lt;List&lt;TaskDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;, or if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<TaskDto>> getTasksWithHttpInfo(String processInstanceId, String processInstanceIdIn, String processInstanceBusinessKey, String processInstanceBusinessKeyExpression, String processInstanceBusinessKeyIn, String processInstanceBusinessKeyLike, String processInstanceBusinessKeyLikeExpression, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionName, String processDefinitionNameLike, String executionId, String caseInstanceId, String caseInstanceBusinessKey, String caseInstanceBusinessKeyLike, String caseDefinitionId, String caseDefinitionKey, String caseDefinitionName, String caseDefinitionNameLike, String caseExecutionId, String activityInstanceIdIn, String tenantIdIn, Boolean withoutTenantId, String assignee, String assigneeExpression, String assigneeLike, String assigneeLikeExpression, String assigneeIn, String owner, String ownerExpression, String candidateGroup, String candidateGroupExpression, String candidateUser, String candidateUserExpression, Boolean includeAssignedTasks, String involvedUser, String involvedUserExpression, Boolean assigned, Boolean unassigned, String taskDefinitionKey, String taskDefinitionKeyIn, String taskDefinitionKeyLike, String name, String nameNotEqual, String nameLike, String nameNotLike, String description, String descriptionLike, Integer priority, Integer maxPriority, Integer minPriority, String dueDate, String dueDateExpression, String dueAfter, String dueAfterExpression, String dueBefore, String dueBeforeExpression, String followUpDate, String followUpDateExpression, String followUpAfter, String followUpAfterExpression, String followUpBefore, String followUpBeforeExpression, String followUpBeforeOrNotExistent, String followUpBeforeOrNotExistentExpression, String createdOn, String createdOnExpression, String createdAfter, String createdAfterExpression, String createdBefore, String createdBeforeExpression, String delegationState, String candidateGroups, String candidateGroupsExpression, Boolean withCandidateGroups, Boolean withoutCandidateGroups, Boolean withCandidateUsers, Boolean withoutCandidateUsers, Boolean active, Boolean suspended, String taskVariables, String processVariables, String caseInstanceVariables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase, String parentTaskId, String sortBy, String sortOrder, Integer firstResult, Integer maxResults) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/task";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceId", processInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceIdIn", processInstanceIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKey", processInstanceBusinessKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyExpression", processInstanceBusinessKeyExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyIn", processInstanceBusinessKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyLike", processInstanceBusinessKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyLikeExpression", processInstanceBusinessKeyLikeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKey", processDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionName", processDefinitionName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionNameLike", processDefinitionNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executionId", executionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceId", caseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceBusinessKey", caseInstanceBusinessKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceBusinessKeyLike", caseInstanceBusinessKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseDefinitionId", caseDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseDefinitionKey", caseDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseDefinitionName", caseDefinitionName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseDefinitionNameLike", caseDefinitionNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseExecutionId", caseExecutionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityInstanceIdIn", activityInstanceIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutTenantId", withoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assignee", assignee));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigneeExpression", assigneeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigneeLike", assigneeLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigneeLikeExpression", assigneeLikeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigneeIn", assigneeIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "owner", owner));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ownerExpression", ownerExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateGroup", candidateGroup));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateGroupExpression", candidateGroupExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateUser", candidateUser));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateUserExpression", candidateUserExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "includeAssignedTasks", includeAssignedTasks));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "involvedUser", involvedUser));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "involvedUserExpression", involvedUserExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigned", assigned));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "unassigned", unassigned));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "taskDefinitionKey", taskDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "taskDefinitionKeyIn", taskDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "taskDefinitionKeyLike", taskDefinitionKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameNotEqual", nameNotEqual));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameLike", nameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameNotLike", nameNotLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "description", description));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "descriptionLike", descriptionLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "priority", priority));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxPriority", maxPriority));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "minPriority", minPriority));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueDate", dueDate));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueDateExpression", dueDateExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueAfter", dueAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueAfterExpression", dueAfterExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueBefore", dueBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueBeforeExpression", dueBeforeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpDate", followUpDate));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpDateExpression", followUpDateExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpAfter", followUpAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpAfterExpression", followUpAfterExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpBefore", followUpBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpBeforeExpression", followUpBeforeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpBeforeOrNotExistent", followUpBeforeOrNotExistent));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpBeforeOrNotExistentExpression", followUpBeforeOrNotExistentExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdOn", createdOn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdOnExpression", createdOnExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdAfter", createdAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdAfterExpression", createdAfterExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdBefore", createdBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdBeforeExpression", createdBeforeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "delegationState", delegationState));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateGroups", candidateGroups));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateGroupsExpression", candidateGroupsExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withCandidateGroups", withCandidateGroups));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutCandidateGroups", withoutCandidateGroups));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withCandidateUsers", withCandidateUsers));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutCandidateUsers", withoutCandidateUsers));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "taskVariables", taskVariables));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processVariables", processVariables));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceVariables", caseInstanceVariables));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableNamesIgnoreCase", variableNamesIgnoreCase));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableValuesIgnoreCase", variableValuesIgnoreCase));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parentTaskId", parentTaskId));
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

    GenericType<List<TaskDto>> localVarReturnType = new GenericType<List<TaskDto>>() {};

    return apiClient.invokeAPI("TaskApi.getTasks", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves the number of tasks that fulfill a provided filter. Corresponds to the size of the result set when using the [Get Tasks](https://docs.camunda.org/manual/7.14/reference/rest/task/) method.  **Security Consideration:** There are several query parameters (such as assigneeExpression) for specifying an EL expression. These are disabled by default to prevent remote code execution. See the section on [security considerations](https://docs.camunda.org/manual/7.14/user-guide/process-engine/securing-custom-code/) for custom code in the user guide for details.
   * @param processInstanceId Restrict to tasks that belong to process instances with the given id. (optional)
   * @param processInstanceIdIn Restrict to tasks that belong to process instances with the given ids. (optional)
   * @param processInstanceBusinessKey Restrict to tasks that belong to process instances with the given business key. (optional)
   * @param processInstanceBusinessKeyExpression Restrict to tasks that belong to process instances with the given business key which  is described by an expression. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. (optional)
   * @param processInstanceBusinessKeyIn Restrict to tasks that belong to process instances with one of the give business keys.  The keys need to be in a comma-separated list. (optional)
   * @param processInstanceBusinessKeyLike Restrict to tasks that have a process instance business key that has the parameter  value as a substring. (optional)
   * @param processInstanceBusinessKeyLikeExpression Restrict to tasks that have a process instance business key that has the parameter  value as a substring and is described by an expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param processDefinitionId Restrict to tasks that belong to a process definition with the given id. (optional)
   * @param processDefinitionKey Restrict to tasks that belong to a process definition with the given key. (optional)
   * @param processDefinitionKeyIn Restrict to tasks that belong to a process definition with one of the given keys. The  keys need to be in a comma-separated list. (optional)
   * @param processDefinitionName Restrict to tasks that belong to a process definition with the given name. (optional)
   * @param processDefinitionNameLike Restrict to tasks that have a process definition name that has the parameter value as  a substring. (optional)
   * @param executionId Restrict to tasks that belong to an execution with the given id. (optional)
   * @param caseInstanceId Restrict to tasks that belong to case instances with the given id. (optional)
   * @param caseInstanceBusinessKey Restrict to tasks that belong to case instances with the given business key. (optional)
   * @param caseInstanceBusinessKeyLike Restrict to tasks that have a case instance business key that has the parameter value  as a substring. (optional)
   * @param caseDefinitionId Restrict to tasks that belong to a case definition with the given id. (optional)
   * @param caseDefinitionKey Restrict to tasks that belong to a case definition with the given key. (optional)
   * @param caseDefinitionName Restrict to tasks that belong to a case definition with the given name. (optional)
   * @param caseDefinitionNameLike Restrict to tasks that have a case definition name that has the parameter value as a  substring. (optional)
   * @param caseExecutionId Restrict to tasks that belong to a case execution with the given id. (optional)
   * @param activityInstanceIdIn Only include tasks which belong to one of the passed and comma-separated activity  instance ids. (optional)
   * @param tenantIdIn Only include tasks which belong to one of the passed and comma-separated  tenant ids. (optional)
   * @param withoutTenantId Only include tasks which belong to no tenant. Value may only be &#x60;true&#x60;,  as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param assignee Restrict to tasks that the given user is assigned to. (optional)
   * @param assigneeExpression Restrict to tasks that the user described by the given expression is assigned to.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param assigneeLike Restrict to tasks that have an assignee that has the parameter  value as a substring. (optional)
   * @param assigneeLikeExpression Restrict to tasks that have an assignee that has the parameter value described by the  given expression as a substring. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param assigneeIn Only include tasks which are assigned to one of the passed and  comma-separated user ids. (optional)
   * @param owner Restrict to tasks that the given user owns. (optional)
   * @param ownerExpression Restrict to tasks that the user described by the given expression owns. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param candidateGroup Only include tasks that are offered to the given group. (optional)
   * @param candidateGroupExpression Only include tasks that are offered to the group described by the given expression.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param candidateUser Only include tasks that are offered to the given user or to one of his groups. (optional)
   * @param candidateUserExpression Only include tasks that are offered to the user described by the given expression.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param includeAssignedTasks Also include tasks that are assigned to users in candidate queries. Default is to only  include tasks that are not assigned to any user if you query by candidate user or group(s). (optional, default to false)
   * @param involvedUser Only include tasks that the given user is involved in. A user is involved in a task if  an identity link exists between task and user (e.g., the user is the assignee). (optional)
   * @param involvedUserExpression Only include tasks that the user described by the given expression is involved in. A user is involved in a task if an identity link exists between task and user (e.g., the user is the assignee). See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. (optional)
   * @param assigned If set to &#x60;true&#x60;, restricts the query to all tasks that are assigned. (optional, default to false)
   * @param unassigned If set to &#x60;true&#x60;, restricts the query to all tasks that are unassigned. (optional, default to false)
   * @param taskDefinitionKey Restrict to tasks that have the given key. (optional)
   * @param taskDefinitionKeyIn Restrict to tasks that have one of the given keys. The keys need to be in a comma-separated list. (optional)
   * @param taskDefinitionKeyLike Restrict to tasks that have a key that has the parameter value as a substring. (optional)
   * @param name Restrict to tasks that have the given name. (optional)
   * @param nameNotEqual Restrict to tasks that do not have the given name. (optional)
   * @param nameLike Restrict to tasks that have a name with the given parameter value as substring. (optional)
   * @param nameNotLike Restrict to tasks that do not have a name with the given parameter value as substring. (optional)
   * @param description Restrict to tasks that have the given description. (optional)
   * @param descriptionLike Restrict to tasks that have a description that has the parameter value as a substring. (optional)
   * @param priority Restrict to tasks that have the given priority. (optional)
   * @param maxPriority Restrict to tasks that have a lower or equal priority. (optional)
   * @param minPriority Restrict to tasks that have a higher or equal priority. (optional)
   * @param dueDate Restrict to tasks that are due on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param dueDateExpression Restrict to tasks that are due on the date described by the given expression. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param dueAfter Restrict to tasks that are due after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.435+0200&#x60;. (optional)
   * @param dueAfterExpression Restrict to tasks that are due after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param dueBefore Restrict to tasks that are due before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.243+0200&#x60;. (optional)
   * @param dueBeforeExpression Restrict to tasks that are due before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpDate Restrict to tasks that have a followUp date on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.342+0200&#x60;. (optional)
   * @param followUpDateExpression Restrict to tasks that have a followUp date on the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpAfter Restrict to tasks that have a followUp date after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.542+0200&#x60;. (optional)
   * @param followUpAfterExpression Restrict to tasks that have a followUp date after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpBefore Restrict to tasks that have a followUp date before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.234+0200&#x60;. (optional)
   * @param followUpBeforeExpression Restrict to tasks that have a followUp date before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpBeforeOrNotExistent Restrict to tasks that have no followUp date or a followUp date before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.432+0200&#x60;. The typical use case is to query all &#x60;active&#x60; tasks for a user for a given date. (optional)
   * @param followUpBeforeOrNotExistentExpression Restrict to tasks that have no followUp date or a followUp date before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdOn Restrict to tasks that were created on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.324+0200&#x60;. (optional)
   * @param createdOnExpression Restrict to tasks that were created on the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdAfter Restrict to tasks that were created after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.342+0200&#x60;. (optional)
   * @param createdAfterExpression Restrict to tasks that were created after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdBefore Restrict to tasks that were created before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.332+0200&#x60;. (optional)
   * @param createdBeforeExpression Restrict to tasks that were created before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param delegationState Restrict to tasks that are in the given delegation state. Valid values are &#x60;PENDING&#x60; and &#x60;RESOLVED&#x60;. (optional)
   * @param candidateGroups Restrict to tasks that are offered to any of the given candidate groups. Takes a comma-separated list of group names, so for example &#x60;developers,support,sales&#x60;. (optional)
   * @param candidateGroupsExpression Restrict to tasks that are offered to any of the candidate groups described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to &#x60;java.util.List&#x60; of Strings. (optional)
   * @param withCandidateGroups Only include tasks which have a candidate group. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withoutCandidateGroups Only include tasks which have no candidate group. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withCandidateUsers Only include tasks which have a candidate user. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withoutCandidateUsers Only include tasks which have no candidate users. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param active Only include active tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param suspended Only include suspended tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param taskVariables Only include tasks that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param processVariables Only include tasks that belong to process instances that have variables with certain  values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param caseInstanceVariables Only include tasks that belong to case instances that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param variableNamesIgnoreCase Match all variable names in this query case-insensitively. If set &#x60;variableName&#x60; and &#x60;variablename&#x60; are treated as equal. (optional, default to false)
   * @param variableValuesIgnoreCase Match all variable values in this query case-insensitively. If set &#x60;variableValue&#x60; and &#x60;variablevalue&#x60; are treated as equal. (optional, default to false)
   * @param parentTaskId Restrict query to all tasks that are sub tasks of the given task. Takes a task id. (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto getTasksCount(String processInstanceId, String processInstanceIdIn, String processInstanceBusinessKey, String processInstanceBusinessKeyExpression, String processInstanceBusinessKeyIn, String processInstanceBusinessKeyLike, String processInstanceBusinessKeyLikeExpression, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionName, String processDefinitionNameLike, String executionId, String caseInstanceId, String caseInstanceBusinessKey, String caseInstanceBusinessKeyLike, String caseDefinitionId, String caseDefinitionKey, String caseDefinitionName, String caseDefinitionNameLike, String caseExecutionId, String activityInstanceIdIn, String tenantIdIn, Boolean withoutTenantId, String assignee, String assigneeExpression, String assigneeLike, String assigneeLikeExpression, String assigneeIn, String owner, String ownerExpression, String candidateGroup, String candidateGroupExpression, String candidateUser, String candidateUserExpression, Boolean includeAssignedTasks, String involvedUser, String involvedUserExpression, Boolean assigned, Boolean unassigned, String taskDefinitionKey, String taskDefinitionKeyIn, String taskDefinitionKeyLike, String name, String nameNotEqual, String nameLike, String nameNotLike, String description, String descriptionLike, Integer priority, Integer maxPriority, Integer minPriority, String dueDate, String dueDateExpression, String dueAfter, String dueAfterExpression, String dueBefore, String dueBeforeExpression, String followUpDate, String followUpDateExpression, String followUpAfter, String followUpAfterExpression, String followUpBefore, String followUpBeforeExpression, String followUpBeforeOrNotExistent, String followUpBeforeOrNotExistentExpression, String createdOn, String createdOnExpression, String createdAfter, String createdAfterExpression, String createdBefore, String createdBeforeExpression, String delegationState, String candidateGroups, String candidateGroupsExpression, Boolean withCandidateGroups, Boolean withoutCandidateGroups, Boolean withCandidateUsers, Boolean withoutCandidateUsers, Boolean active, Boolean suspended, String taskVariables, String processVariables, String caseInstanceVariables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase, String parentTaskId) throws ApiException {
    return getTasksCountWithHttpInfo(processInstanceId, processInstanceIdIn, processInstanceBusinessKey, processInstanceBusinessKeyExpression, processInstanceBusinessKeyIn, processInstanceBusinessKeyLike, processInstanceBusinessKeyLikeExpression, processDefinitionId, processDefinitionKey, processDefinitionKeyIn, processDefinitionName, processDefinitionNameLike, executionId, caseInstanceId, caseInstanceBusinessKey, caseInstanceBusinessKeyLike, caseDefinitionId, caseDefinitionKey, caseDefinitionName, caseDefinitionNameLike, caseExecutionId, activityInstanceIdIn, tenantIdIn, withoutTenantId, assignee, assigneeExpression, assigneeLike, assigneeLikeExpression, assigneeIn, owner, ownerExpression, candidateGroup, candidateGroupExpression, candidateUser, candidateUserExpression, includeAssignedTasks, involvedUser, involvedUserExpression, assigned, unassigned, taskDefinitionKey, taskDefinitionKeyIn, taskDefinitionKeyLike, name, nameNotEqual, nameLike, nameNotLike, description, descriptionLike, priority, maxPriority, minPriority, dueDate, dueDateExpression, dueAfter, dueAfterExpression, dueBefore, dueBeforeExpression, followUpDate, followUpDateExpression, followUpAfter, followUpAfterExpression, followUpBefore, followUpBeforeExpression, followUpBeforeOrNotExistent, followUpBeforeOrNotExistentExpression, createdOn, createdOnExpression, createdAfter, createdAfterExpression, createdBefore, createdBeforeExpression, delegationState, candidateGroups, candidateGroupsExpression, withCandidateGroups, withoutCandidateGroups, withCandidateUsers, withoutCandidateUsers, active, suspended, taskVariables, processVariables, caseInstanceVariables, variableNamesIgnoreCase, variableValuesIgnoreCase, parentTaskId).getData();
  }

  /**
   * 
   * Retrieves the number of tasks that fulfill a provided filter. Corresponds to the size of the result set when using the [Get Tasks](https://docs.camunda.org/manual/7.14/reference/rest/task/) method.  **Security Consideration:** There are several query parameters (such as assigneeExpression) for specifying an EL expression. These are disabled by default to prevent remote code execution. See the section on [security considerations](https://docs.camunda.org/manual/7.14/user-guide/process-engine/securing-custom-code/) for custom code in the user guide for details.
   * @param processInstanceId Restrict to tasks that belong to process instances with the given id. (optional)
   * @param processInstanceIdIn Restrict to tasks that belong to process instances with the given ids. (optional)
   * @param processInstanceBusinessKey Restrict to tasks that belong to process instances with the given business key. (optional)
   * @param processInstanceBusinessKeyExpression Restrict to tasks that belong to process instances with the given business key which  is described by an expression. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. (optional)
   * @param processInstanceBusinessKeyIn Restrict to tasks that belong to process instances with one of the give business keys.  The keys need to be in a comma-separated list. (optional)
   * @param processInstanceBusinessKeyLike Restrict to tasks that have a process instance business key that has the parameter  value as a substring. (optional)
   * @param processInstanceBusinessKeyLikeExpression Restrict to tasks that have a process instance business key that has the parameter  value as a substring and is described by an expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param processDefinitionId Restrict to tasks that belong to a process definition with the given id. (optional)
   * @param processDefinitionKey Restrict to tasks that belong to a process definition with the given key. (optional)
   * @param processDefinitionKeyIn Restrict to tasks that belong to a process definition with one of the given keys. The  keys need to be in a comma-separated list. (optional)
   * @param processDefinitionName Restrict to tasks that belong to a process definition with the given name. (optional)
   * @param processDefinitionNameLike Restrict to tasks that have a process definition name that has the parameter value as  a substring. (optional)
   * @param executionId Restrict to tasks that belong to an execution with the given id. (optional)
   * @param caseInstanceId Restrict to tasks that belong to case instances with the given id. (optional)
   * @param caseInstanceBusinessKey Restrict to tasks that belong to case instances with the given business key. (optional)
   * @param caseInstanceBusinessKeyLike Restrict to tasks that have a case instance business key that has the parameter value  as a substring. (optional)
   * @param caseDefinitionId Restrict to tasks that belong to a case definition with the given id. (optional)
   * @param caseDefinitionKey Restrict to tasks that belong to a case definition with the given key. (optional)
   * @param caseDefinitionName Restrict to tasks that belong to a case definition with the given name. (optional)
   * @param caseDefinitionNameLike Restrict to tasks that have a case definition name that has the parameter value as a  substring. (optional)
   * @param caseExecutionId Restrict to tasks that belong to a case execution with the given id. (optional)
   * @param activityInstanceIdIn Only include tasks which belong to one of the passed and comma-separated activity  instance ids. (optional)
   * @param tenantIdIn Only include tasks which belong to one of the passed and comma-separated  tenant ids. (optional)
   * @param withoutTenantId Only include tasks which belong to no tenant. Value may only be &#x60;true&#x60;,  as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param assignee Restrict to tasks that the given user is assigned to. (optional)
   * @param assigneeExpression Restrict to tasks that the user described by the given expression is assigned to.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param assigneeLike Restrict to tasks that have an assignee that has the parameter  value as a substring. (optional)
   * @param assigneeLikeExpression Restrict to tasks that have an assignee that has the parameter value described by the  given expression as a substring. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param assigneeIn Only include tasks which are assigned to one of the passed and  comma-separated user ids. (optional)
   * @param owner Restrict to tasks that the given user owns. (optional)
   * @param ownerExpression Restrict to tasks that the user described by the given expression owns. See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param candidateGroup Only include tasks that are offered to the given group. (optional)
   * @param candidateGroupExpression Only include tasks that are offered to the group described by the given expression.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param candidateUser Only include tasks that are offered to the given user or to one of his groups. (optional)
   * @param candidateUserExpression Only include tasks that are offered to the user described by the given expression.  See the  [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions)  for more information on available functions. (optional)
   * @param includeAssignedTasks Also include tasks that are assigned to users in candidate queries. Default is to only  include tasks that are not assigned to any user if you query by candidate user or group(s). (optional, default to false)
   * @param involvedUser Only include tasks that the given user is involved in. A user is involved in a task if  an identity link exists between task and user (e.g., the user is the assignee). (optional)
   * @param involvedUserExpression Only include tasks that the user described by the given expression is involved in. A user is involved in a task if an identity link exists between task and user (e.g., the user is the assignee). See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. (optional)
   * @param assigned If set to &#x60;true&#x60;, restricts the query to all tasks that are assigned. (optional, default to false)
   * @param unassigned If set to &#x60;true&#x60;, restricts the query to all tasks that are unassigned. (optional, default to false)
   * @param taskDefinitionKey Restrict to tasks that have the given key. (optional)
   * @param taskDefinitionKeyIn Restrict to tasks that have one of the given keys. The keys need to be in a comma-separated list. (optional)
   * @param taskDefinitionKeyLike Restrict to tasks that have a key that has the parameter value as a substring. (optional)
   * @param name Restrict to tasks that have the given name. (optional)
   * @param nameNotEqual Restrict to tasks that do not have the given name. (optional)
   * @param nameLike Restrict to tasks that have a name with the given parameter value as substring. (optional)
   * @param nameNotLike Restrict to tasks that do not have a name with the given parameter value as substring. (optional)
   * @param description Restrict to tasks that have the given description. (optional)
   * @param descriptionLike Restrict to tasks that have a description that has the parameter value as a substring. (optional)
   * @param priority Restrict to tasks that have the given priority. (optional)
   * @param maxPriority Restrict to tasks that have a lower or equal priority. (optional)
   * @param minPriority Restrict to tasks that have a higher or equal priority. (optional)
   * @param dueDate Restrict to tasks that are due on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param dueDateExpression Restrict to tasks that are due on the date described by the given expression. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param dueAfter Restrict to tasks that are due after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.435+0200&#x60;. (optional)
   * @param dueAfterExpression Restrict to tasks that are due after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param dueBefore Restrict to tasks that are due before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.243+0200&#x60;. (optional)
   * @param dueBeforeExpression Restrict to tasks that are due before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpDate Restrict to tasks that have a followUp date on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.342+0200&#x60;. (optional)
   * @param followUpDateExpression Restrict to tasks that have a followUp date on the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpAfter Restrict to tasks that have a followUp date after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.542+0200&#x60;. (optional)
   * @param followUpAfterExpression Restrict to tasks that have a followUp date after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpBefore Restrict to tasks that have a followUp date before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.234+0200&#x60;. (optional)
   * @param followUpBeforeExpression Restrict to tasks that have a followUp date before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param followUpBeforeOrNotExistent Restrict to tasks that have no followUp date or a followUp date before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.432+0200&#x60;. The typical use case is to query all &#x60;active&#x60; tasks for a user for a given date. (optional)
   * @param followUpBeforeOrNotExistentExpression Restrict to tasks that have no followUp date or a followUp date before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdOn Restrict to tasks that were created on the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.324+0200&#x60;. (optional)
   * @param createdOnExpression Restrict to tasks that were created on the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdAfter Restrict to tasks that were created after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.342+0200&#x60;. (optional)
   * @param createdAfterExpression Restrict to tasks that were created after the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param createdBefore Restrict to tasks that were created before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.332+0200&#x60;. (optional)
   * @param createdBeforeExpression Restrict to tasks that were created before the date described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to a &#x60;java.util.Date&#x60; or &#x60;org.joda.time.DateTime&#x60; object. (optional)
   * @param delegationState Restrict to tasks that are in the given delegation state. Valid values are &#x60;PENDING&#x60; and &#x60;RESOLVED&#x60;. (optional)
   * @param candidateGroups Restrict to tasks that are offered to any of the given candidate groups. Takes a comma-separated list of group names, so for example &#x60;developers,support,sales&#x60;. (optional)
   * @param candidateGroupsExpression Restrict to tasks that are offered to any of the candidate groups described by the given expression. See the [user guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/expression-language/#internal-context-functions) for more information on available functions. The expression must evaluate to &#x60;java.util.List&#x60; of Strings. (optional)
   * @param withCandidateGroups Only include tasks which have a candidate group. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withoutCandidateGroups Only include tasks which have no candidate group. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withCandidateUsers Only include tasks which have a candidate user. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param withoutCandidateUsers Only include tasks which have no candidate users. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param active Only include active tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param suspended Only include suspended tasks. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional, default to false)
   * @param taskVariables Only include tasks that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param processVariables Only include tasks that belong to process instances that have variables with certain  values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param caseInstanceVariables Only include tasks that belong to case instances that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param variableNamesIgnoreCase Match all variable names in this query case-insensitively. If set &#x60;variableName&#x60; and &#x60;variablename&#x60; are treated as equal. (optional, default to false)
   * @param variableValuesIgnoreCase Match all variable values in this query case-insensitively. If set &#x60;variableValue&#x60; and &#x60;variablevalue&#x60; are treated as equal. (optional, default to false)
   * @param parentTaskId Restrict query to all tasks that are sub tasks of the given task. Takes a task id. (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> getTasksCountWithHttpInfo(String processInstanceId, String processInstanceIdIn, String processInstanceBusinessKey, String processInstanceBusinessKeyExpression, String processInstanceBusinessKeyIn, String processInstanceBusinessKeyLike, String processInstanceBusinessKeyLikeExpression, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionName, String processDefinitionNameLike, String executionId, String caseInstanceId, String caseInstanceBusinessKey, String caseInstanceBusinessKeyLike, String caseDefinitionId, String caseDefinitionKey, String caseDefinitionName, String caseDefinitionNameLike, String caseExecutionId, String activityInstanceIdIn, String tenantIdIn, Boolean withoutTenantId, String assignee, String assigneeExpression, String assigneeLike, String assigneeLikeExpression, String assigneeIn, String owner, String ownerExpression, String candidateGroup, String candidateGroupExpression, String candidateUser, String candidateUserExpression, Boolean includeAssignedTasks, String involvedUser, String involvedUserExpression, Boolean assigned, Boolean unassigned, String taskDefinitionKey, String taskDefinitionKeyIn, String taskDefinitionKeyLike, String name, String nameNotEqual, String nameLike, String nameNotLike, String description, String descriptionLike, Integer priority, Integer maxPriority, Integer minPriority, String dueDate, String dueDateExpression, String dueAfter, String dueAfterExpression, String dueBefore, String dueBeforeExpression, String followUpDate, String followUpDateExpression, String followUpAfter, String followUpAfterExpression, String followUpBefore, String followUpBeforeExpression, String followUpBeforeOrNotExistent, String followUpBeforeOrNotExistentExpression, String createdOn, String createdOnExpression, String createdAfter, String createdAfterExpression, String createdBefore, String createdBeforeExpression, String delegationState, String candidateGroups, String candidateGroupsExpression, Boolean withCandidateGroups, Boolean withoutCandidateGroups, Boolean withCandidateUsers, Boolean withoutCandidateUsers, Boolean active, Boolean suspended, String taskVariables, String processVariables, String caseInstanceVariables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase, String parentTaskId) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/task/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceId", processInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceIdIn", processInstanceIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKey", processInstanceBusinessKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyExpression", processInstanceBusinessKeyExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyIn", processInstanceBusinessKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyLike", processInstanceBusinessKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyLikeExpression", processInstanceBusinessKeyLikeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKey", processDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionName", processDefinitionName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionNameLike", processDefinitionNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executionId", executionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceId", caseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceBusinessKey", caseInstanceBusinessKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceBusinessKeyLike", caseInstanceBusinessKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseDefinitionId", caseDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseDefinitionKey", caseDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseDefinitionName", caseDefinitionName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseDefinitionNameLike", caseDefinitionNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseExecutionId", caseExecutionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityInstanceIdIn", activityInstanceIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutTenantId", withoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assignee", assignee));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigneeExpression", assigneeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigneeLike", assigneeLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigneeLikeExpression", assigneeLikeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigneeIn", assigneeIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "owner", owner));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "ownerExpression", ownerExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateGroup", candidateGroup));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateGroupExpression", candidateGroupExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateUser", candidateUser));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateUserExpression", candidateUserExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "includeAssignedTasks", includeAssignedTasks));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "involvedUser", involvedUser));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "involvedUserExpression", involvedUserExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "assigned", assigned));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "unassigned", unassigned));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "taskDefinitionKey", taskDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "taskDefinitionKeyIn", taskDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "taskDefinitionKeyLike", taskDefinitionKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameNotEqual", nameNotEqual));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameLike", nameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameNotLike", nameNotLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "description", description));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "descriptionLike", descriptionLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "priority", priority));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxPriority", maxPriority));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "minPriority", minPriority));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueDate", dueDate));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueDateExpression", dueDateExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueAfter", dueAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueAfterExpression", dueAfterExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueBefore", dueBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "dueBeforeExpression", dueBeforeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpDate", followUpDate));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpDateExpression", followUpDateExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpAfter", followUpAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpAfterExpression", followUpAfterExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpBefore", followUpBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpBeforeExpression", followUpBeforeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpBeforeOrNotExistent", followUpBeforeOrNotExistent));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "followUpBeforeOrNotExistentExpression", followUpBeforeOrNotExistentExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdOn", createdOn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdOnExpression", createdOnExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdAfter", createdAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdAfterExpression", createdAfterExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdBefore", createdBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "createdBeforeExpression", createdBeforeExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "delegationState", delegationState));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateGroups", candidateGroups));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "candidateGroupsExpression", candidateGroupsExpression));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withCandidateGroups", withCandidateGroups));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutCandidateGroups", withoutCandidateGroups));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withCandidateUsers", withCandidateUsers));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutCandidateUsers", withoutCandidateUsers));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "taskVariables", taskVariables));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processVariables", processVariables));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceVariables", caseInstanceVariables));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableNamesIgnoreCase", variableNamesIgnoreCase));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableValuesIgnoreCase", variableValuesIgnoreCase));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "parentTaskId", parentTaskId));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<CountResultDto> localVarReturnType = new GenericType<CountResultDto>() {};

    return apiClient.invokeAPI("TaskApi.getTasksCount", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Reports a business error in the context of a running task by id. The error code must be specified to identify the BPMN error handler. See the documentation for [Reporting Bpmn Error](https://docs.camunda.org/manual/7.14/reference/bpmn20/tasks/user-task/#reporting-bpmn-error) in User Tasks.
   * @param id The id of the task a BPMN error is reported for. (required)
   * @param taskBpmnErrorDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> If the authenticated user is unauthorized to update the process instance. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist or &lt;code&gt;errorCode&lt;/code&gt; is not presented in the request. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void handleBpmnError(String id, TaskBpmnErrorDto taskBpmnErrorDto) throws ApiException {
    handleBpmnErrorWithHttpInfo(id, taskBpmnErrorDto);
  }

  /**
   * 
   * Reports a business error in the context of a running task by id. The error code must be specified to identify the BPMN error handler. See the documentation for [Reporting Bpmn Error](https://docs.camunda.org/manual/7.14/reference/bpmn20/tasks/user-task/#reporting-bpmn-error) in User Tasks.
   * @param id The id of the task a BPMN error is reported for. (required)
   * @param taskBpmnErrorDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> If the authenticated user is unauthorized to update the process instance. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist or &lt;code&gt;errorCode&lt;/code&gt; is not presented in the request. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> handleBpmnErrorWithHttpInfo(String id, TaskBpmnErrorDto taskBpmnErrorDto) throws ApiException {
    Object localVarPostBody = taskBpmnErrorDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling handleBpmnError");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/bpmnError"
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

    return apiClient.invokeAPI("TaskApi.handleBpmnError", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Reports an escalation in the context of a running task by id. The escalation code must be specified to identify the escalation handler. See the documentation for [Reporting Bpmn Escalation](https://docs.camunda.org/manual/7.14/reference/bpmn20/tasks/user-task/#reporting-bpmn-escalation) in User Tasks.
   * @param id The id of the task in which context a BPMN escalation is reported. (required)
   * @param taskEscalationDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> If the authenticated user is unauthorized to update the process instance. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist or &lt;code&gt;errorCode&lt;/code&gt; is not presented in the request. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void handleEscalation(String id, TaskEscalationDto taskEscalationDto) throws ApiException {
    handleEscalationWithHttpInfo(id, taskEscalationDto);
  }

  /**
   * 
   * Reports an escalation in the context of a running task by id. The escalation code must be specified to identify the escalation handler. See the documentation for [Reporting Bpmn Escalation](https://docs.camunda.org/manual/7.14/reference/bpmn20/tasks/user-task/#reporting-bpmn-escalation) in User Tasks.
   * @param id The id of the task in which context a BPMN escalation is reported. (required)
   * @param taskEscalationDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> If the authenticated user is unauthorized to update the process instance. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if the task does not exist or &lt;code&gt;errorCode&lt;/code&gt; is not presented in the request. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> handleEscalationWithHttpInfo(String id, TaskEscalationDto taskEscalationDto) throws ApiException {
    Object localVarPostBody = taskEscalationDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling handleEscalation");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/bpmnEscalation"
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

    return apiClient.invokeAPI("TaskApi.handleEscalation", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Queries for tasks that fulfill a given filter. This method is slightly more powerful than the [Get Tasks](https://docs.camunda.org/manual/7.14/reference/rest/task/get-query/) method because it allows filtering by multiple process or task variables of types &#x60;String&#x60;, &#x60;Number&#x60; or &#x60;Boolean&#x60;. The size of the result set can be retrieved by using the [Get Task Count (POST)](https://docs.camunda.org/manual/7.14/reference/rest/task/post-query-count/) method.  **Security Consideration**: There are several parameters (such as &#x60;assigneeExpression&#x60;) for specifying an EL expression. These are disabled by default to prevent remote code execution. See the section on [security considerations for custom code](https://docs.camunda.org/manual/7.14/user-guide/process-engine/securing-custom-code/) in the user guide for details.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param taskQueryDto  (optional)
   * @return List&lt;TaskDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;, or if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<TaskDto> queryTasks(Integer firstResult, Integer maxResults, TaskQueryDto taskQueryDto) throws ApiException {
    return queryTasksWithHttpInfo(firstResult, maxResults, taskQueryDto).getData();
  }

  /**
   * 
   * Queries for tasks that fulfill a given filter. This method is slightly more powerful than the [Get Tasks](https://docs.camunda.org/manual/7.14/reference/rest/task/get-query/) method because it allows filtering by multiple process or task variables of types &#x60;String&#x60;, &#x60;Number&#x60; or &#x60;Boolean&#x60;. The size of the result set can be retrieved by using the [Get Task Count (POST)](https://docs.camunda.org/manual/7.14/reference/rest/task/post-query-count/) method.  **Security Consideration**: There are several parameters (such as &#x60;assigneeExpression&#x60;) for specifying an EL expression. These are disabled by default to prevent remote code execution. See the section on [security considerations for custom code](https://docs.camunda.org/manual/7.14/user-guide/process-engine/securing-custom-code/) in the user guide for details.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param taskQueryDto  (optional)
   * @return ApiResponse&lt;List&lt;TaskDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;, or if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<TaskDto>> queryTasksWithHttpInfo(Integer firstResult, Integer maxResults, TaskQueryDto taskQueryDto) throws ApiException {
    Object localVarPostBody = taskQueryDto;
    
    // create path and map variables
    String localVarPath = "/task";

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

    GenericType<List<TaskDto>> localVarReturnType = new GenericType<List<TaskDto>>() {};

    return apiClient.invokeAPI("TaskApi.queryTasks", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves the number of tasks that fulfill the given filter. Corresponds to the size of the result set of the [Get Tasks (POST)](https://docs.camunda.org/manual/7.14/reference/rest/task/post-query/) method and takes the same parameters.  **Security Consideration**: There are several parameters (such as &#x60;assigneeExpression&#x60;) for specifying an EL expression. These are disabled by default to prevent remote code execution. See the section on [security considerations for custom code](https://docs.camunda.org/manual/7.14/user-guide/process-engine/securing-custom-code/) in the user guide for details.
   * @param taskQueryDto  (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto queryTasksCount(TaskQueryDto taskQueryDto) throws ApiException {
    return queryTasksCountWithHttpInfo(taskQueryDto).getData();
  }

  /**
   * 
   * Retrieves the number of tasks that fulfill the given filter. Corresponds to the size of the result set of the [Get Tasks (POST)](https://docs.camunda.org/manual/7.14/reference/rest/task/post-query/) method and takes the same parameters.  **Security Consideration**: There are several parameters (such as &#x60;assigneeExpression&#x60;) for specifying an EL expression. These are disabled by default to prevent remote code execution. See the section on [security considerations for custom code](https://docs.camunda.org/manual/7.14/user-guide/process-engine/securing-custom-code/) in the user guide for details.
   * @param taskQueryDto  (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> queryTasksCountWithHttpInfo(TaskQueryDto taskQueryDto) throws ApiException {
    Object localVarPostBody = taskQueryDto;
    
    // create path and map variables
    String localVarPath = "/task/count";

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

    return apiClient.invokeAPI("TaskApi.queryTasksCount", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Resolves a task and updates execution variables.  Resolving a task marks that the assignee is done with the task delegated to them, and that it can be sent back to the owner. Can only be executed when the task has been delegated. The assignee will be set to the owner, who performed the delegation.
   * @param id The id of the task to resolve. (required)
   * @param completeTaskDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> If the task does not exist or the corresponding process instance could not be resumed successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void resolve(String id, CompleteTaskDto completeTaskDto) throws ApiException {
    resolveWithHttpInfo(id, completeTaskDto);
  }

  /**
   * 
   * Resolves a task and updates execution variables.  Resolving a task marks that the assignee is done with the task delegated to them, and that it can be sent back to the owner. Can only be executed when the task has been delegated. The assignee will be set to the owner, who performed the delegation.
   * @param id The id of the task to resolve. (required)
   * @param completeTaskDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> If the task does not exist or the corresponding process instance could not be resumed successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> resolveWithHttpInfo(String id, CompleteTaskDto completeTaskDto) throws ApiException {
    Object localVarPostBody = completeTaskDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling resolve");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/resolve"
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

    return apiClient.invokeAPI("TaskApi.resolve", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Changes the assignee of a task to a specific user.  **Note:** The difference with the [Claim Task](https://docs.camunda.org/manual/7.14/reference/rest/task/post-claim/) method is that this method does not check if the task already has a user assigned to it.
   * @param id The id of the task to set the assignee for. (required)
   * @param userIdDto Provide the id of the user that will be the assignee of the task. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task with given id does not exist or setting the assignee was not successful. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void setAssignee(String id, UserIdDto userIdDto) throws ApiException {
    setAssigneeWithHttpInfo(id, userIdDto);
  }

  /**
   * 
   * Changes the assignee of a task to a specific user.  **Note:** The difference with the [Claim Task](https://docs.camunda.org/manual/7.14/reference/rest/task/post-claim/) method is that this method does not check if the task already has a user assigned to it.
   * @param id The id of the task to set the assignee for. (required)
   * @param userIdDto Provide the id of the user that will be the assignee of the task. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task with given id does not exist or setting the assignee was not successful. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setAssigneeWithHttpInfo(String id, UserIdDto userIdDto) throws ApiException {
    Object localVarPostBody = userIdDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling setAssignee");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/assignee"
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

    return apiClient.invokeAPI("TaskApi.setAssignee", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Completes a task and updates process variables using a form submit. There are two difference between this method and the &#x60;complete&#x60; method:  * If the task is in state &#x60;PENDING&#x60; - i.e., has been delegated before, it is not completed but resolved. Otherwise it will be completed. * If the task has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See the [Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/_index/#generated-task-forms) section of the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/) for more information.
   * @param id The id of the task to submit the form for. (required)
   * @param completeTaskDto  (optional)
   * @return Map&lt;String, VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The response contains the process variables. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> Request successful. The response contains no variables. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> If the task does not exist or the corresponding process instance could not be resumed successfully.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, VariableValueDto> submit(String id, CompleteTaskDto completeTaskDto) throws ApiException {
    return submitWithHttpInfo(id, completeTaskDto).getData();
  }

  /**
   * 
   * Completes a task and updates process variables using a form submit. There are two difference between this method and the &#x60;complete&#x60; method:  * If the task is in state &#x60;PENDING&#x60; - i.e., has been delegated before, it is not completed but resolved. Otherwise it will be completed. * If the task has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See the [Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/_index/#generated-task-forms) section of the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/) for more information.
   * @param id The id of the task to submit the form for. (required)
   * @param completeTaskDto  (optional)
   * @return ApiResponse&lt;Map&lt;String, VariableValueDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The response contains the process variables. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> Request successful. The response contains no variables. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> If the task does not exist or the corresponding process instance could not be resumed successfully.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, VariableValueDto>> submitWithHttpInfo(String id, CompleteTaskDto completeTaskDto) throws ApiException {
    Object localVarPostBody = completeTaskDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling submit");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/submit-form"
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

    GenericType<Map<String, VariableValueDto>> localVarReturnType = new GenericType<Map<String, VariableValueDto>>() {};

    return apiClient.invokeAPI("TaskApi.submit", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Resets a task&#39;s assignee. If successful, the task is not assigned to a user.
   * @param id The id of the task to unclaim. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The Task with the given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void unclaim(String id) throws ApiException {
    unclaimWithHttpInfo(id);
  }

  /**
   * 
   * Resets a task&#39;s assignee. If successful, the task is not assigned to a user.
   * @param id The id of the task to unclaim. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The Task with the given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> unclaimWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling unclaim");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/unclaim"
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

    return apiClient.invokeAPI("TaskApi.unclaim", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Updates a task.
   * @param id The id of the task to be updated. (required)
   * @param taskDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if a not valid &#x60;delegationState&#x60; is supplied. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> If the corresponding task cannot be found. </td><td>  -  </td></tr>
     </table>
   */
  public void updateTask(String id, TaskDto taskDto) throws ApiException {
    updateTaskWithHttpInfo(id, taskDto);
  }

  /**
   * 
   * Updates a task.
   * @param id The id of the task to be updated. (required)
   * @param taskDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if a not valid &#x60;delegationState&#x60; is supplied. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> If the corresponding task cannot be found. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateTaskWithHttpInfo(String id, TaskDto taskDto) throws ApiException {
    Object localVarPostBody = taskDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateTask");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}"
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

    return apiClient.invokeAPI("TaskApi.updateTask", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
