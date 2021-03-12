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

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * ExtendLockOnExternalTaskDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-12T00:15:55.778Z[GMT]")
public class ExtendLockOnExternalTaskDto {
  public static final String SERIALIZED_NAME_WORKER_ID = "workerId";
  @SerializedName(SERIALIZED_NAME_WORKER_ID)
  private String workerId;

  public static final String SERIALIZED_NAME_NEW_DURATION = "newDuration";
  @SerializedName(SERIALIZED_NAME_NEW_DURATION)
  private Long newDuration;


  public ExtendLockOnExternalTaskDto workerId(String workerId) {
    
    this.workerId = workerId;
    return this;
  }

   /**
   * The ID of a worker who is locking the external task.
   * @return workerId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The ID of a worker who is locking the external task.")

  public String getWorkerId() {
    return workerId;
  }


  public void setWorkerId(String workerId) {
    this.workerId = workerId;
  }


  public ExtendLockOnExternalTaskDto newDuration(Long newDuration) {
    
    this.newDuration = newDuration;
    return this;
  }

   /**
   * An amount of time (in milliseconds). This is the new lock duration starting from the current moment.
   * @return newDuration
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "An amount of time (in milliseconds). This is the new lock duration starting from the current moment.")

  public Long getNewDuration() {
    return newDuration;
  }


  public void setNewDuration(Long newDuration) {
    this.newDuration = newDuration;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ExtendLockOnExternalTaskDto extendLockOnExternalTaskDto = (ExtendLockOnExternalTaskDto) o;
    return Objects.equals(this.workerId, extendLockOnExternalTaskDto.workerId) &&
        Objects.equals(this.newDuration, extendLockOnExternalTaskDto.newDuration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(workerId, newDuration);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExtendLockOnExternalTaskDto {\n");
    sb.append("    workerId: ").append(toIndentedString(workerId)).append("\n");
    sb.append("    newDuration: ").append(toIndentedString(newDuration)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

