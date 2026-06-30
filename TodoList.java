import java.util.ArrayList;
import java.util.Scanner;

class list {
    // initialize array for tasks
    protected ArrayList<String> tasks = new ArrayList<>();
    private String ownerName;

    public String getName() {
        return ownerName;
    }

    public list(String ownerName) {
        this.ownerName = ownerName;
    }

    public void addTask(String task) {
        // method to add task based on user input
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        //
        System.out.println("==== TASKS ====");
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            for (String record : tasks) {
                System.out.println(record);
            }
        }
    }

    public void removeTask(int taskNumber) {
        //
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed successfully!");
        } else {
            System.out.println("Invalid task number.");
        }
    }

}

public class TodoList {
    public static void main(String[] args) {
        // initialize scanner
        Scanner scanner = new Scanner(System.in);

        // initialize list object
        list myList = new list("Mr.Balderas");

        // terminal variable for while loop
        boolean exit = false;

        /*
         * // save current list to a file with a header
         * public void saveToFile(){
         * try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
         * writeAccountHeader(writer);
         * writeTransactions(writer);
         * 
         * } catch (IOException e) {
         * // Handle IOException
         * System.out.println("Error saving file.");
         * e.printStackTrace();
         * ;
         * }
         * }
         */

        // while exit is false run loop
        while (!exit) {

            // initialize choice variable
            int choice = 0;

            // Display menu
            System.out.println("Hello " + myList.getName());
            System.out.println("==== TO-DO LIST ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit\n");

            // Get user input
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    // Add task
                    System.out.println("Enter the task to add: ");
                    myList.addTask(scanner.nextLine());
                    break;
                }

                case 2 -> {
                    // View tasks
                    myList.viewTasks();
                    break;

                }
                case 3 -> {
                    // Remove task
                    System.out.println("Enter the task number to remove: ");
                    myList.removeTask(scanner.nextInt());
                    break;

                }

                case 4 -> {
                    // Exit
                    System.out.println("Goodbye!");
                    exit = true;
                    break;

                }

                default -> System.out.println("Invalid choice. Please try again.");

            }

        }

        scanner.close();

    }
}