package io.emelceledonio.DesafioAPIH2.Model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_currencyExchange")
public class CurrencyExchange {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    double amount; // monto inicial
    String entryCurrency; // moneda de origen
    String departureCurrency; // moneda de destino
    double exchangedAmount; // cantidad final al cambio

    public CurrencyExchange() {
    }

    public CurrencyExchange(Long id, double amount, String entryCurrency, String departureCurrency, double exchangedAmount) {
        this.id = id;
        this.amount = amount;
        this.entryCurrency = entryCurrency;
        this.departureCurrency = departureCurrency;
        this.exchangedAmount = exchangedAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getEntryCurrency() {
        return entryCurrency;
    }

    public void setEntryCurrency(String entryCurrency) {
        this.entryCurrency = entryCurrency;
    }

    public String getDepartureCurrency() {
        return departureCurrency;
    }

    public void setDepartureCurrency(String departureCurrency) {
        this.departureCurrency = departureCurrency;
    }

    public double getExchangedAmount() {
        return exchangedAmount;
    }

    public void setExchangedAmount(double exchangedAmount) {
        this.exchangedAmount = exchangedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyExchange that = (CurrencyExchange) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "id=" + id +
                ", amount=" + amount +
                ", entryCurrency='" + entryCurrency + '\'' +
                ", departureCurrency='" + departureCurrency + '\'' +
                ", exchangedAmount=" + exchangedAmount +
                '}';
    }
}
