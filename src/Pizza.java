public class Pizza {
    //Pizza instansvariable
    private String name;
    private int price;
    private int pizzaNumber;

    //Pizza constructor
    public Pizza(String name, int price, int pizzaNumber) {
        this.name = name;
        this.price = price;
        this.pizzaNumber = pizzaNumber;
    }

    //Getters for Pizza attributes/instansvariable
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

    //toString override to print a Pizzas name
    public String toString() {
        return name;
    }
}