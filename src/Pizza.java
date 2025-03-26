public class Pizza {
    //Pizza instansvariable
    private String name;
    private int price;
    private int pizzaNumber;
    private String topping;

    //Pizza constructor til pizzaerne, der skal tilføjes til menukortet
    public Pizza(String name, int price, int pizzaNumber, String topping) {
        this.name = name;
        this.price = price;
        this.pizzaNumber = pizzaNumber;
        this.topping = topping;
    }

    Pizza(Pizza pizza){
        this.name = pizza.name;
        this.price = pizza.price;
        this.pizzaNumber = pizza.pizzaNumber;
        this.topping = pizza.topping;
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

    //Setter til en pizzas pris, så man kan ændre i priserne på menukortet
    public void setPrice(int price) {
        this.price = price;
    }

    //Pizza toString override til at printe en pizzas navn
    public String toString() {
        return name;
    }
}