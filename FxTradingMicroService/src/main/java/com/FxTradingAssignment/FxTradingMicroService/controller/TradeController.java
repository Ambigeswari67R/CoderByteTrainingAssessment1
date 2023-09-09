package com.FxTradingAssignment.FxTradingMicroService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import com.FxTradingAssignment.FxTradingMicroService.model.Trade;

@RestController
@RequestMapping("/trade")
public class TradeController {

	private List<Trade> tradeList = new ArrayList<>();

	@PostMapping("/booktrade")
	public String receiveTrade(@RequestBody Trade trade) {
		trade.bookTrade(trade);
		tradeList.add(trade);
		return trade.printTrade();
	}

	@GetMapping("/printtrades")
	public List<Trade> getAllTrades() {
		return tradeList;
	}

}
