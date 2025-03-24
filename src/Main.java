import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizzaMenu pizzaMenu = new PizzaMenu();
        pizzaMenu.addPizzaMenu();
        System.out.println(pizzaMenu);

        OrderList orderList = new OrderList();

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println(orderList);

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println(orderList);

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println(orderList);

        orderList.removeOrder(scanner);
        System.out.println(orderList);

        orderList.saveOrder();
        orderList.saveOrder();

        orderList.orderRevenue();
    }
}