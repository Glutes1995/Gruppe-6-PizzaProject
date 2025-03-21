import java.util.ArrayList;

public class Order {
    //Order instansvariable
    private ArrayList<Pizza> pizzaList = new ArrayList<>();
    private static int orderIDCounter = 0;
    private final int orderID;
    private int deliveryTimeHours;
    private int deliveryTimeMinutes;

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

    //metode til at beregne prisen på en ordre
    public int sumPizzaPrices() {
        int sum = 0;
        for (Pizza pizza : pizzaList) {
            sum += pizza.getPrice();
        }
        return sum;
    }

    //Order toString override til at printe alle pizzaer på en ordre og orderens ID/nummer
    public String toString() {
        String pizzas = "Order " + getOrderID() + "\n";
        for (Pizza pizza : pizzaList) {
            pizzas += pizza + "\n";
        }
        return pizzas;
    }

}