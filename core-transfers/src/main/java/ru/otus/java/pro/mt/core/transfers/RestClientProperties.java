package ru.otus.java.pro.mt.core.transfers;

import lombok.Data;

@Data
public class RestClientProperties {
    private String url;
    private int readTimeout;
    private int connectTimeout;
}
