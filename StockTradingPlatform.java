import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    String stockName;
    int quantity;
    double price;

    Portfolio(String stockName, int quantity, double price) {
        this.stockName = stockName;
        this.quantity = quantity;
        this.price = price;
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Stock> market = new ArrayList<>();
        ArrayList<Portfolio> portfolio = new ArrayList<>();

        // Available Stocks
        market.add(new Stock("TCS", 3500));
        market.add(new Stock("Infosys", 1600));
        market.add(new Stock("Reliance", 2900));
        market.add(new Stock("HDFC", 1800));

        int choice;

        do {

            System.out.println("\n========== STOCK TRADING PLATFORM ==========");
            System.out.println("1. View Market Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n----- Market Stocks -----");

                    for (Stock s : market) {
                        System.out.println(s.name + " : ₹" + s.price);
                    }
                    break;

                case 2:

                    System.out.print("Enter Stock Name: ");
                    String buyName = sc.nextLine();

                    boolean found = false;

                    for (Stock s : market) {

                        if (s.name.equalsIgnoreCase(buyName)) {

                            System.out.print("Enter Quantity: ");
                            int qty = sc.nextInt();

                            portfolio.add(new Portfolio(s.name, qty, s.price));

                            System.out.println("Stock Purchased Successfully!");

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Stock Not Found!");
                    }

                    break;

                case 3:

                    System.out.print("Enter Stock Name to Sell: ");
                    String sellName = sc.nextLine();

                    boolean sold = false;

                    for (int i = 0; i < portfolio.size(); i++) {

                        if (portfolio.get(i).stockName.equalsIgnoreCase(sellName)) {

                            portfolio.remove(i);

                            System.out.println("Stock Sold Successfully!");

                            sold = true;
                            break;
                        }
                    }

                    if (!sold) {
                        System.out.println("Stock Not Found in Portfolio!");
                    }

                    break;

                case 4:

                    if (portfolio.isEmpty()) {

                        System.out.println("Portfolio is Empty!");
                        break;
                    }

                    double totalValue = 0;

                    System.out.println("\n------ YOUR PORTFOLIO ------");

                    for (Portfolio p : portfolio) {

                        double value = p.quantity * p.price;

                        totalValue += value;

                        System.out.println(
                                p.stockName +
                                " | Quantity: " + p.quantity +
                                " | Price: ₹" + p.price +
                                " | Value: ₹" + value);
                    }

                    System.out.println("--------------------------------");
                    System.out.println("Total Portfolio Value: ₹" + totalValue);

                    break;

                case 5:
                    System.out.println("Thank You for using Stock Trading Platform!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}