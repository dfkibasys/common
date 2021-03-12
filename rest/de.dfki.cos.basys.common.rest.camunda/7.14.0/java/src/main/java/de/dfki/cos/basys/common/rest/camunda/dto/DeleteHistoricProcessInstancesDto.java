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
import de.dfki.cos.basys.common.rest.camunda.dto.HistoricProcessInstanceQueryDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DeleteHistoricProcessInstancesDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-12T00:15:55.778Z[GMT]")
public class DeleteHistoricProcessInstancesDto {
  public static final String SERIALIZED_NAME_HISTORIC_PROCESS_INSTANCE_IDS = "historicProcessInstanceIds";
  @SerializedName(SERIALIZED_NAME_HISTORIC_PROCESS_INSTANCE_IDS)
  private List<String> historicProcessInstanceIds = null;

  public static final String SERIALIZED_NAME_HISTORIC_PROCESS_INSTANCE_QUERY = "historicProcessInstanceQuery";
  @SerializedName(SERIALIZED_NAME_HISTORIC_PROCESS_INSTANCE_QUERY)
  private HistoricProcessInstanceQueryDto historicProcessInstanceQuery;

  public static final String SERIALIZED_NAME_DELETE_REASON = "deleteReason";
  @SerializedName(SERIALIZED_NAME_DELETE_REASON)
  private String deleteReason;

  public static final String SERIALIZED_NAME_FAIL_IF_NOT_EXISTS = "failIfNotExists";
  @SerializedName(SERIALIZED_NAME_FAIL_IF_NOT_EXISTS)
  private Boolean failIfNotExists;


  public DeleteHistoricProcessInstancesDto historicProcessInstanceIds(List<String> historicProcessInstanceIds) {
    
    this.historicProcessInstanceIds = historicProcessInstanceIds;
    return this;
  }

  public DeleteHistoricProcessInstancesDto addHistoricProcessInstanceIdsItem(String historicProcessInstanceIdsItem) {
    if (this.historicProcessInstanceIds == null) {
      this.historicProcessInstanceIds = new ArrayList<String>();
    }
    this.historicProcessInstanceIds.add(historicProcessInstanceIdsItem);
    return this;
  }

   /**
   * A list historic process instance ids to delete.
   * @return historicProcessInstanceIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list historic process instance ids to delete.")

  public List<String> getHistoricProcessInstanceIds() {
    return historicProcessInstanceIds;
  }


  public void setHistoricProcessInstanceIds(List<String> historicProcessInstanceIds) {
    this.historicProcessInstanceIds = historicProcessInstanceIds;
  }


  public DeleteHistoricProcessInstancesDto historicProcessInstanceQuery(HistoricProcessInstanceQueryDto historicProcessInstanceQuery) {
    
    this.historicProcessInstanceQuery = historicProcessInstanceQuery;
    return this;
  }

   /**
   * Get historicProcessInstanceQuery
   * @return historicProcessInstanceQuery
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public HistoricProcessInstanceQueryDto getHistoricProcessInstanceQuery() {
    return historicProcessInstanceQuery;
  }


  public void setHistoricProcessInstanceQuery(HistoricProcessInstanceQueryDto historicProcessInstanceQuery) {
    this.historicProcessInstanceQuery = historicProcessInstanceQuery;
  }


  public DeleteHistoricProcessInstancesDto deleteReason(String deleteReason) {
    
    this.deleteReason = deleteReason;
    return this;
  }

   /**
   * A string with delete reason.
   * @return deleteReason
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A string with delete reason.")

  public String getDeleteReason() {
    return deleteReason;
  }


  public void setDeleteReason(String deleteReason) {
    this.deleteReason = deleteReason;
  }


  public DeleteHistoricProcessInstancesDto failIfNotExists(Boolean failIfNotExists) {
    
    this.failIfNotExists = failIfNotExists;
    return this;
  }

   /**
   * If set to &#x60;false&#x60;, the request will still be successful if one ore more of the process ids are not found.
   * @return failIfNotExists
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "If set to `false`, the request will still be successful if one ore more of the process ids are not found.")

  public Boolean getFailIfNotExists() {
    return failIfNotExists;
  }


  public void setFailIfNotExists(Boolean failIfNotExists) {
    this.failIfNotExists = failIfNotExists;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeleteHistoricProcessInstancesDto deleteHistoricProcessInstancesDto = (DeleteHistoricProcessInstancesDto) o;
    return Objects.equals(this.historicProcessInstanceIds, deleteHistoricProcessInstancesDto.historicProcessInstanceIds) &&
        Objects.equals(this.historicProcessInstanceQuery, deleteHistoricProcessInstancesDto.historicProcessInstanceQuery) &&
        Objects.equals(this.deleteReason, deleteHistoricProcessInstancesDto.deleteReason) &&
        Objects.equals(this.failIfNotExists, deleteHistoricProcessInstancesDto.failIfNotExists);
  }

  @Override
  public int hashCode() {
    return Objects.hash(historicProcessInstanceIds, historicProcessInstanceQuery, deleteReason, failIfNotExists);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeleteHistoricProcessInstancesDto {\n");
    sb.append("    historicProcessInstanceIds: ").append(toIndentedString(historicProcessInstanceIds)).append("\n");
    sb.append("    historicProcessInstanceQuery: ").append(toIndentedString(historicProcessInstanceQuery)).append("\n");
    sb.append("    deleteReason: ").append(toIndentedString(deleteReason)).append("\n");
    sb.append("    failIfNotExists: ").append(toIndentedString(failIfNotExists)).append("\n");
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

