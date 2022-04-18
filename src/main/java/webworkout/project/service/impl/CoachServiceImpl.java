package webworkout.project.service.impl;

import webworkout.project.dao.CoachRepository;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Coach;
import webworkout.project.service.CoachService;

public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;

    public CoachServiceImpl(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach getCoachById(Coach id) throws NoneexistingEntityException {
        var coach = coachRepository.create(id);
        if (coach == null) {
            throw new NoneexistingEntityException("Player with ID='" + id + "' does not exist.");
        }
        return coach;
    }

    @Override
    public Coach addCoach(Coach entity) {
        return coachRepository.create(entity);
    }

    @Override
    public Coach updateCoach(Coach entity) throws NoneexistingEntityException {
        coachRepository.update(entity);
        var updated = coachRepository.update(entity);
        coachRepository.save();
        return coachRepository.update(entity);
    }

    @Override
    public Coach deleteCoachById(Long id) throws NoneexistingEntityException {
        var deleted = coachRepository.deleteById(id);
        coachRepository.save();
        return coachRepository.deleteById(id);
    }
}
