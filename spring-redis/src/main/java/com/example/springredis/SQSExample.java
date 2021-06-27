package com.example.springredis;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.CreateQueueRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlResponse;
import software.amazon.awssdk.services.sqs.model.ListQueuesRequest;
import software.amazon.awssdk.services.sqs.model.ListQueuesResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageBatchRequestEntry;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

@Slf4j
public class SQSExample {


    public static void main(String[] args) {
        String accessKey = "AKIAUMNW7JP54BIPAYS6";
        String secretKey = "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";

        String queueName = "myQueue" + System.currentTimeMillis();

//        String accessKey = System.getenv("AWS_ACCESS_KEY_ID");

        System.setProperty("aws.accessKeyId", "AKIAUMNW7JP54BIPAYS6");
        System.setProperty("aws.secretAccessKey", "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");
        System.out.println(accessKey);



        // create sqsClient
        SqsClient sqsClient = SqsClient.builder()
//                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
//                .credentialsProvider(SystemPropertyCredentialsProvider.create())
                .credentialsProvider(ProfileCredentialsProvider.create())
                .region(Region.AP_NORTHEAST_2)
                .build();

//        String queueUrl = createQueue(sqsClient, queueName);

        String queueUrl = "";
        // list queue
        List<String> strings = listQueue(sqsClient);
        for (String string : strings) {
            log.info(string);
            queueUrl = string;
        }

//        sendBatchMessages(sqsClient, queueUrl);
        List<Message> messages = receiveMessage(sqsClient, queueUrl);
        for (Message message : messages) {
            log.info("message :{}", message);

        }

    }

    private static String createQueue(SqsClient client, String queueName) {
        log.info("createQueue");

        CreateQueueRequest createQueueRequest = CreateQueueRequest.builder()
                .queueName(queueName)
                .build();

        client.createQueue(createQueueRequest);
        GetQueueUrlResponse queueUrlResponse = client
                .getQueueUrl(GetQueueUrlRequest.builder().queueName(queueName).build());

        return queueUrlResponse.queueUrl();
    }

    private static List<String> listQueue(SqsClient sqsClient) {
        String prefix = "myQueue";
        ListQueuesRequest request = ListQueuesRequest.builder().queueNamePrefix(prefix).build();
        ListQueuesResponse listQueuesResponse = sqsClient.listQueues(request);
        return listQueuesResponse.queueUrls();
    }

    private static void sendMessage(SqsClient sqsClient, String queueUrl) {
        SendMessageResponse response = sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody("hello world")
                .delaySeconds(10)
                .build()
        );

        log.info("sendMessageResponse:: messageId {}", response.messageId());
    }

    public static void sendBatchMessages(SqsClient sqsClient, String queueUrl) {
        log.info("send batch message!!");

        SendMessageBatchRequest batchRequest = SendMessageBatchRequest.builder()
                .queueUrl(queueUrl)
                .entries(
                        SendMessageBatchRequestEntry.builder().id("id1").messageBody("msg 1")
                                .build(),
                        SendMessageBatchRequestEntry.builder().id("id2").messageBody("msg 2")
                                .build()
                ).build();

        sqsClient.sendMessageBatch(batchRequest);
    }

    public static List<Message> receiveMessage(SqsClient sqsClient, String queueUrl) {
        log.info("receive message ");

        ReceiveMessageRequest request = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10)
                .build();

        List<Message> messages = sqsClient.receiveMessage(request).messages();
        return messages;

    }

}
