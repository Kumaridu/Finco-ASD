package framework.transaction;

import java.time.LocalDate;

public class Transaction implements ITransaction {
    private Double amount;
    private LocalDate date;
    private String name;

    /**
     * Create a new transaction object
     * @param amount
     * @param name (titlle of transaction)
     */
    public Transaction(String name, Double amount){
        this.amount = amount;
        this.name = name;
        this.date = LocalDate.now();
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", name='" + name + '\'' +
                '}';
    }
}
