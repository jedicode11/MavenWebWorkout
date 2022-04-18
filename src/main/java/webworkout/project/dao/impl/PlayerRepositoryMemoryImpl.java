package webworkout.project.dao.impl;


import lombok.extern.slf4j.Slf4j;
import webworkout.project.dao.PlayerRepository;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.Player;

import java.sql.*;
import java.util.*;

@Slf4j
public class PlayerRepositoryMemoryImpl implements PlayerRepository {
    private Map<Long, Player> playerMap = new HashMap<>();
    private NavigableMap<Integer, List<Player>> findPlayersById = new TreeMap<>();

    public static final String SELECT_ALL_PLAYERS =
            "select * from `book`;";
    private static final String INSERT_NEW_USER = "INSERT INTO USERS (fistName, lastName, username, password, email, sport, age) " +
            "VALUES (?,?,?,?,?,?,?)";


//    private Connection connection;
//
//    PreparedStatement statement = connection.prepareStatement(INSERT_NEW_USER);
//    statement.setString(1, "bill");
//    statement.setString(2, "secretpass");
//    statement.setString(3, "Bill Gates");
//    statement.setString(4, "bill.gates@microsoft.com");
//
//    int rowsInserted = statement.executeUpdate();


    public PlayerRepositoryMemoryImpl() throws SQLException {
    }


    @Override
    public Collection<Player> findAll() {
        return null;
    }

    @Override
    public Player findById(Long id) {
        return playerMap.get(id);
    }

    @Override
    public List<Player> findPlayersById(boolean ascending) {
        var valuesMap =  findPlayersById;
        if(!ascending) {
            valuesMap = valuesMap.descendingMap();
        }
        System.out.println("Player.findAllSorted() called.");
        List<Player> results = new ArrayList<>();
        for(List<Player> findPlayersById: valuesMap.values()){
            results.addAll(findPlayersById);
        }
        return results;
    }


    @Override
    public Player create(Player entity) {
        entity.setId(entity.getId());
        playerMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Player update(Player entity) throws NoneexistingEntityException {
        var old = findById(entity.getId());
        if(old == null) {
            throw new NoneexistingEntityException("Player with ID='"
                    + entity.getId() + "' dose not exist.");
        }
        playerMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Player deleteById(Long id) throws NoneexistingEntityException {
        var old = playerMap.remove(id);
        if(old == null) {
            throw new NoneexistingEntityException("Player with ID='" + id + "' does not exist.");
        }
        return old;
    }

    @Override
    public long count() {
        return playerMap.size();
    }

    @Override
    public void save() {

    }

    @Override
    public void load() {

    }
}
