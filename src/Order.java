import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    //Order instansvariable
    protected ArrayList<Pizza> pizzaList = new ArrayList<>();
    protected static int orderIDCounter = 0;
    protected final int orderID;
    protected int deliveryTimeHours;
    protected int deliveryTimeMinutes;

    //Order constructor, der giver et nyoprettet Order objekt et unikt ID
    public Order() {
        orderIDCounter++;
        orderID = orderIDCounter;
    }

    //Getters for at kunne tilgå Order attributes/instansvariable uden for Order klassen
    public int getOrderID() {
        return orderID;
    }

    public int getDeliveryTimeHours() {
        return deliveryTimeHours;
    }

    public int getDeliveryTimeMinutes() {
        return deliveryTimeMinutes;
    }

    void addOrderDeliveryTime(Scanner scanner){
        String input;

        System.out.println("Skriv leverings tid som 00:00 timer:minutter");
        input = scanner.nextLine();

        String[] timeSplit = input.split(":");
        deliveryTimeHours = Integer.parseInt(timeSplit[0]);
        deliveryTimeMinutes = Integer.parseInt(timeSplit[1]);
    }

    //addPizza metoden tager den pizzamenuen som parametrer for at tilføje pizza'er fra den allerde etablerede menu
    //og kopiere dem til vores ordrerliste
    void addPizza(PizzaMenu menu, String pizzaName){
            try {
                ArrayList<Pizza> pizzaMenu = menu.getPizzaMenu();
                for(Pizza p : pizzaMenu){
                    if(p.getName().equalsIgnoreCase(pizzaName)){
                        pizzaList.add(pizzaMenu.get(p.getPizzaNumber()-1));
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Ugyldigt valg");
            }
    }


    //Begge addPizza metode kan bruges afhængigt af om man giver et navn eller nummer
    //som input parametrer
    void addPizza(PizzaMenu menu, int pizzaNumber){
        try {
            ArrayList<Pizza> pizzaMenu = menu.getPizzaMenu();
            pizzaList.add(pizzaMenu.get(pizzaNumber - 1));
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Ugyldigt valg");
        }
    }

    //metode til at beregne prisen på en ordre
    public int sumPizzaPrices() {
        int sum = 0;
        for (Pizza pizza : pizzaList) {
            sum += pizza.getPrice();
        }
        return sum;
    }

    //metoden sammenligner størrelsen mellem to Order objekters afhentningstidspunkt. Hvis -1, er den mindre. Hvis 1, er den større.
    public int compareTo(Order order) {
        if (this.deliveryTimeHours < order.deliveryTimeHours) return -1;
        if (this.deliveryTimeHours == order.deliveryTimeHours && this.deliveryTimeMinutes < order.deliveryTimeMinutes)
            return -1;
        return 1;
    }

    //Order toString override til at printe alle pizzaer på en ordre og dens ID/nummer, samt afhentningstidspunkt
    public String toString() {
        String pizzas;
        if (deliveryTimeMinutes == 0) {
            pizzas = "Order " + orderID + " for " + deliveryTimeHours + ":" + deliveryTimeMinutes + "0\n";
            for (Pizza pizza : pizzaList) {
                pizzas += pizza + "\n";
            }
        } else {
            pizzas = "Order " + orderID + " for " + deliveryTimeHours + ":" + deliveryTimeMinutes + "\n";
            for (Pizza pizza : pizzaList) {
                pizzas += pizza + "\n";
            }
        }
        return pizzas;
    }
}