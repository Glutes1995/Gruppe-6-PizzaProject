public class Main {
    public static void main(String[] args) {
        System.out.println("Test features manuelt her inde\n");
        //For eksempel har jeg testet ting, der skal vise noget
        //Man kan bare slette hvad end der er her i main og teste det man nu skal have testet"

        PizzaMenu pizzaMenu = new PizzaMenu();
        pizzaMenu.addPizzaMenu(pizzaMenu);
        System.out.println(pizzaMenu);
    }
}