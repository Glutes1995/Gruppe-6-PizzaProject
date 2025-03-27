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

    void addOrderDeliveryTime(Scanner scanner) {
        boolean incorrectInput = false;
        String input;

        do{
            System.out.println("Skriv leverings tid som 00:00 timer:minutter");
            input = scanner.nextLine();

            try{
                String[] timeSplit = input.split(":");

                deliveryTimeHours = Integer.parseInt(timeSplit[0]);
                deliveryTimeMinutes = Integer.parseInt(timeSplit[1]);
                if(deliveryTimeHours > 23 || deliveryTimeMinutes > 59 || deliveryTimeHours < 0 || deliveryTimeMinutes < 0){
                    System.out.println("Ugyldigt afhentningstidspunkt");
                    incorrectInput = true;
                }else{
                    incorrectInput = false;
                }
            }catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
                System.out.println("Ugyldigt afhentningstidspunkt");
                incorrectInput = true;
            }
        }while(incorrectInput);
    }

    //addPizza metoden tager pizzamenuen som parametrer for at tilføje en kopi af en pizza fra pizzamenuen til en ordre
    void addPizza(PizzaMenu menu, String pizzaName) {
        try {
            ArrayList<Pizza> pizzaMenu = menu.getPizzaMenu();
            for (Pizza pizza : pizzaMenu) {
                if (pizza.getName().equalsIgnoreCase(pizzaName)) {
                    Pizza newPizza = new Pizza(pizzaMenu.get(pizza.getPizzaNumber() - 1));
                    pizzaList.add(newPizza);
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ugyldigt valg");
        }
    }

    //Begge addPizza metode kan bruges afhængigt af om man giver et navn eller nummer som input parametrer
    void addPizza(PizzaMenu menu, int pizzaNumber) {
        try {
            ArrayList<Pizza> pizzaMenu = menu.getPizzaMenu();
            Pizza newPizza = new Pizza(pizzaMenu.get(pizzaNumber - 1));
            pizzaList.add(newPizza);
        } catch (IndexOutOfBoundsException e) {
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
        if (deliveryTimeMinutes == 0 && deliveryTimeHours == 0) {
            pizzas = "Order " + orderID + " for " + deliveryTimeHours + "0:" + deliveryTimeMinutes + "0\n";
            for (Pizza pizza : pizzaList) {
                pizzas += pizza + "\n";
            }
        } else if (deliveryTimeHours == 0) {
            pizzas = "Order " + orderID + " for " + deliveryTimeHours + "0:" + deliveryTimeMinutes + "\n";
            for (Pizza pizza : pizzaList) {
                pizzas += pizza + "\n";
            }
        } else if (deliveryTimeMinutes == 0) {
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