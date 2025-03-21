import java.util.ArrayList;

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

    //OrderList toString override til at printe alle odre på ordre listen
    public String toString() {
        String orders = "";
        for (Order order : orderList) {
            orders += order + "\n";
        }
        return orders;
    }
}