package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.BatchDto;
import de.dfki.cos.basys.common.rest.camunda.dto.CountResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.DeleteHistoricProcessInstancesDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.HistoricProcessInstanceDto;
import de.dfki.cos.basys.common.rest.camunda.dto.HistoricProcessInstanceQueryDto;
import org.threeten.bp.OffsetDateTime;
import de.dfki.cos.basys.common.rest.camunda.dto.SetRemovalTimeToHistoricProcessInstancesDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class HistoricProcessInstanceApi {
  private ApiClient apiClient;

  public HistoricProcessInstanceApi() {
    this(Configuration.getDefaultApiClient());
  }

  public HistoricProcessInstanceApi(ApiClient apiClient) {
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
   * Deletes a process instance from the history by id.
   * @param id The id of the historic process instance to be deleted. (required)
   * @param failIfNotExists If set to &#x60;false&#x60;, the request will still be successful if the process id is not found. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Historic process instance with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteHistoricProcessInstance(String id, Boolean failIfNotExists) throws ApiException {
    deleteHistoricProcessInstanceWithHttpInfo(id, failIfNotExists);
  }

  /**
   * Delete
   * Deletes a process instance from the history by id.
   * @param id The id of the historic process instance to be deleted. (required)
   * @param failIfNotExists If set to &#x60;false&#x60;, the request will still be successful if the process id is not found. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Historic process instance with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteHistoricProcessInstanceWithHttpInfo(String id, Boolean failIfNotExists) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteHistoricProcessInstance");
    }
    
    // create path and map variables
    String localVarPath = "/history/process-instance/{id}"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "failIfNotExists", failIfNotExists));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("HistoricProcessInstanceApi.deleteHistoricProcessInstance", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete Async (POST)
   * Delete multiple historic process instances asynchronously (batch). At least &#x60;historicProcessInstanceIds&#x60; or &#x60;historicProcessInstanceQuery&#x60; has to be provided. If both are provided then all instances matching query criterion and instances from the list will be deleted.
   * @param deleteHistoricProcessInstancesDto  (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, i.e. neither historicProcessInstanceIds, nor historicProcessInstanceQuery is present. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto deleteHistoricProcessInstancesAsync(DeleteHistoricProcessInstancesDto deleteHistoricProcessInstancesDto) throws ApiException {
    return deleteHistoricProcessInstancesAsyncWithHttpInfo(deleteHistoricProcessInstancesDto).getData();
  }

  /**
   * Delete Async (POST)
   * Delete multiple historic process instances asynchronously (batch). At least &#x60;historicProcessInstanceIds&#x60; or &#x60;historicProcessInstanceQuery&#x60; has to be provided. If both are provided then all instances matching query criterion and instances from the list will be deleted.
   * @param deleteHistoricProcessInstancesDto  (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, i.e. neither historicProcessInstanceIds, nor historicProcessInstanceQuery is present. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> deleteHistoricProcessInstancesAsyncWithHttpInfo(DeleteHistoricProcessInstancesDto deleteHistoricProcessInstancesDto) throws ApiException {
    Object localVarPostBody = deleteHistoricProcessInstancesDto;
    
    // create path and map variables
    String localVarPath = "/history/process-instance/delete";

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

    return apiClient.invokeAPI("HistoricProcessInstanceApi.deleteHistoricProcessInstancesAsync", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Delete Variable Instances
   * Deletes all variables of a process instance from the history by id.
   * @param id The id of the process instance for which all historic variables are to be deleted. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Historic process instance with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#parse-exceptions) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteHistoricVariableInstancesOfHistoricProcessInstance(String id) throws ApiException {
    deleteHistoricVariableInstancesOfHistoricProcessInstanceWithHttpInfo(id);
  }

  /**
   * Delete Variable Instances
   * Deletes all variables of a process instance from the history by id.
   * @param id The id of the process instance for which all historic variables are to be deleted. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not found Historic process instance with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#parse-exceptions) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteHistoricVariableInstancesOfHistoricProcessInstanceWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteHistoricVariableInstancesOfHistoricProcessInstance");
    }
    
    // create path and map variables
    String localVarPath = "/history/process-instance/{id}/variable-instances"
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

    return apiClient.invokeAPI("HistoricProcessInstanceApi.deleteHistoricVariableInstancesOfHistoricProcessInstance", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get
   * Retrieves a historic process instance by id, according to the &#x60;HistoricProcessInstance&#x60; interface in the engine.
   * @param id The id of the historic process instance to be retrieved. (required)
   * @return HistoricProcessInstanceDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found Historic process instance with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public HistoricProcessInstanceDto getHistoricProcessInstance(String id) throws ApiException {
    return getHistoricProcessInstanceWithHttpInfo(id).getData();
  }

  /**
   * Get
   * Retrieves a historic process instance by id, according to the &#x60;HistoricProcessInstance&#x60; interface in the engine.
   * @param id The id of the historic process instance to be retrieved. (required)
   * @return ApiResponse&lt;HistoricProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Not Found Historic process instance with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<HistoricProcessInstanceDto> getHistoricProcessInstanceWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getHistoricProcessInstance");
    }
    
    // create path and map variables
    String localVarPath = "/history/process-instance/{id}"
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

    GenericType<HistoricProcessInstanceDto> localVarReturnType = new GenericType<HistoricProcessInstanceDto>() {};

    return apiClient.invokeAPI("HistoricProcessInstanceApi.getHistoricProcessInstance", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Duration Report
   * Retrieves a report about the duration of completed process instances, grouped by a period. These reports include the maximum, minimum and average duration of all completed process instances which were started in a given period.  **Note:** This only includes historic data.
   * @param reportType **Mandatory.** Specifies the type of the report to retrieve. To retrieve a report about the duration of process instances, the value must be set to &#x60;duration&#x60;. (required)
   * @param periodUnit **Mandatory.** Specifies the granularity of the report. Valid values are &#x60;month&#x60; and &#x60;quarter&#x60;. (required)
   * @param processDefinitionIdIn Filter by process definition ids. Must be a comma-separated list of process definition ids. (optional)
   * @param processDefinitionKeyIn Filter by process definition keys. Must be a comma-separated list of process definition keys. (optional)
   * @param startedBefore Restrict to instances that were started before the given date. By [default](), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2016-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedAfter Restrict to instances that were started after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2016-01-23T14:42:45.000+0200&#x60;. (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. In case of an expected text/csv response to retrieve the result as a csv file. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid or mandatory parameters are not supplied. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> If the authenticated user is unauthorized to read the history. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Object getHistoricProcessInstanceDurationReport(String reportType, String periodUnit, String processDefinitionIdIn, String processDefinitionKeyIn, OffsetDateTime startedBefore, OffsetDateTime startedAfter) throws ApiException {
    return getHistoricProcessInstanceDurationReportWithHttpInfo(reportType, periodUnit, processDefinitionIdIn, processDefinitionKeyIn, startedBefore, startedAfter).getData();
  }

  /**
   * Get Duration Report
   * Retrieves a report about the duration of completed process instances, grouped by a period. These reports include the maximum, minimum and average duration of all completed process instances which were started in a given period.  **Note:** This only includes historic data.
   * @param reportType **Mandatory.** Specifies the type of the report to retrieve. To retrieve a report about the duration of process instances, the value must be set to &#x60;duration&#x60;. (required)
   * @param periodUnit **Mandatory.** Specifies the granularity of the report. Valid values are &#x60;month&#x60; and &#x60;quarter&#x60;. (required)
   * @param processDefinitionIdIn Filter by process definition ids. Must be a comma-separated list of process definition ids. (optional)
   * @param processDefinitionKeyIn Filter by process definition keys. Must be a comma-separated list of process definition keys. (optional)
   * @param startedBefore Restrict to instances that were started before the given date. By [default](), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2016-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedAfter Restrict to instances that were started after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2016-01-23T14:42:45.000+0200&#x60;. (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. In case of an expected text/csv response to retrieve the result as a csv file. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid or mandatory parameters are not supplied. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> If the authenticated user is unauthorized to read the history. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> getHistoricProcessInstanceDurationReportWithHttpInfo(String reportType, String periodUnit, String processDefinitionIdIn, String processDefinitionKeyIn, OffsetDateTime startedBefore, OffsetDateTime startedAfter) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'reportType' is set
    if (reportType == null) {
      throw new ApiException(400, "Missing the required parameter 'reportType' when calling getHistoricProcessInstanceDurationReport");
    }
    
    // verify the required parameter 'periodUnit' is set
    if (periodUnit == null) {
      throw new ApiException(400, "Missing the required parameter 'periodUnit' when calling getHistoricProcessInstanceDurationReport");
    }
    
    // create path and map variables
    String localVarPath = "/history/process-instance/report";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "reportType", reportType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "periodUnit", periodUnit));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionIdIn", processDefinitionIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startedBefore", startedBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startedAfter", startedAfter));

    
    
    
    final String[] localVarAccepts = {
      "text/csv", "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};

    return apiClient.invokeAPI("HistoricProcessInstanceApi.getHistoricProcessInstanceDurationReport", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List
   * Queries for historic process instances that fulfill the given parameters. The size of the result set can be retrieved by using the [Get Process Instance Count](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/get-process-instance-query-count/) method.
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param processInstanceId Filter by process instance id. (optional)
   * @param processInstanceIds Filter by process instance ids. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processDefinitionId Filter by the process definition the instances run on. (optional)
   * @param processDefinitionKey Filter by the key of the process definition the instances run on. (optional)
   * @param processDefinitionKeyIn Filter by a list of process definition keys. A process instance must have one of the given process definition keys. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processDefinitionName Filter by the name of the process definition the instances run on. (optional)
   * @param processDefinitionNameLike Filter by process definition names that the parameter is a substring of. (optional)
   * @param processDefinitionKeyNotIn Exclude instances that belong to a set of process definitions. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processInstanceBusinessKey Filter by process instance business key. (optional)
   * @param processInstanceBusinessKeyLike Filter by process instance business key that the parameter is a substring of. (optional)
   * @param rootProcessInstances Restrict the query to all process instances that are top level process instances. (optional)
   * @param finished Only include finished process instances. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param unfinished Only include unfinished process instances. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param withIncidents Only include process instances which have an incident. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param withRootIncidents Only include process instances which have a root incident. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentStatus Only include process instances which have an incident in status either open or resolved. To get all process instances, use the query parameter withIncidents. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param startedBefore Restrict to instances that were started before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedAfter Restrict to instances that were started after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param finishedBefore Restrict to instances that were finished before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param finishedAfter Restrict to instances that were finished after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedActivityAfter Restrict to instances that executed an activity after the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedActivityBefore Restrict to instances that executed an activity before the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedJobAfter Restrict to instances that executed an job after the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedJobBefore Restrict to instances that executed an job before the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedBy Only include process instances that were started by the given user. (optional)
   * @param superProcessInstanceId Restrict query to all process instances that are sub process instances of the given process instance. Takes a process instance id. (optional)
   * @param subProcessInstanceId Restrict query to one process instance that has a sub process instance with the given id. (optional)
   * @param superCaseInstanceId Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param subCaseInstanceId Restrict query to one process instance that has a sub case instance with the given id. (optional)
   * @param caseInstanceId Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param tenantIdIn Filter by a list of tenant ids. A process instance must have one of the given tenant ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param withoutTenantId Only include historic process instances which belong to no tenant. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param executedActivityIdIn Restrict to instances that executed an activity with one of given ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param activeActivityIdIn Restrict to instances that have an active activity with one of given ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param active Restrict to instances that are active. (optional)
   * @param suspended Restrict to instances that are suspended. (optional)
   * @param completed Restrict to instances that are completed. (optional)
   * @param externallyTerminated Restrict to instances that are externallyTerminated. (optional)
   * @param internallyTerminated Restrict to instances that are internallyTerminated. (optional)
   * @param variables Only include process instances that have/had variables with certain values. Variable filtering expressions are comma-separated and are structured as follows: A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note:** Values are always treated as String objects on server side.  Valid operator values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;.  Key and value may not contain underscore or comma characters.  (optional)
   * @param variableNamesIgnoreCase Match all variable names provided in variables case-insensitively. If set to &#x60;true&#x60; variableName and variablename are treated as equal. (optional)
   * @param variableValuesIgnoreCase Match all variable values provided in variables case-insensitively. If set to &#x60;true&#x60; variableValue and variablevalue are treated as equal. (optional)
   * @return List&lt;HistoricProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<HistoricProcessInstanceDto> getHistoricProcessInstances(String sortBy, String sortOrder, Integer firstResult, Integer maxResults, String processInstanceId, String processInstanceIds, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionName, String processDefinitionNameLike, String processDefinitionKeyNotIn, String processInstanceBusinessKey, String processInstanceBusinessKeyLike, Boolean rootProcessInstances, Boolean finished, Boolean unfinished, Boolean withIncidents, Boolean withRootIncidents, String incidentType, String incidentStatus, String incidentMessage, String incidentMessageLike, OffsetDateTime startedBefore, OffsetDateTime startedAfter, OffsetDateTime finishedBefore, OffsetDateTime finishedAfter, OffsetDateTime executedActivityAfter, OffsetDateTime executedActivityBefore, OffsetDateTime executedJobAfter, OffsetDateTime executedJobBefore, String startedBy, String superProcessInstanceId, String subProcessInstanceId, String superCaseInstanceId, String subCaseInstanceId, String caseInstanceId, String tenantIdIn, Boolean withoutTenantId, String executedActivityIdIn, String activeActivityIdIn, Boolean active, Boolean suspended, Boolean completed, Boolean externallyTerminated, Boolean internallyTerminated, String variables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase) throws ApiException {
    return getHistoricProcessInstancesWithHttpInfo(sortBy, sortOrder, firstResult, maxResults, processInstanceId, processInstanceIds, processDefinitionId, processDefinitionKey, processDefinitionKeyIn, processDefinitionName, processDefinitionNameLike, processDefinitionKeyNotIn, processInstanceBusinessKey, processInstanceBusinessKeyLike, rootProcessInstances, finished, unfinished, withIncidents, withRootIncidents, incidentType, incidentStatus, incidentMessage, incidentMessageLike, startedBefore, startedAfter, finishedBefore, finishedAfter, executedActivityAfter, executedActivityBefore, executedJobAfter, executedJobBefore, startedBy, superProcessInstanceId, subProcessInstanceId, superCaseInstanceId, subCaseInstanceId, caseInstanceId, tenantIdIn, withoutTenantId, executedActivityIdIn, activeActivityIdIn, active, suspended, completed, externallyTerminated, internallyTerminated, variables, variableNamesIgnoreCase, variableValuesIgnoreCase).getData();
  }

  /**
   * Get List
   * Queries for historic process instances that fulfill the given parameters. The size of the result set can be retrieved by using the [Get Process Instance Count](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/get-process-instance-query-count/) method.
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param processInstanceId Filter by process instance id. (optional)
   * @param processInstanceIds Filter by process instance ids. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processDefinitionId Filter by the process definition the instances run on. (optional)
   * @param processDefinitionKey Filter by the key of the process definition the instances run on. (optional)
   * @param processDefinitionKeyIn Filter by a list of process definition keys. A process instance must have one of the given process definition keys. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processDefinitionName Filter by the name of the process definition the instances run on. (optional)
   * @param processDefinitionNameLike Filter by process definition names that the parameter is a substring of. (optional)
   * @param processDefinitionKeyNotIn Exclude instances that belong to a set of process definitions. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processInstanceBusinessKey Filter by process instance business key. (optional)
   * @param processInstanceBusinessKeyLike Filter by process instance business key that the parameter is a substring of. (optional)
   * @param rootProcessInstances Restrict the query to all process instances that are top level process instances. (optional)
   * @param finished Only include finished process instances. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param unfinished Only include unfinished process instances. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param withIncidents Only include process instances which have an incident. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param withRootIncidents Only include process instances which have a root incident. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentStatus Only include process instances which have an incident in status either open or resolved. To get all process instances, use the query parameter withIncidents. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param startedBefore Restrict to instances that were started before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedAfter Restrict to instances that were started after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param finishedBefore Restrict to instances that were finished before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param finishedAfter Restrict to instances that were finished after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedActivityAfter Restrict to instances that executed an activity after the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedActivityBefore Restrict to instances that executed an activity before the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedJobAfter Restrict to instances that executed an job after the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedJobBefore Restrict to instances that executed an job before the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedBy Only include process instances that were started by the given user. (optional)
   * @param superProcessInstanceId Restrict query to all process instances that are sub process instances of the given process instance. Takes a process instance id. (optional)
   * @param subProcessInstanceId Restrict query to one process instance that has a sub process instance with the given id. (optional)
   * @param superCaseInstanceId Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param subCaseInstanceId Restrict query to one process instance that has a sub case instance with the given id. (optional)
   * @param caseInstanceId Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param tenantIdIn Filter by a list of tenant ids. A process instance must have one of the given tenant ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param withoutTenantId Only include historic process instances which belong to no tenant. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param executedActivityIdIn Restrict to instances that executed an activity with one of given ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param activeActivityIdIn Restrict to instances that have an active activity with one of given ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param active Restrict to instances that are active. (optional)
   * @param suspended Restrict to instances that are suspended. (optional)
   * @param completed Restrict to instances that are completed. (optional)
   * @param externallyTerminated Restrict to instances that are externallyTerminated. (optional)
   * @param internallyTerminated Restrict to instances that are internallyTerminated. (optional)
   * @param variables Only include process instances that have/had variables with certain values. Variable filtering expressions are comma-separated and are structured as follows: A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note:** Values are always treated as String objects on server side.  Valid operator values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;.  Key and value may not contain underscore or comma characters.  (optional)
   * @param variableNamesIgnoreCase Match all variable names provided in variables case-insensitively. If set to &#x60;true&#x60; variableName and variablename are treated as equal. (optional)
   * @param variableValuesIgnoreCase Match all variable values provided in variables case-insensitively. If set to &#x60;true&#x60; variableValue and variablevalue are treated as equal. (optional)
   * @return ApiResponse&lt;List&lt;HistoricProcessInstanceDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<HistoricProcessInstanceDto>> getHistoricProcessInstancesWithHttpInfo(String sortBy, String sortOrder, Integer firstResult, Integer maxResults, String processInstanceId, String processInstanceIds, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionName, String processDefinitionNameLike, String processDefinitionKeyNotIn, String processInstanceBusinessKey, String processInstanceBusinessKeyLike, Boolean rootProcessInstances, Boolean finished, Boolean unfinished, Boolean withIncidents, Boolean withRootIncidents, String incidentType, String incidentStatus, String incidentMessage, String incidentMessageLike, OffsetDateTime startedBefore, OffsetDateTime startedAfter, OffsetDateTime finishedBefore, OffsetDateTime finishedAfter, OffsetDateTime executedActivityAfter, OffsetDateTime executedActivityBefore, OffsetDateTime executedJobAfter, OffsetDateTime executedJobBefore, String startedBy, String superProcessInstanceId, String subProcessInstanceId, String superCaseInstanceId, String subCaseInstanceId, String caseInstanceId, String tenantIdIn, Boolean withoutTenantId, String executedActivityIdIn, String activeActivityIdIn, Boolean active, Boolean suspended, Boolean completed, Boolean externallyTerminated, Boolean internallyTerminated, String variables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/history/process-instance";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortOrder", sortOrder));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstResult", firstResult));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxResults", maxResults));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceId", processInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceIds", processInstanceIds));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKey", processDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionName", processDefinitionName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionNameLike", processDefinitionNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyNotIn", processDefinitionKeyNotIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKey", processInstanceBusinessKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyLike", processInstanceBusinessKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rootProcessInstances", rootProcessInstances));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "finished", finished));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "unfinished", unfinished));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withIncidents", withIncidents));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withRootIncidents", withRootIncidents));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentType", incidentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentStatus", incidentStatus));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessage", incidentMessage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessageLike", incidentMessageLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startedBefore", startedBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startedAfter", startedAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "finishedBefore", finishedBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "finishedAfter", finishedAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedActivityAfter", executedActivityAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedActivityBefore", executedActivityBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedJobAfter", executedJobAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedJobBefore", executedJobBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startedBy", startedBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "superProcessInstanceId", superProcessInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "subProcessInstanceId", subProcessInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "superCaseInstanceId", superCaseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "subCaseInstanceId", subCaseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceId", caseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutTenantId", withoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedActivityIdIn", executedActivityIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activeActivityIdIn", activeActivityIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "completed", completed));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "externallyTerminated", externallyTerminated));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "internallyTerminated", internallyTerminated));
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

    GenericType<List<HistoricProcessInstanceDto>> localVarReturnType = new GenericType<List<HistoricProcessInstanceDto>>() {};

    return apiClient.invokeAPI("HistoricProcessInstanceApi.getHistoricProcessInstances", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List Count
   * Queries for the number of historic process instances that fulfill the given parameters. Takes the same parameters as the [Get Process Instances](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/get-process-instance-query/) method.
   * @param processInstanceId Filter by process instance id. (optional)
   * @param processInstanceIds Filter by process instance ids. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processDefinitionId Filter by the process definition the instances run on. (optional)
   * @param processDefinitionKey Filter by the key of the process definition the instances run on. (optional)
   * @param processDefinitionKeyIn Filter by a list of process definition keys. A process instance must have one of the given process definition keys. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processDefinitionName Filter by the name of the process definition the instances run on. (optional)
   * @param processDefinitionNameLike Filter by process definition names that the parameter is a substring of. (optional)
   * @param processDefinitionKeyNotIn Exclude instances that belong to a set of process definitions. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processInstanceBusinessKey Filter by process instance business key. (optional)
   * @param processInstanceBusinessKeyLike Filter by process instance business key that the parameter is a substring of. (optional)
   * @param rootProcessInstances Restrict the query to all process instances that are top level process instances. (optional)
   * @param finished Only include finished process instances. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param unfinished Only include unfinished process instances. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param withIncidents Only include process instances which have an incident. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param withRootIncidents Only include process instances which have a root incident. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentStatus Only include process instances which have an incident in status either open or resolved. To get all process instances, use the query parameter withIncidents. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param startedBefore Restrict to instances that were started before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedAfter Restrict to instances that were started after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param finishedBefore Restrict to instances that were finished before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param finishedAfter Restrict to instances that were finished after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedActivityAfter Restrict to instances that executed an activity after the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedActivityBefore Restrict to instances that executed an activity before the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedJobAfter Restrict to instances that executed an job after the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedJobBefore Restrict to instances that executed an job before the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedBy Only include process instances that were started by the given user. (optional)
   * @param superProcessInstanceId Restrict query to all process instances that are sub process instances of the given process instance. Takes a process instance id. (optional)
   * @param subProcessInstanceId Restrict query to one process instance that has a sub process instance with the given id. (optional)
   * @param superCaseInstanceId Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param subCaseInstanceId Restrict query to one process instance that has a sub case instance with the given id. (optional)
   * @param caseInstanceId Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param tenantIdIn Filter by a list of tenant ids. A process instance must have one of the given tenant ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param withoutTenantId Only include historic process instances which belong to no tenant. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param executedActivityIdIn Restrict to instances that executed an activity with one of given ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param activeActivityIdIn Restrict to instances that have an active activity with one of given ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param active Restrict to instances that are active. (optional)
   * @param suspended Restrict to instances that are suspended. (optional)
   * @param completed Restrict to instances that are completed. (optional)
   * @param externallyTerminated Restrict to instances that are externallyTerminated. (optional)
   * @param internallyTerminated Restrict to instances that are internallyTerminated. (optional)
   * @param variables Only include process instances that have/had variables with certain values. Variable filtering expressions are comma-separated and are structured as follows: A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note:** Values are always treated as String objects on server side.  Valid operator values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;.  Key and value may not contain underscore or comma characters.  (optional)
   * @param variableNamesIgnoreCase Match all variable names provided in variables case-insensitively. If set to &#x60;true&#x60; variableName and variablename are treated as equal. (optional)
   * @param variableValuesIgnoreCase Match all variable values provided in variables case-insensitively. If set to &#x60;true&#x60; variableValue and variablevalue are treated as equal. (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto getHistoricProcessInstancesCount(String processInstanceId, String processInstanceIds, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionName, String processDefinitionNameLike, String processDefinitionKeyNotIn, String processInstanceBusinessKey, String processInstanceBusinessKeyLike, Boolean rootProcessInstances, Boolean finished, Boolean unfinished, Boolean withIncidents, Boolean withRootIncidents, String incidentType, String incidentStatus, String incidentMessage, String incidentMessageLike, OffsetDateTime startedBefore, OffsetDateTime startedAfter, OffsetDateTime finishedBefore, OffsetDateTime finishedAfter, OffsetDateTime executedActivityAfter, OffsetDateTime executedActivityBefore, OffsetDateTime executedJobAfter, OffsetDateTime executedJobBefore, String startedBy, String superProcessInstanceId, String subProcessInstanceId, String superCaseInstanceId, String subCaseInstanceId, String caseInstanceId, String tenantIdIn, Boolean withoutTenantId, String executedActivityIdIn, String activeActivityIdIn, Boolean active, Boolean suspended, Boolean completed, Boolean externallyTerminated, Boolean internallyTerminated, String variables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase) throws ApiException {
    return getHistoricProcessInstancesCountWithHttpInfo(processInstanceId, processInstanceIds, processDefinitionId, processDefinitionKey, processDefinitionKeyIn, processDefinitionName, processDefinitionNameLike, processDefinitionKeyNotIn, processInstanceBusinessKey, processInstanceBusinessKeyLike, rootProcessInstances, finished, unfinished, withIncidents, withRootIncidents, incidentType, incidentStatus, incidentMessage, incidentMessageLike, startedBefore, startedAfter, finishedBefore, finishedAfter, executedActivityAfter, executedActivityBefore, executedJobAfter, executedJobBefore, startedBy, superProcessInstanceId, subProcessInstanceId, superCaseInstanceId, subCaseInstanceId, caseInstanceId, tenantIdIn, withoutTenantId, executedActivityIdIn, activeActivityIdIn, active, suspended, completed, externallyTerminated, internallyTerminated, variables, variableNamesIgnoreCase, variableValuesIgnoreCase).getData();
  }

  /**
   * Get List Count
   * Queries for the number of historic process instances that fulfill the given parameters. Takes the same parameters as the [Get Process Instances](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/get-process-instance-query/) method.
   * @param processInstanceId Filter by process instance id. (optional)
   * @param processInstanceIds Filter by process instance ids. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processDefinitionId Filter by the process definition the instances run on. (optional)
   * @param processDefinitionKey Filter by the key of the process definition the instances run on. (optional)
   * @param processDefinitionKeyIn Filter by a list of process definition keys. A process instance must have one of the given process definition keys. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processDefinitionName Filter by the name of the process definition the instances run on. (optional)
   * @param processDefinitionNameLike Filter by process definition names that the parameter is a substring of. (optional)
   * @param processDefinitionKeyNotIn Exclude instances that belong to a set of process definitions. Filter by a comma-separated list of &#x60;Strings&#x60;. (optional)
   * @param processInstanceBusinessKey Filter by process instance business key. (optional)
   * @param processInstanceBusinessKeyLike Filter by process instance business key that the parameter is a substring of. (optional)
   * @param rootProcessInstances Restrict the query to all process instances that are top level process instances. (optional)
   * @param finished Only include finished process instances. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param unfinished Only include unfinished process instances. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param withIncidents Only include process instances which have an incident. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param withRootIncidents Only include process instances which have a root incident. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param incidentType Filter by the incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentStatus Only include process instances which have an incident in status either open or resolved. To get all process instances, use the query parameter withIncidents. (optional)
   * @param incidentMessage Filter by the incident message. Exact match. (optional)
   * @param incidentMessageLike Filter by the incident message that the parameter is a substring of. (optional)
   * @param startedBefore Restrict to instances that were started before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedAfter Restrict to instances that were started after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param finishedBefore Restrict to instances that were finished before the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param finishedAfter Restrict to instances that were finished after the given date. By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedActivityAfter Restrict to instances that executed an activity after the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedActivityBefore Restrict to instances that executed an activity before the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedJobAfter Restrict to instances that executed an job after the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param executedJobBefore Restrict to instances that executed an job before the given date (inclusive). By [default](https://docs.camunda.org/manual/7.14/reference/rest/overview/date-format/), the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param startedBy Only include process instances that were started by the given user. (optional)
   * @param superProcessInstanceId Restrict query to all process instances that are sub process instances of the given process instance. Takes a process instance id. (optional)
   * @param subProcessInstanceId Restrict query to one process instance that has a sub process instance with the given id. (optional)
   * @param superCaseInstanceId Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param subCaseInstanceId Restrict query to one process instance that has a sub case instance with the given id. (optional)
   * @param caseInstanceId Restrict query to all process instances that are sub process instances of the given case instance. Takes a case instance id. (optional)
   * @param tenantIdIn Filter by a list of tenant ids. A process instance must have one of the given tenant ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param withoutTenantId Only include historic process instances which belong to no tenant. Value may only be &#x60;true&#x60;, as &#x60;false&#x60; is the default behavior. (optional)
   * @param executedActivityIdIn Restrict to instances that executed an activity with one of given ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param activeActivityIdIn Restrict to instances that have an active activity with one of given ids. Filter by a comma-separated list of &#x60;Strings&#x60; (optional)
   * @param active Restrict to instances that are active. (optional)
   * @param suspended Restrict to instances that are suspended. (optional)
   * @param completed Restrict to instances that are completed. (optional)
   * @param externallyTerminated Restrict to instances that are externallyTerminated. (optional)
   * @param internallyTerminated Restrict to instances that are internallyTerminated. (optional)
   * @param variables Only include process instances that have/had variables with certain values. Variable filtering expressions are comma-separated and are structured as follows: A valid parameter value has the form &#x60;key_operator_value&#x60;. &#x60;key&#x60; is the variable name, &#x60;operator&#x60; is the comparison operator to be used and &#x60;value&#x60; the variable value.  **Note:** Values are always treated as String objects on server side.  Valid operator values are: &#x60;eq&#x60; - equal to; &#x60;neq&#x60; - not equal to; &#x60;gt&#x60; - greater than; &#x60;gteq&#x60; - greater than or equal to; &#x60;lt&#x60; - lower than; &#x60;lteq&#x60; - lower than or equal to; &#x60;like&#x60;.  Key and value may not contain underscore or comma characters.  (optional)
   * @param variableNamesIgnoreCase Match all variable names provided in variables case-insensitively. If set to &#x60;true&#x60; variableName and variablename are treated as equal. (optional)
   * @param variableValuesIgnoreCase Match all variable values provided in variables case-insensitively. If set to &#x60;true&#x60; variableValue and variablevalue are treated as equal. (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> getHistoricProcessInstancesCountWithHttpInfo(String processInstanceId, String processInstanceIds, String processDefinitionId, String processDefinitionKey, String processDefinitionKeyIn, String processDefinitionName, String processDefinitionNameLike, String processDefinitionKeyNotIn, String processInstanceBusinessKey, String processInstanceBusinessKeyLike, Boolean rootProcessInstances, Boolean finished, Boolean unfinished, Boolean withIncidents, Boolean withRootIncidents, String incidentType, String incidentStatus, String incidentMessage, String incidentMessageLike, OffsetDateTime startedBefore, OffsetDateTime startedAfter, OffsetDateTime finishedBefore, OffsetDateTime finishedAfter, OffsetDateTime executedActivityAfter, OffsetDateTime executedActivityBefore, OffsetDateTime executedJobAfter, OffsetDateTime executedJobBefore, String startedBy, String superProcessInstanceId, String subProcessInstanceId, String superCaseInstanceId, String subCaseInstanceId, String caseInstanceId, String tenantIdIn, Boolean withoutTenantId, String executedActivityIdIn, String activeActivityIdIn, Boolean active, Boolean suspended, Boolean completed, Boolean externallyTerminated, Boolean internallyTerminated, String variables, Boolean variableNamesIgnoreCase, Boolean variableValuesIgnoreCase) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/history/process-instance/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceId", processInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceIds", processInstanceIds));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKey", processDefinitionKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionName", processDefinitionName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionNameLike", processDefinitionNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyNotIn", processDefinitionKeyNotIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKey", processInstanceBusinessKey));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceBusinessKeyLike", processInstanceBusinessKeyLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rootProcessInstances", rootProcessInstances));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "finished", finished));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "unfinished", unfinished));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withIncidents", withIncidents));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withRootIncidents", withRootIncidents));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentType", incidentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentStatus", incidentStatus));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessage", incidentMessage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessageLike", incidentMessageLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startedBefore", startedBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startedAfter", startedAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "finishedBefore", finishedBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "finishedAfter", finishedAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedActivityAfter", executedActivityAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedActivityBefore", executedActivityBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedJobAfter", executedJobAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedJobBefore", executedJobBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startedBy", startedBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "superProcessInstanceId", superProcessInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "subProcessInstanceId", subProcessInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "superCaseInstanceId", superCaseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "subCaseInstanceId", subCaseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "caseInstanceId", caseInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "withoutTenantId", withoutTenantId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executedActivityIdIn", executedActivityIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activeActivityIdIn", activeActivityIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "active", active));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "suspended", suspended));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "completed", completed));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "externallyTerminated", externallyTerminated));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "internallyTerminated", internallyTerminated));
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

    return apiClient.invokeAPI("HistoricProcessInstanceApi.getHistoricProcessInstancesCount", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List (POST)
   * Queries for historic process instances that fulfill the given parameters. This method is slightly more powerful than the [Get Process Instance](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/get-process-instance-query/) because it allows filtering by multiple process variables of types &#x60;String&#x60;, &#x60;Number&#x60; or &#x60;Boolean&#x60;.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param historicProcessInstanceQueryDto  (optional)
   * @return List&lt;HistoricProcessInstanceDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<HistoricProcessInstanceDto> queryHistoricProcessInstances(Integer firstResult, Integer maxResults, HistoricProcessInstanceQueryDto historicProcessInstanceQueryDto) throws ApiException {
    return queryHistoricProcessInstancesWithHttpInfo(firstResult, maxResults, historicProcessInstanceQueryDto).getData();
  }

  /**
   * Get List (POST)
   * Queries for historic process instances that fulfill the given parameters. This method is slightly more powerful than the [Get Process Instance](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/get-process-instance-query/) because it allows filtering by multiple process variables of types &#x60;String&#x60;, &#x60;Number&#x60; or &#x60;Boolean&#x60;.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param historicProcessInstanceQueryDto  (optional)
   * @return ApiResponse&lt;List&lt;HistoricProcessInstanceDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid, for example if a sortOrder parameter is supplied, but no sortBy. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<HistoricProcessInstanceDto>> queryHistoricProcessInstancesWithHttpInfo(Integer firstResult, Integer maxResults, HistoricProcessInstanceQueryDto historicProcessInstanceQueryDto) throws ApiException {
    Object localVarPostBody = historicProcessInstanceQueryDto;
    
    // create path and map variables
    String localVarPath = "/history/process-instance";

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

    GenericType<List<HistoricProcessInstanceDto>> localVarReturnType = new GenericType<List<HistoricProcessInstanceDto>>() {};

    return apiClient.invokeAPI("HistoricProcessInstanceApi.queryHistoricProcessInstances", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List Count (POST)
   * Queries for the number of historic process instances that fulfill the given parameters. This method takes the same message body as the [Get Process Instances (POST)](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/get-process-instance-query/) method and therefore it is slightly more powerful than the [Get Process Instance Count](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/post-process-instance-query-count/) method.
   * @param historicProcessInstanceQueryDto  (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto queryHistoricProcessInstancesCount(HistoricProcessInstanceQueryDto historicProcessInstanceQueryDto) throws ApiException {
    return queryHistoricProcessInstancesCountWithHttpInfo(historicProcessInstanceQueryDto).getData();
  }

  /**
   * Get List Count (POST)
   * Queries for the number of historic process instances that fulfill the given parameters. This method takes the same message body as the [Get Process Instances (POST)](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/get-process-instance-query/) method and therefore it is slightly more powerful than the [Get Process Instance Count](https://docs.camunda.org/manual/7.14/reference/rest/history/process-instance/post-process-instance-query-count/) method.
   * @param historicProcessInstanceQueryDto  (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> queryHistoricProcessInstancesCountWithHttpInfo(HistoricProcessInstanceQueryDto historicProcessInstanceQueryDto) throws ApiException {
    Object localVarPostBody = historicProcessInstanceQueryDto;
    
    // create path and map variables
    String localVarPath = "/history/process-instance/count";

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

    return apiClient.invokeAPI("HistoricProcessInstanceApi.queryHistoricProcessInstancesCount", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Set Removal Time Async (POST)
   * Sets the removal time to multiple historic process instances asynchronously (batch).  At least &#x60;historicProcessInstanceIds&#x60; or &#x60;historicProcessInstanceQuery&#x60; has to be provided. If both are provided, all instances matching query criterion and instances from the list will be updated with a removal time.
   * @param setRemovalTimeToHistoricProcessInstancesDto  (optional)
   * @return BatchDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Request was unsuccessfull due to a bad user request. This occurs if some of the query parameters are invalid, e. g. if neither &#x60;historicProcessInstances&#x60; nor &#x60;historicProcessInstanceQuery&#x60; is present or if no mode is specified.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public BatchDto setRemovalTimeAsync(SetRemovalTimeToHistoricProcessInstancesDto setRemovalTimeToHistoricProcessInstancesDto) throws ApiException {
    return setRemovalTimeAsyncWithHttpInfo(setRemovalTimeToHistoricProcessInstancesDto).getData();
  }

  /**
   * Set Removal Time Async (POST)
   * Sets the removal time to multiple historic process instances asynchronously (batch).  At least &#x60;historicProcessInstanceIds&#x60; or &#x60;historicProcessInstanceQuery&#x60; has to be provided. If both are provided, all instances matching query criterion and instances from the list will be updated with a removal time.
   * @param setRemovalTimeToHistoricProcessInstancesDto  (optional)
   * @return ApiResponse&lt;BatchDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Bad Request Request was unsuccessfull due to a bad user request. This occurs if some of the query parameters are invalid, e. g. if neither &#x60;historicProcessInstances&#x60; nor &#x60;historicProcessInstanceQuery&#x60; is present or if no mode is specified.  See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<BatchDto> setRemovalTimeAsyncWithHttpInfo(SetRemovalTimeToHistoricProcessInstancesDto setRemovalTimeToHistoricProcessInstancesDto) throws ApiException {
    Object localVarPostBody = setRemovalTimeToHistoricProcessInstancesDto;
    
    // create path and map variables
    String localVarPath = "/history/process-instance/set-removal-time";

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

    return apiClient.invokeAPI("HistoricProcessInstanceApi.setRemovalTimeAsync", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
