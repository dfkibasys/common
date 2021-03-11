package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.ActivityInstanceDto;
import de.dfki.cos.basys.common.rest.camunda.dto.AuthorizationExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.BatchDto;
import de.dfki.cos.basys.common.rest.camunda.dto.CountResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.DeleteProcessInstancesDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import java.io.File;
import de.dfki.cos.basys.common.rest.camunda.dto.PatchVariablesDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessInstanceDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessInstanceModificationDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessInstanceQueryDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessInstanceSuspensionStateAsyncDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessInstanceSuspensionStateDto;
import de.dfki.cos.basys.common.rest.camunda.dto.SetJobRetriesByProcessDto;
import de.dfki.cos.basys.common.rest.camunda.dto.SetVariablesAsyncDto;
import de.dfki.cos.basys.common.rest.camunda.dto.SuspensionStateDto;
import de.dfki.cos.basys.common.rest.camunda.dto.VariableValueDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class ProcessInstanceApi {
  private ApiClient apiClient;

  public ProcessInstanceApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProcessInstanceApi(ApiClient apiClient) {
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
   * Deletes a set of process instances asynchronously (batch) based on a historic process instance query.
   * @param deleteProcessInstancesDto **Unallowed property**: &#x60;processInstanceQuery&#x60; (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, i.e., neither processInstanceIds, nor historicProcessInstanceQuery is present </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto deleteAsyncHistoricQueryBased(DeleteProcessInstancesDto deleteProcessInstancesDto) throws ApiException {
    return deleteAsyncHistoricQueryBasedWithHttpInfo(deleteProcessInstancesDto).getData();
  }

  /**
   * 
   * Deletes a set of process instances asynchronously (batch) based on a historic process instance query.
   * @param deleteProcessInstancesDto **Unallowed property**: &#x60;processInstanceQuery&#x60; (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, i.e., neither processInstanceIds, nor historicProcessInstanceQuery is present </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> deleteAsyncHistoricQueryBasedWithHttpInfo(DeleteProcessInstancesDto deleteProcessInstancesDto) throws ApiException {
    Object localVarPostBody = deleteProcessInstancesDto;
    
    // create path and map variables
    String localVarPath = "/process-instance/delete-historic-query-based";

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

    return apiClient.invokeAPI("ProcessInstanceApi.deleteAsyncHistoricQueryBased", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Deletes a running process instance by id.
   * @param id The id of the process instance to be deleted. (required)
   * @param skipCustomListeners If set to true, the custom listeners will be skipped. (optional, default to false)
   * @param skipIoMappings If set to true, the input/output mappings will be skipped. (optional, default to false)
   * @param skipSubprocesses If set to true, subprocesses related to deleted processes will be skipped. (optional, default to false)
   * @param failIfNotExists If set to false, the request will still be successful if the process id is not found. (optional, default to true)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Process instance with given id does not exist.  </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProcessInstance(String id, Boolean skipCustomListeners, Boolean skipIoMappings, Boolean skipSubprocesses, Boolean failIfNotExists) throws ApiException {
    deleteProcessInstanceWithHttpInfo(id, skipCustomListeners, skipIoMappings, skipSubprocesses, failIfNotExists);
  }

  /**
   * 
   * Deletes a running process instance by id.
   * @param id The id of the process instance to be deleted. (required)
   * @param skipCustomListeners If set to true, the custom listeners will be skipped. (optional, default to false)
   * @param skipIoMappings If set to true, the input/output mappings will be skipped. (optional, default to false)
   * @param skipSubprocesses If set to true, subprocesses related to deleted processes will be skipped. (optional, default to false)
   * @param failIfNotExists If set to false, the request will still be successful if the process id is not found. (optional, default to true)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Process instance with given id does not exist.  </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProcessInstanceWithHttpInfo(String id, Boolean skipCustomListeners, Boolean skipIoMappings, Boolean skipSubprocesses, Boolean failIfNotExists) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteProcessInstance");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCustomListeners", skipCustomListeners));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipIoMappings", skipIoMappings));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipSubprocesses", skipSubprocesses));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "failIfNotExists", failIfNotExists));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ProcessInstanceApi.deleteProcessInstance", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Deletes a variable of a process instance by id.
   * @param id The id of the process instance to delete the variable from. (required)
   * @param varName The name of the variable to delete. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProcessInstanceVariable(String id, String varName) throws ApiException {
    deleteProcessInstanceVariableWithHttpInfo(id, varName);
  }

  /**
   * 
   * Deletes a variable of a process instance by id.
   * @param id The id of the process instance to delete the variable from. (required)
   * @param varName The name of the variable to delete. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProcessInstanceVariableWithHttpInfo(String id, String varName) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteProcessInstanceVariable");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling deleteProcessInstanceVariable");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/variables/{varName}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "varName" + "\\}", apiClient.escapeString(varName.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ProcessInstanceApi.deleteProcessInstanceVariable", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Deletes multiple process instances asynchronously (batch).
   * @param deleteProcessInstancesDto **Unallowed property**: &#x60;historicProcessInstanceQuery&#x60; (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, i.e., neither processInstanceIds, nor processInstanceQuery is present </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto deleteProcessInstancesAsyncOperation(DeleteProcessInstancesDto deleteProcessInstancesDto) throws ApiException {
    return deleteProcessInstancesAsyncOperationWithHttpInfo(deleteProcessInstancesDto).getData();
  }

  /**
   * 
   * Deletes multiple process instances asynchronously (batch).
   * @param deleteProcessInstancesDto **Unallowed property**: &#x60;historicProcessInstanceQuery&#x60; (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, i.e., neither processInstanceIds, nor processInstanceQuery is present </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> deleteProcessInstancesAsyncOperationWithHttpInfo(DeleteProcessInstancesDto deleteProcessInstancesDto) throws ApiException {
    Object localVarPostBody = deleteProcessInstancesDto;
    
    // create path and map variables
    String localVarPath = "/process-instance/delete";

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

    return apiClient.invokeAPI("ProcessInstanceApi.deleteProcessInstancesAsyncOperation", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves an Activity Instance (Tree) for a given process instance by id.
   * @param id The id of the process instance for which the activity instance should be retrieved. (required)
   * @return ActivityInstanceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Process instance with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public ActivityInstanceDto getActivityInstanceTree(String id) throws ApiException {
    return getActivityInstanceTreeWithHttpInfo(id).getData();
  }

  /**
   * 
   * Retrieves an Activity Instance (Tree) for a given process instance by id.
   * @param id The id of the process instance for which the activity instance should be retrieved. (required)
   * @return ApiResponse&lt;ActivityInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Process instance with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ActivityInstanceDto> getActivityInstanceTreeWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getActivityInstanceTree");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/activity-instances"
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

    GenericType<ActivityInstanceDto> localVarReturnType = new GenericType<ActivityInstanceDto>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.getActivityInstanceTree", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Process Instance
   * Retrieves a process instance by id, according to the &#x60;ProcessInstance&#x60; interface in the engine.
   * @param id The id of the process instance to be retrieved. (required)
   * @return ProcessInstanceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process instance with given id does not exist. See the  [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format.  </td><td>  -  </td></tr>
     </table>
   */
  public ProcessInstanceDto getProcessInstance(String id) throws ApiException {
    return getProcessInstanceWithHttpInfo(id).getData();
  }

  /**
   * Get Process Instance
   * Retrieves a process instance by id, according to the &#x60;ProcessInstance&#x60; interface in the engine.
   * @param id The id of the process instance to be retrieved. (required)
   * @return ApiResponse&lt;ProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process instance with given id does not exist. See the  [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format.  </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessInstanceDto> getProcessInstanceWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProcessInstance");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}"
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

    GenericType<ProcessInstanceDto> localVarReturnType = new GenericType<ProcessInstanceDto>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.getProcessInstance", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves a variable of a given process instance by id.
   * @param id The id of the process instance to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @param deserializeValue Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return VariableValueDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Variable with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public VariableValueDto getProcessInstanceVariable(String id, String varName, Boolean deserializeValue) throws ApiException {
    return getProcessInstanceVariableWithHttpInfo(id, varName, deserializeValue).getData();
  }

  /**
   * 
   * Retrieves a variable of a given process instance by id.
   * @param id The id of the process instance to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @param deserializeValue Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return ApiResponse&lt;VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Variable with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<VariableValueDto> getProcessInstanceVariableWithHttpInfo(String id, String varName, Boolean deserializeValue) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProcessInstanceVariable");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling getProcessInstanceVariable");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/variables/{varName}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "varName" + "\\}", apiClient.escapeString(varName.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deserializeValue", deserializeValue));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<VariableValueDto> localVarReturnType = new GenericType<VariableValueDto>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.getProcessInstanceVariable", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves the content of a Process Variable by the Process Instance id and the Process Variable name. Applicable for byte array or file Process Variables.
   * @param id The id of the process instance to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful.         For binary variables or files without any MIME type information, a byte stream is returned.         File variables with MIME type information are returned as the saved type.         Additionally, for file variables the Content-Disposition header will be set. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request A Process Variable with the given id exists but does not serialize as binary data. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found A Process Variable with the given id does not exist.  </td><td>  -  </td></tr>
     </table>
   */
  public File getProcessInstanceVariableBinary(String id, String varName) throws ApiException {
    return getProcessInstanceVariableBinaryWithHttpInfo(id, varName).getData();
  }

  /**
   * 
   * Retrieves the content of a Process Variable by the Process Instance id and the Process Variable name. Applicable for byte array or file Process Variables.
   * @param id The id of the process instance to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful.         For binary variables or files without any MIME type information, a byte stream is returned.         File variables with MIME type information are returned as the saved type.         Additionally, for file variables the Content-Disposition header will be set. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request A Process Variable with the given id exists but does not serialize as binary data. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found A Process Variable with the given id does not exist.  </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getProcessInstanceVariableBinaryWithHttpInfo(String id, String varName) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProcessInstanceVariableBinary");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling getProcessInstanceVariableBinary");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/variables/{varName}/data"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "varName" + "\\}", apiClient.escapeString(varName.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/octet-stream", "text/plain", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<File> localVarReturnType = new GenericType<File>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.getProcessInstanceVariableBinary", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves all variables of a given process instance by id.
   * @param id The id of the process instance to retrieve the variables from. (required)
   * @param deserializeValue Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return Map&lt;String, VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Process instance with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, VariableValueDto> getProcessInstanceVariables(String id, Boolean deserializeValue) throws ApiException {
    return getProcessInstanceVariablesWithHttpInfo(id, deserializeValue).getData();
  }

  /**
   * 
   * Retrieves all variables of a given process instance by id.
   * @param id The id of the process instance to retrieve the variables from. (required)
   * @param deserializeValue Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return ApiResponse&lt;Map&lt;String, VariableValueDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Process instance with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, VariableValueDto>> getProcessInstanceVariablesWithHttpInfo(String id, Boolean deserializeValue) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProcessInstanceVariables");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/variables"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deserializeValue", deserializeValue));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Map<String, VariableValueDto>> localVarReturnType = new GenericType<Map<String, VariableValueDto>>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.getProcessInstanceVariables", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for process instances that fulfill given parameters. Parameters may be static as well as dynamic runtime properties of process instances. The size of the result set can be retrieved by using the Get Instance Count method.
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param processInstanceIds Filter by a comma-separated list of process instance ids. (optional)
   * @param businessKey Filter by process instance business key. (optional)
   * @param businessKeyLike Filter by process instance business key that the parameter is a substring of. (optional)
   * @param caseInstanceId Filter by case instance id. (optional)
   * @param processDefinitionId Filter by the deployment the id belongs to. (optional)
   * @param processDefinitionKey Filter by the key of the process definition the instances run on. (optional)
   * @param processDefinitionKeyIn Filter by a comma-separated list of process definition keys. A process instance must have one of the given process definition keys. (optional)
   * @param processDefinitionKeyNotIn Exclude instances by a comma-separated list of process definition keys. A process instance must not have one of the given process definition keys. (optional)
   * @param deploymentId Filter by the deployment the id belongs to. (optional)
   * @param superProcessInstance Restrict query to all process instances that are sub process instances of the given process instance. Takes a process instance id. (optional)
   * @param subProcessInstance Restrict query to all process instances that have the given process instance as a sub process instance. Takes a process instance id. (optional)
   * @param superCaseInstance Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param subCaseInstance Restrict query to all process instances that have the given case instance as a sub case instance. Takes a case instance id. (optional)
   * @param active Only include active process instances. Value may only be true, as false is the default behavior. (optional, default to false)
   * @param suspended Only include suspended process instances. Value may only be true, as false is the default behavior. (optional, default to false)
   * @param withIncident Filter by presence of incidents. Selects only process instances that have an incident. (optional, default to false)
   * @param incidentId Filter by the incident id. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. A process instance must have one of the given tenant ids. (optional)
   * @param withoutTenantId Only include process instances which belong to no tenant. (optional, default to false)
   * @param processDefinitionWithoutTenantId Only include process instances which process definition has no tenant id. (optional, default to false)
   * @param activityIdIn Filter by a comma-separated list of activity ids. A process instance must currently wait in a leaf activity with one of the given activity ids. (optional)
   * @param rootProcessInstances Restrict the query to all process instances that are top level process instances. (optional, default to false)
   * @param leafProcessInstances Restrict the query to all process instances that are leaf instances. (i.e. don&#39;t have any sub instances). (optional, default to false)
   * @param variables Only include process instances that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param variableNamesIgnoreCase Match all variable names in this query case-insensitively. If set to true variableName and variablename are treated as equal. (optional, default to false)
   * @param variableValuesIgnoreCase Match all variable values in this query case-insensitively. If set to true variableValue and variablevalue are treated as equal. (optional, default to false)
   * @return List&lt;ProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy, or if an invalid operator for variable comparison is used. </td><td>  -  </td></tr>
     </table>
   */
  public List<ProcessInstanceDto> getProcessInstances(String sortBy, String sortOrder, Integer firstResult, Integer maxResults, String processInstanceIds, String businessKey, String businessKeyLike, String caseInstanceId, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionKeyNotIn, String deploymentId, String superProcessInstance, String subProcessInstance, String superCaseInstance, String subCaseInstance, Boolean active, Boolean suspended, Boolean withIncident, String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String tenantIdIn, Boolean withoutTenantId, Boolean processDefinitionWithoutTenantId, String activityIdIn, Boolean rootProcessInstances, Boolean leafProcessInstances, String variables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase) throws ApiException {
    return getProcessInstancesWithHttpInfo(sortBy, sortOrder, firstResult, maxResults, processInstanceIds, businessKey, businessKeyLike, caseInstanceId, processDefinitionId, processDefinitionKey, processDefinitionKeyIn, processDefinitionKeyNotIn, deploymentId, superProcessInstance, subProcessInstance, superCaseInstance, subCaseInstance, active, suspended, withIncident, incidentId, incidentType, incidentMessage, incidentMessageLike, tenantIdIn, withoutTenantId, processDefinitionWithoutTenantId, activityIdIn, rootProcessInstances, leafProcessInstances, variables, variableNamesIgnoreCase, variableValuesIgnoreCase).getData();
  }

  /**
   * 
   * Queries for process instances that fulfill given parameters. Parameters may be static as well as dynamic runtime properties of process instances. The size of the result set can be retrieved by using the Get Instance Count method.
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param processInstanceIds Filter by a comma-separated list of process instance ids. (optional)
   * @param businessKey Filter by process instance business key. (optional)
   * @param businessKeyLike Filter by process instance business key that the parameter is a substring of. (optional)
   * @param caseInstanceId Filter by case instance id. (optional)
   * @param processDefinitionId Filter by the deployment the id belongs to. (optional)
   * @param processDefinitionKey Filter by the key of the process definition the instances run on. (optional)
   * @param processDefinitionKeyIn Filter by a comma-separated list of process definition keys. A process instance must have one of the given process definition keys. (optional)
   * @param processDefinitionKeyNotIn Exclude instances by a comma-separated list of process definition keys. A process instance must not have one of the given process definition keys. (optional)
   * @param deploymentId Filter by the deployment the id belongs to. (optional)
   * @param superProcessInstance Restrict query to all process instances that are sub process instances of the given process instance. Takes a process instance id. (optional)
   * @param subProcessInstance Restrict query to all process instances that have the given process instance as a sub process instance. Takes a process instance id. (optional)
   * @param superCaseInstance Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param subCaseInstance Restrict query to all process instances that have the given case instance as a sub case instance. Takes a case instance id. (optional)
   * @param active Only include active process instances. Value may only be true, as false is the default behavior. (optional, default to false)
   * @param suspended Only include suspended process instances. Value may only be true, as false is the default behavior. (optional, default to false)
   * @param withIncident Filter by presence of incidents. Selects only process instances that have an incident. (optional, default to false)
   * @param incidentId Filter by the incident id. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. A process instance must have one of the given tenant ids. (optional)
   * @param withoutTenantId Only include process instances which belong to no tenant. (optional, default to false)
   * @param processDefinitionWithoutTenantId Only include process instances which process definition has no tenant id. (optional, default to false)
   * @param activityIdIn Filter by a comma-separated list of activity ids. A process instance must currently wait in a leaf activity with one of the given activity ids. (optional)
   * @param rootProcessInstances Restrict the query to all process instances that are top level process instances. (optional, default to false)
   * @param leafProcessInstances Restrict the query to all process instances that are leaf instances. (i.e. don&#39;t have any sub instances). (optional, default to false)
   * @param variables Only include process instances that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param variableNamesIgnoreCase Match all variable names in this query case-insensitively. If set to true variableName and variablename are treated as equal. (optional, default to false)
   * @param variableValuesIgnoreCase Match all variable values in this query case-insensitively. If set to true variableValue and variablevalue are treated as equal. (optional, default to false)
   * @return ApiResponse&lt;List&lt;ProcessInstanceDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy, or if an invalid operator for variable comparison is used. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ProcessInstanceDto>> getProcessInstancesWithHttpInfo(String sortBy, String sortOrder, Integer firstResult, Integer maxResults, String processInstanceIds, String businessKey, String businessKeyLike, String caseInstanceId, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionKeyNotIn, String deploymentId, String superProcessInstance, String subProcessInstance, String superCaseInstance, String subCaseInstance, Boolean active, Boolean suspended, Boolean withIncident, String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String tenantIdIn, Boolean withoutTenantId, Boolean processDefinitionWithoutTenantId, String activityIdIn, Boolean rootProcessInstances, Boolean leafProcessInstances, String variables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/process-instance";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortOrder", sortOrder));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstResult", firstResult));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxResults", maxResults));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceIds", processInstanceIds));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "businessKey", businessKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "businessKeyLike", businessKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceId", caseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKey", processDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyNotIn", processDefinitionKeyNotIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deploymentId", deploymentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "superProcessInstance", superProcessInstance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "subProcessInstance", subProcessInstance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "superCaseInstance", superCaseInstance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "subCaseInstance", subCaseInstance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withIncident", withIncident));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentId", incidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentType", incidentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessage", incidentMessage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessageLike", incidentMessageLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutTenantId", withoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionWithoutTenantId", processDefinitionWithoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityIdIn", activityIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rootProcessInstances", rootProcessInstances));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leafProcessInstances", leafProcessInstances));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variables", variables));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableNamesIgnoreCase", variableNamesIgnoreCase));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableValuesIgnoreCase", variableValuesIgnoreCase));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<ProcessInstanceDto>> localVarReturnType = new GenericType<List<ProcessInstanceDto>>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.getProcessInstances", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for the number of process instances that fulfill given parameters.
   * @param processInstanceIds Filter by a comma-separated list of process instance ids. (optional)
   * @param businessKey Filter by process instance business key. (optional)
   * @param businessKeyLike Filter by process instance business key that the parameter is a substring of. (optional)
   * @param caseInstanceId Filter by case instance id. (optional)
   * @param processDefinitionId Filter by the deployment the id belongs to. (optional)
   * @param processDefinitionKey Filter by the key of the process definition the instances run on. (optional)
   * @param processDefinitionKeyIn Filter by a comma-separated list of process definition keys. A process instance must have one of the given process definition keys. (optional)
   * @param processDefinitionKeyNotIn Exclude instances by a comma-separated list of process definition keys. A process instance must not have one of the given process definition keys. (optional)
   * @param deploymentId Filter by the deployment the id belongs to. (optional)
   * @param superProcessInstance Restrict query to all process instances that are sub process instances of the given process instance. Takes a process instance id. (optional)
   * @param subProcessInstance Restrict query to all process instances that have the given process instance as a sub process instance. Takes a process instance id. (optional)
   * @param superCaseInstance Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param subCaseInstance Restrict query to all process instances that have the given case instance as a sub case instance. Takes a case instance id. (optional)
   * @param active Only include active process instances. Value may only be true, as false is the default behavior. (optional, default to false)
   * @param suspended Only include suspended process instances. Value may only be true, as false is the default behavior. (optional, default to false)
   * @param withIncident Filter by presence of incidents. Selects only process instances that have an incident. (optional, default to false)
   * @param incidentId Filter by the incident id. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. A process instance must have one of the given tenant ids. (optional)
   * @param withoutTenantId Only include process instances which belong to no tenant. (optional, default to false)
   * @param processDefinitionWithoutTenantId Only include process instances which process definition has no tenant id. (optional, default to false)
   * @param activityIdIn Filter by a comma-separated list of activity ids. A process instance must currently wait in a leaf activity with one of the given activity ids. (optional)
   * @param rootProcessInstances Restrict the query to all process instances that are top level process instances. (optional, default to false)
   * @param leafProcessInstances Restrict the query to all process instances that are leaf instances. (i.e. don&#39;t have any sub instances). (optional, default to false)
   * @param variables Only include process instances that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param variableNamesIgnoreCase Match all variable names in this query case-insensitively. If set to true variableName and variablename are treated as equal. (optional, default to false)
   * @param variableValuesIgnoreCase Match all variable values in this query case-insensitively. If set to true variableValue and variablevalue are treated as equal. (optional, default to false)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example an invalid operator for variable comparison is used. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto getProcessInstancesCount(String processInstanceIds, String businessKey, String businessKeyLike, String caseInstanceId, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionKeyNotIn, String deploymentId, String superProcessInstance, String subProcessInstance, String superCaseInstance, String subCaseInstance, Boolean active, Boolean suspended, Boolean withIncident, String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String tenantIdIn, Boolean withoutTenantId, Boolean processDefinitionWithoutTenantId, String activityIdIn, Boolean rootProcessInstances, Boolean leafProcessInstances, String variables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase) throws ApiException {
    return getProcessInstancesCountWithHttpInfo(processInstanceIds, businessKey, businessKeyLike, caseInstanceId, processDefinitionId, processDefinitionKey, processDefinitionKeyIn, processDefinitionKeyNotIn, deploymentId, superProcessInstance, subProcessInstance, superCaseInstance, subCaseInstance, active, suspended, withIncident, incidentId, incidentType, incidentMessage, incidentMessageLike, tenantIdIn, withoutTenantId, processDefinitionWithoutTenantId, activityIdIn, rootProcessInstances, leafProcessInstances, variables, variableNamesIgnoreCase, variableValuesIgnoreCase).getData();
  }

  /**
   * 
   * Queries for the number of process instances that fulfill given parameters.
   * @param processInstanceIds Filter by a comma-separated list of process instance ids. (optional)
   * @param businessKey Filter by process instance business key. (optional)
   * @param businessKeyLike Filter by process instance business key that the parameter is a substring of. (optional)
   * @param caseInstanceId Filter by case instance id. (optional)
   * @param processDefinitionId Filter by the deployment the id belongs to. (optional)
   * @param processDefinitionKey Filter by the key of the process definition the instances run on. (optional)
   * @param processDefinitionKeyIn Filter by a comma-separated list of process definition keys. A process instance must have one of the given process definition keys. (optional)
   * @param processDefinitionKeyNotIn Exclude instances by a comma-separated list of process definition keys. A process instance must not have one of the given process definition keys. (optional)
   * @param deploymentId Filter by the deployment the id belongs to. (optional)
   * @param superProcessInstance Restrict query to all process instances that are sub process instances of the given process instance. Takes a process instance id. (optional)
   * @param subProcessInstance Restrict query to all process instances that have the given process instance as a sub process instance. Takes a process instance id. (optional)
   * @param superCaseInstance Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param subCaseInstance Restrict query to all process instances that have the given case instance as a sub case instance. Takes a case instance id. (optional)
   * @param active Only include active process instances. Value may only be true, as false is the default behavior. (optional, default to false)
   * @param suspended Only include suspended process instances. Value may only be true, as false is the default behavior. (optional, default to false)
   * @param withIncident Filter by presence of incidents. Selects only process instances that have an incident. (optional, default to false)
   * @param incidentId Filter by the incident id. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. A process instance must have one of the given tenant ids. (optional)
   * @param withoutTenantId Only include process instances which belong to no tenant. (optional, default to false)
   * @param processDefinitionWithoutTenantId Only include process instances which process definition has no tenant id. (optional, default to false)
   * @param activityIdIn Filter by a comma-separated list of activity ids. A process instance must currently wait in a leaf activity with one of the given activity ids. (optional)
   * @param rootProcessInstances Restrict the query to all process instances that are top level process instances. (optional, default to false)
   * @param leafProcessInstances Restrict the query to all process instances that are leaf instances. (i.e. don&#39;t have any sub instances). (optional, default to false)
   * @param variables Only include process instances that have variables with certain values. Variable filtering expressions are comma-separated and are structured as follows:  A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note**: Values are always treated as String objects on server side.  Valid &#x60;operator&#x60; values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;. &#x60;key&#x60; and &#x60;value&#x60; may not contain underscore or comma characters. (optional)
   * @param variableNamesIgnoreCase Match all variable names in this query case-insensitively. If set to true variableName and variablename are treated as equal. (optional, default to false)
   * @param variableValuesIgnoreCase Match all variable values in this query case-insensitively. If set to true variableValue and variablevalue are treated as equal. (optional, default to false)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example an invalid operator for variable comparison is used. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> getProcessInstancesCountWithHttpInfo(String processInstanceIds, String businessKey, String businessKeyLike, String caseInstanceId, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionKeyNotIn, String deploymentId, String superProcessInstance, String subProcessInstance, String superCaseInstance, String subCaseInstance, Boolean active, Boolean suspended, Boolean withIncident, String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String tenantIdIn, Boolean withoutTenantId, Boolean processDefinitionWithoutTenantId, String activityIdIn, Boolean rootProcessInstances, Boolean leafProcessInstances, String variables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/process-instance/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceIds", processInstanceIds));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "businessKey", businessKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "businessKeyLike", businessKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceId", caseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKey", processDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyNotIn", processDefinitionKeyNotIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deploymentId", deploymentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "superProcessInstance", superProcessInstance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "subProcessInstance", subProcessInstance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "superCaseInstance", superCaseInstance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "subCaseInstance", subCaseInstance));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withIncident", withIncident));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentId", incidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentType", incidentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessage", incidentMessage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessageLike", incidentMessageLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutTenantId", withoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionWithoutTenantId", processDefinitionWithoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityIdIn", activityIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rootProcessInstances", rootProcessInstances));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "leafProcessInstances", leafProcessInstances));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variables", variables));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableNamesIgnoreCase", variableNamesIgnoreCase));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "variableValuesIgnoreCase", variableValuesIgnoreCase));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<CountResultDto> localVarReturnType = new GenericType<CountResultDto>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.getProcessInstancesCount", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Submits a list of modification instructions to change a process instance&#39;s execution state. A modification instruction is one of the following:  * Starting execution before an activity * Starting execution after an activity on its single outgoing sequence flow * Starting execution on a specific sequence flow * Canceling an activity instance, transition instance, or all instances (activity or transition) for an activity  Instructions are executed immediately and in the order they are provided in this request&#39;s body. Variables can be provided with every starting instruction.  The exact semantics of modification can be read about in the [User guide](https://docs.camunda.org/manual/develop/user-guide/process-engine/process-instance-modification/).
   * @param id The id of the process instance to modify. (required)
   * @param processInstanceModificationDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> At least one modification instruction misses required parameters. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The modification cannot be performed, for example because it starts a failing activity. </td><td>  -  </td></tr>
     </table>
   */
  public void modifyProcessInstance(String id, ProcessInstanceModificationDto processInstanceModificationDto) throws ApiException {
    modifyProcessInstanceWithHttpInfo(id, processInstanceModificationDto);
  }

  /**
   * 
   * Submits a list of modification instructions to change a process instance&#39;s execution state. A modification instruction is one of the following:  * Starting execution before an activity * Starting execution after an activity on its single outgoing sequence flow * Starting execution on a specific sequence flow * Canceling an activity instance, transition instance, or all instances (activity or transition) for an activity  Instructions are executed immediately and in the order they are provided in this request&#39;s body. Variables can be provided with every starting instruction.  The exact semantics of modification can be read about in the [User guide](https://docs.camunda.org/manual/develop/user-guide/process-engine/process-instance-modification/).
   * @param id The id of the process instance to modify. (required)
   * @param processInstanceModificationDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> At least one modification instruction misses required parameters. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The modification cannot be performed, for example because it starts a failing activity. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> modifyProcessInstanceWithHttpInfo(String id, ProcessInstanceModificationDto processInstanceModificationDto) throws ApiException {
    Object localVarPostBody = processInstanceModificationDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling modifyProcessInstance");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/modification"
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

    return apiClient.invokeAPI("ProcessInstanceApi.modifyProcessInstance", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Submits a list of modification instructions to change a process instance&#39;s execution state async. A modification instruction is one of the following:  * Starting execution before an activity * Starting execution after an activity on its single outgoing sequence flow * Starting execution on a specific sequence flow * Cancelling an activity instance, transition instance, or all instances (activity or transition) for an activity  Instructions are executed asynchronous and in the order they are provided in this request&#39;s body. Variables can be provided with every starting instruction.  The exact semantics of modification can be read about in the [User guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/process-instance-modification/).
   * @param id The id of the process instance to modify. (required)
   * @param processInstanceModificationDto  (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request At least one modification instruction misses required parameters. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden If the user is not allowed to execute batches. See the Introduction for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The modification cannot be performed, for example because it starts a failing activity. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto modifyProcessInstanceAsyncOperation(String id, ProcessInstanceModificationDto processInstanceModificationDto) throws ApiException {
    return modifyProcessInstanceAsyncOperationWithHttpInfo(id, processInstanceModificationDto).getData();
  }

  /**
   * 
   * Submits a list of modification instructions to change a process instance&#39;s execution state async. A modification instruction is one of the following:  * Starting execution before an activity * Starting execution after an activity on its single outgoing sequence flow * Starting execution on a specific sequence flow * Cancelling an activity instance, transition instance, or all instances (activity or transition) for an activity  Instructions are executed asynchronous and in the order they are provided in this request&#39;s body. Variables can be provided with every starting instruction.  The exact semantics of modification can be read about in the [User guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/process-instance-modification/).
   * @param id The id of the process instance to modify. (required)
   * @param processInstanceModificationDto  (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request At least one modification instruction misses required parameters. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden If the user is not allowed to execute batches. See the Introduction for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The modification cannot be performed, for example because it starts a failing activity. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> modifyProcessInstanceAsyncOperationWithHttpInfo(String id, ProcessInstanceModificationDto processInstanceModificationDto) throws ApiException {
    Object localVarPostBody = processInstanceModificationDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling modifyProcessInstanceAsyncOperation");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/modification-async"
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

    GenericType<BatchDto> localVarReturnType = new GenericType<BatchDto>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.modifyProcessInstanceAsyncOperation", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Updates or deletes the variables of a process instance by id. Updates precede deletions. So, if a variable is updated AND deleted, the deletion overrides the update.
   * @param id The id of the process instance to set variables for. (required)
   * @param patchVariablesDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Update or delete could not be executed, for example because the process instance does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public void modifyProcessInstanceVariables(String id, PatchVariablesDto patchVariablesDto) throws ApiException {
    modifyProcessInstanceVariablesWithHttpInfo(id, patchVariablesDto);
  }

  /**
   * 
   * Updates or deletes the variables of a process instance by id. Updates precede deletions. So, if a variable is updated AND deleted, the deletion overrides the update.
   * @param id The id of the process instance to set variables for. (required)
   * @param patchVariablesDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Update or delete could not be executed, for example because the process instance does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> modifyProcessInstanceVariablesWithHttpInfo(String id, PatchVariablesDto patchVariablesDto) throws ApiException {
    Object localVarPostBody = patchVariablesDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling modifyProcessInstanceVariables");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/variables"
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

    return apiClient.invokeAPI("ProcessInstanceApi.modifyProcessInstanceVariables", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Queries for process instances that fulfill given parameters through a JSON object. This method is slightly more powerful than the Get Instances method because it allows filtering by multiple process variables of types &#x60;string&#x60;, &#x60;number&#x60; or &#x60;boolean&#x60;.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param processInstanceQueryDto  (optional)
   * @return List&lt;ProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy, or if an invalid operator for variable comparison is used. </td><td>  -  </td></tr>
     </table>
   */
  public List<ProcessInstanceDto> queryProcessInstances(Integer firstResult, Integer maxResults, ProcessInstanceQueryDto processInstanceQueryDto) throws ApiException {
    return queryProcessInstancesWithHttpInfo(firstResult, maxResults, processInstanceQueryDto).getData();
  }

  /**
   * 
   * Queries for process instances that fulfill given parameters through a JSON object. This method is slightly more powerful than the Get Instances method because it allows filtering by multiple process variables of types &#x60;string&#x60;, &#x60;number&#x60; or &#x60;boolean&#x60;.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param processInstanceQueryDto  (optional)
   * @return ApiResponse&lt;List&lt;ProcessInstanceDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy, or if an invalid operator for variable comparison is used. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ProcessInstanceDto>> queryProcessInstancesWithHttpInfo(Integer firstResult, Integer maxResults, ProcessInstanceQueryDto processInstanceQueryDto) throws ApiException {
    Object localVarPostBody = processInstanceQueryDto;
    
    // create path and map variables
    String localVarPath = "/process-instance";

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

    GenericType<List<ProcessInstanceDto>> localVarReturnType = new GenericType<List<ProcessInstanceDto>>() {};

    return apiClient.invokeAPI("ProcessInstanceApi.queryProcessInstances", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for the number of process instances that fulfill the given parameters. This method takes the same message body as the Get Instances (POST) method and therefore it is slightly more powerful than the Get Instance Count method.
   * @param processInstanceQueryDto  (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if an invalid operator for variable comparison is used. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto queryProcessInstancesCount(ProcessInstanceQueryDto processInstanceQueryDto) throws ApiException {
    return queryProcessInstancesCountWithHttpInfo(processInstanceQueryDto).getData();
  }

  /**
   * 
   * Queries for the number of process instances that fulfill the given parameters. This method takes the same message body as the Get Instances (POST) method and therefore it is slightly more powerful than the Get Instance Count method.
   * @param processInstanceQueryDto  (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if an invalid operator for variable comparison is used. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> queryProcessInstancesCountWithHttpInfo(ProcessInstanceQueryDto processInstanceQueryDto) throws ApiException {
    Object localVarPostBody = processInstanceQueryDto;
    
    // create path and map variables
    String localVarPath = "/process-instance/count";

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

    return apiClient.invokeAPI("ProcessInstanceApi.queryProcessInstancesCount", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Sets a variable of a given process instance by id.
   * @param id The id of the process instance to set the variable for. (required)
   * @param varName The name of the variable to set. (required)
   * @param variableValueDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. </td><td>  -  </td></tr>
     </table>
   */
  public void setProcessInstanceVariable(String id, String varName, VariableValueDto variableValueDto) throws ApiException {
    setProcessInstanceVariableWithHttpInfo(id, varName, variableValueDto);
  }

  /**
   * 
   * Sets a variable of a given process instance by id.
   * @param id The id of the process instance to set the variable for. (required)
   * @param varName The name of the variable to set. (required)
   * @param variableValueDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setProcessInstanceVariableWithHttpInfo(String id, String varName, VariableValueDto variableValueDto) throws ApiException {
    Object localVarPostBody = variableValueDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling setProcessInstanceVariable");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling setProcessInstanceVariable");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/variables/{varName}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "varName" + "\\}", apiClient.escapeString(varName.toString()));

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

    return apiClient.invokeAPI("ProcessInstanceApi.setProcessInstanceVariable", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Sets the serialized value for a binary variable or the binary value for a file variable.
   * @param id The id of the process instance to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @param data The binary data to be set. For File variables, this multipart can contain the filename, binary value and MIME type of the file variable to be set Only the filename is mandatory. (optional)
   * @param valueType The name of the variable type. Either Bytes for a byte array variable or File for a file variable. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request The variable value or type is invalid, for example if no filename is set. </td><td>  -  </td></tr>
     </table>
   */
  public void setProcessInstanceVariableBinary(String id, String varName, File data, String valueType) throws ApiException {
    setProcessInstanceVariableBinaryWithHttpInfo(id, varName, data, valueType);
  }

  /**
   * 
   * Sets the serialized value for a binary variable or the binary value for a file variable.
   * @param id The id of the process instance to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @param data The binary data to be set. For File variables, this multipart can contain the filename, binary value and MIME type of the file variable to be set Only the filename is mandatory. (optional)
   * @param valueType The name of the variable type. Either Bytes for a byte array variable or File for a file variable. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request The variable value or type is invalid, for example if no filename is set. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setProcessInstanceVariableBinaryWithHttpInfo(String id, String varName, File data, String valueType) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling setProcessInstanceVariableBinary");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling setProcessInstanceVariableBinary");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/variables/{varName}/data"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()))
      .replaceAll("\\{" + "varName" + "\\}", apiClient.escapeString(varName.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    if (data != null)
      localVarFormParams.put("data", data);
if (valueType != null)
      localVarFormParams.put("valueType", valueType);

    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "multipart/form-data"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ProcessInstanceApi.setProcessInstanceVariableBinary", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Create a batch to set retries of jobs associated with given processes asynchronously.
   * @param setJobRetriesByProcessDto Please note that if both processInstances and processInstanceQuery are provided, then the resulting execution will be performed on the union of these sets. **Unallowed property**: &#x60;historicProcessInstanceQuery&#x60; (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if neither processInstanceIds, nor processInstanceQuery is present. Or if the retry count is not specified. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto setRetriesByProcess(SetJobRetriesByProcessDto setJobRetriesByProcessDto) throws ApiException {
    return setRetriesByProcessWithHttpInfo(setJobRetriesByProcessDto).getData();
  }

  /**
   * 
   * Create a batch to set retries of jobs associated with given processes asynchronously.
   * @param setJobRetriesByProcessDto Please note that if both processInstances and processInstanceQuery are provided, then the resulting execution will be performed on the union of these sets. **Unallowed property**: &#x60;historicProcessInstanceQuery&#x60; (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if neither processInstanceIds, nor processInstanceQuery is present. Or if the retry count is not specified. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> setRetriesByProcessWithHttpInfo(SetJobRetriesByProcessDto setJobRetriesByProcessDto) throws ApiException {
    Object localVarPostBody = setJobRetriesByProcessDto;
    
    // create path and map variables
    String localVarPath = "/process-instance/job-retries";

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

    return apiClient.invokeAPI("ProcessInstanceApi.setRetriesByProcess", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Create a batch to set retries of jobs asynchronously based on a historic process instance query.
   * @param setJobRetriesByProcessDto Please note that if both processInstances and historicProcessInstanceQuery are provided, then the resulting execution will be performed on the union of these sets. **Unallowed property**: &#x60;processInstanceQuery&#x60; (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if neither processInstanceIds, nor historicProcessInstanceQuery is present. Or if the retry count is not specified. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto setRetriesByProcessHistoricQueryBased(SetJobRetriesByProcessDto setJobRetriesByProcessDto) throws ApiException {
    return setRetriesByProcessHistoricQueryBasedWithHttpInfo(setJobRetriesByProcessDto).getData();
  }

  /**
   * 
   * Create a batch to set retries of jobs asynchronously based on a historic process instance query.
   * @param setJobRetriesByProcessDto Please note that if both processInstances and historicProcessInstanceQuery are provided, then the resulting execution will be performed on the union of these sets. **Unallowed property**: &#x60;processInstanceQuery&#x60; (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if neither processInstanceIds, nor historicProcessInstanceQuery is present. Or if the retry count is not specified. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> setRetriesByProcessHistoricQueryBasedWithHttpInfo(SetJobRetriesByProcessDto setJobRetriesByProcessDto) throws ApiException {
    Object localVarPostBody = setJobRetriesByProcessDto;
    
    // create path and map variables
    String localVarPath = "/process-instance/job-retries-historic-query-based";

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

    return apiClient.invokeAPI("ProcessInstanceApi.setRetriesByProcessHistoricQueryBased", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Update or create runtime process variables in the root scope of process instances.
   * @param setVariablesAsyncDto  (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request * The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported * If none of &#x60;processInstanceIds&#x60;, &#x60;processInstanceQuery&#x60; and &#x60;historicProcessInstanceQuery&#x60; is given * If no or an empty array of &#x60;variables&#x60; is given * If no process instance ids where found * If a transient variable is set * If the engine config flag &#x60;javaSerializationFormatEnabled&#x60; is &#x60;false&#x60; and a Java serialized variable is given </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Returned if the user is not allowed to create the batch.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto setVariablesAsyncOperation(SetVariablesAsyncDto setVariablesAsyncDto) throws ApiException {
    return setVariablesAsyncOperationWithHttpInfo(setVariablesAsyncDto).getData();
  }

  /**
   * 
   * Update or create runtime process variables in the root scope of process instances.
   * @param setVariablesAsyncDto  (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request * The variable value or type is invalid, for example if the value could not be parsed to an Integer value or the passed variable type is not supported * If none of &#x60;processInstanceIds&#x60;, &#x60;processInstanceQuery&#x60; and &#x60;historicProcessInstanceQuery&#x60; is given * If no or an empty array of &#x60;variables&#x60; is given * If no process instance ids where found * If a transient variable is set * If the engine config flag &#x60;javaSerializationFormatEnabled&#x60; is &#x60;false&#x60; and a Java serialized variable is given </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Returned if the user is not allowed to create the batch.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> setVariablesAsyncOperationWithHttpInfo(SetVariablesAsyncDto setVariablesAsyncDto) throws ApiException {
    Object localVarPostBody = setVariablesAsyncDto;
    
    // create path and map variables
    String localVarPath = "/process-instance/variables-async";

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

    return apiClient.invokeAPI("ProcessInstanceApi.setVariablesAsyncOperation", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Activates or suspends process instances by providing certain criteria:  # Activate/Suspend Process Instance By Process Definition Id * &#x60;suspend&#x60; * &#x60;processDefinitionId&#x60;  # Activate/Suspend Process Instance By Process Definition Key  * &#x60;suspend&#x60; * &#x60;processDefinitionKey&#x60; * &#x60;processDefinitionTenantId&#x60; * &#x60;processDefinitionWithoutTenantId&#x60;  # Activate/Suspend Process Instance In Group * &#x60;suspend&#x60; * &#x60;processInstanceIds&#x60; * &#x60;processInstanceQuery&#x60; * &#x60;historicProcessInstanceQuery&#x60;
   * @param processInstanceSuspensionStateDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the request parameters are invalid, for example if the provided processDefinitionId or processDefinitionKey parameter is null. </td><td>  -  </td></tr>
     </table>
   */
  public void updateSuspensionState(ProcessInstanceSuspensionStateDto processInstanceSuspensionStateDto) throws ApiException {
    updateSuspensionStateWithHttpInfo(processInstanceSuspensionStateDto);
  }

  /**
   * 
   * Activates or suspends process instances by providing certain criteria:  # Activate/Suspend Process Instance By Process Definition Id * &#x60;suspend&#x60; * &#x60;processDefinitionId&#x60;  # Activate/Suspend Process Instance By Process Definition Key  * &#x60;suspend&#x60; * &#x60;processDefinitionKey&#x60; * &#x60;processDefinitionTenantId&#x60; * &#x60;processDefinitionWithoutTenantId&#x60;  # Activate/Suspend Process Instance In Group * &#x60;suspend&#x60; * &#x60;processInstanceIds&#x60; * &#x60;processInstanceQuery&#x60; * &#x60;historicProcessInstanceQuery&#x60;
   * @param processInstanceSuspensionStateDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the request parameters are invalid, for example if the provided processDefinitionId or processDefinitionKey parameter is null. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateSuspensionStateWithHttpInfo(ProcessInstanceSuspensionStateDto processInstanceSuspensionStateDto) throws ApiException {
    Object localVarPostBody = processInstanceSuspensionStateDto;
    
    // create path and map variables
    String localVarPath = "/process-instance/suspended";

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

    return apiClient.invokeAPI("ProcessInstanceApi.updateSuspensionState", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Activates or suspends process instances asynchronously with a list of process instance ids, a process instance query, and/or a historical process instance query.
   * @param processInstanceSuspensionStateAsyncDto  (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the request parameters are invalid, for example if the provided processDefinitionId or processDefinitionKey parameter is null. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto updateSuspensionStateAsyncOperation(ProcessInstanceSuspensionStateAsyncDto processInstanceSuspensionStateAsyncDto) throws ApiException {
    return updateSuspensionStateAsyncOperationWithHttpInfo(processInstanceSuspensionStateAsyncDto).getData();
  }

  /**
   * 
   * Activates or suspends process instances asynchronously with a list of process instance ids, a process instance query, and/or a historical process instance query.
   * @param processInstanceSuspensionStateAsyncDto  (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the request parameters are invalid, for example if the provided processDefinitionId or processDefinitionKey parameter is null. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> updateSuspensionStateAsyncOperationWithHttpInfo(ProcessInstanceSuspensionStateAsyncDto processInstanceSuspensionStateAsyncDto) throws ApiException {
    Object localVarPostBody = processInstanceSuspensionStateAsyncDto;
    
    // create path and map variables
    String localVarPath = "/process-instance/suspended-async";

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

    return apiClient.invokeAPI("ProcessInstanceApi.updateSuspensionStateAsyncOperation", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Activates or suspends a given process instance by id.
   * @param id The id of the process instance to activate or suspend. (required)
   * @param suspensionStateDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public void updateSuspensionStateById(String id, SuspensionStateDto suspensionStateDto) throws ApiException {
    updateSuspensionStateByIdWithHttpInfo(id, suspensionStateDto);
  }

  /**
   * 
   * Activates or suspends a given process instance by id.
   * @param id The id of the process instance to activate or suspend. (required)
   * @param suspensionStateDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateSuspensionStateByIdWithHttpInfo(String id, SuspensionStateDto suspensionStateDto) throws ApiException {
    Object localVarPostBody = suspensionStateDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateSuspensionStateById");
    }
    
    // create path and map variables
    String localVarPath = "/process-instance/{id}/suspended"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ProcessInstanceApi.updateSuspensionStateById", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
