package webworkout.project;

import webworkout.project.controller.PlayerController;
import webworkout.project.controller.WorkoutController;
import webworkout.project.dao.PlayerRepository;
import webworkout.project.dao.WorkoutRepository;
import webworkout.project.dao.impl.PlayerRepositoryMemoryImpl;
import webworkout.project.dao.impl.WorkoutRepositoryMemoryImpl;
import webworkout.project.exception.EntityPersistenceException;
import webworkout.project.exception.InvalidEntityDataException;
import webworkout.project.exception.NoneexistingEntityException;
import webworkout.project.model.MockWorkouts;
import webworkout.project.model.Player;
import webworkout.project.model.Workout;
import webworkout.project.service.PlayerService;
import webworkout.project.service.impl.PlayerServiceImpl;
import webworkout.project.service.WorkoutService;
import webworkout.project.service.impl.WorkoutServiceImpl;

import java.io.IOException;
import java.sql.*;

import static ch.qos.logback.core.db.DBHelper.closeConnection;

public class Main {
    public static void main(String[] args) throws NoneexistingEntityException, InvalidEntityDataException, SQLException, IOException, ClassNotFoundException {


        Connection connection = null;
        try {
            // Create DB Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webworkout", "rootPlayer", "123456789");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from people");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("firstname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Close DB connection
        closeConnection(connection);



        PlayerService playerServiceService = new PlayerServiceImpl(new PlayerRepositoryMemoryImpl());
        try {
            playerServiceService.addPlayer(new Player());
        } catch (InvalidEntityDataException | EntityPersistenceException e) {
            e.printStackTrace();
        }

        PlayerRepository playerRepository = new PlayerRepositoryMemoryImpl();
        PlayerService playerService = new PlayerServiceImpl(playerRepository);

        WorkoutService workoutService = null;
        WorkoutController controller = new WorkoutController(workoutService);
        controller.init();

        PlayerController conn = new PlayerController(playerService);
        conn.init();

        WorkoutRepository workoutRepository = new WorkoutRepositoryMemoryImpl();
        workoutService = new WorkoutServiceImpl(workoutRepository);
        for (Workout workout : MockWorkouts.MOCK_WORKOUTS) {
            workoutService.addWorkout(workout);
            workoutService.updateWorkout(workout);
        }


        Player p1 = new Player(1L, "Bill", "Morison", "Billkins", "Sam4321", "billG@gmail.com", "Snowboarding", 32, true);
        playerService.addPlayer(p1);
        p1.setAge(32);
        p1.setUsername("BJMson");
        System.out.println(p1);


        for (Workout workout : workoutRepository.findAll()) {
            System.out.println(workout);
        }
        System.out.println();

        Workout workoutsByDate = workoutRepository.findById(3L);
        System.out.println(workoutsByDate);

        System.out.println(workoutRepository.findById(4L));

        System.out.println();
        workoutsByDate.setTitle("Workout One");
        workoutsByDate.setWorkoutRatings(200);
        workoutRepository.update(workoutsByDate);
        System.out.println(workoutRepository.findById(3L));


        // create the object
        Workout myWorkout = new Workout();
        myWorkout.dailyWorkout();

        //use the object
        System.out.println("Track run: 2x100m / Push-Ups after");

    }
}
