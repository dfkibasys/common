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
import de.dfki.cos.basys.common.rest.camunda.dto.ActivityInstanceIncidentDto;
import de.dfki.cos.basys.common.rest.camunda.dto.TransitionInstanceDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A JSON object corresponding to the Activity Instance tree of the given process instance.
 */
@ApiModel(description = "A JSON object corresponding to the Activity Instance tree of the given process instance.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-12T00:15:55.778Z[GMT]")
public class ActivityInstanceDto {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private String id;

  public static final String SERIALIZED_NAME_PARENT_ACTIVITY_INSTANCE_ID = "parentActivityInstanceId";
  @SerializedName(SERIALIZED_NAME_PARENT_ACTIVITY_INSTANCE_ID)
  private String parentActivityInstanceId;

  public static final String SERIALIZED_NAME_ACTIVITY_ID = "activityId";
  @SerializedName(SERIALIZED_NAME_ACTIVITY_ID)
  private String activityId;

  public static final String SERIALIZED_NAME_ACTIVITY_NAME = "activityName";
  @SerializedName(SERIALIZED_NAME_ACTIVITY_NAME)
  private String activityName;

  public static final String SERIALIZED_NAME_ACTIVITY_TYPE = "activityType";
  @SerializedName(SERIALIZED_NAME_ACTIVITY_TYPE)
  private String activityType;

  public static final String SERIALIZED_NAME_PROCESS_INSTANCE_ID = "processInstanceId";
  @SerializedName(SERIALIZED_NAME_PROCESS_INSTANCE_ID)
  private String processInstanceId;

  public static final String SERIALIZED_NAME_PROCESS_DEFINITION_ID = "processDefinitionId";
  @SerializedName(SERIALIZED_NAME_PROCESS_DEFINITION_ID)
  private String processDefinitionId;

  public static final String SERIALIZED_NAME_CHILD_ACTIVITY_INSTANCES = "childActivityInstances";
  @SerializedName(SERIALIZED_NAME_CHILD_ACTIVITY_INSTANCES)
  private List<ActivityInstanceDto> childActivityInstances = null;

  public static final String SERIALIZED_NAME_CHILD_TRANSITION_INSTANCES = "childTransitionInstances";
  @SerializedName(SERIALIZED_NAME_CHILD_TRANSITION_INSTANCES)
  private List<TransitionInstanceDto> childTransitionInstances = null;

  public static final String SERIALIZED_NAME_EXECUTION_IDS = "executionIds";
  @SerializedName(SERIALIZED_NAME_EXECUTION_IDS)
  private List<String> executionIds = null;

  public static final String SERIALIZED_NAME_INCIDENT_IDS = "incidentIds";
  @SerializedName(SERIALIZED_NAME_INCIDENT_IDS)
  private List<String> incidentIds = null;

  public static final String SERIALIZED_NAME_INCIDENTS = "incidents";
  @SerializedName(SERIALIZED_NAME_INCIDENTS)
  private List<ActivityInstanceIncidentDto> incidents = null;


  public ActivityInstanceDto id(String id) {
    
    this.id = id;
    return this;
  }

   /**
   * The id of the activity instance.
   * @return id
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The id of the activity instance.")

  public String getId() {
    return id;
  }


  public void setId(String id) {
    this.id = id;
  }


  public ActivityInstanceDto parentActivityInstanceId(String parentActivityInstanceId) {
    
    this.parentActivityInstanceId = parentActivityInstanceId;
    return this;
  }

   /**
   * The id of the parent activity instance, for example a sub process instance.
   * @return parentActivityInstanceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The id of the parent activity instance, for example a sub process instance.")

  public String getParentActivityInstanceId() {
    return parentActivityInstanceId;
  }


  public void setParentActivityInstanceId(String parentActivityInstanceId) {
    this.parentActivityInstanceId = parentActivityInstanceId;
  }


  public ActivityInstanceDto activityId(String activityId) {
    
    this.activityId = activityId;
    return this;
  }

   /**
   * The id of the activity.
   * @return activityId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The id of the activity.")

  public String getActivityId() {
    return activityId;
  }


  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }


  public ActivityInstanceDto activityName(String activityName) {
    
    this.activityName = activityName;
    return this;
  }

   /**
   * The name of the activity
   * @return activityName
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The name of the activity")

  public String getActivityName() {
    return activityName;
  }


  public void setActivityName(String activityName) {
    this.activityName = activityName;
  }


  public ActivityInstanceDto activityType(String activityType) {
    
    this.activityType = activityType;
    return this;
  }

   /**
   * The type of activity (corresponds to the XML element name in the BPMN 2.0, e.g., &#39;userTask&#39;)
   * @return activityType
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The type of activity (corresponds to the XML element name in the BPMN 2.0, e.g., 'userTask')")

  public String getActivityType() {
    return activityType;
  }


  public void setActivityType(String activityType) {
    this.activityType = activityType;
  }


  public ActivityInstanceDto processInstanceId(String processInstanceId) {
    
    this.processInstanceId = processInstanceId;
    return this;
  }

   /**
   * The id of the process instance this activity instance is part of.
   * @return processInstanceId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The id of the process instance this activity instance is part of.")

  public String getProcessInstanceId() {
    return processInstanceId;
  }


  public void setProcessInstanceId(String processInstanceId) {
    this.processInstanceId = processInstanceId;
  }


  public ActivityInstanceDto processDefinitionId(String processDefinitionId) {
    
    this.processDefinitionId = processDefinitionId;
    return this;
  }

   /**
   * The id of the process definition.
   * @return processDefinitionId
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "The id of the process definition.")

  public String getProcessDefinitionId() {
    return processDefinitionId;
  }


  public void setProcessDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }


  public ActivityInstanceDto childActivityInstances(List<ActivityInstanceDto> childActivityInstances) {
    
    this.childActivityInstances = childActivityInstances;
    return this;
  }

  public ActivityInstanceDto addChildActivityInstancesItem(ActivityInstanceDto childActivityInstancesItem) {
    if (this.childActivityInstances == null) {
      this.childActivityInstances = new ArrayList<ActivityInstanceDto>();
    }
    this.childActivityInstances.add(childActivityInstancesItem);
    return this;
  }

   /**
   * A list of child activity instances.
   * @return childActivityInstances
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of child activity instances.")

  public List<ActivityInstanceDto> getChildActivityInstances() {
    return childActivityInstances;
  }


  public void setChildActivityInstances(List<ActivityInstanceDto> childActivityInstances) {
    this.childActivityInstances = childActivityInstances;
  }


  public ActivityInstanceDto childTransitionInstances(List<TransitionInstanceDto> childTransitionInstances) {
    
    this.childTransitionInstances = childTransitionInstances;
    return this;
  }

  public ActivityInstanceDto addChildTransitionInstancesItem(TransitionInstanceDto childTransitionInstancesItem) {
    if (this.childTransitionInstances == null) {
      this.childTransitionInstances = new ArrayList<TransitionInstanceDto>();
    }
    this.childTransitionInstances.add(childTransitionInstancesItem);
    return this;
  }

   /**
   * A list of child transition instances. A transition instance represents an execution waiting in an asynchronous continuation.
   * @return childTransitionInstances
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of child transition instances. A transition instance represents an execution waiting in an asynchronous continuation.")

  public List<TransitionInstanceDto> getChildTransitionInstances() {
    return childTransitionInstances;
  }


  public void setChildTransitionInstances(List<TransitionInstanceDto> childTransitionInstances) {
    this.childTransitionInstances = childTransitionInstances;
  }


  public ActivityInstanceDto executionIds(List<String> executionIds) {
    
    this.executionIds = executionIds;
    return this;
  }

  public ActivityInstanceDto addExecutionIdsItem(String executionIdsItem) {
    if (this.executionIds == null) {
      this.executionIds = new ArrayList<String>();
    }
    this.executionIds.add(executionIdsItem);
    return this;
  }

   /**
   * A list of execution ids.
   * @return executionIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of execution ids.")

  public List<String> getExecutionIds() {
    return executionIds;
  }


  public void setExecutionIds(List<String> executionIds) {
    this.executionIds = executionIds;
  }


  public ActivityInstanceDto incidentIds(List<String> incidentIds) {
    
    this.incidentIds = incidentIds;
    return this;
  }

  public ActivityInstanceDto addIncidentIdsItem(String incidentIdsItem) {
    if (this.incidentIds == null) {
      this.incidentIds = new ArrayList<String>();
    }
    this.incidentIds.add(incidentIdsItem);
    return this;
  }

   /**
   * A list of incident ids.
   * @return incidentIds
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of incident ids.")

  public List<String> getIncidentIds() {
    return incidentIds;
  }


  public void setIncidentIds(List<String> incidentIds) {
    this.incidentIds = incidentIds;
  }


  public ActivityInstanceDto incidents(List<ActivityInstanceIncidentDto> incidents) {
    
    this.incidents = incidents;
    return this;
  }

  public ActivityInstanceDto addIncidentsItem(ActivityInstanceIncidentDto incidentsItem) {
    if (this.incidents == null) {
      this.incidents = new ArrayList<ActivityInstanceIncidentDto>();
    }
    this.incidents.add(incidentsItem);
    return this;
  }

   /**
   * A list of JSON objects containing incident specific properties: * &#x60;id&#x60;: the id of the incident * &#x60;activityId&#x60;: the activity id in which the incident occurred
   * @return incidents
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A list of JSON objects containing incident specific properties: * `id`: the id of the incident * `activityId`: the activity id in which the incident occurred")

  public List<ActivityInstanceIncidentDto> getIncidents() {
    return incidents;
  }


  public void setIncidents(List<ActivityInstanceIncidentDto> incidents) {
    this.incidents = incidents;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActivityInstanceDto activityInstanceDto = (ActivityInstanceDto) o;
    return Objects.equals(this.id, activityInstanceDto.id) &&
        Objects.equals(this.parentActivityInstanceId, activityInstanceDto.parentActivityInstanceId) &&
        Objects.equals(this.activityId, activityInstanceDto.activityId) &&
        Objects.equals(this.activityName, activityInstanceDto.activityName) &&
        Objects.equals(this.activityType, activityInstanceDto.activityType) &&
        Objects.equals(this.processInstanceId, activityInstanceDto.processInstanceId) &&
        Objects.equals(this.processDefinitionId, activityInstanceDto.processDefinitionId) &&
        Objects.equals(this.childActivityInstances, activityInstanceDto.childActivityInstances) &&
        Objects.equals(this.childTransitionInstances, activityInstanceDto.childTransitionInstances) &&
        Objects.equals(this.executionIds, activityInstanceDto.executionIds) &&
        Objects.equals(this.incidentIds, activityInstanceDto.incidentIds) &&
        Objects.equals(this.incidents, activityInstanceDto.incidents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, parentActivityInstanceId, activityId, activityName, activityType, processInstanceId, processDefinitionId, childActivityInstances, childTransitionInstances, executionIds, incidentIds, incidents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActivityInstanceDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    parentActivityInstanceId: ").append(toIndentedString(parentActivityInstanceId)).append("\n");
    sb.append("    activityId: ").append(toIndentedString(activityId)).append("\n");
    sb.append("    activityName: ").append(toIndentedString(activityName)).append("\n");
    sb.append("    activityType: ").append(toIndentedString(activityType)).append("\n");
    sb.append("    processInstanceId: ").append(toIndentedString(processInstanceId)).append("\n");
    sb.append("    processDefinitionId: ").append(toIndentedString(processDefinitionId)).append("\n");
    sb.append("    childActivityInstances: ").append(toIndentedString(childActivityInstances)).append("\n");
    sb.append("    childTransitionInstances: ").append(toIndentedString(childTransitionInstances)).append("\n");
    sb.append("    executionIds: ").append(toIndentedString(executionIds)).append("\n");
    sb.append("    incidentIds: ").append(toIndentedString(incidentIds)).append("\n");
    sb.append("    incidents: ").append(toIndentedString(incidents)).append("\n");
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

