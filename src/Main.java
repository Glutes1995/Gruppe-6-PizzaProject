import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizzaMenu pizzaMenu = new PizzaMenu();
        pizzaMenu.addPizzaMenu(pizzaMenu);

        System.out.print(pizzaMenu);

        OrderList orderList = new OrderList();

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println(orderList);

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println(orderList);

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println(orderList);
    }
}