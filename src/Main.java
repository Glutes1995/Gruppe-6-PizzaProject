import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Generelle variabler, instanser og objekter

        //Pizzamenu objekt og instantiering af objekt
        PizzaMenu pizzaMenu = new PizzaMenu();
        pizzaMenu.addPizzaMenu(pizzaMenu);


        Scanner scanner = new Scanner(System.in);
        boolean actionMenu = true;

        //OrderList objekt laves
        OrderList orderList = new OrderList();

        while (actionMenu) {
            //Viser ordrehistorikken
            System.out.println(orderList);

            //Viser handlingsmenuen
            ActionMenu.visActions();

            //Læser brugerens input
            String actions = scanner.nextLine();


            switch (actions) {
                case "1": //Viser pizza menu
                    System.out.println(pizzaMenu);
                    break;

                case "2": //Lav bestilling
                    System.out.println(pizzaMenu);
                    orderList.addOrder(pizzaMenu, scanner);
                    break;

                case "3": //afslut en ordre, flytter en ordre til ordrehistorikken
                    System.out.println(orderList);
                    orderList.saveOrder(scanner);
                    break;

                case "4": //Fjern en bestilling (Hvis Alfonso fatfinger en bestilling)
                    orderList.removeOrder(scanner);
                    break;

                case "5": //Se dagens omsætning
                    orderList.orderRevenue();
                    orderList.mostSoldPizza();
                    break;

                case "6": //Ændre en pris på en pizza
                    System.out.println(pizzaMenu);
                    //Tilføj metoden til at ændre prisen
                    break;


                case "7": //Afslutter programmet
                    System.out.println("Programmet afsluttes");
                    actionMenu = false;
                    break;


                default: //Hvis brugeren indtaster ugyldigt valg
                    System.out.println("Indtast et gyldigt valg");

            }
        }
    }
}