package webworkout.project.view;

import webworkout.project.model.Player;

import java.util.Scanner;

public class NewPlayerLog implements EntityLog<Player> {
    public static Scanner scanner = new Scanner(System.in);

    public NewPlayerLog() {
        super();
    }

    public Player input() {
        var player = new Player();
        while (player.getId() == null) {
            System.out.println("Tile:");
            var plr = scanner.nextLine();
            if (plr.length() < 2) {
                System.out.println("Error: The player Id should be at least 4 characters long.");
            } else {
                player.setAge(0);
            }
        }
        while (player.getUsername() == null) {
            System.out.println("Player Username (comma separated):");
            var playerSport = scanner.nextLine();
            if (playerSport.length() < 4) {
                System.out.println("Error: The player creator should be at least 3 characters long.");
            } else {
                player.setSports(playerSport);
            }
        }
        return player;
    }
}

