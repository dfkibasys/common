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
import de.dfki.cos.basys.common.rest.camunda.dto.AuthorizationExceptionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.CommentDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ExceptionDto;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for TaskCommentApi
 */
@Ignore
public class TaskCommentApiTest {

    private final TaskCommentApi api = new TaskCommentApi();

    
    /**
     * 
     *
     * Creates a comment for a task by id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createCommentTest() throws ApiException {
        String id = null;
        CommentDto commentDto = null;
        CommentDto response = api.createComment(id, commentDto);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Retrieves a task comment by task id and comment id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCommentTest() throws ApiException {
        String id = null;
        String commentId = null;
        CommentDto response = api.getComment(id, commentId);

        // TODO: test validations
    }
    
    /**
     * 
     *
     * Gets the comments for a task by id.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getCommentsTest() throws ApiException {
        String id = null;
        List<CommentDto> response = api.getComments(id);

        // TODO: test validations
    }
    
}
