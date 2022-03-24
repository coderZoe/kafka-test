package com.coderzoe.config;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

import java.net.InetSocketAddress;

/**
 * @author coderZoe
 * @date 2022/3/23 20:05
 */
@Configuration
public class EsConfig {
    @Value("${es.host}")
    private String host;
    @Value("${es.port}")
    private short port;

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo(new InetSocketAddress(host, port)).build();
        return RestClients.create(clientConfiguration).rest();
    }

}
