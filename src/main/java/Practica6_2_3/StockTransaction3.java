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
@DiscriminatorValue("STOCK")
@Table(name = "3stock_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockTransaction3 extends
        BankingTransaction3 {
    private boolean isSale;
    private String stockSymbol;
    private String companyName;
    private int numShares;
    private double pricePerShare;

    public StockTransaction3(String txType, LocalDateTime txDate,
                             String txDescription, Double txFee, boolean isSale,
                             String stockSymbol, String companyName,
                             int numShares, double pricePerShare) {
        super(null, txType, txDate, txDescription, txFee);
        this.isSale = isSale;
        this.stockSymbol = stockSymbol;
        this.companyName = companyName;
        this.numShares = numShares;
        this.pricePerShare = pricePerShare;
    }
}
