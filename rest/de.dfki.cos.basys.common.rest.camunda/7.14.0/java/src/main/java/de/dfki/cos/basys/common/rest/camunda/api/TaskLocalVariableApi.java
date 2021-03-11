package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import java.io.File;
import de.dfki.cos.basys.common.rest.camunda.dto.PatchVariablesDto;
import de.dfki.cos.basys.common.rest.camunda.dto.VariableValueDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class TaskLocalVariableApi {
  private ApiClient apiClient;

  public TaskLocalVariableApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TaskLocalVariableApi(ApiClient apiClient) {
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
   * Removes a local variable from a task by id.
   * @param id The id of the task to delete the variable from. (required)
   * @param varName The name of the variable to be removed. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteTaskLocalVariable(String id, String varName) throws ApiException {
    deleteTaskLocalVariableWithHttpInfo(id, varName);
  }

  /**
   * 
   * Removes a local variable from a task by id.
   * @param id The id of the task to delete the variable from. (required)
   * @param varName The name of the variable to be removed. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteTaskLocalVariableWithHttpInfo(String id, String varName) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteTaskLocalVariable");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling deleteTaskLocalVariable");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/localVariables/{varName}"
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
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    return apiClient.invokeAPI("TaskLocalVariableApi.deleteTaskLocalVariable", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Retrieves a variable from the context of a given task by id.
   * @param id The id of the task to retrieve the variable from. (required)
   * @param varName The name of the variable to get (required)
   * @param deserializeValue Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on the server side (default &#x60;true&#x60;).  If set to &#x60;true&#x60;, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to &#x60;false&#x60;, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While &#x60;true&#x60; is the default value for reasons of backward compatibility, we recommend setting this parameter to &#x60;false&#x60; when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return VariableValueDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Variable with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public VariableValueDto getTaskLocalVariable(String id, String varName, Boolean deserializeValue) throws ApiException {
    return getTaskLocalVariableWithHttpInfo(id, varName, deserializeValue).getData();
  }

  /**
   * 
   * Retrieves a variable from the context of a given task by id.
   * @param id The id of the task to retrieve the variable from. (required)
   * @param varName The name of the variable to get (required)
   * @param deserializeValue Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on the server side (default &#x60;true&#x60;).  If set to &#x60;true&#x60;, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to &#x60;false&#x60;, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  Note: While &#x60;true&#x60; is the default value for reasons of backward compatibility, we recommend setting this parameter to &#x60;false&#x60; when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return ApiResponse&lt;VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Variable with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<VariableValueDto> getTaskLocalVariableWithHttpInfo(String id, String varName, Boolean deserializeValue) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getTaskLocalVariable");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling getTaskLocalVariable");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/localVariables/{varName}"
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

    return apiClient.invokeAPI("TaskLocalVariableApi.getTaskLocalVariable", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves a binary variable from the context of a given task by id. Applicable for byte array and file variables.
   * @param id The id of the task to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @return File
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful.         For binary variables or files without any MIME type information, a byte stream is returned.         File variables with MIME type information are returned as the saved type.         Additionally, for file variables the Content-Disposition header will be set. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Variable with given id exists but is not a binary variable.See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Variable with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public File getTaskLocalVariableBinary(String id, String varName) throws ApiException {
    return getTaskLocalVariableBinaryWithHttpInfo(id, varName).getData();
  }

  /**
   * 
   * Retrieves a binary variable from the context of a given task by id. Applicable for byte array and file variables.
   * @param id The id of the task to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful.         For binary variables or files without any MIME type information, a byte stream is returned.         File variables with MIME type information are returned as the saved type.         Additionally, for file variables the Content-Disposition header will be set. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Variable with given id exists but is not a binary variable.See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Variable with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<File> getTaskLocalVariableBinaryWithHttpInfo(String id, String varName) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getTaskLocalVariableBinary");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling getTaskLocalVariableBinary");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/localVariables/{varName}/data"
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

    return apiClient.invokeAPI("TaskLocalVariableApi.getTaskLocalVariableBinary", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Retrieves all variables of a given task by id.
   * @param id The id of the task to retrieve the variables from. (required)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on the server side (default &#x60;true&#x60;).  If set to &#x60;true&#x60;, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to &#x60;false&#x60;, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note:** While &#x60;true&#x60; is the default value for reasons of backward compatibility, we recommend setting this parameter to &#x60;false&#x60; when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return Map&lt;String, VariableValueDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Map<String, VariableValueDto> getTaskLocalVariables(String id, Boolean deserializeValues) throws ApiException {
    return getTaskLocalVariablesWithHttpInfo(id, deserializeValues).getData();
  }

  /**
   * 
   * Retrieves all variables of a given task by id.
   * @param id The id of the task to retrieve the variables from. (required)
   * @param deserializeValues Determines whether serializable variable values (typically variables that store custom Java objects) should be deserialized on the server side (default &#x60;true&#x60;).  If set to &#x60;true&#x60;, a serializable variable will be deserialized on server side and transformed to JSON using [Jackson&#39;s](https://github.com/FasterXML/jackson) POJO/bean property introspection feature. Note that this requires the Java classes of the variable value to be on the REST API&#39;s classpath.  If set to &#x60;false&#x60;, a serializable variable will be returned in its serialized format. For example, a variable that is serialized as XML will be returned as a JSON string containing XML.  **Note:** While &#x60;true&#x60; is the default value for reasons of backward compatibility, we recommend setting this parameter to &#x60;false&#x60; when developing web applications that are independent of the Java process applications deployed to the engine. (optional, default to true)
   * @return ApiResponse&lt;Map&lt;String, VariableValueDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Map<String, VariableValueDto>> getTaskLocalVariablesWithHttpInfo(String id, Boolean deserializeValues) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getTaskLocalVariables");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/localVariables"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

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

    return apiClient.invokeAPI("TaskLocalVariableApi.getTaskLocalVariables", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * 
   * Updates or deletes the variables in the context of a task. Updates precede deletions. So, if a variable is updated AND deleted, the deletion overrides the update.
   * @param id The id of the task to set variables for. (required)
   * @param patchVariablesDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid. For example the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Update or delete could not be executed because the task is &#x60;null&#x60; or does not exist.. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void modifyTaskLocalVariables(String id, PatchVariablesDto patchVariablesDto) throws ApiException {
    modifyTaskLocalVariablesWithHttpInfo(id, patchVariablesDto);
  }

  /**
   * 
   * Updates or deletes the variables in the context of a task. Updates precede deletions. So, if a variable is updated AND deleted, the deletion overrides the update.
   * @param id The id of the task to set variables for. (required)
   * @param patchVariablesDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid. For example the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Update or delete could not be executed because the task is &#x60;null&#x60; or does not exist.. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> modifyTaskLocalVariablesWithHttpInfo(String id, PatchVariablesDto patchVariablesDto) throws ApiException {
    Object localVarPostBody = patchVariablesDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling modifyTaskLocalVariables");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/localVariables"
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

    return apiClient.invokeAPI("TaskLocalVariableApi.modifyTaskLocalVariables", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Sets a variable in the context of a given task.
   * @param id The id of the task to set the variable for. (required)
   * @param varName The name of the variable to set. (required)
   * @param variableValueDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable name, value or type is invalid, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported or a new transient variable has the name that is already persisted. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The variable name is &#x60;null&#x60;, or the Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void putTaskLocalVariable(String id, String varName, VariableValueDto variableValueDto) throws ApiException {
    putTaskLocalVariableWithHttpInfo(id, varName, variableValueDto);
  }

  /**
   * 
   * Sets a variable in the context of a given task.
   * @param id The id of the task to set the variable for. (required)
   * @param varName The name of the variable to set. (required)
   * @param variableValueDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable name, value or type is invalid, for example if the value could not be parsed to an &#x60;Integer&#x60; value or the passed variable type is not supported or a new transient variable has the name that is already persisted. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The variable name is &#x60;null&#x60;, or the Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> putTaskLocalVariableWithHttpInfo(String id, String varName, VariableValueDto variableValueDto) throws ApiException {
    Object localVarPostBody = variableValueDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling putTaskLocalVariable");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling putTaskLocalVariable");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/localVariables/{varName}"
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

    return apiClient.invokeAPI("TaskLocalVariableApi.putTaskLocalVariable", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * 
   * Sets the serialized value for a binary variable or the binary value for a file variable.
   * @param id The id of the task to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @param data The binary data to be set. For File variables, this multipart can contain the filename, binary value and MIME type of the file variable to be set Only the filename is mandatory. (optional)
   * @param valueType The name of the variable type. Either Bytes for a byte array variable or File for a file variable. (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid, for example if no filename is set. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Variable name is &#x60;null&#x60;, or the Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void setBinaryTaskLocalVariable(String id, String varName, File data, String valueType) throws ApiException {
    setBinaryTaskLocalVariableWithHttpInfo(id, varName, data, valueType);
  }

  /**
   * 
   * Sets the serialized value for a binary variable or the binary value for a file variable.
   * @param id The id of the task to retrieve the variable for. (required)
   * @param varName The name of the variable to retrieve. (required)
   * @param data The binary data to be set. For File variables, this multipart can contain the filename, binary value and MIME type of the file variable to be set Only the filename is mandatory. (optional)
   * @param valueType The name of the variable type. Either Bytes for a byte array variable or File for a file variable. (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The variable value or type is invalid, for example if no filename is set. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> Variable name is &#x60;null&#x60;, or the Task id is &#x60;null&#x60; or does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> setBinaryTaskLocalVariableWithHttpInfo(String id, String varName, File data, String valueType) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling setBinaryTaskLocalVariable");
    }
    
    // verify the required parameter 'varName' is set
    if (varName == null) {
      throw new ApiException(400, "Missing the required parameter 'varName' when calling setBinaryTaskLocalVariable");
    }
    
    // create path and map variables
    String localVarPath = "/task/{id}/localVariables/{varName}/data"
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

    return apiClient.invokeAPI("TaskLocalVariableApi.setBinaryTaskLocalVariable", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
}
