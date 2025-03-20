public class Pizza {
    private String name;
    private int price;
    private int pizzaNumber;

    public Pizza(String name, int price, int pizzaNumber) {
        this.name = name;
        this.price = price;
        this.pizzaNumber = pizzaNumber;
    }

    //Getters for Pizza attributes
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPizzaNumber() {
        return pizzaNumber;
    }

    //Sets Pizza price
    public void setPrice(int price) {
        this.price = price;
    }

    //toString override to print Pizzas
    public String toString() {
        return name + ": ";
    }
}