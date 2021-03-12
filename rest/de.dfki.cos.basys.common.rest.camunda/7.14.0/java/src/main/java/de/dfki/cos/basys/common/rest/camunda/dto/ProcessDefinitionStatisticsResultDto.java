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
import de.dfki.cos.basys.common.rest.camunda.dto.IncidentStatisticsResultDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessDefinitionDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ProcessDefinitionStatisticsResultDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-12T00:15:55.778Z[GMT]")
public class ProcessDefinitionStatisticsResultDto {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_INSTANCES = "instances";
  @SerializedName(SERIALIZED_NAME_INSTANCES)
  private Integer instances;

  public static final String SERIALIZED_NAME_FAILED_JOBS = "failedJobs";
  @SerializedName(SERIALIZED_NAME_FAILED_JOBS)
  private Integer failedJobs;

  public static final String SERIALIZED_NAME_INCIDENTS = "incidents";
  @SerializedName(SERIALIZED_NAME_INCIDENTS)
  private List<IncidentStatisticsResultDto> incidents = null;

  public static final String SERIALIZED_NAME_DEFINITION = "definition";
  @SerializedName(SERIALIZED_NAME_DEFINITION)
  private ProcessDefinitionDto definition;


  public ProcessDefinitionStatisticsResultDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * The id of the process definition the results are aggregated for.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The id of the process definition the results are aggregated for.")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ProcessDefinitionStatisticsResultDto instances(Integer instances) {
    
    this.instances = instances;
    return this;
  }

   /**
   * The total number of running process instances of this process definition.
   * @return instances
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total number of running process instances of this process definition.")

  public Integer getInstances() {
    return instances;
  }


  public void setInstances(Integer instances) {
    this.instances = instances;
  }


  public ProcessDefinitionStatisticsResultDto failedJobs(Integer failedJobs) {
    
    this.failedJobs = failedJobs;
    return this;
  }

   /**
   * The total number of failed jobs for the running instances. **Note**: Will be &#x60;0&#x60; (not &#x60;null&#x60;), if failed jobs were excluded.
   * @return failedJobs
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The total number of failed jobs for the running instances. **Note**: Will be `0` (not `null`), if failed jobs were excluded.")

  public Integer getFailedJobs() {
    return failedJobs;
  }


  public void setFailedJobs(Integer failedJobs) {
    this.failedJobs = failedJobs;
  }


  public ProcessDefinitionStatisticsResultDto incidents(List<IncidentStatisticsResultDto> incidents) {
    
    this.incidents = incidents;
    return this;
  }

  public ProcessDefinitionStatisticsResultDto addIncidentsItem(IncidentStatisticsResultDto incidentsItem) {
    if (this.incidents == null) {
      this.incidents = new ArrayList<IncidentStatisticsResultDto>();
    }
    this.incidents.add(incidentsItem);
    return this;
  }

   /**
   * Each item in the resulting array is an object which contains &#x60;incidentType&#x60; and &#x60;incidentCount&#x60;. **Note**: Will be an empty array, if &#x60;incidents&#x60; or &#x60;incidentsForType&#x60; were excluded. Furthermore, the array will be also empty if no incidents were found.
   * @return incidents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "Each item in the resulting array is an object which contains `incidentType` and `incidentCount`. **Note**: Will be an empty array, if `incidents` or `incidentsForType` were excluded. Furthermore, the array will be also empty if no incidents were found.")

  public List<IncidentStatisticsResultDto> getIncidents() {
    return incidents;
  }


  public void setIncidents(List<IncidentStatisticsResultDto> incidents) {
    this.incidents = incidents;
  }


  public ProcessDefinitionStatisticsResultDto definition(ProcessDefinitionDto definition) {
    
    this.definition = definition;
    return this;
  }

   /**
   * Get definition
   * @return definition
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")

  public ProcessDefinitionDto getDefinition() {
    return definition;
  }


  public void setDefinition(ProcessDefinitionDto definition) {
    this.definition = definition;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProcessDefinitionStatisticsResultDto processDefinitionStatisticsResultDto = (ProcessDefinitionStatisticsResultDto) o;
    return Objects.equals(this.id, processDefinitionStatisticsResultDto.id) &&
        Objects.equals(this.instances, processDefinitionStatisticsResultDto.instances) &&
        Objects.equals(this.failedJobs, processDefinitionStatisticsResultDto.failedJobs) &&
        Objects.equals(this.incidents, processDefinitionStatisticsResultDto.incidents) &&
        Objects.equals(this.definition, processDefinitionStatisticsResultDto.definition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, instances, failedJobs, incidents, definition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProcessDefinitionStatisticsResultDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    instances: ").append(toIndentedString(instances)).append("\n");
    sb.append("    failedJobs: ").append(toIndentedString(failedJobs)).append("\n");
    sb.append("    incidents: ").append(toIndentedString(incidents)).append("\n");
    sb.append("    definition: ").append(toIndentedString(definition)).append("\n");
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

