import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PizzaMenu menu = new PizzaMenu();
        Scanner scanner = new Scanner(System.in);
        menu.addPizzaMenu(menu);
        System.out.println(menu);

        menu.changePrice(scanner);
        System.out.println(menu);
    }
}