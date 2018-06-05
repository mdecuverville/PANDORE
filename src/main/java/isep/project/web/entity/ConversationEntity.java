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
@Table(name = "conversations", schema = "heroku_9efd0238a94d992")
public class ConversationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coversation_id", nullable = false)
    private int id;

    @Basic
    @Column(name = "created_at", nullable = true)
    private Date createdAt;

    @Basic
    @Column(name = "conversation_name", nullable = true, length = 45)
    private String conversationName;

    @Basic
    @Column(name = "is_private", nullable = true)
    private Boolean isPrivate;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "conversation_author")
    private UserEntity author;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinTable(
            name = "users_conversations",
            joinColumns = @JoinColumn(name = "conversations_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private List<UserEntity> usersIn;

    @OneToMany(mappedBy ="conversationIn", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MessageEntity> messages;

    public ConversationEntity() {
        this.setCreatedAt(new Date(Calendar.getInstance().getTime().getTime()));
        this.setPrivate(false);
        this.setUsersIn(new LinkedList<UserEntity>());
    }

    public ConversationEntity(String conversationName, Boolean isPrivate) {
        this.conversationName = conversationName;
        this.isPrivate = isPrivate;

        // Initialise the date and the author inside
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

    public String getConversationName() {
        return conversationName;
    }

    public void setConversationName(String conversationName) {
        this.conversationName = conversationName;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public List<UserEntity> getUsersIn() {
        return usersIn;
    }

    public void setUsersIn(List<UserEntity> usersIn) {
        this.usersIn = usersIn;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

    public void addUser(UserEntity user) {
        if (usersIn == null) {
            usersIn = new LinkedList<>();
        }

        usersIn.add(user);
    }

    public void addMessage(MessageEntity message) {
        if (messages == null) {
            messages = new LinkedList<>();
        }

        messages.add(message);
    }

    @Override
    public String toString() {
        return "ConversationEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", conversationName='" + conversationName + '\'' +
                ", isPrivate=" + isPrivate +
                ", author=" + author +
                ", usersIn=" + usersIn +
                ", messages=" + messages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConversationEntity that = (ConversationEntity) o;
        return id == that.id &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(conversationName, that.conversationName) &&
                Objects.equals(isPrivate, that.isPrivate) &&
                Objects.equals(author, that.author) &&
                Objects.equals(usersIn, that.usersIn) &&
                Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, conversationName, isPrivate, author, usersIn, messages);
    }
}
