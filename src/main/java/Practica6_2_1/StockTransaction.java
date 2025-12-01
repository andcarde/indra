package Practica6_2_1;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "stock_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockTransaction extends
        BankingTransaction {
    private boolean isSale;
    private String stockSymbol;
    private String companyName;
    private int numShares;
    private double pricePerShare;
}
