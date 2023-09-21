package esipov.Model;

public class Post {
    private Integer postID;
    private String topic;
    private String massage;

    public Integer getPostID() {
        return postID;
    }
    public void setPostID(Integer postID) {
        this.postID = postID;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public String getMassage() {
        return massage;
    }
    public void setMassage(String massage) {
        this.massage = massage;
    }
}
