package com.FxTradingAssignment.FxTradingMicroService.model;

public class Trade {
	
	private static double usdToInrRate = 66.00;
	private int tradeNo;
	private String currencyPair;
	private String customerName;
	private double amount;
	private String rate;
	private String confirmation;
	private String rateMsg;
	private String bookedMsg;
	private String currencyMsg;

	public Trade() {

	}

	public Trade(String currencyPair, String customerName, double amount, String rate) {
		this.currencyPair = currencyPair;
		this.customerName = customerName;
		this.amount = amount;
		this.rate = rate;
	}

	
	public static double getUsdToInrRate() {
		return usdToInrRate;
	}

	public static void setUsdToInrRate(double usdToInrRate) {
		Trade.usdToInrRate = usdToInrRate;
	}

	public int getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(int tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public void bookTrade(Trade trade) {
		double inrAmount = amount * usdToInrRate;
		if (currencyPair.equalsIgnoreCase("USDINR")) {

			if (trade.getRate().equalsIgnoreCase("yes")) {
				rateMsg = "You are transferring INR " + formatAmount(inrAmount) + " to " + customerName + ".\n";
			}
			if (trade.getConfirmation().equalsIgnoreCase("book")) {
				bookedMsg = "Trade for " + currencyPair + " has been booked with rate " + usdToInrRate
						+ ", The amount of Rs " + formatAmount(inrAmount) + " will be transferred in 2 working days to "
						+ customerName + ".\n";
			} else {
				bookedMsg = "Trade is cancelled";
			}
		} else {
			currencyMsg = "Invalid currency pair. Only USDINR is supported.\n";
		}
	}

	public String printTrade() {
		if (currencyMsg != null) {
			return currencyMsg;
		}
		if (rateMsg != null) {
			return rateMsg + bookedMsg;
		}
		return bookedMsg;
	}

	@Override
	public String toString() {
		return "Trade [tradeNo=" + tradeNo + ", currencyPair=" + currencyPair + ", customerName=" + customerName
				+ ", amount=" + amount + ", rate=" + usdToInrRate + "]";
	}

	private static String formatAmount(double amount) {
		return String.format("%.2f", amount);
	}

}
