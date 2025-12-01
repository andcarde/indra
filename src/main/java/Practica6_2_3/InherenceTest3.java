package Practica6_2_3;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class InherenceTest3 {
    public static final String DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";
    // Tres tablas: atributos diferentes para las hijas

    public static void main(String[] args) {
        boolean isSale = false;
        String stockSymbol = "Coca";
        String companyName = "Coca-cola";
        int numShares = 1000000;
        double pricePerShare = 50.5;
        new StockTransaction3(isSale, stockSymbol, companyName, numShares, pricePerShare);

        try {
            String txType = "CASH";
            LocalDateTime txDate = LocalDateTime.now();

            String txDescription = "Bar Manolo";
            Double txFee = 5.0;
            boolean isDeposit = true;
            Double moneyAmount = 100.0;

            CashTransaction3 ct = new CashTransaction3(txType, txDate, txDescription,
                    txFee, isDeposit, moneyAmount);
            TransactionDAO3.create(ct);

            String txType2 = "STOCK";

            StockTransaction3 st = new StockTransaction3(txType2, txDate, txDescription,
                    txFee, isSale, stockSymbol, companyName, numShares, pricePerShare);
            TransactionDAO3.create(st);

            // Única tabla con huecos null

            // Dos tablas, una para cada con datos duplicados
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
