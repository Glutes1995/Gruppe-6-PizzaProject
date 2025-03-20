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

    //Getters for at kunne tilgå Pizza attributes/instansvariable udenfor Pizza klassen
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getPizzaNumber() {
        return pizzaNumber;
    }

    //Sætter Pizza price
    public void setPrice(int price) {
        this.price = price;
    }

    //Pizza toString override til at printe en pizzas navn
    public String toString() {
        return name;
    }
}