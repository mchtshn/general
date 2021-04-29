package com.example.dsadasdasda;

import org.apache.http.HttpResponse;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;
import org.elasticsearch.client.HeapBufferedAsyncResponseConsumer;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication

public class DsadasdasdaApplication {


    @Autowired
    private  EntityRepository entityRepository;

    public static void main(String[] args) {
        SpringApplication.run(DsadasdasdaApplication.class, args);
    }




}
