import java.util.*;
public class StockManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Stock> stocks = new ArrayList<>();
        int choice;

        do {
            System.out.println("1. Add stock");
            System.out.println("2. Remove stock");
            System.out.println("3. View stock");
            System.out.println("4. Update stock details");
            System.out.println("5. Search for stock");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1: // Add stock
                    System.out.print("Enter the stock name: ");
                    String name = input.next();
                    System.out.print("Enter the stock quantity: ");
                    int quantity = input.nextInt();
                    System.out.print("Enter the stock price: ");
                    double price = input.nextDouble();
                    stocks.add(new Stock(name, quantity, price));
                    System.out.println("Stock added successfully");
                    break;

                case 2: // Remove stock
                    System.out.print("Enter the stock name: ");
                    String stockName = input.next();
                    System.out.print("Enter the quantity to remove: ");
                    int removeQuantity = input.nextInt();
                    boolean stockFound = false;
                    for (Stock stock : stocks) {
                        if (stock.getName().equals(stockName)) {
                            stockFound = true;
                            stock.removeQuantity(removeQuantity);
                            System.out.println("Stock removed successfully");
                            break;
                        }
                    }
                    if (!stockFound) {
                        System.out.println("Stock not found");
                    }
                    break;

                case 3: // View stock
                    System.out.println("Current stocks:");
                    for (Stock stock : stocks) {
                        System.out.println(stock.toString());
                    }
                    break;

                case 4: // Update stock details
                    System.out.print("Enter the stock name to update: ");
                    String updateName = input.next();
                    boolean found = false;
                    for (Stock stock : stocks) {
                        if (stock.getName().equals(updateName)) {
                            found = true;
                            System.out.print("Enter new name (or press Enter to skip): ");
                            input.nextLine(); // consume the newline
                            String newName = input.nextLine();
                            if (!newName.isEmpty()) stock.setName(newName);

                            System.out.print("Enter new quantity (or -1 to skip): ");
                            int newQuantity = input.nextInt();
                            if (newQuantity != -1) stock.setQuantity(newQuantity);

                            System.out.print("Enter new price (or -1 to skip): ");
                            double newPrice = input.nextDouble();
                            if (newPrice != -1) stock.setPrice(newPrice);

                            System.out.println("Stock updated successfully");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Stock not found");
                    }
                    break;

                case 5: // Search for stock
                    System.out.print("Enter the stock name to search: ");
                    String searchName = input.next();
                    boolean isFound = false;
                    for (Stock stock : stocks) {
                        if (stock.getName().equals(searchName)) {
                            System.out.println("Stock found: " + stock.toString());
                            isFound = true;
                            break;
                        }
                    }
                    if (!isFound) {
                        System.out.println("Stock not found");
                    }
                    break;

                case 6: // Exit
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        } while (choice != 6);

        input.close();
    }
}

class Stock {
    private String name;
    private int quantity;
    private double price;

    public Stock(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void removeQuantity(int quantityToRemove) {
        if (quantityToRemove <= quantity) {
            quantity -= quantityToRemove;
        } else {
            System.out.println("Not enough quantity to remove");
        }
    }

    public String toString() {
        return name + ", quantity: " + quantity + ", price: $" + price;
    }
}