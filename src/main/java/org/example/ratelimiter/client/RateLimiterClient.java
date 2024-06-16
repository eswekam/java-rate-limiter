package org.example.ratelimiter.client;

import org.example.ratelimiter.algorithms.RateLimitingAlgorithm;
import org.example.ratelimiter.models.ServiceConfiguration;

public class RateLimiterClient {

    protected ServiceConfiguration config;
    protected RateLimitingAlgorithm algorithm;

    public RateLimiterClient() {
    }

    protected RateLimiterClient(ServiceConfiguration config, RateLimitingAlgorithm algorithm) {
        this.config = config;
        this.algorithm = algorithm;
    }

    protected RateLimitingAlgorithm getAlgorithm() {
        return algorithm;
    }

    protected void setAlgorithm(RateLimitingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    protected ServiceConfiguration getConfig() {
        return config;
    }

    protected void setConfig(ServiceConfiguration config) {
        this.config = config;
    }

    public Boolean shouldAccept(String key, long timestamp) {
        return this.algorithm.shouldAccept(key, timestamp);
    }
}
