package org.example.ratelimiter.client;

import org.example.ratelimiter.algorithms.SlidingWindowAlgorithm;
import org.example.ratelimiter.dao.ServiceConfigurationDao;
import org.example.ratelimiter.models.ServiceConfiguration;

public class RateLimiterBuilder {
    String serviceName;
    String algorithmName;

    private final ServiceConfigurationDao serviceConfigurationDao;

    public RateLimiterBuilder() {
        this.serviceConfigurationDao = new ServiceConfigurationDao();
    }

    public RateLimiterBuilder service(String service) {
        this.serviceName = service;
        return this;
    }

    // @Todo: Cleaner way to pass algo
    public RateLimiterBuilder algorithm(String algo) {
        this.algorithmName = algo;
        return this;
    }

    public RateLimiterClient build() {
        RateLimiterClient client = new RateLimiterClient();

        ServiceConfiguration config = serviceConfigurationDao.getServiceConfigurationById(this.serviceName);
        client.setConfig(config);
        client.setAlgorithm(new SlidingWindowAlgorithm(config));

        return client;
    }


}
