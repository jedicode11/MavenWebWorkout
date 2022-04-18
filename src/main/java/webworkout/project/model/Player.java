package webworkout.project.model;

import webworkout.project.dao.Identifiable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Player extends User implements Identifiable<Long> {
    private List<String> assignedWorkouts = new ArrayList<>();
    private List<String> completedWorkoutsResults = new ArrayList<>();
    private List<String> favoriteWorkouts = new ArrayList<>();

    LocalDateTime startWorkout = LocalDateTime.now();
    LocalDateTime finishWorkout = LocalDateTime.now();

    public Player() {
    }

    @Override
    public void dailyWorkout() {
    }

    public Player(Long id, String firstName, String lastName, String username, String password, String email, String sports, int age, boolean active) {
        super(id, firstName, lastName, username, password, email, sports, age, active);
        this.setRole(Role.PLAYER);
    }

    public List<String> getAssignedWorkouts() {
        return assignedWorkouts;
    }

    public void setAssignedWorkouts(List<String> assignedWorkouts) {
        this.assignedWorkouts = assignedWorkouts;
    }

    public List<String> getCompletedWorkoutsResults() {
        return completedWorkoutsResults;
    }

    public void setCompletedWorkoutsResults(List<String> completedWorkoutsResults) {
        this.completedWorkoutsResults = completedWorkoutsResults;
    }

    public List<String> getFavoriteWorkouts() {
        return favoriteWorkouts;
    }

    public void setFavoriteWorkouts(List<String> favoriteWorkouts) {
        this.favoriteWorkouts = favoriteWorkouts;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
                .add("id=" + getId())
                .add("firstName='" + getFirstName() + "'")
                .add("lastName='" + getLastName() + "'")
                .add("username='" + getUsername() + "'")
                .add("password='" + getPassword() + "'")
                .add("email='" + getEmail() + "'")
                .add("sports='" + getSports() + "'")
                .add("role=" + getRole())
                .add("age=" + getAge())
                .add("active=" + isActive())
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (getAssignedWorkouts() != null ? !getAssignedWorkouts().equals(player.getAssignedWorkouts()) : player.getAssignedWorkouts() != null)
            return false;
        if (getCompletedWorkoutsResults() != null ? !getCompletedWorkoutsResults().equals(player.getCompletedWorkoutsResults()) : player.getCompletedWorkoutsResults() != null)
            return false;
        if (getFavoriteWorkouts() != null ? !getFavoriteWorkouts().equals(player.getFavoriteWorkouts()) : player.getFavoriteWorkouts() != null)
            return false;
        if (!Objects.equals(startWorkout, player.startWorkout))
            return false;
        return Objects.equals(finishWorkout, player.finishWorkout);
    }


}
