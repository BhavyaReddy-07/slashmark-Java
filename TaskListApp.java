import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {
    private static ArrayList<String> taskList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            performAction(choice);
        }
    }

    private static void displayMenu() {
        System.out.println("Task List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. List Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return getUserChoice();
        }
    }

    private static void performAction(int choice) {
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                removeTask();
                break;
            case 3:
                listTasks();
                break;
            case 4:
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
        }
    }

    private static void addTask() {
        System.out.print("Enter the task: ");
        String task = scanner.nextLine();
        taskList.add(task);
        System.out.println("Task added: " + task);
    }

    private static void removeTask() {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty. Nothing to remove.");
            return;
        }

        System.out.println("Current Tasks:");
        listTasks();
        System.out.print("Enter the index of the task to remove: ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index < taskList.size()) {
                String removedTask = taskList.remove(index);
                System.out.println("Task removed: " + removedTask);
            } else {
                System.out.println("Invalid index. Please enter a valid index.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid index.");
        }
    }

    private static void listTasks() {
        if (taskList.isEmpty()) {
            System.out.println("Task list is empty.");
        } else {
            System.out.println("Task List:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println(i + ". " + taskList.get(i));
            }
        }
    }
}
 
    

