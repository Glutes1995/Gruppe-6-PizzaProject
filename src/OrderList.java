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

    // Finder og viser den mest solgte pizza på tværs af alle ordrer
    public void mostSoldPizza() {
        int maxCount = 0;
        String mostRepeatedName = "";

        // Gennemløb alle ordrer og pizzaer i ordrehistorikken for at tælle salg
        for (Order orderI : orderHistoryList) {
            for (Pizza pizzaI : orderI.pizzaList) {
                String currentName = pizzaI.getName();
                int count = 0;

                // Tæl, hvor ofte 'currentName' forekommer i hele historikken
                for (Order orderN : orderHistoryList) {
                    for (Pizza pizzaN : orderN.pizzaList) {
                        if (pizzaN.getName().equals(currentName)) {
                            count++;
                        }
                    }
                }

                // Opdater 'mest solgte pizza', hvis denne pizza har højere count
                if (count > maxCount) {
                    maxCount = count;
                    mostRepeatedName = currentName;
                }
            }
        }

        // Udskriv resultatet
        if (maxCount >= 2) {
            System.out.println("Mest solgte pizza er: " + mostRepeatedName + " (solgt " + maxCount + " gange)");
        } else {
            System.out.println("Ingen pizza er solgt mere end én gang i dag.");
        }
    }


    //denne metode kan tilføje et givent ordre-objekt til ordre-listen
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
        if (order.pizzaList.isEmpty()) {
            System.out.println("Ugyldig ordre\n");
        } else {
            order.addOrderDeliveryTime(scanner);
            orderList.add(order);
            this.sortOrders();
        }
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
        System.out.println("Skriv ordrenummer og ordren vil blive flyttet til ordrehistorikken");
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
        System.out.println("Order findes ikke\n");
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