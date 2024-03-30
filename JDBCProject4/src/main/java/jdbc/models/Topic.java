package jdbc.models;


public class Topic {

    private long topicId;
    private String name;
    private String slug;


    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + topicId +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }
}
