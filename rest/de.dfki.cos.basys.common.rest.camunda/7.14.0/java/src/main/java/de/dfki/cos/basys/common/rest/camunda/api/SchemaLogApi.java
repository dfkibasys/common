package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.SchemaLogEntryDto;
import de.dfki.cos.basys.common.rest.camunda.dto.SchemaLogQueryDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class SchemaLogApi {
  private ApiClient apiClient;

  public SchemaLogApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SchemaLogApi(ApiClient apiClient) {
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
   * Queries for schema log entries that fulfill given parameters.
   * @param version Only return schema log entries with a specific version. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return List&lt;SchemaLogEntryDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. **Note**: In order to get any results a user of group &#x60;camunda-admin&#x60; must be authenticated. </td><td>  -  </td></tr>
     </table>
   */
  public List<SchemaLogEntryDto> getSchemaLog(String version, Integer firstResult, Integer maxResults) throws ApiException {
    return getSchemaLogWithHttpInfo(version, firstResult, maxResults).getData();
  }

  /**
   * 
   * Queries for schema log entries that fulfill given parameters.
   * @param version Only return schema log entries with a specific version. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return ApiResponse&lt;List&lt;SchemaLogEntryDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. **Note**: In order to get any results a user of group &#x60;camunda-admin&#x60; must be authenticated. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<SchemaLogEntryDto>> getSchemaLogWithHttpInfo(String version, Integer firstResult, Integer maxResults) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/schema/log";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "version", version));
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

    GenericType<List<SchemaLogEntryDto>> localVarReturnType = new GenericType<List<SchemaLogEntryDto>>() {};

    return apiClient.invokeAPI("SchemaLogApi.getSchemaLog", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Queries for schema log entries that fulfill given parameters.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param schemaLogQueryDto  (optional)
   * @return List&lt;SchemaLogEntryDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. **Note**: In order to get any results a user of group camunda-admin must be authenticated. </td><td>  -  </td></tr>
     </table>
   */
  public List<SchemaLogEntryDto> querySchemaLog(Integer firstResult, Integer maxResults, SchemaLogQueryDto schemaLogQueryDto) throws ApiException {
    return querySchemaLogWithHttpInfo(firstResult, maxResults, schemaLogQueryDto).getData();
  }

  /**
   * 
   * Queries for schema log entries that fulfill given parameters.
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param schemaLogQueryDto  (optional)
   * @return ApiResponse&lt;List&lt;SchemaLogEntryDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. **Note**: In order to get any results a user of group camunda-admin must be authenticated. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<SchemaLogEntryDto>> querySchemaLogWithHttpInfo(Integer firstResult, Integer maxResults, SchemaLogQueryDto schemaLogQueryDto) throws ApiException {
    Object localVarPostBody = schemaLogQueryDto;
    
    // create path and map variables
    String localVarPath = "/schema/log";

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

    GenericType<List<SchemaLogEntryDto>> localVarReturnType = new GenericType<List<SchemaLogEntryDto>>() {};

    return apiClient.invokeAPI("SchemaLogApi.querySchemaLog", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
