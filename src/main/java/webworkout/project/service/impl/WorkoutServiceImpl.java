package webworkout.project.service.impl;

import webworkout.project.dao.WorkoutRepository;
import webworkout.project.exception.ConstraintViolationException;
import webworkout.project.exception.InvalidEntityDataException;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Workout;
import webworkout.project.service.WorkoutService;
import webworkout.project.util.WorkoutValidator;

import java.util.Collection;

public class WorkoutServiceImpl implements WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final WorkoutValidator workoutValidator;

    public WorkoutServiceImpl(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
        this.workoutValidator = new WorkoutValidator();
    }

    public WorkoutServiceImpl(WorkoutRepository workoutRepository, WorkoutValidator workoutValidator) {
        this.workoutRepository = workoutRepository;
        this.workoutValidator = workoutValidator;
    }

    @Override
    public Collection<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    @Override
    public Workout getWorkoutById(Workout id) throws NoneexistingEntityException {
        var workout = workoutRepository.create(id);
        if(workout == null) {
            throw new NoneexistingEntityException("Workout with ID='" + id + "' does not exist.");
        }
        return workout;
    }

    @Override
    public Workout addWorkout(Workout workout) throws InvalidEntityDataException {
        try {
            workoutValidator.validate(workout);
        } catch (ConstraintViolationException ex) {
            throw new InvalidEntityDataException(
                    String.format("Error creating workout '%s'", workout.getTitle()),
                    ex
            );
        }
        var newWorkout = workoutRepository.create(workout);
        workoutRepository.save();
        return newWorkout;
    }

    @Override
    public Workout updateWorkout(Workout workout) throws NoneexistingEntityException, InvalidEntityDataException {
        try {
            workoutValidator.validate(workout);
        } catch (ConstraintViolationException e) {
            throw new InvalidEntityDataException(
                    String.format("Error updating workout '%s'", workout.getTitle()),
                    e
            );
        }
        var updated = workoutRepository.update(workout);
        workoutRepository.save();
        return updated;
    }

    @Override
    public Workout deleteWorkoutById(Long id) throws NoneexistingEntityException {
        var deleted = workoutRepository.deleteById(id);
        workoutRepository.save();
        return deleted;
    }


    @Override
    public void loadData() {
        workoutRepository.load();
    }

    @Override
    public long count() {
        return workoutRepository.count();
    }
}
