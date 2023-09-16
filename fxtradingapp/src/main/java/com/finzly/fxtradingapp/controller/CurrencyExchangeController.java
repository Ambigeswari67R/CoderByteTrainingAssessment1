package com.finzly.fxtradingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtradingapp.entity.CurrencyExchange;
import com.finzly.fxtradingapp.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	// add currency pair and exchange rate
	@PostMapping("/add-currency-pair")
	public String addCurrencyPair(@RequestBody CurrencyExchange currencyExchange) {
		return currencyExchangeService.addCurrencyPair(currencyExchange);
	}

	// Get currency pair list
	@GetMapping("/get-currencypair")
	public List<CurrencyExchange> getCurrencyPair() {
		return currencyExchangeService.getCurrencyPair();
	}

}
