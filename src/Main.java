public class Main {
    public static void main(String[] args) {
        System.out.println("Test features manuelt her inde\n");
        //For eksempel har jeg testet ting, der skal vise noget
        //Man kan bare slette hvad end der er her i main og teste det man nu skal have testet"

        PizzaMenu pizzaMenu = new PizzaMenu();
        pizzaMenu.addPizzaMenu(pizzaMenu);
        System.out.println(pizzaMenu);

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();
        System.out.println(order1);
        System.out.println(order2);
        System.out.println(order3);
        System.out.println(order4);
    }
}