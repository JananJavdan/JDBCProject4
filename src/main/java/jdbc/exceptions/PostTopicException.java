package jdbc.exceptions;

import jdbc.models.PostTopic;
import java.util.Arrays;

public class PostTopicException extends RuntimeException {

    public PostTopicException(String message) {
        super(message);
    }

    public PostTopicException notFound() {
        return new PostTopicException("PostTopic not found");
    }

    public PostTopicException alreadyExists() {
        return new PostTopicException("PostTopic already exists");
    }

    public PostTopicException requiredFields(String... fields) {
        return new PostTopicException("Required fields: " + Arrays.toString(fields));
    }

    public PostTopicException nullPostTopicException() {
        return new PostTopicException("PostTopic cannot be null");
    }

}
