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

            System.out.println("Indtast navnet eller nummer på pizzaen. Indtast done til at afslutte bestillingen.");
            userInput = scanner.nextLine();
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