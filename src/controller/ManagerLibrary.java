package controller;

import model.*;
import storage.BookFile;
import storage.LentBookFile;
import storage.PaidBookFile;
import storage.ReceiptsFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerLibrary {
    public static BookFile bookFile = new BookFile();
    public static LentBookFile lentBookFile = new LentBookFile();
    public static PaidBookFile paidBookFile = new PaidBookFile();
    public static ArrayList<Book> books = bookFile.readFile();
    public static ArrayList<LentBook> lentBooks = lentBookFile.readFile();
    public static ArrayList<PaidBooks> paidBooks = paidBookFile.readFile();
    public static ReceiptsFile receiptsFile = new ReceiptsFile();
    public static ArrayList<ReceiptsList> receiptsLists = receiptsFile.readFile();
    public static ArrayList<LibraryManagerName> libraryManagerNames = new ArrayList<>();

    public static boolean login() {
        LibraryManagerName name1 = new LibraryManagerName("CanhNguyen");
        LibraryManagerName name2 = new LibraryManagerName("NgocAnh");
        libraryManagerNames.add(name1);
        libraryManagerNames.add(name2);
        Scanner scanner = new Scanner(System.in);
        System.out.println("|----------------------------------------------------------------------------------|");
        System.out.println("|-----                                LOGIN                                   -----|");
        System.out.println("|----------------------------------------------------------------------------------|");
        System.out.println("Nhập tên người quản lý: ");
        String name = scanner.nextLine();
        boolean check = false;
        for (int i = 0; i < libraryManagerNames.size(); i++) {
            if (libraryManagerNames.get(i).getManagerName().equals(name)) {
                check = true;
            }
        }
        return check;
    }

    public static void showAllBook() {
        for (Book b : books
        ) {
            System.out.println(b.toString());
        }
    }

    public static void showAllLentBook() {
        for (LentBook l : lentBooks
        ) {
            System.out.println(l.toString());
        }
    }

    public static void showAllPaidBook() {
        for (PaidBooks p : paidBooks
        ) {
            System.out.println(p.toString());
        }
    }

    public static void addBook() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id: ");
        int id = scanner.nextInt();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập tên sách: ");
        String name = scanner1.nextLine();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập tên tác giả: ");
        String author = scanner2.nextLine();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập thể loại sách: ");
        String category = scanner3.nextLine();

        Scanner scanner5 = new Scanner(System.in);
        System.out.println("Nhập số lượng: ");
        int amount = scanner5.nextInt();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập giá: ");
        double price = scanner4.nextDouble();

        Book book = new Book(id, name, author, category, amount, price);
        books.add(book);
        try {
            bookFile.writeFile(books);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public static void listLentBook(){
//        Receipts receipts = new Receipts();
//        for (int i = 0; i < lentBooks.size(); i++) {
//            System.out.println(receipts.toString(i));
//            System.out.println("tên sách đã mượn: " + lentBooks.get(i).getName());
//            System.out.println("Số lượng: " + lentBooks.get(i).getAmount());
//        }
//    }



    public static void editBookByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên cuốn sách muốn chỉnh sửa: ");
        String name = scanner.nextLine();
        int check  = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                check = i;
                break;
            }
        }

        if (check != -1){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Nhập id: ");
            int id = scanner1.nextInt();

            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Nhập tên sách: ");
            String name1 = scanner2.nextLine();

            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Nhập tên tác giả: ");
            String author = scanner3.nextLine();

            Scanner scanner4 = new Scanner(System.in);
            System.out.println(" Nhập thể loại sách: ");
            String category = scanner4.nextLine();

            Scanner scanner6 = new Scanner(System.in);
            System.out.println("Nhập số lượng: ");
            int amount = scanner6.nextInt();

            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Nhập giá: ");
            double price = scanner5.nextDouble();

            books.get(check).setId(id);
            books.get(check).setName(name1);
            books.get(check).setAuthor(author);
            books.get(check).setCategory(category);
            books.get(check).setAmount(amount);
            books.get(check).setPrice(price);
        } else {
            System.out.println("Cuốn sách này không có trong thư viện!!!");
        }
        try {
            bookFile.writeFile(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBookByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên cuốn sách muốn xóa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                books.remove(books.get(i));
                try {
                    bookFile.writeFile(books);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Cuốn sách này không có trong thư viện!!!");
            }
        }
    }

    public static void lendBooks() {
        Receipts receipts = new Receipts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên người mượn: ");
        String borrowerName = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Nhập ngày: ");
        int day = scanner1.nextInt();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Nhập tháng: ");
        int month = scanner2.nextInt();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Nhập năm: ");
        int year = scanner3.nextInt();

        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Nhập số tên sách muốn mượn: ");
        int numberBook = scanner4.nextInt();

        int conditionCheck = -1;
        double price = 0;
        double sum = 0;


        for (int i = 0; i < numberBook; i++) {
            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Nhập tên sách " + (i + 1) + ":");
            String lentBookName = scanner5.nextLine();
            int check = -1;
            for (int k = 0; k < books.size(); k++) {
                if (books.get(k).getName().equals(lentBookName)) {
                    check = k;
                    price = books.get(k).getPrice();
                    conditionCheck = k;
                    break;
                }
            }
            if (check != -1){
                Scanner scanner7 = new Scanner(System.in);
                System.out.println("Nhập số lượng: ");
                int amount = scanner7.nextInt();
                sum += price * amount;
                ReceiptsList receiptsList = new ReceiptsList(lentBookName, amount);
                receiptsLists.add(receiptsList);
                try {
                    receiptsFile.writeFile(receiptsLists);
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println("ten sach: " + lentBookName);
//                System.out.println("so luong: " + amount);

                LocalDate date = LocalDate.of(year, month, day);

                int difference = 0;
                if (amount < books.get(check).getAmount()) {
                    difference = books.get(check).getAmount() - amount;
                    books.get(check).setId(books.get(check).getId());
                    books.get(check).setName(books.get(check).getName());
                    books.get(check).setAuthor(books.get(check).getAuthor());
                    books.get(check).setCategory(books.get(check).getCategory());
                    books.get(check).setAmount(difference);
                    books.get(check).setPrice(books.get(check).getPrice());

                    LentBook lentBook = new LentBook(books.get(check).getId(), books.get(check).getName(), books.get(check).getAuthor(),
                            books.get(check).getCategory(), amount, books.get(check).getPrice(), date, borrowerName);
                    lentBooks.add(lentBook);
                } else if (amount == books.get(check).getAmount()){
                    LentBook lentBook = new LentBook(books.get(check).getId(), books.get(check).getName(), books.get(check).getAuthor(),
                            books.get(check).getCategory(), amount, books.get(check).getPrice(), date, borrowerName);
                    lentBooks.add(lentBook);
                    books.remove(books.get(check));
                } else {
                    System.out.println("Số sách trong thư viện không đủ cho yêu cầu này");
                }
                try {
                    lentBookFile.writeFile(lentBooks);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bookFile.writeFile(books);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Cuốn sách bạn tìm không có trong thư viện!");
            }
        }
        if (conditionCheck != -1){
        System.out.println(receipts.toString());
        System.out.println("Ngày mượn: " + LocalDate.of(year, month, day));
        System.out.println("Họ và tên: " + borrowerName);
        System.out.println("Danh sách: ");
            for (int i = 0; i < receiptsLists.size(); i++) {
                System.out.println("Tên sách " + (i + 1) +": " + receiptsLists.get(i).getNameBook());
                System.out.println( "Số lượng: " + receiptsLists.get(i).getAmount());
            }
            System.out.println("Tạm thu: " + sum + " USD");
            try {
                receiptsFile.writeFile(receiptsLists);
            } catch (IOException e) {
                e.printStackTrace();
            }
            receiptsLists.removeAll(receiptsLists);
            try {
                receiptsFile.writeFile(receiptsLists);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void giveBookBack() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên cuốn sách khách trả cho thư viện: ");
        String name = scanner.nextLine();
        int check = -1;
        for (int i = 0; i < lentBooks.size(); i++) {
            if (lentBooks.get(i).getName().equals(name)) {
                check = i;
                break;
            }
        }
        if (check != -1){
            System.out.println("Nhập ngày trả: ");
            Scanner scanner1 = new Scanner(System.in);
            int day = scanner1.nextInt();

            System.out.println("Nhập tháng: ");
            Scanner scanner2 = new Scanner(System.in);
            int month = scanner2.nextInt();

            System.out.println("Nhập năm: ");
            Scanner scanner3 = new Scanner(System.in);
            int year = scanner3.nextInt();

            System.out.println("Nhập tên người trả sách: ");
            Scanner scanner4 = new Scanner(System.in);
            String payerName = scanner4.nextLine();

            Scanner scanner5 = new Scanner(System.in);
            System.out.println("Nhập số lượng: ");
            int amount = scanner5.nextInt();

            LocalDate date = LocalDate.of(year, month, day);
            if (amount == lentBooks.get(check).getAmount()) {
                PaidBooks paidBook = new PaidBooks(lentBooks.get(check).getId(), lentBooks.get(check).getName(),
                        lentBooks.get(check).getAuthor(), amount, lentBooks.get(check).getCategory(), lentBooks.get(check).getPrice(), date, payerName);
                paidBooks.add(paidBook);
                int index = -1;
                for (int j = 0; j < books.size(); j++) {
                    if (books.get(j).getName().equals(name)) {
                        index = j;
                        break;
                    }
                }
                if (index != -1){
                    books.get(index).setAmount(books.get(index).getAmount() + amount);
                }  else {
                    Book book = new Book(lentBooks.get(check).getId(), lentBooks.get(check).getName(), lentBooks.get(check).getAuthor(),
                            lentBooks.get(check).getCategory(), amount, lentBooks.get(check).getPrice());
                    books.add(book);
                    lentBooks.remove(lentBooks.get(check));
                }
            } else if (amount < lentBooks.get(check).getAmount()) {
                PaidBooks paidBook = new PaidBooks(lentBooks.get(check).getId(), lentBooks.get(check).getName(),
                        lentBooks.get(check).getAuthor(), amount, lentBooks.get(check).getCategory(),
                        lentBooks.get(check).getPrice(), date, payerName);
                paidBooks.add(paidBook);
                lentBooks.get(check).setAmount(lentBooks.get(check).getAmount() - amount);
                int index = -1;
                for (int j = 0; j < books.size(); j++) {
                    if (books.get(j).getName().equals(name)) {
                        index = j;
                        break;
                    }
                }
                if (index != -1){
                    books.get(index).setAmount(books.get(index).getAmount() + amount);
                } else {
                    Book book = new Book(lentBooks.get(check).getId(), lentBooks.get(check).getName(), lentBooks.get(check).getAuthor(),
                            lentBooks.get(check).getCategory(), amount, lentBooks.get(check).getPrice());
                    books.add(book);
                }
            }

            try {
                paidBookFile.writeFile(paidBooks);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                lentBookFile.writeFile(lentBooks);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bookFile.writeFile(books);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Tên cuốn sách bạn trả không hợp lệ!!!!");
        }
    }

    public static void searchBookByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên cuốn sách bạn muốn tìm: ");
        String bookName = scanner.nextLine();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(bookName)) {
                System.out.println(books.get(i).toString());
            } else {
                for (int j = 0; j < lentBooks.size(); j++) {
                    if (lentBooks.get(i).getName().equals(bookName)) {
                        System.out.println("Cuốn sách này đã có người mượn. Vui lòng kiểm tra trong danh sách mượn");
                    } else {
                        System.out.println("Cuốn sách bạn tìm không có trong thư viện!!!");
                    }
                }
            }
        }
    }

    public static void searchBookByAuthor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên tác giả bạn muốn tìm: ");
        String authorName = scanner.nextLine();

        int check = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getAuthor().equals(authorName)){
                System.out.println(books.get(i).toString());
                check = i;
            }
        }
        if (check == -1){
            System.out.println("Không tìm thấy tên tác giả này trong thư viện");
        }
    }

    public static void searchBookByCategory(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên thể loại bạn muốn tìm: ");
        String categoryName = scanner.nextLine();

        int check = -1;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCategory().equals(categoryName)){
                System.out.println(books.get(i).toString());
                check = i;
            }
        }
        if (check == -1){
            System.out.println("Không tìm thấy tên thể loại này trong thư viện");
        }
    }

    public static void removeListPaidBook () {
        paidBooks.removeAll(paidBooks);
        try {
            paidBookFile.writeFile(paidBooks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
