package Practica6_2_2;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "stock_transaction2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockTransaction2 extends
        BankingTransaction2 {
    private boolean isSale;
    private String stockSymbol;
    private String companyName;
    private int numShares;
    private double pricePerShare;

    public StockTransaction2(String txType, Date txDate, String txDescription, Double txFee,
                             boolean isSale, String stockSymbol, String companyName, int numShares, double pricePerShare) {
        super(null, txType, txDate, txDescription, txFee);
        this.isSale = isSale;
        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.numShares = numShares;
        this.pricePerShare = pricePerShare;
    }
}
