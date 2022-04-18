package webworkout.project.model;

import webworkout.project.dao.Identifiable;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Workout extends User implements Identifiable<Long>, Comparable<Workout> {
    private static final long COMPLETE_WORKOUT = 10;
    private static long nextId = 0;
    private Long id = ++nextId;
    private String title;
    private String creator;
    private LocalDateTime startDate;
    private String type;
    private double workoutRatings;
    private String tags;

    public Workout() {
    }

    public Workout(Long id) {
        this.id = id;
    }

    public Workout(String title, String creator, String publisher, double workoutRatings, String tags) {
        this.title = title;
        this.creator = creator;
        this.type = publisher;
        this.workoutRatings = workoutRatings;
        this.tags = tags;
        this.startDate = LocalDateTime.now();
    }

    public Workout(Long id, String description) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime now) {
        this.startDate = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWorkoutRatings() {
        return workoutRatings;
    }

    public void setWorkoutRatings(double workoutRatings) {
        this.workoutRatings = workoutRatings;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Workout.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("creator='" + creator + "'")
                .add("startDate=" + startDate)
                .add("type='" + type + "'")
                .add("workoutRatings=" + workoutRatings)
                .add("tags='" + tags + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workout)) return false;

        Workout workout = (Workout) o;

        return getId() != null ? getId().equals(workout.getId()) : workout.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public int compareTo(Workout next) {
        return getId().compareTo(next.getId());
    }
}
