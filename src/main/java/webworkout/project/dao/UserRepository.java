package webworkout.project.dao;

import webworkout.project.model.User;

public interface UserRepository extends CrudRepository<Long, User> {
    User findByUsername(String username);
}
