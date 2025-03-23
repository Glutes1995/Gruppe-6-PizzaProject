public class Main {
    public static void main(String[] args) {
        System.out.println("Test features manuelt her inde\n");
        //For eksempel har jeg testet ting, der skal vise noget
        //Man kan bare slette hvad end der er her i main og teste det man nu skal have testet"

        PizzaMenu pizzaMenu = new PizzaMenu();

        pizzaMenu.addPizza("Margarita",49,1,"Tomato sauce, Cheese");
        System.out.println(pizzaMenu);

        pizzaMenu.removePizza(1);
        System.out.println(pizzaMenu);

        Pizza pizza = new Pizza("Meat lover", 69, 2);
        System.out.println(pizza);

        //pizza order og orderList test
        OrderList orderList = new OrderList();

        pizzaMenu.addPizza("Margarita",49,1,"Tomato sauce, Cheese");
        System.out.println(pizzaMenu);
        System.out.println("*" + orderList.toString());

        Order order = new Order();

        //addPizza test. Tester metoden med pizza-name og med pizza-number
        order.addPizza(pizzaMenu, "margarita");
        System.out.println("pizza-name" + order.toString());

        order.addPizza(pizzaMenu, 1);
        System.out.println("pizza-number" + order.toString());
    }
}