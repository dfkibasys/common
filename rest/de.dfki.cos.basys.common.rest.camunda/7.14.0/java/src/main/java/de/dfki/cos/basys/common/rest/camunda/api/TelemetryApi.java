package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.TelemetryConfigurationDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class TelemetryApi {
  private ApiClient apiClient;

  public TelemetryApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TelemetryApi(ApiClient apiClient) {
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
   * Configure Telemetry
   * Configures whether Camunda receives data collection of the process engine setup and usage.
   * @param telemetryConfigurationDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> If the user who perform the operation is not a &lt;b&gt;camunda-admin&lt;/b&gt; user. </td><td>  -  </td></tr>
     </table>
   */
  public void configureTelemetry(TelemetryConfigurationDto telemetryConfigurationDto) throws ApiException {
    configureTelemetryWithHttpInfo(telemetryConfigurationDto);
  }

  /**
   * Configure Telemetry
   * Configures whether Camunda receives data collection of the process engine setup and usage.
   * @param telemetryConfigurationDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> If the user who perform the operation is not a &lt;b&gt;camunda-admin&lt;/b&gt; user. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> configureTelemetryWithHttpInfo(TelemetryConfigurationDto telemetryConfigurationDto) throws ApiException {
    Object localVarPostBody = telemetryConfigurationDto;
    
    // create path and map variables
    String localVarPath = "/telemetry/configuration";

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

    return apiClient.invokeAPI("TelemetryApi.configureTelemetry", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Fetch Telemetry Configuration
   * Fetches Telemetry Configuration.
   * @return TelemetryConfigurationDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> If the user who perform the operation is not a &lt;b&gt;camunda-admin&lt;/b&gt; user. </td><td>  -  </td></tr>
     </table>
   */
  public TelemetryConfigurationDto getTelemetryConfiguration() throws ApiException {
    return getTelemetryConfigurationWithHttpInfo().getData();
  }

  /**
   * Fetch Telemetry Configuration
   * Fetches Telemetry Configuration.
   * @return ApiResponse&lt;TelemetryConfigurationDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 401 </td><td> If the user who perform the operation is not a &lt;b&gt;camunda-admin&lt;/b&gt; user. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<TelemetryConfigurationDto> getTelemetryConfigurationWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/telemetry/configuration";

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

    GenericType<TelemetryConfigurationDto> localVarReturnType = new GenericType<TelemetryConfigurationDto>() {};

    return apiClient.invokeAPI("TelemetryApi.getTelemetryConfiguration", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
