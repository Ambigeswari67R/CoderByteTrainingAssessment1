package currencyTask;

import java.util.Scanner;

public class FxTradingApp  {
	public static void main(String[] args) {
	
		UsdToInr usdtoinr=new UsdToInr();      // USD into  Indian Rupee
		//EuroToInr eurotoinr=new EuroToInr();  European Currency into Indian Rupee 
		
		Scanner scanner = new Scanner(System.in);
        int choice;

        do {
        	displayOptions();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    usdtoinr.bookTrade();
                    break;
                case 2:
                    usdtoinr.printTrades();
                    break;
                case 3:
                    System.out.print("Do you really want to exit (y/n): ");
                    if (scanner.next().equalsIgnoreCase("y")) {
                    	System.out.println("Bye - have a good day");
                        return;
                    }   
                   break;
                 
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    
            }
        } while (true);
    }

	private static void displayOptions() {
		System.out.println("1. Book Trade");
        System.out.println("2. Print Trades");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
		
	}

}


