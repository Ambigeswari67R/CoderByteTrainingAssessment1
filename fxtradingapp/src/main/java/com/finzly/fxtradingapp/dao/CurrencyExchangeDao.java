package com.finzly.fxtradingapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.finzly.fxtradingapp.entity.CurrencyExchange;
import com.finzly.fxtradingapp.entity.Trade;

@Repository
public class CurrencyExchangeDao {
	@Autowired
	SessionFactory factory;

	public String addCurrencyPair(CurrencyExchange currencyExchange) {
		Session session = factory.openSession();
		session.save(currencyExchange);
		session.beginTransaction().commit();
		return "Currency pair and exchange rate added";
	}

	public List<CurrencyExchange> getCurrencyPair() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(CurrencyExchange.class);
		return criteria.list();
	}

}
