package com.varNcrement.notificationservice.config;

import com.varNcrement.notificationservice.repository.NotificationRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = NotificationRepo.class)
@Configuration
public class MongoDBConfig {

}
