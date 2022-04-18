package webworkout.project.dao;

public interface DaoFactory {
    WorkoutRepository createWorkoutRepository();

    WorkoutRepository createWorkoutRepository(String dbFileName);

    WorkoutRepository createWorkoutRepositoryFile(String dbFileName);

    UserRepository createUserRepository();
}
