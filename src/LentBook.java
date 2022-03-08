import java.time.LocalDate;

public class LentBook extends Book{
    public LocalDate borrowedDate;

    public LentBook(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LentBook(int id, String name, String author, String category, double price, LocalDate borrowedDate) {
        super(id, name, author, category, price);
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    @Override
    public String toString() {
        return "LentBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", borrowedDate=" + borrowedDate +
                '}';
    }
}
