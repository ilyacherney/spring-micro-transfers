package ru.otus.java.pro.mt.core.transfers.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;


@Component
public class TransfersMetricsService {
    private final Counter requestsCounter;
    private final Counter successfulCounter;
    private final Counter failedCounter;

    public TransfersMetricsService(MeterRegistry meterRegistry) {
        requestsCounter = Counter.builder("transfers")
                .description("Metrics for the transfers")
                .tags("environment", "development")
                .register(meterRegistry);

        successfulCounter = Counter.builder("successful-transfers")
                .description("Metrics for the transfers")
                .tags("environment", "development")
                .register(meterRegistry);

        failedCounter = Counter.builder("failed-transfers")
                .description("Metrics for the transfers")
                .tags("environment", "development")
                .register(meterRegistry);
    }

    public void incrementRequestsCounter() {
        requestsCounter.increment();
    }

    public void incrementSuccessfulCounter() {
        successfulCounter.increment();
    }

    public void incrementFailedCounter() {
        failedCounter.increment();
    }
}
