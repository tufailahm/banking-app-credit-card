package com.training.creditapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.creditapp.model.BankCustomer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("creditcards")
public class CreditCardController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("hello")
	public String getHello() {
		return "Hello Carol";
	}

	@GetMapping("goodmorning")
	public String getGreetings() {
		return "Hello Good morning";
	}

	@GetMapping("lunch")
	public String getLunch() {
		return "No lunch break today.";
	}

	@GetMapping("applyCreditCard/{customerId}")
	@CircuitBreaker(name = "visitorServiceCircuitBreaker", fallbackMethod = "ofssFallbackmethod")
	public ResponseEntity<String> applyCreditCard(@PathVariable("customerId") String customerId) {
		String url = "http://localhost:9090/customers/" + customerId;

		ResponseEntity<String> responseEntity;
		String result = null;
		ResponseEntity<BankCustomer> responseFromCustomerApp = restTemplate.getForEntity(url, BankCustomer.class);
		BankCustomer bankCustomer = responseFromCustomerApp.getBody();
		if (responseFromCustomerApp.getStatusCode() == HttpStatus.NO_CONTENT)
			result = customerId + " , your are not existing customer";
		else if (bankCustomer.getBalance() < 10000)
			result = "Sorry , " + bankCustomer.getCustomerName() + " , Credit card rejected, try again.";
		else
			result = "Congrats " + bankCustomer.getCustomerName() + " , Credit card approved";

		responseEntity = new ResponseEntity<String>(result, HttpStatus.OK);

		return responseEntity;
	}

	public ResponseEntity<String> ofssFallbackmethod(String id, Throwable t) {
		return new ResponseEntity<String>("Customer service is currently unavailable. Please try again later.",
				HttpStatus.BAD_GATEWAY);
	}

}
