package Practica6;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Embeddable
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Dimensiones {
    double alto;
    double ancho;
    double profundidad;
    double peso;
}
