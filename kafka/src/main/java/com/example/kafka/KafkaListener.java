package com.example.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.internals.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

//    @Bean
//    public NewTopic topic(){
//        return TopicBuilder.name("kafka-spring").partitions(001).build();
//    }
    @org.springframework.kafka.annotation.KafkaListener(topics = "kafka-spring", groupId = "001")
    void listener(String data){
        System.out.println("received: "+data);
    }
}
