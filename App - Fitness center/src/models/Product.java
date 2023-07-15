package models;
import java.io.Serializable;
import static utils.CurrencyFormat.covertPriceToString;

public class Product implements Serializable {
    private static final long serialVersionUID = 2L;
    private int id;
    private String nameCard;
    private double priceCardClass;
    private int expiryDate;
    private String status;

    public Product(int id, String cardClass, double priceCardClass, int expiryDate, String status) {
        this.id = id;
        this.nameCard = cardClass;
        this.priceCardClass = priceCardClass;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public double getPriceCardClass() {
        return priceCardClass;
    }

    public void setPriceCardClass(double priceCardClass) {
        this.priceCardClass = priceCardClass;
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-10s | %-10s | %-12s | %-20s | \n",
                id, nameCard,expiryDate, status, covertPriceToString(priceCardClass));

    }
}
