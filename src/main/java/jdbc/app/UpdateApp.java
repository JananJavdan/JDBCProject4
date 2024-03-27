package jdbc.app;

import jdbc.models.Topic;
import jdbc.models.User;
import jdbc.repositories.TopicRepository;
import jdbc.repositories.UserRepository;

import java.sql.SQLException;

public class UpdateApp {
    public static void main(String[] args) {

        UserRepository userRepository = new UserRepository();


        User user = new User();
        user.setUsername("Nikola");
        user.setEmail("nikola@tesla.be");
        user.setPassword("2580");

        try {
            int noOfRecordsUpdated = userRepository.update(1, user);
            System.out.println("Number of records updated: " + noOfRecordsUpdated);

            int noOfPasswordsUpdated = userRepository.update(1, "chef");
            System.out.println("Number of passwords updated: " + noOfPasswordsUpdated);

        } catch (SQLException sqlException) {
            System.out.println("sql exception" + sqlException.getMessage());
            ;
        }

        TopicRepository topicRepository = new TopicRepository();
        Topic topic = new Topic();
        topic.setName("newname");
        topic.setSlug("newslug");
        try {
            int noOfUpdatedTopics = topicRepository.update(1, topic);
            System.out.println("No of Updated Topics: " + noOfUpdatedTopics);

        } catch (SQLException sqlException) {
            System.out.println("sql exception" + sqlException.getMessage());
            ;
        }

    }
}
