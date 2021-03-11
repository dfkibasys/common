package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.MetricsIntervalResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.MetricsResultDto;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class MetricsApi {
  private ApiClient apiClient;

  public MetricsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public MetricsApi(ApiClient apiClient) {
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
   * Retrieves the &#x60;sum&#x60; (count) for a given metric.
   * @param metricsName The name of the metric. (required)
   * @param startDate The start date (inclusive). (optional)
   * @param endDate The end date (exclusive). (optional)
   * @return MetricsResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public MetricsResultDto getMetrics(String metricsName, OffsetDateTime startDate, OffsetDateTime endDate) throws ApiException {
    return getMetricsWithHttpInfo(metricsName, startDate, endDate).getData();
  }

  /**
   * 
   * Retrieves the &#x60;sum&#x60; (count) for a given metric.
   * @param metricsName The name of the metric. (required)
   * @param startDate The start date (inclusive). (optional)
   * @param endDate The end date (exclusive). (optional)
   * @return ApiResponse&lt;MetricsResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<MetricsResultDto> getMetricsWithHttpInfo(String metricsName, OffsetDateTime startDate, OffsetDateTime endDate) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'metricsName' is set
    if (metricsName == null) {
      throw new ApiException(400, "Missing the required parameter 'metricsName' when calling getMetrics");
    }
    
    // create path and map variables
    String localVarPath = "/metrics/{metrics-name}/sum"
      .replaceAll("\\{" + "metrics-name" + "\\}", apiClient.escapeString(metricsName.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startDate", startDate));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "endDate", endDate));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<MetricsResultDto> localVarReturnType = new GenericType<MetricsResultDto>() {};

    return apiClient.invokeAPI("MetricsApi.getMetrics", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves a list of metrics, aggregated for a given interval.
   * @param name The name of the metric. (optional)
   * @param reporter The name of the reporter (host), on which the metrics was logged. This will have value provided by the [hostname configuration property](https://docs.camunda.org/manual/7.14/reference/deployment-descriptors/tags/process-engine/#hostname). (optional)
   * @param startDate The start date (inclusive). (optional)
   * @param endDate The end date (exclusive). (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param interval The interval for which the metrics should be aggregated. Time unit is seconds. Default: The interval is set to 15 minutes (900 seconds). (optional, default to &quot;900&quot;)
   * @param aggregateByReporter Aggregate metrics by reporter. (optional)
   * @return List&lt;MetricsIntervalResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. </td><td>  -  </td></tr>
     </table>
   */
  public List<MetricsIntervalResultDto> interval(String name, String reporter, OffsetDateTime startDate, OffsetDateTime endDate, Integer firstResult, Integer maxResults, String interval, String aggregateByReporter) throws ApiException {
    return intervalWithHttpInfo(name, reporter, startDate, endDate, firstResult, maxResults, interval, aggregateByReporter).getData();
  }

  /**
   * 
   * Retrieves a list of metrics, aggregated for a given interval.
   * @param name The name of the metric. (optional)
   * @param reporter The name of the reporter (host), on which the metrics was logged. This will have value provided by the [hostname configuration property](https://docs.camunda.org/manual/7.14/reference/deployment-descriptors/tags/process-engine/#hostname). (optional)
   * @param startDate The start date (inclusive). (optional)
   * @param endDate The end date (exclusive). (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @param interval The interval for which the metrics should be aggregated. Time unit is seconds. Default: The interval is set to 15 minutes (900 seconds). (optional, default to &quot;900&quot;)
   * @param aggregateByReporter Aggregate metrics by reporter. (optional)
   * @return ApiResponse&lt;List&lt;MetricsIntervalResultDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<MetricsIntervalResultDto>> intervalWithHttpInfo(String name, String reporter, OffsetDateTime startDate, OffsetDateTime endDate, Integer firstResult, Integer maxResults, String interval, String aggregateByReporter) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/metrics";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "name", name));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "reporter", reporter));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "startDate", startDate));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "endDate", endDate));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstResult", firstResult));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "maxResults", maxResults));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "interval", interval));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "aggregateByReporter", aggregateByReporter));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<MetricsIntervalResultDto>> localVarReturnType = new GenericType<List<MetricsIntervalResultDto>>() {};

    return apiClient.invokeAPI("MetricsApi.interval", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
