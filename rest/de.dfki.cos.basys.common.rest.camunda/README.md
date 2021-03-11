# Automatically generated OpenAPI Client for Camunda

## Resources
 - OpenAPI definition: https://docs.camunda.org/manual/7.14/reference/rest/openapi/
 - Downloads: https://app.camunda.com/nexus/service/rest/repository/browse/camunda-bpm/org/camunda/bpm/camunda-engine-rest-openapi/
 - Using dockerized OpenAPI Generator: https://github.com/OpenAPITools/openapi-generator#16---docker

## Usage
 - Create a folder named after the Camunda version, e.g. 7.14.0, and cd into that folder
 - Copy opanapi.json contained in downloaded jar-file here
 - Create a config.json

{
  "groupId":"de.dfki.cos.basys.common.camunda",
  "artifactId":"de.dfki.cos.basys.common.camunda",
  "artifactVersion":"7.14.0",
  "library":"jersey2",
  "apiPackage":"de.dfki.cos.basys.common.camunda.api",
  "modelPackage":"de.dfki.cos.basys.common.camunda.dto"
}

 - Then run 

docker run --rm -v ${PWD}:/local openapitools/openapi-generator-cli generate -i /local/openapi.json -c /local/config.json
 -g java -o /local/java
 
## Notice
 - By looking over the generated ApiClient, there was a self-assignment of the userAgent variable in the setUserAgent method (line 375). We corrected that manually.