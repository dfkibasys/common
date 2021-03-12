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
import de.dfki.cos.basys.common.rest.camunda.dto.CaseDefinitionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.DecisionDefinitionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.DecisionRequirementsDefinitionDto;
import de.dfki.cos.basys.common.rest.camunda.dto.ProcessDefinitionDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DeploymentWithDefinitionsDtoAllOf
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-03-12T00:15:55.778Z[GMT]")
public class DeploymentWithDefinitionsDtoAllOf {
  public static final String SERIALIZED_NAME_DEPLOYED_PROCESS_DEFINITIONS = "deployedProcessDefinitions";
  @SerializedName(SERIALIZED_NAME_DEPLOYED_PROCESS_DEFINITIONS)
  private Map<String, ProcessDefinitionDto> deployedProcessDefinitions = null;

  public static final String SERIALIZED_NAME_DEPLOYED_DECISION_DEFINITIONS = "deployedDecisionDefinitions";
  @SerializedName(SERIALIZED_NAME_DEPLOYED_DECISION_DEFINITIONS)
  private Map<String, DecisionDefinitionDto> deployedDecisionDefinitions = null;

  public static final String SERIALIZED_NAME_DEPLOYED_DECISION_REQUIREMENTS_DEFINITIONS = "deployedDecisionRequirementsDefinitions";
  @SerializedName(SERIALIZED_NAME_DEPLOYED_DECISION_REQUIREMENTS_DEFINITIONS)
  private Map<String, DecisionRequirementsDefinitionDto> deployedDecisionRequirementsDefinitions = null;

  public static final String SERIALIZED_NAME_DEPLOYED_CASE_DEFINITIONS = "deployedCaseDefinitions";
  @SerializedName(SERIALIZED_NAME_DEPLOYED_CASE_DEFINITIONS)
  private Map<String, CaseDefinitionDto> deployedCaseDefinitions = null;


  public DeploymentWithDefinitionsDtoAllOf deployedProcessDefinitions(Map<String, ProcessDefinitionDto> deployedProcessDefinitions) {
    
    this.deployedProcessDefinitions = deployedProcessDefinitions;
    return this;
  }

  public DeploymentWithDefinitionsDtoAllOf putDeployedProcessDefinitionsItem(String key, ProcessDefinitionDto deployedProcessDefinitionsItem) {
    if (this.deployedProcessDefinitions == null) {
      this.deployedProcessDefinitions = new HashMap<String, ProcessDefinitionDto>();
    }
    this.deployedProcessDefinitions.put(key, deployedProcessDefinitionsItem);
    return this;
  }

   /**
   * A JSON Object containing a property for each of the process definitions, which are successfully deployed with that deployment. The key is the process definition id, the value is a JSON Object corresponding to the process definition.
   * @return deployedProcessDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A JSON Object containing a property for each of the process definitions, which are successfully deployed with that deployment. The key is the process definition id, the value is a JSON Object corresponding to the process definition.")

  public Map<String, ProcessDefinitionDto> getDeployedProcessDefinitions() {
    return deployedProcessDefinitions;
  }


  public void setDeployedProcessDefinitions(Map<String, ProcessDefinitionDto> deployedProcessDefinitions) {
    this.deployedProcessDefinitions = deployedProcessDefinitions;
  }


  public DeploymentWithDefinitionsDtoAllOf deployedDecisionDefinitions(Map<String, DecisionDefinitionDto> deployedDecisionDefinitions) {
    
    this.deployedDecisionDefinitions = deployedDecisionDefinitions;
    return this;
  }

  public DeploymentWithDefinitionsDtoAllOf putDeployedDecisionDefinitionsItem(String key, DecisionDefinitionDto deployedDecisionDefinitionsItem) {
    if (this.deployedDecisionDefinitions == null) {
      this.deployedDecisionDefinitions = new HashMap<String, DecisionDefinitionDto>();
    }
    this.deployedDecisionDefinitions.put(key, deployedDecisionDefinitionsItem);
    return this;
  }

   /**
   * A JSON Object containing a property for each of the decision definitions, which are successfully deployed with that deployment. The key is the decision definition id, the value is a JSON Object corresponding to the decision definition.
   * @return deployedDecisionDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A JSON Object containing a property for each of the decision definitions, which are successfully deployed with that deployment. The key is the decision definition id, the value is a JSON Object corresponding to the decision definition.")

  public Map<String, DecisionDefinitionDto> getDeployedDecisionDefinitions() {
    return deployedDecisionDefinitions;
  }


  public void setDeployedDecisionDefinitions(Map<String, DecisionDefinitionDto> deployedDecisionDefinitions) {
    this.deployedDecisionDefinitions = deployedDecisionDefinitions;
  }


  public DeploymentWithDefinitionsDtoAllOf deployedDecisionRequirementsDefinitions(Map<String, DecisionRequirementsDefinitionDto> deployedDecisionRequirementsDefinitions) {
    
    this.deployedDecisionRequirementsDefinitions = deployedDecisionRequirementsDefinitions;
    return this;
  }

  public DeploymentWithDefinitionsDtoAllOf putDeployedDecisionRequirementsDefinitionsItem(String key, DecisionRequirementsDefinitionDto deployedDecisionRequirementsDefinitionsItem) {
    if (this.deployedDecisionRequirementsDefinitions == null) {
      this.deployedDecisionRequirementsDefinitions = new HashMap<String, DecisionRequirementsDefinitionDto>();
    }
    this.deployedDecisionRequirementsDefinitions.put(key, deployedDecisionRequirementsDefinitionsItem);
    return this;
  }

   /**
   * A JSON Object containing a property for each of the decision requirements definitions, which are successfully deployed with that deployment. The key is the decision requirements definition id, the value is a JSON Object corresponding to the decision requirements definition.
   * @return deployedDecisionRequirementsDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A JSON Object containing a property for each of the decision requirements definitions, which are successfully deployed with that deployment. The key is the decision requirements definition id, the value is a JSON Object corresponding to the decision requirements definition.")

  public Map<String, DecisionRequirementsDefinitionDto> getDeployedDecisionRequirementsDefinitions() {
    return deployedDecisionRequirementsDefinitions;
  }


  public void setDeployedDecisionRequirementsDefinitions(Map<String, DecisionRequirementsDefinitionDto> deployedDecisionRequirementsDefinitions) {
    this.deployedDecisionRequirementsDefinitions = deployedDecisionRequirementsDefinitions;
  }


  public DeploymentWithDefinitionsDtoAllOf deployedCaseDefinitions(Map<String, CaseDefinitionDto> deployedCaseDefinitions) {
    
    this.deployedCaseDefinitions = deployedCaseDefinitions;
    return this;
  }

  public DeploymentWithDefinitionsDtoAllOf putDeployedCaseDefinitionsItem(String key, CaseDefinitionDto deployedCaseDefinitionsItem) {
    if (this.deployedCaseDefinitions == null) {
      this.deployedCaseDefinitions = new HashMap<String, CaseDefinitionDto>();
    }
    this.deployedCaseDefinitions.put(key, deployedCaseDefinitionsItem);
    return this;
  }

   /**
   * A JSON Object containing a property for each of the case definitions, which are successfully deployed with that deployment. The key is the case definition id, the value is a JSON Object corresponding to the case definition.
   * @return deployedCaseDefinitions
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "A JSON Object containing a property for each of the case definitions, which are successfully deployed with that deployment. The key is the case definition id, the value is a JSON Object corresponding to the case definition.")

  public Map<String, CaseDefinitionDto> getDeployedCaseDefinitions() {
    return deployedCaseDefinitions;
  }


  public void setDeployedCaseDefinitions(Map<String, CaseDefinitionDto> deployedCaseDefinitions) {
    this.deployedCaseDefinitions = deployedCaseDefinitions;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeploymentWithDefinitionsDtoAllOf deploymentWithDefinitionsDtoAllOf = (DeploymentWithDefinitionsDtoAllOf) o;
    return Objects.equals(this.deployedProcessDefinitions, deploymentWithDefinitionsDtoAllOf.deployedProcessDefinitions) &&
        Objects.equals(this.deployedDecisionDefinitions, deploymentWithDefinitionsDtoAllOf.deployedDecisionDefinitions) &&
        Objects.equals(this.deployedDecisionRequirementsDefinitions, deploymentWithDefinitionsDtoAllOf.deployedDecisionRequirementsDefinitions) &&
        Objects.equals(this.deployedCaseDefinitions, deploymentWithDefinitionsDtoAllOf.deployedCaseDefinitions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deployedProcessDefinitions, deployedDecisionDefinitions, deployedDecisionRequirementsDefinitions, deployedCaseDefinitions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeploymentWithDefinitionsDtoAllOf {\n");
    sb.append("    deployedProcessDefinitions: ").append(toIndentedString(deployedProcessDefinitions)).append("\n");
    sb.append("    deployedDecisionDefinitions: ").append(toIndentedString(deployedDecisionDefinitions)).append("\n");
    sb.append("    deployedDecisionRequirementsDefinitions: ").append(toIndentedString(deployedDecisionRequirementsDefinitions)).append("\n");
    sb.append("    deployedCaseDefinitions: ").append(toIndentedString(deployedCaseDefinitions)).append("\n");
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

