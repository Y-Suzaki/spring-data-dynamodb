package com.sample.dynamodb;

import com.sample.dynamodb.model.MetricsInfo;
import com.sample.dynamodb.repository.MetricsInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DynamoDbClient {

    @Autowired
    private MetricsInfoRepository metricsInfoRepository;

    public static void main(String[] args) {
        try(ConfigurableApplicationContext ctx = SpringApplication.run(DynamoDbClient.class, args)) {
            DynamoDbClient dynamoDbClient = ctx.getBean(DynamoDbClient.class);
            dynamoDbClient.execute();
        }
    }

    public void execute() {
        // DynamoDBへの書き込み
        //putDynamoDb();

        // DynamoDBからの読み込み（scan使用）
        metricsInfoRepository.findAll().forEach(x -> System.out.println(x));

        // DynamoDBからの読み込み（index使用）
        metricsInfoRepository.findByWorkflow("workflow1").forEach(x -> System.out.println(x));

        System.out.println("Completed!");
    }
    private void putDynamoDb() {
        // date1
        MetricsInfo metricsInfo1 = new MetricsInfo();
        metricsInfo1.setId("0001");
        metricsInfo1.setName("metricsInfo1");
        metricsInfo1.setVersion("version1");
        metricsInfo1.setWorkflow("workflow1");
        metricsInfo1.setValue(100);
        metricsInfoRepository.save(metricsInfo1);

        // data2
        MetricsInfo metricsInfo2 = new MetricsInfo();
        metricsInfo2.setId("0002");
        metricsInfo2.setName("metricsInfo2");
        metricsInfo2.setVersion("version1");
        metricsInfo2.setWorkflow("workflow1");
        metricsInfo2.setValue(200);
        metricsInfoRepository.save(metricsInfo2);

        // data3
        MetricsInfo metricsInfo3 = new MetricsInfo();
        metricsInfo3.setId("0003");
        metricsInfo3.setName("metricsInfo3");
        metricsInfo3.setVersion("version1");
        metricsInfo3.setWorkflow("workflow2");
        metricsInfo3.setValue(300);
        metricsInfoRepository.save(metricsInfo3);
    }
}
