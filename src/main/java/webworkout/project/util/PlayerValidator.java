package webworkout.project.util;

import webworkout.project.exception.ConstraintViolationException;
import webworkout.project.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerValidator {
    public void validate(Player player) throws ConstraintViolationException {
        List<ConstraintViolationException> violations = new ArrayList<>();
        var titleLength = player.getId();
        if(titleLength < 4 || titleLength > 50){
            violations.add(
                    new ConstraintViolationException(
                    ));
           }
        if(player.getUsername().length() < 4 || player.getUsername().length() < 5){
            violations.add(
                    new ConstraintViolationException(
                    ));
        }
        if(violations.size() > 0) {
            throw new ConstraintViolationException("Invalid workout field", violations);
        }
    }
}
