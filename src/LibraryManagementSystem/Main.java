package LibraryManagementSystem;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Story Book");
            System.out.println("2. Add School Book");
            System.out.println("3. Register Member");
            System.out.println("4. Borrow Item");
            System.out.println("5. Return Item");
            System.out.println("6. List All Items");
            System.out.println("7. List All Members");
            System.out.println("8. Load Data from File");
            System.out.println("9. Save Data to File");
            System.out.println("10. Exit");

            int choice = InputHandler.getIntInput("Choose an option: ");

            switch (choice) {
                case 1:
                    String id1 = InputHandler.getStringInput("Enter book ID: ");
                    String title1 = InputHandler.getStringInput("Enter book title: ");
                    String author = InputHandler.getStringInput("Enter author: ");
                    manager.addStoryBook(new StoryBook(id1, title1, author));
                    break;

                case 2:
                    String id2 = InputHandler.getStringInput("Enter book ID: ");
                    String title2 = InputHandler.getStringInput("Enter book title: ");
                    String subject = InputHandler.getStringInput("Enter subject: ");
                    manager.addSchoolBook(new SchoolBook(id2, title2, subject));
                    break;

                case 3:
                    String memberId = InputHandler.getStringInput("Enter member ID: ");
                    String name = InputHandler.getStringInput("Enter name: ");
                    manager.registerMember(new Member(memberId, name));
                    break;

                case 4:
                    String borrowId = InputHandler.getStringInput("Enter item ID to borrow: ");
                    String borrowerId = InputHandler.getStringInput("Enter your member ID: ");
                    manager.borrowItem(borrowId, borrowerId);
                    break;

                case 5:
                    String returnId = InputHandler.getStringInput("Enter item ID to return: ");
                    String returnerId = InputHandler.getStringInput("Enter your member ID: ");
                    manager.returnItem(returnId, returnerId);
                    break;

                case 6:
                    manager.listItems();
                    break;

                case 7:
                    manager.listMembers();
                    break;

                case 8:
                    manager.loadData();
                    System.out.println("Data loaded from file.");
                    break;

                case 9:
                    manager.saveData();
                    System.out.println("Data saved to file.");
                    break;

                case 10:
                    System.out.println("Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}