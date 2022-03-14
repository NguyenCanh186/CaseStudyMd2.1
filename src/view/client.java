package view;

import controller.ManagerLibrary;
import model.Receipts;

import java.util.Scanner;
import java.util.regex.Pattern;

public class client {

    public static void main(String[] args) {
        while (ManagerLibrary.login() == true) {
            int choose = -1;
            while (choose != 0) {
                System.out.println("                         |----------------------------------------------------------------|");
                System.out.println("                         |---------              SÁCH TRONG THƯ VIỆN              --------|");
                System.out.println("                         |----------------------------------------------------------------|");
                System.out.println("<--------------------------------------------------------------------------------------------------------------->");
                ManagerLibrary.showAllBook();
                System.out.println("<--------------------------------------------------------------------------------------------------------------->");
                System.out.println("Menu");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Thêm sách mới");
                System.out.println("2. Sửa sách trong thư viện");
                System.out.println("3. Xóa sách trong thư viện");
                System.out.println("4. Tìm kiếm sách");
                System.out.println("5. Cho mượn sách");
                System.out.println("6. Trả sách");
                System.out.println("7. Sách đã cho mượn");
                System.out.println("8. Sách đã trả");
                System.out.println("Nhập lựa chọn của bạn: ");
                Pattern p = Pattern.compile("^[1-8]$");
                String choose1 = scanner.nextLine();
                if (p.matcher(choose1).find())
                    switch (choose1) {
                        case "1":
                            ManagerLibrary.addBook();
                            break;
                        case "2":
                            ManagerLibrary.editBookByName();
                            break;
                        case "3":
                            ManagerLibrary.deleteBookByName();
                            break;
                        case "4":
                            System.out.println("1. Tìm kiếm sách theo tên");
                            System.out.println("2. Tìm kiếm sách theo tác giả");
                            System.out.println("3. Tìm kiếm sách theo thể loại");
                            System.out.println("Nhập lựa chọn của bạn: ");
                            Scanner sc = new Scanner(System.in);
                            int choice = sc.nextInt();
                            switch (choice){
                                case 1:
                                    ManagerLibrary.searchBookByName();
                                    break;
                                case 2:
                                    ManagerLibrary.searchBookByAuthor();
                                    break;
                                case 3:
                                    ManagerLibrary.searchBookByCategory();
                                    break;
                            }
                            break;
                        case "5":
                            ManagerLibrary.lendBooks();
                            break;
                        case "6":
                            ManagerLibrary.giveBookBack();
                            break;
                        case "7":
                            System.out.println("                          |----------------------------------------------------------------|");
                            System.out.println("                          |---------     Danh sách những cuốn sách đã cho mượn     --------|");
                            System.out.println("                          |----------------------------------------------------------------|");
                            System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                            boolean result = ManagerLibrary.lentBooks.isEmpty();
                            if (result == true) {
                                System.out.println("                                              Danh sách rỗng!!!");
                            }else {
                                ManagerLibrary.showAllLentBook();
                            }
                            System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                            break;
                        case "8":
                            System.out.println("1. Hiển thị danh sách");
                            System.out.println("2. Xóa danh sách đã trả");
                            Scanner scanner1 = new Scanner(System.in);
                            int choose8 = scanner1.nextInt();
                            switch (choose8){
                                case 1:
                                    System.out.println("                    |------------------------------------------------------------------------|");
                                    System.out.println("                    |---------     Danh sách những cuốn sách đã trả cho thư viện     --------|");
                                    System.out.println("                    |------------------------------------------------------------------------|");
                                    System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                                    boolean result1 = ManagerLibrary.paidBooks.isEmpty();
                                    if (result1 == true)
                                        System.out.println("                                               Danh sách rỗng!!!");
                                    else
                                        ManagerLibrary.showAllPaidBook();
                                    System.out.println("<---------------------------------------------------------------------------------------------------------------->");
                                    break;
                                case 2:
                                    ManagerLibrary.removeListPaidBook();
                                    System.out.println("Đã xóa");
                                    break;
                            }
                    }
                else
                    System.out.println("Lựa chọn của bạn không hợp lệ!!! Vui lòng nhập lại");
            }
        }
    }
}
