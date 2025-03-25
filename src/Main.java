import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PizzaMenu menu = new PizzaMenu();
        menu.addPizzaMenu();
        System.out.println(menu);

        menu.changePrice(scanner);
        System.out.println(menu);

        OrderList orderList = new OrderList();
        orderList.addOrder(menu, scanner);
        System.out.println(orderList);

        orderList.addOrder(menu, scanner);
        System.out.println(orderList);

        orderList.removeOrder(scanner);
        System.out.println(orderList);

        orderList.saveOrder();

        orderList.orderRevenue();
    }
}