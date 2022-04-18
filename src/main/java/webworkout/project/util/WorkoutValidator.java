package webworkout.project.util;

import webworkout.project.exception.ConstraintViolationException;
import webworkout.project.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class WorkoutValidator {
    public void validate(Workout workout) throws ConstraintViolationException {
        List<ConstraintViolationException> violations = new ArrayList<>();

        var titleLength = workout.getTitle().trim().length();
        if(titleLength < 4 || titleLength > 50){
            violations.add(
                    new ConstraintViolationException(
                    ));
           }
        if(workout.getTags().length() < 4 || workout.getTags().length() < 5){
            violations.add(
                    new ConstraintViolationException(
                    ));
        }
        if(violations.size() > 0) {
            throw new ConstraintViolationException("Invalid workout field", violations);
        }
    }
}