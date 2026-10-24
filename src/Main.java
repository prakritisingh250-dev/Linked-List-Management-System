import java.util.Scanner;

/**
 * Entry point for the Linked List Management System.
 * Provides menu-driven access to singly and doubly linked lists.
 */
public class Main {
    private static final Scanner INPUT = new Scanner(System.in);
    private static final SinglyLinkedList SINGLY_LIST = new SinglyLinkedList();
    private static final DoublyLinkedList DOUBLY_LIST = new DoublyLinkedList();

    public static void main(String[] args) {
        boolean running = true;

        printWelcomeMessage();
        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    singlyLinkedListMenu();
                    break;
                case 2:
                    doublyLinkedListMenu();
                    break;
                case 3:
                    compareLinkedLists();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Linked List Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 4.");
            }
        }
        INPUT.close();
    }

    private static void printWelcomeMessage() {
        System.out.println("==================================================");
        System.out.println("           LINKED LIST MANAGEMENT SYSTEM");
        System.out.println("==================================================");
    }

    private static void printMainMenu() {
        System.out.println("\n---------------- MAIN MENU ----------------");
        System.out.println("1. Singly Linked List");
        System.out.println("2. Doubly Linked List");
        System.out.println("3. Compare Singly vs Doubly Linked List");
        System.out.println("4. Exit");
    }

    private static void singlyLinkedListMenu() {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\n------ SINGLY LINKED LIST OPERATIONS ------");
            System.out.println(" 1. Insert at Beginning");
            System.out.println(" 2. Insert at End");
            System.out.println(" 3. Insert at Position");
            System.out.println(" 4. Insert After a Node");
            System.out.println(" 5. Insert Before a Node");
            System.out.println(" 6. Delete from Beginning");
            System.out.println(" 7. Delete from End");
            System.out.println(" 8. Delete from Position");
            System.out.println(" 9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display");
            System.out.println("13. Count Nodes");
            System.out.println("14. Find Maximum");
            System.out.println("15. Find Minimum");
            System.out.println("16. Find Middle Element");
            System.out.println("17. Reverse");
            System.out.println("18. Sort");
            System.out.println("19. Remove Duplicates");
            System.out.println("20. Back to Main Menu");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    SINGLY_LIST.insertAtBeginning(readInt("Enter value: "));
                    break;
                case 2:
                    SINGLY_LIST.insertAtEnd(readInt("Enter value: "));
                    break;
                case 3:
                    int insertValue = readInt("Enter value: ");
                    int insertPosition = readInt("Enter 1-based position: ");
                    SINGLY_LIST.insertAtPosition(insertValue, insertPosition);
                    break;
                case 4:
                    int afterTarget = readInt("Insert after which value? ");
                    int afterValue = readInt("Enter new value: ");
                    SINGLY_LIST.insertAfterValue(afterTarget, afterValue);
                    break;
                case 5:
                    int beforeTarget = readInt("Insert before which value? ");
                    int beforeValue = readInt("Enter new value: ");
                    SINGLY_LIST.insertBeforeValue(beforeTarget, beforeValue);
                    break;
                case 6:
                    SINGLY_LIST.deleteFromBeginning();
                    break;
                case 7:
                    SINGLY_LIST.deleteFromEnd();
                    break;
                case 8:
                    SINGLY_LIST.deleteAtPosition(readInt("Enter 1-based position: "));
                    break;
                case 9:
                    SINGLY_LIST.deleteByValue(readInt("Enter value to delete: "));
                    break;
                case 10:
                    SINGLY_LIST.search(readInt("Enter value to search: "));
                    break;
                case 11:
                    int oldValue = readInt("Enter existing value: ");
                    int newValue = readInt("Enter replacement value: ");
                    SINGLY_LIST.update(oldValue, newValue);
                    break;
                case 12:
                    SINGLY_LIST.display();
                    break;
                case 13:
                    System.out.println("Total nodes: " + SINGLY_LIST.countNodes());
                    break;
                case 14:
                    SINGLY_LIST.findMaximum();
                    break;
                case 15:
                    SINGLY_LIST.findMinimum();
                    break;
                case 16:
                    SINGLY_LIST.findMiddle();
                    break;
                case 17:
                    SINGLY_LIST.reverse();
                    break;
                case 18:
                    SINGLY_LIST.sort();
                    break;
                case 19:
                    SINGLY_LIST.removeDuplicates();
                    break;
                case 20:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 20.");
            }
        }
    }

    private static void doublyLinkedListMenu() {
        boolean backToMainMenu = false;

        while (!backToMainMenu) {
            System.out.println("\n------ DOUBLY LINKED LIST OPERATIONS ------");
            System.out.println(" 1. Insert at Beginning");
            System.out.println(" 2. Insert at End");
            System.out.println(" 3. Insert at Position");
            System.out.println(" 4. Insert After a Node");
            System.out.println(" 5. Insert Before a Node");
            System.out.println(" 6. Delete from Beginning");
            System.out.println(" 7. Delete from End");
            System.out.println(" 8. Delete from Position");
            System.out.println(" 9. Delete by Value");
            System.out.println("10. Search");
            System.out.println("11. Update");
            System.out.println("12. Display Forward");
            System.out.println("13. Display Backward");
            System.out.println("14. Count Nodes");
            System.out.println("15. Find Maximum");
            System.out.println("16. Find Minimum");
            System.out.println("17. Find Middle Element");
            System.out.println("18. Reverse");
            System.out.println("19. Sort");
            System.out.println("20. Remove Duplicates");
            System.out.println("21. Back to Main Menu");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    DOUBLY_LIST.insertAtBeginning(readInt("Enter value: "));
                    break;
                case 2:
                    DOUBLY_LIST.insertAtEnd(readInt("Enter value: "));
                    break;
                case 3:
                    int insertValue = readInt("Enter value: ");
                    int insertPosition = readInt("Enter 1-based position: ");
                    DOUBLY_LIST.insertAtPosition(insertValue, insertPosition);
                    break;
                case 4:
                    int afterTarget = readInt("Insert after which value? ");
                    int afterValue = readInt("Enter new value: ");
                    DOUBLY_LIST.insertAfterValue(afterTarget, afterValue);
                    break;
                case 5:
                    int beforeTarget = readInt("Insert before which value? ");
                    int beforeValue = readInt("Enter new value: ");
                    DOUBLY_LIST.insertBeforeValue(beforeTarget, beforeValue);
                    break;
                case 6:
                    DOUBLY_LIST.deleteFromBeginning();
                    break;
                case 7:
                    DOUBLY_LIST.deleteFromEnd();
                    break;
                case 8:
                    DOUBLY_LIST.deleteAtPosition(readInt("Enter 1-based position: "));
                    break;
                case 9:
                    DOUBLY_LIST.deleteByValue(readInt("Enter value to delete: "));
                    break;
                case 10:
                    DOUBLY_LIST.search(readInt("Enter value to search: "));
                    break;
                case 11:
                    int oldValue = readInt("Enter existing value: ");
                    int newValue = readInt("Enter replacement value: ");
                    DOUBLY_LIST.update(oldValue, newValue);
                    break;
                case 12:
                    DOUBLY_LIST.displayForward();
                    break;
                case 13:
                    DOUBLY_LIST.displayBackward();
                    break;
                case 14:
                    System.out.println("Total nodes: " + DOUBLY_LIST.countNodes());
                    break;
                case 15:
                    DOUBLY_LIST.findMaximum();
                    break;
                case 16:
                    DOUBLY_LIST.findMinimum();
                    break;
                case 17:
                    DOUBLY_LIST.findMiddle();
                    break;
                case 18:
                    DOUBLY_LIST.reverse();
                    break;
                case 19:
                    DOUBLY_LIST.sort();
                    break;
                case 20:
                    DOUBLY_LIST.removeDuplicates();
                    break;
                case 21:
                    backToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 21.");
            }
        }
    }

    private static void compareLinkedLists() {
        System.out.println("\n----------- SINGLY VS DOUBLY LINKED LIST -----------");
        System.out.printf("%-28s | %-25s | %-25s%n",
                "Feature", "Singly Linked List", "Doubly Linked List");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-28s | %-25s | %-25s%n",
                "Node references", "next", "previous and next");
        System.out.printf("%-28s | %-25s | %-25s%n",
                "Traversal", "Forward only", "Forward and backward");
        System.out.printf("%-28s | %-25s | %-25s%n",
                "Memory per node", "Lower", "Higher");
        System.out.printf("%-28s | %-25s | %-25s%n",
                "Reverse traversal", "Not directly supported", "Directly supported");
        System.out.printf("%-28s | %-25s | %-25s%n",
                "Delete a known node", "May need previous node", "Can reconnect both links");
        System.out.println("--------------------------------------------------------------------------------");
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (INPUT.hasNextInt()) {
                return INPUT.nextInt();
            }
            System.out.println("Invalid input. Please enter a whole number.");
            INPUT.next();
        }
    }
}
