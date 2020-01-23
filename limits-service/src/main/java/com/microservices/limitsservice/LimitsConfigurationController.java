package com.microservices.limitsservice;

import com.microservices.limitsservice.bean.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {
        return new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }

    @HystrixCommand(fallbackMethod ="fallbackRetrieveConfiguration")
    @GetMapping("/fault-tolerance-example")
    public LimitConfiguration retrieveConfiguration() {
        throw new RuntimeException("Not available...");
    }

    public LimitConfiguration fallbackRetrieveConfiguration(){
        return new LimitConfiguration(9,999);
    }

}