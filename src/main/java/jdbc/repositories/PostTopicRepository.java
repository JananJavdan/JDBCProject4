package jdbc.repositories;

import jdbc.models.PostTopic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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

        // add create statements here..

        // if fails return -1
        return -1;
    }

    public PostTopic read(long id) throws SQLException {

        Statement selectStatement = getConnection().createStatement();


        // return null if fails
        return null;
    }

    public List<PostTopic> read(PostTopic example) throws SQLException {

        Statement selectStatement = getConnection().createStatement();

        // add read statements here..

        // return empty collection if fails
        return Collections.emptyList();
    }

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
