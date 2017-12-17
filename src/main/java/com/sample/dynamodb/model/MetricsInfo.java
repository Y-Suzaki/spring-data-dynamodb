package com.sample.dynamodb.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Setter;
import lombok.ToString;

@DynamoDBTable(tableName = "MetricsInfo")
@Setter
@ToString
public class MetricsInfo {
    private String id;
    private String name;
    private Integer value;
    private String workflow;
    private String version;

    @DynamoDBHashKey
    public String getId() {
        return id;
    }

    @DynamoDBAttribute
    public String getName() {
        return name;
    }

    @DynamoDBAttribute
    public Integer getValue() {
        return value;
    }

    @DynamoDBIndexHashKey(globalSecondaryIndexName = "workflow-index")
    public String getWorkflow() {
        return workflow;
    }

    @DynamoDBAttribute
    public String getVersion() {
        return version;
    }
}
