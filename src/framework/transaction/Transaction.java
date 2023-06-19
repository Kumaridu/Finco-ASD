package framework.transaction;

import java.time.LocalDate;

public class Transaction implements ITransaction {

    private Double amount;
    private LocalDate date;
    private String name;

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
