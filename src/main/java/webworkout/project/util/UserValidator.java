package webworkout.project.util;

import webworkout.project.exception.ConstraintViolationException;
import webworkout.project.model.User;


import java.util.ArrayList;
import java.util.List;

public class UserValidator {
    public void validate(User user) throws ConstraintViolationException {
        List<ConstraintViolationException> violations = new ArrayList<>();

        var userId = user.getId();
        if (userId < 4 || userId > 25) {
            violations.add(
                    new ConstraintViolationException());
        }
        if (user.getUsername().length() < 4 || user.getUsername().length() > 8) {
            violations.add(
                    new ConstraintViolationException());
        }
        if (user.getPassword().length() < 6 || user.getPassword().length() > 12) {
            violations.add(
                    new ConstraintViolationException());
        }
        if (user.getFirstName().length() < 2 || user.getFirstName().length() > 10) {
            violations.add(
                    new ConstraintViolationException());
        }


        if (violations.size() > 0) {
            throw new ConstraintViolationException("Invalid userId field", violations);
        }
    }
}
