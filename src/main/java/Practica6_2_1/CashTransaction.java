package Practica6_2_1;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "cash_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashTransaction extends BankingTransaction {
    private boolean isDeposit;
    private Double moneyAmount;

    public CashTransaction(String txType, Date txDate,
            String txDescription, Double txFee, boolean isDeposit,
            Double moneyAmount) {
        super(null, txType, txDate, txDescription, txFee);
        this.isDeposit = isDeposit;
        this.moneyAmount = moneyAmount;
    }
}