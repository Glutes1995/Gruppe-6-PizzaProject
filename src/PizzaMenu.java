import java.util.ArrayList;

public class PizzaMenu {
    //PizzaMenu instansvariabel
    private ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    //metode til at tilføje pizzaer til menukortet
    public void addPizza(String name, int price, int pizzaNumber, String topping) {
        Pizza pizza = new Pizza(name, price, pizzaNumber, topping);
        pizzaMenu.add(pizza);
    }

    //metode til at fjerne pizzaer fra menukortet baseret på deres tal
    public void removePizza(int pizzaNumber) {
        if (!isPizzaOnList(1)) {
            System.out.println("The pizza you are trying to remove is not on the menu");
            return;
        }
        for (Pizza pizza : pizzaMenu) {
            if (pizzaNumber == pizza.getPizzaNumber()) {
                pizzaMenu.remove(pizza);
                System.out.println(pizza.getName() + " has been removed from the pizza menu\n");
                return;
            }
        }
    }

    //metode til at checke om en pizza overhovedet er på menukortet
    public boolean isPizzaOnList(int pizzaNumber) {
        for (Pizza pizza : pizzaMenu) {
            if ( pizzaNumber == pizza.getPizzaNumber()) return true;
        }
        return false;
    }

    //PizzaMenu toString override til at printe menukortet
    public String toString() {
        String pizzas = "PIZZA MENU\n";
        for (Pizza pizza : pizzaMenu) {
            pizzas += pizza.getPizzaNumber() + ". " + pizza + ": " + pizza.getTopping() + "............." + pizza.getPrice() + ",-\n";
        }
        return pizzas;
    }
}