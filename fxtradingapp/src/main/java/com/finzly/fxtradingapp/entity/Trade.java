package com.finzly.fxtradingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "from_customer_name")
	private String fromCustomerName;

	@Column(name = "to_customer_name")
	private String toCustomerName;

	@Column(name = "amount")
	private double amount;

	@Column(name = "rate")
	private double rate;

	@Column(name = "exchange_amount")
	private double exchangeAmount;

	@Column(name = "currency_pair")
	private String currencyPair;

	public Trade() {
		super();
	}

	public Trade(Long id, String fromCustomerName, String toCustomerName, double amount, double rate,
			double exchangeAmount, String currencyPair) {
		super();
		this.id = id;
		this.fromCustomerName = fromCustomerName;
		this.toCustomerName = toCustomerName;
		this.amount = amount;
		this.rate = rate;
		this.exchangeAmount = exchangeAmount;
		this.currencyPair = currencyPair;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromCustomerName() {
		return fromCustomerName;
	}

	public void setFromCustomerName(String fromCustomerName) {
		this.fromCustomerName = fromCustomerName;
	}

	public String getToCustomerName() {
		return toCustomerName;
	}

	public void setToCustomerName(String toCustomerName) {
		this.toCustomerName = toCustomerName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getExchangeAmount() {
		return exchangeAmount;
	}

	public void setExchangeAmount(double exchangeAmount) {
		this.exchangeAmount = exchangeAmount;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", fromCustomerName=" + fromCustomerName + ", toCustomerName=" + toCustomerName
				+ ", amount=" + amount + ", rate=" + rate + ", exchangeAmount=" + exchangeAmount + ", currencyPair="
				+ currencyPair + "]";
	}

}