package ru.otus.java.pro.mt.core.transfers;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

public class RestClientFactory {
    public static RestClient createRestClient(RestClientProperties props) {
        return RestClient.builder()
                .requestFactory(customRequestFactory(props))
                .baseUrl(props.getUrl())
                .build();
    }

    public static ClientHttpRequestFactory customRequestFactory(RestClientProperties props) {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(props.getConnectTimeout());
        factory.setReadTimeout(props.getReadTimeout());
        return factory;
    }
}
