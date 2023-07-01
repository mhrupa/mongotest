package com.quest.mongotest.configs;

import java.util.Arrays;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;


@Configuration
@EnableMongoRepositories(basePackages = "com.quest.mongotest.repositories")
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "mongo-test";
    }

    protected void configureMongoClientSettings(MongoClientSettings.Builder builder) {
        builder.applyToClusterSettings(settings ->
                settings.hosts(Arrays.asList(new ServerAddress("localhost", 27017))));
    }
}
