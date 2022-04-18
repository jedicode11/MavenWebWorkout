package webworkout.project.dao.impl;

import webworkout.project.dao.DaoFactory;
import webworkout.project.dao.UserRepository;
import webworkout.project.dao.WorkoutRepository;

public class DaoFactoryMemoryImpl implements DaoFactory {
    @Override
    public WorkoutRepository createWorkoutRepository() {
        return null;
    }

    @Override
    public WorkoutRepository createWorkoutRepository(String dbFileName) {
        return null;
    }

    @Override
    public WorkoutRepository createWorkoutRepositoryFile(String dbFileName) {
        return null;
    }

    @Override
    public UserRepository createUserRepository() {
        return null;
    }
}
