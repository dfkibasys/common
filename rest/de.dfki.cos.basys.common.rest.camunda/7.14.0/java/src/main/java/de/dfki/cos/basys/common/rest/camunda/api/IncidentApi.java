package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.CountResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.IncidentDto;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class IncidentApi {
  private ApiClient apiClient;

  public IncidentApi() {
    this(Configuration.getDefaultApiClient());
  }

  public IncidentApi(ApiClient apiClient) {
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
   * Get Incident
   * Retrieves an incident by ID.
   * @param id The id of the incident to be retrieved. (required)
   * @return IncidentDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if an incident with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public IncidentDto getIncident(String id) throws ApiException {
    return getIncidentWithHttpInfo(id).getData();
  }

  /**
   * Get Incident
   * Retrieves an incident by ID.
   * @param id The id of the incident to be retrieved. (required)
   * @return ApiResponse&lt;IncidentDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if an incident with given id does not exist. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<IncidentDto> getIncidentWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getIncident");
    }
    
    // create path and map variables
    String localVarPath = "/incident/{id}"
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

    GenericType<IncidentDto> localVarReturnType = new GenericType<IncidentDto>() {};

    return apiClient.invokeAPI("IncidentApi.getIncident", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List
   * Queries for incidents that fulfill given parameters. The size of the result set can be retrieved by using the [Get Incident Count](https://docs.camunda.org/manual/7.14/reference/rest/incident/get-query-count/) method.
   * @param incidentId Restricts to incidents that have the given id. (optional)
   * @param incidentType Restricts to incidents that belong to the given incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Restricts to incidents that have the given incident message. (optional)
   * @param incidentMessageLike Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character &#39;%&#39; to express like-strategy: starts with (&#x60;string%&#x60;), ends with (&#x60;%string&#x60;) or contains (&#x60;%string%&#x60;). (optional)
   * @param processDefinitionId Restricts to incidents that belong to a process definition with the given id. (optional)
   * @param processDefinitionKeyIn Restricts to incidents that belong to a process definition with the given keys. Must be a comma-separated list. (optional)
   * @param processInstanceId Restricts to incidents that belong to a process instance with the given id. (optional)
   * @param executionId Restricts to incidents that belong to an execution with the given id. (optional)
   * @param incidentTimestampBefore Restricts to incidents that have an incidentTimestamp date before the given date. By default, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param incidentTimestampAfter Restricts to incidents that have an incidentTimestamp date after the given date. By default*, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param activityId Restricts to incidents that belong to an activity with the given id. (optional)
   * @param failedActivityId Restricts to incidents that were created due to the failure of an activity with the given id. (optional)
   * @param causeIncidentId Restricts to incidents that have the given incident id as cause incident. (optional)
   * @param rootCauseIncidentId Restricts to incidents that have the given incident id as root cause incident. (optional)
   * @param _configuration Restricts to incidents that have the given parameter set as configuration. (optional)
   * @param tenantIdIn Restricts to incidents that have one of the given comma-separated tenant ids. (optional)
   * @param jobDefinitionIdIn Restricts to incidents that have one of the given comma-separated job definition ids. (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @return List&lt;IncidentDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<IncidentDto> getIncidents(String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String processDefinitionId, String processDefinitionKeyIn, String processInstanceId, String executionId, OffsetDateTime incidentTimestampBefore, OffsetDateTime incidentTimestampAfter, String activityId, String failedActivityId, String causeIncidentId, String rootCauseIncidentId, String _configuration, String tenantIdIn, String jobDefinitionIdIn, String sortBy, String sortOrder) throws ApiException {
    return getIncidentsWithHttpInfo(incidentId, incidentType, incidentMessage, incidentMessageLike, processDefinitionId, processDefinitionKeyIn, processInstanceId, executionId, incidentTimestampBefore, incidentTimestampAfter, activityId, failedActivityId, causeIncidentId, rootCauseIncidentId, _configuration, tenantIdIn, jobDefinitionIdIn, sortBy, sortOrder).getData();
  }

  /**
   * Get List
   * Queries for incidents that fulfill given parameters. The size of the result set can be retrieved by using the [Get Incident Count](https://docs.camunda.org/manual/7.14/reference/rest/incident/get-query-count/) method.
   * @param incidentId Restricts to incidents that have the given id. (optional)
   * @param incidentType Restricts to incidents that belong to the given incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Restricts to incidents that have the given incident message. (optional)
   * @param incidentMessageLike Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character &#39;%&#39; to express like-strategy: starts with (&#x60;string%&#x60;), ends with (&#x60;%string&#x60;) or contains (&#x60;%string%&#x60;). (optional)
   * @param processDefinitionId Restricts to incidents that belong to a process definition with the given id. (optional)
   * @param processDefinitionKeyIn Restricts to incidents that belong to a process definition with the given keys. Must be a comma-separated list. (optional)
   * @param processInstanceId Restricts to incidents that belong to a process instance with the given id. (optional)
   * @param executionId Restricts to incidents that belong to an execution with the given id. (optional)
   * @param incidentTimestampBefore Restricts to incidents that have an incidentTimestamp date before the given date. By default, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param incidentTimestampAfter Restricts to incidents that have an incidentTimestamp date after the given date. By default*, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param activityId Restricts to incidents that belong to an activity with the given id. (optional)
   * @param failedActivityId Restricts to incidents that were created due to the failure of an activity with the given id. (optional)
   * @param causeIncidentId Restricts to incidents that have the given incident id as cause incident. (optional)
   * @param rootCauseIncidentId Restricts to incidents that have the given incident id as root cause incident. (optional)
   * @param _configuration Restricts to incidents that have the given parameter set as configuration. (optional)
   * @param tenantIdIn Restricts to incidents that have one of the given comma-separated tenant ids. (optional)
   * @param jobDefinitionIdIn Restricts to incidents that have one of the given comma-separated job definition ids. (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @return ApiResponse&lt;List&lt;IncidentDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<IncidentDto>> getIncidentsWithHttpInfo(String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String processDefinitionId, String processDefinitionKeyIn, String processInstanceId, String executionId, OffsetDateTime incidentTimestampBefore, OffsetDateTime incidentTimestampAfter, String activityId, String failedActivityId, String causeIncidentId, String rootCauseIncidentId, String _configuration, String tenantIdIn, String jobDefinitionIdIn, String sortBy, String sortOrder) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/incident";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentId", incidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentType", incidentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessage", incidentMessage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessageLike", incidentMessageLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceId", processInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executionId", executionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentTimestampBefore", incidentTimestampBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentTimestampAfter", incidentTimestampAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityId", activityId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "failedActivityId", failedActivityId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "causeIncidentId", causeIncidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rootCauseIncidentId", rootCauseIncidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "configuration", _configuration));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "jobDefinitionIdIn", jobDefinitionIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortBy", sortBy));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "sortOrder", sortOrder));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<IncidentDto>> localVarReturnType = new GenericType<List<IncidentDto>>() {};

    return apiClient.invokeAPI("IncidentApi.getIncidents", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List Count
   * Queries for the number of incidents that fulfill given parameters. Takes the same parameters as the [Get Incidents](https://docs.camunda.org/manual/7.14/reference/rest/incident/get-query/) method.
   * @param incidentId Restricts to incidents that have the given id. (optional)
   * @param incidentType Restricts to incidents that belong to the given incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Restricts to incidents that have the given incident message. (optional)
   * @param incidentMessageLike Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character &#39;%&#39; to express like-strategy: starts with (&#x60;string%&#x60;), ends with (&#x60;%string&#x60;) or contains (&#x60;%string%&#x60;). (optional)
   * @param processDefinitionId Restricts to incidents that belong to a process definition with the given id. (optional)
   * @param processDefinitionKeyIn Restricts to incidents that belong to a process definition with the given keys. Must be a comma-separated list. (optional)
   * @param processInstanceId Restricts to incidents that belong to a process instance with the given id. (optional)
   * @param executionId Restricts to incidents that belong to an execution with the given id. (optional)
   * @param incidentTimestampBefore Restricts to incidents that have an incidentTimestamp date before the given date. By default, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param incidentTimestampAfter Restricts to incidents that have an incidentTimestamp date after the given date. By default*, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param activityId Restricts to incidents that belong to an activity with the given id. (optional)
   * @param failedActivityId Restricts to incidents that were created due to the failure of an activity with the given id. (optional)
   * @param causeIncidentId Restricts to incidents that have the given incident id as cause incident. (optional)
   * @param rootCauseIncidentId Restricts to incidents that have the given incident id as root cause incident. (optional)
   * @param _configuration Restricts to incidents that have the given parameter set as configuration. (optional)
   * @param tenantIdIn Restricts to incidents that have one of the given comma-separated tenant ids. (optional)
   * @param jobDefinitionIdIn Restricts to incidents that have one of the given comma-separated job definition ids. (optional)
   * @return List&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<CountResultDto> getIncidentsCount(String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String processDefinitionId, String processDefinitionKeyIn, String processInstanceId, String executionId, OffsetDateTime incidentTimestampBefore, OffsetDateTime incidentTimestampAfter, String activityId, String failedActivityId, String causeIncidentId, String rootCauseIncidentId, String _configuration, String tenantIdIn, String jobDefinitionIdIn) throws ApiException {
    return getIncidentsCountWithHttpInfo(incidentId, incidentType, incidentMessage, incidentMessageLike, processDefinitionId, processDefinitionKeyIn, processInstanceId, executionId, incidentTimestampBefore, incidentTimestampAfter, activityId, failedActivityId, causeIncidentId, rootCauseIncidentId, _configuration, tenantIdIn, jobDefinitionIdIn).getData();
  }

  /**
   * Get List Count
   * Queries for the number of incidents that fulfill given parameters. Takes the same parameters as the [Get Incidents](https://docs.camunda.org/manual/7.14/reference/rest/incident/get-query/) method.
   * @param incidentId Restricts to incidents that have the given id. (optional)
   * @param incidentType Restricts to incidents that belong to the given incident type. See the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) for a list of incident types. (optional)
   * @param incidentMessage Restricts to incidents that have the given incident message. (optional)
   * @param incidentMessageLike Restricts to incidents that incidents message is a substring of the given value. The string can include the wildcard character &#39;%&#39; to express like-strategy: starts with (&#x60;string%&#x60;), ends with (&#x60;%string&#x60;) or contains (&#x60;%string%&#x60;). (optional)
   * @param processDefinitionId Restricts to incidents that belong to a process definition with the given id. (optional)
   * @param processDefinitionKeyIn Restricts to incidents that belong to a process definition with the given keys. Must be a comma-separated list. (optional)
   * @param processInstanceId Restricts to incidents that belong to a process instance with the given id. (optional)
   * @param executionId Restricts to incidents that belong to an execution with the given id. (optional)
   * @param incidentTimestampBefore Restricts to incidents that have an incidentTimestamp date before the given date. By default, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param incidentTimestampAfter Restricts to incidents that have an incidentTimestamp date after the given date. By default*, the date must have the format &#x60;yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSSZ&#x60;, e.g., &#x60;2013-01-23T14:42:45.000+0200&#x60;. (optional)
   * @param activityId Restricts to incidents that belong to an activity with the given id. (optional)
   * @param failedActivityId Restricts to incidents that were created due to the failure of an activity with the given id. (optional)
   * @param causeIncidentId Restricts to incidents that have the given incident id as cause incident. (optional)
   * @param rootCauseIncidentId Restricts to incidents that have the given incident id as root cause incident. (optional)
   * @param _configuration Restricts to incidents that have the given parameter set as configuration. (optional)
   * @param tenantIdIn Restricts to incidents that have one of the given comma-separated tenant ids. (optional)
   * @param jobDefinitionIdIn Restricts to incidents that have one of the given comma-separated job definition ids. (optional)
   * @return ApiResponse&lt;List&lt;CountResultDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<CountResultDto>> getIncidentsCountWithHttpInfo(String incidentId, String incidentType, String incidentMessage, String incidentMessageLike, String processDefinitionId, String processDefinitionKeyIn, String processInstanceId, String executionId, OffsetDateTime incidentTimestampBefore, OffsetDateTime incidentTimestampAfter, String activityId, String failedActivityId, String causeIncidentId, String rootCauseIncidentId, String _configuration, String tenantIdIn, String jobDefinitionIdIn) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/incident/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentId", incidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentType", incidentType));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessage", incidentMessage));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentMessageLike", incidentMessageLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionId", processDefinitionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processDefinitionKeyIn", processDefinitionKeyIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "processInstanceId", processInstanceId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "executionId", executionId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentTimestampBefore", incidentTimestampBefore));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "incidentTimestampAfter", incidentTimestampAfter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "activityId", activityId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "failedActivityId", failedActivityId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "causeIncidentId", causeIncidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "rootCauseIncidentId", rootCauseIncidentId));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "configuration", _configuration));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "tenantIdIn", tenantIdIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "jobDefinitionIdIn", jobDefinitionIdIn));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<CountResultDto>> localVarReturnType = new GenericType<List<CountResultDto>>() {};

    return apiClient.invokeAPI("IncidentApi.getIncidentsCount", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Resolve Incident
   * Resolves an incident with given id.
   * @param id The id of the incident to be resolved. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if an incident with given id does not exist. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if an incident is not related to any execution or an incident is of type &#x60;failedJob&#x60; or &#x60;failedExternalTask&#x60;. To resolve such an incident, please refer to the [Incident Types](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) section. </td><td>  -  </td></tr>
     </table>
   */
  public void resolveIncident(String id) throws ApiException {
    resolveIncidentWithHttpInfo(id);
  }

  /**
   * Resolve Incident
   * Resolves an incident with given id.
   * @param id The id of the incident to be resolved. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Returned if an incident with given id does not exist. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if an incident is not related to any execution or an incident is of type &#x60;failedJob&#x60; or &#x60;failedExternalTask&#x60;. To resolve such an incident, please refer to the [Incident Types](https://docs.camunda.org/manual/7.14/user-guide/process-engine/incidents/#incident-types) section. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> resolveIncidentWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling resolveIncident");
    }
    
    // create path and map variables
    String localVarPath = "/incident/{id}"
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

    return apiClient.invokeAPI("IncidentApi.resolveIncident", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
