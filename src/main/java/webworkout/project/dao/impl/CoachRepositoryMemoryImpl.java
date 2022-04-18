package webworkout.project.dao.impl;

import webworkout.project.dao.CoachRepository;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Coach;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CoachRepositoryMemoryImpl implements CoachRepository {
    private Map<Long, Coach> coachMap = new HashMap<>();

    @Override
    public Collection<Coach> findAll() {
        return coachMap.values();
    }


    @Override
    public Coach findById(Long id) {
        return coachMap.get(id);
    }

    @Override
    public Coach create(Coach entity) {
        entity.setId(entity.getId());
        coachMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Coach update(Coach entity) throws NoneexistingEntityException {
        var old = findById(entity.getId());
        if(old == null) {
            throw new NoneexistingEntityException("Coach with ID='"
                    + entity.getId() + "' dose not exist.");
        }
        coachMap.put(entity.getId(), entity);
        return null;
    }

    @Override
    public Coach deleteById(Long id) throws NoneexistingEntityException {
        var old = coachMap.remove(id);
        if(old == null) {
            throw new NoneexistingEntityException("Book with ID='" + id + "' does not exist.");
        }
        return old;
    }

    @Override
    public long count() {
        return coachMap.size();
    }

    @Override
    public void save() {

    }

    @Override
    public void load() {

    }
}
