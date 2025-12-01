package Practica6_2_3;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@DiscriminatorValue("CASH")
@Table(name = "3cash_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CashTransaction3 extends BankingTransaction3 {
    private boolean isDeposit;
    private Double moneyAmount;

    public CashTransaction3(String txType, LocalDateTime txDate,
                            String txDescription, Double txFee, boolean isDeposit,
                            Double moneyAmount) {
        super(null, txType, txDate, txDescription, txFee);
        this.isDeposit = isDeposit;
        this.moneyAmount = moneyAmount;
    }
}