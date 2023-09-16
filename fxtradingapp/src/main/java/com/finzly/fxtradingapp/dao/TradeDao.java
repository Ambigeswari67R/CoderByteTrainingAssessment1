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
public class TradeDao {
	@Autowired
	SessionFactory factory;

	public String saveTrade(Trade trade) {
		Session session = factory.openSession();
		session.save(trade);
		session.beginTransaction().commit();
		return "Trade is booked";

	}

	public List<Trade> getTrade() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Trade.class);
		return criteria.list();
	}

	public List<CurrencyExchange> bookTrade(Trade trade, CurrencyExchange currencyExchange) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(CurrencyExchange.class);
		return criteria.list();
	}

}
