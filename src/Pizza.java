public class Pizza {
    private String name;
    private int price;
    private String toppings;

    public Pizza() {
        name = "Margarita";
        price = 65;
        toppings = "Tomato sauce, cheese";
    }

    public Pizza(String name, int price, String toppings) {
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

    //Sets Pizza price
    public void setPrice(int price) {
        this.price = price;
    }

    //toString override to print Pizzas
    public String toString() {
        return name + ": " + toppings + "..........................." + price + ",-";
    }
}