package jdbc.repositories;

import jdbc.models.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostRepository {

private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "P@ssw0rd"
        );
        System.out.println("CONNECTION TO DB IS MADE");

        return connection;
    }

    public long create(Post newPost) throws SQLException {
//        Statement createStatement = getConnection().createStatement();
//        String query = "INSERT INTO post " +
//                "(user_id, title) " +
//                "VALUES " +
//                "('" + newPost.getUserId() + "', " +
//                "'" + newPost.getTitle() + "')";
////        statement.executeUpdate() -> creates a record, or updates a record.
//        return createStatement.executeUpdate(query);
//        //Statement createStatement = getConnection().createStatement();
        String query = "insert into post (user_id, title,slug,image,body,published) values (?, ?,?,?,?,?)";
        PreparedStatement insertStatement = getConnection().prepareStatement(query);

        insertStatement.setLong(1,newPost.getUserId());
        insertStatement.setString(2,newPost.getTitle());
        insertStatement.setString(3,newPost.getSlug());
        insertStatement.setString(4,newPost.getImage());
        insertStatement.setString(5,newPost.getBody());
        insertStatement.setLong(6,newPost.getPublished());

        return insertStatement.executeUpdate();
    }

    public Post read(long id) throws SQLException {
        String query = "SELECT * FROM post WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(query)) {

            // Set the id parameter
            selectStatement.setLong(1, id);

            try (ResultSet resultSet = selectStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Create a new Post object
                    Post post = new Post();

                    // Populate the Post object with data from the result set
                    post.setId(resultSet.getLong("id"));
                    post.setUserId(resultSet.getLong("user_id")); // Assuming the column name is "user_id"
                    post.setTitle(resultSet.getString("title"));
                    post.setSlug(resultSet.getString("slug"));
                    post.setImage(resultSet.getString("image"));
                    post.setBody(resultSet.getString("body"));
                    post.setPublished(resultSet.getLong("published"));

                    // Return the populated Post object
                    return post;
                }
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, for example log it
            e.printStackTrace();
        }

        // Return null if no matching record is found or an exception occurs
        return null;
    }

    public List<Post> read(Post example) throws SQLException {
        List<Post> posts = new ArrayList<>();
        String query = "SELECT * FROM post WHERE 1=1";

        // Check if the example object is not null and set conditions accordingly
        if (example != null) {
            if (false) {
                query += " AND user_id = ?";
            }
            if (example.getTitle() != null) {
                query += " AND title = ?";
            }
            // Add other conditions as needed
        }

        try (Connection connection = getConnection();
             PreparedStatement selectStatement = connection.prepareStatement(query)) {

            // Set parameters based on the conditions set in the query
            int parameterIndex = 1;
            if (example != null) {
                if (false) {
                    selectStatement.setLong(parameterIndex++, example.getUserId());
                }
                if (example.getTitle() != null) {
                    selectStatement.setString(parameterIndex++, example.getTitle());
                }
                // Set other parameters as needed
            }

            try (ResultSet resultSet = selectStatement.executeQuery()) {
                while (resultSet.next()) {
                    // Create a new Post object for each record in the result set
                    Post post = new Post();
                    post.setId(resultSet.getLong("id"));
                    post.setUserId(resultSet.getLong("user_id")); // Assuming the column name is "user_id"
                    post.setTitle(resultSet.getString("title"));
                    post.setSlug(resultSet.getString("slug"));
                    post.setImage(resultSet.getString("image"));
                    post.setBody(resultSet.getString("body"));
                    post.setPublished(resultSet.getLong("published"));

                    posts.add(post);
                }
            }
        } catch (SQLException e) {
            // Handle the exception appropriately, for example log it
            e.printStackTrace();
            // Return an empty list if fails
            return Collections.emptyList();
        }

        return posts;
    }

    public List<Post> read() throws SQLException {
        List<Post> postList=new ArrayList<>();
        Statement selectStatement = getConnection().createStatement();

        String query="SELECT id,user_id,title FROM POST";
        ResultSet result=selectStatement.executeQuery(query);

        while(result.next()){
            Post post=new Post();
            post.setId(result.getLong("id"));
            post.setUserId(result.getLong("user_id"));
            post.setTitle(result.getString("title"));
            postList.add(post);
        }
        return postList;

    }

    public boolean update(long id, Post existingPost) throws SQLException {
        String query = "UPDATE post SET user_id=?, title=?, slug=?, image=?, body=?, published=? WHERE id=?";

        try (Connection connection = getConnection();
             PreparedStatement updateStatement = connection.prepareStatement(query)) {

            // Set parameters for the update statement
            updateStatement.setLong(1, existingPost.getUserId());
            updateStatement.setString(2, existingPost.getTitle());
            updateStatement.setString(3, existingPost.getSlug());
            updateStatement.setString(4, existingPost.getImage());
            updateStatement.setString(5, existingPost.getBody());
            updateStatement.setLong(6, existingPost.getPublished());
            updateStatement.setLong(7, id); // Assuming 'id' is the primary key

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
        String query = "DELETE FROM post WHERE id=?";

        try (Connection connection = getConnection();
             PreparedStatement deleteStatement = connection.prepareStatement(query)) {

            // Set the id parameter
            deleteStatement.setLong(1, id);

            // Execute the delete statement
            int rowsAffected = deleteStatement.executeUpdate();

            // If delete was successful, return true
            return rowsAffected > 0;

        } catch (SQLException e) {
            // Handle the exception appropriately, for example log it
            e.printStackTrace();
            // Return false if the delete fails
            return false;
        }
    }

}
