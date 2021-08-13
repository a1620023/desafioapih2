package io.emelceledonio.DesafioAPIH2.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_rateExchange")
public class RateExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String entryCurrencyType; // tipo de moneda
    String departureCurrencyType;
    double purchasePrice; // precio de compra
    double sellingPrice; // preco de venta

    public RateExchange() {
    }

    public RateExchange(Long id, String entryCurrencyType, String departureCurrencyType, double purchasePrice, double sellingPrice) {
        this.id = id;
        this.entryCurrencyType = entryCurrencyType;
        this.departureCurrencyType = departureCurrencyType;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryCurrencyType() {
        return entryCurrencyType;
    }

    public void setEntryCurrencyType(String entryCurrencyType) {
        this.entryCurrencyType = entryCurrencyType;
    }

    public String getDepartureCurrencyType() {
        return departureCurrencyType;
    }

    public void setDepartureCurrencyType(String departureCurrencyType) {
        this.departureCurrencyType = departureCurrencyType;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateExchange that = (RateExchange) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RateExchange{" +
                "id=" + id +
                ", entryCurrencyType='" + entryCurrencyType + '\'' +
                ", departureCurrencyType='" + departureCurrencyType + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
