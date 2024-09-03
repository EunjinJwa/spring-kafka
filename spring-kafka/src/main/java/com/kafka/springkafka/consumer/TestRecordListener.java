package com.kafka.springkafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class TestRecordListener {

    @KafkaListener(topics = "test_0828_1", groupId = "test-group-00")
    public void recordListender(ConsumerRecords<String, String> records) {
        System.out.println(records.toString());
    }

    @KafkaListener(topics = "test_0828_1", groupId = "test-group-01")
    public void singleTopicListener(String messageValue) {
        System.out.println(messageValue);
    }

    @KafkaListener(topics = "test_0828_1", groupId = "test-group-02",
            properties = {"max.poll.interval.ms:60000", "auto.offset.reset:earliest"})
    public void singleTopicWithPropertiesListener(String messageValue) {
        System.out.println(messageValue);
    }

    @KafkaListener(topics = "test_0828_1", groupId = "test-group-03",
            concurrency = "3")
    public void concurrentTopicListener(String messageValue) {
        System.out.println(messageValue);
    }

    @KafkaListener(topicPartitions = {
            @TopicPartition(topic = "Test01", partitions = {"0", "1"}),
            @TopicPartition(topic = "Test02", partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "3"))
    })
    public void listenSpecificPartition(ConsumerRecords<String, String> records) {
        System.out.println(records.toString());
    }

}
