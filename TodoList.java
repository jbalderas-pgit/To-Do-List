import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> tasks = new ArrayList<>();

        int choice = 0;
        
        while(choice != 4){

            // Display menu
            System.out.println("==== TO-DO LIST ====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit\n");

            // Get user input
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 -> {
                    // Add task
                    System.out.println("Enter the task to add: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task added successfully!");
                }

                case 2 -> {
                    // View tasks
                    System.out.println("==== TASKS ====");
                    if(tasks.isEmpty()){
                        System.out.println("No tasks available.");
                    } 
                    else {
                        for(int i = 0; i < tasks.size(); i++){
                            System.out.println((i+1) + ". " + tasks.get(i));
                        }}
                }
                case 3 -> {
                    // Remove task
                    System.out.println("Enter the task number to remove: ");
                    int taskNumber = scanner.nextInt();
                    if(taskNumber > 0 && taskNumber <= tasks.size()){
                        tasks.remove(taskNumber - 1);
                        System.out.println("Task removed successfully!");
                    } 
                    else {
                        System.out.println("Invalid task number.");
                    }
                }
                
                case 4 -> {
                    // Exit
                    System.out.println("Goodbye!");
                    choice = 4;
                }
                
                default -> System.out.println("Invalid choice. Please try again.");
                
            }

        }

        scanner.close();

    }
}