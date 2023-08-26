package currencyTask;

public class Trade {
	private static int tradeCount = 0;

    private int tradeNo;
    private String currencyPair;
    private String customerName;
    private double amount;
    private double rate;

    public Trade(String currencyPair, String customerName, double amount, double rate) {
        this.tradeNo = ++tradeCount;
        this.currencyPair = currencyPair;
        this.customerName = customerName;
        this.amount = amount;
        this.rate = rate;
    }

	public int getTradeNo() {
		return tradeNo;
	}

	public String getCurrencyPair() {
		return currencyPair;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAmount() {
		return amount;
	}

	public double getRate() {
		return rate;
	}
}
