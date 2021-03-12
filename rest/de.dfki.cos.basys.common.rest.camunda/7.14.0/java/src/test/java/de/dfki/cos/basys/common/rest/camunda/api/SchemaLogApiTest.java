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
import de.dfki.cos.basys.common.rest.camunda.dto.SchemaLogEntryDto;
import de.dfki.cos.basys.common.rest.camunda.dto.SchemaLogQueryDto;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SchemaLogApi
 */
@Ignore
public class SchemaLogApiTest {

    private final SchemaLogApi api = new SchemaLogApi();

    
    /**
     * 
     *
     * Queries for schema log entries that fulfill given parameters.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getSchemaLogTest() throws ApiException {
        String version = null;
        Integer firstResult = null;
        Integer maxResults = null;
        List<SchemaLogEntryDto> response = api.getSchemaLog(version, firstResult, maxResults);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Queries for schema log entries that fulfill given parameters.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void querySchemaLogTest() throws ApiException {
        Integer firstResult = null;
        Integer maxResults = null;
        SchemaLogQueryDto schemaLogQueryDto = null;
        List<SchemaLogEntryDto> response = api.querySchemaLog(firstResult, maxResults, schemaLogQueryDto);

        // TODO: test validations
    }
    
}
