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
import de.dfki.cos.basys.common.rest.camunda.dto.CorrelationMessageDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.MessageCorrelationResultWithVariableDto;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MessageApi
 */
@Ignore
public class MessageApiTest {

    private final MessageApi api = new MessageApi();

    
    /**
     * 
     *
     * Correlates a message to the process engine to either trigger a message start event or an intermediate message  catching event. Internally this maps to the engine&#39;s message correlation builder methods &#x60;MessageCorrelationBuilder#correlateWithResult()&#x60; and &#x60;MessageCorrelationBuilder#correlateAllWithResult()&#x60;. For more information about the correlation behavior, see the [Message Events](https://docs.camunda.org/manual/7.14/bpmn20/events/message-events/) section of the [BPMN 2.0 Implementation Reference](https://docs.camunda.org/manual/7.14/reference/bpmn20/).
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deliverMessageTest() throws ApiException {
        CorrelationMessageDto correlationMessageDto = null;
        List<MessageCorrelationResultWithVariableDto> response = api.deliverMessage(correlationMessageDto);

        // TODO: test validations
    }
    
}
