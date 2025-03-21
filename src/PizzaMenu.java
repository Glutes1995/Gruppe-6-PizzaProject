import java.util.ArrayList;

public class PizzaMenu {
    //PizzaMenu instansvariabel
    private ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    //Metoden tilføjer alle pizzaerne på menukortet til et PizzaMenu objekt
    public void addPizzaMenu(PizzaMenu pizzaMenu) {
        pizzaMenu.addPizza("Margarita",49,1,"Tomato sauce, Cheese");
        pizzaMenu.addPizza("Hawaii", 55, 2,"Tomato sauce, Cheese, Ham, Pineapple");
        pizzaMenu.addPizza("Pep dress", 55, 3,"Tomato sauce, Cheese, Pepperoni, Dressing");
        pizzaMenu.addPizza("Marios recommended",60, 4,"Tomato sauce, Cheese, Ham, Pepperoni");
        pizzaMenu.addPizza("Meat lover", 69, 5, "Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Beef, Chicken");
        pizzaMenu.addPizza("Kea special", 75, 6,"Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Dressing");
        pizzaMenu.addPizza("Giga chad", 75, 7,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("The rizzler", 75, 8,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Hangover", 75, 9,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Worse hangover", 80, 10,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("worst hangover", 85, 11,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Pineapple lover", 90, 12,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Bacon paradise", 95, 13,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Potato dream", 95, 14,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("The spicy one", 99, 15,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Mystery pizza", 102, 16,"Tomato sauce, Cheese,");

    }

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