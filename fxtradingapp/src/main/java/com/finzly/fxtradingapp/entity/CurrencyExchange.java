package com.finzly.fxtradingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "currency_pair")
	private String currencyPair;

	@Column(name = "exchange_rate", nullable = false, precision = 10, scale = 2)
	private double exchangeRate;

	public CurrencyExchange() {
		super();
	}

	public CurrencyExchange(Long id, String currencyPair, double exchangeRate) {
		super();
		this.id = id;
		this.currencyPair = currencyPair;
		this.exchangeRate = exchangeRate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Override
	public String toString() {
		return "CurrencyExchange [id=" + id + ", currencyPair=" + currencyPair + ", exchangeRate=" + exchangeRate + "]";
	}

}
