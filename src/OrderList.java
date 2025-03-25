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
        System.out.println("Dagens omsætning er: " + sum + ",-\n");
    }

    // Metode til at finde og vise den mest solgte pizza
    public void mostSoldPizza() {

        //Bruges til at gemme antal pizza solgt og sætte navnet på mest pizza solgt
        int maxCount = 0;
        String mostRepeatedName = "";

        // Ydre loop: Går gennem hver ordre i ordrehistorikken
        for (Order orderI : orderHistoryList) {

            // Loop gennem alle pizzaer i den aktuelle ordre
            for (Pizza pizzaI : orderI.pizzaList) {

                // Tager bare navnet på en pizza og looper hver gang den kommer i loopet
                // Gemmer hvor mange gange denne pizza optræder i hele ordrehistorikken
                String currentName = pizzaI.getName();
                int count = 0;

                // Nyt loop som tæller pizzaerne
                for (Order orderN : orderHistoryList) {

                    // Loop gennem alle pizzaer i hver af disse ordrer
                    for (Pizza pizzaN : orderN.pizzaList) {

                        // Hvis navnet matcher den pizza vi tæller på, læg én til tælleren
                        if (pizzaN.getName().equals(currentName)) {
                            count++;
                        }
                    }
                }
                //Gemmer pizzanavnet og antal solgte gange
                // Hvis loopet har fundet en pizza der er solgt mere end en anden så -
                // - opdaterer den både tælleren og navnet
                if (count > maxCount) {
                    maxCount = count;
                    mostRepeatedName = currentName;
                }
            }
        }
        // Printer outputtet af loops
        System.out.println("Mest solgte pizza er: " + mostRepeatedName + " (" + maxCount + " solgte)\n");
    }


    //denne metode kan tilføje et givent odre-objekt til ordre-listen
    void addOrder(PizzaMenu menu, Scanner scanner) {
        Order order = new Order();
        System.out.println("Indtast navnet eller nummer på pizzaen. Indtast done til at afslutte bestillingen.");
        String userInput = scanner.nextLine();

        //tilføjer pizzaer til odren indtil man skriver done
        while (!userInput.equalsIgnoreCase("done")) {
            //try catch fanger fejl ved at omdanne en String til en Integer
            try {
                int pizzaNumber = Integer.parseInt(userInput);
                order.addPizza(menu, pizzaNumber);
            } catch (NumberFormatException e) {
                order.addPizza(menu, userInput);
            }

            System.out.println("Indtast navnet eller nummer på pizzaen. Indtast done til at afslutte bestillingen.");
            userInput = scanner.nextLine();
        }
        order.addOrderDeliveryTime(scanner);
        orderList.add(order);
        this.sortOrders();
    }

    //metode til at fjerne en ordre fra ordrelisten
    public void removeOrder(Scanner scanner) {
        System.out.println("Skriv nummeret på ordren du ønsker at fjerne");
        int orderID = scanner.nextInt();
        scanner.nextLine();
        if (!isOrderOnList(orderID)) return;
        for (Order order : orderList) {
            if (orderID == order.getOrderID()) {
                orderList.remove(order);
                System.out.println("Order " + order.getOrderID() + " er blevet fjernet fra listen\n");
                return;
            }
        }
    }

    //metode til at rykke en færdig ordre over på ordrehistorikken
    public void saveOrder(Scanner scanner) {
        System.out.println("Skriv ordrenummer og ordren vil blive flyttet til ordrehistorikken'");
        int orderID = scanner.nextInt();
        scanner.nextLine();
        if (!isOrderOnList(orderID)) return;
        for (Order order : orderList) {
            if (orderID == order.getOrderID()) {
                orderList.remove(order);
                orderHistoryList.add(order);
                System.out.println("order " + order.getOrderID() + " er blevet fjernet og flyttet til ordrehistorikken\n");
                break;
            }
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

    //metoden sorterer Order objekter i orderlisten. Ved at give et Order objekt til compareTo metoden, kan den sammenligne to Order objekter.
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