package jdbc.app;

import jdbc.models.User;
import jdbc.repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        try {

            List<User> users = userRepository.read();
            for(User u : users){
                System.out.println(u);
            }

            User user = new User();
            user.setUsername("albert");
            user.setEmail("einstein@mail.be");
            user.setPassword("1257");

            long noOfRowsCreated = userRepository.create(user);
            System.out.println("No of records created: " + noOfRowsCreated);



        } catch (SQLException sqlException) {
            System.err.println("SQL EX: " + sqlException.getMessage());
        }
    }
}
