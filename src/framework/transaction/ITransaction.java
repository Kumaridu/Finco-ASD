package framework.transaction;

import java.time.LocalDate;

public interface ITransaction {
    public Double getAmount();

    public LocalDate getDate();

    public String getName();
}
