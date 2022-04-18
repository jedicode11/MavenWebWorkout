package webworkout.project.service;

import webworkout.project.exception.InvalidEntityDataException;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Coach;

public interface CoachService {

    Coach getCoachById(Coach id) throws NoneexistingEntityException;
    Coach addCoach(Coach entity) throws InvalidEntityDataException, NoneexistingEntityException;
    Coach updateCoach(Coach workout) throws NoneexistingEntityException, InvalidEntityDataException;
    Coach deleteCoachById(Long id) throws NoneexistingEntityException;
}
