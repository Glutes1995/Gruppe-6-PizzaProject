import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Generelle variabler, instanser og objekter

            //Pizzamenu objekt og instantiering af objekt
        PizzaMenu pizzaMenu = new PizzaMenu();
        pizzaMenu.addPizzaMenu(pizzaMenu);

            //Pizza objekt og instantiering af objektet
        Pizza pizza = new Pizza();


        Scanner scanner = new Scanner(System.in);
        boolean actionMenu = true;

        //OrderList objekt laves
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
                    System.out.println(pizzaMenu);
                    break;

                case "2": //Lav bestilling
                    System.out.println(pizzaMenu);
                    orderList.addOrder(pizzaMenu, scanner);
                    break;

                case "3": //Ændre en pris på pizza
                    System.out.println(pizzaMenu);
                    pizza.setPrice();

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