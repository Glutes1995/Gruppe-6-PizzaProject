public class Pizza {
    //Pizza instansvariable
    private String name;
    private int price;
    private int pizzaNumber;
    private String topping;

    //Pizza constructor til pizzaerne, der skal tilføjes til orderen
    public Pizza(String name, int price, int pizzaNumber) {
        this.name = name;
        this.price = price;
        this.pizzaNumber = pizzaNumber;
    }

    //Pizza constructor til pizzaerne, der skal tilføjes til menukortet
    public Pizza(String name, int price, int pizzaNumber, String topping) {
        this.name = name;
        this.price = price;
        this.pizzaNumber = pizzaNumber;
        this.topping = topping;
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

    public String getTopping() {
        return topping;
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