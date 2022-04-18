package webworkout.project.model;

import webworkout.project.dao.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Coach extends User implements Identifiable<Long> {
    private List<String> dailyWorkouts = new ArrayList<>();
    private List<String> completedWorkoutsResults = new ArrayList<>();

    @Override
    public void dailyWorkout() {
    }

    public Coach(Long id, String firstName, String lastName, String username, String password, String email, String sports, int age, boolean active) {
        super(id, firstName, lastName, username, password, email, sports, age, active);
        this.setRole(Role.COACH);
    }

    public List<String> getDailyWorkouts() {
        return dailyWorkouts;
    }

    public void setDailyWorkouts(List<String> dailyWorkouts) {
        this.dailyWorkouts = dailyWorkouts;
    }

    public List<String> getCompletedWorkoutsResults() {
        return completedWorkoutsResults;
    }

    public void setCompletedWorkoutsResults(List<String> completedWorkoutsResults) {
        this.completedWorkoutsResults = completedWorkoutsResults;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Coach.class.getSimpleName() + "[", "]")
                .add("dailyWorkouts=" + dailyWorkouts)
                .add("completedWorkoutsResults=" + completedWorkoutsResults)
                .toString();
    }
}
