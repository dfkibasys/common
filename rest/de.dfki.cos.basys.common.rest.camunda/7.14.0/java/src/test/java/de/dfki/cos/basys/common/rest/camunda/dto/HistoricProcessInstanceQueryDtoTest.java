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


package de.dfki.cos.basys.common.rest.camunda.dto;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.dfki.cos.basys.common.rest.camunda.dto.HistoricProcessInstanceQueryDtoSorting;
import de.dfki.cos.basys.common.rest.camunda.dto.VariableQueryParameterDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


/**
 * Model tests for HistoricProcessInstanceQueryDto
 */
public class HistoricProcessInstanceQueryDtoTest {
    private final HistoricProcessInstanceQueryDto model = new HistoricProcessInstanceQueryDto();

    /**
     * Model tests for HistoricProcessInstanceQueryDto
     */
    @Test
    public void testHistoricProcessInstanceQueryDto() {
        // TODO: test HistoricProcessInstanceQueryDto
    }

    /**
     * Test the property 'processInstanceId'
     */
    @Test
    public void processInstanceIdTest() {
        // TODO: test processInstanceId
    }

    /**
     * Test the property 'processInstanceIds'
     */
    @Test
    public void processInstanceIdsTest() {
        // TODO: test processInstanceIds
    }

    /**
     * Test the property 'processDefinitionId'
     */
    @Test
    public void processDefinitionIdTest() {
        // TODO: test processDefinitionId
    }

    /**
     * Test the property 'processDefinitionKey'
     */
    @Test
    public void processDefinitionKeyTest() {
        // TODO: test processDefinitionKey
    }

    /**
     * Test the property 'processDefinitionKeyIn'
     */
    @Test
    public void processDefinitionKeyInTest() {
        // TODO: test processDefinitionKeyIn
    }

    /**
     * Test the property 'processDefinitionName'
     */
    @Test
    public void processDefinitionNameTest() {
        // TODO: test processDefinitionName
    }

    /**
     * Test the property 'processDefinitionNameLike'
     */
    @Test
    public void processDefinitionNameLikeTest() {
        // TODO: test processDefinitionNameLike
    }

    /**
     * Test the property 'processDefinitionKeyNotIn'
     */
    @Test
    public void processDefinitionKeyNotInTest() {
        // TODO: test processDefinitionKeyNotIn
    }

    /**
     * Test the property 'processInstanceBusinessKey'
     */
    @Test
    public void processInstanceBusinessKeyTest() {
        // TODO: test processInstanceBusinessKey
    }

    /**
     * Test the property 'processInstanceBusinessKeyLike'
     */
    @Test
    public void processInstanceBusinessKeyLikeTest() {
        // TODO: test processInstanceBusinessKeyLike
    }

    /**
     * Test the property 'rootProcessInstances'
     */
    @Test
    public void rootProcessInstancesTest() {
        // TODO: test rootProcessInstances
    }

    /**
     * Test the property 'finished'
     */
    @Test
    public void finishedTest() {
        // TODO: test finished
    }

    /**
     * Test the property 'unfinished'
     */
    @Test
    public void unfinishedTest() {
        // TODO: test unfinished
    }

    /**
     * Test the property 'withIncidents'
     */
    @Test
    public void withIncidentsTest() {
        // TODO: test withIncidents
    }

    /**
     * Test the property 'withRootIncidents'
     */
    @Test
    public void withRootIncidentsTest() {
        // TODO: test withRootIncidents
    }

    /**
     * Test the property 'incidentType'
     */
    @Test
    public void incidentTypeTest() {
        // TODO: test incidentType
    }

    /**
     * Test the property 'incidentStatus'
     */
    @Test
    public void incidentStatusTest() {
        // TODO: test incidentStatus
    }

    /**
     * Test the property 'incidentMessage'
     */
    @Test
    public void incidentMessageTest() {
        // TODO: test incidentMessage
    }

    /**
     * Test the property 'incidentMessageLike'
     */
    @Test
    public void incidentMessageLikeTest() {
        // TODO: test incidentMessageLike
    }

    /**
     * Test the property 'startedBefore'
     */
    @Test
    public void startedBeforeTest() {
        // TODO: test startedBefore
    }

    /**
     * Test the property 'startedAfter'
     */
    @Test
    public void startedAfterTest() {
        // TODO: test startedAfter
    }

    /**
     * Test the property 'finishedBefore'
     */
    @Test
    public void finishedBeforeTest() {
        // TODO: test finishedBefore
    }

    /**
     * Test the property 'finishedAfter'
     */
    @Test
    public void finishedAfterTest() {
        // TODO: test finishedAfter
    }

    /**
     * Test the property 'executedActivityAfter'
     */
    @Test
    public void executedActivityAfterTest() {
        // TODO: test executedActivityAfter
    }

    /**
     * Test the property 'executedActivityBefore'
     */
    @Test
    public void executedActivityBeforeTest() {
        // TODO: test executedActivityBefore
    }

    /**
     * Test the property 'executedJobAfter'
     */
    @Test
    public void executedJobAfterTest() {
        // TODO: test executedJobAfter
    }

    /**
     * Test the property 'executedJobBefore'
     */
    @Test
    public void executedJobBeforeTest() {
        // TODO: test executedJobBefore
    }

    /**
     * Test the property 'startedBy'
     */
    @Test
    public void startedByTest() {
        // TODO: test startedBy
    }

    /**
     * Test the property 'superProcessInstanceId'
     */
    @Test
    public void superProcessInstanceIdTest() {
        // TODO: test superProcessInstanceId
    }

    /**
     * Test the property 'subProcessInstanceId'
     */
    @Test
    public void subProcessInstanceIdTest() {
        // TODO: test subProcessInstanceId
    }

    /**
     * Test the property 'superCaseInstanceId'
     */
    @Test
    public void superCaseInstanceIdTest() {
        // TODO: test superCaseInstanceId
    }

    /**
     * Test the property 'subCaseInstanceId'
     */
    @Test
    public void subCaseInstanceIdTest() {
        // TODO: test subCaseInstanceId
    }

    /**
     * Test the property 'caseInstanceId'
     */
    @Test
    public void caseInstanceIdTest() {
        // TODO: test caseInstanceId
    }

    /**
     * Test the property 'tenantIdIn'
     */
    @Test
    public void tenantIdInTest() {
        // TODO: test tenantIdIn
    }

    /**
     * Test the property 'withoutTenantId'
     */
    @Test
    public void withoutTenantIdTest() {
        // TODO: test withoutTenantId
    }

    /**
     * Test the property 'executedActivityIdIn'
     */
    @Test
    public void executedActivityIdInTest() {
        // TODO: test executedActivityIdIn
    }

    /**
     * Test the property 'activeActivityIdIn'
     */
    @Test
    public void activeActivityIdInTest() {
        // TODO: test activeActivityIdIn
    }

    /**
     * Test the property 'active'
     */
    @Test
    public void activeTest() {
        // TODO: test active
    }

    /**
     * Test the property 'suspended'
     */
    @Test
    public void suspendedTest() {
        // TODO: test suspended
    }

    /**
     * Test the property 'completed'
     */
    @Test
    public void completedTest() {
        // TODO: test completed
    }

    /**
     * Test the property 'externallyTerminated'
     */
    @Test
    public void externallyTerminatedTest() {
        // TODO: test externallyTerminated
    }

    /**
     * Test the property 'internallyTerminated'
     */
    @Test
    public void internallyTerminatedTest() {
        // TODO: test internallyTerminated
    }

    /**
     * Test the property 'variables'
     */
    @Test
    public void variablesTest() {
        // TODO: test variables
    }

    /**
     * Test the property 'variableNamesIgnoreCase'
     */
    @Test
    public void variableNamesIgnoreCaseTest() {
        // TODO: test variableNamesIgnoreCase
    }

    /**
     * Test the property 'variableValuesIgnoreCase'
     */
    @Test
    public void variableValuesIgnoreCaseTest() {
        // TODO: test variableValuesIgnoreCase
    }

    /**
     * Test the property 'orQueries'
     */
    @Test
    public void orQueriesTest() {
        // TODO: test orQueries
    }

    /**
     * Test the property 'sorting'
     */
    @Test
    public void sortingTest() {
        // TODO: test sorting
    }

}
