package isep.project.web.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by owner on 18-05-07.
 */
@Entity
@Table(name = "users_groups", schema = "heroku_9efd0238a94d992")
public class UserGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", nullable = false)
    private int id;

    @Basic
    @Column(name = "user_group_name", nullable = true, length = 45)
    private String userGroupName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinTable(
            name = "users_groups_categories",
            joinColumns = @JoinColumn(name = "users_groups_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id")
    )
    private List<CategoryEntity> categories;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH,
    })
    @JoinTable(
            name = "users_groups_users",
            joinColumns = @JoinColumn(name = "users_groups_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    private List<UserEntity> users;

    public UserGroupEntity() {
        this.setCategories(new LinkedList<CategoryEntity>());
        this.setUsers(new LinkedList<UserEntity>());
    }

    public UserGroupEntity(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public void addCategory(CategoryEntity category) {
        if (categories == null) {
            categories = new LinkedList<>();
        }

        categories.add(category);
    }

    public void addUser(UserEntity user) {
        if (users == null) {
            users = new LinkedList<>();
        }

        users.add(user);
    }

    @Override
    public String toString() {
        return "UserGroupEntity{" +
                "id=" + id +
                ", userGroupName='" + userGroupName + '\'' +
                ", categories=" + categories +
                ", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroupEntity that = (UserGroupEntity) o;
        return id == that.id &&
                Objects.equals(userGroupName, that.userGroupName) &&
                Objects.equals(categories, that.categories) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userGroupName, categories, users);
    }
}
