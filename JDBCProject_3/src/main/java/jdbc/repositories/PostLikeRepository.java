package jdbc.repositories;

import jdbc.models.PostLike;

import java.sql.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class PostLikeRepository {

private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "P@ssw0rd"
        );
        System.out.println("CONNECTION TO DB IS MADE");

        return connection;
    }

    public long create(PostLike newPostLike) throws SQLException {
        String query = "INSERT INTO PostLikes (postId, userId, timestamp) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement createStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            // Set the values for the parameters
            createStatement.setLong(1, newPostLike.getPostId());
            createStatement.setLong(2, newPostLike.getUserId());

            // Execute the insert statement
            int rowsAffected = createStatement.executeUpdate();

            // If the insert was successful, retrieve the generated ID
            if (rowsAffected > 0) {
                ResultSet generatedKeys = createStatement.getGeneratedKeys();
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


    public PostLike read(long id) throws SQLException {
    String query = "SELECT * FROM PostLikes WHERE id = ?";

    try (Connection connection = getConnection();
         PreparedStatement selectStatement = connection.prepareStatement(query)) {

        // Set the id parameter
        selectStatement.setLong(1, id);

        try (ResultSet resultSet = selectStatement.executeQuery()) {
            if (resultSet.next()) {
                // Create a new PostLike object
                PostLike postLike = new PostLike();

                // Populate the PostLike object with data from the result set
                postLike.setPostId(resultSet.getLong("id"));
                postLike.setPostId(resultSet.getLong("postId")); // Assuming the column name is "postId"
                postLike.setUserId(resultSet.getLong("userId")); // Assuming the column name is "userId"
                // Set other properties as needed

                // Return the populated PostLike object
                return postLike;
            }
        }
    } catch (SQLException e) {
        // Handle the exception appropriately, for example log it
        e.printStackTrace();
    }

    // Return null if no matching record is found or an exception occurs
    return null;
}

    public List<PostLike> read(PostLike example) throws SQLException {
        List<PostLike> postLikes = new ArrayList<>();
        Statement selectStatement = getConnection().createStatement();

        String query = "SELECT * FROM PostLikes WHERE postId = " + example.getPostId();
        ResultSet result=selectStatement.executeQuery(query);

        while (result.next()){
            PostLike postLike = new PostLike();
            postLike.setPostId(result.getLong("id"));
            postLike.setUserId(result.getLong("user_id"));
            postLikes.add(postLike);
        }
        return postLikes;
        // add read statements here..

        // return empty collection if fails
    }

public List<PostLike> read() throws SQLException {
    List<PostLike> postLikes = new ArrayList<>();
    String query = "SELECT * FROM PostLikes";

    try (Connection connection = getConnection();
         Statement selectStatement = connection.createStatement();
         ResultSet resultSet = selectStatement.executeQuery(query)) {

        while (resultSet.next()) {
            PostLike postLike = new PostLike();
            postLike.setPostId(resultSet.getLong("id")); // Assuming the column name is "id"
            postLike.setUserId(resultSet.getLong("user_id")); // Assuming the column name is "user_id"

            postLikes.add(postLike);
        }
    } catch (SQLException e) {
        // Handle the exception appropriately, for example log it
        e.printStackTrace();
        // Return an empty list if fails
        return Collections.emptyList();
    }

    return postLikes;
}

    public boolean update(long id, PostLike existingPostLike) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(
                     "UPDATE PostLikes SET postId = ?, userId = ?, timestamp = ? WHERE id = ?")) {

            // Assuming PostLike has fields like postId, userId, and timestamp
            updateStatement.setLong(10, existingPostLike.getPostId());
            updateStatement.setLong(2000, existingPostLike.getPostId());
            updateStatement.setLong(4000, id);

            // Execute the update statement
            int rowsAffected = updateStatement.executeUpdate();

            // If update was successful, return true
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Handle the exception appropriately, for example log it
            e.printStackTrace();
            // Return false if the update fails
            return false;
        }
    }

    public boolean delete(long id) throws SQLException {
        String query = "DELETE FROM topic WHERE id=?";
        try (PreparedStatement deleteStatement = getConnection().prepareStatement(query)) {
            // Set the value for the parameter
            deleteStatement.setLong(1, id);

            // Execute the delete statement and return true if successful
            return deleteStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            // Handle the exception appropriately, for example log it
            e.printStackTrace();
            // Return false if the delete fails
            return false;
        }

    }

}










