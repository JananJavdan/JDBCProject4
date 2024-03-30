package jdbc.app;

import jdbc.repositories.TopicRepository;
import jdbc.repositories.UserRepository;

import java.sql.SQLException;

public class DeleteApp {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();


        try {
            int noOfRecordsDeleted = userRepository.delete(3);
            System.out.println("Number of records deleted: " + noOfRecordsDeleted);
        } catch (SQLException sqlException) {
            System.out.println("sql exception" + sqlException.getMessage());
            ;
        }
        System.out.println("***************************");

        TopicRepository topicRepository = new TopicRepository();
        try {
            int noOfDeletedTopics = topicRepository.delete(3);

            System.out.println("No Of Deleted Topics: " + noOfDeletedTopics);

        } catch (SQLException sqlException) {
            System.out.println("sql exception" + sqlException.getMessage());
            ;
        }


    }
}
