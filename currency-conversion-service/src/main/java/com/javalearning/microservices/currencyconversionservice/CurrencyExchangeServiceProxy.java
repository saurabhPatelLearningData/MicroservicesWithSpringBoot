package com.javalearning.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service",url="http://localhost:8000")
//@FeignClient(name = "currency-exchange-service")
//For implementing zuul api gateway we have doing below one line
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	/*
	 * @GetMapping("/currency-exchange/from/{from}/to/{to}") public
	 * CurrencyConversionBean retrieveExchangeValue(@PathVariable String
	 * from, @PathVariable String to);
	 */
	//For implementing zuul api gateway we have doing below one line
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable 
			String to);
}