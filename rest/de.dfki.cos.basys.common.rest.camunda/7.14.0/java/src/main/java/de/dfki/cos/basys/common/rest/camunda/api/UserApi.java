package de.dfki.cos.basys.common.rest.camunda.api;

import de.dfki.cos.basys.common.rest.camunda.ApiException;
import de.dfki.cos.basys.common.rest.camunda.ApiClient;
import de.dfki.cos.basys.common.rest.camunda.ApiResponse;
import de.dfki.cos.basys.common.rest.camunda.Configuration;
import de.dfki.cos.basys.common.rest.camunda.Pair;

import javax.ws.rs.core.GenericType;

import de.dfki.cos.basys.common.rest.camunda.dto.CountResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ResourceOptionsDto;
import de.dfki.cos.basys.common.rest.camunda.dto.UserCredentialsDto;
import de.dfki.cos.basys.common.rest.camunda.dto.UserDto;
import de.dfki.cos.basys.common.rest.camunda.dto.UserProfileDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-11T21:54:35.456Z[GMT]")
public class UserApi {
  private ApiClient apiClient;

  public UserApi() {
    this(Configuration.getDefaultApiClient());
  }

  public UserApi(ApiClient apiClient) {
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
   * Options
   * The &#x60;/user&#x60; resource supports two custom &#x60;OPTIONS&#x60; requests, one for the resource as such and one for individual user instances. The &#x60;OPTIONS&#x60; request allows checking for the set of available operations that the currently authenticated user can perform on the /user resource. If the user can perform an operation or not may depend on various things, including the user&#39;s authorizations to interact with this resource and the internal configuration of the process engine.
   * @return ResourceOptionsDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public ResourceOptionsDto availableOperations() throws ApiException {
    return availableOperationsWithHttpInfo().getData();
  }

  /**
   * Options
   * The &#x60;/user&#x60; resource supports two custom &#x60;OPTIONS&#x60; requests, one for the resource as such and one for individual user instances. The &#x60;OPTIONS&#x60; request allows checking for the set of available operations that the currently authenticated user can perform on the /user resource. If the user can perform an operation or not may depend on various things, including the user&#39;s authorizations to interact with this resource and the internal configuration of the process engine.
   * @return ApiResponse&lt;ResourceOptionsDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResourceOptionsDto> availableOperationsWithHttpInfo() throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/user";

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

    GenericType<ResourceOptionsDto> localVarReturnType = new GenericType<ResourceOptionsDto>() {};

    return apiClient.invokeAPI("UserApi.availableOperations", localVarPath, "OPTIONS", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Options
   * The &#x60;/user&#x60; resource supports two custom &#x60;OPTIONS&#x60; requests, one for the resource as such and one for individual user instances. The &#x60;OPTIONS&#x60; request allows checking for the set of available operations that the currently authenticated user can perform on the /user resource. If the user can perform an operation or not may depend on various things, including the user&#39;s authorizations to interact with this resource and the internal configuration of the process engine.
   * @param id The id of the user to be deleted. (required)
   * @return ResourceOptionsDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public ResourceOptionsDto availableUserOperations(String id) throws ApiException {
    return availableUserOperationsWithHttpInfo(id).getData();
  }

  /**
   * Options
   * The &#x60;/user&#x60; resource supports two custom &#x60;OPTIONS&#x60; requests, one for the resource as such and one for individual user instances. The &#x60;OPTIONS&#x60; request allows checking for the set of available operations that the currently authenticated user can perform on the /user resource. If the user can perform an operation or not may depend on various things, including the user&#39;s authorizations to interact with this resource and the internal configuration of the process engine.
   * @param id The id of the user to be deleted. (required)
   * @return ApiResponse&lt;ResourceOptionsDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<ResourceOptionsDto> availableUserOperationsWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling availableUserOperations");
    }
    
    // create path and map variables
    String localVarPath = "/user/{id}"
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

    GenericType<ResourceOptionsDto> localVarReturnType = new GenericType<ResourceOptionsDto>() {};

    return apiClient.invokeAPI("UserApi.availableUserOperations", localVarPath, "OPTIONS", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Create
   * Create a new user.
   * @param userDto  (optional)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public void createUser(UserDto userDto) throws ApiException {
    createUserWithHttpInfo(userDto);
  }

  /**
   * Create
   * Create a new user.
   * @param userDto  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> createUserWithHttpInfo(UserDto userDto) throws ApiException {
    Object localVarPostBody = userDto;
    
    // create path and map variables
    String localVarPath = "/user/create";

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

    return apiClient.invokeAPI("UserApi.createUser", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Delete
   * Deletes a user by id.
   * @param id The id of the user to be deleted. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Identity service is read-only (Cannot modify users / groups / memberships). </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> A Deployment with the provided id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void deleteUser(String id) throws ApiException {
    deleteUserWithHttpInfo(id);
  }

  /**
   * Delete
   * Deletes a user by id.
   * @param id The id of the user to be deleted. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Identity service is read-only (Cannot modify users / groups / memberships). </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> A Deployment with the provided id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> deleteUserWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling deleteUser");
    }
    
    // create path and map variables
    String localVarPath = "/user/{id}"
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

    return apiClient.invokeAPI("UserApi.deleteUser", localVarPath, "DELETE", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Get List Count
   * Queries for the number of deployments that fulfill given parameters. Takes the same parameters as the [Get Users](https://docs.camunda.org/manual/7.14/reference/rest/user/get-query/) method.
   * @param id Filter by user id (optional)
   * @param idIn Filter by a comma-separated list of user ids. (optional)
   * @param firstName Filter by the first name of the user. Exact match. (optional)
   * @param firstNameLike Filter by the first name that the parameter is a substring of. (optional)
   * @param lastName Filter by the last name of the user. Exact match. (optional)
   * @param lastNameLike Filter by the last name that the parameter is a substring of. (optional)
   * @param email Filter by the email of the user. Exact match. (optional)
   * @param emailLike Filter by the email that the parameter is a substring of. (optional)
   * @param memberOfGroup Filter for users which are members of the given group. (optional)
   * @param memberOfTenant Filter for users which are members of the given tenant. (optional)
   * @param potentialStarter Only select Users that are potential starter for the given process definition. (optional)
   * @return CountResultDto
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example, if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public CountResultDto getUserCount(String id, String idIn, String firstName, String firstNameLike, String lastName, String lastNameLike, String email, String emailLike, String memberOfGroup, String memberOfTenant, String potentialStarter) throws ApiException {
    return getUserCountWithHttpInfo(id, idIn, firstName, firstNameLike, lastName, lastNameLike, email, emailLike, memberOfGroup, memberOfTenant, potentialStarter).getData();
  }

  /**
   * Get List Count
   * Queries for the number of deployments that fulfill given parameters. Takes the same parameters as the [Get Users](https://docs.camunda.org/manual/7.14/reference/rest/user/get-query/) method.
   * @param id Filter by user id (optional)
   * @param idIn Filter by a comma-separated list of user ids. (optional)
   * @param firstName Filter by the first name of the user. Exact match. (optional)
   * @param firstNameLike Filter by the first name that the parameter is a substring of. (optional)
   * @param lastName Filter by the last name of the user. Exact match. (optional)
   * @param lastNameLike Filter by the last name that the parameter is a substring of. (optional)
   * @param email Filter by the email of the user. Exact match. (optional)
   * @param emailLike Filter by the email that the parameter is a substring of. (optional)
   * @param memberOfGroup Filter for users which are members of the given group. (optional)
   * @param memberOfTenant Filter for users which are members of the given tenant. (optional)
   * @param potentialStarter Only select Users that are potential starter for the given process definition. (optional)
   * @return ApiResponse&lt;CountResultDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example, if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<CountResultDto> getUserCountWithHttpInfo(String id, String idIn, String firstName, String firstNameLike, String lastName, String lastNameLike, String email, String emailLike, String memberOfGroup, String memberOfTenant, String potentialStarter) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/user/count";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "idIn", idIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstName", firstName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstNameLike", firstNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lastName", lastName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lastNameLike", lastNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "email", email));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "emailLike", emailLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "memberOfGroup", memberOfGroup));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "memberOfTenant", memberOfTenant));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "potentialStarter", potentialStarter));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<CountResultDto> localVarReturnType = new GenericType<CountResultDto>() {};

    return apiClient.invokeAPI("UserApi.getUserCount", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get Profile
   * Retrieves a user&#39;s profile.
   * @param id The id of the user to retrieve. (required)
   * @return List&lt;UserProfileDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Execution with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<UserProfileDto> getUserProfile(String id) throws ApiException {
    return getUserProfileWithHttpInfo(id).getData();
  }

  /**
   * Get Profile
   * Retrieves a user&#39;s profile.
   * @param id The id of the user to retrieve. (required)
   * @return ApiResponse&lt;List&lt;UserProfileDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> Execution with given id does not exist. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserProfileDto>> getUserProfileWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling getUserProfile");
    }
    
    // create path and map variables
    String localVarPath = "/user/{id}/profile"
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

    GenericType<List<UserProfileDto>> localVarReturnType = new GenericType<List<UserProfileDto>>() {};

    return apiClient.invokeAPI("UserApi.getUserProfile", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Get List
   * Query for a list of users using a list of parameters. The size of the result set can be retrieved by using the Get User Count method. [Get User Count](https://docs.camunda.org/manual/7.14/reference/rest/user/get-query-count/) method.
   * @param id Filter by user id (optional)
   * @param idIn Filter by a comma-separated list of user ids. (optional)
   * @param firstName Filter by the first name of the user. Exact match. (optional)
   * @param firstNameLike Filter by the first name that the parameter is a substring of. (optional)
   * @param lastName Filter by the last name of the user. Exact match. (optional)
   * @param lastNameLike Filter by the last name that the parameter is a substring of. (optional)
   * @param email Filter by the email of the user. Exact match. (optional)
   * @param emailLike Filter by the email that the parameter is a substring of. (optional)
   * @param memberOfGroup Filter for users which are members of the given group. (optional)
   * @param memberOfTenant Filter for users which are members of the given tenant. (optional)
   * @param potentialStarter Only select Users that are potential starter for the given process definition. (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return List&lt;UserProfileDto&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;, or if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public List<UserProfileDto> getUsers(String id, String idIn, String firstName, String firstNameLike, String lastName, String lastNameLike, String email, String emailLike, String memberOfGroup, String memberOfTenant, String potentialStarter, String sortBy, String sortOrder, Integer firstResult, Integer maxResults) throws ApiException {
    return getUsersWithHttpInfo(id, idIn, firstName, firstNameLike, lastName, lastNameLike, email, emailLike, memberOfGroup, memberOfTenant, potentialStarter, sortBy, sortOrder, firstResult, maxResults).getData();
  }

  /**
   * Get List
   * Query for a list of users using a list of parameters. The size of the result set can be retrieved by using the Get User Count method. [Get User Count](https://docs.camunda.org/manual/7.14/reference/rest/user/get-query-count/) method.
   * @param id Filter by user id (optional)
   * @param idIn Filter by a comma-separated list of user ids. (optional)
   * @param firstName Filter by the first name of the user. Exact match. (optional)
   * @param firstNameLike Filter by the first name that the parameter is a substring of. (optional)
   * @param lastName Filter by the last name of the user. Exact match. (optional)
   * @param lastNameLike Filter by the last name that the parameter is a substring of. (optional)
   * @param email Filter by the email of the user. Exact match. (optional)
   * @param emailLike Filter by the email that the parameter is a substring of. (optional)
   * @param memberOfGroup Filter for users which are members of the given group. (optional)
   * @param memberOfTenant Filter for users which are members of the given tenant. (optional)
   * @param potentialStarter Only select Users that are potential starter for the given process definition. (optional)
   * @param sortBy Sort the results lexicographically by a given criterion. Must be used in conjunction with the sortOrder parameter. (optional)
   * @param sortOrder Sort the results in a given order. Values may be asc for ascending order or desc for descending order. Must be used in conjunction with the sortBy parameter. (optional)
   * @param firstResult Pagination of results. Specifies the index of the first result to return. (optional)
   * @param maxResults Pagination of results. Specifies the maximum number of results to return. Will return less results if there are no more results left. (optional)
   * @return ApiResponse&lt;List&lt;UserProfileDto&gt;&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> Returned if some of the query parameters are invalid, for example if a &#x60;sortOrder&#x60; parameter is supplied, but no &#x60;sortBy&#x60;, or if an invalid operator for variable comparison is used. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<List<UserProfileDto>> getUsersWithHttpInfo(String id, String idIn, String firstName, String firstNameLike, String lastName, String lastNameLike, String email, String emailLike, String memberOfGroup, String memberOfTenant, String potentialStarter, String sortBy, String sortOrder, Integer firstResult, Integer maxResults) throws ApiException {
    Object localVarPostBody = null;
    
    // create path and map variables
    String localVarPath = "/user";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "id", id));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "idIn", idIn));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstName", firstName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "firstNameLike", firstNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lastName", lastName));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "lastNameLike", lastNameLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "email", email));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "emailLike", emailLike));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "memberOfGroup", memberOfGroup));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "memberOfTenant", memberOfTenant));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "potentialStarter", potentialStarter));
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

    GenericType<List<UserProfileDto>> localVarReturnType = new GenericType<List<UserProfileDto>>() {};

    return apiClient.invokeAPI("UserApi.getUsers", localVarPath, "GET", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
  /**
   * Unlock User
   * Unlocks a user by id.
   * @param id The id of the user to be unlocked. (required)
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The user who performed the operation is not a Camunda admin user. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> User cannot be found. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public void unlockUser(String id) throws ApiException {
    unlockUserWithHttpInfo(id);
  }

  /**
   * Unlock User
   * Unlocks a user by id.
   * @param id The id of the user to be unlocked. (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 204 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> The user who performed the operation is not a Camunda admin user. </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> User cannot be found. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Void> unlockUserWithHttpInfo(String id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling unlockUser");
    }
    
    // create path and map variables
    String localVarPath = "/user/{id}/unlock"
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

    return apiClient.invokeAPI("UserApi.unlockUser", localVarPath, "POST", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, null, false);
  }
  /**
   * Update Credentials
   * Updates a user&#39;s credentials (password)
   * @param id The id of the user to be updated. (required)
   * @param password The users new password. (required)
   * @param authenticatedUserPassword The password of the authenticated user who changes the password of the user (i.e., the user with passed id as path parameter). (required)
   * @param userCredentialsDto  (optional)
   * @return Object
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Identity service is read-only (Cannot modify users / groups / memberships). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The authenticated user password does not match </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> If the corresponding user cannot be found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The user could not be updated due to an internal server error. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public Object updateCredentials(String id, String password, String authenticatedUserPassword, UserCredentialsDto userCredentialsDto) throws ApiException {
    return updateCredentialsWithHttpInfo(id, password, authenticatedUserPassword, userCredentialsDto).getData();
  }

  /**
   * Update Credentials
   * Updates a user&#39;s credentials (password)
   * @param id The id of the user to be updated. (required)
   * @param password The users new password. (required)
   * @param authenticatedUserPassword The password of the authenticated user who changes the password of the user (i.e., the user with passed id as path parameter). (required)
   * @param userCredentialsDto  (optional)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   * @http.response.details
     <table summary="Response Details" border="1">
       <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
       <tr><td> 200 </td><td> Request successful. </td><td>  -  </td></tr>
       <tr><td> 403 </td><td> Identity service is read-only (Cannot modify users / groups / memberships). </td><td>  -  </td></tr>
       <tr><td> 400 </td><td> The authenticated user password does not match </td><td>  -  </td></tr>
       <tr><td> 404 </td><td> If the corresponding user cannot be found </td><td>  -  </td></tr>
       <tr><td> 500 </td><td> The user could not be updated due to an internal server error. See the [Introduction](https://docs.camunda.org/manual/7.14/reference/rest/overview/#error-handling) for the error response format. </td><td>  -  </td></tr>
     </table>
   */
  public ApiResponse<Object> updateCredentialsWithHttpInfo(String id, String password, String authenticatedUserPassword, UserCredentialsDto userCredentialsDto) throws ApiException {
    Object localVarPostBody = userCredentialsDto;
    
    // verify the required parameter 'id' is set
    if (id == null) {
      throw new ApiException(400, "Missing the required parameter 'id' when calling updateCredentials");
    }
    
    // verify the required parameter 'password' is set
    if (password == null) {
      throw new ApiException(400, "Missing the required parameter 'password' when calling updateCredentials");
    }
    
    // verify the required parameter 'authenticatedUserPassword' is set
    if (authenticatedUserPassword == null) {
      throw new ApiException(400, "Missing the required parameter 'authenticatedUserPassword' when calling updateCredentials");
    }
    
    // create path and map variables
    String localVarPath = "/user/{id}/credentials"
      .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "password", password));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "authenticatedUserPassword", authenticatedUserPassword));

    
    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<Object> localVarReturnType = new GenericType<Object>() {};

    return apiClient.invokeAPI("UserApi.updateCredentials", localVarPath, "PUT", localVarQueryParams, localVarPostBody,
                               localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType,
                               localVarAuthNames, localVarReturnType, false);
  }
}
