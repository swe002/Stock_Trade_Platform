class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void updatePrice() {
        double change = (Math.random() - 0.5) * 10;
        price += change;
        if (price < 1) price = 1;
    }
}