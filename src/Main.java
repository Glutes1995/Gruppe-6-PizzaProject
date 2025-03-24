import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test features manuelt her inde\n");
        //For eksempel har jeg testet ting, der skal vise noget
        //Man kan bare slette hvad end der er her i main og teste det man nu skal have testet"

        PizzaMenu pizzaMenu = new PizzaMenu();
        Scanner scanner = new Scanner(System.in);
        boolean actionMenu = true;

        pizzaMenu.addPizza("Margarita",49,1,"Tomato sauce, Cheese");
        System.out.println(pizzaMenu);

        pizzaMenu.removePizza(1);
        System.out.println(pizzaMenu);

        Pizza pizza = new Pizza("Meat lover", 69, 2);
        System.out.println(pizza);

        //Test OrderList og Order klasserne
        pizzaMenu.addPizza("Margarita",49,1,"Tomato sauce, Cheese");
        System.out.println(pizzaMenu);

        OrderList orderList = new OrderList();

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println("OrderList1: ");
        System.out.println(orderList);

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println("OrderList2: ");
        System.out.println(orderList);

        orderList.addOrder(pizzaMenu, scanner);
        System.out.println("OrderList3: ");
        System.out.println(orderList);

        while(actionMenu){
            //Viser ordrehistorikken
            System.out.println(orderList);

            //Viser handlingsmenuen
            ActionMenu.visActions();

            //Læser brugerens input
            String actions = scanner.nextLine();

            switch (actions){
                case "1": //Viser pizza menu
                    System.out.println(pizzaMenu);
                    break;

                case "2": //Lav bestilling
                    orderList.addOrder(pizzaMenu, scanner);
                    break;

                case "3": //Ændre en pris på pizza

                    break;

                case "4": //

                    break;

                case "5": //Afslutter programmet
                    System.out.println("Programmet afsluttes");
                    actionMenu = false;
                    break;

                default: //Hvis brugeren indtaster ugyldigt valg
                    System.out.println("Indtast et gyldigt valg");

            }
        }
    }
}