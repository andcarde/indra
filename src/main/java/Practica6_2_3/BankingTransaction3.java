package Practica6_2_3;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

// InheritanceType.TABLE_PER_CLASS -> Estrategia de 2 tablas
// InheritanceType.JOINED -> Estrategia de 3 tablas
// InheritanceType.SINGLE_TABLE -> Estrategia de 1 tabla

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TX_TYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name = "3banking_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BankingTransaction3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String txType;
    private LocalDateTime txDate;
    private String txDescription;
    private Double txFee;

}
