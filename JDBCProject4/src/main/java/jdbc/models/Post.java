package jdbc.models;


public class Post {

  private long postId;
  private long userId;
  private String title;
  private String slug;
  private long views;
  private String image;
  private String body;
  private long published;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;


  public long getPostId() {
    return postId;
  }

  public void setPostId(long postId) {
    this.postId = postId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }


  public long getViews() {
    return views;
  }

  public void setViews(long views) {
    this.views = views;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }


  public long getPublished() {
    return published;
  }

  public void setPublished(long published) {
    this.published = published;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public String toString() {
    return "Post{" +
            "id=" + postId +
            ", userId=" + userId +
            ", title=" + title ;
  }
}
