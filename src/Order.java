import java.util.ArrayList;


public class Order {
    private ArrayList<Pizza> pizzaList = new ArrayList<>();
    private int orderIDCounter;
    private static int orderID;
    private int deliveryTimeHours;
    private int deliveryTimeMinutes;

public int getOrderID() {
    return orderID;
}
public int getDeliveryTimeHours()  {
    return deliveryTimeHours;
}
public int getDeliveryTimeMinutes() {
    return deliveryTimeMinutes;
}
}
