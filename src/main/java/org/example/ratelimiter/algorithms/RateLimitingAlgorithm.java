package org.example.ratelimiter.algorithms;

public interface RateLimitingAlgorithm {
    boolean shouldAccept(String key, long timestamp);
}
