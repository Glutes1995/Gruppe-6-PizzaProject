import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test features manuelt her inde\n");
        //For eksempel har jeg testet ting, der skal vise noget
        //Man kan bare slette hvad end der er her i main og teste det man nu skal have testet"

        PizzaMenu pizzaMenu = new PizzaMenu();
        Scanner scanner = new Scanner(System.in);

        pizzaMenu.addPizza("Margarita",49,1,"Tomato sauce, Cheese");
        System.out.println(pizzaMenu);

        pizzaMenu.removePizza(1);
        System.out.println(pizzaMenu);

        Pizza pizza = new Pizza("Meat lover", 69, 2);
        System.out.println(pizza);

        //Test OrderList og Order klasserne
        pizzaMenu.addPizza("Margarita",49,1,"Tomato sauce, Cheese");
        System.out.println(pizzaMenu);

        OrderList orderList = new OrderList();

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println("OrderList1: ");
        System.out.println(orderList);

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println("OrderList2: ");
        System.out.println(orderList);

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println("OrderList3: ");
        System.out.println(orderList);
    }
}