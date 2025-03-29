package ru.otus.java.pro.mt.core.transfers.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import ru.otus.java.pro.mt.core.transfers.RestClientFactory;
import ru.otus.java.pro.mt.core.transfers.RestClientProperties;
import ru.otus.java.pro.mt.core.transfers.configs.properties.LimitsIntegrationProperties;

@Configuration
public class RestClientsConfig {
    // @Bean
    public RestTemplate commonRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestClient limitsClient(LimitsIntegrationProperties properties) {

        RestClientProperties restClientProperties = new RestClientProperties();
        restClientProperties.setUrl(properties.getUrl());
        restClientProperties.setConnectTimeout((int) properties.getConnectTimeout().toMillis());
        restClientProperties.setReadTimeout((int) properties.getReadTimeout().toMillis());

        return RestClientFactory.createRestClient(restClientProperties);
    }
}
