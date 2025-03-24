import java.util.ArrayList;
import java.util.Scanner;

public class OrderList {
    //OrderList instansvariable
    private ArrayList<Order> orderList = new ArrayList<>();
    private ArrayList<Order> orderHistoryList = new ArrayList<>();

    //metode til at beregne dagens omsætning. Altså beregne alle odrepriser på ordrehistorikken
    public void orderRevenue() {
        int sum = 0;
        for (Order order : orderHistoryList) {
            sum += order.sumPizzaPrices();
        }
        System.out.println("Daily revenue: " + sum + ",-\n");
    }

    //denne metode kan tilføje et givent odre-objekt til ordre-listen
    void addOrder(PizzaMenu menu, Scanner scanner){
        Order order = new Order();
        System.out.println("Enter the name or number of a pizza or type done to end the order.");
        String userInput = scanner.nextLine();

        //tilføjer pizzaer til odren indtil man skriver done
        while(!userInput.equalsIgnoreCase("done")){
            //try catch fanger fejl ved at omdanne en String til en Integer
            try{
                int pizzaNumber = Integer.parseInt(userInput);
                order.addPizza(menu, pizzaNumber);
            }catch(NumberFormatException e){
                order.addPizza(menu, userInput);
            }

            System.out.println("Enter the name or number of a pizza or type done to end the order.");
            userInput = scanner.nextLine();
        }

        order.addOrderDeliveryTime(scanner);
        orderList.add(order);
        this.sortOrders();
    }

    //metode til at fjerne en ordre fra ordrelisten
    public void removeOrder(Scanner scanner) {
        System.out.println("Order id?");
        int orderID = scanner.nextInt();
        scanner.nextLine();
        if (!isOrderOnList(orderID)) return;
        for (Order order : orderList) {
            if (orderID == order.getOrderID()) orderList.remove(order);
            System.out.println("Order " + order.getOrderID() + " has been removed\n");
            return;
        }
    }

    //metode til at rykke en færdig ordre over på ordrehistorikken
    public void saveOrder() {
        for (Order order : orderList) {
            orderList.remove(order);
            orderHistoryList.add(order);
            System.out.println("order " + order.getOrderID() + " has been saved in the order history\n");
            break;
        }
    }

    //metoden checker om en given ordre er på ordrelisten
    public boolean isOrderOnList(int orderID) {
        for (Order order : orderList) {
            if (orderID == order.getOrderID()) return true;
        }
        System.out.println("Order not found\n");
        return false;
    }

    //metoden sorterer Order objekter i orderlisten. Ved at  et Order objekt til compareTo metoden, kan den sammenligne dem.
    public void sortOrders() {
        orderList.sort(Order::compareTo);
    }

    //OrderList toString override til at printe alle odre på ordre listen
    public String toString() {
        String orders = "";
        for (Order order : orderList) {
            orders += order + "\n";
        }
        return orders;
    }
}