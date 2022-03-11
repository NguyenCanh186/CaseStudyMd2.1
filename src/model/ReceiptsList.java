package model;

import java.io.Serializable;

public class ReceiptsList implements Serializable {
    public String nameBook;
    public int amount;

    public ReceiptsList() {
    }

    public ReceiptsList(String nameBook, int amount) {
        this.nameBook = nameBook;
        this.amount = amount;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return
                "ten sach: " + nameBook +
                ", so luong: " + amount;
    }
}
