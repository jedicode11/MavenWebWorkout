package webworkout.project.model;

import webworkout.project.dao.Identifiable;

import java.util.StringJoiner;

public class Administrator extends User implements Identifiable<Long> {
    private String email;
    private String results;

    public Administrator(Long id, String firstName, String lastName, String username, String password, String email, String sports, int age, boolean active) {
        super(id, firstName, lastName, username, password, email, sports, age, active);
        this.setRole(Role.ADMINISTRATOR);
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @Override
    public void dailyWorkout() {
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Administrator.class.getSimpleName() + "[", "]")
                .add("email='" + email + "'")
                .add("results='" + results + "'")
                .toString();
    }
}
