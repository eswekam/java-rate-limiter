package org.example.ratelimiter.dao;

import org.example.ratelimiter.exception.ServiceConfigurationNotFoundException;
import org.example.ratelimiter.models.ServiceConfiguration;
import org.example.ratelimiter.models.Timeunit;

import java.util.HashMap;
import java.util.Map;

public class ServiceConfigurationDao {

    Map<String, ServiceConfiguration> configMap;

    public ServiceConfigurationDao() {
        this.configMap = new HashMap<>();

        ServiceConfiguration config = new ServiceConfiguration("service1", "user", 2, 5, Timeunit.SECONDS);
        this.configMap.put("service1", config);
    }

    public ServiceConfiguration getServiceConfigurationById(String service) {
        if (!this.configMap.containsKey(service)) {
            throw new ServiceConfigurationNotFoundException("Service configuration not found for service name " + service);
        }

        return this.configMap.get(service);
    }
}
