import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

class TaskOrganizer {
    // initialize array for tasks
    protected ArrayList<String> tasks = new ArrayList<>();
    private String ownerName;

    // error finding file
    boolean fileExist = true;

    // get name outside of class
    public String getName() {
        return ownerName;
    }

    public void changeName(String newName) {
        // change name method
        ownerName = newName;
    }

    // constructor for TaskOrganizer object
    public TaskOrganizer(String ownerName) {
        this.ownerName = ownerName;
    }

    public void addTask(String task) {
        // method to add task based on user input
        tasks.add(task);
        System.out.println("Task added successfully!");
    }

    public void viewTasks() {
        // method to view task
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

    public void saveToFile(String filename) {
        //
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Header for file
            writer.write(ownerName);
            writer.write("'s Tasks:");
            writer.newLine();
            writer.write("==========");
            writer.newLine();
            // loop through task and write
            for (String record : tasks) {
                writer.write("-");
                writer.write(record);
                writer.newLine();
            }

        } catch (IOException e) {
            // Handle IOException
            System.out.println("Error saving file.");
            e.printStackTrace();
            ;
        }
        System.out.println("Tasks saved successfully.");
    }

    public void readFromFile(String filename) {
        //
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            // handle owners name from header
            String firstLine = reader.readLine();
            if (firstLine != null) {
                // remove unwanted part from first line and assign to ownerName
                ownerName = firstLine.replace("'s Tasks:", "");
            }
            // skip divider line
            reader.readLine();
            // loop through remaning lines
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                // logic for line
                if (!currentLine.isEmpty() && currentLine.startsWith("-")) {
                    tasks.add(currentLine.substring(1));
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file." + e);
            System.out.println("No previous data found.");
            fileExist = false;
        }
    }

    public void createStartFile(String filename) {
        //
    }

}

public class TodoList {
    public static void main(String[] args) {
        // initialize scanner
        Scanner scanner = new Scanner(System.in);

        // initialize list object
        TaskOrganizer myList = new TaskOrganizer("");

        // load previous data before user interface
        myList.readFromFile("test.txt");

        if (myList.fileExist == false) {
            System.out.println("Please enter your name: ");
            myList.changeName(scanner.nextLine());
        }

        // terminal variable for while loop
        boolean exit = false;

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
            System.out.println("4. Save Tasks to File");
            System.out.println("5. Exit\n");

            // Get user input
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: {
                    // Add task
                    System.out.println("Enter the task to add: ");
                    myList.addTask(scanner.nextLine());
                    break;
                }

                case 2: {
                    // View tasks
                    myList.viewTasks();
                    break;
                }

                case 3: {
                    // Remove task
                    System.out.println("Enter the task number to remove: ");
                    myList.removeTask(scanner.nextInt());
                    break;
                }

                case 4: {
                    // save current list to file
                    myList.saveToFile("test.txt");
                    break;
                }

                case 5: {
                    // Exit
                    System.out.println("Goodbye!");
                    exit = true;
                    break;
                }
                // invalid input validation
                default: {
                    System.out.println("Invalid choice. Please try again.");
                }

            }

        }

        // close scanner
        scanner.close();

    }
}