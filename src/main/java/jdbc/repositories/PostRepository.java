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

        Statement selectStatement = getConnection().createStatement();


        // return null if fails
        return null;
    }

    public List<Post> read(Post example) throws SQLException {

        Statement selectStatement = getConnection().createStatement();

        // add read statements here..

        // return empty collection if fails
        return Collections.emptyList();
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
