package com.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* Do not connect to currency-exchange-service directly.
   Instead connect via the netflix-zuul-api-gateway-server.
 */
// @FeignClient(name="currency-exchange-service", url="localhost:8000")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    // @GetMapping("/currency-exchange/from/{from}/to/{to}")
    @GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
    
}