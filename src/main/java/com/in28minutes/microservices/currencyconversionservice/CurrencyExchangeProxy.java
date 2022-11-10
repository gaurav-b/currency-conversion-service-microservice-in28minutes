package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * the name below should match the name of the application 
 * mentioned in the application.properties. Now the instances of
 * currency-exchange-service are client side load balanced.
 * Client side load balancing: Earlier it was done using Ribbon but now,
 * it is done using spring cloud loadbalancer.
 * 
 * it is available in the class path by using "spring-cloud-starter-netflix-eureka-client"
 * we just need to use eureka client and feign and it will provide us
 * with client side load balancing automatically
 *  
 * @author gaura
 */
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from,
			@PathVariable String to);
}
