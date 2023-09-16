package com.finzly.fxtradingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finzly.fxtradingapp.dao.CurrencyExchangeDao;
import com.finzly.fxtradingapp.entity.CurrencyExchange;

@Service
public class CurrencyExchangeService {
	@Autowired
	private CurrencyExchangeDao currencyExchangeDao;

	public String addCurrencyPair(CurrencyExchange currencyExchange) {
		return currencyExchangeDao.addCurrencyPair(currencyExchange);
	}

	public List<CurrencyExchange> getCurrencyPair() {
		return currencyExchangeDao.getCurrencyPair();
	}

}
