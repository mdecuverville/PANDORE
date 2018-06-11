package isep.project.web.entity;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by owner on 18-05-07.
 */
@Entity
@Table(name = "users", schema = "heroku_9efd0238a94d992")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int id;

    @Basic
    @Column(name = "first_name", nullable = false, length = 75)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 75)
    private String lastName;

    @Basic
    @Column(name = "Password_hash", nullable = false, length = 100)
    private String passwordHash;

    @Basic
    @Column(name = "email", nullable = false, length = 75)
    private String email;

    @Basic
    @Column(name = "role", nullable = false, length = 75)
    private String role;

    @OneToMany(mappedBy ="author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ConversationEntity> conversationsOwned;

    @OneToMany(mappedBy ="likedBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LikeEntity> likes;

    @OneToMany(mappedBy ="createdBy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MessageEntity> messages;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinTable(
            name = "users_conversations",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "conversations_id")
    )
    private List<ConversationEntity> conversationsJoined;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinTable(
            name = "users_groups_users",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "users_groups_id")
    )
    private List<UserGroupEntity> usersGroups;

    public UserEntity() {
        this.setConversationsJoined(new LinkedList<ConversationEntity>());
        this.setConversationsOwned(new LinkedList<ConversationEntity>());
        this.setLikes(new LinkedList<LikeEntity>());
        this.setMessages(new LinkedList<MessageEntity>());
        this.setUsersGroups(new LinkedList<UserGroupEntity>());
    }

    public UserEntity(String firstName, String lastName, String passwordHash, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<ConversationEntity> getConversationsOwned() {
        return conversationsOwned;
    }

    public void setConversationsOwned(List<ConversationEntity> conversationsOwned) {
        this.conversationsOwned = conversationsOwned;
    }

    public List<LikeEntity> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeEntity> likes) {
        this.likes = likes;
    }

    public List<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageEntity> messages) {
        this.messages = messages;
    }

    public List<ConversationEntity> getConversationsJoined() {
        return conversationsJoined;
    }

    public void setConversationsJoined(List<ConversationEntity> conversationsJoined) {
        this.conversationsJoined = conversationsJoined;
    }

    public List<UserGroupEntity> getUsersGroups() {
        return usersGroups;
    }

    public void setUsersGroups(List<UserGroupEntity> usersGroups) {
        this.usersGroups = usersGroups;
    }


    public void addUserGroup(UserGroupEntity userGroup) {
        if (usersGroups == null) {
            usersGroups = new LinkedList<>();
        }

        usersGroups.add(userGroup);
    }

    public void addConversationOwned(ConversationEntity conversation) {
        if (conversationsOwned == null) {
            conversationsOwned = new LinkedList<>();
        }

        conversationsOwned.add(conversation);
    }

    public void addConversationJoined(ConversationEntity conversation) {
        if (conversationsJoined == null) {
            conversationsJoined = new LinkedList<>();
        }

        conversationsJoined.add(conversation);
    }

    public void addMessage(MessageEntity message) {
        if (messages == null) {
            messages = new LinkedList<>();
        }

        messages.add(message);
    }

    public void addLike(LikeEntity like) {
        if (likes == null) {
            likes = new LinkedList<>();
        }

        likes.add(like);
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", conversationsOwned=" + conversationsOwned +
                ", likes=" + likes +
                ", messages=" + messages +
                ", conversationsJoined=" + conversationsJoined +
                ", usersGroups=" + usersGroups +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(passwordHash, that.passwordHash) &&
                Objects.equals(email, that.email) &&
                Objects.equals(role, that.role) &&
                Objects.equals(conversationsOwned, that.conversationsOwned) &&
                Objects.equals(likes, that.likes) &&
                Objects.equals(messages, that.messages) &&
                Objects.equals(conversationsJoined, that.conversationsJoined) &&
                Objects.equals(usersGroups, that.usersGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, passwordHash, email, role, conversationsOwned, likes, messages, conversationsJoined, usersGroups);
    }

    public static String getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }

        return null;
    }
}
