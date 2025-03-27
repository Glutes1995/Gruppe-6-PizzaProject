import java.util.Scanner;

public class ActionMenu {
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
            showActions();

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

    //Metode til at vise handlinger
    public static void showActions() {
        System.out.println("""
                Hvad vil du foretage dig?
                1 - Se menukortet
                2 - Lav en bestilling
                3 - Færdiggør en bestilling
                4 - Fjern en bestilling
                5 - Se dagens bestillinger
                6 - Ændre pris på en pizza
                7 - Afslut programmet
                """);
        /*
        System.out.println("Hvad vil du foretage dig?");
        System.out.println("1 - Se menukortet");
        System.out.println("2 - Lav en bestilling");
        System.out.println("3 - Færdiggør en bestilling");
        System.out.println("4 - Fjern en bestilling");
        System.out.println("5 - Se dagens bestillinger");
        System.out.println("6 - Ændre pris på en pizza");
        System.out.println("7 - Afslut programmet");
         */
    }
}