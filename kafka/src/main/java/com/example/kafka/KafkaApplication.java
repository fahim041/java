package com.example.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate){
		return args -> {
//			kafkaTemplate.send("kafka-spring", "Hello!! no");
			for (int i = 0; i < 2; i++) {
				kafkaTemplate.send("kafka-spring", "Data: "+i);
			}
		};
	}


//---------------> Minimal config <---------------------
//	@Bean
//	public NewTopic topic() {
//		return TopicBuilder.name("topic1")
//				.partitions(10)
//				.replicas(1)
//				.build();
//	}
//
//	@Bean
//	public ApplicationRunner runner(KafkaTemplate<String, String> template) {
//		return args -> {
//			template.send("topic1", 2, "keypart1", "datapart1");
//		};
//	}
//
//	@KafkaListener(groupId = "root1", topics = "topic1")
//	public void listen(String in) {
//		System.out.println(in);
//	}
//
//	@KafkaListener( groupId = "root2", topics = "topic1")
//	public void listenpart2(String in) {
//		System.out.println("part2 "+in);
//	}

//	@KafkaListener(groupId = "root1", topicPartitions =
//			{ @TopicPartition(topic = "topic1", partitions = { "2" })})
//	public void listen(String in) {
//		System.out.println(in);
//	}
//
//	@KafkaListener( groupId = "root2", topicPartitions =
//			{ @TopicPartition(topic = "topic1", partitions = { "1" })})
//	public void listenpart2(String in) {
//		System.out.println("part2 "+in);
//	}

//

}
