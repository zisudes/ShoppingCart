import java.util.Locale;
import java.util.Scanner;
import java.util.ResourceBundle;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a language : ");
        System.out.println("1. English");
        System.out.println("2. Finnish");
        System.out.println("3. Swedish");
        System.out.println("4. Japanese");

        int languageChoice = scanner.nextInt();
        Locale locale = null;
        switch (languageChoice) {
            case 1:
                locale = new Locale("en", "US");
                break;
                case 2:
                locale = new Locale("fi", "FI");
                break;
                case 3:
                locale = new Locale("sv", "SE");
                break;
                case 4:
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
                System.out.println("Invalid choice. Returning to English.");
                break;
        }

        ResourceBundle messages = ResourceBundle.getBundle("messages", locale);

        System.out.print(messages.getString("enterNumOfItems"));
        double numOfItems = scanner.nextDouble();
        scanner.nextLine();

        double totalCost = 0.0;

        for(int i =1; i<=numOfItems; i++){
            System.out.print(messages.getString("enterItemPrice") + i + ": ");
            double itemPrice = scanner.nextDouble();
            System.out.print(messages.getString("enterItemQuantity") + i + ": ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            double itemCost = itemPrice * quantity;
            totalCost += itemCost;
        }

        System.out.println(messages.getString("totalCost") + ": " + totalCost);
        scanner.close();
    }
}
