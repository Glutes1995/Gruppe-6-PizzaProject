import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Generelle variabler, instanser og objekter

        //Pizzamenu objekt og instantiering af objekt
        PizzaMenu pizzaMenu = new PizzaMenu();
        pizzaMenu.addPizzaMenu();


        Scanner scanner = new Scanner(System.in);
        boolean actionMenu = true;

        //OrderList objekt laves
        OrderList orderList = new OrderList();

        while (actionMenu) {
            //Viser ordrehistorikken
            System.out.println(orderList);

            //Viser handlingsmenuen
            ActionMenu.showActions();

            //Læser brugerens input
            String actions = scanner.nextLine();

            switch (actions) {
                //Viser pizza menu
                case "1" -> System.out.println(pizzaMenu);
                //Laver og tilføjer bestilling
                case "2" -> orderList.addOrder(pizzaMenu, scanner);
                //afslut en ordre, flytter en ordre til ordrehistorikken
                case "3" -> orderList.saveOrder(scanner);
                //Fjern en bestilling (Hvis Alfonso fatfinger en bestilling)
                case "4" -> orderList.removeOrder(scanner);
                //Se dagens omsætning og mest populære
                case "5" -> orderList.orderRevenue();
                //Ændre en pris på en pizza
                case "6" -> pizzaMenu.changePrice(scanner);
                //Afslutter programmet
                case "7" -> actionMenu = false;
                //Hvis brugeren indtaster ugyldigt valg
                default -> System.out.println("Indtast et tal fra 1-7");
            }
        }
        scanner.close();
        System.out.println("Programmet afsluttes");
    }
}