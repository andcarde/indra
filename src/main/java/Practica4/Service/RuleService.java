package Practica4.Service;

import Practica4.Model.Hand;

import java.util.Map;
import java.util.Set;

public class RuleService {
    private final Map<Hand, Set<Hand>> rules = Map.of(
            Hand.TIJERAS, Set.of(Hand.PAPEL, Hand.LAGARTO),
            Hand.PAPEL, Set.of(Hand.PIEDRA, Hand.SPOCK),
            Hand.PIEDRA, Set.of(Hand.LAGARTO, Hand.TIJERAS),
            Hand.SPOCK, Set.of(Hand.TIJERAS, Hand.PIEDRA),
            Hand.LAGARTO, Set.of(Hand.SPOCK, Hand.PAPEL)
    );

    public boolean win(Hand player, Hand rival){
        return rules.get(player).contains(rival);
    }
}
