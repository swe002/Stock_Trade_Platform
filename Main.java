import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stock s1 = new Stock("TCS", 3500);
        Stock s2 = new Stock("INFY", 1500);
        Stock s3 = new Stock("RELIANCE", 2800);

        ArrayList<Stock> market = new ArrayList<>();
        market.add(s1);
        market.add(s2);
        market.add(s3);

        User user = new User();

        while (true) {
            System.out.println("\n--- Stock Trading Platform ---");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            // Update prices each loop
            for (Stock s : market) {
                s.updatePrice();
            }

            switch (choice) {
                case 1:
                    for (int i = 0; i < market.size(); i++) {
                        System.out.println(i + ". " + market.get(i).name + " - " + market.get(i).price);
                    }
                    break;

                case 2:
                    System.out.print("Enter stock index: ");
                    int buyIndex = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    user.buyStock(market.get(buyIndex), qty);
                    break;

                case 3:
                    System.out.print("Enter stock index: ");
                    int sellIndex = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty2 = sc.nextInt();
                    user.sellStock(market.get(sellIndex), qty2);
                    break;

                case 4:
                    user.showPortfolio();
                    break;

                case 5:
                    user.showHistory();
                    break;

                case 6:
                    sc.close();
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}