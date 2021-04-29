package com.example.dsadasdasda;

import org.apache.http.HttpResponse;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;
import org.elasticsearch.client.HeapBufferedAsyncResponseConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Conf {



    @Bean
    @Primary
    public  HttpAsyncResponseConsumer<HttpResponse> httpResponseHttpAsyncResponseConsumer() {
        return new HeapBufferedAsyncResponseConsumer(100 * 1024 * 1024);
    }
}
