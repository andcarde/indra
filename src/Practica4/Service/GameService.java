package Practica4.Service;

import Practica4.Model.Hand;
import Practica4.Model.Result;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GameService {
    private final RuleService ruleService;

    public Result play(Hand player, Hand rival){
        if(player==rival){
            return new Result("Empate",0);
        } else if (ruleService.win(player,rival)) {
            return new Result(player + " gana a "+ rival + "\nGana el jugador 1",1);
        } else {
            return new Result(rival + " gana a " + player + "\nGana el jugador 2", -1);
        }
    }

    public String mostrarResultado(int i){
        if(i==0){
            return "¡Empate!";
        } else if (i>0) {
            return "¡Jugador 1 gana!";
        }
        return "¡Jugador 2 gana!";
    }
}
