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

    //addPizza metoden tager den pizzamenuen som parametrer for at tilføje pizza'er fra den allerde etablerede menu
    //og kopiere dem til vores ordrerliste
    void addPizza(PizzaMenu menu, String pizzaName){
        ArrayList<Pizza> pizzaMenu = menu.getPizzaMenu();
        for(Pizza p : pizzaMenu){
            if(p.getName().equalsIgnoreCase(pizzaName)){
                pizzaList.add(pizzaMenu.get(p.getPizzaNumber()-1));
            }
        }

    }
    //Begge addPizza metode kan bruges afhængigt af om man giver et navn eller nummer
    //som input parametrer
    void addPizza(PizzaMenu menu, int pizzaNumber){
        ArrayList<Pizza> pizzaMenu = menu.getPizzaMenu();
        pizzaList.add(pizzaMenu.get(pizzaNumber-1));
    }

    //metode til at beregne prisen på en ordre
    public int sumPizzaPrices() {
        int sum = 0;
        for (Pizza pizza : pizzaList) {
            sum += pizza.getPrice();
        }
        return sum;
    }

    //metoden sammenligner størrelsen mellem to Order objekters, to integers. Hvis -1, er den mindre. Hvis 1, er den større.
    public int compareTo(Order order) {
        if (this.deliveryTimeHours < order.deliveryTimeHours) return -1;
        if (this.deliveryTimeHours == order.deliveryTimeHours && this.deliveryTimeMinutes < order.deliveryTimeMinutes)
            return -1;
        return 1;
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