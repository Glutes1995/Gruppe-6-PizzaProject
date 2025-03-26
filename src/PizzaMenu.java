import java.util.ArrayList;
import java.util.Scanner;

public class PizzaMenu {
    //PizzaMenu instansvariabel
    private ArrayList<Pizza> pizzaMenu = new ArrayList<>();

    //Metoden tilføjer menukortet til et PizzaMenu objekt
    public void addPizzaMenu() {
        this.addPizza("Margarita",49,1,"Tomato sauce, Cheese...............................................");
        this.addPizza("Hawaii", 55, 2,"Tomato sauce, Cheese, Ham, Pineapple..................................");
        this.addPizza("Pep dress", 55, 3,"Tomato sauce, Cheese, Pepperoni, Dressing..........................");
        this.addPizza("Marios recommended",60, 4,"Tomato sauce, Cheese, Ham, Pepperoni.......................");
        this.addPizza("Meat lover", 69, 5, "Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Beef, Chicken.......");
        this.addPizza("Kea special", 75, 6,"Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Dressing............");
        this.addPizza("Giga chad", 75, 7,"Tomato sauce, Cheese, flank steak, parmigiano......................");
        this.addPizza("The rizzler", 75, 8,"Tomato sauce, Cheese, Chicken, Bacon, Pepperoni..................");
        this.addPizza("Hangover", 75, 9,"Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Dressing");
        this.addPizza("Worse hangover", 80, 10,"Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Chicken, Dressing");
        this.addPizza("worst hangover", 85, 11,"Tomato sauce, Cheese, Extra cheese, Pepperoni, Dressing");
        this.addPizza("Pineapple lover", 90, 12,"Tomato sauce, Cheese, Pepperoni, Pineapple, Chili");
        this.addPizza("Bacon paradise", 95, 13,"Tomato sauce, Cheese, Bacon, Mushroom, Garlic");
        this.addPizza("Potato dream", 95, 14,"Tomato sauce, Cheese, Potato, Bacon, Rosemary");
        this.addPizza("The spicy one", 99, 15,"Tomato sauce, Cheese, Ham, Pepperoni, chili");
        this.addPizza("Mystery pizza", 102, 16,"Tomato sauce, Cheese, + Chefs choise");
        this.addPizza("4 cheeses",100, 17,"Tomato sauce, Cheese, Emmental, Parmigiano, Gorgonzola");
        this.addPizza("Trouble truffel",100, 18,"Tomato sauce, Cheese, Ham, Mushroom, Onion, Truffle");
        this.addPizza("Garlic",80, 19,"Tomato sauce, Cheese, Ham, Garlic");
        this.addPizza("Mushroom",100, 20,"Tomato sauce, Cheese, Ham, Mushroom");
        this.addPizza("Veggie",100, 21,"Tomato sauce, Cheese, Eggplant, Zucchini, Sundried tomato, Spinach");
        this.addPizza("Vegan special",100, 22,"Tomato sauce, Eggplant, Mushroom, Zucchini, Fresh tomato, Spinach ");
        this.addPizza("Vegan tropical",100, 23,"Tomato sauce, Cheese, Peppers, Zucchini, Pineapple, Garlic");
        this.addPizza("Gluten free",100, 24,"Tomato sauce, Cheese, Ham, Pepperoni, Onion");
        this.addPizza("August special",100, 25,"Tomato sauce, Cheese, Ham, Chocolate");
        this.addPizza("Joshua special",100, 26,"Tomato sauce, Cheese, Kebab, Salad, Tomato, Dressing");
        this.addPizza("Simon special",100, 27,"Tomato sauce, Cheese, Ham, Bacon, Pepperoni, Mushroom");
        this.addPizza("Martin special",100, 28,"Tomato sauce, Cheese, Pepperoni, Pineapple, Garlic, Chili");
        this.addPizza("Group 6 special",100, 29,"Tomato sauce, Cheese, Chocolate, Dressing, Mushroom, Pineapple");
        this.addPizza("The indian",100, 30,"Tomato sauce, Cheese, Butter chicken, Cashew sauce,");
        this.addPizza("Manhatten",100, 31,"Tomato sauce, Cheese, Beef, Bacon, Pepperoni");
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
            if (pizzaNumber == pizza.getPizzaNumber()) return true;
        }
        return false;
    }

    //Overload af isPizzaOnList, som kan modtage string/pizza navn
    public boolean isPizzaOnList(String name) {
        for (Pizza pizza : pizzaMenu) {
            if (name.equalsIgnoreCase(pizza.getName())) return true;
        }
        return false;
    }

    //getPizzaMenu er en metode der returnerer pizzaMenu arraylisten så man kan få listen af pizzaer på menukortet
    public ArrayList<Pizza> getPizzaMenu() {
        return pizzaMenu;
    }

    //changePrice er en metode, der lader brugeren ændre prisen på en given pizza
    public void changePrice(Scanner scanner) {
        System.out.println("Hvilken pizza ønsker du at ændre pris på?\n");
        String userChoice = scanner.nextLine();

        //gør det muligt at indtaste enten ID eller pizzanavn
        try {
            int pizzaNumber = Integer.parseInt(userChoice);

            //Tjekker om pizzaen er på menuen
            if (!isPizzaOnList(pizzaNumber)) {
                System.out.println("Pizzaen kunne ikke findes\n");
                return;
            }

            //Ændrer pris med ID
            for (Pizza pizza : pizzaMenu) {
                if (pizza.getPizzaNumber() == pizzaNumber) {
                    System.out.println("Prisen er nu " + pizza.getPrice() +
                            " Hvad kunne du godt tænke dig at ændre prisen til?");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine();
                    pizza.setPrice(newPrice);
                    System.out.println("Prisen er nu opdateret til " + newPrice);
                    return;
                }
            }
        } catch (NumberFormatException e) {
            if (!isPizzaOnList(userChoice)) {
                System.out.println("Pizzaen kunne ikke findes");
                return;
            }
            //Ændrer pris med pizzanavn
            for (Pizza pizza : pizzaMenu) {
                if (pizza.getName().equalsIgnoreCase(userChoice)) {
                    System.out.println("Prisen er nu " + pizza.getPrice() +
                            " Hvad kunne du godt tænke dig at ændre prisen til?");
                    int newPrice = scanner.nextInt();
                    scanner.nextLine();
                    pizza.setPrice(newPrice);
                    System.out.println("Prisen er nu opdateret til " + newPrice);
                    return;
                }
            }
        }
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
