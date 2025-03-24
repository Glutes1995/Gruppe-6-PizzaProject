import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Variabler
        PizzaMenu pizzaMenu = new PizzaMenu();
        Scanner scanner = new Scanner(System.in);
        boolean actionMenu = true;
        OrderList orderList = new OrderList();

        while(actionMenu){
            //Viser ordrehistorikken
            System.out.println(orderList);

            //Viser handlingsmenuen
            ActionMenu.visActions();

            //Læser brugerens input
            String actions = scanner.nextLine();

            switch (actions){
                case "1": //Viser pizza menu
                    pizzaMenu.getPizzaMenu();
                    break;

                case "2": //Lav bestilling
                    System.out.println(pizzaMenu);
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