import java.time.LocalDate;

public class PaidBooks extends Book{
    public LocalDate payDay;

    public PaidBooks(LocalDate payDay) {
        this.payDay = payDay;
    }

    public PaidBooks(int id, String name, String author, String category, double price, LocalDate payDay) {
        super(id, name, author, category, price);
        this.payDay = payDay;
    }

    public LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(LocalDate payDay) {
        this.payDay = payDay;
    }

    @Override
    public String toString() {
        return "PaidBooks{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", payDay=" + payDay +
                '}';
    }
}
