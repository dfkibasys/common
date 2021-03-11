

# VariableQueryParameterDto


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | Variable name |  [optional]
**operator** | [**OperatorEnum**](#OperatorEnum) | Comparison operator to be used |  [optional]
**value** | **Object** | The variable value, could be of type boolean, string or number |  [optional]



## Enum: OperatorEnum

Name | Value
---- | -----
EQ | &quot;eq&quot;
NEQ | &quot;neq&quot;
GT | &quot;gt&quot;
GTEQ | &quot;gteq&quot;
LT | &quot;lt&quot;
LTEQ | &quot;lteq&quot;
LIKE | &quot;like&quot;



