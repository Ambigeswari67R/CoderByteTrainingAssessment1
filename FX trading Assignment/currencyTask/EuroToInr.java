package currencyTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import task.Trade;

public class EuroToInr implements ForAnyCurrency{
    List<Trade> trades = new ArrayList<>();
	
	private static double euroToInrRate = 79.50;
    Scanner scanner=new Scanner(System.in);
	
	public void bookTrade() {
		
		System.out.print("Enter customer Name: ");
        String customerName = scanner.next();
        scanner.nextLine();
        System.out.print("Enter Currency Pair (EUROINR): ");
        String currencyPair = scanner.next();
        if (!currencyPair.equalsIgnoreCase("EUROINR")) {
            System.out.println("Invalid currency pair. Only EUROINR is supported.");
            return;
        }

        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();

        System.out.print("Do you want to get Rate (Yes/No): ");
        boolean getRate = scanner.next().equalsIgnoreCase("yes");
        double rate = euroToInrRate;

        if (getRate) {
            System.out.print("Enter rate: ");
            rate = scanner.nextDouble();
        }

        double inrAmount = amount * rate;

        System.out.println("You are transferring INR " + formatAmount(inrAmount) + " to " + customerName);
        System.out.print("Book/Cancel this trade (Book/Cancel): ");
        String decision = scanner.next();

        if (decision.equalsIgnoreCase("Book")) {
            Trade trade = new Trade(currencyPair, customerName, inrAmount, rate);
            trades.add(trade);
            System.out.println("Trade for " + currencyPair + " has been booked with rate " + rate +
                    ", The amount of Rs " + formatAmount(inrAmount) + " will be transferred in 2 working days to " + customerName + ".");
        } else if (decision.equalsIgnoreCase("Cancel")) {
            System.out.println("Trade is Canceled.");
        } else {
            System.out.println("Invalid choice. Trade not booked.");
        }
		
	}

	
	public void printTrades() {
		System.out.println("TradeNo CurrencyPair CustomerName Amount Rate");
        for (Trade trade : trades) {
            System.out.println(trade);
        }
		
	}
	private static String formatAmount(double amount) {
        return String.format("%.2f", amount);
    }

}
