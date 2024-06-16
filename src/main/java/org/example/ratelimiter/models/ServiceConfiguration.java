package org.example.ratelimiter.models;


public class ServiceConfiguration {
    String service;
    String key;
    Integer amount;
    Integer time;
    Timeunit timeUnit;

    public ServiceConfiguration(String service, String key, Integer amount, Integer time, Timeunit timeUnit) {
        this.service = service;
        this.key = key;
        this.amount = amount;
        this.time = time;
        this.timeUnit = timeUnit;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Timeunit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(Timeunit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
