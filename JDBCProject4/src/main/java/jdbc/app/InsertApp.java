package jdbc.app;

import jdbc.models.Post;
import jdbc.models.Topic;
import jdbc.models.User;
import jdbc.repositories.PostRepository;
import jdbc.repositories.TopicRepository;
import jdbc.repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class InsertApp {

    public static void main(String[] args) {

//        UserRepository userRepository=new UserRepository();
//
//
//
//        try {
//            User user=new User();
//            user.setUsername("eric");
//            user.setEmail("eric@mail.be");
//            user.setPassword("5644");
//            long noOfNewUser=userRepository.create(user);
//            System.out.println("Number of new users: "+noOfNewUser);
//        }
//        catch (SQLException sqlException) {
//            System.out.println("SQL Exception: "+sqlException.getMessage());;
//        }

        System.out.println("*****************************");

        PostRepository postRepository = new PostRepository();


//        try {
//
//            Post post=new Post();
//            post.setUserId(3);
//            post.setTitle("title3");
//            post.setSlug("slug3");
//            post.setImage("image3");
//            post.setBody("body3");
//            post.setPublished(2);long noOfNewPost=postRepository.create(post);
//            System.out.println("Number of new post: "+noOfNewPost);
//
//        } catch (SQLException sqlException) {
//            System.out.println("SQL Exception: "+sqlException.getMessage());;
//        }

        System.out.println("*****************************");

        TopicRepository topicRepository = new TopicRepository();
        Topic topic = new Topic();
        try {
            topic.setName("name3");
            topic.setSlug("slug3");
            long noOfNewTopics = topicRepository.create(topic);
            System.out.println("No Of New Topics: " + noOfNewTopics);

        } catch (SQLException sqlException) {
            System.out.println("SQL Exception: " + sqlException.getMessage());
            ;
        }


    }
}
