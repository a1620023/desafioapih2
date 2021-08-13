package io.emelceledonio.DesafioAPIH2.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_rateExchange")
public class RateExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String currencyType; // tipo de moneda
    double purchasePrice; // precio de compra
    double sellingPrice; // preco de venta

    public RateExchange() {
    }

    public RateExchange(Long id, String currencyType, double purchasePrice, double sellingPrice) {
        this.id = id;
        this.currencyType = currencyType;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
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
        return id.equals(that.id) && currencyType.equals(that.currencyType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencyType);
    }

    @Override
    public String toString() {
        return "RateExchamnge{" +
                "id=" + id +
                ", currencyType='" + currencyType + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
