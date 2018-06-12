package isep.project.web.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by owner on 18-05-07.
 */
@Entity
@Table(name = "likes", schema = "heroku_9efd0238a94d992")
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id", nullable = false)
    private int id;

    @Basic
    @Column(name = "is_dislike", nullable = true)
    private Boolean isDislike;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "liked_by")
    private UserEntity likedBy;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "liked_message")
    private MessageEntity likedMessage;

    public LikeEntity() {
        this.setDislike(false);
    }

    public LikeEntity(Boolean isDislike, MessageEntity likedMessage) {
        this.isDislike = isDislike;
        this.likedMessage = likedMessage;
    }

    public LikeEntity(boolean isDislike, MessageEntity message, UserEntity user) {
        this.isDislike = isDislike;
        this.likedMessage = message;
        this.likedBy = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getDislike() {
        return isDislike;
    }

    public void setDislike(Boolean dislike) {
        isDislike = dislike;
    }

    public UserEntity getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(UserEntity likedBy) {
        this.likedBy = likedBy;
    }

    public MessageEntity getLikedMessage() {
        return likedMessage;
    }

    public void setLikedMessage(MessageEntity likedMessage) {
        this.likedMessage = likedMessage;
    }



    @Override
    public String toString() {
        return "LikeEntity{" +
                "id=" + id +
                ", isDislike=" + isDislike +
                ", likedBy=" + likedBy +
                ", likedMessage=" + likedMessage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeEntity that = (LikeEntity) o;
        return id == that.id &&
                Objects.equals(isDislike, that.isDislike) &&
                Objects.equals(likedBy, that.likedBy) &&
                Objects.equals(likedMessage, that.likedMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isDislike, likedBy, likedMessage);
    }
}
