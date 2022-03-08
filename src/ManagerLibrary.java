import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerLibrary {
    public static ArrayList<Book> books = new ArrayList<>();
    public static ArrayList<LentBook> lentBooks = new ArrayList<>();
    public static ArrayList<PaidBooks> paidBooks = new ArrayList<>();

    public static void book(){
        Book book = new Book(1, "trên đường băng", "Tony", "phát triển bản thân", 90000);
        Book book2 = new Book(2, "cà phê cùng Tony", "tony", "phát triển banr thân", 80000);
        Book book3 = new Book(3, "Conan", "Fuji", "truyện tranh", 45000);
        Book book4 = new Book(4, "Doraemon", "Ayaka", "Truyện tranh", 50000);
        Book book5 = new Book(5, "Việt Nam thời @", "Nguyễn Cừ", "truyện cười", 50000);
        Book book6 = new Book(6, "Cười ra vàng", "nhiều tác giả", "truyện cười", 65000);
        Book book7 = new Book(7, "giải mã bí ẩn phái đẹp", "Lai.H", "tâm lí phụ nữ", 150000);
        Book book8 = new Book(8, "No Friend Zone", "Lai.H", "tâm lí phụ nữ", 300000);
        Book book9 = new Book(9, "vợ nhặt", "Kim Lân", "văn học", 70000);
        Book book10 = new Book(10, "tắt đèn", "Ngô Tất Tố", "văn học", 85000);
        books.add(book);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);
        for (Book b: books
        ) {
            System.out.println(b.toString());
        }
    }

    public static void showAllBook(){
        for (Book b: books
             ) {
            System.out.println(b.toString());
        }
    }

    public static void showAllLentBook(){
        for (LentBook l: lentBooks
             ) {
            System.out.println(l);
        }
    }

    public static void showAllPaidBook(){
        for (PaidBooks p: paidBooks
             ) {
            System.out.println(p);
        }
    }

    public static void addBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id: ");
        int id = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("nhập tên sách: ");
        String name = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("nhập tên tác giả: ");
        String author = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("nhập thể loại sách: ");
        String category = scanner3.nextLine();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("nhập giá: ");
        double price = scanner4.nextDouble();

        Book book = new Book(id, name, author, category, price);
        books.add(book);
    }

    public static void editBookByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn sách muốn chỉnh sửa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)){
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("nhập id: ");
                int id = scanner1.nextInt();

                Scanner scanner2 = new Scanner(System.in);
                System.out.println("nhập tên sách: ");
                String name1 = scanner2.nextLine();

                Scanner scanner3 = new Scanner(System.in);
                System.out.println("nhập tên tác giả: ");
                String author = scanner3.nextLine();

                Scanner scanner4 = new Scanner(System.in);
                System.out.println(" nhập thể loại sách: ");
                String category = scanner4.nextLine();

                Scanner scanner5 = new Scanner(System.in);
                System.out.println("nhập giá: ");
                double price = scanner5.nextDouble();

                books.get(i).setId(id);
                books.get(i).setName(name1);
                books.get(i).setAuthor(author);
                books.get(i).setCategory(category);
                books.get(i).setPrice(price);
            } else {
                System.out.println("cuốn sách này không có trong thư viện!!!");
            }
        }
    }

    public static void deleteBookByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn sách muốn xóa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)){
                books.remove(books.get(i));
            } else {
                System.out.println("cuốn sách này không có trong thư viện!!!");
            }
        }
    }

    public static void lentBookList(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn cho mượn: ");
        String lentBookName = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(lentBookName)){
                System.out.println("nhập ngày cho mượn: ");
                Scanner scanner1 = new Scanner(System.in);
                int day = scanner1.nextInt();

                System.out.println("nhập tháng: ");
                Scanner scanner2 = new Scanner(System.in);
                int month = scanner2.nextInt();

                System.out.println("nhập năm: ");
                Scanner scanner3 = new Scanner(System.in);
                int year = scanner3.nextInt();

                LocalDate date = LocalDate.of(year, month, day);
                LentBook lentBook = new LentBook(books.get(i).getId(), books.get(i).getName(), books.get(i).getAuthor(), books.get(i).getCategory(), books.get(i).getPrice(), date);
                lentBooks.add(lentBook);
                books.remove(books.get(i));
            } else {
                System.out.println("tên cuốn sách bạn nhập không hợp lệ!!");
            }
        }
    }

    public static void paidBookList(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập tên cuốn sách khách trả cho thư viện: ");
        String name = scanner.nextLine();
        for (int i = 0; i < lentBooks.size(); i++) {
            if (lentBooks.get(i).getName().equals(name)){
                System.out.println("nhập ngày trả: ");
                Scanner scanner1 = new Scanner(System.in);
                int day = scanner1.nextInt();

                System.out.println("nhập tháng: ");
                Scanner scanner2 = new Scanner(System.in);
                int month = scanner2.nextInt();

                System.out.println("nhập năm: ");
                Scanner scanner3 = new Scanner(System.in);
                int year = scanner3.nextInt();

                LocalDate date = LocalDate.of(year, month, day);
                PaidBooks paidBook = new PaidBooks(lentBooks.get(i).getId(), lentBooks.get(i).getName(), lentBooks.get(i).getAuthor(), lentBooks.get(i).getCategory(), lentBooks.get(i).getPrice(), date);
                paidBooks.add(paidBook);
                lentBooks.remove(lentBooks.get(i));
                Book book = new Book(lentBooks.get(i).getId(), lentBooks.get(i).getName(), lentBooks.get(i).getAuthor(), lentBooks.get(i).getCategory(), lentBooks.get(i).getPrice());
                books.add(book);
            } else {
                System.out.println("Tên cuốn sách không hợp lệ!!! ");
            }
        }
    }

}
