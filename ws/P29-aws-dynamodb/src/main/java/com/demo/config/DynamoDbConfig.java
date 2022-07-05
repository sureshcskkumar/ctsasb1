package com.demo.config;

import java.net.URI;

import com.demo.entities.Customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDbConfig {
    
    @Value("${amazon.dynamo.db.endpoint}")
    private String dynamoDbEndpoint;
    @Value("${amazon.dynamo.db.region}")
    private String dynamoDbRegion;

    @Bean
    public Region getRegion(){
        return Region.of(dynamoDbRegion);
    }
    
    @Bean
    public DynamoDbClient getDynamoDbClient(){
        DynamoDbClient client = DynamoDbClient.builder()
    .endpointOverride(URI.create(dynamoDbEndpoint))
    // The region is meaningless for local DynamoDb but required for client builder validation
    .region(getRegion())
    
    // .credentialsProvider(StaticCredentialsProvider.create(
    // AwsBasicCredentials.create("dummy-key", "dummy-secret")))
    
    .build();

    return client;
    }


    @Bean
    public DynamoDbEnhancedClient getDynamoDbEnhancedClient(){
        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
        .dynamoDbClient(getDynamoDbClient())
        .build();
        return enhancedClient;
    }

    @Bean
    public DynamoDbTable<Customer> getDynamoDbTable(){
        String tableName = "Customer";
        DynamoDbTable<Customer> table = getDynamoDbEnhancedClient().table(tableName, TableSchema.fromBean(Customer.class));
        return table;
    }

}