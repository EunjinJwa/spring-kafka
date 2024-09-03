package com.kafka.springkafka;

import com.kafka.springkafka.consumer.TestRecordListener;
import com.kafka.springkafka.producer.CustomKafkaProducer;
import com.kafka.springkafka.producer.DefaultProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringKafkaApplication implements CommandLineRunner {

//	@Autowired
//	private DefaultProducer defaultProducer;

	@Autowired
	private CustomKafkaProducer customKafkaProducer;

	@Autowired
	private TestRecordListener recordListener;


	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		customKafkaProducer.exute();
	}

}
