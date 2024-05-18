import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class Library {
    private String libraryName;
    private ArrayList<Book> bookList;
    private static final int MAX_NUMBER_OF_BOOKS = 100;
    private static int numberOfBooks = 0;

    // Constructor
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.bookList = new ArrayList<>();
    }

    // Phương thức thêm sách mới
    public void addNewBook() {
        if (numberOfBooks >= MAX_NUMBER_OF_BOOKS) {
            System.out.println("Thư viện đã đầy, không thể thêm sách mới.");
            return;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã sách: ");
        int bookID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tiêu đề sách: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Nhập số lượng sách: ");
        int amount = scanner.nextInt();

        // Kiểm tra mã sách trùng
        for (Book book : bookList) {
            if (book.getBookID() == bookID) {
                System.out.println("This book is exist!");
                return;
            }
        }

        Book newBook = new Book(bookID, bookTitle, amount);
        bookList.add(newBook);
        numberOfBooks++;
        System.out.println("Add book successfully!");
    }

    // Phương thức tìm kiếm sách
    public boolean findBook(int bookID) {
        for (Book book : bookList) {
            if (book.getBookID()==bookID) {
                book.showBookInfo();
                return true;
            }
        }
        System.out.println("Didn't find the book with ID: " + bookID);
        return false;
    }

    // Phương thức mượn sách
    public void borrowBook(int bookID) {
        for (Book book : bookList) {
            if (book.getBookID()==bookID) {
                if (book.getAvailable() > 0) {
                    book.setAvailable(book.getAvailable() - 1);
                    System.out.println("The book is borrowed successfully!");
                } else {
                    System.out.println("This book is not available!");
                }
                book.showBookInfo();
                return;
            }
        }
        System.out.println("Didn't find the book with ID: " + bookID);
    }

    public void returnBook(int bookID) {
        for (Book book : bookList ){
            if ( book.getBookID() == bookID ){
                book.setAvailable(book.getAvailable()+1);
                System.out.println("The book returned successfully!");
                book.showBookInfo();
                return;
            }
        }
        System.out.println("Didn't find the book with ID: " + bookID);
    }

    public void showLibraryInfo() {
        System.out.println("Library's Name: " + libraryName);
        System.out.println("Number of Books: " + numberOfBooks);
        for (Book book : bookList) {
            book.showBookInfo();
            System.out.println("------------------");
        }
    }
}
