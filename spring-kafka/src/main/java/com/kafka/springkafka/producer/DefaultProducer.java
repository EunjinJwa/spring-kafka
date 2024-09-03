package com.kafka.springkafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//@Component
public class DefaultProducer {

    private static String TOPIC_NAME = "test_0828_1";

//    @Autowired
	private KafkaTemplate<Integer, String> template;


    public void exute() {
        for (int i = 0; i < 10; i++) {
            template.send(TOPIC_NAME, "test_0828_1" + i);
        }
        System.exit(0);
    }
}
