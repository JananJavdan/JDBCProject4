package jdbc.exceptions;

import jdbc.models.Topic;
import java.util.Arrays;

public class TopicException extends RuntimeException {

    public TopicException(String message) {
        super(message);
    }

    public TopicException notFound() {
        return new TopicException("Topic not found");
    }

    public TopicException alreadyExists() {
        return new TopicException("Topic already exists");
    }

    public TopicException requiredFields(String... fields) {
        return new TopicException("Required fields: " + Arrays.toString(fields));
    }

    public TopicException nullTopicException() {
        return new TopicException("Topic cannot be null");
    }

}
