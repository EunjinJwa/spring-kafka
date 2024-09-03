package com.kafka.springkafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class CustomKafkaProducer {

    private static String TOPIC_NAME = "test_0828_1";

    @Autowired
    private KafkaTemplate customKafkaTemplate;

    public void exute() {
        System.out.println("run... setCustomKafkaTemplate");
        ListenableFuture future = customKafkaTemplate.send(TOPIC_NAME, "test_custom");

        future.addCallback(new KafkaSendCallback<String, String>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("success : " + result);
			}

			@Override
			public void onFailure(KafkaProducerException e) {
				System.out.println("fail : " + e.getMessage());
			}
		});
		System.exit(0);
    }

}
