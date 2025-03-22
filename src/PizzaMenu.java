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
        pizzaMenu.addPizza("Giga chad", 75, 7,"Tomato sauce, Cheese, flank steak, parmigiano");
        pizzaMenu.addPizza("The rizzler", 75, 8,"Tomato sauce, Cheese, Chicken, Bacon, Pepperoni");
        pizzaMenu.addPizza("Hangover", 75, 9,"Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Dressing");
        pizzaMenu.addPizza("Worse hangover", 80, 10,"Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Chicken, Dressing");
        pizzaMenu.addPizza("worst hangover", 85, 11,"Tomato sauce, Cheese, Extra cheese, Pepperoni, Dressing");
        pizzaMenu.addPizza("Pineapple lover", 90, 12,"Tomato sauce, Cheese, Pepperoni, Pineapple, Chili");
        pizzaMenu.addPizza("Bacon paradise", 95, 13,"Tomato sauce, Cheese, Bacon, Mushroom, Garlic");
        pizzaMenu.addPizza("Potato dream", 95, 14,"Tomato sauce, Cheese, Potato, Bacon, Rosemary");
        pizzaMenu.addPizza("The spicy one", 99, 15,"Tomato sauce, Cheese, Ham, Pepperoni, chili");
        pizzaMenu.addPizza("Mystery pizza", 102, 16,"Tomato sauce, Cheese, + Chefs choise");
        pizzaMenu.addPizza("4 cheeses",100, 17,"Tomato sauce, Cheese, Emmental, Parmigiano, Gorgonzola");
        pizzaMenu.addPizza("Trouble truffel",100, 18,"Tomato sauce, Cheese, Ham, Mushroom, Onion, Truffle");
        pizzaMenu.addPizza("Garlic",80, 19,"Tomato sauce, Cheese, Ham, Garlic");
        pizzaMenu.addPizza("Mushroom",100, 20,"Tomato sauce, Cheese, Ham, Mushroom");
        pizzaMenu.addPizza("Veggie",100, 21,"Tomato sauce, Cheese, Eggplant, Zucchini, Sundried tomato, Spinach");
        pizzaMenu.addPizza("Vegan special",100, 22,"Tomato sauce, Eggplant, Mushroom, Zucchini, Fresh tomato, Spinach ");
        pizzaMenu.addPizza("Vegan tropical",100, 23,"Tomato sauce, Cheese, Peppers, Zucchini, Pineapple, Garlic");
        pizzaMenu.addPizza("Gluten free",100, 24,"Tomato sauce, Cheese, Ham, Pepperoni, Onion");
        pizzaMenu.addPizza("August special",100, 25,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Joshua special",100, 26,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Simon special",100, 27,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Martin special",100, 28,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("Group 6 special",100, 29,"Tomato sauce, Cheese,");
        pizzaMenu.addPizza("The indian",100, 30,"Tomato sauce, Cheese, Butter chicken, Cashew sauce,");
        pizzaMenu.addPizza("Manhatten",100, 31,"Tomato sauce, Cheese, Beef, Bacon, Pepperoni");
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