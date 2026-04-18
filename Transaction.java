class Transaction {
    String type;
    String stockName;
    int quantity;
    double price;

    Transaction(String type, String stockName, int quantity, double price) {
        this.type = type;
        this.stockName = stockName;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println(type + " | " + stockName + " | Qty: " + quantity + " | Price: " + price);
    }
}