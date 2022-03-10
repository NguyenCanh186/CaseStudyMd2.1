package model;

import controller.ManagerLibrary;
import storage.LentBookFile;

import java.time.LocalDate;
import java.util.ArrayList;

import static controller.ManagerLibrary.lentBookFile;


public class Receipts {

    public double code;
    public static ArrayList<LentBook> lentBooks = lentBookFile.readFile();

    public double getCode() {
        double a = Math.random();
        return a * 1000000000 + 1;
    }

    public void setCode(double code) {
        this.code = code;
    }

    public  String toString(){
        return "Mã phiếu thu: " + getCode() + "\n" +
                "ngày mượn: "  + lentBooks.get(0).getBorrowedDate() + "\n" +
                "tên khách hàng: " + lentBooks.get(0).getBorrowerName() + "\n" +
                "danh sách mượn:\n";
    }
}
