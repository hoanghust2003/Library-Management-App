import java.util.Scanner;

public class Program {
    static int option;

    public static void main(String[] args) {
        Library library = new Library("Thư viện tổ dân phố 7 phường Bách Khoa");
        Scanner scanner = new Scanner(System.in);
        do {
            showMenu();
            askOption();

            switch (option) {
                case 1:
                    library.showLibraryInfo();
                    break;
                case 2:
                    library.addNewBook();
                    break;
                case 3:
                    System.out.print("Enter book's ID: ");
                    int bookID = scanner.nextInt();
                    library.findBook(bookID);
                    break;
                case 4:
                    System.out.print("Enter book's ID: ");
                    bookID = scanner.nextInt();
                    library.borrowBook(bookID);
                    break;
                case 5:
                    System.out.print("Enter book's ID: ");
                    bookID = scanner.nextInt();
                    library.returnBook(bookID);
                    break;
                case 6:
                    System.out.println("Exit successfully!");
                    break;
                default:
                    System.out.println("Invalid selection");
            }
        } while (option != 6);
    }

    public static void askOption() {
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
    }
    // Phương thức hiển thị menu
    public static void showMenu() {
        System.out.println("===== Main menu =====");
        System.out.println("1. Show library information");
        System.out.println("2. Add new book");
        System.out.println("3. Find book");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Exit");
        System.out.println("================");
        System.out.println("Enter menu ID (1-6) :");
    }
}
