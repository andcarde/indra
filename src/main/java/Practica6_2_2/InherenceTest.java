package Practica6_2_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InherenceTest {
    // Tres tablas: atributos diferentes para las hijas

    public static void main(String[] args) {
        boolean isSale = false;
        String stockSymbol = "Coca";
        String companyName = "Coca-cola";
        int numShares = 1000000;
        double pricePerShare = 50.5;
        StockTransaction2 st = new StockTransaction2(
                "BUY",                       // txType
                new Date(),                   // txDate
                "Compra de acciones",         // txDescription
                12.50,                        // txFee
                true,                         // isSale
                "AAPL",                       // stockSymbol
                "Apple Inc.",                 // companyName
                100,                          // numShares
                150.75                        // pricePerShare
        );

        try {
            String txType = "?";
            Date txDate = new SimpleDateFormat("dd-MM-yyyy").parse("01-12-2025");
            String txDescription = "Bar Manolo";
            Double txFee = 5.0;
            boolean isDeposit = true;
            Double moneyAmount = 100.0;

            CashTransaction2 ct = new CashTransaction2(txType, txDate, txDescription,
                    txFee, isDeposit, moneyAmount);
            TransactionDAO.create(ct);
            TransactionDAO.create(st);

            // Única tabla con huecos null

            // Dos tablas, una para cada con datos duplicados
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
