import java.util.ArrayList;

public class Order {
    //Order instansvariable
    private ArrayList<Pizza> pizzaList = new ArrayList<>();
    private static int orderIDCounter = 0;
    private final int orderID;
    private int deliveryTimeHours;
    private int deliveryTimeMinutes;

    //Order constructor
    public Order() {
        orderIDCounter++;
        orderID = orderIDCounter;
    }

    //Getters for Order attributes/instansvariable
    public int getOrderID() {
        return orderID;
    }

    public int getDeliveryTimeHours() {
        return deliveryTimeHours;
    }

    public int getDeliveryTimeMinutes() {
        return deliveryTimeMinutes;
    }

}