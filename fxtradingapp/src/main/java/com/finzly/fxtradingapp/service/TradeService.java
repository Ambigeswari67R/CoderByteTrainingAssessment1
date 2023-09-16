package com.finzly.fxtradingapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtradingapp.dao.TradeDao;
import com.finzly.fxtradingapp.entity.CurrencyExchange;
import com.finzly.fxtradingapp.entity.Trade;
import com.finzly.fxtradingapp.exception.CustomCurrencyPairException;
import com.finzly.fxtradingapp.exception.CustomTradeException;

@Service
public class TradeService {
	@Autowired
	private TradeDao tradeDao;

	public List<Trade> getTrade() {
		return tradeDao.getTrade();
	}

	

	public List<Trade> bookTrade(Trade trade, CurrencyExchange currencyExchange) throws CustomTradeException {
		try {
			List<CurrencyExchange> list = tradeDao.bookTrade(trade, currencyExchange);

			List<Trade> trades = new ArrayList<>();
			double transferredAmount = 0;
			double rate = 0;

			boolean validCurrencyPair = false; // Flag to check if a valid pair is found

			for (CurrencyExchange currencyexchange : list) {
				if (currencyexchange.getCurrencyPair().equalsIgnoreCase(trade.getCurrencyPair())) {
					rate = currencyexchange.getExchangeRate();
					transferredAmount = rate * trade.getAmount();
					validCurrencyPair = true; // Found a valid pair
					break; // No need to continue searching
				}
			}

			if (!validCurrencyPair) {
				throw new CustomCurrencyPairException("Invalid currency pair: " + trade.getCurrencyPair());
			}

			Trade newTrade = new Trade();
			newTrade.setCurrencyPair(trade.getCurrencyPair());
			newTrade.setAmount(trade.getAmount());
			newTrade.setExchangeAmount(transferredAmount);
			newTrade.setRate(rate);

			// Save the new trade to the database
			tradeDao.saveTrade(newTrade);

			trades.add(newTrade); // Add the new trade to the list
			return trades; // Return the list of trades
		} catch (Exception e) {
			throw new CustomTradeException("Error processing the trade: " + e.getMessage());
		}
	}

}
