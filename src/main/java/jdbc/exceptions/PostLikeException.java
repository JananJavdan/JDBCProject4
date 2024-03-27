package jdbc.exceptions;

import jdbc.models.PostLike;
import java.util.Arrays;

public class PostLikeException extends RuntimeException {

    public PostLikeException(String message) {
        super(message);
    }

    public PostLikeException notFound() {
        return new PostLikeException("PostLike not found");
    }

    public PostLikeException alreadyExists() {
        return new PostLikeException("PostLike already exists");
    }

    public PostLikeException requiredFields(String... fields) {
        return new PostLikeException("Required fields: " + Arrays.toString(fields));
    }

    public PostLikeException nullPostLikeException() {
        return new PostLikeException("PostLike cannot be null");
    }

}
