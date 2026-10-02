import java.util.ArrayList;   // Java's fancy list
import java.util.Scanner;     // For user input


// The way our expenses will look like
class Expense {
    String description;   // What you bought:
    double amount;        // How much it cost:
    String category;      // Food? Fun? Essentials?
}


public class Main {

    // Our list to store all expenses
    static ArrayList<Expense> expenses = new ArrayList<>();
    
    // Our input reader!
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("WELCOME TO EXPENSE TRACKER!");

        while (true) {
            showMenu();   
            
            int choice = scanner.nextInt();
            scanner.nextLine();   // Clear the buffer (Important!)

            if (choice == 1) {
                addExpense();     // Calls addExpense() function
            }
            else if (choice == 2) {
                viewExpenses();    // Calls viewExpenses() function
            }
            else if (choice == 3) {
                double total = getTotalSpent();   // Calls getTotalSpent() and it writes the number in decimals
                System.out.println("\nTotal spent: " + total + " RSD"); // I added RSD as currency of my home country, you can change it and add whatever it is that you want
            }
            else if (choice == 4) {
                System.out.println("\nGoodbye! Spend wisely!");
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }

   
    static void showMenu() {
        System.out.println("\nEXPENSE TRACKER");
        System.out.println("1. Add expense");
        System.out.println("2. View expenses");
        System.out.println("3. Total spent");
        System.out.println("4. Quit");
        System.out.print("Choice: ");
    }

   
    static void addExpense() {
        Expense newExpense = new Expense();   // Create object from our Class Expense!

        // Little interview before creating a whole object heheh 
        System.out.print("\nWhat did you buy?");
        newExpense.description = scanner.nextLine();

        System.out.print("How much did it cost?");
        newExpense.amount = scanner.nextDouble();
        scanner.nextLine();   // Clear buffer!

        System.out.print("Category (Food/Fun/Essential/Other): ");
        newExpense.category = scanner.nextLine();

        expenses.add(newExpense);   // ADD to our list! - finalizing the interview!
        System.out.println("Expense added!");
    }

   
    static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("\nNo expenses yet! Add some!");
            return;
        }
        // It catches, writes and lists all of your expenses!
        System.out.println("\nYOUR EXPENSES:");
        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            System.out.println((i + 1) + ". " + e.description 
                + " | " + e.amount + " RSD | " + e.category);
        }
    }

    // Sums your entire expense sheet
    static double getTotalSpent() {
        double total = 0;
        for (Expense e : expenses) {
            total += e.amount;   // Add each expense!
        }
        return total;   // The result!
    }
}


