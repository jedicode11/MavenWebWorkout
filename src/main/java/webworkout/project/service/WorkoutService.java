package webworkout.project.service;

import webworkout.project.exception.InvalidEntityDataException;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Workout;

import java.util.Collection;

public interface WorkoutService {

    Collection<Workout> getAllWorkouts();

    Workout getWorkoutById(Workout id) throws NoneexistingEntityException;
    Workout addWorkout(Workout workout) throws InvalidEntityDataException;
    Workout updateWorkout(Workout workout) throws NoneexistingEntityException, InvalidEntityDataException;
    Workout deleteWorkoutById(Long id) throws NoneexistingEntityException;

    void loadData();

    long count();
}
