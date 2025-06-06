/*
Name - Soe Min Min Latt
ID - 6611938
Sec - 541
 */
package u6611938mid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class InventoryControl {
    private static ArrayList<Product> products = new ArrayList<>();
    static Scanner reader = new Scanner(System.in);

    public static void create(){
        System.out.print("Enter product ID: ");
        int ID = reader.nextInt();
        reader.nextLine();
        System.out.print("Enter product name: ");
        String pName = reader.nextLine();
        System.out.print("Enter product unit: ");
        String pUnit = reader.nextLine();

        boolean exists = false;
        for (Product product: products) {
            if (product.getId() == ID) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("This Product ID already exists.");
        } else {
            products.add(new Product(ID, pName, pUnit));
            System.out.println("Product added successfully.");
        }
    }

    public static void restock(){
        System.out.print("Enter the product ID to restock: ");
        int ID = reader.nextInt();
        reader.nextLine();
        boolean found = false;

        for (Product product: products) {
            if (product.getId() == ID) {
                found = true;
                System.out.print("Enter the number of items to restock: ");
                int numItems = reader.nextInt();
                reader.nextLine();

                if (product.restock(numItems)) {
                    System.out.println("Restocked successfully.");
                } else {
                    System.out.println("Invalid quantity entered. Restocking failed.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("This ID does not exist.");
        }
    }

    public static void sell(){
        System.out.print("Enter the product ID to sell: ");
        int ID = reader.nextInt();
        reader.nextLine();
        boolean found = false;

        for (Product product: products) {
            if (product.getId() == ID) {
                found = true;
                System.out.print("Enter the number of items to sell: ");
                int numItems = reader.nextInt();
                reader.nextLine();

                if (product.sell(numItems)) {
                    System.out.println("Sold successfully.");
                } else {
                    System.out.println("Insufficient quantity. Sale failed.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("This ID does not exist.");
        }
    }

    public static void display(){
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            products.sort(Comparator.comparing(Product::getId));
            for (Product product: products) {
                System.out.println(product);
            }
        }
    }

    public static void main(String[] args) {
        int choice;
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Create a new product");
            System.out.println("2. Restock the product");
            System.out.println("3. Sell the product");
            System.out.println("4. Display the inventory");
            System.out.println("5. Exit");

            System.out.print("Enter your choice [1-5]: ");
            choice = reader.nextInt();
            reader.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    restock();
                    break;
                case 3:
                    sell();
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Choose 1-5 to continue.");
            }
        }
        reader.close();
    }
}
