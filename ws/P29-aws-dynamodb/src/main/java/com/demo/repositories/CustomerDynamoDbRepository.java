package com.demo.repositories;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.demo.entities.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.model.BatchWriteItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.WriteBatch;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

@Repository
public class CustomerDynamoDbRepository {
    @Autowired
    private DynamoDbEnhancedClient enhancedClient;
    @Autowired
    private DynamoDbTable<Customer> custTable;
    
    public void putRecord() {

        try {

            // Create an Instant
            LocalDate localDate = LocalDate.parse("2017-08-21");
            LocalDateTime localDateTime = localDate.atStartOfDay();
            Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

            // Populate the Table
            Customer custRecord = new Customer();
            custRecord.setCustName("Tim red");
            custRecord.setId("id120");
            custRecord.setEmail("tim@goserver.com");
            custRecord.setRegistrationDate(instant) ;

            // Put the customer data into a DynamoDB table
            custTable.putItem(custRecord);

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("putRecord for customer is done");
    }


    public void putBatchRecords() {
        try {
            LocalDate localDate = LocalDate.parse("2020-01-31");
            LocalDateTime localDateTime = localDate.atStartOfDay();
            Instant instant = localDateTime.toInstant(ZoneOffset.UTC);

            Customer record2 = new Customer();
            record2.setCustName("Fred Pink");
            record2.setId("id110");// not available, save/create
            record2.setEmail("fredp@noserver.com");
            record2.setRegistrationDate(instant) ;

            Customer record3 = new Customer();
            record3.setCustName("Susan Brown");
            record3.setId("id112");// if id is available -> not save, update operation
            record3.setEmail("spink@noserver.com");
            record3.setRegistrationDate(instant) ;

            // Create a BatchWriteItemEnhancedRequest object
            BatchWriteItemEnhancedRequest batchWriteItemEnhancedRequest =
                    BatchWriteItemEnhancedRequest.builder()
                            .writeBatches(
                                    WriteBatch.builder(Customer.class)
                                            .mappedTableResource(custTable)
                                            .addPutItem(r -> r.item(record2))
                                            .addPutItem(r -> r.item(record3))
                                            .build())
                            .build();

            // Add these two items to the table
            enhancedClient.batchWriteItem(batchWriteItemEnhancedRequest);
            System.out.println("batch write is done");

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void queryTableFilter() {

        try{
            AttributeValue att = AttributeValue.builder()
                    .s("spink@noserver.com")
                    .build();

            Map<String, AttributeValue> expressionValues = new HashMap<>();
            expressionValues.put(":value", att);

            Expression expression = Expression.builder()
                    .expression("email = :value")
                    .expressionValues(expressionValues)
                    .build();

            // Create a QueryConditional object that is used in the query operation.
            QueryConditional queryConditional = QueryConditional
                    .keyEqualTo(Key.builder().partitionValue("id120")
                            .build());

            // Get items in the Customer table and write out the ID value.
            Iterator<Customer> results = custTable.query(r -> r.queryConditional(queryConditional).filterExpression(expression)).items().iterator();

            while (results.hasNext()) {

                Customer rec = results.next();
                System.out.println("The record is "+rec);
            }

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Filter is done");
    }

    public void getAll() {

        try{
            Iterator<Customer> results = custTable.scan().items().iterator();
//            iterator -> ele2, ele3
//            if(!results.hasNext()) {
//            	System.out.println("Empty table");
//            }
            while (results.hasNext()) {
                Customer rec = results.next();
                System.out.println("The record is "+rec);
            }

        } catch (DynamoDbException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.out.println("Get all is done");
    }

    public void deleteCust(){
        Customer cust = new Customer();
        cust.setId("id120");
        Customer cus2 = custTable.deleteItem(cust);
        System.out.println(cus2);

        System.out.println("Delete operation is done");
    }

}