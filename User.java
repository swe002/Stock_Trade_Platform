import java.util.*;

class User {
    double balance = 10000;
    HashMap<String, Integer> portfolio = new HashMap<>();
    ArrayList<Transaction> history = new ArrayList<>();

    void buyStock(Stock stock, int qty) {
        double cost = stock.price * qty;

        if (cost > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        balance -= cost;
        portfolio.put(stock.name, portfolio.getOrDefault(stock.name, 0) + qty);
        history.add(new Transaction("BUY", stock.name, qty, stock.price));

        System.out.println("Stock bought successfully!");
    }

    void sellStock(Stock stock, int qty) {
        int owned = portfolio.getOrDefault(stock.name, 0);

        if (qty > owned) {
            System.out.println("Not enough shares!");
            return;
        }

        balance += stock.price * qty;
        portfolio.put(stock.name, owned - qty);
        history.add(new Transaction("SELL", stock.name, qty, stock.price));

        System.out.println("Stock sold successfully!");
    }

    void showPortfolio() {
        System.out.println("\nPortfolio:");
        for (String stock : portfolio.keySet()) {
            System.out.println(stock + " → " + portfolio.get(stock));
        }
        System.out.println("Balance: " + balance);
    }

    void showHistory() {
        System.out.println("\nTransaction History:");
        for (Transaction t : history) {
            t.display();
        }
    }
}