package jdbc.repositories;

import jdbc.exceptions.PostLikeException;
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
        Statement createStatement = getConnection().createStatement();
        String query = "insert into postlike (postId, userId) values("
                +newPostLike.getPostId() + ", " + newPostLike.getUserId() +")";

        int rowsAffected = createStatement.executeUpdate(query);
        if (rowsAffected > 0) {
            return rowsAffected;
        }else
            return -1;
    }


    public PostLike read(long id) throws SQLException {

        try {
            Statement selectStatement = getConnection().createStatement();
            String query = "select postId, userId from postike where postId = " + id;
            ResultSet resultSet = selectStatement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getRow() + " | " +
                        resultSet.getInt("postId") + " | " +
                        resultSet.getInt("userid"));
            }
            return (PostLike) resultSet;
        } catch (PostLikeException postLikeException) {
            postLikeException.notFound();
            return null;
        }
    }

    public List<PostLike> read(PostLike example) throws SQLException {
    try {
        Statement selectStatement = getConnection().createStatement();
        String query = "select postId, userId, from postlike where postId =" +example.getPostId();
        ResultSet resultSet = selectStatement.executeQuery(query);
        List<PostLike> postLikes = new ArrayList<>();
        while (resultSet.next()){
            int postId = resultSet.getInt("postId");
            int userId = resultSet.getInt("userId");
            PostLike postLike = new PostLike();

            postLike.setPostId(postId);
            postLike.setUserId(userId);
            //postLike.add(postLike);

            System.out.println(resultSet.getRow() + " | " +
                    resultSet.getInt("postId") + " | " +
                    resultSet.getInt("userId"));
        }
        return postLikes;
    }catch (PostLikeException postLikeException) {
        postLikeException.notFound();
        return Collections.emptyList();
    }

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
    Statement updateStatement = getConnection().createStatement();
    String query = "update postlike set postId =" + existingPostLike.getPostId() +
            ",userId = " + existingPostLike.getUserId() + "where postId = " + id;
    ResultSet resultSet = updateStatement.executeQuery(query);

    if (resultSet.next()) {
        int rowsAffected = resultSet.getInt(1);
        return rowsAffected > 0;
    }else {
        return false;
    }
    }

    public boolean delete(long id) throws SQLException {
    Statement deleteStatement = getConnection().createStatement();
    String query = "delete from postlike where postId = " + id;
    int rowsAffected = deleteStatement.executeUpdate(query);

    if (rowsAffected > 0) {
        return true;
    }else {
        return false;
    }

    }
}










