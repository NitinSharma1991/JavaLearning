package learning.functional;

import java.util.Currency;


public record Transaction(Trader trader, int year, int value, Currency currency) {

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }

}