package isep.project.web.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by owner on 18-05-07.
 */
@Entity
@Table(name = "messages", schema = "heroku_9efd0238a94d992")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id", nullable = false)
    private int id;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @Basic
    @Column(name = "is_anonymous", nullable = true)
    private Boolean isAnonymous;

    @Basic
    @Column(name = "type", nullable = true, length = 45)
    private String type;

    @Basic
    @Column(name = "title", nullable = true, length = 45)
    private String title;

    @Basic
    @Column(name = "has_been_read", nullable = true)
    private Boolean hasBeenRead;

    @Basic
    @Column(name = "content", nullable = true, length = -1)
    private String content;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    @OneToMany(mappedBy ="likedMessage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LikeEntity> likes;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "conversation")
    private ConversationEntity conversationIn;

    public MessageEntity() {
        this.setAnonymous(false);
        this.setHasBeenRead(false);
        this.setLikes(new LinkedList<LikeEntity>());
        this.setCreatedAt(new Date(Calendar.getInstance().getTime().getTime()));
    }

    public MessageEntity(Boolean isAnonymous, String type, String content, String title) {
        this.isAnonymous = isAnonymous;
        this.type = type;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHasBeenRead() {
        return hasBeenRead;
    }

    public void setHasBeenRead(Boolean hasBeenRead) {
        this.hasBeenRead = hasBeenRead;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public List<LikeEntity> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeEntity> likes) {
        this.likes = likes;
    }

    public ConversationEntity getConversationIn() {
        return conversationIn;
    }

    public void setConversationIn(ConversationEntity conversationIn) {
        this.conversationIn = conversationIn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addLike(LikeEntity like) {
        if (likes == null) {
            likes = new LinkedList<>();
        }

        likes.add(like);
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", isAnonymous=" + isAnonymous +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", hasBeenRead=" + hasBeenRead +
                ", content='" + content + '\'' +
                ", createdBy=" + createdBy +
                ", likes=" + likes +
                ", conversationIn=" + conversationIn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return id == that.id &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(isAnonymous, that.isAnonymous) &&
                Objects.equals(type, that.type) &&
                Objects.equals(title, that.title) &&
                Objects.equals(hasBeenRead, that.hasBeenRead) &&
                Objects.equals(content, that.content) &&
                Objects.equals(createdBy, that.createdBy) &&
                Objects.equals(likes, that.likes) &&
                Objects.equals(conversationIn, that.conversationIn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, isAnonymous, type, title, hasBeenRead, content, createdBy, likes, conversationIn);
    }
}
