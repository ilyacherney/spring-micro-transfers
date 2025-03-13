package ru.otus.java.pro.mt.core.transfers.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class TransfersMetricsService {
    private final Counter metricCounter;
    private final AtomicInteger metricGauge;

    public TransfersMetricsService(MeterRegistry meterRegistry) {
        metricCounter = Counter.builder("transfers")
                .description("Metrics for the transfers")
                .tags("environment", "development")
                .register(meterRegistry);

        metricGauge = meterRegistry.gauge("custom_gauge", new AtomicInteger(0));
    }

    public void incrementMetricCounter() {
        metricCounter.increment();
    }

    public void changeCustomGauge() {
        metricGauge.set((int)(Math.random() * 1000));
    }
}
