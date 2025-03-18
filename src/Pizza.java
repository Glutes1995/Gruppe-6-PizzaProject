public class Pizza {
    private String name;
    private int price;
    private String topping;

    public Pizza(String name, int price, String topping) {
        this.name = name;
        this.price = price;
        this.topping = topping;
    }

    //Getters for Pizza attributes
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getToppings() {
        return topping;
    }

    //Sets Pizza price
    public void setPrice(int price) {
        this.price = price;
    }

    //toString override to print Pizzas
    public String toString() {
        return name + ": " + topping + "..........................." + price + ",-";
    }
}