package Practica6_2_2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// InheritanceType.TABLE_PER_CLASS -> Estrategia de 2 tablas
// InheritanceType.JOINED -> Estrategia de 3 tablas
// InheritanceType.SINGLE_TABLE -> Estrategia de 1 tabla

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "banking_transaction2")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BankingTransaction2 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String txType = null;
    private Date txDate = null;
    private String txDescription = null;
    private Double txFee = null;

//    public BankingTransaction(String txType, Date txDate,
//            String txDescription, Double txFee) {
//        this.txType = txType;
//        this.txDate = txDate;
//        this.txDescription = txDescription;
//        this.txFee = txFee;
//    }
}
