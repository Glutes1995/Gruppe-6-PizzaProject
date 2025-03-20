public class Main {
    public static void main(String[] args) {
        System.out.println("Test features manuelt her inde\n");
        //For eksempel har jeg testet ting, der skal vise noget
        //Man kan bare slette hvad end der er her i Main og teste det man nu skal have testet"

        PizzaMenu pizzaMenu = new PizzaMenu();
        Pizza pizza = new Pizza("Margarita",49,1);

        pizzaMenu.addPizza("Margarita",49,1);
        System.out.println(pizzaMenu);

        pizzaMenu.removePizza(1);
        System.out.println(pizzaMenu);
    }
}