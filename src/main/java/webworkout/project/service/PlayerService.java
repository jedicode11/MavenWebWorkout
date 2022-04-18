package webworkout.project.service;

import webworkout.project.exception.InvalidEntityDataException;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Player;

import java.util.Collection;

public interface PlayerService {

    Collection<Player> getAllPlayers();

    Player getPlayerById(Player id) throws NoneexistingEntityException;
    Player addPlayer(Player player) throws InvalidEntityDataException;
    Player updatePlayer(Player player) throws NoneexistingEntityException, InvalidEntityDataException;
    Player deletePlayerById(Long id) throws NoneexistingEntityException;

    long count();
}
