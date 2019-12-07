package com.varNcrement.notificationservice.config;

import com.varNcrement.bookingservice.model.Booking;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Value("${KafkaHost}")
    private String kafkaHost;

    @Bean
    public ConsumerFactory<String, Booking> bookingConsumerFactory(){
        Map<String, Object> config = new HashMap<>();

        JsonDeserializer<Booking> domainEventJsonDeserializer = new JsonDeserializer<>(Booking.class);
        domainEventJsonDeserializer.addTrustedPackages("*");

        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaHost);
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "notification_group");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(),
                 domainEventJsonDeserializer);
    }



    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Booking> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Booking> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(bookingConsumerFactory());

        return factory;
    }

}
