package Practica4.Start;

import Practica4.Model.Hand;
import Practica4.Model.Result;
import Practica4.Service.GameService;
import Practica4.Service.RuleService;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        GameService game = new GameService(new RuleService());
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Piedra, Papel, Tijera, Lagarto, Spock ===");
            System.out.println("1) 1 jugador vs Máquina");
            System.out.println("2) 2 jugadores");
            System.out.println("3) Salir");
            System.out.println("Elige una opción: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    int n=0;
                    for (int i = 0; i<3 ; i++) {
                        System.out.println("Elige una mano");
                        String selection = sc.nextLine().toUpperCase();
                        Hand player = Hand.valueOf(selection);
                        Hand rival = Hand.values()[random.nextInt(Hand.values().length)];
                        System.out.println("Máquina eligió: " + rival);
                        Result r = game.play(player,rival);
                        n = n + r.getNVictories();
                        System.out.println(r.getMensaje());
                    }
                    System.out.println(game.mostrarResultado(n));
                    break;
                }

                case 2 :{
                    int n = 0;
                    for (int i = 0; i<3 ; i++) {
                        System.out.println("Jugador 1 elige una mano: ");
                        String selection1 = sc.nextLine().toUpperCase();
                        System.out.println("Jugador 2 elige una mano: ");
                        String selection2 = sc.nextLine().toUpperCase();
                        Hand player1 = Hand.valueOf(selection1);
                        Hand player2 = Hand.valueOf(selection2);
                        System.out.println("Jugador 1 eligió: " + selection1);
                        System.out.println("Jugador 2 eligió: " + selection2);
                        Result r = game.play(player1,player2);
                        n = n + r.getNVictories();
                        System.out.println(r.getMensaje());
                    }
                    System.out.println(game.mostrarResultado(n));
                    break;
                }
                case 3 : exit = true;
            }
        }
    }
}
