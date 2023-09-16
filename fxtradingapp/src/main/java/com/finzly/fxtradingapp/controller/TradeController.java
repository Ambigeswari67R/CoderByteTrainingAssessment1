package com.finzly.fxtradingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.fxtradingapp.entity.CurrencyExchange;
import com.finzly.fxtradingapp.entity.Trade;
import com.finzly.fxtradingapp.exception.CustomTradeException;
import com.finzly.fxtradingapp.service.TradeService;

@RestController
@RequestMapping("/trade")
public class TradeController {
	@Autowired
	private TradeService tradeService;

	// book trades
	@PostMapping("/booktrade")
	public List<Trade> bookTrade(@RequestBody Trade trade, CurrencyExchange currencyExchange)
			throws CustomTradeException {
		return tradeService.bookTrade(trade, currencyExchange);
	}

	// Get trades list
	@GetMapping("/get-trades")
	public List<Trade> getTrade() {
		return tradeService.getTrade();
	}

}
