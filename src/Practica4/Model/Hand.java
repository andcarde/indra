package Practica4.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Hand {
    PIEDRA("Piedra", "✊"),
    PAPEL("Papel", "📜"),
    TIJERAS("Tijeras", "✂️"),
    LAGARTO("Lagarto", "🦎"),
    SPOCK("Spock", "🖖");

    private final String nombre;
    private final String emoji;


    @Override
    public String toString() {
        return nombre + " " + emoji;
    }
}


