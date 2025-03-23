import java.util.ArrayList;
import java.util.Scanner;

public class OrderList {
    //OrderList instansvariable
    private ArrayList<Order> orderList = new ArrayList<>();
    private ArrayList<Order> orderHistoryList = new ArrayList<>();

    //metode til at beregne dagens omsætning. Altså beregne alle odrepriser på ordrehistorikken
    public int orderRevenue() {
        int sum = 0;
        for (Order order : orderHistoryList) {
            sum += order.sumPizzaPrices();
        }
        return sum;
    }

    //denne metode kan tilføje et givent odre-objekt til ordre-listen
    void addOrder(PizzaMenu menu){
        Scanner input = new Scanner(System.in);
        Order order = new Order();

        String userInput = input.nextLine();

        try{
            int pizzaNumber = Integer.parseInt(userInput);
            order.addPizza(menu, pizzaNumber);
        }catch(NumberFormatException e){
            order.addPizza(menu, userInput);
        }

        orderList.add(order);
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