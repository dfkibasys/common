/*
 * Camunda BPM REST API
 * OpenApi Spec for Camunda BPM REST API.
 *
 * The version of the OpenAPI document: 7.14.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiCallback;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;
import de.dfki.cos.basys.common.rest.camunda.ProgressRequestBody;
import de.dfki.cos.basys.common.rest.camunda.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.MetricsIntervalResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.MetricsResultDto;
import org.threeten.bp.OffsetDateTime;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetricsApi {
    private ApiClient localVarApiClient;

    public MetricsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public MetricsApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for getMetrics
     * @param metricsName The name of the metric. (required)
     * @param startDate The start date (inclusive). (optional)
     * @param endDate The end date (exclusive). (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getMetricsCall(String metricsName, OffsetDateTime startDate, OffsetDateTime endDate, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/metrics/{metrics-name}/sum"
            .replaceAll("\\{" + "metrics-name" + "\\}", localVarApiClient.escapeString(metricsName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (startDate != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("startDate", startDate));
        }

        if (endDate != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("endDate", endDate));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call getMetricsValidateBeforeCall(String metricsName, OffsetDateTime startDate, OffsetDateTime endDate, final ApiCallback _callback) throws ApiException {
        
        // verify the required parameter 'metricsName' is set
        if (metricsName == null) {
            throw new ApiException("Missing the required parameter 'metricsName' when calling getMetrics(Async)");
        }
        

        okhttp3.Call localVarCall = getMetricsCall(metricsName, startDate, endDate, _callback);
        return localVarCall;

    }

    /**
     * 
     * Retrieves the &#x60;sum&#x60; (count) for a given metric.
     * @param metricsName The name of the metric. (required)
     * @param startDate The start date (inclusive). (optional)
     * @param endDate The end date (exclusive). (optional)
     * @return MetricsResultDto
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
     */
    public MetricsResultDto getMetrics(String metricsName, OffsetDateTime startDate, OffsetDateTime endDate) throws ApiException {
        ApiResponse<MetricsResultDto> localVarResp = getMetricsWithHttpInfo(metricsName, startDate, endDate);
        return localVarResp.getData();
    }

    /**
     * 
     * Retrieves the &#x60;sum&#x60; (count) for a given metric.
     * @param metricsName The name of the metric. (required)
     * @param startDate The start date (inclusive). (optional)
     * @param endDate The end date (exclusive). (optional)
     * @return ApiResponse&lt;MetricsResultDto&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<MetricsResultDto> getMetricsWithHttpInfo(String metricsName, OffsetDateTime startDate, OffsetDateTime endDate) throws ApiException {
        okhttp3.Call localVarCall = getMetricsValidateBeforeCall(metricsName, startDate, endDate, null);
        Type localVarReturnType = new TypeToken<MetricsResultDto>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Retrieves the &#x60;sum&#x60; (count) for a given metric.
     * @param metricsName The name of the metric. (required)
     * @param startDate The start date (inclusive). (optional)
     * @param endDate The end date (exclusive). (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call getMetricsAsync(String metricsName, OffsetDateTime startDate, OffsetDateTime endDate, final ApiCallback<MetricsResultDto> _callback) throws ApiException {

        okhttp3.Call localVarCall = getMetricsValidateBeforeCall(metricsName, startDate, endDate, _callback);
        Type localVarReturnType = new TypeToken<MetricsResultDto>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
    /**
     * Build call for interval
     * @param name The name of the metric. (optional)
     * @param reporter The name of the reporter (host), on which the metrics was logged. This will have value provided by the [hostname configuration property](https://docs.camunda.org/manual/7.14/reference/deployment-descriptors/tags/process-engine/#hostname). (optional)
     * @param startDate The start date (inclusive). (optional)
     * @param endDate The end date (exclusive). (optional)
     * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
     * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
     * @param interval The interval for which the metrics should be aggregated. Time unit is seconds. Default: The interval is set to 15 minutes (900 seconds). (optional, default to &quot;900&quot;)
     * @param aggregateByReporter Aggregate metrics by reporter. (optional)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call intervalCall(String name, String reporter, OffsetDateTime startDate, OffsetDateTime endDate, Integer firstResult, Integer maxResults, String interval, String aggregateByReporter, final ApiCallback _callback) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/metrics";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        if (name != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("name", name));
        }

        if (reporter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("reporter", reporter));
        }

        if (startDate != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("startDate", startDate));
        }

        if (endDate != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("endDate", endDate));
        }

        if (firstResult != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("firstResult", firstResult));
        }

        if (maxResults != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("maxResults", maxResults));
        }

        if (interval != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("interval", interval));
        }

        if (aggregateByReporter != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("aggregateByReporter", aggregateByReporter));
        }

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call intervalValidateBeforeCall(String name, String reporter, OffsetDateTime startDate, OffsetDateTime endDate, Integer firstResult, Integer maxResults, String interval, String aggregateByReporter, final ApiCallback _callback) throws ApiException {
        

        okhttp3.Call localVarCall = intervalCall(name, reporter, startDate, endDate, firstResult, maxResults, interval, aggregateByReporter, _callback);
        return localVarCall;

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
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. </td><td>  -  </td></tr>
     </table>
     */
    public List<MetricsIntervalResultDto> interval(String name, String reporter, OffsetDateTime startDate, OffsetDateTime endDate, Integer firstResult, Integer maxResults, String interval, String aggregateByReporter) throws ApiException {
        ApiResponse<List<MetricsIntervalResultDto>> localVarResp = intervalWithHttpInfo(name, reporter, startDate, endDate, firstResult, maxResults, interval, aggregateByReporter);
        return localVarResp.getData();
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
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<List<MetricsIntervalResultDto>> intervalWithHttpInfo(String name, String reporter, OffsetDateTime startDate, OffsetDateTime endDate, Integer firstResult, Integer maxResults, String interval, String aggregateByReporter) throws ApiException {
        okhttp3.Call localVarCall = intervalValidateBeforeCall(name, reporter, startDate, endDate, firstResult, maxResults, interval, aggregateByReporter, null);
        Type localVarReturnType = new TypeToken<List<MetricsIntervalResultDto>>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     *  (asynchronously)
     * Retrieves a list of metrics, aggregated for a given interval.
     * @param name The name of the metric. (optional)
     * @param reporter The name of the reporter (host), on which the metrics was logged. This will have value provided by the [hostname configuration property](https://docs.camunda.org/manual/7.14/reference/deployment-descriptors/tags/process-engine/#hostname). (optional)
     * @param startDate The start date (inclusive). (optional)
     * @param endDate The end date (exclusive). (optional)
     * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
     * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
     * @param interval The interval for which the metrics should be aggregated. Time unit is seconds. Default: The interval is set to 15 minutes (900 seconds). (optional, default to &quot;900&quot;)
     * @param aggregateByReporter Aggregate metrics by reporter. (optional)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
        <tr><td> 400 </td><td> Returned if some of the query parameters are invalid. </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call intervalAsync(String name, String reporter, OffsetDateTime startDate, OffsetDateTime endDate, Integer firstResult, Integer maxResults, String interval, String aggregateByReporter, final ApiCallback<List<MetricsIntervalResultDto>> _callback) throws ApiException {

        okhttp3.Call localVarCall = intervalValidateBeforeCall(name, reporter, startDate, endDate, firstResult, maxResults, interval, aggregateByReporter, _callback);
        Type localVarReturnType = new TypeToken<List<MetricsIntervalResultDto>>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}