package jdbc.repositories;

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
        String query = "INSERT INTO PostTopics (postId, topicId) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement insertStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // Set the values for the parameters
            ((PreparedStatement) insertStatement).setLong(1, newPostTopic.getPostId());
            insertStatement.setLong(2, newPostTopic.getTopicId());

            // Execute the insert statement
            int rowsAffected = insertStatement.executeUpdate();

            // If the insert was successful, retrieve the generated ID
            if (rowsAffected > 0) {
                ResultSet generatedKeys = insertStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1); // Return the generated ID
                }
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, for example log it
            e.printStackTrace();
        }

        // If the insert fails or no generated key is available, return -1
        return -1;
    }


    public PostTopic read(long id) throws SQLException {

        Statement selectStatement = getConnection().createStatement();


        // return null if fails
        return null;
    }

    //public List<PostTopic> read(PostTopic example) throws SQLException {
        //Statement selectStatement = getConnection().createStatement();
        // add read statements here..
        // return empty collection if fails
       // return Collections.emptyList();
   // }
    ///////////////////////////////
    public List<PostTopic> read(PostTopic example) throws SQLException {
        List<PostTopic> postTopics = new ArrayList<>();
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM PostTopics WHERE 1=1");

        // Check if the example object is not null and set conditions accordingly
        if (example != null) {
            if (example.getPostId() != 0) {
                queryBuilder.append(" AND postId = ?");
            }
            if (example.getTopicId() != 0) {
                queryBuilder.append(" AND topicId = ?");
            }
            // Add other conditions as needed
        }

        try (Connection connection = getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(queryBuilder.toString())) {

            // Set parameters based on the conditions set in the query
            int parameterIndex = 1;
            if (example != null) {
                if (example.getPostId() != 0) {
                    selectStatement.setLong(parameterIndex++, example.getPostId());
                }
                if (example.getTopicId() != 0) {
                    selectStatement.setLong(parameterIndex++, example.getTopicId());
                }
                // Set other parameters as needed
            }

            try (ResultSet resultSet = selectStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Create a new PostTopic object for each record in the result set
                    PostTopic postTopic = new PostTopic();
                    postTopic.setPostId(resultSet.getLong("postId"));
                    postTopic.setTopicId(resultSet.getLong("topicId"));

                    postTopics.add(postTopic);
                }
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, for example log it
            e.printStackTrace();
            // Return an empty list if fails
            return Collections.emptyList();
        }

        return postTopics;
    }
/////////////////

    public List<PostTopic> read() throws SQLException {

        Statement selectStatement = getConnection().createStatement();

        // return empty collection if fails
        return Collections.emptyList();
    }

    public boolean update(long id, PostTopic existingPostTopic) throws SQLException {

        Statement updateStatement = getConnection().createStatement();

        // return false if fails
        return false;
    }

    public boolean delete(long id) throws SQLException {

        Statement deleteStatement = getConnection().createStatement();

        // return false if fails
        return false;
    }

}
