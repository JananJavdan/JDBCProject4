package jdbc.repositories;

import jdbc.exceptions.PostTopicException;
import jdbc.models.PostTopic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostTopicRepository {

private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "P@ssw0rd"
        );
        System.out.println("CONNECTION TO DB IS MADE");

        return connection;
    }

    public long create(PostTopic newPostTopic) throws SQLException {
    Statement createStatement = getConnection().createStatement();
        String query = "INSERT INTO PostTopics (postId, topicId) VALUES (" + newPostTopic.getPostId()+
                ", " + newPostTopic.getTopicId() +")";

            // Execute the insert statement
            int rowsAffected = createStatement.executeUpdate(query);

            if (rowsAffected > 0) {
                return rowsAffected;
                }else {
                return -1;
            }
    }

    public PostTopic read(long id) throws SQLException {
    try {
        Statement selectStatement = getConnection().createStatement();
        String query = "select postId, topicId from postTopic where postId = " +id;
        ResultSet resultSet = selectStatement.executeQuery(query);
        while (resultSet.next()) {
            System.out.println(resultSet.getRow() + " | " + resultSet.getInt("postId") + " | "+
                    resultSet.getInt("topicId"));
        }
        return (PostTopic) resultSet;
    }catch (PostTopicException postTopicException) {
        postTopicException.notFound();
        return null;
    }

    }

    public List<PostTopic> read(PostTopic example) throws SQLException {
    try {
        Statement selectStatement = getConnection().createStatement();
        String query = "select postId, topicId from postTopic where postId = "+example.getPostId();
        ResultSet resultSet = selectStatement.executeQuery(query);
        List<PostTopic> postTopics = new ArrayList<>();
        while (resultSet.next()) {
            int postId = resultSet.getInt("postId");
            int topicId = resultSet.getInt("topicId");
            PostTopic postTopic = new PostTopic();

            System.out.println(resultSet.getRow() + " | " + resultSet.getInt("postId") + " | " +
                    resultSet.getInt("topicId"));
        }
        return postTopics;
    }catch (PostTopicException postTopicException) {
        postTopicException.notFound();
        return Collections.emptyList();
    }

}
    public List<PostTopic> read() throws SQLException {
    try {
        Statement selectStatement = getConnection().createStatement();
        String query = "select * from postlike";
        ResultSet resultSet = selectStatement.executeQuery(query);
        List<PostTopic> postTopics = new ArrayList<>();
        while (resultSet.next()) {
            int postId = resultSet.getInt("postId");
            int topicId = resultSet.getInt("userId");
            PostTopic postTopic = new PostTopic();
            postTopic.setPostId(postId);
            postTopic.setTopicId(topicId);
            postTopics.add(postTopic);
            System.out.println(resultSet.getRow() + " | " + postId + " | " + topicId);
        }
        return postTopics;
    }catch (PostTopicException postTopicException) {
        postTopicException.notFound();
        return Collections.emptyList();
    }
}
    public boolean update(long id, PostTopic existingPostTopic) throws SQLException {
            Statement updateStatement = getConnection().createStatement();
            String query = "update postlike set postId = " + existingPostTopic.getPostId() + ", topicId = " +
                    existingPostTopic.getTopicId() + " where postId = " + id;

            ResultSet resultSet = updateStatement.executeQuery(query);

            if (resultSet.next()) {
                int rowsAffected = resultSet.getInt(1);
                return rowsAffected > 0;
            } else {
                return false;
            }
        }
        public boolean delete(long id) throws SQLException {
            Statement deleteStatement = getConnection().createStatement();
            String query = "delete from postTopic where postId = " + id;
            int rowsAffected = deleteStatement.executeUpdate(query);

            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        }
    }