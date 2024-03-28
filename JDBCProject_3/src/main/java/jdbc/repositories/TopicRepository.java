package jdbc.repositories;

import jdbc.models.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopicRepository {

    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blogdb",
                "blogger",
                "P@ssw0rd"
        );
        System.out.println("CONNECTION TO DB IS MADE");

        return connection;
    }

    public long create(Topic newTopic) throws SQLException {

        String query = "insert into topic (name,slug) values(?,?)";
        PreparedStatement insertStatement = getConnection().prepareStatement(query);
        insertStatement.setString(1, newTopic.getName());
        insertStatement.setString(2, newTopic.getSlug());
        return insertStatement.executeUpdate();
    }

    public Topic read(long id) throws SQLException {

        Statement selectStatement = getConnection().createStatement();


        // return null if fails
        return null;
    }

    public List<Topic> read(Topic example) throws SQLException {

        Statement selectStatement = getConnection().createStatement();

        // add read statements here..

        // return empty collection if fails
        return Collections.emptyList();
    }
    public List<Topic> read() throws SQLException {

        Statement selectStatement = getConnection().createStatement();
        List<Topic> topicList = new ArrayList<>();
        String query = "select name,slug from topic";
        ResultSet result = selectStatement.executeQuery(query);
        while (result.next()) {
            Topic topic = new Topic();
            topic.setName(result.getString("name"));
            topic.setSlug(result.getString("slug"));
            topicList.add(topic);
        }
        return topicList;
    }
    public int update(int id, Topic existingTopic) throws SQLException {

        String query = "Update topic Set name=?,slug=? where id =?";
        PreparedStatement updateStatement = getConnection().prepareStatement(query);
        updateStatement.setString(1, existingTopic.getName());
        updateStatement.setString(2, existingTopic.getSlug());
        updateStatement.setLong(3, id);
        return updateStatement.executeUpdate();

    }

    public int delete(int id) throws SQLException {

        String query = "Delete from topic where id=?";
        PreparedStatement deleteStatement = getConnection().prepareStatement(query);
        deleteStatement.setInt(1, id);
        return deleteStatement.executeUpdate();
    }

}
