package org.example.ratelimiter.algorithms;

import org.example.ratelimiter.models.ServiceConfiguration;
import org.example.ratelimiter.models.Timeunit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class SlidingWindowAlgorithm implements RateLimitingAlgorithm {

    private final ServiceConfiguration serviceConfiguration;

    private final Map<String, LinkedList<Long>> requests;

    public SlidingWindowAlgorithm(ServiceConfiguration serviceConfiguration) {
        this.serviceConfiguration = serviceConfiguration;
        this.requests = new HashMap<>();
    }

    private void cleanStaleTs(String key) {
        if (!this.requests.containsKey(key)) {
            this.requests.put(key, new LinkedList<Long>());
        }

        LinkedList<Long> window = this.requests.get(key);

        System.out.printf("linkedlist for key %s is \n", key);
        System.out.println(window);

        Long startTime = System.currentTimeMillis() - serviceConfiguration.getTime() * getSecondsFromTimeunit(serviceConfiguration.getTimeUnit());
        while (!window.isEmpty() && window.getLast() <= startTime) {
            System.out.println("Removing " + window.getLast());
            window.removeLast();
        }
    }

    private Long getSecondsFromTimeunit(Timeunit timeUnit) {
        Long millis = (long) 1.0;
        if (timeUnit == Timeunit.SECONDS) {
            millis *= 1000;
        }
        if (timeUnit == Timeunit.MINUTES) {
            millis *= 60;
        }
        return millis;
    }

    @Override
    public boolean shouldAccept(String key, long timestamp) {
        cleanStaleTs(key);
        this.requests.get(key).offerFirst(timestamp);

        if(this.requests.get(key).size() > this.serviceConfiguration.getAmount()) {
            System.out.println("Rate Limited");
            return false;
        }

        return true;
    }
}
