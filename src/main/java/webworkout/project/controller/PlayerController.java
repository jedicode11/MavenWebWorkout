package webworkout.project.controller;


import webworkout.project.model.Player;
import webworkout.project.service.PlayerService;
import webworkout.project.view.Menu;
import webworkout.project.view.NewPlayerLog;

import java.util.List;

public class PlayerController {
    private PlayerService playerService;

    public PlayerController (PlayerService playerService) {
        this.playerService = playerService;
    }

    public void init() {
        var menu = new Menu("Main Menu", List.of(
                new Menu.Option("Generate Players", () -> {
                    System.out.println("Generate PLayers ...");
                    return "Players loaded successfully.";
                }),
                new Menu.Option("Show Full List of Players", () -> {
                    var players = playerService.getAllPlayers();
                    players.forEach(System.out::println);
                    return "Total workout count: " + playerService.getAllPlayers();
                }),
                new Menu.Option("Add New workouts", () -> {
                    Player player = new NewPlayerLog().input();
                    var created = playerService.getPlayerById(player);
                    return String.format("Workout ID: '%s' added successfully", player.getId());
                })
        ));
        menu.show();
    }
}
