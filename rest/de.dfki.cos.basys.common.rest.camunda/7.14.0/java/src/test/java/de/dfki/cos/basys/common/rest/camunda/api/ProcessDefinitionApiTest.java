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

import de.dfki.cos.basys.common.rest.camunda.ApiException;
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
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProcessDefinitionApi
 */
@Ignore
public class ProcessDefinitionApiTest {

    private final ProcessDefinitionApi api = new ProcessDefinitionApi();

    
    /**
     * Delete
     *
     * Deletes a running process instance by id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteProcessDefinitionTest() throws ApiException {
        String id = null;
        Boolean cascade = null;
        Boolean skipCustomListeners = null;
        Boolean skipIoMappings = null;
        api.deleteProcessDefinition(id, cascade, skipCustomListeners, skipIoMappings);

        // TODO: test validations
    }
    
    /**
     * Delete By Key
     *
     * Deletes process definitions by a given key which belong to no tenant id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteProcessDefinitionsByKeyTest() throws ApiException {
        String key = null;
        Boolean cascade = null;
        Boolean skipCustomListeners = null;
        Boolean skipIoMappings = null;
        api.deleteProcessDefinitionsByKey(key, cascade, skipCustomListeners, skipIoMappings);

        // TODO: test validations
    }
    
    /**
     * Delete By Key
     *
     * Deletes process definitions by a given key and which belong to a tenant id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteProcessDefinitionsByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        Boolean cascade = null;
        Boolean skipCustomListeners = null;
        Boolean skipIoMappings = null;
        api.deleteProcessDefinitionsByKeyAndTenantId(key, tenantId, cascade, skipCustomListeners, skipIoMappings);

        // TODO: test validations
    }
    
    /**
     * Get Activity Instance Statistics
     *
     * Retrieves runtime statistics of a given process definition, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getActivityStatisticsTest() throws ApiException {
        String id = null;
        Boolean failedJobs = null;
        Boolean incidents = null;
        String incidentsForType = null;
        List<ActivityStatisticsResultDto> response = api.getActivityStatistics(id, failedJobs, incidents, incidentsForType);

        // TODO: test validations
    }
    
    /**
     * Get Activity Instance Statistics
     *
     * Retrieves runtime statistics of the latest version of the given process definition which belongs to no tenant, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getActivityStatisticsByProcessDefinitionKeyTest() throws ApiException {
        String key = null;
        Boolean failedJobs = null;
        Boolean incidents = null;
        String incidentsForType = null;
        List<ActivityStatisticsResultDto> response = api.getActivityStatisticsByProcessDefinitionKey(key, failedJobs, incidents, incidentsForType);

        // TODO: test validations
    }
    
    /**
     * Get Activity Instance Statistics
     *
     * Retrieves runtime statistics of the latest version of the given process definition for a tenant, grouped by activities. These statistics include the number of running activity instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getActivityStatisticsByProcessDefinitionKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        Boolean failedJobs = null;
        Boolean incidents = null;
        String incidentsForType = null;
        List<ActivityStatisticsResultDto> response = api.getActivityStatisticsByProcessDefinitionKeyAndTenantId(key, tenantId, failedJobs, incidents, incidentsForType);

        // TODO: test validations
    }
    
    /**
     * Get Deployed Start Form
     *
     * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getDeployedStartFormTest() throws ApiException {
        String id = null;
        File response = api.getDeployedStartForm(id);

        // TODO: test validations
    }
    
    /**
     * Get Deployed Start Form
     *
     * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getDeployedStartFormByKeyTest() throws ApiException {
        String key = null;
        File response = api.getDeployedStartFormByKey(key);

        // TODO: test validations
    }
    
    /**
     * Get Deployed Start Form
     *
     * Retrieves the deployed form that can be referenced from a start event. For further information please refer to [User Guide](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#embedded-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getDeployedStartFormByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        File response = api.getDeployedStartFormByKeyAndTenantId(key, tenantId);

        // TODO: test validations
    }
    
    /**
     * Get
     *
     * Retrieves the latest version of the process definition for tenant according to the &#x60;ProcessDefinition&#x60; interface in the engine.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getLatestProcessDefinitionByTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        ProcessDefinitionDto response = api.getLatestProcessDefinitionByTenantId(key, tenantId);

        // TODO: test validations
    }
    
    /**
     * Get
     *
     * Retrieves a process definition according to the &#x60;ProcessDefinition&#x60; interface in the engine.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionTest() throws ApiException {
        String id = null;
        ProcessDefinitionDto response = api.getProcessDefinition(id);

        // TODO: test validations
    }
    
    /**
     * Get XML
     *
     * Retrieves the BPMN 2.0 XML of a process definition.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionBpmn20XmlTest() throws ApiException {
        String id = null;
        ProcessDefinitionDiagramDto response = api.getProcessDefinitionBpmn20Xml(id);

        // TODO: test validations
    }
    
    /**
     * Get XML
     *
     * Retrieves latest version the BPMN 2.0 XML of a process definition.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionBpmn20XmlByKeyTest() throws ApiException {
        String key = null;
        ProcessDefinitionDiagramDto response = api.getProcessDefinitionBpmn20XmlByKey(key);

        // TODO: test validations
    }
    
    /**
     * Get XML
     *
     * Retrieves latest version the BPMN 2.0 XML of a process definition. Returns the XML for the latest version of the process definition for tenant.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionBpmn20XmlByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        ProcessDefinitionDiagramDto response = api.getProcessDefinitionBpmn20XmlByKeyAndTenantId(key, tenantId);

        // TODO: test validations
    }
    
    /**
     * Get
     *
     * Retrieves the latest version of the process definition which belongs to no tenant according to the &#x60;ProcessDefinition&#x60; interface in the engine.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionByKeyTest() throws ApiException {
        String key = null;
        ProcessDefinitionDto response = api.getProcessDefinitionByKey(key);

        // TODO: test validations
    }
    
    /**
     * Get Diagram
     *
     * Retrieves the diagram of a process definition.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionDiagramTest() throws ApiException {
        String id = null;
        File response = api.getProcessDefinitionDiagram(id);

        // TODO: test validations
    }
    
    /**
     * Get Diagram
     *
     * Retrieves the diagram for the latest version of the process definition which belongs to no tenant.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionDiagramByKeyTest() throws ApiException {
        String key = null;
        File response = api.getProcessDefinitionDiagramByKey(key);

        // TODO: test validations
    }
    
    /**
     * Get Diagram
     *
     * Retrieves the diagram for the latest version of the process definition for tenant.  If the process definition&#39;s deployment contains an image resource with the same file name as the process definition, the deployed image will be returned by the Get Diagram endpoint. Example: &#x60;someProcess.bpmn&#x60; and &#x60;someProcess.png&#x60;. Supported file extentions for the image are: &#x60;svg&#x60;, &#x60;png&#x60;, &#x60;jpg&#x60;, and &#x60;gif&#x60;.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionDiagramByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        File response = api.getProcessDefinitionDiagramByKeyAndTenantId(key, tenantId);

        // TODO: test validations
    }
    
    /**
     * Get Process Instance Statistics
     *
     * Retrieves runtime statistics of the process engine, grouped by process definitions. These statistics include the number of running process instances, optionally the number of failed jobs and also optionally the number of incidents either grouped by incident types or for a specific incident type. **Note**: This does not include historic data.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionStatisticsTest() throws ApiException {
        Boolean failedJobs = null;
        Boolean incidents = null;
        String incidentsForType = null;
        Boolean rootIncidents = null;
        List<ProcessDefinitionStatisticsResultDto> response = api.getProcessDefinitionStatistics(failedJobs, incidents, incidentsForType, rootIncidents);

        // TODO: test validations
    }
    
    /**
     * Get List
     *
     * Queries for process definitions that fulfill given parameters. Parameters may be the properties of  process definitions, such as the name, key or version. The size of the result set can be retrieved by using the [Get Definition Count](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/get-query-count/) method.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionsTest() throws ApiException {
        String processDefinitionId = null;
        String processDefinitionIdIn = null;
        String name = null;
        String nameLike = null;
        String deploymentId = null;
        OffsetDateTime deployedAfter = null;
        OffsetDateTime deployedAt = null;
        String key = null;
        String keysIn = null;
        String keyLike = null;
        String category = null;
        String categoryLike = null;
        Integer version = null;
        Boolean latestVersion = null;
        String resourceName = null;
        String resourceNameLike = null;
        String startableBy = null;
        Boolean active = null;
        Boolean suspended = null;
        String incidentId = null;
        String incidentType = null;
        String incidentMessage = null;
        String incidentMessageLike = null;
        String tenantIdIn = null;
        Boolean withoutTenantId = null;
        Boolean includeProcessDefinitionsWithoutTenantId = null;
        String versionTag = null;
        String versionTagLike = null;
        Boolean withoutVersionTag = null;
        Boolean startableInTasklist = null;
        Boolean notStartableInTasklist = null;
        Boolean startablePermissionCheck = null;
        String sortBy = null;
        String sortOrder = null;
        Integer firstResult = null;
        Integer maxResults = null;
        List<ProcessDefinitionDto> response = api.getProcessDefinitions(processDefinitionId, processDefinitionIdIn, name, nameLike, deploymentId, deployedAfter, deployedAt, key, keysIn, keyLike, category, categoryLike, version, latestVersion, resourceName, resourceNameLike, startableBy, active, suspended, incidentId, incidentType, incidentMessage, incidentMessageLike, tenantIdIn, withoutTenantId, includeProcessDefinitionsWithoutTenantId, versionTag, versionTagLike, withoutVersionTag, startableInTasklist, notStartableInTasklist, startablePermissionCheck, sortBy, sortOrder, firstResult, maxResults);

        // TODO: test validations
    }
    
    /**
     * Get List Count
     *
     * Requests the number of process definitions that fulfill the query criteria. Takes the same filtering parameters as the [Get Definitions](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/get-query/) method.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getProcessDefinitionsCountTest() throws ApiException {
        String processDefinitionId = null;
        String processDefinitionIdIn = null;
        String name = null;
        String nameLike = null;
        String deploymentId = null;
        OffsetDateTime deployedAfter = null;
        OffsetDateTime deployedAt = null;
        String key = null;
        String keysIn = null;
        String keyLike = null;
        String category = null;
        String categoryLike = null;
        Integer version = null;
        Boolean latestVersion = null;
        String resourceName = null;
        String resourceNameLike = null;
        String startableBy = null;
        Boolean active = null;
        Boolean suspended = null;
        String incidentId = null;
        String incidentType = null;
        String incidentMessage = null;
        String incidentMessageLike = null;
        String tenantIdIn = null;
        Boolean withoutTenantId = null;
        Boolean includeProcessDefinitionsWithoutTenantId = null;
        String versionTag = null;
        String versionTagLike = null;
        Boolean withoutVersionTag = null;
        Boolean startableInTasklist = null;
        Boolean notStartableInTasklist = null;
        Boolean startablePermissionCheck = null;
        CountResultDto response = api.getProcessDefinitionsCount(processDefinitionId, processDefinitionIdIn, name, nameLike, deploymentId, deployedAfter, deployedAt, key, keysIn, keyLike, category, categoryLike, version, latestVersion, resourceName, resourceNameLike, startableBy, active, suspended, incidentId, incidentType, incidentMessage, incidentMessageLike, tenantIdIn, withoutTenantId, includeProcessDefinitionsWithoutTenantId, versionTag, versionTagLike, withoutVersionTag, startableInTasklist, notStartableInTasklist, startablePermissionCheck);

        // TODO: test validations
    }
    
    /**
     * Get Rendered Start Form
     *
     * Retrieves the rendered form for a process definition. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getRenderedStartFormTest() throws ApiException {
        String id = null;
        File response = api.getRenderedStartForm(id);

        // TODO: test validations
    }
    
    /**
     * Get Rendered Start Form
     *
     * Retrieves  the rendered form for the latest version of the process definition which belongs to no tenant. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getRenderedStartFormByKeyTest() throws ApiException {
        String key = null;
        File response = api.getRenderedStartFormByKey(key);

        // TODO: test validations
    }
    
    /**
     * Get Rendered Start Form
     *
     * Retrieves  the rendered form for the latest version of the process definition for a tenant. This method can be used to get the HTML rendering of a [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getRenderedStartFormByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        File response = api.getRenderedStartFormByKeyAndTenantId(key, tenantId);

        // TODO: test validations
    }
    
    /**
     * Get Start Form Key
     *
     * Retrieves the key of the start form for a process definition. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStartFormTest() throws ApiException {
        String id = null;
        FormDto response = api.getStartForm(id);

        // TODO: test validations
    }
    
    /**
     * Get Start Form Key
     *
     * Retrieves the key of the start form for the latest version of the process definition which belongs to no tenant. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStartFormByKeyTest() throws ApiException {
        String key = null;
        FormDto response = api.getStartFormByKey(key);

        // TODO: test validations
    }
    
    /**
     * Get Start Form Key
     *
     * Retrieves the key of the start form for the latest version of the process definition for a tenant. The form key corresponds to the &#x60;FormData#formKey&#x60; property in the engine.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStartFormByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        FormDto response = api.getStartFormByKeyAndTenantId(key, tenantId);

        // TODO: test validations
    }
    
    /**
     * Get Start Form Variables
     *
     * Retrieves the start form variables for a process definition (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStartFormVariablesTest() throws ApiException {
        String id = null;
        String variableNames = null;
        Boolean deserializeValues = null;
        Map<String, VariableValueDto> response = api.getStartFormVariables(id, variableNames, deserializeValues);

        // TODO: test validations
    }
    
    /**
     * Get Start Form Variables
     *
     * Retrieves the start form variables for the latest process definition which belongs to no tenant (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStartFormVariablesByKeyTest() throws ApiException {
        String key = null;
        String variableNames = null;
        Boolean deserializeValues = null;
        Map<String, VariableValueDto> response = api.getStartFormVariablesByKey(key, variableNames, deserializeValues);

        // TODO: test validations
    }
    
    /**
     * Get Start Form Variables
     *
     * Retrieves the start form variables for the latest process definition for a tenant (only if they are defined via the  [Generated Task Form](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms) approach). The start form variables take form data specified on the start event into account. If form fields are defined, the variable types and default values of the form fields are taken into account.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getStartFormVariablesByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        String variableNames = null;
        Boolean deserializeValues = null;
        Map<String, VariableValueDto> response = api.getStartFormVariablesByKeyAndTenantId(key, tenantId, variableNames, deserializeValues);

        // TODO: test validations
    }
    
    /**
     * Restart Process Instance
     *
     * Restarts process instances that were canceled or terminated synchronously. Can also restart completed process instances. It will create a new instance using the original instance information. To execute the restart asynchronously, use the [Restart Process Instance Async](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/post-restart-process-instance-async/) method.  For more information about the difference between synchronous and asynchronous execution, please refer to the related section of the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/process-instance-restart/#execution).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartProcessInstanceTest() throws ApiException {
        String id = null;
        RestartProcessInstanceDto restartProcessInstanceDto = null;
        api.restartProcessInstance(id, restartProcessInstanceDto);

        // TODO: test validations
    }
    
    /**
     * Restart Process Instance Async
     *
     * Restarts process instances that were canceled or terminated asynchronously. Can also restart completed process instances. It will create a new instance using the original instance information. To execute the restart asynchronously, use the [Restart Process Instance](https://docs.camunda.org/manual/7.14/reference/rest/process-definition/post-restart-process-instance-sync/) method.  For more information about the difference between synchronous and asynchronous execution, please refer to the related section of the [User Guide](https://docs.camunda.org/manual/7.14/user-guide/process-engine/process-instance-restart/#execution).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void restartProcessInstanceAsyncOperationTest() throws ApiException {
        String id = null;
        RestartProcessInstanceDto restartProcessInstanceDto = null;
        BatchDto response = api.restartProcessInstanceAsyncOperation(id, restartProcessInstanceDto);

        // TODO: test validations
    }
    
    /**
     * Start Instance
     *
     * Instantiates a given process definition. Process variables and business key may be supplied in the request body.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void startProcessInstanceTest() throws ApiException {
        String id = null;
        StartProcessInstanceDto startProcessInstanceDto = null;
        ProcessInstanceWithVariablesDto response = api.startProcessInstance(id, startProcessInstanceDto);

        // TODO: test validations
    }
    
    /**
     * Start Instance
     *
     * Instantiates a given process definition, starts the latest version of the process definition which belongs to no tenant. Process variables and business key may be supplied in the request body.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void startProcessInstanceByKeyTest() throws ApiException {
        String key = null;
        StartProcessInstanceDto startProcessInstanceDto = null;
        ProcessInstanceWithVariablesDto response = api.startProcessInstanceByKey(key, startProcessInstanceDto);

        // TODO: test validations
    }
    
    /**
     * Start Instance
     *
     * Instantiates a given process definition, starts the latest version of the process definition for tenant. Process variables and business key may be supplied in the request body.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void startProcessInstanceByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        StartProcessInstanceDto startProcessInstanceDto = null;
        ProcessInstanceWithVariablesDto response = api.startProcessInstanceByKeyAndTenantId(key, tenantId, startProcessInstanceDto);

        // TODO: test validations
    }
    
    /**
     * Submit Start Form
     *
     * Starts a process instance using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void submitFormTest() throws ApiException {
        String id = null;
        StartProcessInstanceFormDto startProcessInstanceFormDto = null;
        ProcessInstanceDto response = api.submitForm(id, startProcessInstanceFormDto);

        // TODO: test validations
    }
    
    /**
     * Submit Start Form
     *
     * Starts the latest version of the process definition which belongs to no tenant using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void submitFormByKeyTest() throws ApiException {
        String key = null;
        StartProcessInstanceFormDto startProcessInstanceFormDto = null;
        ProcessInstanceDto response = api.submitFormByKey(key, startProcessInstanceFormDto);

        // TODO: test validations
    }
    
    /**
     * Submit Start Form
     *
     * Starts the latest version of the process definition for a tenant using a set of process variables and the business key. If the start event has Form Field Metadata defined, the process engine will perform backend validation for any form fields which have validators defined. See [Documentation on Generated Task Forms](https://docs.camunda.org/manual/7.14/user-guide/task-forms/#generated-task-forms).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void submitFormByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        StartProcessInstanceFormDto startProcessInstanceFormDto = null;
        ProcessInstanceDto response = api.submitFormByKeyAndTenantId(key, tenantId, startProcessInstanceFormDto);

        // TODO: test validations
    }
    
    /**
     * Update History Time to Live
     *
     * Updates history time to live for process definition. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateHistoryTimeToLiveByProcessDefinitionIdTest() throws ApiException {
        String id = null;
        HistoryTimeToLiveDto historyTimeToLiveDto = null;
        api.updateHistoryTimeToLiveByProcessDefinitionId(id, historyTimeToLiveDto);

        // TODO: test validations
    }
    
    /**
     * Update History Time to Live
     *
     * Updates history time to live for the latest version of the process definition which belongs to no tenant. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateHistoryTimeToLiveByProcessDefinitionKeyTest() throws ApiException {
        String key = null;
        HistoryTimeToLiveDto historyTimeToLiveDto = null;
        api.updateHistoryTimeToLiveByProcessDefinitionKey(key, historyTimeToLiveDto);

        // TODO: test validations
    }
    
    /**
     * Update History Time to Live
     *
     * Updates history time to live for the latest version of the process definition for a tenant. The field is used within [History cleanup](https://docs.camunda.org/manual/7.14/user-guide/process-engine/history/#history-cleanup).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateHistoryTimeToLiveByProcessDefinitionKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        HistoryTimeToLiveDto historyTimeToLiveDto = null;
        api.updateHistoryTimeToLiveByProcessDefinitionKeyAndTenantId(key, tenantId, historyTimeToLiveDto);

        // TODO: test validations
    }
    
    /**
     * Activate/Suspend By Key
     *
     * Activates or suspends process definitions with the given process definition key.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateProcessDefinitionSuspensionStateTest() throws ApiException {
        ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto = null;
        api.updateProcessDefinitionSuspensionState(processDefinitionSuspensionStateDto);

        // TODO: test validations
    }
    
    /**
     * Activate/Suspend By Id
     *
     * Activates or suspends a given process definition by id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateProcessDefinitionSuspensionStateByIdTest() throws ApiException {
        String id = null;
        ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto = null;
        api.updateProcessDefinitionSuspensionStateById(id, processDefinitionSuspensionStateDto);

        // TODO: test validations
    }
    
    /**
     * Activate/Suspend by Id
     *
     * Activates or suspends a given process definition by latest version of process definition key which belongs to no tenant.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateProcessDefinitionSuspensionStateByKeyTest() throws ApiException {
        String key = null;
        ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto = null;
        api.updateProcessDefinitionSuspensionStateByKey(key, processDefinitionSuspensionStateDto);

        // TODO: test validations
    }
    
    /**
     * Activate/Suspend by Id
     *
     * Activates or suspends a given process definition by the latest version of the process definition for tenant.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateProcessDefinitionSuspensionStateByKeyAndTenantIdTest() throws ApiException {
        String key = null;
        String tenantId = null;
        ProcessDefinitionSuspensionStateDto processDefinitionSuspensionStateDto = null;
        api.updateProcessDefinitionSuspensionStateByKeyAndTenantId(key, tenantId, processDefinitionSuspensionStateDto);

        // TODO: test validations
    }
    
}
