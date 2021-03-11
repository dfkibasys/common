package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.ActivityStatisticsResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.AuthorizationExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.BatchDto;
import de.dfki.cos.basys.common.rest.camunda.dto.CountResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import java.io.File;
import de.dfki.cos.basys.common.rest.camunda.dto.FormDto;
import de.dfki.cos.basys.common.rest.camunda.dto.HistoryTimeToLiveDto;
import org.threeten.bp.OffsetDateTime;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessDefinitionDiagramDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessDefinitionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessDefinitionStatisticsResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessDefinitionSuspensionStateDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessInstanceDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessInstanceWithVariablesDto;
import de.dfki.cos.basys.common.rest.camunda.dto.RestartProcessInstanceDto;
import de.dfki.cos.basys.common.rest.camunda.dto.StartProcessInstanceDto;
import de.dfki.cos.basys.common.rest.camunda.dto.StartProcessInstanceFormDto;
import de.dfki.cos.basys.common.rest.camunda.dto.VariableValueDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class ProcessDefinitionApi {
  private ApiClient apiClient;

  public ProcessDefinitionApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProcessDefinitionApi(ApiClient apiClient) {
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
   * Delete
   * Deletes a running process instance by id.
   * @param id The id of the process definition to be deleted. (required)
   * @param cascade &#x60;true&#x60;, if all process instances, historic process instances and jobs for this process definition should be deleted. (optional)
   * @param skipCustomListeners &#x60;true&#x60;, if only the built-in ExecutionListeners should be notified with the end event. (optional, default to false)
   * @param skipIoMappings A boolean value to control whether input/output mappings should be executed during deletion. &#x60;true&#x60;, if input/output mappings should not be invoked. (optional, default to false)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProcessDefinition(String id, Boolean cascade, Boolean skipCustomListeners, Boolean skipIoMappings) throws ApiException {
    deleteProcessDefinitionWithHttpInfo(id, cascade, skipCustomListeners, skipIoMappings);
  }

  /**
   * Delete
   * Deletes a running process instance by id.
   * @param id The id of the process definition to be deleted. (required)
   * @param cascade &#x60;true&#x60;, if all process instances, historic process instances and jobs for this process definition should be deleted. (optional)
   * @param skipCustomListeners &#x60;true&#x60;, if only the built-in ExecutionListeners should be notified with the end event. (optional, default to false)
   * @param skipIoMappings A boolean value to control whether input/output mappings should be executed during deletion. &#x60;true&#x60;, if input/output mappings should not be invoked. (optional, default to false)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProcessDefinitionWithHttpInfo(String id, Boolean cascade, Boolean skipCustomListeners, Boolean skipIoMappings) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteProcessDefinition");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cascade", cascade));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCustomListeners", skipCustomListeners));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipIoMappings", skipIoMappings));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ProcessDefinitionApi.deleteProcessDefinition", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete By Key
   * Deletes process definitions by a given key which belong to no tenant id.
   * @param key The key of the process definitions to be deleted. (required)
   * @param cascade &#x60;true&#x60;, if all process instances, historic process instances and jobs for this process definition should be deleted. (optional)
   * @param skipCustomListeners &#x60;true&#x60;, if only the built-in ExecutionListeners should be notified with the end event. (optional, default to false)
   * @param skipIoMappings A boolean value to control whether input/output mappings should be executed during deletion. &#x60;true&#x60;, if input/output mappings should not be invoked. (optional, default to false)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden The process definitions with the given &#x60;key&#x60; cannot be deleted due to missing permissions. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Process definition with given &#x60;key&#x60; does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProcessDefinitionsByKey(String key, Boolean cascade, Boolean skipCustomListeners, Boolean skipIoMappings) throws ApiException {
    deleteProcessDefinitionsByKeyWithHttpInfo(key, cascade, skipCustomListeners, skipIoMappings);
  }

  /**
   * Delete By Key
   * Deletes process definitions by a given key which belong to no tenant id.
   * @param key The key of the process definitions to be deleted. (required)
   * @param cascade &#x60;true&#x60;, if all process instances, historic process instances and jobs for this process definition should be deleted. (optional)
   * @param skipCustomListeners &#x60;true&#x60;, if only the built-in ExecutionListeners should be notified with the end event. (optional, default to false)
   * @param skipIoMappings A boolean value to control whether input/output mappings should be executed during deletion. &#x60;true&#x60;, if input/output mappings should not be invoked. (optional, default to false)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden The process definitions with the given &#x60;key&#x60; cannot be deleted due to missing permissions. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Process definition with given &#x60;key&#x60; does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProcessDefinitionsByKeyWithHttpInfo(String key, Boolean cascade, Boolean skipCustomListeners, Boolean skipIoMappings) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling deleteProcessDefinitionsByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cascade", cascade));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCustomListeners", skipCustomListeners));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipIoMappings", skipIoMappings));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ProcessDefinitionApi.deleteProcessDefinitionsByKey", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete By Key
   * Deletes process definitions by a given key and which belong to a tenant id.
   * @param key The key of the process definitions to be deleted. (required)
   * @param tenantId The id of the tenant the process definitions belong to. (required)
   * @param cascade &#x60;true&#x60;, if all process instances, historic process instances and jobs for this process definition should be deleted. (optional)
   * @param skipCustomListeners &#x60;true&#x60;, if only the built-in ExecutionListeners should be notified with the end event. (optional, default to false)
   * @param skipIoMappings A boolean value to control whether input/output mappings should be executed during deletion. &#x60;true&#x60;, if input/output mappings should not be invoked. (optional, default to false)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden The process definitions with the given &#x60;key&#x60; cannot be deleted due to missing permissions. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteProcessDefinitionsByKeyAndTenantId(String key, String tenantId, Boolean cascade, Boolean skipCustomListeners, Boolean skipIoMappings) throws ApiException {
    deleteProcessDefinitionsByKeyAndTenantIdWithHttpInfo(key, tenantId, cascade, skipCustomListeners, skipIoMappings);
  }

  /**
   * Delete By Key
   * Deletes process definitions by a given key and which belong to a tenant id.
   * @param key The key of the process definitions to be deleted. (required)
   * @param tenantId The id of the tenant the process definitions belong to. (required)
   * @param cascade &#x60;true&#x60;, if all process instances, historic process instances and jobs for this process definition should be deleted. (optional)
   * @param skipCustomListeners &#x60;true&#x60;, if only the built-in ExecutionListeners should be notified with the end event. (optional, default to false)
   * @param skipIoMappings A boolean value to control whether input/output mappings should be executed during deletion. &#x60;true&#x60;, if input/output mappings should not be invoked. (optional, default to false)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Forbidden The process definitions with the given &#x60;key&#x60; cannot be deleted due to missing permissions. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteProcessDefinitionsByKeyAndTenantIdWithHttpInfo(String key, String tenantId, Boolean cascade, Boolean skipCustomListeners, Boolean skipIoMappings) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling deleteProcessDefinitionsByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling deleteProcessDefinitionsByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "cascade", cascade));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipCustomListeners", skipCustomListeners));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "skipIoMappings", skipIoMappings));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("ProcessDefinitionApi.deleteProcessDefinitionsByKeyAndTenantId", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get Activity Instance Statistics
   * Retrieves runtime statistics of a given process definition, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
   * @param id The id of the process definition. (required)
   * @param failedJobs Whether to include the number of failed jobs in the result or not. Valid values are &#x60;true&#x60; or &#x60;false&#x60;. (optional)
   * @param incidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60;. (optional)
   * @param incidentsForType If this property has been set with any incident type (i.e., a string value) the result will only include the number of incidents for the assigned incident type. Cannot be used in combination with &#x60;incidents&#x60;. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @return List&lt;ActivityStatisticsResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<ActivityStatisticsResultDto> getActivityStatistics(String id, Boolean failedJobs, Boolean incidents, String incidentsForType) throws ApiException {
    return getActivityStatisticsWithHttpInfo(id, failedJobs, incidents, incidentsForType).getData();
  }

  /**
   * Get Activity Instance Statistics
   * Retrieves runtime statistics of a given process definition, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
   * @param id The id of the process definition. (required)
   * @param failedJobs Whether to include the number of failed jobs in the result or not. Valid values are &#x60;true&#x60; or &#x60;false&#x60;. (optional)
   * @param incidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60;. (optional)
   * @param incidentsForType If this property has been set with any incident type (i.e., a string value) the result will only include the number of incidents for the assigned incident type. Cannot be used in combination with &#x60;incidents&#x60;. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @return ApiResponse&lt;List&lt;ActivityStatisticsResultDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ActivityStatisticsResultDto>> getActivityStatisticsWithHttpInfo(String id, Boolean failedJobs, Boolean incidents, String incidentsForType) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getActivityStatistics");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/statistics"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "failedJobs", failedJobs));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidents", incidents));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentsForType", incidentsForType));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<ActivityStatisticsResultDto>> localVarReturnType = new GenericType<List<ActivityStatisticsResultDto>>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getActivityStatistics", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Activity Instance Statistics
   * Retrieves runtime statistics of the latest version of the given process definition which belongs to no tenant, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param failedJobs Whether to include the number of failed jobs in the result or not. Valid values are &#x60;true&#x60; or &#x60;false&#x60;. (optional)
   * @param incidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60;. (optional)
   * @param incidentsForType If this property has been set with any incident type (i.e., a string value) the result will only include the number of incidents for the assigned incident type. Cannot be used in combination with &#x60;incidents&#x60;. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @return List&lt;ActivityStatisticsResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<ActivityStatisticsResultDto> getActivityStatisticsByProcessDefinitionKey(String key, Boolean failedJobs, Boolean incidents, String incidentsForType) throws ApiException {
    return getActivityStatisticsByProcessDefinitionKeyWithHttpInfo(key, failedJobs, incidents, incidentsForType).getData();
  }

  /**
   * Get Activity Instance Statistics
   * Retrieves runtime statistics of the latest version of the given process definition which belongs to no tenant, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param failedJobs Whether to include the number of failed jobs in the result or not. Valid values are &#x60;true&#x60; or &#x60;false&#x60;. (optional)
   * @param incidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60;. (optional)
   * @param incidentsForType If this property has been set with any incident type (i.e., a string value) the result will only include the number of incidents for the assigned incident type. Cannot be used in combination with &#x60;incidents&#x60;. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @return ApiResponse&lt;List&lt;ActivityStatisticsResultDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ActivityStatisticsResultDto>> getActivityStatisticsByProcessDefinitionKeyWithHttpInfo(String key, Boolean failedJobs, Boolean incidents, String incidentsForType) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getActivityStatisticsByProcessDefinitionKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/statistics"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "failedJobs", failedJobs));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidents", incidents));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentsForType", incidentsForType));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<ActivityStatisticsResultDto>> localVarReturnType = new GenericType<List<ActivityStatisticsResultDto>>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getActivityStatisticsByProcessDefinitionKey", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Activity Instance Statistics
   * Retrieves runtime statistics of the latest version of the given process definition for a tenant, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param failedJobs Whether to include the number of failed jobs in the result or not. Valid values are &#x60;true&#x60; or &#x60;false&#x60;. (optional)
   * @param incidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60;. (optional)
   * @param incidentsForType If this property has been set with any incident type (i.e., a string value) the result will only include the number of incidents for the assigned incident type. Cannot be used in combination with &#x60;incidents&#x60;. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @return List&lt;ActivityStatisticsResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<ActivityStatisticsResultDto> getActivityStatisticsByProcessDefinitionKeyAndTenantId(String key, String tenantId, Boolean failedJobs, Boolean incidents, String incidentsForType) throws ApiException {
    return getActivityStatisticsByProcessDefinitionKeyAndTenantIdWithHttpInfo(key, tenantId, failedJobs, incidents, incidentsForType).getData();
  }

  /**
   * Get Activity Instance Statistics
   * Retrieves runtime statistics of the latest version of the given process definition for a tenant, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param failedJobs Whether to include the number of failed jobs in the result or not. Valid values are &#x60;true&#x60; or &#x60;false&#x60;. (optional)
   * @param incidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60;. (optional)
   * @param incidentsForType If this property has been set with any incident type (i.e., a string value) the result will only include the number of incidents for the assigned incident type. Cannot be used in combination with &#x60;incidents&#x60;. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @return ApiResponse&lt;List&lt;ActivityStatisticsResultDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ActivityStatisticsResultDto>> getActivityStatisticsByProcessDefinitionKeyAndTenantIdWithHttpInfo(String key, String tenantId, Boolean failedJobs, Boolean incidents, String incidentsForType) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getActivityStatisticsByProcessDefinitionKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling getActivityStatisticsByProcessDefinitionKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/statistics"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "failedJobs", failedJobs));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidents", incidents));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentsForType", incidentsForType));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<ActivityStatisticsResultDto>> localVarReturnType = new GenericType<List<ActivityStatisticsResultDto>>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getActivityStatisticsByProcessDefinitionKeyAndTenantId", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Deployed Start Form
   * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
   * @param id The id of the process definition to get the deployed start form for. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The form key has wrong format.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The deployed start form cannot be retrieved due to missing permissions on process definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> No deployed start form for a given process definition exists. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getDeployedStartForm(String id) throws ApiException {
    return getDeployedStartFormWithHttpInfo(id).getData();
  }

  /**
   * Get Deployed Start Form
   * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
   * @param id The id of the process definition to get the deployed start form for. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The form key has wrong format.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The deployed start form cannot be retrieved due to missing permissions on process definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> No deployed start form for a given process definition exists. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getDeployedStartFormWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getDeployedStartForm");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/deployed-start-form"
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

    return apiClient.invokeAPI("ProcessDefinitionApi.getDeployedStartForm", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Deployed Start Form
   * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The form key has wrong format.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The deployed start form cannot be retrieved due to missing permissions on process definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> No deployed start form for a given process definition exists. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getDeployedStartFormByKey(String key) throws ApiException {
    return getDeployedStartFormByKeyWithHttpInfo(key).getData();
  }

  /**
   * Get Deployed Start Form
   * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The form key has wrong format.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The deployed start form cannot be retrieved due to missing permissions on process definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> No deployed start form for a given process definition exists. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getDeployedStartFormByKeyWithHttpInfo(String key) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getDeployedStartFormByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/deployed-start-form"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.getDeployedStartFormByKey", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Deployed Start Form
   * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definitions belong to. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The form key has wrong format.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The deployed start form cannot be retrieved due to missing permissions on process definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> No deployed start form for a given process definition exists. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getDeployedStartFormByKeyAndTenantId(String key, String tenantId) throws ApiException {
    return getDeployedStartFormByKeyAndTenantIdWithHttpInfo(key, tenantId).getData();
  }

  /**
   * Get Deployed Start Form
   * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definitions belong to. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The form key has wrong format.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The deployed start form cannot be retrieved due to missing permissions on process definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> No deployed start form for a given process definition exists. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getDeployedStartFormByKeyAndTenantIdWithHttpInfo(String key, String tenantId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getDeployedStartFormByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling getDeployedStartFormByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/deployed-start-form"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.getDeployedStartFormByKeyAndTenantId", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get
   * Retrieves the latest version of the process definition for tenant according to the &#x60;ProcessDefinition&#x60; interface in the engine.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return ProcessDefinitionDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition with given &#x60;key&#x60; does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessDefinitionDto getLatestProcessDefinitionByTenantId(String key, String tenantId) throws ApiException {
    return getLatestProcessDefinitionByTenantIdWithHttpInfo(key, tenantId).getData();
  }

  /**
   * Get
   * Retrieves the latest version of the process definition for tenant according to the &#x60;ProcessDefinition&#x60; interface in the engine.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return ApiResponse&lt;ProcessDefinitionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition with given &#x60;key&#x60; does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessDefinitionDto> getLatestProcessDefinitionByTenantIdWithHttpInfo(String key, String tenantId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getLatestProcessDefinitionByTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling getLatestProcessDefinitionByTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    GenericType<ProcessDefinitionDto> localVarReturnType = new GenericType<ProcessDefinitionDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getLatestProcessDefinitionByTenantId", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get
   * Retrieves a process definition according to the &#x60;ProcessDefinition&#x60; interface in the engine.
   * @param id The id of the process definition to be retrieved. (required)
   * @return ProcessDefinitionDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition with given &#x60;id&#x60; does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessDefinitionDto getProcessDefinition(String id) throws ApiException {
    return getProcessDefinitionWithHttpInfo(id).getData();
  }

  /**
   * Get
   * Retrieves a process definition according to the &#x60;ProcessDefinition&#x60; interface in the engine.
   * @param id The id of the process definition to be retrieved. (required)
   * @return ApiResponse&lt;ProcessDefinitionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition with given &#x60;id&#x60; does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessDefinitionDto> getProcessDefinitionWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProcessDefinition");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}"
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

    GenericType<ProcessDefinitionDto> localVarReturnType = new GenericType<ProcessDefinitionDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinition", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get XML
   * Retrieves the BPMN 2.0 XML of a process definition.
   * @param id The id of the process definition. (required)
   * @return ProcessDefinitionDiagramDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The Process Definition xml cannot be retrieved due to missing permissions on the Process Definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessDefinitionDiagramDto getProcessDefinitionBpmn20Xml(String id) throws ApiException {
    return getProcessDefinitionBpmn20XmlWithHttpInfo(id).getData();
  }

  /**
   * Get XML
   * Retrieves the BPMN 2.0 XML of a process definition.
   * @param id The id of the process definition. (required)
   * @return ApiResponse&lt;ProcessDefinitionDiagramDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The Process Definition xml cannot be retrieved due to missing permissions on the Process Definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessDefinitionDiagramDto> getProcessDefinitionBpmn20XmlWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProcessDefinitionBpmn20Xml");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/xml"
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

    GenericType<ProcessDefinitionDiagramDto> localVarReturnType = new GenericType<ProcessDefinitionDiagramDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionBpmn20Xml", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get XML
   * Retrieves latest version the BPMN 2.0 XML of a process definition.
   * @param key The key of the process definition (the latest version thereof) whose XML should be retrieved. (required)
   * @return ProcessDefinitionDiagramDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The Process Definition xml cannot be retrieved due to missing permissions on the Process Definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessDefinitionDiagramDto getProcessDefinitionBpmn20XmlByKey(String key) throws ApiException {
    return getProcessDefinitionBpmn20XmlByKeyWithHttpInfo(key).getData();
  }

  /**
   * Get XML
   * Retrieves latest version the BPMN 2.0 XML of a process definition.
   * @param key The key of the process definition (the latest version thereof) whose XML should be retrieved. (required)
   * @return ApiResponse&lt;ProcessDefinitionDiagramDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The Process Definition xml cannot be retrieved due to missing permissions on the Process Definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessDefinitionDiagramDto> getProcessDefinitionBpmn20XmlByKeyWithHttpInfo(String key) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getProcessDefinitionBpmn20XmlByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/xml"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    GenericType<ProcessDefinitionDiagramDto> localVarReturnType = new GenericType<ProcessDefinitionDiagramDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionBpmn20XmlByKey", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get XML
   * Retrieves latest version the BPMN 2.0 XML of a process definition. Returns the XML for the latest version of the process definition for tenant.
   * @param key The key of the process definition (the latest version thereof) whose XML should be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return ProcessDefinitionDiagramDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The Process Definition xml cannot be retrieved due to missing permissions on the Process Definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessDefinitionDiagramDto getProcessDefinitionBpmn20XmlByKeyAndTenantId(String key, String tenantId) throws ApiException {
    return getProcessDefinitionBpmn20XmlByKeyAndTenantIdWithHttpInfo(key, tenantId).getData();
  }

  /**
   * Get XML
   * Retrieves latest version the BPMN 2.0 XML of a process definition. Returns the XML for the latest version of the process definition for tenant.
   * @param key The key of the process definition (the latest version thereof) whose XML should be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return ApiResponse&lt;ProcessDefinitionDiagramDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The Process Definition xml cannot be retrieved due to missing permissions on the Process Definition resource. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessDefinitionDiagramDto> getProcessDefinitionBpmn20XmlByKeyAndTenantIdWithHttpInfo(String key, String tenantId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getProcessDefinitionBpmn20XmlByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling getProcessDefinitionBpmn20XmlByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/xml"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    GenericType<ProcessDefinitionDiagramDto> localVarReturnType = new GenericType<ProcessDefinitionDiagramDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionBpmn20XmlByKeyAndTenantId", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get
   * Retrieves the latest version of the process definition which belongs to no tenant according to the &#x60;ProcessDefinition&#x60; interface in the engine.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @return ProcessDefinitionDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition with given &#x60;key&#x60; does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessDefinitionDto getProcessDefinitionByKey(String key) throws ApiException {
    return getProcessDefinitionByKeyWithHttpInfo(key).getData();
  }

  /**
   * Get
   * Retrieves the latest version of the process definition which belongs to no tenant according to the &#x60;ProcessDefinition&#x60; interface in the engine.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @return ApiResponse&lt;ProcessDefinitionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition with given &#x60;key&#x60; does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessDefinitionDto> getProcessDefinitionByKeyWithHttpInfo(String key) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getProcessDefinitionByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    GenericType<ProcessDefinitionDto> localVarReturnType = new GenericType<ProcessDefinitionDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionByKey", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Diagram
   * Retrieves the diagram of a process definition.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
   * @param id The id of the process definition. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The image diagram of this process. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> The process definition doesn&#39;t have an associated diagram. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getProcessDefinitionDiagram(String id) throws ApiException {
    return getProcessDefinitionDiagramWithHttpInfo(id).getData();
  }

  /**
   * Get Diagram
   * Retrieves the diagram of a process definition.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
   * @param id The id of the process definition. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The image diagram of this process. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> The process definition doesn&#39;t have an associated diagram. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getProcessDefinitionDiagramWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getProcessDefinitionDiagram");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/diagram"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/octet-stream", "*/*", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<File> localVarReturnType = new GenericType<File>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionDiagram", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Diagram
   * Retrieves the diagram for the latest version of the process definition which belongs to no tenant.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
   * @param key The key of the process definition. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The image diagram of this process. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> The process definition doesn&#39;t have an associated diagram. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getProcessDefinitionDiagramByKey(String key) throws ApiException {
    return getProcessDefinitionDiagramByKeyWithHttpInfo(key).getData();
  }

  /**
   * Get Diagram
   * Retrieves the diagram for the latest version of the process definition which belongs to no tenant.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
   * @param key The key of the process definition. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The image diagram of this process. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> The process definition doesn&#39;t have an associated diagram. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getProcessDefinitionDiagramByKeyWithHttpInfo(String key) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getProcessDefinitionDiagramByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/diagram"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/octet-stream", "*/*", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<File> localVarReturnType = new GenericType<File>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionDiagramByKey", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Diagram
   * Retrieves the diagram for the latest version of the process definition for tenant.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
   * @param key The key of the process definition. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The image diagram of this process. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> The process definition doesn&#39;t have an associated diagram. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getProcessDefinitionDiagramByKeyAndTenantId(String key, String tenantId) throws ApiException {
    return getProcessDefinitionDiagramByKeyAndTenantIdWithHttpInfo(key, tenantId).getData();
  }

  /**
   * Get Diagram
   * Retrieves the diagram for the latest version of the process definition for tenant.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
   * @param key The key of the process definition. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. The image diagram of this process. </td><td>  -  </td></tr>
       <tr><td> 204 </td><td> The process definition doesn&#39;t have an associated diagram. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getProcessDefinitionDiagramByKeyAndTenantIdWithHttpInfo(String key, String tenantId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getProcessDefinitionDiagramByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling getProcessDefinitionDiagramByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/diagram"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();


    
    
    
    final String[] localVarAccepts = {
      "application/octet-stream", "*/*", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<File> localVarReturnType = new GenericType<File>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionDiagramByKeyAndTenantId", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Process Instance Statistics
   * Retrieves runtime statistics of the process engine, grouped by process definitions. These statistics include the number of running process instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
   * @param failedJobs Whether to include the number of failed jobs in the result or not. Valid values are &#x60;true&#x60; or &#x60;false&#x60;. (optional)
   * @param incidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60;. (optional)
   * @param incidentsForType If this property has been set with any incident type (i.e., a string value) the result will only include the number of incidents for the assigned incident type. Cannot be used in combination with &#x60;incidents&#x60;. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param rootIncidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of root incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60; or &#x60;incidents&#x60;. (optional)
   * @return List&lt;ProcessDefinitionStatisticsResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<ProcessDefinitionStatisticsResultDto> getProcessDefinitionStatistics(Boolean failedJobs, Boolean incidents, String incidentsForType, Boolean rootIncidents) throws ApiException {
    return getProcessDefinitionStatisticsWithHttpInfo(failedJobs, incidents, incidentsForType, rootIncidents).getData();
  }

  /**
   * Get Process Instance Statistics
   * Retrieves runtime statistics of the process engine, grouped by process definitions. These statistics include the number of running process instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
   * @param failedJobs Whether to include the number of failed jobs in the result or not. Valid values are &#x60;true&#x60; or &#x60;false&#x60;. (optional)
   * @param incidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60;. (optional)
   * @param incidentsForType If this property has been set with any incident type (i.e., a string value) the result will only include the number of incidents for the assigned incident type. Cannot be used in combination with &#x60;incidents&#x60;. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param rootIncidents Valid values for this property are &#x60;true&#x60; or &#x60;false&#x60;. If this property has been set to &#x60;true&#x60; the result will include the corresponding number of root incidents for each occurred incident type. If it is set to &#x60;false&#x60;, the incidents will not be included in the result. Cannot be used in combination with &#x60;incidentsForType&#x60; or &#x60;incidents&#x60;. (optional)
   * @return ApiResponse&lt;List&lt;ProcessDefinitionStatisticsResultDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ProcessDefinitionStatisticsResultDto>> getProcessDefinitionStatisticsWithHttpInfo(Boolean failedJobs, Boolean incidents, String incidentsForType, Boolean rootIncidents) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/process-definition/statistics";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "failedJobs", failedJobs));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidents", incidents));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentsForType", incidentsForType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rootIncidents", rootIncidents));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<ProcessDefinitionStatisticsResultDto>> localVarReturnType = new GenericType<List<ProcessDefinitionStatisticsResultDto>>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionStatistics", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List
   * Queries for process definitions that fulfill given parameters. Parameters may be the properties of  process definitions, such as the name, key or version. The size of the result set can be retrieved by using the [Get Definition Count](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/get-query-count/) method.
   * @param processDefinitionId Filter by process definition id. (optional)
   * @param processDefinitionIdIn Filter by a comma-separated list of process definition ids. (optional)
   * @param name Filter by process definition name. (optional)
   * @param nameLike Filter by process definition names that the parameter is a substring of. (optional)
   * @param deploymentId Filter by the deployment the id belongs to. (optional)
   * @param deployedAfter Filter by the deploy time of the deployment the process definition belongs to. Only selects process definitions that have been deployed after (exclusive) a specific time. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param deployedAt Filter by the deploy time of the deployment the process definition belongs to. Only selects process definitions that have been deployed at a specific time (exact match). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param key Filter by process definition key, i.e., the id in the BPMN 2.0 XML. Exact match. (optional)
   * @param keysIn Filter by a comma-separated list of process definition keys. (optional)
   * @param keyLike Filter by process definition keys that the parameter is a substring of. (optional)
   * @param category Filter by process definition category. Exact match. (optional)
   * @param categoryLike Filter by process definition categories that the parameter is a substring of. (optional)
   * @param version Filter by process definition version. (optional)
   * @param latestVersion Only include those process definitions that are latest versions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param resourceName Filter by the name of the process definition resource. Exact match. (optional)
   * @param resourceNameLike Filter by names of those process definition resources that the parameter is a substring of. (optional)
   * @param startableBy Filter by a user name who is allowed to start the process. (optional)
   * @param active Only include active process definitions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param suspended Only include suspended process definitions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param incidentId Filter by the incident id. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. A process definition must have one of the given tenant ids. (optional)
   * @param withoutTenantId Only include process definitions which belong to no tenant. Value may only be true, as false is the default behavior. (optional)
   * @param includeProcessDefinitionsWithoutTenantId Include process definitions which belong to no tenant. Can be used in combination with &#x60;tenantIdIn&#x60;. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param versionTag Filter by the version tag. (optional)
   * @param versionTagLike Filter by the version tag that the parameter is a substring of. (optional)
   * @param withoutVersionTag Only include process definitions without a &#x60;versionTag&#x60;. (optional)
   * @param startableInTasklist Filter by process definitions which are startable in Tasklist.. (optional)
   * @param notStartableInTasklist Filter by process definitions which are not startable in Tasklist. (optional)
   * @param startablePermissionCheck Filter by process definitions which the user is allowed to start in Tasklist. If the user doesn&#39;t have these permissions the result will be empty list. The permissions are: * &#x60;CREATE&#x60; permission for all Process instances * &#x60;CREATE_INSTANCE&#x60; and &#x60;READ&#x60; permission on Process definition level (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return List&lt;ProcessDefinitionDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<ProcessDefinitionDto> getProcessDefinitions(String processDefinitionId, String processDefinitionIdIn, String name, String nameLike, String deploymentId, OffsetDateTime deployedAfter, OffsetDateTime deployedAt, String key, String keysIn, String keyLike, String category, String categoryLike, Integer version, Boolean latestVersion, String resourceName, String resourceNameLike, String startableBy, Boolean active, Boolean suspended, String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String tenantIdIn, Boolean withoutTenantId, Boolean includeProcessDefinitionsWithoutTenantId, String versionTag, String versionTagLike, Boolean withoutVersionTag, Boolean startableInTasklist, Boolean notStartableInTasklist, Boolean startablePermissionCheck, String sortBy, String sortOrder, Integer firstResult, Integer maxResults) throws ApiException {
    return getProcessDefinitionsWithHttpInfo(processDefinitionId, processDefinitionIdIn, name, nameLike, deploymentId, deployedAfter, deployedAt, key, keysIn, keyLike, category, categoryLike, version, latestVersion, resourceName, resourceNameLike, startableBy, active, suspended, incidentId, incidentType, incidentMessage, incidentMessageLike, tenantIdIn, withoutTenantId, includeProcessDefinitionsWithoutTenantId, versionTag, versionTagLike, withoutVersionTag, startableInTasklist, notStartableInTasklist, startablePermissionCheck, sortBy, sortOrder, firstResult, maxResults).getData();
  }

  /**
   * Get List
   * Queries for process definitions that fulfill given parameters. Parameters may be the properties of  process definitions, such as the name, key or version. The size of the result set can be retrieved by using the [Get Definition Count](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/get-query-count/) method.
   * @param processDefinitionId Filter by process definition id. (optional)
   * @param processDefinitionIdIn Filter by a comma-separated list of process definition ids. (optional)
   * @param name Filter by process definition name. (optional)
   * @param nameLike Filter by process definition names that the parameter is a substring of. (optional)
   * @param deploymentId Filter by the deployment the id belongs to. (optional)
   * @param deployedAfter Filter by the deploy time of the deployment the process definition belongs to. Only selects process definitions that have been deployed after (exclusive) a specific time. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param deployedAt Filter by the deploy time of the deployment the process definition belongs to. Only selects process definitions that have been deployed at a specific time (exact match). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param key Filter by process definition key, i.e., the id in the BPMN 2.0 XML. Exact match. (optional)
   * @param keysIn Filter by a comma-separated list of process definition keys. (optional)
   * @param keyLike Filter by process definition keys that the parameter is a substring of. (optional)
   * @param category Filter by process definition category. Exact match. (optional)
   * @param categoryLike Filter by process definition categories that the parameter is a substring of. (optional)
   * @param version Filter by process definition version. (optional)
   * @param latestVersion Only include those process definitions that are latest versions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param resourceName Filter by the name of the process definition resource. Exact match. (optional)
   * @param resourceNameLike Filter by names of those process definition resources that the parameter is a substring of. (optional)
   * @param startableBy Filter by a user name who is allowed to start the process. (optional)
   * @param active Only include active process definitions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param suspended Only include suspended process definitions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param incidentId Filter by the incident id. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. A process definition must have one of the given tenant ids. (optional)
   * @param withoutTenantId Only include process definitions which belong to no tenant. Value may only be true, as false is the default behavior. (optional)
   * @param includeProcessDefinitionsWithoutTenantId Include process definitions which belong to no tenant. Can be used in combination with &#x60;tenantIdIn&#x60;. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param versionTag Filter by the version tag. (optional)
   * @param versionTagLike Filter by the version tag that the parameter is a substring of. (optional)
   * @param withoutVersionTag Only include process definitions without a &#x60;versionTag&#x60;. (optional)
   * @param startableInTasklist Filter by process definitions which are startable in Tasklist.. (optional)
   * @param notStartableInTasklist Filter by process definitions which are not startable in Tasklist. (optional)
   * @param startablePermissionCheck Filter by process definitions which the user is allowed to start in Tasklist. If the user doesn&#39;t have these permissions the result will be empty list. The permissions are: * &#x60;CREATE&#x60; permission for all Process instances * &#x60;CREATE_INSTANCE&#x60; and &#x60;READ&#x60; permission on Process definition level (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return ApiResponse&lt;List&lt;ProcessDefinitionDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<ProcessDefinitionDto>> getProcessDefinitionsWithHttpInfo(String processDefinitionId, String processDefinitionIdIn, String name, String nameLike, String deploymentId, OffsetDateTime deployedAfter, OffsetDateTime deployedAt, String key, String keysIn, String keyLike, String category, String categoryLike, Integer version, Boolean latestVersion, String resourceName, String resourceNameLike, String startableBy, Boolean active, Boolean suspended, String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String tenantIdIn, Boolean withoutTenantId, Boolean includeProcessDefinitionsWithoutTenantId, String versionTag, String versionTagLike, Boolean withoutVersionTag, Boolean startableInTasklist, Boolean notStartableInTasklist, Boolean startablePermissionCheck, String sortBy, String sortOrder, Integer firstResult, Integer maxResults) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/process-definition";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionIdIn", processDefinitionIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameLike", nameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deploymentId", deploymentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deployedAfter", deployedAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deployedAt", deployedAt));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "keysIn", keysIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "keyLike", keyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "category", category));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "categoryLike", categoryLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "version", version));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "latestVersion", latestVersion));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "resourceName", resourceName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "resourceNameLike", resourceNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startableBy", startableBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentId", incidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentType", incidentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessage", incidentMessage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessageLike", incidentMessageLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutTenantId", withoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "includeProcessDefinitionsWithoutTenantId", includeProcessDefinitionsWithoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "versionTag", versionTag));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "versionTagLike", versionTagLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutVersionTag", withoutVersionTag));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startableInTasklist", startableInTasklist));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "notStartableInTasklist", notStartableInTasklist));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startablePermissionCheck", startablePermissionCheck));
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

    GenericType<List<ProcessDefinitionDto>> localVarReturnType = new GenericType<List<ProcessDefinitionDto>>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitions", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List Count
   * Requests the number of process definitions that fulfill the query criteria. Takes the same filtering parameters as the [Get Definitions](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/get-query/) method.
   * @param processDefinitionId Filter by process definition id. (optional)
   * @param processDefinitionIdIn Filter by a comma-separated list of process definition ids. (optional)
   * @param name Filter by process definition name. (optional)
   * @param nameLike Filter by process definition names that the parameter is a substring of. (optional)
   * @param deploymentId Filter by the deployment the id belongs to. (optional)
   * @param deployedAfter Filter by the deploy time of the deployment the process definition belongs to. Only selects process definitions that have been deployed after (exclusive) a specific time. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param deployedAt Filter by the deploy time of the deployment the process definition belongs to. Only selects process definitions that have been deployed at a specific time (exact match). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param key Filter by process definition key, i.e., the id in the BPMN 2.0 XML. Exact match. (optional)
   * @param keysIn Filter by a comma-separated list of process definition keys. (optional)
   * @param keyLike Filter by process definition keys that the parameter is a substring of. (optional)
   * @param category Filter by process definition category. Exact match. (optional)
   * @param categoryLike Filter by process definition categories that the parameter is a substring of. (optional)
   * @param version Filter by process definition version. (optional)
   * @param latestVersion Only include those process definitions that are latest versions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param resourceName Filter by the name of the process definition resource. Exact match. (optional)
   * @param resourceNameLike Filter by names of those process definition resources that the parameter is a substring of. (optional)
   * @param startableBy Filter by a user name who is allowed to start the process. (optional)
   * @param active Only include active process definitions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param suspended Only include suspended process definitions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param incidentId Filter by the incident id. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. A process definition must have one of the given tenant ids. (optional)
   * @param withoutTenantId Only include process definitions which belong to no tenant. Value may only be true, as false is the default behavior. (optional)
   * @param includeProcessDefinitionsWithoutTenantId Include process definitions which belong to no tenant. Can be used in combination with &#x60;tenantIdIn&#x60;. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param versionTag Filter by the version tag. (optional)
   * @param versionTagLike Filter by the version tag that the parameter is a substring of. (optional)
   * @param withoutVersionTag Only include process definitions without a &#x60;versionTag&#x60;. (optional)
   * @param startableInTasklist Filter by process definitions which are startable in Tasklist.. (optional)
   * @param notStartableInTasklist Filter by process definitions which are not startable in Tasklist. (optional)
   * @param startablePermissionCheck Filter by process definitions which the user is allowed to start in Tasklist. If the user doesn&#39;t have these permissions the result will be empty list. The permissions are: * &#x60;CREATE&#x60; permission for all Process instances * &#x60;CREATE_INSTANCE&#x60; and &#x60;READ&#x60; permission on Process definition level (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto getProcessDefinitionsCount(String processDefinitionId, String processDefinitionIdIn, String name, String nameLike, String deploymentId, OffsetDateTime deployedAfter, OffsetDateTime deployedAt, String key, String keysIn, String keyLike, String category, String categoryLike, Integer version, Boolean latestVersion, String resourceName, String resourceNameLike, String startableBy, Boolean active, Boolean suspended, String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String tenantIdIn, Boolean withoutTenantId, Boolean includeProcessDefinitionsWithoutTenantId, String versionTag, String versionTagLike, Boolean withoutVersionTag, Boolean startableInTasklist, Boolean notStartableInTasklist, Boolean startablePermissionCheck) throws ApiException {
    return getProcessDefinitionsCountWithHttpInfo(processDefinitionId, processDefinitionIdIn, name, nameLike, deploymentId, deployedAfter, deployedAt, key, keysIn, keyLike, category, categoryLike, version, latestVersion, resourceName, resourceNameLike, startableBy, active, suspended, incidentId, incidentType, incidentMessage, incidentMessageLike, tenantIdIn, withoutTenantId, includeProcessDefinitionsWithoutTenantId, versionTag, versionTagLike, withoutVersionTag, startableInTasklist, notStartableInTasklist, startablePermissionCheck).getData();
  }

  /**
   * Get List Count
   * Requests the number of process definitions that fulfill the query criteria. Takes the same filtering parameters as the [Get Definitions](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/get-query/) method.
   * @param processDefinitionId Filter by process definition id. (optional)
   * @param processDefinitionIdIn Filter by a comma-separated list of process definition ids. (optional)
   * @param name Filter by process definition name. (optional)
   * @param nameLike Filter by process definition names that the parameter is a substring of. (optional)
   * @param deploymentId Filter by the deployment the id belongs to. (optional)
   * @param deployedAfter Filter by the deploy time of the deployment the process definition belongs to. Only selects process definitions that have been deployed after (exclusive) a specific time. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param deployedAt Filter by the deploy time of the deployment the process definition belongs to. Only selects process definitions that have been deployed at a specific time (exact match). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.546+0200&#x60;. (optional)
   * @param key Filter by process definition key, i.e., the id in the BPMN 2.0 XML. Exact match. (optional)
   * @param keysIn Filter by a comma-separated list of process definition keys. (optional)
   * @param keyLike Filter by process definition keys that the parameter is a substring of. (optional)
   * @param category Filter by process definition category. Exact match. (optional)
   * @param categoryLike Filter by process definition categories that the parameter is a substring of. (optional)
   * @param version Filter by process definition version. (optional)
   * @param latestVersion Only include those process definitions that are latest versions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param resourceName Filter by the name of the process definition resource. Exact match. (optional)
   * @param resourceNameLike Filter by names of those process definition resources that the parameter is a substring of. (optional)
   * @param startableBy Filter by a user name who is allowed to start the process. (optional)
   * @param active Only include active process definitions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param suspended Only include suspended process definitions. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param incidentId Filter by the incident id. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param tenantIdIn Filter by a comma-separated list of tenant ids. A process definition must have one of the given tenant ids. (optional)
   * @param withoutTenantId Only include process definitions which belong to no tenant. Value may only be true, as false is the default behavior. (optional)
   * @param includeProcessDefinitionsWithoutTenantId Include process definitions which belong to no tenant. Can be used in combination with &#x60;tenantIdIn&#x60;. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param versionTag Filter by the version tag. (optional)
   * @param versionTagLike Filter by the version tag that the parameter is a substring of. (optional)
   * @param withoutVersionTag Only include process definitions without a &#x60;versionTag&#x60;. (optional)
   * @param startableInTasklist Filter by process definitions which are startable in Tasklist.. (optional)
   * @param notStartableInTasklist Filter by process definitions which are not startable in Tasklist. (optional)
   * @param startablePermissionCheck Filter by process definitions which the user is allowed to start in Tasklist. If the user doesn&#39;t have these permissions the result will be empty list. The permissions are: * &#x60;CREATE&#x60; permission for all Process instances * &#x60;CREATE_INSTANCE&#x60; and &#x60;READ&#x60; permission on Process definition level (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> getProcessDefinitionsCountWithHttpInfo(String processDefinitionId, String processDefinitionIdIn, String name, String nameLike, String deploymentId, OffsetDateTime deployedAfter, OffsetDateTime deployedAt, String key, String keysIn, String keyLike, String category, String categoryLike, Integer version, Boolean latestVersion, String resourceName, String resourceNameLike, String startableBy, Boolean active, Boolean suspended, String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String tenantIdIn, Boolean withoutTenantId, Boolean includeProcessDefinitionsWithoutTenantId, String versionTag, String versionTagLike, Boolean withoutVersionTag, Boolean startableInTasklist, Boolean notStartableInTasklist, Boolean startablePermissionCheck) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/process-definition/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionIdIn", processDefinitionIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "nameLike", nameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deploymentId", deploymentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deployedAfter", deployedAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "deployedAt", deployedAt));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "key", key));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "keysIn", keysIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "keyLike", keyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "category", category));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "categoryLike", categoryLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "version", version));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "latestVersion", latestVersion));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "resourceName", resourceName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "resourceNameLike", resourceNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startableBy", startableBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentId", incidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentType", incidentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessage", incidentMessage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessageLike", incidentMessageLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutTenantId", withoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "includeProcessDefinitionsWithoutTenantId", includeProcessDefinitionsWithoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "versionTag", versionTag));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "versionTagLike", versionTagLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutVersionTag", withoutVersionTag));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startableInTasklist", startableInTasklist));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "notStartableInTasklist", notStartableInTasklist));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startablePermissionCheck", startablePermissionCheck));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<CountResultDto> localVarReturnType = new GenericType<CountResultDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.getProcessDefinitionsCount", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Rendered Start Form
   * Retrieves the rendered form for a process definition. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param id The id of the process definition to get the rendered start form for. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no form field metadata defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getRenderedStartForm(String id) throws ApiException {
    return getRenderedStartFormWithHttpInfo(id).getData();
  }

  /**
   * Get Rendered Start Form
   * Retrieves the rendered form for a process definition. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param id The id of the process definition to get the rendered start form for. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no form field metadata defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getRenderedStartFormWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getRenderedStartForm");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/rendered-form"
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

    return apiClient.invokeAPI("ProcessDefinitionApi.getRenderedStartForm", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Rendered Start Form
   * Retrieves  the rendered form for the latest version of the process definition which belongs to no tenant. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no form field metadata defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getRenderedStartFormByKey(String key) throws ApiException {
    return getRenderedStartFormByKeyWithHttpInfo(key).getData();
  }

  /**
   * Get Rendered Start Form
   * Retrieves  the rendered form for the latest version of the process definition which belongs to no tenant. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no form field metadata defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getRenderedStartFormByKeyWithHttpInfo(String key) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getRenderedStartFormByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/rendered-form"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.getRenderedStartFormByKey", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Rendered Start Form
   * Retrieves  the rendered form for the latest version of the process definition for a tenant. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no form field metadata defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getRenderedStartFormByKeyAndTenantId(String key, String tenantId) throws ApiException {
    return getRenderedStartFormByKeyAndTenantIdWithHttpInfo(key, tenantId).getData();
  }

  /**
   * Get Rendered Start Form
   * Retrieves  the rendered form for the latest version of the process definition for a tenant. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no form field metadata defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getRenderedStartFormByKeyAndTenantIdWithHttpInfo(String key, String tenantId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getRenderedStartFormByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling getRenderedStartFormByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/rendered-form"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.getRenderedStartFormByKeyAndTenantId", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Start Form Key
   * Retrieves the key of the start form for a process definition. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
   * @param id The id of the process definition to get the start form key for. (required)
   * @return FormDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no start form defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public FormDto getStartForm(String id) throws ApiException {
    return getStartFormWithHttpInfo(id).getData();
  }

  /**
   * Get Start Form Key
   * Retrieves the key of the start form for a process definition. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
   * @param id The id of the process definition to get the start form key for. (required)
   * @return ApiResponse&lt;FormDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no start form defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<FormDto> getStartFormWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getStartForm");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/startForm"
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

    return apiClient.invokeAPI("ProcessDefinitionApi.getStartForm", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Start Form Key
   * Retrieves the key of the start form for the latest version of the process definition which belongs to no tenant. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
   * @param key The key of the process definition (the latest version thereof) for which the form key is to be retrieved. (required)
   * @return FormDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no start form defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public FormDto getStartFormByKey(String key) throws ApiException {
    return getStartFormByKeyWithHttpInfo(key).getData();
  }

  /**
   * Get Start Form Key
   * Retrieves the key of the start form for the latest version of the process definition which belongs to no tenant. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
   * @param key The key of the process definition (the latest version thereof) for which the form key is to be retrieved. (required)
   * @return ApiResponse&lt;FormDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no start form defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<FormDto> getStartFormByKeyWithHttpInfo(String key) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getStartFormByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/startForm"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.getStartFormByKey", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Start Form Key
   * Retrieves the key of the start form for the latest version of the process definition for a tenant. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
   * @param key The key of the process definition (the latest version thereof) for which the form key is to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return FormDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no start form defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public FormDto getStartFormByKeyAndTenantId(String key, String tenantId) throws ApiException {
    return getStartFormByKeyAndTenantIdWithHttpInfo(key, tenantId).getData();
  }

  /**
   * Get Start Form Key
   * Retrieves the key of the start form for the latest version of the process definition for a tenant. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
   * @param key The key of the process definition (the latest version thereof) for which the form key is to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @return ApiResponse&lt;FormDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Process definition has no start form defined. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<FormDto> getStartFormByKeyAndTenantIdWithHttpInfo(String key, String tenantId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getStartFormByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling getStartFormByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/startForm"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.getStartFormByKeyAndTenantId", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Start Form Variables
   * Retrieves the start form variables for a process definition (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
   * @param id The id of the process definition to retrieve the variables for. (required)
   * @param variableNames A comma-separated list of variable names. Allows restricting the list of requested variables to the variable names in the list. It is best practice to restrict the list of variables to the variables actually required by the form in order to minimize fetching of data. If the query parameter is ommitted all variables are fetched. If the query parameter contains non-existent variable names, the variable names are ignored. (optional)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](http://jackson.codehaus.org/) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note**: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return Map&lt;String, VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. A JSON object containing a property for each variable returned. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The id is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, VariableValueDto> getStartFormVariables(String id, String variableNames, Boolean deserializeValues) throws ApiException {
    return getStartFormVariablesWithHttpInfo(id, variableNames, deserializeValues).getData();
  }

  /**
   * Get Start Form Variables
   * Retrieves the start form variables for a process definition (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
   * @param id The id of the process definition to retrieve the variables for. (required)
   * @param variableNames A comma-separated list of variable names. Allows restricting the list of requested variables to the variable names in the list. It is best practice to restrict the list of variables to the variables actually required by the form in order to minimize fetching of data. If the query parameter is ommitted all variables are fetched. If the query parameter contains non-existent variable names, the variable names are ignored. (optional)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](http://jackson.codehaus.org/) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note**: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return ApiResponse&lt;Map&lt;String, VariableValueDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. A JSON object containing a property for each variable returned. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The id is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, VariableValueDto>> getStartFormVariablesWithHttpInfo(String id, String variableNames, Boolean deserializeValues) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getStartFormVariables");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/form-variables"
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

    return apiClient.invokeAPI("ProcessDefinitionApi.getStartFormVariables", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Start Form Variables
   * Retrieves the start form variables for the latest process definition which belongs to no tenant (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param variableNames A comma-separated list of variable names. Allows restricting the list of requested variables to the variable names in the list. It is best practice to restrict the list of variables to the variables actually required by the form in order to minimize fetching of data. If the query parameter is ommitted all variables are fetched. If the query parameter contains non-existent variable names, the variable names are ignored. (optional)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](http://jackson.codehaus.org/) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note**: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return Map&lt;String, VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. A JSON object containing a property for each variable returned. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The key is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, VariableValueDto> getStartFormVariablesByKey(String key, String variableNames, Boolean deserializeValues) throws ApiException {
    return getStartFormVariablesByKeyWithHttpInfo(key, variableNames, deserializeValues).getData();
  }

  /**
   * Get Start Form Variables
   * Retrieves the start form variables for the latest process definition which belongs to no tenant (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param variableNames A comma-separated list of variable names. Allows restricting the list of requested variables to the variable names in the list. It is best practice to restrict the list of variables to the variables actually required by the form in order to minimize fetching of data. If the query parameter is ommitted all variables are fetched. If the query parameter contains non-existent variable names, the variable names are ignored. (optional)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](http://jackson.codehaus.org/) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note**: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return ApiResponse&lt;Map&lt;String, VariableValueDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. A JSON object containing a property for each variable returned. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The key is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, VariableValueDto>> getStartFormVariablesByKeyWithHttpInfo(String key, String variableNames, Boolean deserializeValues) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getStartFormVariablesByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/form-variables"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.getStartFormVariablesByKey", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Start Form Variables
   * Retrieves the start form variables for the latest process definition for a tenant (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param variableNames A comma-separated list of variable names. Allows restricting the list of requested variables to the variable names in the list. It is best practice to restrict the list of variables to the variables actually required by the form in order to minimize fetching of data. If the query parameter is ommitted all variables are fetched. If the query parameter contains non-existent variable names, the variable names are ignored. (optional)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](http://jackson.codehaus.org/) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note**: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return Map&lt;String, VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. A JSON object containing a property for each variable returned. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The key is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, VariableValueDto> getStartFormVariablesByKeyAndTenantId(String key, String tenantId, String variableNames, Boolean deserializeValues) throws ApiException {
    return getStartFormVariablesByKeyAndTenantIdWithHttpInfo(key, tenantId, variableNames, deserializeValues).getData();
  }

  /**
   * Get Start Form Variables
   * Retrieves the start form variables for the latest process definition for a tenant (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param variableNames A comma-separated list of variable names. Allows restricting the list of requested variables to the variable names in the list. It is best practice to restrict the list of variables to the variables actually required by the form in order to minimize fetching of data. If the query parameter is ommitted all variables are fetched. If the query parameter contains non-existent variable names, the variable names are ignored. (optional)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on server side (default true).  If set to true, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](http://jackson.codehaus.org/) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to false, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note**: While true is the default value for reasons of backward compatibility, we recommend setting this parameter to false when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return ApiResponse&lt;Map&lt;String, VariableValueDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. A JSON object containing a property for each variable returned. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> The key is null or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, VariableValueDto>> getStartFormVariablesByKeyAndTenantIdWithHttpInfo(String key, String tenantId, String variableNames, Boolean deserializeValues) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling getStartFormVariablesByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling getStartFormVariablesByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/form-variables"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.getStartFormVariablesByKeyAndTenantId", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Restart Process Instance
   * Restarts process instances that were canceled or terminated synchronously. Can also restart completed process instances. It will create a new instance using the original instance information. To execute the restart asynchronously, use the [Restart Process Instance Async](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/post-restart-process-instance-async/) method.  For more information about the difference between synchronous and asynchronous execution, please refer to the related section of the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/process-instance-restart/#execution).
   * @param id The id of the process definition of the process instances to restart. (required)
   * @param restartProcessInstanceDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> In case following parameters are missing: &#x60;instructions&#x60;, &#x60;activityId&#x60; or &#x60;transitionId&#x60;, &#x60;processInstanceIds&#x60; or &#x60;historicProcessInstanceQuery&#x60;, an exception of type &#x60;InvalidRequestException&#x60; is returned.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void restartProcessInstance(String id, RestartProcessInstanceDto restartProcessInstanceDto) throws ApiException {
    restartProcessInstanceWithHttpInfo(id, restartProcessInstanceDto);
  }

  /**
   * Restart Process Instance
   * Restarts process instances that were canceled or terminated synchronously. Can also restart completed process instances. It will create a new instance using the original instance information. To execute the restart asynchronously, use the [Restart Process Instance Async](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/post-restart-process-instance-async/) method.  For more information about the difference between synchronous and asynchronous execution, please refer to the related section of the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/process-instance-restart/#execution).
   * @param id The id of the process definition of the process instances to restart. (required)
   * @param restartProcessInstanceDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> In case following parameters are missing: &#x60;instructions&#x60;, &#x60;activityId&#x60; or &#x60;transitionId&#x60;, &#x60;processInstanceIds&#x60; or &#x60;historicProcessInstanceQuery&#x60;, an exception of type &#x60;InvalidRequestException&#x60; is returned.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> restartProcessInstanceWithHttpInfo(String id, RestartProcessInstanceDto restartProcessInstanceDto) throws ApiException {
    Object localVarPostBody = restartProcessInstanceDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling restartProcessInstance");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/restart"
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

    return apiClient.invokeAPI("ProcessDefinitionApi.restartProcessInstance", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Restart Process Instance Async
   * Restarts process instances that were canceled or terminated asynchronously. Can also restart completed process instances. It will create a new instance using the original instance information. To execute the restart asynchronously, use the [Restart Process Instance](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/post-restart-process-instance-sync/) method.  For more information about the difference between synchronous and asynchronous execution, please refer to the related section of the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/process-instance-restart/#execution).
   * @param id The id of the process definition of the process instances to restart. (required)
   * @param restartProcessInstanceDto  (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> In case following parameters are missing: &#x60;instructions&#x60;, &#x60;activityId&#x60; or &#x60;transitionId&#x60;, &#x60;processInstanceIds&#x60; or &#x60;historicProcessInstanceQuery&#x60;, an exception of type &#x60;InvalidRequestException&#x60; is returned.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto restartProcessInstanceAsyncOperation(String id, RestartProcessInstanceDto restartProcessInstanceDto) throws ApiException {
    return restartProcessInstanceAsyncOperationWithHttpInfo(id, restartProcessInstanceDto).getData();
  }

  /**
   * Restart Process Instance Async
   * Restarts process instances that were canceled or terminated asynchronously. Can also restart completed process instances. It will create a new instance using the original instance information. To execute the restart asynchronously, use the [Restart Process Instance](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/post-restart-process-instance-sync/) method.  For more information about the difference between synchronous and asynchronous execution, please refer to the related section of the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/process-instance-restart/#execution).
   * @param id The id of the process definition of the process instances to restart. (required)
   * @param restartProcessInstanceDto  (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> In case following parameters are missing: &#x60;instructions&#x60;, &#x60;activityId&#x60; or &#x60;transitionId&#x60;, &#x60;processInstanceIds&#x60; or &#x60;historicProcessInstanceQuery&#x60;, an exception of type &#x60;InvalidRequestException&#x60; is returned.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> restartProcessInstanceAsyncOperationWithHttpInfo(String id, RestartProcessInstanceDto restartProcessInstanceDto) throws ApiException {
    Object localVarPostBody = restartProcessInstanceDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling restartProcessInstanceAsyncOperation");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/restart-async"
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

    return apiClient.invokeAPI("ProcessDefinitionApi.restartProcessInstanceAsyncOperation", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Start Instance
   * Instantiates a given process definition. Process variables and business key may be supplied in the request body.
   * @param id The id of the process definition to be retrieved. (required)
   * @param startProcessInstanceDto  (optional)
   * @return ProcessInstanceWithVariablesDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessInstanceWithVariablesDto startProcessInstance(String id, StartProcessInstanceDto startProcessInstanceDto) throws ApiException {
    return startProcessInstanceWithHttpInfo(id, startProcessInstanceDto).getData();
  }

  /**
   * Start Instance
   * Instantiates a given process definition. Process variables and business key may be supplied in the request body.
   * @param id The id of the process definition to be retrieved. (required)
   * @param startProcessInstanceDto  (optional)
   * @return ApiResponse&lt;ProcessInstanceWithVariablesDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessInstanceWithVariablesDto> startProcessInstanceWithHttpInfo(String id, StartProcessInstanceDto startProcessInstanceDto) throws ApiException {
    Object localVarPostBody = startProcessInstanceDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling startProcessInstance");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/start"
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

    GenericType<ProcessInstanceWithVariablesDto> localVarReturnType = new GenericType<ProcessInstanceWithVariablesDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.startProcessInstance", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Start Instance
   * Instantiates a given process definition, starts the latest version of the process definition which belongs to no tenant. Process variables and business key may be supplied in the request body.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param startProcessInstanceDto  (optional)
   * @return ProcessInstanceWithVariablesDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessInstanceWithVariablesDto startProcessInstanceByKey(String key, StartProcessInstanceDto startProcessInstanceDto) throws ApiException {
    return startProcessInstanceByKeyWithHttpInfo(key, startProcessInstanceDto).getData();
  }

  /**
   * Start Instance
   * Instantiates a given process definition, starts the latest version of the process definition which belongs to no tenant. Process variables and business key may be supplied in the request body.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param startProcessInstanceDto  (optional)
   * @return ApiResponse&lt;ProcessInstanceWithVariablesDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessInstanceWithVariablesDto> startProcessInstanceByKeyWithHttpInfo(String key, StartProcessInstanceDto startProcessInstanceDto) throws ApiException {
    Object localVarPostBody = startProcessInstanceDto;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling startProcessInstanceByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/start"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    GenericType<ProcessInstanceWithVariablesDto> localVarReturnType = new GenericType<ProcessInstanceWithVariablesDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.startProcessInstanceByKey", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Start Instance
   * Instantiates a given process definition, starts the latest version of the process definition for tenant. Process variables and business key may be supplied in the request body.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param startProcessInstanceDto  (optional)
   * @return ProcessInstanceWithVariablesDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessInstanceWithVariablesDto startProcessInstanceByKeyAndTenantId(String key, String tenantId, StartProcessInstanceDto startProcessInstanceDto) throws ApiException {
    return startProcessInstanceByKeyAndTenantIdWithHttpInfo(key, tenantId, startProcessInstanceDto).getData();
  }

  /**
   * Start Instance
   * Instantiates a given process definition, starts the latest version of the process definition for tenant. Process variables and business key may be supplied in the request body.
   * @param key The key of the process definition (the latest version thereof) to be retrieved. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param startProcessInstanceDto  (optional)
   * @return ApiResponse&lt;ProcessInstanceWithVariablesDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessInstanceWithVariablesDto> startProcessInstanceByKeyAndTenantIdWithHttpInfo(String key, String tenantId, StartProcessInstanceDto startProcessInstanceDto) throws ApiException {
    Object localVarPostBody = startProcessInstanceDto;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling startProcessInstanceByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling startProcessInstanceByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/start"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    GenericType<ProcessInstanceWithVariablesDto> localVarReturnType = new GenericType<ProcessInstanceWithVariablesDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.startProcessInstanceByKeyAndTenantId", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Submit Start Form
   * Starts a process instance using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param id The id of the process definition to submit the form for. (required)
   * @param startProcessInstanceFormDto  (optional)
   * @return ProcessInstanceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessInstanceDto submitForm(String id, StartProcessInstanceFormDto startProcessInstanceFormDto) throws ApiException {
    return submitFormWithHttpInfo(id, startProcessInstanceFormDto).getData();
  }

  /**
   * Submit Start Form
   * Starts a process instance using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param id The id of the process definition to submit the form for. (required)
   * @param startProcessInstanceFormDto  (optional)
   * @return ApiResponse&lt;ProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessInstanceDto> submitFormWithHttpInfo(String id, StartProcessInstanceFormDto startProcessInstanceFormDto) throws ApiException {
    Object localVarPostBody = startProcessInstanceFormDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling submitForm");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/submit-form"
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

    GenericType<ProcessInstanceDto> localVarReturnType = new GenericType<ProcessInstanceDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.submitForm", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Submit Start Form
   * Starts the latest version of the process definition which belongs to no tenant using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param key The key of the process definition to submit the form for. (required)
   * @param startProcessInstanceFormDto  (optional)
   * @return ProcessInstanceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessInstanceDto submitFormByKey(String key, StartProcessInstanceFormDto startProcessInstanceFormDto) throws ApiException {
    return submitFormByKeyWithHttpInfo(key, startProcessInstanceFormDto).getData();
  }

  /**
   * Submit Start Form
   * Starts the latest version of the process definition which belongs to no tenant using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param key The key of the process definition to submit the form for. (required)
   * @param startProcessInstanceFormDto  (optional)
   * @return ApiResponse&lt;ProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessInstanceDto> submitFormByKeyWithHttpInfo(String key, StartProcessInstanceFormDto startProcessInstanceFormDto) throws ApiException {
    Object localVarPostBody = startProcessInstanceFormDto;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling submitFormByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/submit-form"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    GenericType<ProcessInstanceDto> localVarReturnType = new GenericType<ProcessInstanceDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.submitFormByKey", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Submit Start Form
   * Starts the latest version of the process definition for a tenant using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param key The key of the process definition to submit the form for. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param startProcessInstanceFormDto  (optional)
   * @return ProcessInstanceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ProcessInstanceDto submitFormByKeyAndTenantId(String key, String tenantId, StartProcessInstanceFormDto startProcessInstanceFormDto) throws ApiException {
    return submitFormByKeyAndTenantIdWithHttpInfo(key, tenantId, startProcessInstanceFormDto).getData();
  }

  /**
   * Submit Start Form
   * Starts the latest version of the process definition for a tenant using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
   * @param key The key of the process definition to submit the form for. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param startProcessInstanceFormDto  (optional)
   * @return ApiResponse&lt;ProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The instance could not be created due to an invalid variable value, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The instance could not be created successfully. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ProcessInstanceDto> submitFormByKeyAndTenantIdWithHttpInfo(String key, String tenantId, StartProcessInstanceFormDto startProcessInstanceFormDto) throws ApiException {
    Object localVarPostBody = startProcessInstanceFormDto;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling submitFormByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling submitFormByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/submit-form"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    GenericType<ProcessInstanceDto> localVarReturnType = new GenericType<ProcessInstanceDto>() {};

    return apiClient.invokeAPI("ProcessDefinitionApi.submitFormByKeyAndTenantId", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Update History Time to Live
   * Updates history time to live for process definition. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
   * @param id The id of the process definition to change history time to live. (required)
   * @param historyTimeToLiveDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the request parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void updateHistoryTimeToLiveByProcessDefinitionId(String id, HistoryTimeToLiveDto historyTimeToLiveDto) throws ApiException {
    updateHistoryTimeToLiveByProcessDefinitionIdWithHttpInfo(id, historyTimeToLiveDto);
  }

  /**
   * Update History Time to Live
   * Updates history time to live for process definition. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
   * @param id The id of the process definition to change history time to live. (required)
   * @param historyTimeToLiveDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the request parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateHistoryTimeToLiveByProcessDefinitionIdWithHttpInfo(String id, HistoryTimeToLiveDto historyTimeToLiveDto) throws ApiException {
    Object localVarPostBody = historyTimeToLiveDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateHistoryTimeToLiveByProcessDefinitionId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/history-time-to-live"
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

    return apiClient.invokeAPI("ProcessDefinitionApi.updateHistoryTimeToLiveByProcessDefinitionId", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update History Time to Live
   * Updates history time to live for the latest version of the process definition which belongs to no tenant. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
   * @param key The key of the process definition to change history time to live. (required)
   * @param historyTimeToLiveDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the request parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void updateHistoryTimeToLiveByProcessDefinitionKey(String key, HistoryTimeToLiveDto historyTimeToLiveDto) throws ApiException {
    updateHistoryTimeToLiveByProcessDefinitionKeyWithHttpInfo(key, historyTimeToLiveDto);
  }

  /**
   * Update History Time to Live
   * Updates history time to live for the latest version of the process definition which belongs to no tenant. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
   * @param key The key of the process definition to change history time to live. (required)
   * @param historyTimeToLiveDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the request parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateHistoryTimeToLiveByProcessDefinitionKeyWithHttpInfo(String key, HistoryTimeToLiveDto historyTimeToLiveDto) throws ApiException {
    Object localVarPostBody = historyTimeToLiveDto;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling updateHistoryTimeToLiveByProcessDefinitionKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/history-time-to-live"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.updateHistoryTimeToLiveByProcessDefinitionKey", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update History Time to Live
   * Updates history time to live for the latest version of the process definition for a tenant. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
   * @param key The key of the process definition to change history time to live. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param historyTimeToLiveDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the request parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void updateHistoryTimeToLiveByProcessDefinitionKeyAndTenantId(String key, String tenantId, HistoryTimeToLiveDto historyTimeToLiveDto) throws ApiException {
    updateHistoryTimeToLiveByProcessDefinitionKeyAndTenantIdWithHttpInfo(key, tenantId, historyTimeToLiveDto);
  }

  /**
   * Update History Time to Live
   * Updates history time to live for the latest version of the process definition for a tenant. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
   * @param key The key of the process definition to change history time to live. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param historyTimeToLiveDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the request parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateHistoryTimeToLiveByProcessDefinitionKeyAndTenantIdWithHttpInfo(String key, String tenantId, HistoryTimeToLiveDto historyTimeToLiveDto) throws ApiException {
    Object localVarPostBody = historyTimeToLiveDto;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling updateHistoryTimeToLiveByProcessDefinitionKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling updateHistoryTimeToLiveByProcessDefinitionKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/history-time-to-live"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.updateHistoryTimeToLiveByProcessDefinitionKeyAndTenantId", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Activate/Suspend By Key
   * Activates or suspends process definitions with the given process definition key.
   * @param processDefinitionSuspensionStateDto **Note**: Unallowed property is &#x60;processDefinitionId&#x60;. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if the provided &#x60;executionDate&#x60; parameter doesn&#39;t have the expected format or if the &#x60;processDefinitionKey&#x60; parameter is &#x60;null&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void updateProcessDefinitionSuspensionState(ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto) throws ApiException {
    updateProcessDefinitionSuspensionStateWithHttpInfo(processDefinitionSuspensionStateDto);
  }

  /**
   * Activate/Suspend By Key
   * Activates or suspends process definitions with the given process definition key.
   * @param processDefinitionSuspensionStateDto **Note**: Unallowed property is &#x60;processDefinitionId&#x60;. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if the provided &#x60;executionDate&#x60; parameter doesn&#39;t have the expected format or if the &#x60;processDefinitionKey&#x60; parameter is &#x60;null&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateProcessDefinitionSuspensionStateWithHttpInfo(ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto) throws ApiException {
    Object localVarPostBody = processDefinitionSuspensionStateDto;
    
    // create path and map variables
    String localVarPath = "/process-definition/suspended";

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

    return apiClient.invokeAPI("ProcessDefinitionApi.updateProcessDefinitionSuspensionState", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Activate/Suspend By Id
   * Activates or suspends a given process definition by id.
   * @param id The id of the process definition to activate or suspend. (required)
   * @param processDefinitionSuspensionStateDto **Note**: Unallowed properties are &#x60;processDefinitionId&#x60; and &#x60;processDefinitionKey&#x60;. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if the provided &#x60;executionDate&#x60; parameter doesn&#39;t have the expected format or if the &#x60;processDefinitionKey&#x60; parameter is &#x60;null&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void updateProcessDefinitionSuspensionStateById(String id, ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto) throws ApiException {
    updateProcessDefinitionSuspensionStateByIdWithHttpInfo(id, processDefinitionSuspensionStateDto);
  }

  /**
   * Activate/Suspend By Id
   * Activates or suspends a given process definition by id.
   * @param id The id of the process definition to activate or suspend. (required)
   * @param processDefinitionSuspensionStateDto **Note**: Unallowed properties are &#x60;processDefinitionId&#x60; and &#x60;processDefinitionKey&#x60;. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if the provided &#x60;executionDate&#x60; parameter doesn&#39;t have the expected format or if the &#x60;processDefinitionKey&#x60; parameter is &#x60;null&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateProcessDefinitionSuspensionStateByIdWithHttpInfo(String id, ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto) throws ApiException {
    Object localVarPostBody = processDefinitionSuspensionStateDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateProcessDefinitionSuspensionStateById");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/{id}/suspended"
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

    return apiClient.invokeAPI("ProcessDefinitionApi.updateProcessDefinitionSuspensionStateById", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Activate/Suspend by Id
   * Activates or suspends a given process definition by latest version of process definition key which belongs to no tenant.
   * @param key The key of the process definition (the latest version thereof) to be activated/suspended. (required)
   * @param processDefinitionSuspensionStateDto **Note**: Unallowed properties are &#x60;processDefinitionId&#x60; and &#x60;processDefinitionKey&#x60;. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if the provided &#x60;executionDate&#x60; parameter doesn&#39;t have the expected format or if the &#x60;processDefinitionKey&#x60; parameter is &#x60;null&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void updateProcessDefinitionSuspensionStateByKey(String key, ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto) throws ApiException {
    updateProcessDefinitionSuspensionStateByKeyWithHttpInfo(key, processDefinitionSuspensionStateDto);
  }

  /**
   * Activate/Suspend by Id
   * Activates or suspends a given process definition by latest version of process definition key which belongs to no tenant.
   * @param key The key of the process definition (the latest version thereof) to be activated/suspended. (required)
   * @param processDefinitionSuspensionStateDto **Note**: Unallowed properties are &#x60;processDefinitionId&#x60; and &#x60;processDefinitionKey&#x60;. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if the provided &#x60;executionDate&#x60; parameter doesn&#39;t have the expected format or if the &#x60;processDefinitionKey&#x60; parameter is &#x60;null&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateProcessDefinitionSuspensionStateByKeyWithHttpInfo(String key, ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto) throws ApiException {
    Object localVarPostBody = processDefinitionSuspensionStateDto;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling updateProcessDefinitionSuspensionStateByKey");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/suspended"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.updateProcessDefinitionSuspensionStateByKey", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Activate/Suspend by Id
   * Activates or suspends a given process definition by the latest version of the process definition for tenant.
   * @param key The key of the process definition (the latest version thereof) to be activated/suspended. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param processDefinitionSuspensionStateDto **Note**: Unallowed properties are &#x60;processDefinitionId&#x60; and &#x60;processDefinitionKey&#x60;. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if the provided &#x60;executionDate&#x60; parameter doesn&#39;t have the expected format or if the &#x60;processDefinitionKey&#x60; parameter is &#x60;null&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void updateProcessDefinitionSuspensionStateByKeyAndTenantId(String key, String tenantId, ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto) throws ApiException {
    updateProcessDefinitionSuspensionStateByKeyAndTenantIdWithHttpInfo(key, tenantId, processDefinitionSuspensionStateDto);
  }

  /**
   * Activate/Suspend by Id
   * Activates or suspends a given process definition by the latest version of the process definition for tenant.
   * @param key The key of the process definition (the latest version thereof) to be activated/suspended. (required)
   * @param tenantId The id of the tenant the process definition belongs to. (required)
   * @param processDefinitionSuspensionStateDto **Note**: Unallowed properties are &#x60;processDefinitionId&#x60; and &#x60;processDefinitionKey&#x60;. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if the provided &#x60;executionDate&#x60; parameter doesn&#39;t have the expected format or if the &#x60;processDefinitionKey&#x60; parameter is &#x60;null&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Process definition with given key does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> updateProcessDefinitionSuspensionStateByKeyAndTenantIdWithHttpInfo(String key, String tenantId, ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto) throws ApiException {
    Object localVarPostBody = processDefinitionSuspensionStateDto;
    
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(400, "Missing the required parameter 'key' when calling updateProcessDefinitionSuspensionStateByKeyAndTenantId");
    }
    
    // verify the required parameter 'tenantId' is set
    if (tenantId == null) {
      throw new ApiException(400, "Missing the required parameter 'tenantId' when calling updateProcessDefinitionSuspensionStateByKeyAndTenantId");
    }
    
    // create path and map variables
    String localVarPath = "/process-definition/key/{key}/tenant-id/{tenant-id}/suspended"
      .replaceAll("\\{" + "key" + "\\}", apiClient.escapeString(key.toString()))
      .replaceAll("\\{" + "tenant-id" + "\\}", apiClient.escapeString(tenantId.toString()));

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

    return apiClient.invokeAPI("ProcessDefinitionApi.updateProcessDefinitionSuspensionStateByKeyAndTenantId", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
