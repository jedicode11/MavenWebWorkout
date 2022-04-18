package webworkout.project.view;

import webworkout.project.model.Workout;

import java.util.Scanner;

public class NewWorkoutLog implements EntityLog<Workout> {
    public static Scanner scanner = new Scanner(System.in);

    public NewWorkoutLog() {
        super();
    }

    public Workout input() {
        var workout = new Workout();
        while (workout.getTitle() == null) {
            System.out.println("Tile:");
            var sport = scanner.nextLine();
            if (sport.length() < 2) {
                System.out.println("Error: The workout title should be at least 3 characters long.");
            } else {
                workout.setTitle(sport);
            }
        }
        while (workout.getCreator() == null) {
            System.out.println("Creator (comma separated):");
            var sport = scanner.nextLine();
            if (sport.length() < 4) {
                System.out.println("Error: The workout creator should be at least 4 characters long.");
            } else {
                workout.setCreator(sport);
            }
        }
        return workout;
    }
}

