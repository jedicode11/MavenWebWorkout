package webworkout.project.service.impl;

import webworkout.project.dao.PlayerRepository;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Player;
import webworkout.project.service.PlayerService;

import java.util.Collection;

public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @Override
    public Collection<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public Player getPlayerById(Player id) throws NoneexistingEntityException {
        var player = playerRepository.create(id);
        if (player == null) {
            throw new NoneexistingEntityException("Player with ID='" + id + "' does not exist.");
        }
        return player;
    }

    @Override
    public Player addPlayer(Player player) {
        return playerRepository.create(player);
    }

    @Override
    public Player updatePlayer(Player player) throws NoneexistingEntityException {
        playerRepository.update(player);
        var updated = playerRepository.update(player);
        playerRepository.save();
        return playerRepository.update(player);
    }

    @Override
    public Player deletePlayerById(Long id) throws NoneexistingEntityException {
        var deleted = playerRepository.deleteById(id);
        playerRepository.save();
        return playerRepository.deleteById(id);
    }

    @Override
    public long count() {
        return playerRepository.count();
    }
}
