import java.util.Scanner;

public class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Product Details:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
       try( Scanner sc = new Scanner(System.in)){
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();  // consume newline
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        Product p = new Product(id, name, price);
        p.displayDetails();

        sc.close();
       }
    }
}
