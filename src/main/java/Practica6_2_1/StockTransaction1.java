package Practica6_2_1;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "stock_transaction1")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockTransaction1 extends
        BankingTransaction1 {
    private boolean isSale;
    private String stockSymbol;
    private String companyName;
    private int numShares;
    private double pricePerShare;

    public StockTransaction1(String txType, Date txDate, String txDescription, Double txFee,
                             boolean isSale, String stockSymbol, String companyName, int numShares, double pricePerShare) {
        super(null, txType, txDate, txDescription, txFee);
        this.isSale = isSale;
        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.numShares = numShares;
        this.pricePerShare = pricePerShare;
    }
}
