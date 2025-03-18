public class Pizza {
    private String name;
    private double price;
    private String toppings;

    public Pizza() {
        name = "Margarita";
        price = 65;
        toppings = "Tomato sauce, cheese";
    }

    public Pizza(String name, double price, String toppings) {
        this.name = name;
        this.price = price;
        this.toppings = toppings;
    }
    //Getters for Pizza attributes
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getToppings() {
        return toppings;
    }
    //Setter for Pizza price
    public void setPrice(double price) {
        this.price = price;
    }
    //toString override to print Pizzas
    public String toString() {
        return name + "\n" + toppings + "\n" + price + " kr";
    }
}
