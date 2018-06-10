package isep.project.web.entity;

public class MessageFormEntity {

    private int categoryId;

    private String privacy;

    private String anonymism;

    private String title;

    private String content;

    public MessageFormEntity() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPrivacy() { return privacy; }

    public void setPrivacy(String privacy) { this.privacy = privacy; }

    public String getAnonymism() { return anonymism; }

    public void setAnonymism(String anonymism) { this.anonymism = anonymism; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
